import java.util.EnumSet;

public class EnumSetDemo {
    // Define an enum for demonstration
    enum Days {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    public static void main(String[] args) {
        // Create an EnumSet containing specific enum values
        EnumSet<Days> weekend = EnumSet.of(Days.SATURDAY, Days.SUNDAY);
        System.out.println("Weekend days: " + weekend); // Output: [SATURDAY, SUNDAY]

        // Create an EnumSet containing all days
        EnumSet<Days> allDays = EnumSet.allOf(Days.class);
        System.out.println("All days: " + allDays); // Output: [MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY]

        // Create an EnumSet containing a range of enum values
        EnumSet<Days> weekdays = EnumSet.range(Days.MONDAY, Days.FRIDAY);
        System.out.println("Weekdays: " + weekdays); // Output: [MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY]

        // Add all weekend days to the weekdays EnumSet
        weekdays.addAll(weekend);
        System.out.println("Weekdays + Weekend: " + weekdays); // Output: [MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY]
    }
}
