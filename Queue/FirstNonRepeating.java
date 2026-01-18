package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeating {

    public static void firstNonRepeating(String str){

        Queue<Character> q = new LinkedList<>();

        int[] freq = new int[26];

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            freq[curr - 'a']++;
            q.add(curr);
            boolean rep = true;

            while (rep) {
                if (!q.isEmpty()) {
                    if (freq[q.peek()-'a'] <= 1) {
                        rep = false;
                    }else{
                        q.remove();
                    }  
                }
                else {
                    rep = false;
                } 
            }
            if (q.isEmpty()) {
                System.err.println(-1);
            }
            else{
                System.out.println(q.peek());
            }
        }
    }
    public static void main(String[] args) {

        String str = "aabccxb";
        firstNonRepeating(str);
    }
}
