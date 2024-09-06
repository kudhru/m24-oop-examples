interface SharedConstants {
    int NO = 0;
    int YES = 1;
}

class DecisionMaker implements SharedConstants {
    public void printDecision(int decision) {
        switch (decision) {
            case NO:
                System.out.println("Decision: No");
                break;
            case YES:
                System.out.println("Decision: Yes");
                break;
            default:
                System.out.println("Invalid decision");
        }
    }
}

public class TestInterfaceVariables {
    public static void main(String[] args) {
        DecisionMaker dm = new DecisionMaker();
        dm.printDecision(SharedConstants.YES);  // Accessing interface constants
    }
}