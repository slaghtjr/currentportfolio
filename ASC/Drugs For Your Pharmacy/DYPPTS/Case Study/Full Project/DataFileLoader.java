//Reads a Comma Separated Value file and copies its contents to an array.
//Saves the the array the file.

import java.io.*;
import java.util.*;

public class DataFileLoader {

	// This needs to be changed depending on who's running it and where they
	// have the file saved
	String file = "C:\\Users\\Administrator\\Dropbox\\Case Study\\";

	public ArrayList<Customer> getCustomers() throws Exception {

		BufferedReader customerFile = new BufferedReader(new FileReader(file
				+ "Customer.txt"));
		ArrayList<Customer> customers = new ArrayList<Customer>();
		Customer aCustomer;
		String dataRow = customerFile.readLine(); // Read first line.

		// The while checks to see if the data is null. If
		// it is, we've hit the end of the file. If not,
		// process the data.

		while (dataRow != null) {

			String[] dataArray = dataRow.split("\t");
			aCustomer = new Customer();
			aCustomer.setCustomerId(dataArray[0]);
			aCustomer.setFirstName(dataArray[1]);
			aCustomer.setLastName(dataArray[2]);
			aCustomer.setTelephoneNumber(dataArray[3]);
			aCustomer.setDateOfBirth(dataArray[4]);
			aCustomer.setInsuranceProvider(dataArray[5]);
			aCustomer.setPolicyNumber(dataArray[6]);
			customers.add(aCustomer);
			dataRow = customerFile.readLine(); // Read next line of data.
		}
		// Reads the next line of data.

		// Close the file once all data has been read.
		customerFile.close();

		return customers;

	}

	public void saveCustomers(ArrayList<Customer> aCustomers) throws Exception {

		BufferedWriter customerFile = new BufferedWriter(new FileWriter(file
				+ "Customer.txt"));
		ArrayList<Customer> customers = aCustomers;

		for (Customer customer : customers) {

			String customerStr = "";
			customerStr = customer.getCustomerId() + "\t"
					+ customer.getFirstName() + "\t" + customer.getLastName()
					+ "\t" + customer.getTelephoneNumber() + "\t"
					+ customer.getDateOfBirth() + "\t"
					+ customer.getInsuranceProvider() + "\t"
					+ customer.getPolicyNumber();

			customerFile.write(customerStr);
			customerFile.newLine();
		}

		// Close the file once all data has been read.
		customerFile.close();

	}

	public ArrayList<Prescription> getPrescriptions() throws Exception {

		BufferedReader prescriptionFile = new BufferedReader(new FileReader(
				file + "Presciption.txt"));
		ArrayList<Prescription> prescriptions = new ArrayList<Prescription>();
		Prescription aPrescription;
		String dataRow = prescriptionFile.readLine(); // Read first line.

		// The while checks to see if the data is null. If
		// it is, we've hit the end of the file. If not,
		// process the data.

		while (dataRow != null) {

			String[] dataArray = dataRow.split("\t");
			aPrescription = new Prescription();
			aPrescription.setPrescriptionId(dataArray[0]);
			aPrescription.setCustomerId(dataArray[1]);
			aPrescription.setMedicationName(dataArray[2]);
			aPrescription.setPhysicianName(dataArray[3]);
			aPrescription.setPhysicianPhone(dataArray[4]);
			aPrescription.setDateOfIssue(dataArray[5]);
			aPrescription.setExpirationDate(dataArray[6]);
			aPrescription.setNumberRefills(Integer.parseInt(dataArray[7]));
			aPrescription.setUnitsPerRefill(Integer.parseInt(dataArray[8]));
			aPrescription.setGeneric(Boolean.parseBoolean(dataArray[9]));
			prescriptions.add(aPrescription);
			dataRow = prescriptionFile.readLine(); // Read next line of data.

		}
		
		// Close the file once all data has been read.
		prescriptionFile.close();

		return prescriptions;

	}

	public ArrayList<Generic> getGenerics() throws Exception {

		BufferedReader genericFile = new BufferedReader(new FileReader(file
				+ "Generic.txt"));
		ArrayList<Generic> generics = new ArrayList<Generic>();
		Generic aGeneric;
		String dataRow = genericFile.readLine();

		while (dataRow != null) {
			String[] dataArray = dataRow.split("\t");
			aGeneric = new Generic();
			aGeneric.setMedicationId(dataArray[0]);
			aGeneric.setMedicationName(dataArray[1]);
			aGeneric.setUnitOfMeasurement(dataArray[2]);
			for (int i = 3; i < dataArray.length; i++) {
				aGeneric.addSideEffects(SideEffects.valueOf(dataArray[i]));
			}
			generics.add(aGeneric);
			dataRow = genericFile.readLine();
		}

		genericFile.close();

		return generics;
	}

	public ArrayList<Medication> getMedications(Generics generics)
			throws Exception {

		BufferedReader medicationFile = new BufferedReader(new FileReader(file
				+ "Medication.txt"));
		ArrayList<Medication> medications = new ArrayList<Medication>();
		Medication aMedication;
		String dataRow = medicationFile.readLine(); // Read first line.

		// The while checks to see if the data is null. If
		// it is, we've hit the end of the file. If not,
		// process the data.

		while (dataRow != null) {

			String[] dataArray = dataRow.split("\t");
			aMedication = new Medication();
			aMedication.setMedicationId(dataArray[0]);
			aMedication.setMedicationName(dataArray[1]);
			aMedication.setUnitOfMeasurement(dataArray[2]);
			aMedication
					.setGenericsAvailable(Boolean.parseBoolean(dataArray[3]));
			if (aMedication.getGenericsAvailable()) {
				String[] genericsString = dataArray[4].split("|");
				for (int x = 0; x < genericsString.length;) {
					for (int k = 0; k < generics.size(); k++) {
						if (generics.getId(k).equals(genericsString[x])) {
							aMedication.addGeneric(generics.getGeneric(k));
						}
					}
					x++;
				}
				for (int i = 5; i < dataArray.length; i++) {
					aMedication.addSideEffects(SideEffects
							.valueOf(dataArray[i]));
				}
			} else {
				for (int i = 4; i < dataArray.length; i++) {
					aMedication.addSideEffects(SideEffects
							.valueOf(dataArray[i]));
				}
			}
			medications.add(aMedication);
			dataRow = medicationFile.readLine(); // Read next line of data.

		}

		// Close the file once all data has been read.
		medicationFile.close();

		return medications;

	}

	public void savePrescriptions(ArrayList<Prescription> aPrescriptions)
			throws Exception {
		BufferedWriter prescriptionFile = new BufferedWriter(new FileWriter(
				file + "Presciption.txt"));
		ArrayList<Prescription> prescriptions = aPrescriptions;

		for (Prescription prescription : prescriptions) {

			String prescriptionStr = "";
			prescriptionStr = prescription.getPrescriptionId() + "\t"
					+ prescription.getCustomerId() + "\t"
					+ prescription.getMedicationName() + "\t"
					+ prescription.getPhysicianName() + "\t"
					+ prescription.getPhysicianPhone() + "\t"
					+ prescription.getDateOfIssue() + "\t"
					+ prescription.getExpirationDate() + "\t"
					+ prescription.getNumberRefills() + "\t"
					+ prescription.getUnitsPerRefill() + "\t"
					+ prescription.getGeneric();

			prescriptionFile.write(prescriptionStr);
			prescriptionFile.newLine();
		}

		// Close the file once all data has been read.
		prescriptionFile.close();

	}
}