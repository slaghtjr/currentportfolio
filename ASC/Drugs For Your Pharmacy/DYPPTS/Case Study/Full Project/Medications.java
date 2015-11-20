import java.util.ArrayList;

public class Medications {
	private ArrayList<Medication> medicationList = new ArrayList<Medication>();

	
	//This is the default Constructor
	public Medications() {

	}

	public Medications(Generics generics) {
		DataFileLoader aFileLoader = new DataFileLoader();
		try {
			medicationList = aFileLoader.getMedications(generics);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Adds a new medication to the list. 
	//If the medication allready exists the old one will be deleted.
	public void add(String medicationId, String medicationName,
			String unitOfMeasurement, ArrayList<SideEffects> sideEffectsList,
			Boolean genericsAvailable) {

		this.remove(medicationName);
		medicationList.add(new Medication(medicationId, medicationName,
				unitOfMeasurement, sideEffectsList, genericsAvailable));
	}

	
	//Removes medication if the medication name submited equals another name in the
	//list.
	public void remove(String medicationName) {
		int i = medicationList.size() - 1;
		while (i >= 0) {
			if (medicationList.get(i).getMedicationName()
					.equals(medicationName)) {
				medicationList.remove(i);
			}
			i--;
		}
	}

	//Returns true if medication name is in the list otherwise false.
	public boolean contains(String medicationName) {

		boolean isContained = false;

		for (Medication aMed : medicationList) {
			if (aMed.getMedicationName().equals(medicationName)) {
				isContained = true;
			}
		}
		return isContained;
	}

	public ArrayList<Medication> getMedications() {
		return medicationList;
	}

	public int size() {

		return medicationList.size();
	}

	public boolean isValid() {
		if (this.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		String aString = "";
		for (Medication aMed : medicationList) {
			aString = aString + aMed.toString();
		}
		return aString;
	}
}
