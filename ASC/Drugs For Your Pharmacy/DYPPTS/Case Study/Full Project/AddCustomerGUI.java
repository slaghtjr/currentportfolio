import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

@SuppressWarnings("serial")
public class AddCustomerGUI extends JFrame {

	private JPanel custInfo = new JPanel();
	private JPanel buttons = new JPanel();
	private JButton add = new JButton("Add Customer");
	private JButton main = new JButton("Return to Main Menu");
	private JLabel custID;
	private JLabel fName;
	private JLabel lName;
	private JLabel telNumber;
	private JLabel dateOfBirth;
	private JLabel insProvider;
	private JLabel polNumber;
	private JTextField custIDText;
	private JTextField fNameText;
	private JTextField lNameText;
	private JTextField telNumberText;
	private JTextField dateOfBirthText;
	private JTextField insProviderText;
	private JTextField polNumberText;

	private GUIController control;

	public AddCustomerGUI() {
		super("Add Customer");
		createLabels();
		createTextFields();
		createButtons();
		createPanels();
		add(custInfo, BorderLayout.NORTH);
		add(buttons, BorderLayout.SOUTH);
		setSize(300, 300);
		setUndecorated(true);
	}
	//Initializing the GUI to Add Customers
	public AddCustomerGUI(GUIController gc) {
		this();
		control = gc;
	}
	//The above code retrieves information from the GUI Controller
	private void createLabels() {
		custID = new JLabel("Customer ID:");
		fName = new JLabel("First Name:");
		lName = new JLabel("Last Name:");
		telNumber = new JLabel("Telephone Number:");
		dateOfBirth = new JLabel("Date of Birth:");
		insProvider = new JLabel("Insurance Provider:");
		polNumber = new JLabel("Policy #:");
	}
	//The above code is Formatting the Labels for the GUI, labeling the fields.
	private void createTextFields() {
		custIDText = new JTextField();
		fNameText = new JTextField();
		lNameText = new JTextField();
		telNumberText = new JTextField();
		dateOfBirthText = new JTextField();
		insProviderText = new JTextField();
		polNumberText = new JTextField();

	}
	//The above code is formatting the variable text fields for input of data
	private void createButtons() {
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				if (custIDText.getText().equals("")
						| fNameText.getText().equals("")
						| lNameText.getText().equals("")
						| telNumberText.getText().equals("")
						| dateOfBirthText.getText().equals("")
						| insProviderText.getText().equals("")
						| polNumberText.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Invalid Customer Add, Please Try Again");
					clearForm();
				} else {
					control.addCustomers(custIDText.getText(),
							lNameText.getText(), fNameText.getText(),
							telNumberText.getText(), dateOfBirthText.getText(),
							insProviderText.getText(), polNumberText.getText());
					control.saveCustomers();
					control.setAddRun(false);
					control.setMainRun(true);
					clearForm();
				}
			}
		});
			//The IF STATEMENT is to check for missing data, all fields need to be filled out.  
			//	The above code is the failsafe check, if data is missing then an error will be 
			//returned, data will NOT be saved, and the user must start over
		
		// Adds the exit button's actionListener
		main.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				control.saveCustomers();
				control.setAddRun(false);
				control.setMainRun(true);
				clearForm();
			}
		}); // Adds the exit button's actionListener
	}

	private void createPanels() {
		custInfo.setLayout(new GridLayout(7, 1, 0, 0));
		custInfo.add(custID);
		custInfo.add(custIDText);
		custInfo.add(fName);
		custInfo.add(fNameText);
		custInfo.add(lName);
		custInfo.add(lNameText);
		custInfo.add(telNumber);
		custInfo.add(telNumberText);
		custInfo.add(dateOfBirth);
		custInfo.add(dateOfBirthText);
		custInfo.add(insProvider);
		custInfo.add(insProviderText);
		custInfo.add(polNumber);
		custInfo.add(polNumberText);

		buttons.add(add);
		buttons.add(main);
	}
	//The above code adds the variables to both the Customer and Customers Classes. 
	//Customer is the current customer information being entered into the system.  
	//Customers is the customer’s history, which is initialized on first entry.
	

	private void clearForm() {
		custIDText.setText("");
		fNameText.setText("");
		lNameText.setText("");
		telNumberText.setText("");
		dateOfBirthText.setText("");
		insProviderText.setText("");
		polNumberText.setText("");
	}
}
//The above code resets all variables of the customer table back to their default values