package banking_project;

import javax.swing.JOptionPane;

public class Admin {

	Customer customerInfo;
	Employee employeeInfo;
	Transaction transactionInfo;
	Admin businessInfo;

	public Admin() {
		super();

	}

	public Admin(Customer customerInfo, Employee employeeInfo, Transaction transactionInfo) {
		super();
		this.customerInfo = customerInfo;
		this.employeeInfo = employeeInfo;
		this.transactionInfo = transactionInfo;
	}

	public Customer getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(Customer customerInfo) {
		this.customerInfo = customerInfo;
	}

	public Employee getEmployeeInfo() {
		return employeeInfo;
	}

	public void setEmployeeInfo(Employee employeeInfo) {
		this.employeeInfo = employeeInfo;
	}

	public Transaction getTransactionInfo() {
		return transactionInfo;
	}

	public void setTransactionInfo(Transaction transactionInfo) {
		this.transactionInfo = transactionInfo;
	}

	public Admin getBusinessInfo() {
		storeBusinessData();
		return businessInfo;
	}

	public void setBusinessInfo(Admin businessInfo) {
		this.businessInfo = businessInfo;
	}

	/**
	 * this method stores data from all aspects of the business
	 * 
	 * @return returns the business data
	 */
	public Object[] storeBusinessData() {
		Object[] businessData = new Object[3];

		((Admin) businessData[0]).getCustomerInfo();
		((Admin) businessData[1]).getEmployeeInfo();
		((Admin) businessData[2]).getTransactionInfo();

		return businessData;
	}

	/**
	 * This method allows the user to learn information about the company
	 */
	public static void aboutUs() {
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

	}

	/**
	 * This method allows the user to get the contact information about the company
	 */
	public static void contactInfo() {

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

	}
}
