package GreedyAlgo;

import java.util.Arrays;
import java.util.Collections;

// We are given a bar of chocolate composed of mxn square pieces. One should break the chocolate
// into single squares. Each break of a part of the chocolate is charged a cost expressed by a positive
// integer. This cost does not depend on the size of the part that is being broken but only depends on
// the line the break goes along.
// Compute the minimal cost of breaking the whole chocolate into single squares.
public class ChocolaProblem {
    
    public static void main(String[] args) {
        int n = 4; int m = 6;
        Integer[] hCost = {4, 2, 1};
        Integer[] vCost = {2, 1, 3, 1, 4};

        // Integer[] hCost = {3};
        // Integer[] vCost = {2};

        int vPieces = 1;
        int hPieces = 1;

        int h = 0;
        int v = 0;

        int cost = 0;

        Arrays.sort(vCost, Collections.reverseOrder());
        Arrays.sort(hCost, Collections.reverseOrder());

        while (h < hCost.length && v < vCost.length) {
            if (hCost[h] >= vCost[v]) {
                cost += hCost[h]*vPieces;
                hPieces++;
                h++;
            }else{
                cost += vCost[v]*hPieces;
                vPieces++;
                v++;
            }
        }

        while (h < hCost.length) {
            cost += hCost[h]*vPieces;
            hPieces++;
            h++;
        }
        while (v < vCost.length) {
            cost += vCost[v]*hPieces;
            vPieces++;
            v++;
        }

        System.out.println(cost);

    }
}
