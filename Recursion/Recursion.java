package Recursion;

public class Recursion {

    public static void printNTo1(int n){
        if (n == 1) {
            System.out.print(" "+1);
            return;
        }

        System.out.print(" " +n);
        printNTo1(n-1);
    }

    public static void print1ToN(int n){
        if (n == 1) {
            System.out.print(" "+1);
            return;
        }

        print1ToN(n-1);
        System.out.print(" " +n);
        return;
    }
    
    public static void main(String args[]){
        printNTo1(10);
        System.out.println();
        print1ToN(10);
    }
}
