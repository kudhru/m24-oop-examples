// Person.java
class Person {

    // fields of the object to build
    private final String name;   // required
    private final int age;       // optional
    private final String city;   // optional

    // private constructor uses Builder
    private Person(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.city = builder.city;
    }

    // static nested Builder class
    public static class Builder {
        // required
        private final String name;

        // optional (with default values)
        private int age = 0;
        private String city = "Unknown";

        // constructor for required fields
        public Builder(String name) {
            this.name = name;
        }

        // "setter" methods return Builder for chaining
        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        // build method creates the final Person object
        public Person build() {
            return new Person(this);
        }
    }

    // getters (no setters → immutable)
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getCity() { return city; }
}

// TestPerson.java
public class TestPerson {
    public static void main(String[] args) {
        Person.Builder builder = new Person.Builder("John");
        builder = builder.age(30)
                .city("San Francisco");
        Person p3 = builder.build();

        Person p1 = new Person.Builder("Alice")
                .age(25)
                .city("Pilani")
                .build();

        Person p2 = new Person.Builder("Bob")
                .build(); // only required field

        System.out.println(p1.getName() + ", " + p1.getAge() + ", " + p1.getCity());
        System.out.println(p2.getName() + ", " + p2.getAge() + ", " + p2.getCity());
    }
}
