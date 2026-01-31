package Hashing;

import java.util.HashMap;

public class SubarrayQ {

    public static int subarraySum0(int[] array){
        HashMap<Integer, Integer> sc = new HashMap<>();
        int sum = 0;
        int len = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            if (sc.containsKey(sum)) {
                len = i - sc.get(sum);
            }
            else{
                sc.put(sum, i);
            }
        }
        return len;
    }

    // public static int subarraySumK(int[] array, int k){
    //     HashMap<Integer, Integer> sc = new HashMap<>();
    //     int sum = 0;
    //     int count = 0;
    //     return count;
    // }
    
    public static void main(String[] args) {
        int[] array = {15, -2, 2, -8, 1, 7, 10, 23};
        int LSWS0 = subarraySum0(array);//Largest subarray with sum 0;
        // int NSSEK = subarraySumK(array, 3);
        System.out.println(LSWS0);
    }
}
