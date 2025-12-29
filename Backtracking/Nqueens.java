package Backtracking;

public class Nqueens {

    public static boolean isSafe(char[][] board,int i, int j){
        //for up
        for (int j2 = i; j2 >=0; j2--) {
            if (board[j2][j] == 'Q') {
                return false;
            }
        }

        //for vertical left
        int j2 = i;
        int k = j;
        while (j2 >= 0 && k >= 0) {
            if (board[j2--][k--] == 'Q') {
                return false;
            }
        }

        //for vertical right
        j2 = i;
        k = j;
        while (j2 >= 0 && k < board.length) {
            if (board[j2--][k++] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void nQueens(char[][] board, int i){
        if (i == board.length) {
            printBoard(board);
            return;
        }

        for (int j = 0; j < board.length; j++) {
            if (isSafe(board,i, j)) {
                board[i][j] = 'Q';
                nQueens(board, i+1);
                board[i][j] = 'x';
            }
        }
    }

    public static void printBoard(char[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("_________________");
    }
    
    public static void main(String[] args) {
        char[][] board = new char[5][5];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = 'x';
            }
        }

        nQueens(board, 0);
    }
}
