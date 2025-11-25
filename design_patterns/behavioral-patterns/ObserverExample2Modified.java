import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 1. Modified Observer Interface (No arguments in update anymore - they must 'pull' data)
interface ControlledStockObserver {
    void update(); 
}

// 2. Modified Subject Interface/Class (Data accessors added, notify is manual)
class ControlledStockExchange {
    private List<ControlledStockObserver> observers = new ArrayList<>();
    Map<String, Double> stockPrices = new HashMap<>();
    // Keep track of which stocks actually changed in this batch if needed

    // Public method for clients to change data *without* immediate notification
    public void setStockPrice(String symbol, double newPrice) {
        stockPrices.put(symbol, newPrice);
        System.out.println(">>> Client Action: Price of " + symbol + " updated internally to $" + newPrice);
        // We *do not* call notifyObservers() here
    }
    
    // The "Client" or Change Manager calls this manually when ready
    public void notifyObserversManual() {
        System.out.println("\n--- Initiating manual notification batch ---");
        for (ControlledStockObserver observer : observers) {
            observer.update(); // Observers must now pull the new data themselves
        }
    }

    public void registerObserver(ControlledStockObserver o) {
        observers.add(o);
    }
    
    // Getter for observers to 'pull' the current data (part of the 'pull' model)
    public double getStockPrice(String symbol) {
        return stockPrices.getOrDefault(symbol, 0.0);
    }
}

// 3. Modified Concrete Observer A (Pulls data when updated)
class ManualStockTickerDisplay implements ControlledStockObserver {
    private ControlledStockExchange subject;

    public ManualStockTickerDisplay(ControlledStockExchange subject) {
        this.subject = subject;
    }

    @Override
    public void update() {
        // When 'update()' is called, we pull the data we care about
        System.out.println("[Manual Ticker]: Updating ALL stock prices now:");
        for (String symbol : subject.stockPrices.keySet()) {
             System.out.println("  - " + symbol + ": $" + subject.getStockPrice(symbol));
        }
    }
}


// 4. Demonstration (Client Controls Notification Timing)
public class ObserverExample2Modified {
    public static void main(String[] args) {
        ControlledStockExchange exchange = new ControlledStockExchange();
        
        ManualStockTickerDisplay ticker = new ManualStockTickerDisplay(exchange);

        exchange.registerObserver(ticker);

        System.out.println("Making a series of changes rapidly:");
        
        // Client makes multiple changes without immediate observer notification
        exchange.setStockPrice("GOOGL", 150.00); 
        exchange.setStockPrice("APPL", 180.50); 
        exchange.setStockPrice("TSLA", 220.00);
        exchange.setStockPrice("GOOGL", 151.25); // GOOGL changed twice

        System.out.println("\nAll changes processed by the client internally.");
        System.out.println("Observers have NOT been updated yet.");

        // Client initiates ONE SINGLE notification when ready
        exchange.notifyObserversManual();
        // The display updates once, reading all final values in one batch operation.
    }
}
