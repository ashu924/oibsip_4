import java.util.ArrayList;
import java.util.List;

class Contact {

    // Constructor and other methods remain the same as before
    // ...
}

public class WhatsAppContactListGUI extends Application {
    private List<Contact> contacts;
    private TextField nameField;
    private TextField phoneNumberField;

    public WhatsAppContactListGUI() {
        contacts = new ArrayList<>();
        nameField = new TextField();
        phoneNumberField = new TextField();
    }

    // Rest of the class remains the same as before
    // ...

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("WhatsApp Contact List");

        Label nameLabel = new Label("Name:");
        Label phoneNumberLabel = new Label("Phone Number:");

        Button addButton = new Button("Add Contact");
        addButton.setOnAction(e -> addContact());

        Button searchButton = new Button("Search Contact");
        searchButton.setOnAction(e -> searchContact());

        Button updateButton = new Button("Update Contact");
        updateButton.setOnAction(e -> updateContact());

        Button displayButton = new Button("Display Contacts");
        displayButton.setOnAction(e -> displayContacts());

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(nameLabel, nameField, phoneNumberLabel, phoneNumberField,
                addButton, searchButton, updateButton, displayButton);

        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Rest of the class remains the same as before
    // ...

    public static void main(String[] args) {
        launch(args);
    }
}
