import java.util.ArrayList;

public class Customers {
	private ArrayList<Customer> customerList;

	
	//Getting Customer information from the file
	public Customers() {
		DataFileLoader aFileLoader = new DataFileLoader();
		try {
			customerList = aFileLoader.getCustomers();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Saving Customer information to the file
	public void save() {
		DataFileLoader aFileLoader = new DataFileLoader();
		try {
			aFileLoader.saveCustomers(customerList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	//Getting a specific customer information
	public Customer getCustomer(String lastName, String firstName) {

		for (Customer aCustomer : customerList) {
			if (aCustomer.getLastName().equals(lastName)
					&& (aCustomer.getFirstName().equals(firstName))) {
				return aCustomer;
			}
		}
		return null;

	}

	public Customer getCustomer(int i) {
		return customerList.get(i);
	}

	public void add(String customerId, String lastName, String firstName,
			String telephoneNumber, String dateOfBirth,
			String insuranceProvider, String policyNumber) {

		this.remove(lastName, firstName);
		customerList.add(new Customer(customerId, lastName, firstName,
				telephoneNumber, dateOfBirth, insuranceProvider, policyNumber));
	}

	//Removing a customer 
	public void remove(String lastName, String firstName) {
		int i = customerList.size() - 1;
		while (i >= 0) {
			if (customerList.get(i).getLastName().equals(lastName)
					&& (customerList.get(i).getFirstName().equals(firstName))) {
				customerList.remove(i);
			}
			i--;
		}
	}

	public boolean contains(String lastName, String firstName) {

		boolean isContained = false;

		for (Customer aCustomer : customerList) {
			if (aCustomer.getLastName().equals(lastName)
					&& (aCustomer.getFirstName().equals(firstName))) {
				isContained = true;
			}
		}
		return isContained;
	}

	public int size() {

		return customerList.size();
	}

	public String getCustomerId(int i) {
		return customerList.get(i).getCustomerId();
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
		for (Customer aCustomer : customerList) {
			aString = aString + aCustomer.toString() + "\n";
		}
		return aString;
	}
}
