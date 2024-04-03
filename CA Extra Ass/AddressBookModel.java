import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Class for storing and managing contacts
class AddressBookModel {
    private List<Contact> contacts;

    public AddressBookModel() {
        contacts = new ArrayList<>();
    }

    // Method to add a new contact
    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    // Method to display all contacts
    public List<Contact> getAllContacts() {
        return contacts;
    }

    // Method to search for a contact by name
    public Contact searchContact(String name) {
        for (Contact contact : contacts) {
            if (contact.name.equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }

    // Method to delete a contact by name
    public void deleteContact(String name) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).name.equalsIgnoreCase(name)) {
                contacts.remove(i);
                break;
            }
        }
    }

    // Method to save address book to a file
    public void saveToFile(String filename) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            outputStream.writeObject(contacts);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to load address book from a file
    @SuppressWarnings("unchecked")
    public void loadFromFile(String filename) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) {
            contacts = (List<Contact>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
