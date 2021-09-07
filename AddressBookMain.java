package com.AddressBook;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AddressBookMain {
	static Map<String,AddressBook> addressBook = new HashMap<>();
	static Scanner scanner =new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Welcome to AddressBook program");

		final int EXIT = 6;

		int option = 0;

		while (option != EXIT) {

			System.out.println("1 : Add AddressBook\n2 : Add Contact\n3 : Edit Contact\n4 : Delete Contact\n5 : Display Contact\n"+
					EXIT + " : to exit");
			Scanner scanner = new Scanner(System.in);
			Scanner sc = new Scanner(System.in);
			option = scanner.nextInt();

			switch (option) {
			case 1:
				addAddressBook();
				break;
			
			case 2:
				addContact();
				break;
			case 3:editContact();
				
				break;
			case 4:deleteContact();
				break;
			case 5:
				displayContact();
				break;
			
			case EXIT:
				System.exit(0);

			}

		}

	}

	private static void deleteContact() {
		System.out.println("Enter the name of address book from which you want to delete");

		
		String bookName=scanner.nextLine();
		AddressBook adrBook=addressBook.get(bookName);
		if(adrBook != null) {
			addressBook.get(bookName).deleteperson();;
		}
		else {
		System.out.println("Book name not found");
		}
		
	}

	private static void editContact() {
		System.out.println("Enter the name of address book to which you want to edit");

	
		String bookName=scanner.nextLine();
		AddressBook adrBook=addressBook.get(bookName);
		if(adrBook != null) {
			addressBook.get(bookName).editPerson();
		}
		else {
		System.out.println("Book name not found");
		}
		
		
	}

	private static void addAddressBook() {
		System.out.println("Enter the name of new address book");

		
		String bookName = scanner.nextLine();
		
		AddressBook book = addressBook.get(bookName);
		if(book == null) {
			AddressBook adrBook=new AddressBook(bookName);
			addressBook.put(bookName, adrBook);
			
		}
		else {
			System.out.println("Already has a address book of that name");
		
		}
		
	}
	
	private static void displayContact() {
		System.out.println("Enter the name of address book whose contacts to display");

		
		String bookName=scanner.nextLine();
		AddressBook adrBook=addressBook.get(bookName);
		
		
		if(adrBook == null) {
			System.out.println("Book name not found");
		}
		else {
			adrBook.print();
		
		}

	}
	private static void addContact() {
		
		
		System.out.println("Enter the name of Address book to which you to add the contact");
	
		String adrBook = scanner.nextLine();
		AddressBook Book=addressBook.get(adrBook);
		if(Book == null)
		{
		
			System.out.println("No book found");
			
		}
		else
		{
			addressBook.get(adrBook).addContact();
			
		}

	}
	
	
}