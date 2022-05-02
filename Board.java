import java.util.Scanner;
public class Board {
    //intilaizing the board
    // each array has 15 elements because each column for the board is 2 indices
    // so i need double the number of columns plus 1 (7x2+1= 15)
    //i added extra array and elements so i can add numbers for each column
    private String[][] board = new String[8][16]; 
    
    
    
    //making the board layout
    Board()
    {
        for (int i =0;i<board.length;i++)
        {
            for (int j =0;j<board[i].length;j++)
            {
                // this is for formatting the board, 
                // for some reason on different computers the output is different
                // so it might be too long or too short
                if (j% 2 == 0)
                {  
                    board[i][j] =" \t| ";
                }
                else 
                {
                    board[i][j] = " ";
                }
                if (i==6)
                {
                    board[i][j]= "=====";
                }
                
                if (i==7&&j<7)
                {
                    board[i][j]=" \t   "+j;
                }
                
                
                    
                
                
                
      
            }  
        }
        //this is for the column numbers below the board
        // without this the numbers continue all the way to 15
        board[7][7]=" \t   ";
        board[7][8]=" \t   ";
        board[7][9]=" \t   ";
        board[7][10]=" \t   ";
        board[7][11]=" \t   ";
        board[7][12]=" \t   ";
        board[7][13]=" \t   ";
        board[7][14]=" \t   ";
        
    }
    
    
    
    
    // a getter method to return board
    String[][] getBoard(){
        return board;
    }
    
    //prints out the board on the console
    public  void printPattern(String[][] board)
    {
        for (int i =0;i<board.length;i++)
        {
            for (int j=0;j<board[i].length;j++)
            {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
    
    
    // asks player red which column to put their disc at
    public  void dropRedDisc(String[][] board)
  {
    System.out.println("\n\nPlayer 1, Drop a red disc at column (between 0–6): ");
    Scanner scanner = new Scanner (System.in);
    
    // this is for illegal moves incase the player 1 enters a column that is outside the board
    int d = scanner.nextInt();
    while(d<0||d>6){
        System.out.println("Player 1,Please enter a number between 0-6");
        d = scanner.nextInt();
    }
    
    // this is for the fact that the number of columns is doubled the number of columns in a connect 4 board
    d = ((2*d)+ 1);
    
    for (int i =5;i>=0;i--)
    {
      if (board[i][d] == " ")
      {
        board[i][d] = "R";
        break;
      }
      
    }
  
  }


// asks player yellow which column to put their disc at
  public  void dropYellowDisc(String[][] board)
  {
    System.out.println("\n\nPlayer 2, Drop a yellow disc at column (between 0–6): ");
    Scanner scanner = new Scanner (System.in);
    
    // this is for illegal moves incase the player 2 enters a column that is outside the board
    int d = scanner.nextInt();
    while(d<0||d>6){
        System.out.println("Player 2, Please enter a number between 0-6");
        d = scanner.nextInt();
    }
    
    d = ((2*d)+ 1);
    
    for (int i =5;i>=0;i--)
    {
      if (board[i][d] == " "){
         board[i][d] = "Y ";
         break;
      }
    }
  }
  
  
    // to check winner
    public  String checkWinner(String[][] board)
    {
    
// checks if four of the same discs are beside each other horizontally
    for (int i =0;i<6;i++)
    {
      for (int j=0;j<7;j+=2)
      {
        if ((board[i][j+1] != " ") && (board[i][j+3] != " ") && (board[i][j+5] != " ") && (board[i][j+7] != " ") && ((board[i][j+1] == board[i][j+3]) && (board[i][j+3] == board[i][j+5]) && (board[i][j+5] == board[i][j+7]))){
        return board[i][j+1]; 
        }
      }
    }
    
// checks if four of the same discs are beside each other vertically
    for (int i=1;i<15;i+=2)
    {
      for (int j =0;j<3;j++)
      {
        if((board[j][i] != " ") && (board[j+1][i] != " ") && (board[j+2][i] != " ") && (board[j+3][i] != " ") && ((board[j][i] == board[j+1][i]) && (board[j+1][i] == board[j+2][i]) && (board[j+2][i] == board[j+3][i]))){
              return board[j][i]; 
        }
      } 
    }
    


// checks if four of the same discs are beside each other diagonally going right   
    for (int i=0;i<3;i++)
    {
      for (int j=1;j<9;j+=2)
      {
        if((board[i][j] != " ") && (board[i+1][j+2] != " ") && (board[i+2][j+4] != " ") && (board[i+3][j+6] != " ") && ((board[i][j] == board[i+1][j+2]) && (board[i+1][j+2] == board[i+2][j+4]) && (board[i+2][j+4] == board[i+3][j+6])))
        {
              return board[i][j]; 
        }
      } 
    }
    
// checks if four of the same discs are beside each other diagonally going left    
    for (int i=0;i<3;i++)
    {
      for (int j=7;j<15;j+=2)
      {
        if((board[i][j] != " ") && (board[i+1][j-2] != " ") && (board[i+2][j-4] != " ") && (board[i+3][j-6] != " ") && ((board[i][j] == board[i+1][j-2]) && (board[i+1][j-2] == board[i+2][j-4]) && (board[i+2][j-4] == board[i+3][j-6]))){
              return board[i][j];
        }
      }  
    }
    return null;
  }

    
    
    
    
    
    
    
    
    
    
}