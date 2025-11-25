package practiceproblems;

//=== SINGLETON ===
class AtmosphericConfig {
 private static AtmosphericConfig instance;
 private final double GRAVITY_CONSTANT = 9.81;
 private AtmosphericConfig() {}
 public static AtmosphericConfig getInstance() {
     if (instance == null) { instance = new AtmosphericConfig(); }
     return instance;
 }
 public double getGravity() { return GRAVITY_CONSTANT; }
}

//=== FACTORY ===
interface CelestialBody { void orbit(); }
class Planet implements CelestialBody { 
 public void orbit() { 
     System.out.println("Planet orbiting with gravity " + AtmosphericConfig.getInstance().getGravity());
 }
}
class Star implements CelestialBody { public void orbit() { System.out.println("Star radiating heat."); } }

class CelestialBodyFactory {
 public CelestialBody createBody(String type) {
     if ("planet".equalsIgnoreCase(type)) return new Planet();
     if ("star".equalsIgnoreCase(type)) return new Star();
     return null;
 }
}

//=== BUILDER (Rocket Assembly) ===
class Rocket {
 private String name;
 String stage1;
 String stage2;
 private String payload;
 public void display() { System.out.println("Built Rocket: " + name + " -> Stage 1: " + stage1); }
 // setters omitted for brevity...
}

interface RocketBuilder {

	void buildEngine();

	Rocket getResult();

	void buildColor();
	
}

class MarsMissionBuilder implements RocketBuilder {
 private Rocket rocket = new Rocket();
 @Override public void buildEngine() { rocket.stage1 = "Heavy Lift Booster"; }
 @Override public void buildColor() { rocket.stage2 = "Orbital Stage"; }
 // ... methods to build complex rocket ...
 @Override public Rocket getResult() { return rocket; }
}
