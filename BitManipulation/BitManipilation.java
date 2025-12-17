package BitManipulation;

public class BitManipilation {

    public static void oddEven(int num){
        int bitMask = 1;

        if ((num & bitMask) == 0) {
            System.out.println("The number is even.");
        }
        else System.out.println("the Number is odd.");
    }
    
    public static void main(String[] args) {
        oddEven(4);
        oddEven(5);
    }
}
