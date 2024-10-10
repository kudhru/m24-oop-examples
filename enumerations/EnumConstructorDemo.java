enum Apple {
//    Jonathan(10), GoldenDel(9), RedDel(12), Winesap(15), Cortland(8);
//    Jonathan, GoldenDel, RedDel, Winesap, Cortland;
//    Jonathan, GoldenDel, RedDel, Winesap, Cortland;
    Jonathan, GoldenDel(5), RedDel, Winesap(4), Cortland;

    private int price;  // price of each apple variety

    // Constructor
    Apple(int p) {
        price = p;
    }

    // Constructor
    Apple() {
        price = -1;
    }

    // Method to get price
    int getPrice() {
        return price;
    }

//    int compare(Apple apple) {
//        Apple x = new Apple();
//        return -1;
//    }

    void setPrice(int p) {
        price = p;
    }

//    Jonathan, GoldenDel, RedDel, Winesap(4), Cortland(10);
}

public class EnumConstructorDemo {
    public static void main(String[] args) {
        // Display price of a specific variety
        System.out.println("Winesap costs " + Apple.Winesap.getPrice() + " cents.\n");
//        System.out.println("Winesap costs " + Winesap.getPrice() + " cents.\n");

        // Display all varieties and their prices
        System.out.println("All apple prices:");
        for (Apple a : Apple.values())
            System.out.println(a + " costs " + a.getPrice() + " cents.");

//        Apple x = new Apple();
//        System.out.println("x");
        Apple y = Apple.GoldenDel;
        y.setPrice(10);
        System.out.println(y + " costs " + y.getPrice() + " cents.");
    }
}
