// ToyDuck Interface
interface ToyDuck {
    void squeak();
}

// Bird Class
class Bird {
    public void chirp() {
        System.out.println("Bird is chirping!");
    }
}

// Adapter Class
class BirdAdapter implements ToyDuck {
    private Bird bird;

    // Constructor
    public BirdAdapter(Bird bird) {
        this.bird = bird;
    }

    @Override
    public void squeak() {
        // Translate the Bird's chirping to a ToyDuck's squeak
        bird.chirp();
    }
}

public class AdapterSimpleExample {
    public static void main(String[] args) {
        // Create a Bird
        Bird sparrow = new Bird();

        // Use the Adapter to make the Bird behave like a ToyDuck
        ToyDuck birdAsToyDuck = new BirdAdapter(sparrow);

        // Call the ToyDuck's squeak method
        birdAsToyDuck.squeak(); // Output: Bird is chirping!
    }
}


