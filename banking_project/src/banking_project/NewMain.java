package banking_project;

import java.io.IOException;
import javax.swing.JOptionPane;

//***************************************************************************************
//           This Program by Travis Pearson shows the basics
//           of a bank. It uses several classes as models for
//           customer, employee, location, transaction, and
//           and admin with the capability of accessing all
//           information located in several files with information 
//           provided by the user.
//***************************************************************************************

public class NewMain {

	// declaring instance variable
	public static double balance;

	// constructor to keep balance consistent
	public NewMain() {
		balance = 0;
	}

	// initializing balance
	public NewMain(double initialBalance) {
		balance = initialBalance;
	}

	// main method
	public static void main(String[] args) throws IOException {

		// This calls to the method to choose whether to go to new program or the old
		// program
		methodMenu();
		// This calls the method for the new main menu
		newMainMenu();

	}

	/*
	 * This method is the menu to choose the new program or the old program
	 */
	static void methodMenu() {
		// allows string input from user
		String inputString;
		// returns number from user
		byte number = 0;

		try {

			// Input from user on menu
			inputString = JOptionPane.showInputDialog("Welcome to Pearson Financial\n" + "\nEnter 1 for new version: "
					+ "\nEnter 2 for previous version: ");
			number = Byte.parseByte(inputString);

			// if statement to go to the main menu of the old program
			if (number == 2) {
				BankingMain.mainMenu();
			}
			// while statement to validate input from user
			while (number <= 0 || number > 2) {
				JOptionPane.showMessageDialog(null, "You must enter the correct number!", "PEARSON FINANCIAL",
						JOptionPane.ERROR_MESSAGE);
				// validating input from user on menu
				inputString = JOptionPane.showInputDialog("Enter 1 for new version: \nEnter 2 for previous version: ");
				number = Byte.parseByte(inputString);
				if (number == 2) {
					BankingMain.mainMenu();
				}
			}

			// end of try/catch to verify inputs
		} catch (IOException | NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "      You must enter a number!", "PEARSON FINANCIAL",
					JOptionPane.ERROR_MESSAGE);
			methodMenu();
		}

	}

	/**
	 * This method operates the main menu of the new program and returns input from
	 * the user
	 * 
	 * @return number input from user
	 * @throws IOException
	 */
	public static int newMainMenu() throws IOException {

		// allows string input from user
		String inputString;
		// returns number from user
		byte number = 0;

		// Beginning of try/catch to make sure user inputs number
		try {

			// Input from user on main menu
			inputString = JOptionPane
					.showInputDialog("                    Main Menu" + "\n       What can we help you with? "
							+ "\nEnter 1 to Sign in " + "\nEnter 2 for Transaction Menu" + "\nEnter 3 to Contact Us"
							+ "\nEnter 4 to Learn About Us" + "\nEnter 5 to Exit");
			number = Byte.parseByte(inputString);

			// Validating input from user on main menu.
			while (number < 1 || number > 5) {
				inputString = JOptionPane.showInputDialog("*********INVALID ENTRY!*********"
						+ "\n                   Main Menu" + "\nEnter 1 to Sign in " + "\nEnter 2 for Transaction Menu"
						+ "\nEnter 3 to Contact Us" + "\nEnter 4 to Learn About Us" + "\nEnter 5 to Exit"
						+ "\nPlease Enter a Valid Number");
				number = Byte.parseByte(inputString);

				// If-else-if statements to navigate the main menu and call from other methods
			}

			if (number == 1) {
				Customer customer = new Customer();
				Location location = new Location();
				customer.getFirstName();
				customer.getLastName();
				customer.getAccNumber();
				customer.getPassword();
				customer.getBalance();
				customer.getCustomerInfo();
				location.getAddress();
				location.getCity();
				location.getState();
				location.getZipcode();
				location.getLocationInfo();
				goBackNewMain();
			}

			else if (number == 2) {
				Transaction transaction = new Transaction();
				Employee employee = new Employee();
				transaction.getDate();
				transaction.getTransactionNum();
				transaction.getTransactionType();
				employee.getEmployeeInfo();
				transaction.getTransactionInfo();
				goBackNewMain();
			}

			else if (number == 3) {
				Admin.contactInfo();
				goBackNewMain();
			}

			else if (number == 4) {
				Admin.aboutUs();
				goBackNewMain();
			}

			else if (number == 5) {
				BankingMain.menuExitMessage();
			}

			else
				newMainMenu();

		} catch (IOException | NumberFormatException e) {

			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Must Enter a Number", "PEARSON FINANCIAL", JOptionPane.ERROR_MESSAGE);

		}
		// This returns the input from user
		return number;

	}

	/**
	 * This method asks user if they wish to go back to the main menu on the new
	 * program
	 */
	public static void goBackNewMain() {

		int repeat;

		repeat = JOptionPane.showConfirmDialog(null, "Would you like to go back to the Menu? ", "PEARSON FINANCIAL",
				JOptionPane.YES_NO_OPTION);

		if (repeat == 0) {

			try {
				newMainMenu();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else
			BankingMain.menuExitMessage();

	}

}
