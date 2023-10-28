import java.util.Random;
import java.util.Scanner;

public class Tictactoe {

    public static void main(String[] args) {
        char[][] board = {{' ', ' ', ' '},
                          {' ', ' ', ' '},
                          {' ', ' ', ' '}};
        printBoard(board);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Do you wanna play against a computer or friend against friend? 1 for computer, 2 otherwise");
        String computerOrFriend = scanner.nextLine();

        if(computerOrFriend.equals("1")) {
            computerGame(board,scanner);
        } else {
            playerPlayerGame(board,scanner);
        }


    }



    private static void computerGame(char[][] board, Scanner scanner) {
        while(true) {
            System.out.println("Where would you like to play? (1-9)");
            playerTurn(board,scanner, 'X');
            if(isGameFinished(board, 'X', true)) {
                break;
            }
            computerTurn(board, 'O');
            if(isGameFinished(board, 'O', true)) {
                break;
            }
        }
    }
    private static void playerPlayerGame(char[][] board, Scanner scanner) {
        while(true) {
            System.out.println("Player 1 turn: where would you like to play? (1-9)");
            playerTurn(board,scanner, 'X');
            if(isGameFinished(board, 'X', false)) {
                break;
            }
            System.out.println("Player 2 turn: where would you like to play? (1-9)");
            playerTurn(board, scanner, 'O');
            if(isGameFinished(board, 'O', false)) {
                break;
            }
        }
    }



    private static void computerTurn(char[][] board, char symbol) {
        Random rand = new Random();
        int computerPlay;
        while(true) {
            computerPlay = rand.nextInt(9) + 1;
            if(isValidMove(board, Integer.toString(computerPlay))) {
                break;
            }
        }
        System.out.println("Computer turn is: ");
        turn(board, Integer.toString(computerPlay), symbol);
    }
    private static void playerTurn(char[][] board, Scanner scanner, char symbol)     {

        String userInput = scanner.nextLine();
        while(true) {
            if(isValidMove(board, userInput)) {
                break;
            } else {
                System.out.println("This is not a valid move! please peak again(1-9)");
                userInput = scanner.nextLine();
            }
        }
        turn(board, userInput, symbol);
    }



    private static boolean isGameFinished(char[][] board, char symbol, boolean isComputerGame) {

        // checks if someone won:
        if(hasSomeoneWon(board,symbol)) {
            if(symbol == 'X' && isComputerGame) {
                System.out.println("You won!");
            } else if(symbol == 'X' && !isComputerGame) {
                System.out.println("Player 1 won!");
            } else if(symbol == 'O' && isComputerGame) {
                System.out.println("The computer won!");
            } else {
                System.out.println("Player 2 won!");
            }
            return true;
        }

        // check if it is  a tie:
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                if(board[i][j] == ' ') {
                    return false;
                }
            }
        }
        System.out.println("The game ended in a tie!");
        printBoard(board);
        return true;
    }
    private static boolean hasSomeoneWon(char[][] board, char symbol) {

        if((board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol) ||
        (board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol) ||
        (board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol) ||

         (board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol) ||
         (board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol) ||
         (board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol) ||

         (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
         (board[2][0] == symbol && board[1][1] == symbol && board[0][2] == symbol) )
        {
            return true;
        }
        return false;
    }



    private static void turn(char[][] board, String position, char symbol) {
        switch (position) {
            case "1":
                board[0][0] = symbol;
                break;
            case "2":
                board[0][1] = symbol;
                break;
            case "3":
                board[0][2] = symbol;
                break;
            case "4":
                board[1][0] = symbol;
                break;
            case "5":
                board[1][1] = symbol;
                break;
            case "6":
                board[1][2] = symbol;
                break;
            case "7":
                board[2][0] = symbol;
                break;
            case "8":
                board[2][1] = symbol;
                break;
            case "9":
                board[2][2] = symbol;
                break;
            default:
                System.out.println("What?");
        }

        printBoard(board);
    }
    private static boolean isValidMove(char[][] board, String position) {
        switch (position) {
            case "1":
                return (board[0][0] == ' ');
            case "2":
                return (board[0][1] == ' ');
            case "3":
                return (board[0][2] == ' ');
            case "4":
                return (board[1][0] == ' ');
            case "5":
                return (board[1][1] == ' ');
            case "6":
                return (board[1][2] == ' ');
            case "7":
                return (board[2][0] == ' ');
            case "8":
                return (board[2][1] == ' ');
            case "9":
                return (board[2][2] == ' ');
            default:
                return false;
        }
    }
    private static void printBoard(char[][] board) {
        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2] + "|");
        System.out.println("-+-+-+");
        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2] + "|");
        System.out.println("-+-+-+");
        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2] + "|");
    }
}