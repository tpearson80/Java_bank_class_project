package banking_project;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.swing.JOptionPane;

//**************************************************************************************
//
//	               This class creates a model for an employee
//
//**************************************************************************************

public class Employee extends Transaction {

	int empID;
	Employee employeeInfo;

	public Employee() {
		super();

	}

	public Employee(int empID, String lastName, String firstName) {
		super();
		this.empID = empID;

	}

	public int getEmpID() {
		Random r = new Random();
		empID = r.nextInt(5000 + 999) - 999;
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public Employee getEmployeeInfo() {
		storeEmployeeData("EmployeeData.txt", "", false);
		return employeeInfo;
	}

	public void setEmployeeInfo(Employee employeeInfo) {
		this.employeeInfo = employeeInfo;
	}

	/**
	 * This method shows information about employees
	 * 
	 * @return returns employee data
	 */
	public Object[] storeEmployeeData(String employeeFile, String text, boolean updateFile) {
		Object[] employeeData = new Object[3];

		employeeData[0] = this.getEmpID();
		employeeData[1] = "Anakin";
		employeeData[2] = "Skywalker";

		// Beginning of try/catch to make sure user inputs number
		try {
			// Creates a file object called f
			File f = new File(employeeFile);
			// Creates FileWriter object called fw
			FileWriter fw;
			fw = new FileWriter(f, updateFile);
			// Using PrintWriter method to collect user's personal data
			PrintWriter pw = new PrintWriter(fw);
			pw.println("Employee ID#: " + employeeData[0]);
			pw.println("Employee First Name: " + employeeData[1]);
			pw.println("Employee Last Name: " + employeeData[2]);
			pw.close();

			JOptionPane.showMessageDialog(null, "              Thank You " + "\nData written to file EmployeeData.txt");
		} catch (IOException | NumberFormatException e) {

			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Must Enter a Number", "PEARSON FINANCIAL", JOptionPane.ERROR_MESSAGE);

		}

		JOptionPane
				.showMessageDialog(
						null, "Employee Information\n" + "\nEMP ID#: " + employeeData[0] + "\nFirst Name: "
								+ employeeData[1] + "\nLast Name: " + employeeData[2],
						"PEARSON FINANCIAL", JOptionPane.PLAIN_MESSAGE);

		return employeeData;

	}

}
