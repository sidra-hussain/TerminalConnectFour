//Author: Sidra Hussain
//Description: A utility class to help determine, which player's turn it is and keep track of which turns have been taken

public class TurnManager {
    
    boolean player1Turn; 

    public TurnManager(){
        this.player1Turn = true;
    }

    public void completeTurn (){
        
        this.player1Turn = !this.player1Turn;
    }

    public int getCurrentTurn(){

        return (this.player1Turn == true) ? 1 : 2;
    }
}
