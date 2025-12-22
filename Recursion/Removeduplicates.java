package Recursion;

public class Removeduplicates {
    
    public static void removeDuplicates(String str, int i, boolean arr[], StringBuilder newStr){
        if (i == str.length()) {
            System.out.println(newStr);
            return;
        }

        int arrIndex = str.charAt(i) - 'a';
        if (!arr[arrIndex]) {
            
            newStr.append(str.charAt(i));
            arr[arrIndex] = true;
        }

        removeDuplicates(str, i+1, arr, newStr);
        return;
    }

    public static void main(String[] args) {
        boolean[] arr = new boolean[26];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = false;
        }

        StringBuilder newStr = new StringBuilder("");

        removeDuplicates("appnacollege", 0, arr, newStr);
    }
}
