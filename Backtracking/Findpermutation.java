package Backtracking;

public class Findpermutation {
    
    public static void findPermutation(StringBuilder str, String ans){

        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        for (int j = 0; j < str.length(); j++) {
            char curr = str.charAt(j);
            str.deleteCharAt(j);
            findPermutation(str, ans+curr);
            str.insert(j, curr);
        }
    }

    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("abc");
        findPermutation(str, "");
    }
}
