public class ConnectFour {

    int [][] board;
    int winner;

    public ConnectFour () {
        board = new int [6][7];
        int winner = 0;

    }

    //TODO
    //Description: This function performs the move a player indicates on the board
    //Inputs: player = player performing the move, row = the row the player is dropping their piece into 
    //Return Values: Returns true if the move is valid, else false
    public boolean playerMove(int player, int row){

        return false;

    }
    

    //TODO
    //Description: This function checks if a player has won, and stores the player number of the winner
    //Inputs: None
    //Return Values: Returns true if the game is over, else returns false
    public boolean isGameOver(){

        return false;
    }

    public String toString (){
        String boardString = "";
        for (int i=0; i < board.length; i++){
            for (int j=0; j < board[i].length; j++){
                boardString+=board[i][j] + " ";
            }
            boardString+="\n";
        }
        
        return boardString;
    }
    
}
