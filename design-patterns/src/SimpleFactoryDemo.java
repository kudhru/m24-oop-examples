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
        String storage_provider = args[0];
        StorageService storage = StorageFactory.createStorage(storage_provider);
        storage.upload("report.pdf");
    }
}
