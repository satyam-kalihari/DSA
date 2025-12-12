package ARRAYS;

public class MaxOfSubArrays {

    public static void maxOfSubArrays(int[] array) {
        int max = 0;
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                for (int j2 = i; j2 <= j; j2++) {
                    sum += array[j2];
                }
                if (sum > max) {
                    max = sum;
                }
                sum=0;
            }
        }
        System.out.println(max);
        
    }

    public static void kadane(int[] array){
        //if the current sum is -ve make it 0
        int cs =0 ;
        int ms = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            cs += array[i];
            if (cs < 0) {
                cs = 0;
            }
            if (cs > ms) {
                ms = cs;
            }
        }

        System.out.println("max of sub arrays: "+ ms);
    }
    
    public static void main(String[] args) {
        int[] array = {-2, -3, 4, -1, -2, 1, 5, -3};
        // maxOfSubArrays(array);
        kadane(array);
    }
}
