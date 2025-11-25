interface StorageService1 {
    void upload(String fileName);
}

interface MessageQueue {
    void send(String message);
}

// AWS products
class S3Storage1 implements StorageService1 {
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
class BlobStorage1 implements StorageService1 {
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
    StorageService1 createStorageService();
    MessageQueue createMessageQueue();
}

// Concrete factories (families)
class AwsCloudFactory implements CloudServicesFactory {
    public StorageService1 createStorageService() { return new S3Storage1(); }
    public MessageQueue createMessageQueue()     { return new SQSQueue(); }
}
class AzureCloudFactory implements CloudServicesFactory {
    public StorageService1 createStorageService() { return new BlobStorage1(); }
    public MessageQueue createMessageQueue()     { return new ServiceBusQueue(); }
}

// Client
class CloudApp {
    private final StorageService1 storage;
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
