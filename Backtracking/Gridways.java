package Backtracking;


public class Gridways {

    public static int gridWays(int row, int col, int n, int m, int count){
        int way1 =0, way2=0 ;
        if (row == n-1 && col == m-1) {
            return 1;
        }

        if (row < n-1) {
            way1= gridWays(row+1, col, n, m, count);
        }
        if (col < m-1) {
            way2= gridWays(row, col+1, n, m, count);
        }

        return way1+way2;
    }
    public static void main(String[] args) {
        int n=3, m=3;
        System.out.println(gridWays(0, 0, n, m, 0));
    }
}
