// Person.java
class Person1 {

    // fields of the object to build
    private final String name;   // required
    private final int age;       // optional
    private final String city;   // optional

    public Person1(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public Person1(String name) {
        this(name, 0, "unknown");
    }

    public Person1(String name, int age) {
        this(name, age, "unknown");
    }

    public Person1(String name, String city) {
        this(name, 0, city);
    }


    // getters (no setters → immutable)
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getCity() { return city; }

}

// TestPerson.java
public class TestWithoutBuilder {
    public static void main(String[] args) {
        Person1 person = new Person1("John Doe", 20, "Mumbai");
        System.out.println(person.getName() + " " + person.getAge() + " " + person.getCity());
    }
}
