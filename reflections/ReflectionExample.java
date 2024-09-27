import java.lang.reflect.*;

class Person {
    private String name;
    private int age;

    public Person() {
        this.name = "Unknown";
        this.age = 0;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private void privateMethod() {
        System.out.println("Private method called");
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
}

public class ReflectionExample {
    public static void main(String[] args) {
        try {
            // 1. Getting Class Information
            Class<?> personClass = Class.forName("Person");
            System.out.println("Class Name: " + personClass.getName());

            // 2. Accessing Constructors
            Constructor<?>[] constructors = personClass.getConstructors();
            System.out.println("Constructors:");
            for (Constructor<?> constructor : constructors) {
                System.out.println(constructor);
                System.out.println(constructor.getParameterTypes());
            }

            // 3. Instantiating an Object Using Reflection
            Constructor<?> constructor = personClass.getConstructor(String.class, int.class);
            Object personObj = constructor.newInstance("Alice", 30);
            System.out.println("Instantiated Object: " + personObj);

            // 4. Accessing Fields
            Field[] fields = personClass.getDeclaredFields();
            System.out.println("Fields:");
            for (Field field : fields) {
                System.out.println(field.getName() + " - Type: " + field.getType());
            }

            // Accessing a field value and modifying it
            Field nameField = personClass.getDeclaredField("name");
//            System.out.println("Original Name: " + nameField.get(personObj));
            nameField.setAccessible(true); // Make private field accessible
            System.out.println("Original Name: " + nameField.get(personObj));
            nameField.set(personObj, "Bob");
            System.out.println("Modified Name: " + nameField.get(personObj));

            Field nameField1 = personClass.getDeclaredField("name");
            nameField1.setAccessible(true); // Make private field accessible
            System.out.println("Original Name: " + nameField1.get(personObj));

            // 5. Accessing and Invoking Methods
            Method getNameMethod = personClass.getMethod("getName");
            String name = (String) getNameMethod.invoke(personObj);
            System.out.println("Name from getName(): " + name);

            Method getAgeMethod = personClass.getMethod("getAge");
            int age = (int) getAgeMethod.invoke(personObj);
            System.out.println("Original Age from getAge(): " + age);
            Method setAgeMethod = personClass.getMethod("setAge", int.class);
            setAgeMethod.invoke(personObj, 35);
            age = (int) getAgeMethod.invoke(personObj);
            System.out.println("Modified Age from getAge(): " + age);

            // 6. Accessing Private Methods
            Method privateMethod = personClass.getDeclaredMethod("privateMethod");
            privateMethod.setAccessible(true); // Make private method accessible
            privateMethod.invoke(personObj); // Calling private method

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
