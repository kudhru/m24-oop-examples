import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StockWithObserverExample {

    // ----- Observer interface -----
    interface StockObserver {
        void onPriceChanged(String symbol, double newPrice);
    }

    // ----- Subject interface -----
    interface StockMarket {
        void registerObserver(StockObserver observer);
        void removeObserver(StockObserver observer);
        void updatePrice(String symbol, double newPrice);
    }

    // ----- Concrete Subject: StockExchange -----
    static class StockExchange implements StockMarket {

        private final List<StockObserver> observers = new ArrayList<>();
        private final Map<String, Double> prices = new HashMap<>();

        @Override
        public void registerObserver(StockObserver observer) {
            observers.add(observer);
        }

        @Override
        public void removeObserver(StockObserver observer) {
            observers.remove(observer);
        }

        // Business method: someone updates a stock price
        @Override
        public void updatePrice(String symbol, double newPrice) {
            prices.put(symbol, newPrice);
            System.out.println("\n[StockExchange] " + symbol + " new price = " + newPrice);
            notifyObservers(symbol, newPrice);
        }

        private void notifyObservers(String symbol, double newPrice) {
            for (StockObserver observer : observers) {
                observer.onPriceChanged(symbol, newPrice);
            }
        }
    }

    // ----- Concrete Observer 1: Trading screen (shows all updates) -----
    static class TradingScreen implements StockObserver {

        private final String screenName;

        public TradingScreen(String screenName, StockMarket market) {
            this.screenName = screenName;
            market.registerObserver(this);
        }

        @Override
        public void onPriceChanged(String symbol, double newPrice) {
            System.out.println("[TradingScreen-" + screenName + "] " +
                    symbol + " => " + newPrice);
        }
    }

    // ----- Concrete Observer 2: Alert service (alerts on threshold) -----
    static class PriceAlertService implements StockObserver {

        private final String symbolOfInterest;
        private final double threshold;

        public PriceAlertService(String symbolOfInterest, double threshold,
                                 StockMarket market) {
            this.symbolOfInterest = symbolOfInterest;
            this.threshold = threshold;
            market.registerObserver(this);
        }

        @Override
        public void onPriceChanged(String symbol, double newPrice) {
            if (symbol.equals(symbolOfInterest) && newPrice >= threshold) {
                System.out.println("[AlertService] ALERT: " + symbol +
                        " has crossed " + threshold +
                        " (current: " + newPrice + ")");
            }
        }
    }

    // ----- Client demo -----
    public static void main(String[] args) {

        StockExchange nse = new StockExchange();

        // Observers subscribe to the market
        StockObserver screen1 = new TradingScreen("FrontOffice", nse);
        StockObserver screen2 = new TradingScreen("BackOffice", nse);
        StockObserver alert = new PriceAlertService("INFY", 1600.0, nse);

        // Prices changing in the market
        nse.updatePrice("INFY", 1580.0);
        nse.updatePrice("TCS", 3450.0);
        nse.updatePrice("INFY", 1610.0);   // should trigger alert

        // Unsubscribe one screen
        nse.removeObserver(screen2);

        nse.updatePrice("INFY", 1625.0);
    }
}
