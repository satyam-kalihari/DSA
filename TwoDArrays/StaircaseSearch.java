package TwoDArrays;

public class StaircaseSearch {

    public static boolean stairCaseSearch(int[][] matrix, int key){

        int row = 0, col = matrix.length -1;

        while (row < matrix.length && col >= 0) {
            
            if (key == matrix[row][col]) {
                System.out.println("element found at "+ row + col);
                return true;
            }

            else if (key > matrix[row][col]) {
                row++;
            }
            else if (key < matrix[row][col]) {
                col--;
            }
            else{
                System.out.println("Item not found");
                return false;
            }
        }

        return false;
    }
    
    public static void main(String[] args) {
        int[][] matrix = {
            {10, 20, 30, 40},
            {15, 25, 35, 45},
            {27, 29, 37, 48},
            {32, 33, 39, 50}
        };
        stairCaseSearch(matrix, 33);
    }
}
