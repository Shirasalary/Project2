import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        char[] board = new char[9];
        checkRow(board);
        System.out.println("Welcome to the game tic-tac-toe!");
        boolean isThereAWinner;
        int position;
        for (int i = 0; i<9; i++)
        {
            if (i % 2==0) {
                System.out.println("player 1 (x): your turn");
                position = getPositionFromUser(board);
                isThereAWinner = placeSymbolOnBoard(board, position,'x' );
                if (isThereAWinner)
                {
                    break;
                }
            }else {
                System.out.println("player 2 (o): your turn");
                position = getPositionFromUser(board);
                isThereAWinner = placeSymbolOnBoard(board, position,'o' );
                if (isThereAWinner)
                {
                    break;
                }

            }

        }
        if (checkWinner(board) == '-') {
            System.out.println("So sad, nobody won :(");
        }

    }

    public static void printBoard (char[] board)
    {
        for (int i = 0; i<board.length;i++)
        {
            if ((i+1)%3==0)
            {
                System.out.print(board[i]);
                System.out.println();
            }else{
                System.out.print(board[i] + ", ");
            }
        }
    }

    public static boolean isAvailable (char[] board, int index)
    {
        boolean returnValue = true;
        if (board[index] == 'o'||board[index] == 'x' )
        {
            returnValue = false;
        }
        return returnValue;
    }

    public static int getPositionFromUser (char[] board)
    {
        Scanner scanner = new Scanner(System.in);
        int postion;
        boolean firstTine = true;
        System.out.println("Enter postion between 1-9: ");
        postion= scanner.nextInt();
        do {
                if (postion<1 || postion>9) {
                    System.out.println("Please enter postion between 1-9, try again: ");
                    postion= scanner.nextInt();
                }else if (isAvailable(board,postion-1) == false){
                    System.out.println(" The postion is not available");
                    System.out.println(" Try again, please enter postion between 1-9: ");
                    postion= scanner.nextInt();
                }

        }while ( (postion<1 || postion>9) || isAvailable(board,postion-1) == false);

        return  postion;
    }

    public static char checkRow(char[] board)
    {
        char winner = '-';
        for (int i= 0; i< board.length-2;i+=3) {
            if (board[i] == 'o' && board[i + 1] == 'o' && board[i + 2] == 'o') {
                winner = 'o';
            } else if ((board[i] == 'x' && board[i + 1] == 'x' && board[i + 2] == 'x')) {
                winner = 'x';
            }
        }
        return winner;
    }

    public static char checkColumn(char[] board)
    {
        char winner = '-';
        for (int i= 0; i< board.length-6;i+=3)
        {
            if ((board[i] == 'o' && board[i + 3] == 'o' && board[i + 6] == 'o')) {
                winner = 'o';
            } else if ((board[i] == 'x' && board[i + 3] == 'x' && board[i + 6] == 'x')) {
                winner = 'x';
            }
        }

        return winner;
    }
    public static char checkSlant(char[] board)
    {
        char winner = '-';
        if (board[4] == 'o')
        {
            if ( (board[0]=='o' && board[8]=='o') || (board[2]=='o' && board[6]=='o'))
                winner= 'o';
        }else if (board[4] == 'x')
        {
            if ( (board[0]=='x' && board[8]=='x') || (board[2]=='x' && board[6]=='x'))
                winner= 'x';

        }

        return winner;
    }
    public static char checkWinner (char[] board)
    {
        char winner = checkRow(board);
        if (winner== '-')
            winner = checkColumn(board);
        if (winner == '-') {
                winner = checkSlant(board);
        }


        return winner;

    }

    public static boolean placeSymbolOnBoard(char[] board, int index,char player)
    {
        boolean isThereAWinner = false;
        board[index-1]=player;
        printBoard(board);
        if (checkWinner(board) != '-')
        {
            System.out.println();
            System.out.println("The winner is "+ player);
            System.out.println();
            isThereAWinner = true;
        }

        return isThereAWinner;
    }

}
