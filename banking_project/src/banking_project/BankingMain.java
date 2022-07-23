package banking_project;

//import statement that allows for random generation of numbers
import java.util.Random;
//import statement that allows for PrintWriter to be used
import java.io.*;
//import statement that allows for using JOptionPane
import javax.swing.JOptionPane;

//This is the public class
public class BankingMain {

	// This is a variable to keep balance consistent throughout program
	public static double balance;

	// Balance constructor entered set to 0 to begin program
	public BankingMain() {
		balance = 0;

	}

	// Constructor to initialize balance in parameters
	public BankingMain(double initialBalance) {
		balance = initialBalance;

	}

	// This is the main method
	public static void oldMain() throws IOException {

		// ********************************************************************
		//
		// This is the previous banking program by Travis Pearson
		//
		// ********************************************************************

		signIn("PersonalData.txt", " ", false);
		mainMenu();

	}

	/**
	 * This method operates the main menu of the program and returns input from the
	 * user
	 * 
	 * @return number input from user
	 * @throws IOException
	 */
	public static int mainMenu() throws IOException {

		// allows string input from user
		String inputString;
		// returns number from user
		byte number = 0;

		// Beginning of try/catch to make sure user inputs number
		try {

			// Input from user on main menu
			inputString = JOptionPane
					.showInputDialog("                    Main Menu" + "\n       What can we help you with? "
							+ "\nEnter 1 to Check your Balance" + "\nEnter 2 to Deposit" + "\nEnter 3 to Withdraw"
							+ "\nEnter 4 to Transfer Funds" + "\nEnter 5 to Check Your Credit Score"
							+ "\nEnter 6 to Contact Us" + "\nEnter 7 to Learn About Us" + "\nEnter 8 to Exit");

			number = Byte.parseByte(inputString);

			// Validating input from user on main menu.
			while (number < 1 || number > 8) {
				inputString = JOptionPane.showInputDialog("*********INVALID ENTRY!*********"
						+ "\n                   Main Menu" + "\nEnter 1 to Check your Balance" + "\nEnter 2 to Deposit"
						+ "\nEnter 3 to Withdraw" + "\nEnter 4 to Transfer Funds"
						+ "\nEnter 5 to Check Your Credit Score" + "\nEnter 6 to Contact Us"
						+ "\nEnter 7 to Learn About Us" + "\nEnter 8 to Exit" + "\nPlease Enter a Valid Number");

				number = Byte.parseByte(inputString);

				// If-else-if statements to navigate the main menu and call from other methods
			}

			if (number == 1) {
				balanceCheck();
			}

			else if (number == 2) {
				menuDeposit(balance);
			}

			else if (number == 3) {
				menuWithdraw(balance);
			}

			else if (number == 4) {
				menuBalanceTransfer(balance);
			}

			else if (number == 5) {
				menuCreditScore();
			}

			else if (number == 6) {
				menuContactInfo();
			}

			else if (number == 7) {
				menuAboutUs();
			}

			else if (number == 8) {
				menuExitMessage();
			}

			else
				mainMenu();

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "You must enter a number!", "PEARSON FINANCIAL",
					JOptionPane.WARNING_MESSAGE);
			mainMenu();
		}
		// This returns the input from user
		return number;
	}

	/**
	 * This method welcomes the user and allows user to sign into their account and
	 * saves sign in information to PersonalData.txt file
	 * 
	 * @param userFile PersonalData.txt file
	 * @param text     user input
	 * @param addTo    boolean to save input to file
	 */
	private static void signIn(String userFile, String text, boolean updateFile) {

		// Allows for user to enter account number
		long accountNumber = 0;
		// Allows for user to enter password
		String passWord;
		// Allows for user to enter their last name
		String lastName;
		// Allows for user to enter their first name
		String firstName;
		// Allows string input from user
		String inputString;

		// Message to tell user they will need to enter their information
		JOptionPane.showMessageDialog(null, "Welcome to Pearson Financial! " + "\n          Please Sign In ",
				"PEARSON FINANCIAL", JOptionPane.INFORMATION_MESSAGE);

		// Beginning of try/catch to keep IO from throwing exception and make sure user
		// inputs number
		try {

			// Entering personal information

			// Enter user's last name
			lastName = JOptionPane.showInputDialog("Enter your last name: ");

			// Enter user's first name
			firstName = JOptionPane.showInputDialog("Enter your first name: ");

			// Enter user's password
			passWord = JOptionPane.showInputDialog("Please enter your password: ");

			// Enter user's account number
			inputString = JOptionPane.showInputDialog(
					"Please enter your 9 digit account number: " + "\n**********Must Not start with 0**********");
			accountNumber = Long.parseLong(inputString);

			// While statement to validate the user's account number
			while (accountNumber > 999_999_999 || accountNumber <= 999_999_99) {
				inputString = JOptionPane.showInputDialog("*****INVALID ACCOUNT NUMBER!*****"
						+ "\n********Must Not start with 0********" + "\nPlease enter 9 digit Account Number: ");
				accountNumber = Long.parseLong(inputString);
			}

			// Creates a file with user's information

			// Creates a file object called f
			File f = new File(userFile);
			// Creates FileWriter object called fw
			FileWriter fw = new FileWriter(f, updateFile);
			// Using PrintWriter method to collect user's personal data
			PrintWriter pw = new PrintWriter(fw);
			pw.println("Last Name " + lastName + " ");
			pw.println("First Name " + firstName + " ");
			pw.println("Account Number " + accountNumber + " ");
			pw.println("Password " + passWord);
			pw.close();
			JOptionPane.showMessageDialog(null, "              Thank You " + "\nData written to file PersonalData.txt",
					"PEARSON FINANCIAL", JOptionPane.INFORMATION_MESSAGE);

			// If statement to welcome user to their account
			if (accountNumber <= 999_999_999 || accountNumber > 999_999_99) {
				JOptionPane.showMessageDialog(null, " \t Welcome " + firstName + " " + lastName + "! ",
						"PEARSON FINANCIAL", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (IOException | NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Error, Try Again", "PEARSON FINANCIAL", JOptionPane.ERROR_MESSAGE);
			signIn("PersonalData.txt", " ", false);
		}

	}

	/**
	 * This method allows the user to check their balance
	 * 
	 * @return balance information
	 */
	public static double balanceCheck() {

		// Tells user what their balance is
		JOptionPane.showMessageDialog(null, String.format("Your account balance is: " + "$%,.2f\n", balance,
				"PEARSON FINANCIAL", JOptionPane.INFORMATION_MESSAGE));
		// Asks user if they wish to go back to the main menu
		goBackMain();
		return balance;
	}

	/**
	 * This method allows the user to deposit funds into their account
	 * 
	 * @param amount
	 */
	public static void menuDeposit(double amount) {

		// allows string input from user
		String inputString;
		// Allows for user to enter Y or y for yes and N or n for no
		char repeat;

		// Beginning of try/catch to make sure user inputs number
		try {
			inputString = JOptionPane.showInputDialog("Enter your deposit:$ ");
			amount = Float.parseFloat(inputString);

			inputString = JOptionPane.showInputDialog(String.format("You Entered:$%,.2f\n" + "\nIs this correct?"
					+ "\nPlease Enter Y to Confirm" + " or N to go back: ", amount));
			repeat = inputString.charAt(0);

			if (repeat == 'y' || repeat == 'Y') {
				JOptionPane.showMessageDialog(null, "              Thank You", "PEARSON FINANCIAL",
						JOptionPane.INFORMATION_MESSAGE);
			} else if (repeat == 'n' || repeat == 'N') {
				menuDeposit(amount);
			} else {
				inputString = JOptionPane.showInputDialog("************INVALID ENTRY*************");
				menuDeposit(amount);
			}

			// Validating input for deposit
			if (amount < 0) {
				JOptionPane.showMessageDialog(null, "INVALID ENTRY! Please Enter an Amount Greater than $0",
						"PEARSON FINANCIAL", JOptionPane.ERROR_MESSAGE);

				menuDeposit(amount);
			}
			// adding the deposit
			JOptionPane.showMessageDialog(null, String.format("Your account balance is now: " + "$%,.2f\n",
					balance += amount, "PEARSON FINANCIAL", JOptionPane.INFORMATION_MESSAGE));

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "You must enter a number!", "PEARSON FINANCIAL",
					JOptionPane.WARNING_MESSAGE);
			menuDeposit(balance);
		}

		// Asks user if they wish to go back to the main menu
		goBackMain();

	}

	/**
	 * This method allows the user to withdraw funds from their account
	 * 
	 * @param amount
	 */
	public static void menuWithdraw(double amount) {

		// allows string input from user
		String inputString;
		// Allows for user to enter Y or y for yes and N or n for no
		char repeat;

		// Beginning of try/catch to make sure user inputs number
		try {

			inputString = JOptionPane.showInputDialog("Enter your withdrawal amount:$ ");
			amount = Float.parseFloat(inputString);

			inputString = JOptionPane.showInputDialog(String.format("You Entered:$%,.2f\n" + "\nIs this correct?"
					+ "\nPlease Enter Y to Confirm" + " or N to go back: ", amount));
			repeat = inputString.charAt(0);

			if (repeat == 'y' || repeat == 'Y') {
				JOptionPane.showMessageDialog(null, "              Thank You");
			} else if (repeat == 'n' || repeat == 'N') {
				menuWithdraw(amount);
			} else {
				inputString = JOptionPane.showInputDialog("************INVALID ENTRY*************");
				menuWithdraw(amount);
			}

			while (amount > balance) {
				// Validating Input for withdrawal
				JOptionPane.showMessageDialog(null,
						String.format(
								"                         " + "**ERROR** Insufficient Funds!"
										+ "\nPlease Enter Withdrawal Amount that is less than your Account Balance"
										+ "\n                       " + "Your Account Balance is: " + "$%,.2f\n",
								balance, "PEARSON FINANCIAL", JOptionPane.ERROR_MESSAGE));
				menuWithdraw(amount);
			}

			if (amount > 0 && amount < balance) {
				// subtracting the withdrawal from user's account
				JOptionPane.showMessageDialog(null, String.format("Your account balance is now: " + "$%,.2f\n",
						balance -= amount, "PEARSON FINANCIAL", JOptionPane.INFORMATION_MESSAGE));
			}
		}

		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "You must enter a number!", "PEARSON FINANCIAL",
					JOptionPane.WARNING_MESSAGE);
			menuWithdraw(balance);
		}
		// Asks user if they wish to go back to the main menu
		goBackMain();
	}

	/**
	 * This method allows the user to transfer funds to another bank
	 * 
	 * @param amount
	 */
	public static void menuBalanceTransfer(double amount) {

		// user's account number
		long accountNumber;
		// Routing number of user's other bank for when they wish to transfer funds
		float routingNum;
		// allows string input from user
		String inputString;
		// Allows for user to enter Y or y for yes and N or n for no
		char repeat;

		// Beginning of try/catch to make sure user inputs number
		try {
			// returns number from user
			inputString = JOptionPane.showInputDialog(
					"Please Enter 9 digit Routing Number of Bank: " + "\n**********Must Not start with 0**********");
			routingNum = Float.parseFloat(inputString);
			// Validating input from user
			while (routingNum <= 999_999_99 || routingNum > 999_999_999) {
				inputString = JOptionPane.showInputDialog("INVALID ENTRY! Please Enter 9 digit Routing Number of Bank:"
						+ "\n**********Must Not start with 0**********");
				routingNum = Float.parseFloat(inputString);

			}
			// Get account number of bank that user wants to transfer to
			inputString = JOptionPane.showInputDialog("Please Enter 9 digit Account Number of the Bank"
					+ " \nthat you are Transferring Funds to: " + "\n**********Must Not start with 0**********");
			accountNumber = Long.parseLong(inputString);
			// Validating input from user
			while (accountNumber <= 999_999_99 || accountNumber > 999_999_999) {
				inputString = JOptionPane
						.showInputDialog("INVALID ENTRY!" + "\nPlease Enter 9 digit Account Number of the Bank"
								+ " \nfor which you would like to Transfer Funds:"
								+ "\n**********Must Not start with 0**********");
				accountNumber = Long.parseLong(inputString);
			}

			inputString = JOptionPane.showInputDialog("Enter the amount you wish to transfer:$ ");
			// represents deposit amount from account
			amount = Float.parseFloat(inputString);

			inputString = JOptionPane.showInputDialog(String.format("You Entered:$%,.2f\n" + "\nIs this correct?"
					+ "\nPlease Enter Y to Confirm" + " or N to go back: ", amount));
			repeat = inputString.charAt(0);

			if (repeat == 'y' || repeat == 'Y') {
				JOptionPane.showMessageDialog(null, "              Thank You", "PEARSON FINANCIAL",
						JOptionPane.INFORMATION_MESSAGE);
			} else if (repeat == 'n' || repeat == 'N') {
				menuBalanceTransfer(amount);
			} else {
				inputString = JOptionPane.showInputDialog("************INVALID ENTRY*************");
				menuBalanceTransfer(amount);
			}

			while (amount > balance) {
				// Validating Input for withdrawal
				JOptionPane.showMessageDialog(null,
						String.format(
								"                         " + "**ERROR** Insufficient Funds!"
										+ "\nPlease Enter Amount that is less than your Account Balance"
										+ "\n                       " + "Your Account Balance is: " + "$%,.2f\n",
								balance, "PEARSON FINANCIAL", JOptionPane.ERROR_MESSAGE));
				menuBalanceTransfer(amount);
			}
			if (amount > 0 && amount < balance) {
				// subtracting the withdrawal from user's account
				JOptionPane.showMessageDialog(null,
						String.format("Your account balance is now: " + "$%,.2f\n", balance -= amount));
			}

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "You must enter a number!", "PEARSON FINANCIAL",
					JOptionPane.WARNING_MESSAGE);
			menuBalanceTransfer(balance);
		}

		// Asks user if they wish to go back to the main menu
		goBackMain();

	}

	/**
	 * This method allows the user to check their credit score based off of their
	 * account balance
	 */
	public static void menuCreditScore() {

		// Name of company
		String nameOfCo = "Pearson Financial";
		// random number generator for Credit Score
		Random r = new Random();
		// allows string input from user
		String inputString;
		// Allows for user to enter Y or y for yes and N or n for no
		char creditCheck;
		// gives user their credit score based on account balance
		int creditScore;

		// Asks user if they would like to check their Credit Score
		inputString = JOptionPane.showInputDialog(
				"Are you sure you want to Check your Credit Score?" + "\nPlease enter Y for yes or N for no: ");
		creditCheck = inputString.charAt(0);

		// check user's credit score using switch statement with random generation
		switch (creditCheck) {
		case 'Y':
		case 'y':

			if (balance >= 10000) {
				creditScore = r.nextInt(851 - 751) + 751;
				JOptionPane.showMessageDialog(null, "Your Credit Score is " + creditScore + "!");
			}
			if (balance < 10000 && balance > 3000) {
				creditScore = r.nextInt(751 - 651) + 651;
				JOptionPane.showMessageDialog(null, "Your Credit Score is " + creditScore + "!");
			}
			if (balance <= 3000) {
				creditScore = r.nextInt(651 - 551) + 551;
				JOptionPane.showMessageDialog(null, "Your Credit Score is " + creditScore + "!");
			}

			break;

		case 'N':
		case 'n':
			JOptionPane.showMessageDialog(null, "Enjoy the rest of your " + nameOfCo + " Experience",
					"PEARSON FINANCIAL", JOptionPane.INFORMATION_MESSAGE);
			break;

		default:
			JOptionPane.showMessageDialog(null, "******INVALID ENTRY******", "PEARSON FINANCIAL",
					JOptionPane.ERROR_MESSAGE);
			menuCreditScore();

		}
		// Asks user if they wish to go back to the main menu
		goBackMain();
	}

	/**
	 * This method allows the user to get the contact information about the company
	 */
	public static void menuContactInfo() {

		// Company email address
		final String coEmail = "pearsonfinancial@hcc.com";
		// Company phone number
		final String coPhoneNumber = "555-555-5555";
		// Name of company
		final String nameOfCo = "Pearson Financial";
		// Tells user the company's phone number and email address

		JOptionPane.showMessageDialog(null,
				"Contact " + nameOfCo + " by Phone at " + coPhoneNumber + "\nor Email at " + coEmail, "CONTACT US",
				JOptionPane.INFORMATION_MESSAGE);
		// Asks user if they wish to go back to the main menu
		goBackMain();
	}

	/**
	 * This method allows the user to learn information about the company
	 */
	public static void menuAboutUs() {
		// Business variable declarations
		// Name of company
		final String nameOfCo = "Pearson Financial";
		// Name of owner
		final String ownerCEO = "Travis Pearson";
		// Year company was founded
		final short yearFounded = 2021;

		// About Us message
		JOptionPane.showMessageDialog(null,
				nameOfCo + " has been servicing the" + " Houston, Texas area since " + yearFounded + " .\nCEO "
						+ ownerCEO + ", has worked in the banking industry for 15 years. "
						+ "\nOur associates will be glad to help you with all of your banking needs.",
				"ABOUT US", JOptionPane.INFORMATION_MESSAGE);

		// Asks user if they wish to go back to the main menu
		goBackMain();
	}

	/**
	 * This method allows the user to exit the program and receives a lovely goodbye
	 */
	public static void menuExitMessage() {

		// Exiting message
		JOptionPane.showMessageDialog(null, "Thank You for using Pearson Financial" + "\n\n           Have a Great Day!"
				+ "\n\n                   Goodbye!", "PEACE OUT PEEPS!", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}

	public static void goBackMain() {

		int repeat;

		repeat = JOptionPane.showConfirmDialog(null, "Would you like to go back to the Menu? ", "PEARSON FINANCIAL",
				JOptionPane.YES_NO_OPTION);

		if (repeat == 0) {

			try {
				mainMenu();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else
			menuExitMessage();

	}

}
