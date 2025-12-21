package Recursion;

public class Fibonacci {

    public static void fibonacci(int n, int curr, int prev){

        if (curr > n) {
            return;
        }

        System.out.print(curr + " ");
        int next = curr+prev;
        fibonacci(n, next , curr);
        return;
    }

    //fibonacci of nth term
    public static int fibonacci(int n){

        if (n == 1 || n == 0) {
            return n;
        }
        int fib1 = fibonacci(n-1);
        int fib2 = fibonacci(n-2);
        int fn = fib1+fib2;
        return fn;
    }

    public static void main(String[] args) {
        
        int prev = 0;
        System.out.print(prev + " ");
        fibonacci(25, prev+1, prev);
        System.out.println();
        System.out.println(fibonacci(25));
    }
}
