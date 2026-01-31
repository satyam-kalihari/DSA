package Hashing;

import java.util.HashMap;

public class HashMapImp {
    public static boolean isAnangram(String s1, String s2){

        if (s1.length() != s2.length()) {
            return false;
        }

        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            if (hm.containsKey(ch)) {
                hm.put(ch, hm.get(ch) - 1);
                if (hm.get(ch) == 0) {
                    hm.remove(ch);
                }
            }
        }

        if (hm.isEmpty()) {
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args) {
        String s1 = "keen";
        String s2 = "eenk";

        System.out.println(isAnangram(s1, s2));
    }
}
