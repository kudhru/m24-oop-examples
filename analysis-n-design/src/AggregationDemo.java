/*
2. Aggregation (Has-A Relationship - Weak)
Aggregation represents a "has-a" relationship where one class contains a reference to another class, 
but the contained object can exist independently of the container. 
It's a weaker form of association than composition.

Instance Variable (Reference): The aggregating class holds a reference to an object of the aggregated class, 
typically passed in through the constructor or a setter method.
*/

class Address {
    String street;
    String city;

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }
}

class Employee {
    int id;
    String name;
    Address address; // Aggregation: Employee has an Address

    public Employee(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}


public class AggregationDemo {
	public void main() {

		// Client code
		Address homeAddress = new Address("123 Main St", "Anytown");
		Employee emp = new Employee(101, "John Doe", homeAddress);
		// homeAddress can exist even if emp is destroyed.
	}
}
