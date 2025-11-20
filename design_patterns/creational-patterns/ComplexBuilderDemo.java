import java.util.ArrayList;
import java.util.List;

// Abstract Product Base Class
abstract class Address {
    protected String name;
    public Address(String name) { this.name = name; }
}

class Person extends Address {
    String firstName;
    String lastName;
    String company;
    String email;
    String phone;
    // Constructor and getters...
    public Person(String firstName, String lastName, String company, String email, String phone) {
        super(firstName + " " + lastName);
        this.firstName = firstName; this.lastName = lastName; this.company = company; this.email = email; this.phone = phone;
    }
}

class Group extends Address {
    String purpose;
    List<String> members = new ArrayList<>();
    // Constructor and getters...
    public Group(String name, String purpose, List<String> members) {
        super(name);
        this.purpose = purpose; this.members = members;
    }
}

// UI Product (The complex object being built)
class AddressUI {
    private StringBuilder display = new StringBuilder();

    public void addWidget(String widgetText) {
        display.append(widgetText).append("\n");
    }

    public void display() {
        System.out.println("--- Displaying Address UI ---");
        System.out.println(display.toString());
        System.out.println("-----------------------------\n");
    }
}

// Abstract Builder Interface
interface UIBuilder {
    void buildHeader(String title);
    void buildDetails(Address data);
    AddressUI getUI();
}

// Concrete Builder for Person UI
class PersonUIBuilder implements UIBuilder {
    private AddressUI ui = new AddressUI();

    @Override
    public void buildHeader(String title) {
        ui.addWidget("Title: " + title);
    }

    @Override
    public void buildDetails(Address data) {
        if (data instanceof Person) {
            Person p = (Person) data;
            ui.addWidget("First Name: " + p.firstName);
            ui.addWidget("Last Name: " + p.lastName);
            ui.addWidget("Company: " + p.company);
            ui.addWidget("Email: " + p.email);
            ui.addWidget("Phone: " + p.phone);
        }
    }

    @Override
    public AddressUI getUI() {
        return ui;
    }
}

// Concrete Builder for Group UI
class GroupUIBuilder implements UIBuilder {
    private AddressUI ui = new AddressUI();

    @Override
    public void buildHeader(String title) {
        ui.addWidget("Group Name: " + title);
    }

    @Override
    public void buildDetails(Address data) {
        if (data instanceof Group) {
            Group g = (Group) data;
            ui.addWidget("Purpose: " + g.purpose);
            ui.addWidget("Members List:");
            for (String member : g.members) {
                ui.addWidget("  - " + member);
            }
        }
    }

    @Override
    public AddressUI getUI() {
        return ui;
    }
}

// Director Class
class UIDirector {
    public void constructUI(Address data, UIBuilder builder) {
        builder.buildHeader(data.name);
        builder.buildDetails(data);
    }
}

// Demo Class
public class ComplexBuilderDemo {
    public static void main(String[] args) {
        UIDirector director = new UIDirector();

        // Create data objects
        Person alice = new Person("Alice", "Smith", "Tech Corp", "alice@example.com", "555-1234");
        Group teamA = new Group("Team Alpha", "Project Development", List.of("Alice Smith", "Bob Jones"));

        // Build and display Person UI
        PersonUIBuilder personBuilder = new PersonUIBuilder();
        director.constructUI(alice, personBuilder);
        AddressUI personUI = personBuilder.getUI();
        personUI.display();

        // Build and display Group UI
        GroupUIBuilder groupBuilder = new GroupUIBuilder();
        director.constructUI(teamA, groupBuilder);
        AddressUI groupUI = groupBuilder.getUI();
        groupUI.display();
    }
}
