public class StockWithoutObserverExample {

    // ----- Concrete "observers" but no common interface -----

    static class TradingScreen {
        private final String screenName;

        public TradingScreen(String screenName) {
            this.screenName = screenName;
        }

        public void showPrice(String symbol, double newPrice) {
            System.out.println("[TradingScreen-" + screenName + "] "
                    + symbol + " => " + newPrice);
        }
    }

    static class PriceAlertService {
        private final String symbolOfInterest;
        private final double threshold;

        public PriceAlertService(String symbolOfInterest, double threshold) {
            this.symbolOfInterest = symbolOfInterest;
            this.threshold = threshold;
        }

        public void checkAlert(String symbol, double newPrice) {
            if (symbol.equals(symbolOfInterest) && newPrice >= threshold) {
                System.out.println("[AlertService] ALERT: " + symbol
                        + " has crossed " + threshold
                        + " (current: " + newPrice + ")");
            }
        }
    }

    // ----- StockExchange is TIGHTLY COUPLED to specific classes -----
    static class StockExchange {

        // Hard-coded dependencies
        private TradingScreen screen1;
        private TradingScreen screen2;
        private PriceAlertService alertService;

        public void setScreen1(TradingScreen screen) {
            this.screen1 = screen;
        }

        public void setScreen2(TradingScreen screen) {
            this.screen2 = screen;
        }

        public void setAlertService(PriceAlertService alertService) {
            this.alertService = alertService;
        }

        // Business method: price update
        public void updatePrice(String symbol, double newPrice) {
            System.out.println("\n[StockExchange] " + symbol
                    + " new price = " + newPrice);

            // Directly call concrete types
            if (screen1 != null) {
                screen1.showPrice(symbol, newPrice);
            }
            if (screen2 != null) {
                screen2.showPrice(symbol, newPrice);
            }
            if (alertService != null) {
                alertService.checkAlert(symbol, newPrice);
            }

            // If we add LoggingService, AnalyticsService, etc.
            // we must add new fields + calls here.
        }
    }

    // ----- Client code -----
    public static void main(String[] args) {

        StockExchange nse = new StockExchange();

        // Manually wire concrete dependencies
        TradingScreen screen1 = new TradingScreen("FrontOffice");
        TradingScreen screen2 = new TradingScreen("BackOffice");
        PriceAlertService alert = new PriceAlertService("INFY", 1600.0);

        nse.setScreen1(screen1);
        nse.setScreen2(screen2);
        nse.setAlertService(alert);

        nse.updatePrice("INFY", 1580.0);
        nse.updatePrice("TCS", 3450.0);
        nse.updatePrice("INFY", 1610.0); // should trigger alert
    }
}
