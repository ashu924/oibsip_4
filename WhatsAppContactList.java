import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return name + " : " + phoneNumber;
    }
}

public class WhatsAppContactList {
    private List<Contact> contacts;
    private Scanner scanner;

    public WhatsAppContactList() {
        contacts = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void removeContact(Contact contact) {
        contacts.remove(contact);
    }

    public void displayContacts() {
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    public Contact searchContact(String searchQuery) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(searchQuery) || contact.getPhoneNumber().equals(searchQuery)) {
                return contact;
            }
        }
        return null; // Contact not found
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int index = contacts.indexOf(oldContact);
        if (index != -1) {
            contacts.set(index, newContact);
            return true; // Contact updated successfully
        }
        return false; // Contact not found
    }

    public Contact createContactFromUserInput() {
        System.out.print("Enter the name of the contact: ");
        String name = scanner.nextLine();

        System.out.print("Enter the phone number of the contact: ");
        String phoneNumber = scanner.nextLine();

        return new Contact(name, phoneNumber);
    }

    public static void main(String[] args) {
        WhatsAppContactList whatsappList = new WhatsAppContactList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== WhatsApp Contact List Menu =====");
            System.out.println("1. Add a new contact");
            System.out.println("2. Search for a contact");
            System.out.println("3. Update contact information");
            System.out.println("4. Display all contacts");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    Contact newContact = whatsappList.createContactFromUserInput();
                    whatsappList.addContact(newContact);
                    System.out.println("Contact added successfully.");
                    break;
                case 2:
                    System.out.print("Enter the name or phone number to search: ");
                    String searchQuery = scanner.nextLine();
                    Contact foundContact = whatsappList.searchContact(searchQuery);
                    if (foundContact != null) {
                        System.out.println("Contact found: " + foundContact);
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter the name or phone number of the contact to update: ");
                    String updateQuery = scanner.nextLine();
                    Contact oldContact = whatsappList.searchContact(updateQuery);
                    if (oldContact != null) {
                        Contact updatedContact = whatsappList.createContactFromUserInput();
                        boolean isUpdated = whatsappList.updateContact(oldContact, updatedContact);
                        if (isUpdated) {
                            System.out.println("Contact updated successfully.");
                        } else {
                            System.out.println("Contact update failed.");
                        }
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;
                case 4:
                    System.out.println("WhatsApp Contact List:");
                    whatsappList.displayContacts();
                    break;
                case 5:
                    System.out.println("Exiting the WhatsApp Contact List.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
