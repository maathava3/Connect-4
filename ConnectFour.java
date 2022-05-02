import java.util.Scanner;

public class ConnectFour
{

  public static void main (String[] args)
  {
    Scanner scanner = new Scanner (System.in);
    System.out.println("\nWelcome to Connect 4!\nThis is a TWO player game\nPlayers will take turns choosing a column to drop their disc into ");
    System.out.println("First player to get 4 discs in a row diagonally, horizontally, or verticcally wins");
    System.out.println("Player 1 is Red and Player 2 is Yellow");
    System.out.println("\n");
    
    boolean restart = true;
    while(restart)
    {
    // the game instructions
    
    
    
    
    //intiallizaing a board object
    Board board1 = new Board();
    
    // assigning the value of the board1 object to make things easier
    // getBoard() is the method for creating the board
    String[][] board = board1.getBoard();
    
    
    //this is for the loop
    boolean loop = true;
    //used for checking the number of turns
    int count = 0;
    board1.printPattern(board);
    
    while(loop)
    {
    // this if statement determines if it is player red's turn or player yellow's
       if (count % 2 == 0){
           board1.dropRedDisc(board);
       } 
       else {
           board1.dropYellowDisc(board);
       }
       
       count++;
       
       // gets the win condition to check if the condittions have been met
       //then prints the winner
       board1.printPattern(board);
       if (board1.checkWinner(board) != null)
       {
          // checks who wins the game and prints out the winner
          if (board1.checkWinner(board) == "R")
          {
             System.out.println("\nPlayer Red has won the game!");
             System.out.println("Better luck next time Player Yellow  :)");
          } 
          else  //(board1.checkWinner(board)== "Y")
          {
            System.out.println("\nPlayer Yellow has won the game!");
            System.out.println("Better luck next time Player Red  :)");
          }
        // if there is a winner, the loop must be stopped so variable loop is set to false
        loop = false;
       }
    }
    
    
    
    
    
    
    // this is for asking the users if they want to play again
    System.out.println("Do you want to play again(Type \"yes\" or \"no\")");
    String restarts = scanner.nextLine();
    if (restarts.equals("no")){
        break;
        
    }
    else if (restarts.equals("yes")){

        System.out.println("\nNEW GAME");
        System.out.println("");
        
    }
    
    
    
    
    
    
    
  }
  
  
  
  
  
  
  
  
}























}