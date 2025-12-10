public class HollowRectanglePattern {

    public static void main(String[] args) {
        int numberOfRows = 4;
        int numberOfColumns = 5;

        for(int i  = 0; i < numberOfRows; i++){
            for(int j = 0; j < numberOfColumns; j++){
                if (i == 0 || i == 3 || j == 0 || j == 4) {
                    System.out.print('*');
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}