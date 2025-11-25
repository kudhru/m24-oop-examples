/*
* Problem Statement
Implement a Traffic Light System with three states:

Red: The light is red, and vehicles must stop.
Yellow: The light is yellow, and vehicles should prepare to stop.
Green: The light is green, and vehicles can move.

The states must have the following methods:

public void nextLight() - Transition to the next state.
public void displayLight() - Display the current light.
Write the states using the State Design Pattern and provide transitions between them.
* */

// State Interface
interface TrafficLightState {
    void nextLight();
    void displayLight();
}

// Concrete States
// Implement RedLightState, YellowLightState, and GreenLightState classes here
class RedLightState implements TrafficLightState {
	TrafficLight trafficlight;
	
	public RedLightState(TrafficLight trafficlight) {
		this.trafficlight = trafficlight;
	}
	
	public void nextLight() {
		
	}
	
    public void displayLight() {
    	
    }
}


// Context
class TrafficLight {
    private TrafficLightState currentState;

    public void setState(TrafficLightState state) {
        this.currentState = state;
    }

    public void nextLight() {
        currentState.nextLight();
    }

    public void displayLight() {
        currentState.displayLight();
    }
}

// Client
public class StatePatternExample2 {
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();

        // Test starting with the Red light
        TrafficLightState redLight = new RedLightState(trafficLight);
        trafficLight.setState(redLight);

        trafficLight.displayLight(); // Red
        trafficLight.nextLight();   // Transition to Yellow

        trafficLight.displayLight(); // Yellow
        trafficLight.nextLight();   // Transition to Green

        trafficLight.displayLight(); // Green
        trafficLight.nextLight();   // Transition back to Red
    }
}