//The purpose of the “Inventory GUI” is to call up the medication that is carried by the pharmacy.
//Medication can be added to the database or viewed in this GUI.  
//The “Add Medication” feature will prompt the pharmacist to enter the Medication name, the Unit of Measurement, and possible Side Effects.  
//The user will also be asked if there is a generic available for the medication.  
//This information will be entered into the database.  
//The “View Inventory “ will allow the user to see what medications are carried by the pharmacy.


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class InventoryGUI extends JFrame {
	private JPanel buttons = new JPanel();
	private JButton main = new JButton("Return to Main");
	private JButton addMed = new JButton("Add Medication");
	private JButton viewInv = new JButton("View Inventory");
	private GUIController control;
	//The above code is formatting the GUI to “Return to Main Menu”, “Add Medication”, and to “View Inventory”.
	
	public InventoryGUI() {
		createButtons();
		createPanel();
		add(buttons);
		setSize(300, 300);
		setUndecorated(true);
	}

	public InventoryGUI(GUIController c) {
		this();
		control = c;
	}
	//The above code retrieves information from the GUI Controller.

	private void createPanel() {
		buttons.setLayout(new GridLayout(3, 1, 0, 0));
		buttons.add(addMed);
		buttons.add(viewInv);
		buttons.add(main);
	}
	//The above code is formatting the GUI to retrieve information.

	private void createButtons() {
		main.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				control.setInvRun(false);
				control.setMainRun(true);
			}
		}); 
		// Adds the exit button's actionListener

		addMed.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				JOptionPane.showMessageDialog(null,
						"Not currently functioning, select a differnt option.");
			}
		}); 
		// Adds the add button's actionListener
		
		viewInv.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				JOptionPane.showMessageDialog(null,
						"Not currently functioning, select a differnt option.");
			}
		}); 
		// Adds the view button's actionListener
	}
}
