class DummyDummy {
    static int add (int a, int b) {
        return a + b;
    }

//    @Override
//    public String toString() {
//        return Integer.toString(add(1,2));
//    }
}

public class Dummy {
    static int add (int a, int b) {
        return a + b;
    }

    @Override
    public String toString() {
        return Integer.toString(add(1,2));
    }
   public static void main(String[] args) {
       DummyDummy.add(1,2);
   }
}
