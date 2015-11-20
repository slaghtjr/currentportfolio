import java.util.ArrayList;

//The Generic Class is a single entity of a specific type of Drug
public class Generic implements Drug {

	private String medicationId;
	private String medicationName;
	private String unitOfMeasurement;
	private ArrayList<SideEffects> sideEffectsList = new ArrayList<SideEffects>();

	//All the @Override methods are methods from Drug that need to be called.
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
	public void setSideEffectsList(ArrayList<SideEffects> aSideEffectsList) {
		this.sideEffectsList = aSideEffectsList;

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

	public void addSideEffects(SideEffects aSideEffect) {
		sideEffectsList.add(aSideEffect);
	}

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
		return aString;
	}

}
