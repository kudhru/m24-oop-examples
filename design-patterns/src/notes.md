## 1. Simple Factory

> Not a GoF pattern, but very common in real code.
> **One function/class decides which concrete class to instantiate.**

* Usually a **single class with a static method**.
* Uses `if/else` or `switch` to pick the implementation.
* Typically **one product hierarchy** (e.g., different kinds of `Shape` or `StorageService`).
* Goal: **move object creation out of client code**, centralize it.

### Example (Simple Factory – Storage only)

```java
interface StorageService {
    void upload(String fileName);
}

class S3Storage implements StorageService {
    public void upload(String fileName) {
        System.out.println("Uploading " + fileName + " to AWS S3");
    }
}

class BlobStorage implements StorageService {
    public void upload(String fileName) {
        System.out.println("Uploading " + fileName + " to Azure Blob Storage");
    }
}

// Simple Factory
class StorageFactory {
    static StorageService createStorage(String provider) {
        switch (provider.toLowerCase()) {
            case "aws":   return new S3Storage();
            case "azure": return new BlobStorage();
            default: throw new IllegalArgumentException("Unknown provider");
        }
    }
}

public class SimpleFactoryDemo {
    public static void main(String[] args) {
        StorageService storage = StorageFactory.createStorage("aws");
        storage.upload("report.pdf");
    }
}
```

**Important points:**

* Client only calls `StorageFactory.createStorage("aws")`, **no `new S3Storage()`** in client.
* Great when you just need **one type of object** and want a clean client.

---

## 2. Factory Method (GoF)

> **An abstract “creator” class defines a factory method; subclasses decide which concrete product to create.**

* Uses **inheritance + polymorphism**.
* An abstract class (or interface) has a **factory method** like `createNotification()`.
* Concrete subclasses **override** this method to return different products.
* Often used with a **template method**: base class defines an algorithm that uses the product created by the factory method.

### Example (Factory Method – Notifications)

```java
interface Notification {
    void notifyUser();
}

class EmailNotification implements Notification {
    public void notifyUser() {
        System.out.println("Sending EMAIL notification");
    }
}

class SMSNotification implements Notification {
    public void notifyUser() {
        System.out.println("Sending SMS notification");
    }
}

// Creator (abstract)
abstract class NotificationService {

    // factory method
    protected abstract Notification createNotification();

    // template method using product
    public void send() {
        Notification n = createNotification();
        n.notifyUser();
    }
}

// Concrete creators
class EmailNotificationService extends NotificationService {
    protected Notification createNotification() {
        return new EmailNotification();
    }
}

class SMSNotificationService extends NotificationService {
    protected Notification createNotification() {
        return new SMSNotification();
    }
}

public class FactoryMethodDemo {
    public static void main(String[] args) {
        NotificationService service = new EmailNotificationService();
        service.send();   // internally creates EmailNotification
    }
}
```

**Important points:**

* Client chooses **which creator subclass** to use (`new EmailNotificationService()`).
* The **base class** (`NotificationService`) doesn’t know which notification it will get; it just calls `createNotification()`.
* **No `switch` needed** in the base class; choice is pushed to subclasses via polymorphism.

---

## 3. Abstract Factory (GoF)

> Provide an interface for creating **families of related objects** (products), without specifying their concrete classes.

* A factory interface with **multiple factory methods**:

    * e.g. `createStorageService()`, `createMessageQueue()`.
* Each concrete factory produces a **family of related products**:

    * `AwsCloudFactory` → `S3Storage` + `SQSQueue`
    * `AzureCloudFactory` → `BlobStorage` + `ServiceBusQueue`
* Client uses **only the abstract factory**, not the concrete products.

### Example (Abstract Factory – Cloud family: Storage + Queue)

```java
interface StorageService {
    void upload(String fileName);
}

interface MessageQueue {
    void send(String message);
}

// AWS products
class S3Storage implements StorageService {
    public void upload(String fileName) {
        System.out.println("Uploading " + fileName + " to AWS S3");
    }
}
class SQSQueue implements MessageQueue {
    public void send(String msg) {
        System.out.println("Sending to AWS SQS: " + msg);
    }
}

// Azure products
class BlobStorage implements StorageService {
    public void upload(String fileName) {
        System.out.println("Uploading " + fileName + " to Azure Blob Storage");
    }
}
class ServiceBusQueue implements MessageQueue {
    public void send(String msg) {
        System.out.println("Sending to Azure Service Bus: " + msg);
    }
}

// Abstract Factory
interface CloudServicesFactory {
    StorageService createStorageService();
    MessageQueue createMessageQueue();
}

// Concrete factories (families)
class AwsCloudFactory implements CloudServicesFactory {
    public StorageService createStorageService() { return new S3Storage(); }
    public MessageQueue createMessageQueue()     { return new SQSQueue(); }
}
class AzureCloudFactory implements CloudServicesFactory {
    public StorageService createStorageService() { return new BlobStorage(); }
    public MessageQueue createMessageQueue()     { return new ServiceBusQueue(); }
}

// Client
class CloudApp {
    private final StorageService storage;
    private final MessageQueue queue;

    CloudApp(CloudServicesFactory factory) {
        this.storage = factory.createStorageService();
        this.queue = factory.createMessageQueue();
    }

    void run() {
        storage.upload("report.pdf");
        queue.send("New report uploaded");
    }
}

public class AbstractFactoryDemo {
    public static void main(String[] args) {
        CloudServicesFactory factory = new AwsCloudFactory(); // or new AzureCloudFactory()
        CloudApp app = new CloudApp(factory);
        app.run();
    }
}
```

**Important points:**

* `CloudApp` doesn’t know about S3 / Blob / SQS / ServiceBus, only:

    * `CloudServicesFactory`, `StorageService`, `MessageQueue`.
* `AwsCloudFactory` and `AzureCloudFactory` each produce a **consistent set** of products.
* Use abstract factory when you want to switch **the whole family** (AWS world ↔ Azure world) in one go.

---

## 4. Summary Table

| Pattern              | Main Idea                                              | Structure Key Point                                                  | What Varies?                                | Typical Use Case                                          |
| -------------------- | ------------------------------------------------------ | -------------------------------------------------------------------- | ------------------------------------------- | --------------------------------------------------------- |
| **Simple Factory**   | One function/class creates objects based on input      | One factory class with a static `createX(type)`                      | **Which concrete class** of one product     | Centralising `new` logic; avoiding repeated `if/else`     |
| **Factory Method**   | Base class defines factory method, subclasses decide   | Abstract *creator* with `createProduct()`; subclasses override       | **Which product** a subclass creates        | Frameworks where subclasses plug in their own products    |
| **Abstract Factory** | Interface for creating **families of related objects** | `Factory` interface with many methods, e.g. `createA()`, `createB()` | **Which family** of products (AWS vs Azure) | Cross-platform UIs, multi-cloud, theming, driver families |


* **Simple Factory** → “Give me one object of the right type.”
* **Factory Method** → “Let subclasses decide which object the algorithm uses.”
* **Abstract Factory** → “Give me an entire *family* of related objects from one place.”
