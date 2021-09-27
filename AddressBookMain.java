package com.AddressBook;

import java.util.List;

import java.util.Map;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AddressBookMain {
	static Map<String, AddressBook> addressBook = new HashMap<>();
	static Scanner r = new Scanner(System.in);

	/**
	 * This method lets the user to make choice.
	 */
	public static void main(String[] args) {
		System.out.println("Welcome to AddressBook program");

		final int EXIT = 11;

		int choice = 0;

		while (choice != EXIT) {

			System.out.println(
					"1 : Add AddressBook\n2 : Add Contact\n3 : Edit Contact\n4 : Delete Contact\n5 : Display Contact\n6 :"
							+ " Search by place\n7 :Sort by name\n8 :Sort by place\n9 Read from File\n10 Write to File"
							+ EXIT + " : to exit");
			Scanner r = new Scanner(System.in);
			Scanner sc = new Scanner(System.in);
			choice = r.nextInt();

			switch (choice) {
			case 1:
				addAddressBook();
				break;

			case 2:
				addContact();
				break;
			case 3:
				editContact();

				break;
			case 4:
				deleteContact();
				break;
			case 5:
				displayContact();
				break;
			case 6:
				searchPlace();
				break;
			case 7:
				sortByName();
				break;
			case 8:
				sortByPlace();
				break;
			case 9:
				readFile();
				break;
			case 10:
				writeToFile();
				break;

			case EXIT:
				System.exit(0);

			}

		}

	}

	/**
	 * Writes the contact in addressbook to file
	 */
	private static void writeToFile() {
		String basePath = "/Users/kshamavidyananda/eclipse-workspace/Address-Book/data";
		Scanner m = new Scanner(System.in);
		System.out.println("Enter the address book you wanna write");
		String fileName = m.next();
		AddressBook book = addressBook.get(fileName);
		if (book == null) {
			System.out.println("No book found");
			return;

		}
		addressBook.get(fileName).writeContact(basePath + "/" + fileName);
        System.out.println("Writing complted");
	}

	/**
	 * Reads the contact from file .
	 */
	private static void readFile() {
		String basePath = "/Users/kshamavidyananda/eclipse-workspace/Address-Book/data";
		Scanner m = new Scanner(System.in);
		System.out.println("Enter the address book you want to read");
		String filename = m.next();
		File file = new File(basePath + "/" + filename);
		if (!file.exists()) {
			System.out.println("Address book not found");
			return;
		}
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));

			AddressBook adBook = new AddressBook(filename);
			addressBook.put(filename, adBook);
			adBook.addContactFile(br);
			System.out.println("Reading completed");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Sorts the contacts in addressbook based on zipcode or city or state
	 */
	private static void sortByPlace() {
		System.out.println("How do you wanna sort\n1:By Zip code\n2: By City name\n3: By State name");
		Scanner m = new Scanner(System.in);
		int ch = m.nextInt();
		switch (ch) {
		case 1:
			for (Map.Entry<String, AddressBook> entry : addressBook.entrySet()) {
				AddressBook obj = entry.getValue();
				obj.sortZip();
			}
			break;
		case 2:
			for (Map.Entry<String, AddressBook> entry : addressBook.entrySet()) {
				AddressBook obj = entry.getValue();
				obj.sortCity();
			}
			break;
		case 3:
			for (Map.Entry<String, AddressBook> entry : addressBook.entrySet()) {
				AddressBook obj = entry.getValue();
				obj.sortState();
			}
			break;
		}

	}

	/**
	 * Sorts the contacts of addressbook based on name
	 */
	private static void sortByName() {
		for (Map.Entry<String, AddressBook> entry : addressBook.entrySet()) {
			AddressBook obj = entry.getValue();
			obj.sort();
		}

	}

	/**
	 * Searches for people in addressbook based on state or city name.
	 */
	private static void searchPlace() {
		Scanner m = new Scanner(System.in);
		System.out.println("Enter the 1:city\n 2 state name");
		int ch = m.nextInt();
		if (ch == 1) {
			Scanner r1 = new Scanner(System.in);
			System.out.println("Enter city name");
			String place = r1.nextLine();
			int count = 0;
			for (Map.Entry<String, AddressBook> entry : addressBook.entrySet()) {
				AddressBook obj = entry.getValue();
				count += obj.searchCity(place);
			}
			System.out.println(count + " contact found based on place of your choice");

		} else if (ch == 2) {
			Scanner r2 = new Scanner(System.in);
			System.out.println("Enter state name");
			String place = r2.nextLine();
			int count = 0;
			for (Map.Entry<String, AddressBook> entry : addressBook.entrySet()) {
				AddressBook obj = entry.getValue();
				count += obj.searchState(place);
			}
			System.out.println(count + " contact found based on place of your choice");

		}

	}

	/**
	 * Deletes the contact from the addressbook
	 */
	private static void deleteContact() {
		System.out.println("Enter the name of address book from which you want to delete");

		// Scanner r =new Scanner(System.in);
		String bookName = r.nextLine();
		AddressBook adBook = addressBook.get(bookName);
		if (adBook != null) {
			addressBook.get(bookName).deleteperson();
			;
		} else {
			System.out.println("Book name not found");
		}

	}

	/**
	 * Edits the details of person in particular addressbook
	 */
	private static void editContact() {
		System.out.println("Enter the name of address book to which you want to edit");

		String bookName = r.nextLine();
		AddressBook adBook = addressBook.get(bookName);
		if (adBook != null) {
			addressBook.get(bookName).editPerson();
		} else {
			System.out.println("Book name not found");
		}

	}

	/**
	 * Adds the new addressbook to system
	 */
	private static void addAddressBook() {
		System.out.println("Enter the name of new address book");

		String bookName = r.nextLine();

		AddressBook book = addressBook.get(bookName);
		if (book != null) {
			System.out.println("Already has a address book of that name");
		} else {

			AddressBook adBook = new AddressBook(bookName);
			addressBook.put(bookName, adBook);
		}

	}

	/**
	 * Displays the chosen addressbook
	 */
	private static void displayContact() {
		System.out.println("Enter the name of address book whose contacts you want to display");

		String bookName = r.nextLine();
		AddressBook adBook = addressBook.get(bookName);

		// System.out.println(adBook);
		if (adBook != null) {
			adBook.print();
		} else {
			System.out.println("Book name not found");
		}

	}

	/**
	 * Adds the contacts into addressbook
	 */
	private static void addContact() {

		System.out.println("Enter the name of Address book to which you want to add the contact");
		String adBook = r.nextLine();
		AddressBook Book = addressBook.get(adBook);
		if (Book == null) {
			System.out.println("No book found");

		} else {
			addressBook.get(adBook).addContact();
		}

	}
}