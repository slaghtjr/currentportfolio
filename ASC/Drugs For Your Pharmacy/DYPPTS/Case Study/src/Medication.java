//The medication class is a blueprint for every medication that is put into the system. 
//It holds the name of the medication, the units of measurement, possible side effects, and also if there is a generic substitute available for the medication.

import java.util.ArrayList;

public class Medication implements Drug {

	private String medicationId;
	private String medicationName;
	private String unitOfMeasurement;
	private ArrayList<SideEffects> sideEffectsList = new ArrayList<SideEffects>();

	private Boolean genericsAvailable;
	private ArrayList<Generic> genericList = new ArrayList<Generic>();

	public void setGenericsAvailable(Boolean aGenericsAvailable) {
		this.genericsAvailable = aGenericsAvailable;
	}

	public Boolean getGenericsAvailable() {
		return genericsAvailable;
	}

	public Medication() {
		// this is the empty constructor
	}

	public Medication(String aMedicationId, String aMedicationName,
			String aUnitOfMeasurement, ArrayList<SideEffects> aSideEffectsList,
			Boolean aGenericsAvailable) {
		super();
		this.medicationId = aMedicationId;
		this.medicationName = aMedicationName;
		this.unitOfMeasurement = aUnitOfMeasurement;
		this.sideEffectsList = aSideEffectsList;
		this.genericsAvailable = aGenericsAvailable;
	}

	@Override
	public void setMedicationId(String aMedicationId) {
		this.medicationId = aMedicationId;

	}

	@Override
	public void setMedicationName(String aMedicationName) {
		this.medicationName = aMedicationName;

	}

	@Override
	public void setUnitOfMeasurement(String aUnitOfMeasurement) {
		this.unitOfMeasurement = aUnitOfMeasurement;

	}

	@Override
	public void setSideEffectsList(ArrayList<SideEffects> aSideEffectList) {
		this.sideEffectsList = aSideEffectList;

	}

	public void setGeneric(ArrayList<Generic> aGeneric) {
		this.genericList = aGeneric;
	}

	@Override
	public String getMedicationId() {
		return this.medicationId;
	}

	@Override
	public String getMedicationName() {
		return this.medicationName;
	}

	@Override
	public String getUnitPrescribed() {
		return this.unitOfMeasurement;
	}

	@Override
	public ArrayList<SideEffects> getSideEffectsList() {
		return this.sideEffectsList;
	}

	public ArrayList<Generic> getGeneric() {
		return this.genericList;
	}

	public void addSideEffects(SideEffects aSideEffect) {
		sideEffectsList.add(aSideEffect);
	}

	public void addGeneric(Generic aGeneric) {
		genericList.add(aGeneric);
	}

	@Override
	public String toString() {
		String aString = "";
		aString = aString + "Medication Id: " + this.getMedicationId() + "\n";
		aString = aString + "Medication Name: " + this.getMedicationName()
				+ "\n";
		aString = aString + "Unit of Measurement: " + this.getUnitPrescribed()
				+ "\n";
		aString = aString + "Side Effects: \n";
		for (int i = 0; i < sideEffectsList.size(); i++) {
			aString = aString + "\t" + sideEffectsList.get(i) + "\n";
		}
		aString = aString + "Generics Available: "
				+ this.getGenericsAvailable() + "\n";
		if (genericsAvailable) {
			aString = aString + "Generic: \n";
			aString = aString + genericList.size() + "\n";
			for (int i = 0; i < genericList.size(); i++) {
				aString = aString + "\t" + genericList.get(i) + "\n";
			}
		}
		aString = aString + "\n";
		return aString;
	}

}
