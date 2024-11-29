/*Problem Statement
Design a system to manage the states of an Elevator. The elevator can be in one of three states:

Idle: The elevator is not moving.
Moving Up: The elevator is moving upwards to a specified floor.
Moving Down: The elevator is moving downwards to a specified floor.
Implement the State Design Pattern to handle the behavior of the elevator in each state. Write the state classes with the following method signatures:

public void pressButton(int floor)
public void reachFloor()
The behavior should change based on the elevator's current state.
*/

// State Interface
interface ElevatorState {
    void pressButton(int floor);
    void reachFloor();
}

// Concrete States
// Implement IdleState, MovingUpState, and MovingDownState classes here

class IdleState implements ElevatorState {
    private Elevator elevator;
//    private int currentDestinationFloor;
    public IdleState(Elevator elevator) {
        this.elevator = elevator;
    }


    public void pressButton(int floor) {
//        currentDestinationFloor = floor;
        if(floor > elevator.getCurrentFloor()) {
//        if(currentDestinationFloor > elevator.getCurrentFloor()) {
            elevator.setState(new MovingUpState(elevator, floor));
        }
        else if(floor < elevator.getCurrentFloor()) {
//        else if(currentDestinationFloor < elevator.getCurrentFloor()) {
            elevator.setState(new MovingDownState(elevator, floor));
        }
        System.out.println("Idle");
    }

    public void reachFloor() {
        System.out.println("Floor Reached: " + elevator.getCurrentFloor());
    }
}

class MovingUpState implements ElevatorState {
    private int currentDestinationFloor;
    private Elevator elevator;
    public MovingUpState(Elevator elevator, int currentDestinationFloor) {
        this.elevator = elevator;
        this.currentDestinationFloor = currentDestinationFloor;
    }

    public void pressButton(int floor) {
        currentDestinationFloor = floor;
        System.out.println("Moving up");
    }

    public void reachFloor() {
        System.out.println("Floor Reached: " + currentDestinationFloor);
    }
}

class MovingDownState implements ElevatorState {
    private int currentDestinationFloor;
    private Elevator elevator;
    public MovingDownState(Elevator elevator, int currentDestinationFloor) {
        this.elevator = elevator;
        this.currentDestinationFloor = currentDestinationFloor;
    }
    public void pressButton(int floor) {
        currentDestinationFloor = floor;
        System.out.println("Moving down");
    }

    public void reachFloor() {
        System.out.println("Floor Reached: " + currentDestinationFloor);
    }
}

// Context
class Elevator {
    private ElevatorState currentState;
    private int currentFloor;
//    private String currentState;

    public Elevator(int currentFloor) {
        this.currentFloor = currentFloor;
        this.currentState = new IdleState(this);
    }

    public void setState(ElevatorState state) {
        this.currentState = state;
    }

    public void pressButtonInElevator(int floor) {
        currentState.pressButton(floor);
    }

    public void reachFloorInElevator() {
        currentState.reachFloor();
    }

    public int getCurrentFloor() {
        return currentFloor;
    }
}

// Client
public class StatePatternExample {
    public static void main(String[] args) {
        Elevator elevator = new Elevator(4);

        // Test the elevator starting in the Idle state
        ElevatorState idleState = new IdleState(elevator);
        elevator.setState(idleState);

        // Press button to go to the 5th floor
        elevator.pressButton(5);

        // Simulate the elevator reaching the 5th floor
        elevator.reachFloor();

        // Additional Test Cases:
        ElevatorState movingUpState = new MovingUpState(elevator);
        elevator.setState(movingUpState);
        elevator.pressButton(3);

        ElevatorState movingDownState = new MovingDownState(elevator);
        elevator.setState(movingDownState);
        elevator.pressButton(1);
    }
}
