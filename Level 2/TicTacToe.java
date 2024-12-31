import java.util.Scanner;
public class TicTacToe {
    static final int SIZE = 3;
    static char[][] board = new char[SIZE][SIZE];
    static char currentPlayer = 'X';
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;
        do {
            initializeBoard();
            boolean gameOver = false;
            while (!gameOver) {
                printBoard();
                playerMove(scanner);
                gameOver = checkWin() || checkDraw();
                switchPlayer();
            }
            printBoard();
            if (checkWin()) {
                switchPlayer(); 
                System.out.println("Player " + currentPlayer + " wins!");
            } else {
                System.out.println("It's a draw!");
            }
            System.out.print("Do you want to play again? (y/n): ");
            playAgain = scanner.next().charAt(0) == 'y';
        } while (playAgain);

        System.out.println("Thank you for playing!");
        scanner.close();
    }
    public static void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = ' ';
            }
        }
        currentPlayer = 'X';
    }
    public static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print("| " + board[i][j] + " ");
            }
            System.out.println("|");
            System.out.println("-------------");
        }
    }
    public static void playerMove(Scanner scanner) {
        int row, col;
        boolean validMove = false;
        while (!validMove) {
            System.out.println("Player " + currentPlayer + "'s turn. Enter row and column (1-3): ");
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;
            if (row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] == ' ') {
                board[row][col] = currentPlayer;
                validMove = true;
            } else {
                System.out.println("This move is not valid. Try again.");
            }
        }
    }
    public static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
    public static boolean checkWin() {
        for (int i = 0; i < SIZE; i++) {
            if (checkRow(i) || checkColumn(i)) {
                return true;
            }
        }
        return checkDiagonal();
    }
    public static boolean checkRow(int row) {
        return board[row][0] == currentPlayer && board[row][1] == currentPlayer && board[row][2] == currentPlayer;
    }
    public static boolean checkColumn(int col) {
        return board[0][col] == currentPlayer && board[1][col] == currentPlayer && board[2][col] == currentPlayer;
    }
    public static boolean checkDiagonal() {
        return (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
               (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer);
    }
    public static boolean checkDraw() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
