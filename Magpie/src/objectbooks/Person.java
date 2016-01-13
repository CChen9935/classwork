package objectbooks;

import java.awt.Color;

public class Person {
	private String firstName;
	private String middleName;
	private String lastName;

	// Constructor
	//
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		middleName = "";
		this.lastName = lastName;
	}

	public Person(String firstName, String middleName, String lastName) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}

	public String toString() {
		return firstName + " " + middleName + " " + lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
