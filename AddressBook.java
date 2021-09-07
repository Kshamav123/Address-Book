package com.AddressBook;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class AddressBook {
	String addressBookName;
	static Scanner sc = new Scanner(System.in);
	
	AddressBook(String addressBookName){
		this.addressBookName=addressBookName;
	}

	/**
	 * Map to maintain dictionary
	 */
	
	
	static Map<String,Contacts> addressBook = new HashMap<>();
	
	
	public static void addContact() {
		Contacts contact;

		System.out.println("Enter the person details");
		System.out.println("enter the first name");
		String firstname1 = sc.nextLine();
		System.out.println("enter the last name");
		String lastname1= sc.nextLine();
		System.out.println("enter the addres");
		String address = sc.nextLine();
		System.out.println("enter the city");
		String city = sc.nextLine();

		System.out.println("enter the state");
		String state = sc.nextLine();
		System.out.println("enter the zip code");
		String zip = sc.nextLine();
		System.out.println("enter the phone Number");
		String phone = sc.nextLine();
		System.out.println("enter the email Id ");
		String email = sc.nextLine();
		contact = new Contacts(firstname1, lastname1, address, city, state, zip, phone, email);
		String name=firstname1 + " "+lastname1;
		Contacts con= addressBook.get(name);
		if(con != null) {
			System.out.println("There is already a person with this name ");
		}
		else {
		addressBook.put(firstname1+" "+lastname1, contact);
		}

	}
	
	
	
	public static void editPerson() {
		
		
		
		System.out.println("enter the first name");
		String firstname1 = sc.nextLine();
		System.out.println("enter the last name");
		String lastname1 = sc.nextLine();
		
		String name=firstname1 + " "+lastname1;
		
		Contacts con= addressBook.get(name);
		if(con == null) {
			System.out.println("Person of that name does not exits in this book");
		}
		else {
			int option;

			Scanner scanner= new Scanner(System.in);
			

			while (true) {
				System.out.println("What do you wanna edit");
				System.out.println(
						"1 First Name\n2 Last Name\n3 Address\n4 City\n5 State\n6 Zip\n7 Phone number\n8 Email\n9 Go back");
				option = scanner.nextInt();
				switch (option) {
				case 1:
					System.out.println("enter the first name");
					String firstName = sc.nextLine();
					
					con.firstName=firstName;
					break;
				case 2:
					System.out.println("enter the last name");
					String lastName = sc.nextLine();
					con.lastName = lastName;
					break;
				case 3:
					System.out.println("enter the address");
					String address = sc.nextLine();
					con.address = address;
					break;
				case 4:
					System.out.println("enter the city");
					String city = sc.nextLine();
					con.city = city;
					break;
				case 5:
					System.out.println("enter state");
					String state = sc.nextLine();
					con.state = state;
					break;
				case 6:
					System.out.println("enter the zip code");
					String zip = sc.nextLine();
					con.zip = zip;
					break;
				case 7:
					System.out.println("enter phone number");
					String phone = sc.nextLine();
					con.phoneNumber = phone;
					break;
				case 8:
					System.out.println("enter email");
					String email = sc.nextLine();
					con.eMail = email;
					break;
				case 9:
					return;
				}
			}
			
		}
		
	}
	
	public static void deleteperson() {
		
	
		System.out.println("enter the first name");
		String firstname1 = sc.nextLine();
		System.out.println("enter the last name");
		String lastname1 = sc.nextLine();
		
		String name=firstname1 + " "+lastname1;
		
		Contacts con= addressBook.get(name);
		if(con == null) {
			System.out.println("Person of that name not exits in this book");
			
		}
		else {
			addressBook.remove(name);
		}
		

	}

	
	public void print() {

		for(Contacts con:addressBook.values()) {
			System.out.println(con);
		}
		
	}	

}