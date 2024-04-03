import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

// View class for GUI
class AddressBookView extends JFrame {
    private AddressBookModel model;
    private JTextField nameField, phoneField, emailField, addressField, companyField;
    private JTextArea displayArea;

    public AddressBookView(AddressBookModel model) {
        this.model = model;

        setTitle("Address Book");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6, 2));

        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Phone Number:"));
        phoneField = new JTextField();
        inputPanel.add(phoneField);

        inputPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        inputPanel.add(emailField);

        inputPanel.add(new JLabel("Address:"));
        addressField = new JTextField();
        inputPanel.add(addressField);

        inputPanel.add(new JLabel("Company:"));
        companyField = new JTextField();
        inputPanel.add(companyField);

        JButton addButton = new JButton("Add Contact");
        addButton.addActionListener(new AddButtonListener());
        inputPanel.add(addButton);

        JButton displayButton = new JButton("Display All");
        displayButton.addActionListener(new DisplayButtonListener());
        inputPanel.add(displayButton);

        mainPanel.add(inputPanel, BorderLayout.NORTH);

        displayArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(displayArea);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        getContentPane().add(mainPanel);
        setVisible(true);
    }

    public void displayContacts(List<Contact> contacts) {
        StringBuilder displayText = new StringBuilder();
        for (Contact contact : contacts) {
            displayText.append(contact.name).append("\n");
        }
        displayArea.setText(displayText.toString());
    }

    private class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();
            String address = addressField.getText();
            String company = companyField.getText();

            if (!name.isEmpty() && !phone.isEmpty() && !email.isEmpty() && !address.isEmpty()) {
                if (company.isEmpty()) {
                    model.addContact(new PersonalContact(name, phone, email, address));
                } else {
                    model.addContact(new BusinessContact(name, phone, email, address, company));
                }
                JOptionPane.showMessageDialog(null, "Contact added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                clearFields();
            } else {
                JOptionPane.showMessageDialog(null, "Please fill all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        private void clearFields() {
            nameField.setText("");
            phoneField.setText("");
            emailField.setText("");
            addressField.setText("");
            companyField.setText("");
        }
    }

    private class DisplayButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            displayContacts(model.getAllContacts());
        }
    }
}
