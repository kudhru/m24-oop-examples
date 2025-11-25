/*
 * The State design pattern is perfectly suited for a vending machine because the machine's behavior changes dramatically depending on its current state (e.g., whether it has money, whether an item is selected, or if it's out of stock).
This pattern encapsulates the behavior for each state into separate classes and delegates the machine's actions to the current state object.
Scenario: Vending Machine States
We define an interface for the states and implement specific classes for each behavior:
NoCoinState: Waits for money. Cannot dispense or refund.
HasCoinState: Money inserted. Can select an item, dispense, or refund money.
SoldState: Currently dispensing an item.
OutOfStockState: Cannot accept money or dispense.
 */

import java.math.BigDecimal;

// 1. The State Interface
interface State {
    void insertCoin(BigDecimal amount);
    void selectItem(String itemCode);
    void dispense();
    void refund();
}

// 2. The Context (VendingMachine)
class VendingMachine {
    State noCoinState;
    State hasCoinState;
    State soldState;
    State outOfStockState;

    State currentState;
    int stock = 0;
    BigDecimal currentMoney = BigDecimal.ZERO;

    public VendingMachine(int initialStock) {
        noCoinState = new NoCoinState(this);
        hasCoinState = new HasCoinState(this);
        soldState = new SoldState(this);
        outOfStockState = new OutOfStockState(this);

        this.stock = initialStock;
        // Initial state is determined by stock level
        if (initialStock > 0) {
            currentState = noCoinState;
        } else {
            currentState = outOfStockState;
        }
    }

    // Methods delegated to the current state object
    public void insertCoin(BigDecimal amount) {
        currentState.insertCoin(amount);
    }

    public void selectItem(String itemCode) {
        currentState.selectItem(itemCode);
    }

    public void pressDispenseButton() {
        currentState.dispense();
    }

    public void pressRefundButton() {
        currentState.refund();
    }

    // Helper method to transition states
    public void setState(State newState) {
        this.currentState = newState;
    }

    // Getters for states
    public State getNoCoinState() { return noCoinState; }
    public State getHasCoinState() { return hasCoinState; }
    public State getSoldState() { return soldState; }
    public State getOutOfStockState() { return outOfStockState; }
    
    // Logic for dispensing an item
    public void releaseItem() {
        if (stock > 0) {
            stock--;
            System.out.println("Item dispensed. Stock remaining: " + stock);
        }
    }
}

// 3. Concrete State Implementations

class NoCoinState implements State {
    VendingMachine machine;

    public NoCoinState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin(BigDecimal amount) {
        System.out.println("Accepted $" + amount + ". Moving to HasCoinState.");
        machine.currentMoney = machine.currentMoney.add(amount);
        machine.setState(machine.getHasCoinState());
    }

    @Override
    public void selectItem(String itemCode) {
        System.out.println("Please insert coin first.");
    }

    @Override
    public void dispense() {
        System.out.println("Cannot dispense without payment.");
    }
    
    @Override
    public void refund() {
        System.out.println("No money to refund.");
    }
}

class HasCoinState implements State {
    VendingMachine machine;

    public HasCoinState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin(BigDecimal amount) {
        machine.currentMoney = machine.currentMoney.add(amount);
        System.out.println("Added $" + amount + " to balance. Total: $" + machine.currentMoney);
    }

    @Override
    public void selectItem(String itemCode) {
        // Simplified check, assuming all items cost $1
        if (machine.currentMoney.compareTo(new BigDecimal("1.00")) >= 0) {
            System.out.println("Item " + itemCode + " selected. Moving to SoldState.");
            machine.setState(machine.getSoldState());
            machine.pressDispenseButton(); // Automatically dispense after selection
        } else {
            System.out.println("Insufficient funds. Need $1.00.");
        }
    }

    @Override
    public void dispense() {
        // Should only be called internally after moving to SoldState
        System.out.println("Error: Cannot dispense here. Select item first.");
    }
    
    @Override
    public void refund() {
        System.out.println("Refunding $" + machine.currentMoney);
        machine.currentMoney = BigDecimal.ZERO;
        machine.setState(machine.getNoCoinState());
    }
}

class SoldState implements State {
    VendingMachine machine;

    public SoldState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin(BigDecimal amount) {
        System.out.println("Please wait. Dispensing current item first.");
    }

    @Override
    public void selectItem(String itemCode) {
        System.out.println("Dispensing current item first.");
    }

    @Override
    public void dispense() {
        machine.releaseItem();
        machine.currentMoney = machine.currentMoney.subtract(new BigDecimal("1.00")); // Assume $1 cost
        
        if (machine.currentMoney.compareTo(BigDecimal.ZERO) > 0) {
            System.out.println("Change due: $" + machine.currentMoney + ". Returning to NoCoinState after refunding change.");
            machine.currentMoney = BigDecimal.ZERO; // "Refund" the change amount
            machine.setState(machine.getNoCoinState());
       } else {
           System.out.println("Returning to NoCoinState.");
           machine.setState(machine.getNoCoinState());
       }
       
        if (machine.stock == 0) {
            System.out.println("Machine is now out of stock.");
            machine.setState(machine.getOutOfStockState());
        }
    }
    
    @Override
    public void refund() {
        System.out.println("Cannot refund during dispense.");
    }
}

class OutOfStockState implements State {
    VendingMachine machine;

    public OutOfStockState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin(BigDecimal amount) {
        System.out.println("Machine is out of stock. Coin returned.");
    }

    @Override
    public void selectItem(String itemCode) {
        System.out.println("Machine is out of stock.");
    }

    @Override
    public void dispense() {
        System.out.println("Machine is out of stock.");
    }
    
    @Override
    public void refund() {
        System.out.println("Machine is out of stock. No money to refund.");
    }
}


// 4. Demonstration
public class StatePatternExample3 {
    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine(2); // Start with 2 items

        System.out.println("--- Scenario 1: Successful purchase ---");
        vm.selectItem("A1"); // Cannot select item yet (NoCoinState)
        vm.insertCoin(new BigDecimal("1.00"));
        vm.selectItem("A1"); // Item A1 selected, moves to SoldState, dispenses
        // Machine is now back in NoCoinState, stock is 1

        System.out.println("\n--- Scenario 2: Purchase with change ---");
        vm.insertCoin(new BigDecimal("5.00"));
        vm.selectItem("B2"); // Item B2 selected, dispenses
        // Machine refunds $4 change and is back in NoCoinState, stock is 0

        System.out.println("\n--- Scenario 3: Out of Stock behavior ---");
        vm.insertCoin(new BigDecimal("1.00")); // Machine reports out of stock and returns coin
        vm.pressDispenseButton();
    }
}
