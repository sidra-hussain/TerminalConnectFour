import java.util.*;
public class PlayConnectFour {

    public static void main (String [] args){

        Scanner scanner = new Scanner (System.in);
        ConnectFour game = new ConnectFour ();
        TurnManager turnManager = new TurnManager();

        while(!game.isGameOver()){
            
            //print the current state of the game
            System.out.println (game.toString());

            System.out.println("Player " + turnManager.getCurrentTurn() + "'s turn. Select a column between 1 and 7 to drop your piece");
            int play = scanner.nextInt();

            //handle invalid moves
            if(play > 6 || play < 0 || game.playerMove(turnManager.getCurrentTurn(), play-1) == false){
                System.out.println("The play you entered is invalid, please play a valid column to place a piece in between 1 and 7");
                scanner.nextLine();
            }

            //when the move is valid complete the turn
            else{
                
                //complete the previous player's turn
                turnManager.completeTurn();
            }
        }

        System.out.println(game.toString());

        if (game.winner != 1 && game.winner != 2){ 
            System.out.println("GAME OVER: NO WINNER");
        }
        else{
            System.out.println("PLAYER: " + game.winner + " WINS!");
        }
        
        scanner.close();
    }
    
}
