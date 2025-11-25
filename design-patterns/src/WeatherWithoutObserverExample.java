import java.util.*; // (Actually only for consistency; not really needed here)

public class WeatherWithoutObserverExample {

    // ----- Concrete "display" classes (no Observer interface) -----

    static class PhoneDisplay {
        public void showTemperature(float temperature) {
            System.out.println("PhoneDisplay: showing " + temperature + "°C");
        }
    }

    static class WindowDisplay {
        public void showTemperature(float temperature) {
            System.out.println("WindowDisplay: showing " + temperature + "°C");
        }
    }

    // ----- WeatherStation is TIGHTLY COUPLED to specific displays -----
    static class WeatherStation {

        private float temperature;

        // Hard-coded dependencies on concrete classes
        private PhoneDisplay phoneDisplay;
        private WindowDisplay windowDisplay;

        public void setPhoneDisplay(PhoneDisplay phoneDisplay) {
            this.phoneDisplay = phoneDisplay;
        }

        public void setWindowDisplay(WindowDisplay windowDisplay) {
            this.windowDisplay = windowDisplay;
        }

        // Business logic: when temperature changes, manually notify known displays
        public void setTemperature(float temperature) {
            System.out.println("\nWeatherStation: new temperature = " + temperature);
            this.temperature = temperature;

            // Direct calls to concrete types (no Observer list, no interface)
            if (phoneDisplay != null) {
                phoneDisplay.showTemperature(temperature);
            }
            if (windowDisplay != null) {
                windowDisplay.showTemperature(temperature);
            }

            // If we add SmartWatchDisplay, LoggerDisplay, etc.
            // we must add new fields and calls here.
        }
    }

    // ----- Client code -----
    public static void main(String[] args) {

        WeatherStation station = new WeatherStation();

        // create concrete displays
        PhoneDisplay phone = new PhoneDisplay();
        WindowDisplay window = new WindowDisplay();

        // wire them into WeatherStation
        station.setPhoneDisplay(phone);
        station.setWindowDisplay(window);

        station.setTemperature(25.0f);
        station.setTemperature(30.5f);

        // "Unsubscribe" phone display = manual null
        station.setPhoneDisplay(null);

        station.setTemperature(27.3f);
    }
}
