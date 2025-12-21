package Recursion;

public class Fibonacci {

    public static void fibonacchi(int n, int curr, int prev){

        if (curr > n) {
            return;
        }

        System.out.print(curr + " ");
        int next = curr+prev;
        fibonacchi(n, next , curr);
        return;
    }

    public static void main(String[] args) {
        
        int prev = 0;
        System.out.print(prev + " ");
        fibonacchi(25, prev+1, prev);
    }
}
