import java.util.*;

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

        //directions you can make a set with 
        int[][] dirs = {
            {0, 1},  // Horizontal 
            {1, 0},  // Vertical 
            {1, 1},  // Diagonal 
            {1, -1}  // Diagonal 
        };

        //iterate over every piece to see if a winning play has been made
        int boardCount = 0;
        for (int row=0; row < board.length; row++){
            for (int col=0; col < board[row].length; col++){
                //check if the current spot has something played in it
                if(board[row][col] != 0){
                    boardCount++;
                    //check to see if this makes a set of 4
                    int player = board[row][col];

                    //for every direction see if it starts a chain
                    for (int [] dir : dirs){
                        
                        int nextRow = row;
                        int nextCol = col;
                        int playCount = 1;

                        //take 3 more steps in that direction
                        for (int i=0; i < 3; i++){
                            
                            nextRow+=dir[0];
                            nextCol+=dir[1];

                            //check the value is within the bound 
                            if(nextRow >= board.length || nextRow < 0 || nextCol >= board[0].length || nextCol < 0){
                                break;
                            }

                            //if we have more pieces in the chain increment the count
                            else if (board[nextRow][nextCol] == player){
                                playCount++;
                            }

                            //chain is broken so end
                            else{
                                break;
                            }

                        }

                        //if we found 4 in a row we have a winner
                        if (playCount == 4){
                            winner = player;
                            return true;
                        }
                    }

                }

            }
        }

        //check if the board is full, if full than game over, otherwise the game keeps going
        return boardCount == board.length*board[0].length;
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
