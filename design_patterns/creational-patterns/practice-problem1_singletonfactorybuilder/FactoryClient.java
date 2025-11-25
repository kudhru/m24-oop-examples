package singletonfactorybuilder;

public class FactoryClient {
    public static void main(String[] args) {
        // --- 1. Use the Singleton Configuration Manager (Client can also read it) ---
        ConfigurationManager config = ConfigurationManager.getInstance();
        System.out.print("[Client Log] Current Factory Configuration: ");
        config.printConfig();
        System.out.println("---");

        // --- 2. Use the Factory to get a standard vehicle (Factory uses the SAME config) ---
        VehicleFactory factory = new VehicleFactory();
        Vehicle standardCar = factory.createVehicle("car");
        standardCar.manufacture();
        System.out.println("---");

        // --- 3. Use the Builder/Director for a complex, customized order (Director uses the SAME config) ---
        ManufacturingDirector director = new ManufacturingDirector();
        SportsCarBuilder sportsBuilder = new SportsCarBuilder();
        
        // Director constructs the object step-by-step
        director.constructSportsCar(sportsBuilder); 
        CustomizedVehicle customSportsCar = sportsBuilder.getResult();
        customSportsCar.display();
    }
}