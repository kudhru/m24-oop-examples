// The Product
class Pizza {
    private final String size;      // Mandatory
    private final String crust;     // Mandatory
    private final boolean cheese;   // Optional
    private final boolean pepperoni; // Optional
    private final boolean mushrooms; // Optional

    // Private constructor
    private Pizza(Builder builder) {
        this.size = builder.size;
        this.crust = builder.crust;
        this.cheese = builder.cheese;
        this.pepperoni = builder.pepperoni;
        this.mushrooms = builder.mushrooms;
    }

    // Static nested Builder class
    public static class Builder {
        private final String size;
        private final String crust;
        private boolean cheese = false;
        private boolean pepperoni = false;
        private boolean mushrooms = false;

        public Builder(String size, String crust) {
            this.size = size;
            this.crust = crust;
        }

        public Builder cheese(boolean value) {
            cheese = value;
            return this;
        }

        public Builder pepperoni(boolean value) {
            pepperoni = value;
            return this;
        }

        public Builder mushrooms(boolean value) {
            mushrooms = value;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }

    @Override
    public String toString() {
        return "Pizza [size=" + size + ", crust=" + crust + ", cheese=" + cheese +
                ", pepperoni=" + pepperoni + ", mushrooms=" + mushrooms + "]";
    }
}

/**
 * Imagine there is a Pizza class.
 * Assume that this Pizza class has two mandatory attributes (size and crust)
 * There are some optional attributes which are by default set to false (cheese, mushrooms, pepperoni).
 * Given all this of above information, use the Builder Pattern to write the code for Pizza class.
 */

// Testing the Builder Pattern
public class BuilderExample {
    public static void main(String[] args) {
        Pizza.Builder builder = new Pizza.Builder("Large", "Thin Crust");

        builder.cheese(true);
        builder.pepperoni(true);
        builder.mushrooms(true);

        builder.build();



//                .cheese(true)
//                .pepperoni(true)
//                .build();


        Pizza pizza = new Pizza.Builder("Large", "Thin Crust")
                .cheese(true)
                .pepperoni(true)
                .build();

        System.out.println(pizza);
    }
}
