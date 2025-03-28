//Author: Sidra Hussain
//Description: A utility class to help determine, which player's turn it is and keep track of which turns have been taken

public class TurnManager {
    
    boolean player1Turn; 

    public TurnManager(){
        player1Turn = true;
    }

    public void completeTurn (){
        
        player1Turn = !player1Turn;
    }

    public int getCurrentTurn(){

        if (player1Turn){
            return 1;
        }
        
        return 2;
    }

    public boolean isPlayer1Turn (){
        return player1Turn;
    }

    public boolean isPlayer2Turn (){
        return !player1Turn;
    }
}
