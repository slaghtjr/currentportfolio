import java.util.ArrayList;

//Generics is basic plural class of Generics, it contains an ArrayList of Generic
public class Generics {
	private ArrayList<Generic> genericList = new ArrayList<>();

	//The constructor loads pre-existing Generics into the array list from a text file
	public Generics() {
		DataFileLoader aFileLoader = new DataFileLoader();
		try {
			genericList = aFileLoader.getGenerics();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void add(String genericId, String genericName,
			String unitOfMeasurement, Boolean genericsAvailable) {

		this.remove(genericName);
		genericList.add(new Generic());
	}

	public void remove(String medicationName) {
		int i = genericList.size() - 1;
		while (i >= 0) {
			if (genericList.get(i).getMedicationName().equals(medicationName)) {
				genericList.remove(i);
			}
			i--;
		}
	}

	public String getId(int i) {
		return genericList.get(i).getMedicationId();
	}

	public Generic getGeneric(int i) {
		return genericList.get(i);
	}

	public boolean contains(String medicationName) {

		boolean isContained = false;

		for (Generic aMed : genericList) {
			if (aMed.getMedicationName().equals(medicationName)) {
				isContained = true;
			}
		}
		return isContained;
	}

	public int size() {

		return genericList.size();
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
		for (Generic aMed : genericList) {
			aString = aString + aMed.toString();
		}
		return aString;
	}
}
