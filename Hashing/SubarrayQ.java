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

    public static int subarraySumK(int[] array, int k){
        HashMap<Integer, Integer> sc = new HashMap<>();
        int sum = 0;
        int ans = 0;
        sc.put(0, 1);
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            if (sc.containsKey(sum - k)) {
                ans += sc.get(sum-k);
            }
            sc.put(sum, sc.getOrDefault(sum, 0)+1);
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int[] array = {10, 2, -2, -20, 10};
        int LSWS0 = subarraySum0(array);//Largest subarray with sum 0;
        int NSSEK = subarraySumK(array, -10);
        System.out.println(LSWS0);
        System.out.println(NSSEK);
    }
}
