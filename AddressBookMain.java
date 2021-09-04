package com.AddressBook;

import java.util.Scanner;

public class AddressBookMain {
	
	 public static void main (String[] args)
     {
     	System.out.println("Welcome to Address Book Program");
     	
     	Scanner sc = new Scanner(System.in);
     	System.out.println("Enter the number of contacts to add :");
     	int num = sc.nextInt();
     	
     	for(int i =0; i<num ; i++)
     		
     	{
     		System.out.println("Enter your First Name:");
     		String firstName = sc.nextLine();
     		System.out.println("Enter your Last Name:");
     		String lastName = sc.nextLine();
     		System.out.println("Enter your Address:");
     		String address = sc.nextLine();
     		System.out.println("Enter your City:");
     		String city = sc.nextLine();
     		System.out.println("Enter your State:");
     		String state = sc.nextLine();
     		System.out.println("Enter your Zip:");
     		String zip = sc.nextLine();
     		System.out.println("Enter your Phone number:");
     		String phoneNo = sc.nextLine();
     		System.out.println("Enter your Email:");
     		String email = sc.nextLine();
     		
     		Contacts contact = new Contacts(firstName, lastName, address, city, state, zip, phoneNo, email);
     		
     		System.out.println("Details Added. \n");
			System.out.println("Name: " + contact.firstName + " " + contact.lastName);
			System.out.println("Address: " + contact.address + ", " + contact.city + ", "+ contact.state + " - " + contact.zip);
			System.out.println("Contact Number: " + contact.phoneNo + "\n");
						
     		
     	}
     	sc.close();
     }
	 
	 
}
