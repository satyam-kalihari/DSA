package GreedyAlgo;

import java.util.ArrayList;

public class MaximumActivity {
    
    public static void main(String[] args) {
        int[] start = {10, 12, 30};
        int[] end = {20, 25, 30};

        ArrayList<Integer> ans = new ArrayList<>();
        int maxAct = 1;
        ans.add(0);

        int lastEnd = end[0];
        for (int i = 1; i < end.length; i++) {
            if (start[i] >= lastEnd) {
                maxAct++;
                ans.add(i);
                lastEnd = end[i];
            }
        }

        System.out.println(maxAct + "" + ans );
    }
}
