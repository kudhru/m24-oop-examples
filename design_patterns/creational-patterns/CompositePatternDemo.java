/*
Here is a simple example using the theme of a company organizational structure: 
Employees (leaf nodes) and Managers (composite nodes) are both treated as EmployeeComponent types.
*/

import java.util.ArrayList;
import java.util.List;

// 1. Component Interface
// Defines the common operations for both simple (leaf) and complex (composite) objects.
interface EmployeeComponent {
    void showDetails();
}

// 2. Leaf Class
// Represents the simple objects (e.g., individual employees) in the composition.
class Developer implements EmployeeComponent {
    private String name;
    private String position;

    public Developer(String name, String position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public void showDetails() {
        System.out.println("  Developer: " + name + " (" + position + ")");
    }
}

// 3. Composite Class
// Represents complex objects (e.g., managers/departments) that can have children (employees or other managers).
class Manager implements EmployeeComponent {
    private String name;
    private String position;
    // The key feature: a list of child components
    private List<EmployeeComponent> subordinates = new ArrayList<>();

    public Manager(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public void addSubordinate(EmployeeComponent emp) {
        subordinates.add(emp);
    }

    public void removeSubordinate(EmployeeComponent emp) {
        subordinates.remove(emp);
    }

    @Override
    public void showDetails() {
        System.out.println("Manager: " + name + " (" + position + ")");
        // Iterate over children and call their showDetails() method
        for (EmployeeComponent emp : subordinates) {
            emp.showDetails();
        }
    }
}

// 4. Demo Class (Client Code)
public class CompositePatternDemo {
    public static void main(String[] args) {
        // Create individual employees (Leafs)
        EmployeeComponent dev1 = new Developer("Alice", "Senior Developer");
        EmployeeComponent dev2 = new Developer("Bob", "Junior Developer");
        EmployeeComponent dev3 = new Developer("Charlie", "QA Engineer");

        // Create a Team Lead/Manager (Composite)
        Manager engineeringManager = new Manager("David", "Engineering Manager");
        // Add individual developers as subordinates
        engineeringManager.addSubordinate(dev1);
        engineeringManager.addSubordinate(dev2);

        // Create another manager/CTO (Composite)
        Manager cto = new Manager("Eva", "Chief Technical Officer");
        // The CTO has another manager as a subordinate (demonstrating nesting)
        cto.addSubordinate(engineeringManager);
        cto.addSubordinate(dev3); // CTO also manages QA directly

        // The client interacts with the top-level component uniformly:
        System.out.println("--- Full Organizational Structure ---");
        cto.showDetails();
    }
}
