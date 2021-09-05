package com.AddressBook;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookMain {
	static List<Contacts> list =new ArrayList<>();

	public static void main(String[] args) {
		System.out.println("Welcome to AddressBook program");
		Scanner sc = new Scanner(System.in);
		 final int EXIT=5;
		
		int option=0;
		while(option != EXIT) {
			
			System.out.println("1 : Add Contact\n2 : Edit Contact\n3 : Delete Contact\n4 : Display Contact\n"+EXIT+" to exit");
			Scanner scanner = new Scanner(System.in);
			option=scanner.nextInt();
			
			switch(option)
			{
			
			case 1:addContact();
					break;
			case 2:
				
				System.out.println("Enter your first name");
				String firstName1=sc.nextLine();
				System.out.println("Enter your last name");
				String lastName1=sc.nextLine();
					editPerson(firstName1,lastName1);
					break;
			case 5:System.exit(0);
			
			}
			
		}
		
		
	}
	
	

	

    public static Contacts getPerson(String firstName1,String lastName1)
	{
		for(Contacts contact:list)
		{
			if(contact.firstName.equals(firstName1) && contact.lastName.equals(lastName1)) {
				return contact;
			}
			
		}
		return null;
		
	}

	/* To edit the Contact of the person*/
	private static void editPerson(String firstName1,String lastName1) {
		
		Contacts person=getPerson(firstName1,lastName1);
		if(person != null)
		{
			
           int choice;
			Scanner scanner = new Scanner(System.in);
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				System.out.println("What do you wanna edit");
				System.out.println("1 First Name\n2 Last Name\n3 Address\n4 City\n5 State\n6 Zip\n7 Phone number\n8 Email\n9 Go back");
				choice=scanner.nextInt();
				switch(choice) {
				case 1:System.out.println("enter the first name");
				String firstName=sc.nextLine();
				person.firstName=firstName;
				break;
				case 2:System.out.println("enter the last name");
				String lastName=sc.nextLine();
				person.lastName=lastName;
				break;
				case 3:System.out.println("enter the address");
				String address=sc.nextLine();
				person.address=address;
				break;
				case 4:System.out.println("enter the city");
				String city=sc.nextLine();
				person.city=city;
				break;
				case 5:System.out.println("enter state");
				String state=sc.nextLine();
				person.state=state;
				break;
				case 6:System.out.println("enter the zip code");
				String zip=sc.nextLine();
				person.zip=zip;
				break;
				case 7:System.out.println("enter phone number");
				String phone=sc.nextLine();
				person.phoneNo=phone;
				break;
				case 8:System.out.println("enter email");
				String email=sc.nextLine();
				person.email=email;
				break;
				case 9: return;
				}
			}
		}
		
		else {
			System.out.println("Contact not found");
		}
			
	}
		

	/**
	 * Function to add new contact
	 */
	private static void addContact() {
		Contacts contact ;
		
		System.out.println("Enter the person details");
		Scanner sc= new Scanner(System.in);
		System.out.println("enter the first name");
		String firstName1=sc.nextLine();
		System.out.println("enter the last name");
		String lastName1=sc.nextLine();
		System.out.println("enter the addres");
		String address=sc.nextLine();
		System.out.println("enter the city");
		String city=sc.nextLine();
		
		System.out.println("enter the state");
		String state=sc.nextLine();
		System.out.println("enter the zip code");
		String zip=sc.nextLine();
		System.out.println("enter the phone Number");
		String phone=sc.nextLine();
		System.out.println("enter the email Id ");
		String email=sc.nextLine();
		contact=new Contacts(firstName1,lastName1,address,city,state,zip,phone,email);
		list.add(contact);
		
		
	}

}