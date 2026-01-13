package Stack;

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
    
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};

        System.out.println(findMaxAreaInHistogram(heights));
    }
}
