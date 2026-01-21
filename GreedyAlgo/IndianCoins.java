package GreedyAlgo;

import java.util.ArrayList;
import java.util.Arrays;

// we are given an infinite supply of denominations  [1, 2, 5, 10, 20, 50, 100, 500, 2000].
// Find min no. of coins/notes to make the change for a value v.
public class IndianCoins {

    public static void findMinCoins(int[] coins, int v){
        Arrays.sort(coins);
        int currenVal = v;
        int count = 0;
        ArrayList<Integer> coin = new ArrayList<>();

        for (int i = coins.length - 1; i >= 0; i--) {
            if (coins[i] <= currenVal) {
                coin.add(coins[i]);
                while (coins[i] <= currenVal) {
                    count++;
                    currenVal -= coins[i];
                }
            }
        }

        System.out.println("Number of coins required: " + count + coin);
    }
        
    public static void main(String[] args) {
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 500, 2000};
        int value = 121;

        findMinCoins(coins, value);
    }
}
