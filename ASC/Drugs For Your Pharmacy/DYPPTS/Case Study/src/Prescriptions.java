import java.util.ArrayList;

public class Prescriptions {

	private ArrayList<Prescription> prescriptionList = new ArrayList<Prescription>();

	public Prescriptions() {
		DataFileLoader aFileLoader = new DataFileLoader();

		try {
			prescriptionList = aFileLoader.getPrescriptions();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void save() {
		DataFileLoader aFileLoader = new DataFileLoader();
		try {
			aFileLoader.savePrescriptions(prescriptionList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Returns customer Id at given array index.
	public String getCustomerId(int k) {
		return prescriptionList.get(k).getCustomerId();
	}

	//Returns Prescription at given array index.
	public Prescription getPrescription(int k) {
		return prescriptionList.get(k);
	}
 
	//Adds a new prescription. If The prescription exists already it will remove
	//the old prescription and then adds the new one.
	public void add(String prescriptionId, String customerId,
			String medicationName, String physicianName, String physicianPhone,
			String dateOfIssue, String expirationDate, int numberRefills,
			int unitsPerRefill, Boolean generic) {

		this.remove(prescriptionId);
		prescriptionList.add(new Prescription(prescriptionId, customerId,
				medicationName, physicianName, physicianPhone, dateOfIssue,
				expirationDate, numberRefills, unitsPerRefill, generic));
	}

	public void remove(String prescriptionId) {
		int i = prescriptionList.size() - 1;
		while (i >= 0) {
			if (prescriptionList.get(i).getPrescriptionId()
					.equals(prescriptionId)) {
				prescriptionList.remove(i);
			}
			i--;
		}
	}

	public boolean contains(String medicationName) {

		boolean isContained = false;

		for (Prescription aMed : prescriptionList) {
			if (aMed.getMedicationName().equals(medicationName)) {
				isContained = true;
			}
		}
		return isContained;
	}

	public int size() {

		return prescriptionList.size();
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
		for (Prescription aMed : prescriptionList) {
			aString = aString + aMed.toString();
		}
		return aString;
	}
}
