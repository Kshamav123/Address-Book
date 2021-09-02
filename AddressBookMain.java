package com.AddressBook;

public class AddressBookMain {
	
	public String firstName;
	public String lastName;
	public String address;
	public String city;
	public String state;
	public int zip;
	public int phoneNo;
	public String email;
	
	
	public AddressBookMain(String firstName, String lastName, String address, String city, String state, int zip, int phoneNo, String email)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNo = phoneNo;
		this.email = email;
	}
	
        public static void main (String[] args)
        {
        	System.out.println("Welcome to Address Book Program");
        }
}

