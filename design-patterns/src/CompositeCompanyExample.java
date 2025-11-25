import java.util.ArrayList;
import java.util.List;

public class CompositeCompanyExample {

    // ----- Component -----
    interface EmployeeComponent {
        String getName();
        double getSalary();
        void printStructure(String indent);
    }

    // ----- Leaf: Individual Employee -----
    static class Employee implements EmployeeComponent {

        private final String name;
        private final String role;
        private final double salary;

        public Employee(String name, String role, double salary) {
            this.name = name;
            this.role = role;
            this.salary = salary;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public double getSalary() {
            return salary;
        }

        @Override
        public void printStructure(String indent) {
            System.out.println(indent + "- " + name + " (" + role + "), salary: " + salary);
        }
    }

    // ----- Composite: Manager with subordinates -----
    static class Manager implements EmployeeComponent {

        private final String name;
        private final String role;
        private final double salary;
        private final List<EmployeeComponent> subordinates = new ArrayList<>();

        public Manager(String name, String role, double salary) {
            this.name = name;
            this.role = role;
            this.salary = salary;
        }

        public void add(EmployeeComponent e) {
            subordinates.add(e);
        }

        public void remove(EmployeeComponent e) {
            subordinates.remove(e);
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public double getSalary() {
            // total salary = manager's own salary + all subordinates
            double total = salary;
            for (EmployeeComponent e : subordinates) {
                total += e.getSalary();
            }
            return total;
        }

        @Override
        public void printStructure(String indent) {
            System.out.println(indent + "+ " + name + " (" + role + "), total team salary: " + getSalary());
            for (EmployeeComponent e : subordinates) {
                e.printStructure(indent + "   ");
            }
        }
    }

    // ----- Client demo -----
    public static void main(String[] args) {

        // Individual employees (leaves)
        EmployeeComponent dev1 = new Employee("Alice", "Developer", 80000);
        EmployeeComponent dev2 = new Employee("Bob", "Developer", 75000);
        EmployeeComponent qa1  = new Employee("Charlie", "QA Engineer", 70000);
        EmployeeComponent hr1  = new Employee("Diana", "HR", 65000);

        // Managers (composites)
        Manager engManager = new Manager("Eve", "Engineering Manager", 100000);
        engManager.add(dev1);
        engManager.add(dev2);
        engManager.add(qa1);

        Manager hrManager = new Manager("Frank", "HR Manager", 90000);
        hrManager.add(hr1);

        Manager ceo = new Manager("Grace", "CEO", 200000);
        ceo.add(engManager);
        ceo.add(hrManager);

        // Use the composite
        ceo.printStructure("");
        System.out.println("\nTotal salary under CEO: " + ceo.getSalary());
    }
}
