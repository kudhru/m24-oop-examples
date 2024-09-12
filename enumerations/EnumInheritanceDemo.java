enum Apple {
    Jonathan, GoldenDel, RedDel, Winesap, Cortland;
    // new enum Apple ("Jonathan")

    int dummyOrdinal() {
        return this.ordinal();
    }
}

public class EnumInheritanceDemo {
    public static void main(String[] args) {
        Apple ap1, ap2, ap3;

        String a, b, c;

        a = new String("abc");
        b = a;

        // Display ordinal values
        System.out.println("Here are all apple constants and their ordinal values:");
        for (Apple a : Apple.values()) {
            System.out.println(a + " " + a.ordinal());
            System.out.println(a + " " + a.dummyOrdinal());
        }


        ap1 = Apple.RedDel;
        ap2 = Apple.GoldenDel;
        ap3 = Apple.RedDel;
        System.out.println(ap1 + " - " + ap2 + " = " + ap1.compareTo(ap2));
        System.out.println(ap2 + " - " + ap1 + " = " + ap2.compareTo(ap1));
        // Use compareTo()
        if (ap1.compareTo(ap2) < 0)
            System.out.println("<" + ap1 + " comes before " + ap2);
        if (ap1.compareTo(ap2) > 0)
            System.out.println(">" + ap2 + " comes before " + ap1);

        // Use equals()
        if (ap1.equals(ap3))
            System.out.println(ap1 + " equals " + ap3);
    }
}
