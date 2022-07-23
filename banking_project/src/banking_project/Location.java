package banking_project;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

//*****************************************************************************
//
//	           This class creates a model for the customer's location
//
//*****************************************************************************

public class Location extends Customer {

	Location locationInfo;
	String address;
	String city;
	String state;
	int zipcode;

	public Location() {
		super();

	}

	public Location(String address, String city, String state, int zipcode) {
		super();
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}

	public String getAddress() {
		address = JOptionPane.showInputDialog("Enter your street address: ");
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		city = JOptionPane.showInputDialog("Enter your City: ");
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		state = JOptionPane.showInputDialog("Enter your State: ");
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipcode() {
		try {
			zipcode = Integer.parseInt(JOptionPane.showInputDialog("Enter your Zip Code: "));

			if (zipcode < 9999 || zipcode > 99999) {
				JOptionPane.showMessageDialog(null, "Error, Zip Codes are only 5 digits!");
				zipcode = Integer.parseInt(JOptionPane.showInputDialog("Enter your Zip Code: "));
			}

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Error, you must enter a number!", "PEARSON FINANCIAL",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public Location getLocationInfo() {
		storeLocationData("LocationData.txt", "", false);
		return locationInfo;
	}

	public void setLocationInfo(Location locationInfo) {
		this.locationInfo = locationInfo;
	}

	/**
	 * This method returns information about the customer's location
	 * 
	 * @return returns customer location data
	 */
	public Object[] storeLocationData(String locationFile, String text, boolean updateFile) {

		Object[] locationData = new Object[4];
		locationData[0] = this.address;
		locationData[1] = this.city;
		locationData[2] = this.state;
		locationData[3] = this.zipcode;

		// Beginning of try/catch to make sure user inputs number
		try {
			// Creates a file object called f
			File f = new File(locationFile);
			// Creates FileWriter object called fw
			FileWriter fw;
			fw = new FileWriter(f, updateFile);
			// Using PrintWriter method to collect user's personal data
			PrintWriter pw = new PrintWriter(fw);
			pw.println("Address: " + locationData[0]);
			pw.println("City: " + locationData[1]);
			pw.println("State: " + locationData[2]);
			pw.println("Zip Code: " + locationData[3]);
			pw.close();

			JOptionPane.showMessageDialog(null, "              Thank You " + "\nData written to file LocationData.txt");
		} catch (IOException | NumberFormatException e) {

			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Must Enter a Number", "PEARSON FINANCIAL", JOptionPane.ERROR_MESSAGE);

		}

		JOptionPane.showMessageDialog(null,
				"Location Information\n" + "\nAddress: " + locationData[0] + "\nCity: " + locationData[1] + "\nState: "
						+ locationData[2] + "\nZip Code: " + locationData[3],
				"PEARSON FINANCIAL", JOptionPane.PLAIN_MESSAGE);

		return locationData;

	}

}
