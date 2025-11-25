
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

// Component Interface (using built-in Java Iterator for simplicity)
interface OrganizationalComponent {
    void add(OrganizationalComponent component);
    // Method to get an iterator for the whole structure
    Iterator<String> createEmployeeIterator();
}

// Composite (Department)
class Department implements OrganizationalComponent {
    private String name;
    private List<OrganizationalComponent> children = new ArrayList<>();
    private List<String> employees = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    public void add(OrganizationalComponent component) {
        children.add(component);
    }
    
    public void addEmployee(String employeeName) {
        employees.add(employeeName);
    }

    @Override
    public Iterator<String> createEmployeeIterator() {
        // This is where the specific, complex iterator logic goes
        return new HierarchyIterator(children, employees);
    }
}

// Concrete Iterator for the Department Hierarchy
class HierarchyIterator implements Iterator<String> {
    // We use a Stack to perform a Depth-First Traversal of the tree structure
    private Stack<Iterator<String>> iterators = new Stack<>();

    public HierarchyIterator(List<OrganizationalComponent> children, List<String> employees) {
        // Start by pushing an iterator of the current department's employees
        iterators.push(employees.iterator());
        
        // Push iterators for child departments (if any)
        for (OrganizationalComponent child : children) {
            iterators.push(child.createEmployeeIterator());
        }
    }

    @Override
    public boolean hasNext() {
        // While the stack is not empty, check if the top iterator has elements
        if (iterators.empty()) {
            return false;
        } else {
            Iterator<String> iterator = iterators.peek();
            if (!iterator.hasNext()) {
                // If the top iterator is empty, pop it and check the next one
                iterators.pop();
                return hasNext(); // Recurse to find the next valid iterator
            } else {
                return true;
            }
        }
    }

    @Override
    public String next() {
        if (hasNext()) {
            return iterators.peek().next();
        }
        return null; // Or throw NoSuchElementException as per Iterator contract
    }
}

// Client Code (IteratorDemo)
public class IteratorDemo3 {
    public static void main(String[] args) {
        Department sales = new Department("Sales");
        sales.addEmployee("Alice (Sales)");
        sales.addEmployee("Bob (Sales)");

        Department engineering = new Department("Engineering");
        engineering.addEmployee("Charlie (Eng)");

        Department qa = new Department("QA");
        qa.addEmployee("David (QA)");
        engineering.add(qa); // QA is a sub-department of Engineering

        Department root = new Department("Root Organization");
        root.add(sales);
        root.add(engineering);

        // Client uses the universal Iterator interface without knowing the hierarchy structure
        Iterator<String> organizationIterator = root.createEmployeeIterator();

        System.out.println("Printing all employees in the entire organization:");
        while (organizationIterator.hasNext()) {
            System.out.println(organizationIterator.next());
        }
    }
}

/*
Why this uses the Iterator Pattern effectively:

Decoupling: 
The client code (DepartmentDemo) iterates over the entire complex hierarchy using a simple while(hasNext()) / next() loop. 
It has no knowledge of whether an item is in a root department, a nested sub-department, 
or how the tree traversal (Depth-First Search) is implemented internally.

Abstraction: 
The HierarchyIterator handles the complex logic of moving between the different levels and lists using a Stack, 
hiding that complexity from the user.


Encapsulation: The internal structure of the Department hierarchy can change 
(e.g., switching from a List to a Map or changing the traversal algorithm), 
but the client's iteration code remains exactly the same.
*/