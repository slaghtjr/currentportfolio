public class Prescription {

	private String prescriptionId = "N/A";
	private String customerId = "N/A";
	private String medicationName = "N/A";
	private String physicianName = "N/A";
	private String physicianPhone = "N/A";
	private String dateOfIssue = "N/A";
	private String expirationDate = "N/A";
	private int numberRefills = 0;
	private int unitsPerRefill = 0;
	private Boolean generic;

	public void setPrescriptionId(String aprescriptionId) {
		this.prescriptionId = aprescriptionId;
	}

	public void setCustomerId(String aCustomerId) {
		this.customerId = aCustomerId;
	}

	public void setMedicationName(String aMedicationName) {
		this.medicationName = aMedicationName;
	}

	public void setPhysicianName(String aPhysicianName) {
		this.physicianName = aPhysicianName;
	}

	public void setPhysicianPhone(String aPhysicianPhone) {
		this.physicianPhone = aPhysicianPhone;
	}

	public void setDateOfIssue(String aDateOfIssue) {
		this.dateOfIssue = aDateOfIssue;
	}

	public void setExpirationDate(String aExpirationDate) {
		this.expirationDate = aExpirationDate;
	}

	public void setNumberRefills(int aNumberRefills) {
		this.numberRefills = aNumberRefills;
	}

	public void setUnitsPerRefill(int aUnitsPerRefill) {
		this.unitsPerRefill = aUnitsPerRefill;
	}

	public void setGeneric(Boolean aGeneric) {
		this.generic = aGeneric;
	}

	public String getPrescriptionId() {
		return prescriptionId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public String getMedicationName() {
		return medicationName;
	}

	public String getPhysicianName() {
		return physicianName;
	}

	public String getPhysicianPhone() {
		return physicianPhone;
	}

	public String getDateOfIssue() {
		return dateOfIssue;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public int getNumberRefills() {
		return numberRefills;
	}

	public int getUnitsPerRefill() {
		return unitsPerRefill;
	}

	public Boolean getGeneric() {
		return generic;
	}

	public Prescription() {
		// this is the empty constructor
	}

	public Prescription(String prescriptionId, String customerId,
			String medicationName, String physicianName, String physicianPhone,
			String dateOfIssue, String expirationDate, int numberRefills,
			int unitsPerRefill, boolean generic) {

		this.prescriptionId = prescriptionId;
		this.customerId = customerId;
		this.medicationName = medicationName;
		this.physicianName = physicianName;
		this.physicianPhone = physicianPhone;
		this.dateOfIssue = dateOfIssue;
		this.expirationDate = expirationDate;
		this.numberRefills = numberRefills;
		this.unitsPerRefill = unitsPerRefill;
		this.generic = generic;

	}

	public String toString() {
		String aString = "\n\n";
		aString = aString + "Prescription Id: " + this.getPrescriptionId()
				+ "\n";
		aString = aString + "Customer Id: " + this.getCustomerId() + "\n";
		aString = aString + "Medication Name: " + this.getMedicationName()
				+ "\n";
		aString = aString + "Physician Name: " + this.getPhysicianName() + "\n";
		aString = aString + "Physician Phone: " + this.getPhysicianPhone()
				+ "\n";
		aString = aString + "Date Of Issue: " + this.getDateOfIssue() + "\n";
		aString = aString + "Expiration Date: " + this.getExpirationDate()
				+ "\n";
		aString = aString + "Number Refills: " + this.getNumberRefills() + "\n";
		aString = aString + "Units Per Refill: " + this.getNumberRefills()
				+ "\n";
		aString = aString + "Generic: " + this.getGeneric() + "\n";
		return aString;
	}
}
