import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class SearchCustGUI extends JFrame {
	private JLabel searchFirst = new JLabel();
	private JLabel searchLast = new JLabel();
	private JPanel searchCust = new JPanel();
	private JTextField fNameText;
	private JTextField lNameText;
	private JPanel buttons = new JPanel();
	private JButton submit = new JButton("Submit Search Query");
	private JButton main = new JButton("Return to Main Menu");
	private GUIController control;

	public SearchCustGUI() {
		createLabels();
		createTextFields();
		createButtons();
		createPanels();

		add(searchCust, BorderLayout.CENTER);
		add(buttons, BorderLayout.SOUTH);
		setSize(300, 300);
		setUndecorated(true);
	}

	public SearchCustGUI(GUIController c) {
		this();
		control = c;
	}

	private void createLabels() {
		searchFirst.setText("Customer First Name");
		searchLast.setText("Customer Last Name");
	}

	private void createTextFields() {
		fNameText = new JTextField();
		lNameText = new JTextField();
	}

	private void createButtons() {
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				if ((control.getCustomers().contains(lNameText.getText(),
						fNameText.getText()) == true && (control.getCustomers()
						.getCustomer(lNameText.getText(), fNameText.getText()) != null))) {
					control.setSearchCustRun(false);
					Customer c = control.getCustomers().getCustomer(
							lNameText.getText(), fNameText.getText());
					control.setViewRun(true, c);
					lNameText.setText("");
					fNameText.setText("");
				} else {
					JOptionPane.showMessageDialog(null,
							"Customer Not Found, Please Try Again");
					lNameText.setText("");
					fNameText.setText("");
				}
			}
		}); // Adds the exit button's actionListener
		main.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				lNameText.setText("");
				fNameText.setText("");
				control.setSearchCustRun(false);
				control.setMainRun(true);
			}
		}); // Adds the exit button's actionListener
	}

	private void createPanels() {
		searchCust.setLayout(new GridLayout(2, 2));
		// searchCust.setLayout(new GridLayout(2,2,0,0));
		searchCust.add(searchLast);
		searchCust.add(lNameText);
		searchCust.add(searchFirst);
		searchCust.add(fNameText);

		buttons.setLayout(new GridLayout(1, 2, 0, 0));

		buttons.add(submit);
		buttons.add(main);
	}
}
