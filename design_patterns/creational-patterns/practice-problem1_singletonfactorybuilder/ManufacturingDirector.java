// The complex Product (Vehicle in this case needs many options)
package singletonfactorybuilder;

class CustomizedVehicle {
    private String engine;
    private String color;
    private int wheels;
    // ... other complex configurations

    public void display() {
        System.out.println("Customized Vehicle: Color=" + color + ", Engine=" + engine + ", Wheels=" + wheels);
    }
    
    // Setters for the builder
    public void setEngine(String engine) { this.engine = engine; }
    public void setColor(String color) { this.color = color; }
    public void setWheels(int wheels) { this.wheels = wheels; }
}

// Builder Interface
interface VehicleBuilder {
    void buildEngine();
    void buildColor();
    void buildWheels();
    CustomizedVehicle getResult();
}

// Concrete Builder
class SportsCarBuilder implements VehicleBuilder {
    private CustomizedVehicle vehicle = new CustomizedVehicle();

    @Override
    public void buildEngine() {
        vehicle.setEngine("V8 Sports Engine");
    }

    @Override
    public void buildColor() {
        vehicle.setColor("Racing Red");
    }

    @Override
    public void buildWheels() {
        vehicle.setWheels(4);
    }

    @Override
    public CustomizedVehicle getResult() {
        return vehicle;
    }
}

//Director now uses the Singleton instance
class ManufacturingDirector {
 // Director internally gets the Singleton instance
 private ConfigurationManager config = ConfigurationManager.getInstance();

 public void constructSportsCar(VehicleBuilder builder) {
     System.out.println("[Director Log] Ensuring build meets global QC level: " + config.getRequiredQualityLevel());
     builder.buildEngine();
     builder.buildColor();
     builder.buildWheels();
     
     // Hypothetical check before finalizing
     if (config.getRequiredQualityLevel() < 5) {
          System.out.println("[Director Log] Skipping advanced features due to low config settings.");
     }
 }
}
