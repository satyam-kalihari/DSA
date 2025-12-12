package ARRAYS;

public class PrintSubarrays {

    public static void subArrays(int array[]) {
        
        for (int i = 0; i < array.length; i++) {
            // System.out.print("("+ i + "); ");
            
            for (int j = i; j < array.length; j++) {
                System.out.print("(");
                for (int k = i; k <= j; k++) {
                    System.out.print(" "+array[k]+" ");
                }
                System.out.print(");");
            }
            
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        int[] arrays = {2, 3, 4, 5, 6};
        subArrays(arrays);
    }
}
