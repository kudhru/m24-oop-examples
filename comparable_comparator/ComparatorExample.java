// Example 2: Using Comparator Interface
// This example shows a separate Comparator class to sort based on custom criteria.
import java.util.*;

class Employee {
    private String name;
    private double salary;

    // Constructor to initialize the employee's name and salary
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // Getter method for name
    public String getName() {
        return name;
    }

    // Getter method for salary
    public double getSalary() {
        return salary;
    }

    // Override toString() method to provide a readable representation of the employee object
    @Override
    public String toString() {
        return "Employee{name='" + name + "', salary=" + salary + "}";
    }
}

class EmployeeComparatorBySalary implements Comparator<Employee> {

    @Override
    public int compare(Employee e1, Employee e2) {
        return Double.compare(e1.getSalary(), e2.getSalary());
    }
}

class EmployeeComparatorByName implements Comparator<Employee> {

    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.getName().compareTo(e2.getName());
    }
}

public class ComparatorExample {
    public static void main(String[] args) {
        // Create a list of employees
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 50000));
        employees.add(new Employee("Bob", 60000));
        employees.add(new Employee("Charlie", 45000));


        // Sorting using a custom Comparator (by salary)
//        Collections.sort(employees);
        Collections.sort(employees, new EmployeeComparatorBySalary());
        System.out.println("Sorted by salary (using Comparator): " + employees);
        Collections.sort(employees, new EmployeeComparatorByName());
        System.out.println("Sorted by name (using Comparator): " + employees);
//        Collections.sort(employees, (e1, e2) -> e1.getName().compareTo(e2.getName()));
//        Collections.sort(employees, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee e1, Employee e2) {
//                // Sort employees by salary in ascending order
//                return Double.compare(e1.getSalary(), e2.getSalary());
//            }
//        });

//        System.out.println("Sorted by salary (using Comparator): " + employees);

        // Sorting using a custom Comparator (by name) with a lambda expression
        employees.sort((e1, e2) -> e1.getName().compareTo(e2.getName()));
        System.out.println("Sorted by name (using Comparator with lambda): " + employees);
    }
}
