class Address implements Cloneable {
    private String city;
    private int houseNo;

    public Address(String city, int houseNo) {
        this.city = city;
        this.houseNo = houseNo;
    }

    public String getCity() {
        return city;
    }

    public int getHouseNo() {
    	return houseNo;
    }
    
    public void setCity(String city) {
        this.city = city;
    }

    public void setHouseNo(int houseNo) {
    	this.houseNo = houseNo;
    }
    
    @Override
    public String toString() {
        return "Address{city='" + city + "' & house number=" + houseNo + "}";
    }

    // A method to perform a deep copy of the Address object
    public Address deepClone() throws CloneNotSupportedException {
        return (Address) super.clone(); // Shallow clone of Address is deep enough since it only contains a String
    }
}
class Customer implements Cloneable {
    private int id;
	private String name; // Immutable field
    private Address address; // Mutable field

    public Customer(int id, String name, Address address) {
        this.id = id;
    	this.name = name;
        this.address = address;
    }

    // Getters and Setters (omitted for brevity)

    @Override
    // Shallow cloning using super.clone()
    public Customer clone() throws CloneNotSupportedException {
        return (Customer) super.clone();
    }

    // Deep cloning implementation
    public Customer deepClone() throws CloneNotSupportedException {
        Customer clonedCustomer = (Customer) super.clone(); // Shallow copy first
        // Then, create a new copy of the mutable field (Address) and set it
        clonedCustomer.address = address.deepClone(); 
        return clonedCustomer;
    }
    
    @Override
    public String toString() {
        return "Customer{id = " + id + " name='" + name + "', address=" + address + '}';
    }

    public Address getAddress() {
        return address;
    }
    
    public String getName() {
        return name;
    }
    
    public int getId() {
    	return id;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public void setId(int id) {
    	this.id = id;
    }
}
public class CloningDemo {

    public static void main(String[] args) throws CloneNotSupportedException {
        Address originalAddress = new Address("New York",5);
        Customer originalCustomer = new Customer(1,"Alice", originalAddress);

        // --- Demo 1: Shallow Cloning ---
        System.out.println("--- Shallow Cloning Demo ---");
        Customer shallowClone = originalCustomer.clone();
        
        System.out.println("Original: " + originalCustomer);
        System.out.println("Shallow Clone: " + shallowClone);
        
        // Modify the city in the *original* object's address
        originalCustomer.getAddress().setCity("San Francisco");
        originalCustomer.getAddress().setHouseNo(20);
        
        System.out.println("\nAfter modifying original customer's address:");
        System.out.println("Original: " + originalCustomer);
        System.out.println("Shallow Clone: " + shallowClone); 
        // Both objects now have "San Francisco" because they share the same Address object
        System.out.println("Shared Address Object? " + (originalCustomer.getAddress() == shallowClone.getAddress()));


        // --- Demo 2: Deep Cloning ---
        System.out.println("\n--- Deep Cloning Demo ---");
        Address originalAddress2 = new Address("London",7);
        Customer originalCustomer2 = new Customer(2, "Bob", originalAddress2);

        Customer deepClone = originalCustomer2.deepClone();

        System.out.println("Original: " + originalCustomer2);
        System.out.println("Deep Clone: " + deepClone);

        // Modify the city in the *original* object's address
        originalCustomer2.getAddress().setCity("Paris");
        originalCustomer2.getAddress().setHouseNo(10);

        System.out.println("\nAfter modifying original customer's address:");
        System.out.println("Original: " + originalCustomer2);
        System.out.println("Deep Clone: " + deepClone); 
        // Only the original is "Paris"; the clone remains "London"
        System.out.println("Shared Address Object? " + (originalCustomer2.getAddress() == deepClone.getAddress()));
        
        System.out.println("------------more experiment--------------");
        originalCustomer.setName("shallow");
        originalCustomer2.setName("deep");
        
        System.out.println(originalCustomer.getName() + " " + shallowClone.getName());
        System.out.println(originalCustomer2.getName() + " " + deepClone.getName());
    
        originalCustomer.setId(100);
        originalCustomer2.setId(200);
        
        System.out.println(originalCustomer.getId() + " " + shallowClone.getId());
        System.out.println(originalCustomer2.getId() + " " + deepClone.getId());
    }
}
