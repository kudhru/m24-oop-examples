// The Product
class Car {
    private final String engine;   // Mandatory
    private final int wheels;      // Mandatory
    private final boolean sunroof; // Optional
    private final boolean gps;     // Optional
    private final boolean automatic; // Optional

    private Car(Builder builder) {
        this.engine = builder.engine;
        this.wheels = builder.wheels;
        this.sunroof = builder.sunroof;
        this.gps = builder.gps;
        this.automatic = builder.automatic;
    }

    public static class Builder {
        private final String engine;
        private final int wheels;
        private boolean sunroof = false;
        private boolean gps = false;
        private boolean automatic = false;

        public Builder(String engine, int wheels) {
            this.engine = engine;
            this.wheels = wheels;
        }

        public Builder sunroof(boolean value) {
            sunroof = value;
            return this;
        }

        public Builder gps(boolean value) {
            gps = value;
            return this;
        }

        public Builder automatic(boolean value) {
            automatic = value;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }

    @Override
    public String toString() {
        return "Car [engine=" + engine + ", wheels=" + wheels + ", sunroof=" + sunroof +
                ", gps=" + gps + ", automatic=" + automatic + "]";
    }
}

// Testing the Car Builder
public class CarBuilderExample {
    public static void main(String[] args) {
        Car car = new Car.Builder("V8", 4)
                .sunroof(true)
                .gps(true)
                .automatic(true)
                .build();

        System.out.println(car);
    }
}
