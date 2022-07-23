package banking_project;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

//*********************************************************************************
//
//	              This class creates the model for a customer
//
//*********************************************************************************

public class Customer {

	public long accNumber;
	double balance;
	String lastName;
	String firstName;
	String password;
	Customer customerInfo;

	public Customer() {
		super();
		balance = 0;
	}

	public Customer(long accNumber, double balance, String lastName, String firstName, String password) {
		super();
		this.accNumber = accNumber;
		this.balance = balance;
		this.lastName = lastName;
		this.firstName = firstName;
		this.password = password;

	}

	public long getAccNumber() {
		String input;

		try {
			input = JOptionPane.showInputDialog(
					"Enter your 9 digit Account Number: " + "\n**********Must Not start with 0**********");
			accNumber = Long.parseLong(input);

			while (accNumber > 999_999_999 || accNumber <= 999_999_99) {
				input = JOptionPane.showInputDialog("*****INVALID ACCOUNT NUMBER!*****"
						+ "\n********Must Not start with 0********" + "\nPlease enter 9 digit Account Number: ");
				getAccNumber();
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Error, you must enter a number", "ERROR", JOptionPane.ERROR_MESSAGE);
			accNumber = Long.parseLong(JOptionPane.showInputDialog(
					"Enter your 9 digit Account Number: " + "\n**********Must Not start with 0**********"));
		}
		return accNumber;
	}

	public void setAccNumber(long accNumber) {
		this.accNumber = accNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getLastName() {
		lastName = JOptionPane.showInputDialog("Enter your Last Name: ");
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		firstName = JOptionPane.showInputDialog("Enter your First Name: ");
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPassword() {
		password = JOptionPane.showInputDialog("Enter your Password: ");
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Customer getCustomerInfo() {
		storeCustomerData("CustomerData.txt", "", false);
		return customerInfo;
	}

	public void setCustomerInfo(Customer customerInfo) {
		this.customerInfo = customerInfo;
	}

	/**
	 * This method returns all information about the customer
	 * 
	 * @return returns customer data
	 */

	public Object[] storeCustomerData(String customerFile, String text, boolean updateFile) {
		Object[] customerData = new Object[5];

		customerData[0] = this.accNumber;
		customerData[1] = this.firstName;
		customerData[2] = this.lastName;
		customerData[3] = this.password;
		customerData[4] = this.balance;

		// Beginning of try/catch to make sure user inputs number
		try {
			// Creates a file object called f
			File f = new File(customerFile);
			// Creates FileWriter object called fw
			FileWriter fw;
			fw = new FileWriter(f, updateFile);
			// Using PrintWriter method to collect user's personal data
			PrintWriter pw = new PrintWriter(fw);
			pw.println("Account Number: " + customerData[0]);
			pw.println("First Name: " + customerData[1]);
			pw.println("Last Name: " + customerData[2]);
			pw.println("Password: " + customerData[3]);
			pw.println("Balance: " + customerData[4]);

			pw.close();

			JOptionPane.showMessageDialog(null, "              Thank You " + "\nData written to file CustomerData.txt");
		} catch (IOException | NumberFormatException e) {

			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Must Enter a Number", "PEARSON FINANCIAL", JOptionPane.ERROR_MESSAGE);

		}

		JOptionPane.showMessageDialog(null,
				"Account Information\n" + "\nAccount Number: " + customerData[0] + "\nFirst Name: " + customerData[1]
						+ "\nLast Name: " + customerData[2] + "\nPassword: " + customerData[3] + "\nAccount Balance:"
						+ customerData[4],
				"PEARSON FINANCIAL", JOptionPane.PLAIN_MESSAGE);

		return customerData;

	}
}
