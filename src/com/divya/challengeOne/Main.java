package com.divya.challengeOne;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Contact> contacts;
    private static Scanner sc;
    private static int id = 0;

    public static void main(String[] args) {
        contacts = new ArrayList<>();
        System.out.println("Welcome");
        showInitialOptions();
    }

    private static void showInitialOptions() {
        sc = new Scanner(System.in);

        System.out.println("Please select one:\n" +
                               "\t1. Manage Contacts\n" +
                               "\t2. Messages\n" +
                               "\t3. Quit");

        int choice = sc.nextInt();

        switch (choice) {
            case 1 -> manageContacts();
            case 2 -> manageMessages();
            default -> {
            }
        }
    }

    private static void manageContacts() {
        System.out.println("Please select one:\n" +
                               "\t1. Show all contacts\n" +
                               "\t2. Add a new contact\n" +
                               "\t3. Search for a contact\n" +
                               "\t4. Delete a contact\n" +
                               "\t5. Go Back");

        int choice = sc.nextInt();

        switch (choice) {
            case 1 -> showAllContacts();
            case 2 -> addNewContact();
            case 3 -> searchForContact();
            case 4 -> deleteContact();
            default -> showInitialOptions();
        }
    }

    private static void showAllContacts() {
        for (Contact c : contacts) {
            c.getDetails();
            System.out.println("***********");
        }

        showInitialOptions();
    }

    private static void addNewContact() {
        System.out.println("Adding a new contact..." + "\n" +
                           "Please enter the contact's name: ");
        String name = sc.next();

        System.out.println("Please enter the contact's number: ");
        String number = sc.next();

        System.out.println("Please enter the contact's email: ");
        String email = sc.next();

        if (name.equals("") || number.equals("") || email.equals("")) {
            System.out.println("Please enter all information");
            addNewContact();
        } else {
            boolean doesExist = false;
            for (Contact c: contacts) {
                if (c.getName().equals(name)) {
                    doesExist = true;
                    break;
                }
            }

            if (doesExist) {
                System.out.println("We have a contact named " + name + " saved on this device");
                addNewContact();
            } else {
                Contact contact = new Contact(name, number, email);
                contacts.add(contact);
                System.out.println(name + " added successfully");
            }

            Contact contact = new Contact(name, number, email);
            contacts.add(contact);
        }

        showAllContacts();
    }

    private static void searchForContact() {
        System.out.println("Enter the contact name: ");
        String name = sc.next();
        if (name.equals("")) {
            System.out.println("Please enter the name: ");
            searchForContact();
        } else {
            boolean doesExist = false;
            for (Contact c: contacts) {
                if (c.getName().equals("")) {
                    doesExist = true;
                    c.getDetails();
                }
            }

            if (!doesExist) {
                System.out.println("There is no such contact in your phone");
            }
        }

        showAllContacts();
    }

    private static void deleteContact() {
        System.out.println("Please enter the contact's name: ");
        String name = sc.next();
        if (name.equals ("")) {
            System.out.println("Please enter the name");
            deleteContact();
        } else {
            boolean doesExist = false;
            for (Contact c: contacts) {
                if (c.getName().equals(name)) {
                    doesExist = true;
                    contacts.remove(c);
                }
            }

            if (!doesExist) {
                System.out.println("There is no such contact");
            }
        }

        showInitialOptions();
    }

    private static void manageMessages() {
        System.out.println("Please select one:\n" +
                               "\t1. Show all new messages\n" +
                               "\t2. Send a new message\n" +
                               "\t3. Go back");
        int choice = sc.nextInt();
        switch (choice) {
            case 1 -> showAllMessages();
            case 2 -> sendNewMessage();
            default -> showInitialOptions();
        }
    }

    private static void sendNewMessage() {
        System.out.println("Who are you going to send the message?");
        String name = sc.next();
        if (name.equals("")) {
            System.out.println("Please enter the name of the contact");
            sendNewMessage();
        } else {
            boolean doesExist = false;
            for (Contact c: contacts) {
                if (c.getName().equals(name)) {
                    doesExist = true;
                }
            }

            if (doesExist) {
                System.out.println("What are you going to say?");
                String text = sc.next();
                if (text.equals("")) {
                    System.out.println("Please enter some message");
                    sendNewMessage();
                } else {
                    id++;
                    Message newMessage = new Message(text, name, id);
                    for (Contact c: contacts) {
                        if (c.getName().equals(name)) {
                            ArrayList<Message> newMessages = c.getMessages();
                            newMessages.add(newMessage);
                            c.setMessages(newMessages);
                        }
                    }
                }
            } else {
                System.out.println("There is no such contact");
            }
        }
        showInitialOptions();
    }

    private static void showAllMessages() {
        if (contacts.size() > 0) {
            for (Contact c: contacts) {
                c.getDetails();
                System.out.println("***********");
            }

            showInitialOptions();
        } else {
            System.out.println("You do not have any contact");
            showInitialOptions();
        }
    }
}