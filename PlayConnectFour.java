import java.util.*;
public class PlayConnectFour {

    public static void main (String [] args){

        Scanner scanner = new Scanner (System.in);
        ConnectFour game = new ConnectFour ();
        TurnManager turnManager = new TurnManager();

        System.out.println (game.toString());

        while(!game.isGameOver){
            
            //print the current state of the game
            game.toString();

            System.out.println("Player " + turnManager.getCurrentTurn() + "'s turn. Select a column between 0 and 6 to drop your piece");
            int play = scanner.nextInt();

            //handle invalid moves
            if(play > 6 || play < 0 || game.playerMove(turnManager.getCurrentTurn(), play) == false){
                System.out.println("The play you entered is invalid, please play a valid column between 0 and 6");
            }

            //when the move is valid complete the turn
            else{
                
                //complete the previous player's turn
                turnManager.completeTurn();
            }
        }

        System.out.println("PLAYER: " + game.winner + "WINS!");
    }
    
}
