//Author: Sidra Hussain
//Description: A utility class to help determine, which player's turn it is and keep track of which turns have been taken

public class TurnManager {
    
    boolean player1Turn; 

    //Constructor: Intializes the turn manager
    public TurnManager(){
        player1Turn = true;
    }

    //Description: Swaps the current player's turn
    //Input: None
    //Output: None
    public void completeTurn (){
        
        player1Turn = !player1Turn;
    }

    //Description: Gets the turn of the current player 
    //Input: None
    //Output: 1 if it is player 1's turn and 2 if it is player 2's turn
    public int getCurrentTurn(){

        return (player1Turn == true) ? 1 : 2;
    }
}
