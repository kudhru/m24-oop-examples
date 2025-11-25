// ===== Without Decorator: subclasses for each variation =====

interface DataSource {
    void writeData(String data);
    String readData();
}

// Base class – writes plain data
class FileDataSource implements DataSource1 {
    private String fileName;
    private String storage; // simulate file storage as a String

    public FileDataSource(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void writeData(String data) {
        System.out.println("FileDataSource: writing plain data to " + fileName);
        storage = data;
    }

    @Override
    public String readData() {
        System.out.println("FileDataSource: reading plain data from " + fileName);
        return storage;
    }
}

// Now we want ENCRYPTION
class EncryptedFileDataSource extends FileDataSource1 {

    public EncryptedFileDataSource(String fileName) {
        super(fileName);
    }

    @Override
    public void writeData(String data) {
        String encrypted = "[ENC]" + data + "[/ENC]"; // fake encryption
        System.out.println("EncryptedFileDataSource: encrypting data");
        super.writeData(encrypted);
    }

    @Override
    public String readData() {
        String encrypted = super.readData();
        System.out.println("EncryptedFileDataSource: decrypting data");
        // fake decrypt: strip tags
        return encrypted.replace("[ENC]", "").replace("[/ENC]", "");
    }
}

// Now we want COMPRESSION
class CompressedFileDataSource extends FileDataSource1 {

    public CompressedFileDataSource(String fileName) {
        super(fileName);
    }

    @Override
    public void writeData(String data) {
        String compressed = "[ZIP]" + data + "[/ZIP]"; // fake compression
        System.out.println("CompressedFileDataSource: compressing data");
        super.writeData(compressed);
    }

    @Override
    public String readData() {
        String compressed = super.readData();
        System.out.println("CompressedFileDataSource: decompressing data");
        return compressed.replace("[ZIP]", "").replace("[/ZIP]", "");
    }
}

// What about ENCRYPTED + COMPRESSED?
class EncryptedCompressedFileDataSource extends FileDataSource1 {

    public EncryptedCompressedFileDataSource(String fileName) {
        super(fileName);
    }

    @Override
    public void writeData(String data) {
        System.out.println("EncryptedCompressedFileDataSource: compressing, then encrypting");
        String compressed = "[ZIP]" + data + "[/ZIP]";
        String encrypted = "[ENC]" + compressed + "[/ENC]";
        super.writeData(encrypted);
    }

    @Override
    public String readData() {
        String encrypted = super.readData();
        System.out.println("EncryptedCompressedFileDataSource: decrypting, then decompressing");
        String compressed = encrypted.replace("[ENC]", "").replace("[/ENC]", "");
        return compressed.replace("[ZIP]", "").replace("[/ZIP]", "");
    }
}

public class WithoutDecoratorDemo {
    public static void main(String[] args) {
        DataSource1 ds1 = new FileDataSource1("data.txt");
        ds1.writeData("Hello World");
        System.out.println("Result: " + ds1.readData());

        DataSource1 ds2 = new EncryptedCompressedFileDataSource("secure.dat");
        ds2.writeData("Secret Message");
        System.out.println("Result: " + ds2.readData());
    }
}
