//The purpose of the Main GUI is to act as the Main menu for the program.  
//On the Main GUI, the user will see 3 different menu items.  
//The graphical representation of the buttons that will show up on the display (Graphical User Interface) are ”Add Customer”, “View Customer”, and “View Inventory”.
//These menu items are what the Pharmacist will see when he/she first accesses the software. 

//The “Add Customer” will route the user to the “Add Customer GUI” through the GUI Controller, where there will be fields for the pharmacist to enter into the database. 

//The “View Customer” will route the user to the “View Customer GUI” through the GUI Controller, where there will be a search query to locate the customer.

//The “View Inventory” will route the user to the “Inventory GUI” through the GUI Controller.  
//Once there, another menu displays options under that menu.


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class MainGUI extends JFrame {
	private JPanel buttons = new JPanel();
	private JButton exit = new JButton("Exit");
	private JButton addCust = new JButton("Add Customer");
	private JButton viewCust = new JButton("View Customers");
	private JButton invMenu = new JButton("View Inventory");
	private GUIController control;
	//The above code is the graphic representation of the buttons that
	// will show up on the display (Graphical User Interface).  
	//This is what the Pharmacist will see when adding information into
	// the database.  As can be seen above, the user has the options of
	// “Adding Customer”, “View Customer”, and “View Inventory”.

	public MainGUI() {
		createButtons();
		createPanel();
		add(buttons);
		setSize(300, 300);
		setUndecorated(true);
	}
	//The above code is formatting the GUI appearance, including the size and the panel to add the buttons.

	public MainGUI(GUIController gc) {
		this();
		control = gc;
	}
	//The above code is a constructor for the GUI Controller.

	private void createPanel() {
		buttons.setLayout(new GridLayout(4, 1, 0, 0));
		buttons.add(addCust);
		buttons.add(viewCust);
		buttons.add(invMenu);
		buttons.add(exit);
	}
	//The above code creates the panel, and assigns each button the class to be accessed.

	private void createButtons() {
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				control.setRun(false);
			}
		}); 
		// Adds the exit button's actionListener

		addCust.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				control.setMainRun(false);
				control.setAddRun(true);
			}
		}); 
		// Adds the add button's actionListener
		
		viewCust.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				control.setMainRun(false);
				control.setSearchCustRun(true);
			}
		});
		// Adds the view button's actionListener

		invMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				control.setMainRun(false);
				control.setInvRun(true);
			}
		}); 
		// Adds the inventory button's actionListener

	}

}
