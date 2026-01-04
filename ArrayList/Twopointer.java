package ArrayList;

import java.util.ArrayList;

//Q for given n lines on x-axis, use 2 lines to form a container such that it holds maxi water
public class Twopointer {

    public static void maxWaterContainer(ArrayList<Integer> height){

        int maxWater = 0;
        int leftP = 0;
        int rightP = height.size() - 1;
        while (leftP <= rightP) {
            int hei = Math.min(height.get(leftP), height.get(rightP));
            int weidth = rightP-leftP;
            int currentWater = hei*weidth;

            maxWater = Math.max(maxWater, currentWater);

            if (height.get(leftP) < height.get(rightP)) {
                leftP++;
            }else rightP--;
        }

        System.out.println("Maximum water = " + maxWater);
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        maxWaterContainer(height);
    }
}
