//Guistuff holds the main method for the program. 
//It instantiates Customers, Prescriptions, Medications, Generics, and GUIController.

public class Guistuff {

	private static Customers customers = new Customers();
	private static Prescriptions prescriptions = new Prescriptions();
	private static Generics generics = new Generics();
	private static Medications medications = new Medications(generics);
	private static GUIController control;

	public static void main(String[] args) {
		control = new GUIController(customers, prescriptions, medications);
		control.run();

		while (control.getRun() != false) {
			control.checkVisibility();
		}
		System.exit(0);
	}
}
