public class GUIController {
	//Creates the GUIs for the PTS

	private MainGUI main;
	private AddCustomerGUI addCust;
	private ViewCustomerGUI viewCust;
	private NewScriptGUI newScript;
	private SearchCustGUI searchCust;
	private ScriptHistoryGUI scriptHistory;
	private InventoryGUI inventory;

	//The following booleans are the toggles for displaying and running of the guis

	private boolean refillRun = false;
	private boolean invRun = false;
	private boolean run = true;
	private boolean addRun = false;
	private boolean viewRun = false;
	private boolean mainRun = true;
	private boolean newScriptRun = false;
	private boolean searchCustRun = false;
	private boolean scriptHistoryRun = false;

	//Creates the needed plural variables for the program: Customers, Prescriptions, and Medications

	private Customers customers;
	private Prescriptions prescriptions;

	private Medications medications;

	public GUIController() {
		main = new MainGUI(this);
		addCust = new AddCustomerGUI(this);
		viewCust = new ViewCustomerGUI(this);
		searchCust = new SearchCustGUI(this);
		scriptHistory = new ScriptHistoryGUI(this);
		inventory = new InventoryGUI(this);
	}

	public GUIController(Customers c, Prescriptions p, Medications m) {
		this();
		customers = c;
		prescriptions = p;
		medications = m;
		newScript = new NewScriptGUI(this);
		updatePrescriptionHistory();
	}

	//The updatePrescriptionHistory updates each customer's prescription
	private void updatePrescriptionHistory() {

		for (int i = 0; i < customers.size(); i++) {
			for (int k = 0; k < prescriptions.size(); k++) {
				if (customers.getCustomerId(i).equals(
						prescriptions.getCustomerId(k))) {
					customers.getCustomer(i).setPrescriptionHistoryList(
							prescriptions.getPrescription(k));
				}
			}
		}

	}

	public boolean getRun() {
		return run;
	}

	public void setRun(boolean r) {
		run = r;
	}

	public Customers getCustomers() {
		return customers;
	}

	public Prescriptions getPrescriptions() {
		return prescriptions;
	}
	
	//adds a Customer to the Customers list
	public void addCustomers(String id, String ln, String fn, String phone,
			String dob, String ins, String policy) {
		customers.add(id, ln, fn, phone, dob, ins, policy);
	}
	
	//Adds a Script to the list of Prescriptions
	public void addPrescriptions(String prescriptionId, String customerId,
			String medicationName, String physicianName, String physicianPhone,
			String dateOfIssue, String expirationDate, int numberRefills,
			int unitsPerRefill, Boolean generic) {
		prescriptions.add(prescriptionId, customerId, medicationName,
				physicianName, physicianPhone, dateOfIssue, expirationDate,
				numberRefills, unitsPerRefill, generic);
		System.out.println(prescriptions.toString());
	}

	//The saveCustomers() method calls the save function for the customers at one time to allow for safe usage
	
	public void saveCustomers() {
		customers.save();
	}

	public boolean getNewScriptRun() {
		return newScriptRun;
	}

	public void setNewScriptRun(boolean r) {
		newScriptRun = r;
		if (r == false) {
			newScript.setVisible(false);
		}
	}

	public boolean getInvRun() {
		return invRun;
	}

	public void setInvRun(boolean r) {
		invRun = r;
		if (r == false) {
			inventory.setVisible(false);
		}
	}

	public boolean getRefillRun() {
		return refillRun;
	}

	public boolean getSearchCustRun() {
		return newScriptRun;
	}

	public void setSearchCustRun(boolean r) {
		searchCustRun = r;
		if (r == false) {
			searchCust.setVisible(false);
		}
	}

	public boolean getMainRun() {
		return mainRun;
	}

	public void setMainRun(boolean r) {
		mainRun = r;
		if (r == false) {
			main.setVisible(false);
		}
	}

	public boolean getAddRun() {
		return addRun;
	}

	public void setAddRun(boolean r) {
		addRun = r;
		if (r == false) {
			addCust.setVisible(false);
		}
	}

	public boolean getViewRun() {
		return viewRun;
	}

	public void setViewRun(boolean r) {
		viewRun = r;
		if (r == false) {
			viewCust.setVisible(false);
		}
	}

	//setScriptOwner() gives the newScript GUI the proper customer of a script
	public void setScriptOwner(Customer c) {
		newScript.scriptOwner(c);
	}

	public void setViewRun(boolean r, Customer c) {
		viewRun = r;
		viewCust.display(c);
		if (r == false) {
			viewCust.setVisible(false);
		}
	}

	public boolean getHistoryRun() {
		return newScriptRun;
	}

	public void setHistoryRun(boolean r) {
		scriptHistoryRun = r;
		if (r == false) {
			scriptHistory.setVisible(false);
		}
	}

	public void setHistoryDisplay(Customer c) {
		Customer cust = c;
		scriptHistory.displayHistory(cust);
	}

	public Medications getMedications() {
		return medications;
	}

	//run() is called at start and calls a second method, run can be scaled	
	public void run() {
		checkVisibility();
	}

	//the checkVisibility() method is just a large if-else statement that checks which
	//GUI is active
	public void checkVisibility() {
		if (searchCustRun == true) {
			searchCust.setVisible(true);
		}
		else if (viewRun == true) {
			viewCust.setVisible(true);
		} else if (addRun == true) {
			addCust.setVisible(true);
		} else if (mainRun == true) {
			main.setVisible(true);
		} else if (newScriptRun == true) {
			newScript.setVisible(true);
		} else if (scriptHistoryRun == true) {
			scriptHistory.setVisible(true);
		} else if (invRun == true) {
			inventory.setVisible(true);
		}
	}

}
