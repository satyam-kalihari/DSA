public class PatternII {

    public static void InvertedAndRotatedHalfPyramid(int row, int column){
        int blank = column - 1;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                if (j < blank) {
                    System.out.print(" ");
                }
                else{
                    System.out.print("*");
                }
            }
            blank--;
            System.out.println();
        }
    }

    //Butterfly Pattern
    public static void ButterflyPattern(int n){
        int blank = 2*n-2;

        for(int i = 1; i <= n; i++){
            for( int j = 1; j <= i; j++){
                System.out.print("*");
            }
            for (int j = 1; j <= blank; j++) {
                System.out.print(" ");
            }
            for( int j = 1; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
            blank -= 2;      
        }
        blank = 0;
        for(int i = n; i >= 1; i--){
            for( int j = 1; j <= i; j++){
                System.out.print("*");
            }
            for (int j = 1; j <= blank; j++) {
                System.out.print(" "); 
            }
            for( int j = 1; j <= i; j++){
                System.out.print("*");
            }
            System.out.println( );
            blank += 2;      
        }
    }

    public static void main(String[] args) {
        // InvertedAndRotatedHalfPyramid(4, 4);
        ButterflyPattern(6);
    }
}
