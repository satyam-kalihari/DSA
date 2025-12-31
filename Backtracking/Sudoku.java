package Backtracking;

public class Sudoku {

    public static boolean isSafe(int[][] sudoku, int row, int col, int digit){

        //col wise
        for (int i = 0; i < sudoku.length; i++) {
            if (sudoku[i][col] == digit) {
                return false;
            }
        }

        //row wise
        for (int i = 0; i < sudoku.length; i++) {
            if (sudoku[row][i] == digit) {
                return false;
            }
        }

        //in the box
        row = (row/3)*3; col = (col/3)*3;
        for (int i = row; i < row+3; i++) {
            for (int j = col; j < col+3; j++) {
                if (sudoku[i][j] == digit) {
                    return false;
                }
            }
        }

        return true;
    }
    
    public static boolean sudokuSolver(int[][] sudoku, int row, int col){
        if (row == 9 && col == 0) {
            return true;
        }

        int nexRow = row, nexCol = col+1;
        if (col+1 == 9) {
            nexRow = row+1;
            nexCol = 0;
        }

        if (sudoku[row][col] != 0) {
            return sudokuSolver(sudoku, nexRow, nexCol);
        }

        for (int i = 1; i < 10; i++) {
            if (isSafe(sudoku, row, col, i)) {
                sudoku[row][col] = i;
                if (sudokuSolver(sudoku, nexRow, nexCol)) {
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }

        return false;
    }

    public static void printSudoku(int[][] sudoku){
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku.length; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int sudoku[][] = {
            {0, 0, 8, 0, 0, 0, 0, 0, 0},
            {4, 9, 0, 1, 5, 7, 0, 0, 2},
            {0, 0, 3, 0, 0, 4, 1, 9, 0},
            {1, 8, 5, 0, 6, 0, 0, 2, 0},
            {0, 0, 0, 0, 2, 0, 0, 6, 0},
            {9, 6, 0, 4, 0, 5, 3, 0, 0},
            {0, 3, 0, 0, 7, 2, 0, 0, 4},
            {0, 4, 9, 0, 3, 0, 0, 5, 7},
            {8, 2, 7, 0, 0, 9, 0, 1, 3}
        };

        System.out.println(sudokuSolver(sudoku, 0, 0));
        printSudoku(sudoku);
    }
}