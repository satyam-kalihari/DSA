package TwoDArrays;

public class SpiralArray {

    public static void spiralArray(int matrix[][]){
        int colStart = 0;
        int rowStart = 0;
        int colEnd = matrix[0].length-1;
        int rowEnd = matrix.length-1;

        while (colStart <= colEnd && rowStart <= rowEnd) {
            
            for (int i = colStart; i <= colEnd; i++) {
                System.out.print(matrix[rowStart][i]+" ");
            }

            for(int i = rowStart+1; i <= rowEnd; i++){
                System.out.print(matrix[i][colEnd]+" ");
            }

            for (int i = colEnd-1; i >= colStart; i--) {
                System.out.print(matrix[rowEnd][i]+" ");
            }

            for(int i = rowEnd-1; i >= rowStart+1; i--){
                System.out.print(matrix[i][colStart]+" ");
            }

            colStart++;
            rowStart++;
            rowEnd--;
            colEnd--;
        }

    }
    
    public static void main(String[] args) {
        
        int[][] matrix = {
            {1, 2, 3, 4},
            {12, 13, 14, 5},
            {11, 16, 15, 6},
            {10, 9, 8, 7}
        };

        spiralArray(matrix);
    }
}
