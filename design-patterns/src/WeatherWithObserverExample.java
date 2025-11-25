import java.util.ArrayList;
import java.util.List;

public class WeatherWithObserverExample {

    // ----- Observer interface -----
    interface Observer {
        void update(float temperature);
    }

    // ----- Subject interface -----
    interface Subject {
        void registerObserver(Observer o);
        void removeObserver(Observer o);
        void notifyObservers();
    }

    // ----- Concrete Subject -----
    static class WeatherStation implements Subject {

        private final List<Observer> observers = new ArrayList<>();
        private float temperature;

        @Override
        public void registerObserver(Observer o) {
            observers.add(o);
        }

        @Override
        public void removeObserver(Observer o) {
            observers.remove(o);
        }

        @Override
        public void notifyObservers() {
            for (Observer o : observers) {
                o.update(temperature);
            }
        }

        // Business logic: when temperature changes, we notify everyone
        public void setTemperature(float temperature) {
            System.out.println("\nWeatherStation: new temperature = " + temperature);
            this.temperature = temperature;
            notifyObservers();
        }
    }

    // ----- Concrete Observers -----
    static class PhoneDisplay implements Observer {

        private final Subject weatherStation;

        public PhoneDisplay(Subject weatherStation) {
            this.weatherStation = weatherStation;
            weatherStation.registerObserver(this);
        }

        @Override
        public void update(float temperature) {
            System.out.println("PhoneDisplay: showing " + temperature + "°C");
        }
    }

    static class WindowDisplay implements Observer {

        private final Subject weatherStation;

        public WindowDisplay(Subject weatherStation) {
            this.weatherStation = weatherStation;
            weatherStation.registerObserver(this);
        }

        @Override
        public void update(float temperature) {
            System.out.println("WindowDisplay: showing " + temperature + "°C");
        }
    }

    // ----- Client code -----
    public static void main(String[] args) {

        WeatherStation station = new WeatherStation();

        // observers subscribe
        Observer phone = new PhoneDisplay(station);
        Observer window = new WindowDisplay(station);

        station.setTemperature(25.0f);
        station.setTemperature(30.5f);

        // unsubscribe one observer
        station.removeObserver(phone);

        station.setTemperature(27.3f);
    }
}
