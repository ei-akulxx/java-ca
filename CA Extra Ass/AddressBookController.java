public class AddressBookController {
    private AddressBookModel model;
    private AddressBookView view;

    public AddressBookController(AddressBookModel model, AddressBookView view) {
        this.model = model;
        this.view = view;

        // Wire up the controller to the view
        view.displayContacts(model.getAllContacts());
    }

    public static void main(String[] args) {
        AddressBookModel model = new AddressBookModel();
        AddressBookView view = new AddressBookView(model);
        AddressBookController controller = new AddressBookController(model, view);
    }
}
