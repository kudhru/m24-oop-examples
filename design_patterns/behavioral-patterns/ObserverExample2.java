import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 1. Observer Interface
interface StockObserver {
    void update(String stockSymbol, double price);
}

// 2. Subject Interface (Optional, but good practice)
interface StockSubject {
    void registerObserver(StockObserver o);
    void removeObserver(StockObserver o);
    void notifyObservers(String stockSymbol, double price);
}

// 3. Concrete Subject (The Stock Exchange)
class StockExchange implements StockSubject {
    private List<StockObserver> observers = new ArrayList<>();
    private Map<String, Double> stockPrices = new HashMap<>();

    public void setStockPrice(String symbol, double newPrice) {
        stockPrices.put(symbol, newPrice);
        System.out.println("\nExchange Update: Price of " + symbol + " changed to $" + newPrice);
        notifyObservers(symbol, newPrice); // Notify everyone on change
    }

    @Override
    public void registerObserver(StockObserver o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(StockObserver o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(String stockSymbol, double price) {
        for (StockObserver observer : observers) {
            observer.update(stockSymbol, price);
        }
    }
}

// 4. Concrete Observer A (Stock Ticker Display)
class StockTickerDisplay implements StockObserver {
    @Override
    public void update(String stockSymbol, double price) {
        System.out.println("[Ticker Display]: Latest price for " + stockSymbol + " is $" + price);
    }
}

// 5. Concrete Observer B (Portfolio Calculator)
class PortfolioCalculator implements StockObserver {
    // In a real app, this would update portfolio value
    @Override
    public void update(String stockSymbol, double price) {
        System.out.println("[Portfolio Calc]: Recalculating value based on " + stockSymbol + " price...");
    }
}

// 6. Demo
public class ObserverExample2 {
    public static void main(String[] args) {
        StockExchange exchange = new StockExchange();

        StockObserver ticker = new StockTickerDisplay();
        StockObserver portfolio = new PortfolioCalculator();

        exchange.registerObserver(ticker);
        exchange.registerObserver(portfolio);

        // A change in the subject automatically notifies both observers
        exchange.setStockPrice("GOOGL", 150.00);
        exchange.setStockPrice("APPL", 180.50);
        
        exchange.removeObserver(portfolio); // Stop monitoring with the calculator

        exchange.setStockPrice("GOOGL", 151.25); // Only Ticker updates now
    }
}
