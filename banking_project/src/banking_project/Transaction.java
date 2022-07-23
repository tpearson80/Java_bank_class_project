package banking_project;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Random;
import javax.swing.JOptionPane;

//*************************************************************************************
//
//	              This class creates a model for each transaction made
//
//*************************************************************************************

public class Transaction extends Customer {

	Transaction transactionInfo;
	double withdraw;
	double deposit;
	double checkBalance;
	long transactionNum;
	String transactionType;
	Date date = new Date();

	public Transaction() {

	}

	public Transaction(double withdraw, double deposit, double checkBalance, long transactionNum,
			String transactionType, Date date) {
		super();
		this.withdraw = withdraw;
		this.deposit = deposit;
		this.checkBalance = checkBalance;
		this.transactionNum = transactionNum;
		this.transactionType = transactionType;
		this.date = date;
	}

	public double getWithdraw() {

		// allows string input from user
		String input;
		// Allows for user to enter Y or y for yes and N or n for no
		char repeat;

		// Beginning of try/catch to make sure user inputs number
		try {

			input = JOptionPane.showInputDialog("Enter your withdrawal amount:$ ");
			withdraw = Float.parseFloat(input);

			input = JOptionPane.showInputDialog(String.format("You Entered:$%,.2f\n" + "\nIs this correct?"
					+ "\nPlease Enter Y to Confirm" + " or N to go back: ", withdraw));
			repeat = input.charAt(0);

			if (repeat == 'y' || repeat == 'Y') {
				JOptionPane.showMessageDialog(null, "              Thank You");
			} else if (repeat == 'n' || repeat == 'N') {
				getWithdraw();
			} else {
				input = JOptionPane.showInputDialog("************INVALID ENTRY*************");
				getWithdraw();
			}

			while (withdraw > NewMain.balance) {
				// Validating Input for withdrawal
				JOptionPane.showMessageDialog(null,
						String.format(
								"                         " + "**ERROR** Insufficient Funds!"
										+ "\nPlease Enter Withdrawal Amount that is less than your Account Balance"
										+ "\n                       " + "Your Account Balance is: " + "$%,.2f\n",
								NewMain.balance, "PEARSON FINANCIAL", JOptionPane.ERROR_MESSAGE));
				getWithdraw();
			}

			if (withdraw > 0 && withdraw < NewMain.balance) {
				// subtracting the withdrawal from user's account
				JOptionPane.showMessageDialog(null, String.format("Your account balance is now: " + "$%,.2f\n",
						NewMain.balance -= withdraw, "PEARSON FINANCIAL", JOptionPane.INFORMATION_MESSAGE));
			}
		}

		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "You must enter a number!", "ERROR", JOptionPane.WARNING_MESSAGE);
			getWithdraw();
		}
		return checkBalance;
	}

	public void setWithdraw(double withdraw) {
		this.withdraw = withdraw;
	}

	public double getDeposit() {
		// allows string input from user
		String input;
		// Allows for user to enter Y or y for yes and N or n for no
		char repeat;

		// Beginning of try/catch to make sure user inputs number
		try {
			input = JOptionPane.showInputDialog("Enter your deposit:$ ");
			deposit = Float.parseFloat(input);

			input = JOptionPane.showInputDialog(String.format("You Entered:$%,.2f\n" + "\nIs this correct?"
					+ "\nPlease Enter Y to Confirm" + " or N to go back: ", deposit));
			repeat = input.charAt(0);

			if (repeat == 'y' || repeat == 'Y') {
				JOptionPane.showMessageDialog(null, "              Thank You", "", JOptionPane.INFORMATION_MESSAGE);
			} else if (repeat == 'n' || repeat == 'N') {
				getDeposit();
			} else {
				input = JOptionPane.showInputDialog("************INVALID ENTRY*************");
				getDeposit();
			}

			// Validating input for deposit
			if (deposit < 0) {
				JOptionPane.showMessageDialog(null, "INVALID ENTRY! Please Enter an Amount Greater than $0", "ERROR",
						JOptionPane.ERROR_MESSAGE);

				getDeposit();
			}
			// adding the deposit
			JOptionPane.showMessageDialog(null, String.format("Your account balance is now: " + "$%,.2f\n",
					NewMain.balance += deposit, "BALANCE", JOptionPane.INFORMATION_MESSAGE));

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "You must enter a number!", "ERROR", JOptionPane.WARNING_MESSAGE);
			getDeposit();
		}

		return deposit;
	}

	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}

	public double getCheckBalance() {
		// Tells user what their balance is
		JOptionPane.showMessageDialog(null, String.format("Your account balance is: " + "$%,.2f\n", NewMain.balance,
				"CHECK BALANCE", JOptionPane.INFORMATION_MESSAGE));

		return checkBalance;
	}

	public void setCheckBalance(double checkBalance) {
		this.checkBalance = checkBalance;
	}

	public long getTransactionNum() {
		Random r = new Random();
		transactionNum = r.nextInt((500000 + 99999) - 99999);
		return transactionNum;
	}

	public void setTransactionNum(long transactionNum) {
		this.transactionNum = transactionNum;
	}

	public String getTransactionType() {
		// allows string input from user
		String input;
		// returns number from user
		byte number = 0;

		// Beginning of try/catch to make sure user inputs number
		try {

			// Input from user to get the type of transaction they want to do
			input = JOptionPane.showInputDialog("       What can we help you with? " + "\nEnter 1 to Check your Balance"
					+ "\nEnter 2 to Deposit" + "\nEnter 3 to Withdraw");
			number = Byte.parseByte(input);

			// Validating input from user on menu.
			while (number < 1 || number > 3) {
				input = JOptionPane.showInputDialog("*********INVALID ENTRY!*********"
						+ "\nEnter 1 to Check your Balance" + "\nEnter 2 to Deposit" + "\nEnter 3 to Withdraw");
				number = Byte.parseByte(input);

				// If-else-if statements to navigate the transaction menu to determine type of
				// transaction
			}

			if (number == 1) {
				transactionType = "Check Balance";
				this.getCheckBalance();
			}

			else if (number == 2) {
				transactionType = "Deposit";
				this.getDeposit();
			}

			else if (number == 3) {
				transactionType = "Withdraw";
				this.getWithdraw();
			}

			else {
				getTransactionType();
			}

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "You must enter a number!", "ERROR", JOptionPane.WARNING_MESSAGE);
		}

		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Transaction getTransactionInfo() {
		storeTransactionData("TransactionData.txt", "", false);
		return transactionInfo;
	}

	public void setTransactionInfo(Transaction transactionInfo) {
		this.transactionInfo = transactionInfo;
	}

	/**
	 * This method returns information about the transactions
	 * 
	 * @return returns transaction data
	 */
	public Object[] storeTransactionData(String transactionFile, String text, boolean updateFile) {
		Object[] transactionData = new Object[3];

		transactionData[0] = this.date;
		transactionData[1] = this.transactionNum;
		transactionData[2] = this.transactionType;

		// Beginning of try/catch to make sure user inputs number
		try {
			// Creates a file object called f
			File f = new File(transactionFile);
			// Creates FileWriter object called fw
			FileWriter fw;
			fw = new FileWriter(f, updateFile);
			// Using PrintWriter method to collect user's personal data
			PrintWriter pw = new PrintWriter(fw);
			pw.println("Date: " + transactionData[0]);
			pw.println("Transaction Number: " + transactionData[1]);
			pw.println("Transaction Type: " + transactionData[2]);
			pw.close();

			JOptionPane.showMessageDialog(null,
					"              Thank You " + "\nData written to file TransactionData.txt");
		} catch (IOException | NumberFormatException e) {

			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Must Enter a Number", "PEARSON FINANCIAL", JOptionPane.ERROR_MESSAGE);

		}

		JOptionPane.showMessageDialog(null,
				"Transaction Information\n" + "\nDate: " + transactionData[0] + "\nTransaction Number: "
						+ transactionData[1] + "\nTransaction Type: " + transactionData[2],
				"PEARSON FINANCIAL", JOptionPane.PLAIN_MESSAGE);

		return transactionData;

	}

}
