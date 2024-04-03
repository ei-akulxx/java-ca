import java.io.Serializable;

// Interface for contactable objects
interface Contactable {
    void display();
}

// Abstract class for Contact
abstract class Contact implements Contactable, Serializable {
    protected String name;
    protected String phoneNumber;
    protected String email;
    protected String address;

    public Contact(String name, String phoneNumber, String email, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    // Abstract method for displaying contact details
    public abstract void display();
}

// Concrete class representing a personal contact
class PersonalContact extends Contact {
    public PersonalContact(String name, String phoneNumber, String email, String address) {
        super(name, phoneNumber, email, address);
    }

    @Override
    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Email: " + email);
        System.out.println("Address: " + address);
        System.out.println();
    }
}

// Concrete class representing a business contact
class BusinessContact extends Contact {
    private String company;

    public BusinessContact(String name, String phoneNumber, String email, String address, String company) {
        super(name, phoneNumber, email, address);
        this.company = company;
    }

    @Override
    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Email: " + email);
        System.out.println("Address: " + address);
        System.out.println("Company: " + company);
        System.out.println();
    }
}
