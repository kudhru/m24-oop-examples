// The Product
class PizzaOne {
    private final String size;      // Mandatory
    private final String crust;     // Mandatory
    private boolean cheese;   // Optional
    private boolean pepperoni; // Optional
    private boolean mushrooms; // Optional

    // Private constructor
    public PizzaOne(String size, String crust) {
        this.size = size;
        this.crust = crust;
        this.cheese = false;
        this.pepperoni = false;
        this.mushrooms = false;
    }

    @Override
    public String toString() {
        return "Pizza [size=" + size + ", crust=" + crust + ", cheese=" + cheese +
                ", pepperoni=" + pepperoni + ", mushrooms=" + mushrooms + "]";
    }

    public String getSize() {return size;}
    public String getCrust() {return crust;}
    public boolean isCheese() {return cheese;}
    public void setCheese(boolean cheese) {
        this.cheese = cheese;
    }
    public boolean isPepperoni() {return pepperoni;}
    public void setPepperoni(boolean pepperoni) {
        this.pepperoni = pepperoni;
    }
    public boolean isMushrooms() {return mushrooms;}
    public void setMushrooms(boolean mushrooms) {
        this.mushrooms = mushrooms;
    }
}

/**
 * Imagine there is a Pizza class.
 * Assume that this Pizza class has two mandatory attributes (size and crust)
 * There are some optional attributes which are by default set to false (cheese, mushrooms, pepperoni).
 * Given all this of above information, use the Builder Pattern to write the code for Pizza class.
 */

// Testing the Builder Pattern
public class WithoutBuilderExample {
    public static void main(String[] args) {
        PizzaOne pizza1 = new PizzaOne("Large", "Thin Crust");
        pizza1.setCheese(true);
        pizza1.setPepperoni(true);
        pizza1.setMushrooms(true);

//        Pizza pizza = new Pizza.Builder("Large", "Thin Crust")
//                .cheese(true)
//                .pepperoni(true)
//                .build();
//
//        System.out.println(pizza);
    }
}
