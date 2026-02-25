package DynamicProgramming.fibonacci;

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

    public static void main(String[] args) {
        int n = 4;
        int[] allWays = new int[n+1];

        memoizationWays(n, allWays);
        System.out.println(allWays[n]);
    }
}
