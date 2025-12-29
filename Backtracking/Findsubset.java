package Backtracking;

public class Findsubset {
    
    public static void findSubSet(String str, String newStr, int i){
        if (i == str.length()) {
            if (newStr.length() == 0) {
                System.out.println("null");
            }else{
                System.out.println(newStr);
            }
            return;
        }

        findSubSet(str, newStr+str.charAt(i), i+1);
        findSubSet(str, newStr, i+1);
    }

    public static void main(String[] args) {
        findSubSet("adc", "", 0);
    }
}
