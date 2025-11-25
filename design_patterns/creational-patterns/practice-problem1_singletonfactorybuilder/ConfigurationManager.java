package singletonfactorybuilder;
public class ConfigurationManager {
    private static ConfigurationManager instance;
    private String systemConfigDetails;
    private int requiredQualityLevel; // Added specific config variable

    private ConfigurationManager() {
        // Load configuration from a file or database upon initialization
        this.systemConfigDetails = "Loaded System Config: Default Materials: Steel/Plastic";
        this.requiredQualityLevel = 10; // e.g., 10 is the pass standard
    }

    public static synchronized ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }

    public void printConfig() {
        System.out.println(systemConfigDetails + ", Required Quality Level: " + requiredQualityLevel);
    }
    
    public int getRequiredQualityLevel() {
        return requiredQualityLevel;
    }
    
    //prevent cloning
}
