enum Apple {
    Jonathan, GoldenDel, RedDel, Winesap, Cortland
}

public class EnumDemo {
    public static void main(String[] args) {
        Apple ap = Apple.RedDel;

        // Output the value of the enum
        System.out.println("Selected apple variety: " + ap);

        // Use enum in a switch statement
        switch(ap) {
            case Jonathan:
                System.out.println("Jonathan is red.");
                break;
            case GoldenDel:
                System.out.println("Golden Delicious is yellow.");
                break;
            case RedDel:
                System.out.println("Red Delicious is red.");
                break;
            default:
                System.out.println("Other variety.");
        }
    }
}