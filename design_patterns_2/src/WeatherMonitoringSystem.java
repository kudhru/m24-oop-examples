import java.util.ArrayList;
import java.util.List;

// Observer Interface
interface WeatherObserver {
    void update(float temperature, float humidity, float pressure);
}

// Concrete Observers
class PhoneDisplay implements WeatherObserver {
    @Override
    public void update(float temperature, float humidity, float pressure) {
        System.out.println("Phone Display - Temperature: " + temperature +
                ", Humidity: " + humidity + ", Pressure: " + pressure);
    }
}

class WebDisplay implements WeatherObserver {
    @Override
    public void update(float temperature, float humidity, float pressure) {
        System.out.println("Web Display - Temperature: " + temperature +
                ", Humidity: " + humidity + ", Pressure: " + pressure);
    }
}

// Subject Class
class WeatherStation {
    private List<WeatherObserver> observers = new ArrayList<>();
    private float temperature;
    private float humidity;
    private float pressure;

    public void addObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (WeatherObserver observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }

    public void setWeatherData(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObservers();
    }
}

// Client Code
public class WeatherMonitoringSystem {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();

        WeatherObserver phoneDisplay = new PhoneDisplay();
        WeatherObserver webDisplay = new WebDisplay();

        station.addObserver(phoneDisplay);
        station.addObserver(webDisplay);

        station.setWeatherData(25.3f, 65.0f, 1013.1f);
        station.setWeatherData(26.1f, 63.5f, 1012.8f);
    }
}
