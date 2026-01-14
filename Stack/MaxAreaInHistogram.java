package Stack;

import java.util.Stack;

public class MaxAreaInHistogram {

    public static int findMinHeignt(int i, int j, int[] height){
         int min = height[i];

         for (int k = i+1; k <= j; k++) {
            if (height[k] < min) {
                min = height[k];
            }
         }

         return min;
    }

    public static int findMaxAreaInHistogram(int[] heights){

        int maxArea = Integer.MIN_VALUE;

        for (int i = 0; i < heights.length; i++) {

            for (int j = i+1; j < heights.length; j++) {
                
                int min = findMinHeignt(i, j, heights);
                int area = (j-i+1) * min;
                if (area > maxArea) {
                    maxArea = area;
                }
            }
            
        }

        return maxArea;
    }

    public static int findMaxAreaByStackMethod(int[] height){
        int maxArea = 0;

        int[] nsl = new int[height.length];
        int[] nsr = new int[height.length];

        Stack<Integer> s = new Stack<>();

        //next smallest right
        for (int i = height.length - 1; i >= 0; i--) {
            int curr = height[i];
            while (!s.isEmpty() && curr <= height[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nsr[i] = height.length;
            }else{
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        //next smallest left
        s = new Stack<>();
        for (int i = 0; i < nsr.length; i++) {
            int curr = height[i];
            while (!s.isEmpty() && curr <= height[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nsl[i] = -1;
             }else{
                nsl[i] = s.peek();
            }
            s.push(i);
        }

        //calculate the area
        for (int i = 0; i < nsr.length; i++) {
            int width = nsr[i]-nsl[i]-1;
            int area = height[i] * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
    
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};

        System.out.println(findMaxAreaByStackMethod(heights));
    }
}
