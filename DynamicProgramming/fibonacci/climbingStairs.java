package DynamicProgramming.fibonacci;

import java.util.Arrays;

public class climbingStairs {
    public static int memoizationWays(int n, int[] allWays){
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }

        if (allWays[n] != 0) {
            return allWays[n];
        }
        allWays[n] = memoizationWays(n-1, allWays) + memoizationWays(n-2, allWays);
        return allWays[n];
    }

    public static int tabulationWays(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = dp[i-1];
            }
            else{
                dp[i] = dp[i-1] + dp[i-2];
            }
        }

        return dp[n];
    }
    public static void main(String[] args) {
        int n = 5;
        int[] allWays = new int[n+1];
        Arrays.fill(allWays, -1);

        // memoizationWays(n, allWays);
        // System.out.println(allWays[n]);
        System.out.println(tabulationWays(n));
    }
}
