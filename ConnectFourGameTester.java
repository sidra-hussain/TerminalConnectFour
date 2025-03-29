public class ConnectFourGameTester {

    public static void main(String[] args) {
        
        System.out.println("TESTING THE TURN MANAGER...\n");
        testInitialTurn();
        testCompleteTurn();
        testGetCurrentTurn();

        System.out.println("\nTESTING THE GAME BOARD...\n");
        testConnectFourToStringEmpty();
        testHorizontalWin();
        testVerticalWin();
        testDiagonalWinBottomLeftToTopRight();
        testDiagonalWinBottomRightToTopLeft();
        testNoWinner();
        
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

     // Test horizontal win for Player 1
    public static void testHorizontalWin() {
        int[][] board = {
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 0, 0, 0},  // Horizontal win for Player 1
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0}
        };
        ConnectFour game = new ConnectFour(board);
        if (game.isGameOver() && game.winner == 1) {
            System.out.println("TEST 2 PASSED: Horizontal win detected for Player 1");
        } else {
            System.out.println("TEST 2 FAILED: Horizontal win detected for Player 1");
        }
    }

    // Test vertical win for Player 2
    public static void testVerticalWin() {
        int[][] board = {
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {2, 0, 0, 0, 0, 0, 0},
            {2, 0, 0, 0, 0, 0, 0},
            {2, 0, 0, 0, 0, 0, 0},
            {2, 0, 0, 0, 0, 0, 0}  // Vertical win for Player 2
        };
        ConnectFour game = new ConnectFour(board);
        if (game.isGameOver() && game.winner == 2) {
            System.out.println("TEST 3 PASSED: Vertical win detected for Player 2");
        } else {
            System.out.println("TEST 3 FAILED: Vertical win detected for Player 2");
        }
    }

    // Test diagonal win (bottom-left to top-right) for Player 1
    public static void testDiagonalWinBottomLeftToTopRight() {
        int[][] board = {
            {0, 0, 0, 1, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0},  // Diagonal ↗ win for Player 1
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0}
        };
        ConnectFour game = new ConnectFour(board);
        if (game.isGameOver() && game.winner == 1) {
            System.out.println("TEST 4 PASSED: Diagonal win detected for Player 1");
        } else {
            System.out.println("TEST 4 FAILED: Diagonal win detected for Player 1");
        }
    }

    // Test diagonal win (bottom-right to top-left) for Player 2
    public static void testDiagonalWinBottomRightToTopLeft() {
        int[][] board = {
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 2},
            {0, 0, 0, 0, 0, 2, 0},
            {0, 0, 0, 0, 2, 0, 0},
            {0, 0, 0, 2, 0, 0, 0},  // Diagonal ↖ win for Player 2
            {0, 0, 0, 0, 0, 0, 0}
        };
        ConnectFour game = new ConnectFour(board);
        if (game.isGameOver() && game.winner == 2) {
            System.out.println("TEST 5 PASSED: Diagonal win detected for Player 2");
        } else {
            System.out.println("TEST 5 FAILED: Diagonal win detected for Player 2");
        }
    }

    // Test for no winner
    public static void testNoWinner() {
        int[][] board = {
            {1, 2, 1, 2, 1, 2, 1},
            {2, 1, 2, 1, 2, 1, 2},
            {1, 2, 1, 2, 1, 2, 1},
            {2, 1, 2, 1, 2, 1, 2},
            {1, 2, 1, 2, 1, 2, 1},
            {2, 1, 2, 1, 2, 1, 2}  // Full board, no four in a row
        };
        ConnectFour game = new ConnectFour(board);
        if (game.isGameOver() && game.winner == -1) {
            System.out.println("TEST 6 PASSED: No winner detected correctly");
        } else {
            System.out.println("TEST 6 FAILED: No winner detected correctly");
        }
    }

}
