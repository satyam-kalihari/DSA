package String;

import java.util.Scanner;

public class Palindrome {

    public static void isPalindrome(String str){

        boolean isPal = true;
        for (int i = 0; i < str.length()/2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                isPal = false;
            }
        }
        if (isPal) {
            System.out.println("Given string is Palindrome.");
        }
        else{
            System.out.println("Given string is not a palindrome.");
        }
    }
    
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            String str = sc.next();

            isPalindrome(str);
        }
        
    }
}
