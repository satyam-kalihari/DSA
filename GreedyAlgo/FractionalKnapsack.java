package GreedyAlgo;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public static void main(String[] args) {
        int val[] = {60, 100, 120};
        int weig[] = {10, 20, 30};
        int maxCap = 50;

        double[][] ratio = new double[val.length][2];
        for (int i = 0; i < ratio.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = val[i]/(double)weig[i];
        }
        Arrays.sort(ratio, Comparator.comparingDouble(o->o[1]));

        int capacity = maxCap;
        int finalAns = 0;
        for (int i = ratio.length - 1; i >= 0; i--) {
            int idx = (int)ratio[i][0];
            if (weig[idx] <= capacity) {
                finalAns += val[idx];
                capacity -= weig[idx];
            }
            else{
                finalAns += ratio[i][1]*capacity;
                capacity = 0;
                break;
            }
        }

        System.out.println(finalAns);
    }
}
