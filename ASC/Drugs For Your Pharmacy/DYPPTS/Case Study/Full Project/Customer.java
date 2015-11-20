import java.util.ArrayList;

public class Customer {

	private String customerId;
	private String lastName;
	private String firstName;
	private String telephoneNumber;
	private String dateOfBirth;
	private String insuranceProvider;
	private String policyNumber;
	private ArrayList<Prescription> prescriptionHistoryList = new ArrayList<Prescription>();

	public void setCustomerId(String aCustomerId) {
		this.customerId = aCustomerId;
	}

	public void setLastName(String aLastName) {
		this.lastName = aLastName;
	}

	public void setFirstName(String aFirstName) {
		this.firstName = aFirstName;
	}

	public void setTelephoneNumber(String aTelephoneNumber) {
		this.telephoneNumber = aTelephoneNumber;
	}

	public void setDateOfBirth(String aDateOfBirth) {
		this.dateOfBirth = aDateOfBirth;
	}

	public void setInsuranceProvider(String aInsuranceProvider) {
		this.insuranceProvider = aInsuranceProvider;
	}

	public void setPolicyNumber(String aPolicyNumber) {
		this.policyNumber = aPolicyNumber;
	}

	public void setPrescriptionHistoryList(Prescription aPrescription) {
		this.prescriptionHistoryList.add(aPrescription);
	}

	public String getCustomerId() {
		return customerId;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public String getInsuranceProvider() {
		return insuranceProvider;
	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public ArrayList<Prescription> getPrescriptionHistoryList() {
		return this.prescriptionHistoryList;
	}

	public Customer() {
		// this is the empty constructor
	}

	public Customer(String customerId, String lastName, String firstName,
			String telephoneNumber, String dateOfBirth,
			String insuranceProvider, String policyNumber) {
		this.customerId = customerId;
		this.lastName = lastName;
		this.firstName = firstName;
		this.telephoneNumber = telephoneNumber;
		this.dateOfBirth = dateOfBirth;
		this.insuranceProvider = insuranceProvider;
		this.policyNumber = policyNumber;

	}

	public void setCustomerInfo(String aCustomerId, String aLastName,
			String aFirstName, String aTelephoneNumber, String aDateOfBirth,
			String aInsuranceProvider, String aPolicyNumber) {
		if (aCustomerId != "" && aCustomerId != null) {
			this.setCustomerId(aCustomerId);
		}
		if (aLastName != "" && aLastName != null) {
			this.setLastName(aLastName);
		}
		if (aFirstName != "" && aFirstName != null) {
			this.setFirstName(aFirstName);
		}
		if (aTelephoneNumber != "" && aTelephoneNumber != null) {
			this.setTelephoneNumber(aTelephoneNumber);
		}
		if (aDateOfBirth != "" && aDateOfBirth != null) {
			this.setDateOfBirth(aDateOfBirth);
		}
		if (aInsuranceProvider != "" && aInsuranceProvider != null) {
			this.setInsuranceProvider(aInsuranceProvider);
		}
		if (aPolicyNumber != "" && aPolicyNumber != null) {
			this.setPolicyNumber(aPolicyNumber);
		}

	}

	public String toString() {
		String aString = "";
		aString = "Customer Id: " + this.getCustomerId() + "\n";
		aString = aString + "Last Name: " + this.getLastName() + "\n";
		aString = aString + "First Name: " + this.getFirstName() + "\n";
		aString = aString + "Telephone Number: " + this.getTelephoneNumber()
				+ "\n";
		aString = aString + "Date Of Birth: " + this.getDateOfBirth() + "\n";
		aString = aString + "Insurance Provider: "
				+ this.getInsuranceProvider() + "\n";
		aString = aString + "Policy Number: " + this.getPolicyNumber() + "\n";
		return aString;
	}
}
