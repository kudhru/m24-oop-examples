// Target Interface
interface AmericanPlug {
    void connect();
}

// Adaptee Class
class EuropeanPlug {
    public void connectEuropeanPlug() {
        System.out.println("Connecting European Plug.");
    }
}

// Adapter Class
class PlugAdapter implements AmericanPlug {
    private EuropeanPlug europeanPlug;

    public PlugAdapter(EuropeanPlug europeanPlug) {
        this.europeanPlug = europeanPlug;
    }

    @Override
    public void connect() {
        // Adapting European plug to American plug
        europeanPlug.connectEuropeanPlug();
        System.out.println("Adapter converts to American plug.");
    }
}

// Client Code
public class AdapterExample {
    public static void main(String[] args) {
        EuropeanPlug europeanPlug = new EuropeanPlug();
        europeanPlug.connectEuropeanPlug();

        AmericanPlug adapter = new PlugAdapter(europeanPlug);

        // Using the adapter to connect a European plug to an American socket
        adapter.connect();
    }
}
