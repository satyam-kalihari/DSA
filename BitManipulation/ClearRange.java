package BitManipulation;

public class ClearRange {

    public static void clearRange(int num, int i, int j){
        int a = (~0) << j;
        int b = (1<<i) - 1;

        int bitMask = a|b;
        int number = num & bitMask;

        System.out.println("The result is "+ number);
    }
    public static void main(String[] args) {
        clearRange(10, 2, 4);
    }
}