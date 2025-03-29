public class ConnectFourGameTester {

    public static void main(String[] args) {
        
        System.out.println("TESTING THE TURN MANAGER...\n");
        testInitialTurn();
        testCompleteTurn();
        testGetCurrentTurn();

        System.out.println("\nTESTING THE GAME BOARD...\n");
        testConnectFourToStringEmpty();
        
    }

    //*****TURN MANAGER TESTS********

    // Tests that the initial turn starts with player 1
    public static void testInitialTurn() {
        TurnManager turnManager = new TurnManager();
        if (turnManager.getCurrentTurn() == 1) {
            System.out.println("TEST 1 PASSED: Initial turn is Player 1");
        } else {
            System.out.println("TEST 1 FAILED: Initial turn is not Player 1");
        }
    }

    // Tests that completing a turn switches to the other player
    public static void testCompleteTurn() {
        TurnManager turnManager = new TurnManager();
        turnManager.completeTurn();
        if (turnManager.getCurrentTurn() == 2) {
            System.out.println("TEST 2 PASSED: Turn switches to Player 2");
        } else {
            System.out.println("TEST 2 FAILED: Turn did not switch to Player 2");
        }
    }
    
    // Tests getCurrentTurn to ensure it correctly returns the active player
    public static void testGetCurrentTurn() {
        TurnManager turnManager = new TurnManager();
        if (turnManager.getCurrentTurn() == 1) {
            turnManager.completeTurn();
            if (turnManager.getCurrentTurn() == 2) {
                System.out.println("TEST 3 PASSED: getCurrentTurn works correctly");
                return;
            }
        }
        System.out.println("TEST 3 FAILED: getCurrentTurn did not return correct player");
    }

    //*****GAME BOARD TESTS********
    //Tests that an empty board is correctly printed
    public static void testConnectFourToStringEmpty(){
        ConnectFour game = new ConnectFour();
        String resultString = game.toString();
        String expectedString = "0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 \n";
        
        if (resultString.equals(expectedString)){System.out.println("TEST 1 PASSED: Print an Empty Board");}
        else{System.out.println("TEST 1 FAILED: Print an Empty Board");}
    }
}
