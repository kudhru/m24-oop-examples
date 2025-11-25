package practiceproblems;

import java.util.ArrayList;
import java.util.List;

//=== SINGLETON ===
class DatabaseConnectionPool {
 private static DatabaseConnectionPool instance;
 private int activeConnections = 0;
 // Private constructor prevents instantiation
 private DatabaseConnectionPool() { System.out.println("Connection Pool Initialized."); }
 public static synchronized DatabaseConnectionPool getInstance() {
     if (instance == null) { instance = new DatabaseConnectionPool(); }
     return instance;
 }
 public void executeQuery(String sql) {
     System.out.println("[DB Log] Executing SQL: " + sql + " using shared pool.");
 }
}

//=== FACTORY ===
interface Product {
 void purchase();
}
class PhysicalProduct implements Product {
 private String name;
 public PhysicalProduct(String name) { this.name = name; }
 @Override
 public void purchase() { 
     System.out.println("Purchasing physical product: " + name + ". Needs shipping.");
     // Uses Singleton internally to log the purchase to DB
     DatabaseConnectionPool.getInstance().executeQuery("INSERT INTO purchases..."); 
 }
}
class DigitalProduct implements Product {
 // ... similar structure ...
	
	DigitalProduct(String name) {}
 @Override
 public void purchase() { System.out.println("Purchasing digital product. Instant download."); }
}

class ProductFactory {
 public Product createProduct(String type, String name) {
     if ("physical".equalsIgnoreCase(type)) {
         return new PhysicalProduct(name);
     } else if ("digital".equalsIgnoreCase(type)) {
         return new DigitalProduct(name);
     }
     return null;
 }
}

//=== BUILDER & CLIENT (Director) ===
class Order { // Complex object
 private String orderId, shippingAddress; List<String> items = new ArrayList<>();
 public void display() { System.out.println("Order " + orderId + " to " + shippingAddress + " with items: " + items); }
 public void setOrderId(String id) { this.orderId = id; }
 public void setAddress(String addr) { this.shippingAddress = addr; }
 public void addItem(String item) { this.items.add(item); }
}

interface OrderBuilder {
 void buildId();
 void buildAddress(String address);
 void buildItems(List<String> items);
 Order getResult();
}
//Concrete builder & client usage would follow the manufacturing example structure...
