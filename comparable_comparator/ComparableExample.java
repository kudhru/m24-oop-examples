// Example 1: Using Comparable Interface
// This example shows a class implementing Comparable to sort based on a single natural order.
import java.util.*;

class Student implements Comparable<Student> {
    private String name;
    private int grade;

    // Constructor to initialize the student's name and grade
    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    // Getter method for name
    public String getName() {
        return name;
    }

    // Getter method for grade
    public int getGrade() {
        return grade;
    }

    // Implementing the compareTo method from Comparable interface
    public int compareTo(Student other) {
        // Sort students by grade in ascending order
        if(this.getGrade() < other.getGrade())
            return -1;
        else if (this.getGrade() > other.getGrade())
            return 1;
        else
            return 0;
    }

    // Override toString() method to provide a readable representation of the student object
    @Override
    public String toString() {
        return "Student{name='" + name + "', grade=" + grade + "}";
    }
}

public class ComparableExample {
    public static void main(String[] args) {
        // Create a list of students
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 85));
        students.add(new Student("Bob", 90));
        students.add(new Student("Charlie", 80));

        // Sorting using Comparable
//        Collections.sort(students);
        // first sort using name
        Collections.sort(students);

        // a new sort using grade
        Collections.sort(students);
//        Student s1 = students.get(0);
//        Student s2 = students.get(1);
//        s1.compareTo(s2);
        System.out.println("Sorted by grade (using Comparable): " + students);
    }
}