enum Apple {
    Jonathan, GoldenDel, RedDel, Winesap, Cortland
}

public class EnumValuesDemo {
    public static void main(String[] args) {
        // Using values() to get all constants
        Apple[] allApples = Apple.values();
        System.out.println("All apple varieties:");
        for (Apple a : allApples)
            System.out.println(a);

        // Using valueOf() to get a specific constant
        Apple ap = Apple.valueOf("Winesap");
        System.out.println("\nSelected apple variety: " + ap);
    }
}
