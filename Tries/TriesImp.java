package Tries;

public class TriesImp {
    public static class Node {
        Node[] children = new Node[26];
        boolean endOfWord = false;

        Node(){
            for(int i = 0; i < 26; i++){
                children[i] = null;
            }
        }
    }
    public static Node root = new Node();

    public static void insert(String word){
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i)-'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.endOfWord = true;
    }

    public static boolean search(String word){
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i)-'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];

        }
        return curr.endOfWord == true;
    }

    public static boolean wordBreakProblem(String key){
        if (key.length() == 0) {
            return true;
        }
        for (int i = 1; i <= key.length(); i++) {
            if (search(key.substring(0, i)) && wordBreakProblem(key.substring(i))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] str = {"the", "a", "there", "their", "any", "three"};
        for (String string : str) {
            insert(string);
        }

        // System.out.println(search("a"));
        System.out.println(wordBreakProblem("thereaany"));
    }
}
