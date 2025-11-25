
// ===== Component interface =====
interface DataSource1 {
    void writeData(String data);
    String readData();
}

// ===== Concrete Component =====
class FileDataSource1 implements DataSource1 {
    private String fileName;
    private String storage; // simulate file content as a String

    public FileDataSource1(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void writeData(String data) {
        System.out.println("FileDataSource: writing to " + fileName);
        storage = data;
    }

    @Override
    public String readData() {
        System.out.println("FileDataSource: reading from " + fileName);
        return storage;
    }
}

// ===== Base Decorator =====
class DataSourceDecorator implements DataSource1 {

    protected DataSource1 wrappee; // the object being decorated

    public DataSourceDecorator(DataSource1 source) {
        this.wrappee = source;
    }

    @Override
    public void writeData(String data) {
        wrappee.writeData(data);
    }

    @Override
    public String readData() {
        return wrappee.readData();
    }
}

// ===== Concrete Decorator: Encryption =====
class EncryptionDecorator extends DataSourceDecorator {

    public EncryptionDecorator(DataSource1 source) {
        super(source);
    }

    @Override
    public void writeData(String data) {
        String encrypted = encrypt(data);
        System.out.println("EncryptionDecorator: encrypting data");
        super.writeData(encrypted);
    }

    @Override
    public String readData() {
        String encrypted = super.readData();
        System.out.println("EncryptionDecorator: decrypting data");
        return decrypt(encrypted);
    }

    // fake "encryption"
    private String encrypt(String data) {
        return "[ENC]" + data + "[/ENC]";
    }

    private String decrypt(String data) {
        return data.replace("[ENC]", "").replace("[/ENC]", "");
    }
}

// ===== Concrete Decorator: Compression =====
class CompressionDecorator extends DataSourceDecorator {

    public CompressionDecorator(DataSource1 source) {
        super(source);
    }

    @Override
    public void writeData(String data) {
        String compressed = compress(data);
        System.out.println("CompressionDecorator: compressing data");
        super.writeData(compressed);
    }

    @Override
    public String readData() {
        String compressed = super.readData();
        System.out.println("CompressionDecorator: decompressing data");
        return decompress(compressed);
    }

    // fake "compression"
    private String compress(String data) {
        return "[ZIP]" + data + "[/ZIP]";
    }

    private String decompress(String data) {
        return data.replace("[ZIP]", "").replace("[/ZIP]", "");
    }
}

public class DecoratorDataSourceExample {
    // ===== Client demo =====
    public static void main(String[] args) {

        String salaryData = "Employee=Alice;Salary=1,00,000";

        // 1. Plain file
        DataSource1 plain = new FileDataSource1("plain.txt");
        plain.writeData(salaryData);
        System.out.println("Plain read: " + plain.readData());
        System.out.println();

        // 2. Encrypted only
        DataSource1 encrypted = new EncryptionDecorator(
                new FileDataSource1("encrypted.txt"));
        encrypted.writeData(salaryData);
        System.out.println("Encrypted read: " + encrypted.readData());
        System.out.println();

        // 3. Compressed + Encrypted (stack decorators!)
        DataSource1 compressedEncrypted =
                new EncryptionDecorator(
                        new CompressionDecorator(
                                new FileDataSource1("secure.dat")));

        compressedEncrypted.writeData(salaryData);
        System.out.println("Compressed+Encrypted read: " + compressedEncrypted.readData());
    }
}
