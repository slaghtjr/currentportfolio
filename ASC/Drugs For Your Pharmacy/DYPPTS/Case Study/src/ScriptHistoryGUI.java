import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class ScriptHistoryGUI extends JFrame {
	private GUIController control;

	private JPanel buttons = new JPanel();
	private JPanel history = new JPanel();

	private JButton view = new JButton("Return to Customer");
	private JTextArea displayHistory;
	private JScrollPane pane;

	public ScriptHistoryGUI() {
		createTextArea();
		createPanels();
		createButtons();

		add(history, BorderLayout.NORTH);
		add(buttons, BorderLayout.SOUTH);
		setSize(300, 300);
		setUndecorated(true);
	}

	public ScriptHistoryGUI(GUIController c) {
		this();
		control = c;
	}

	private void createTextArea() {
		displayHistory = new JTextArea(15, 20);
		displayHistory.setEditable(false);

		pane = new JScrollPane(displayHistory);
	}

	private void createPanels() {
		history.add(pane);
		// history.add(displayHistory);
		history.setVisible(true);
		buttons.add(view);
	}

	private void createButtons() {
		view.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				control.setHistoryRun(false);
				control.setViewRun(true);
			}
		}); // Adds the exit button's actionListener

	}

	public void displayHistory(Customer c) {
		displayHistory.setText("");
		Customer cust = c;

		if (cust.getPrescriptionHistoryList().size() < 1) {
			displayHistory.append(cust.getLastName() + ","
					+ cust.getFirstName() + " has no Prescription History\n\n");
		} else {
			for (int i = 0; i < cust.getPrescriptionHistoryList().size(); i++) {
				displayHistory.append(cust.getPrescriptionHistoryList().get(i)
						.toString());
			}
		}
	}
}
