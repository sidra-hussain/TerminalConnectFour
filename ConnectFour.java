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
    public boolean playerMove(int player, int col){

        //check if the row is full
        if(board[0][col] != 0){return false;}
        
        //find the first empty row from the bottom in col and place the player's piece
        for (int row=board.length-1; row >= 0; row--){
            if(board[row][col] == 0){
                board[row][col] = player;
                return true;
            }
        }

        //return false if the play cannot be made
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
        for (int row=0; row < board.length; row++){
            for (int col=0; col < board[row].length; col++){
                boardString+=board[row][col] + " ";
            }
            boardString+="\n";
        }
        
        return boardString;
    }
    
}
