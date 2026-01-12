package Stack;

import java.util.Stack;

public class NextGreaterElement {
    
    public static void nextGreatestElement(int[] arr, int[] nextGreatest){

        Stack<Integer> s = new Stack<>();

        for (int i = arr.length-1; i >= 0 ; i--) {

            int curr = arr[i];
            while (!s.isEmpty() && curr > s.peek()) {
                s.pop();
            }
            if (s.isEmpty()) {
                nextGreatest[i] = -1;
            }else{
                nextGreatest[i] = s.peek();
            }

            s.push(arr[i]);
        }
    }

    public static void main(String[] args) {

        int[] arr = {6, 8, 0, 1, 3};
        int[] nextGreatest = new int[arr.length];

        nextGreatestElement(arr, nextGreatest);
        for (int i = 0; i < nextGreatest.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < nextGreatest.length; i++) {
            System.out.println(arr[i] + "->" + nextGreatest[i]);
        }
    }
}
