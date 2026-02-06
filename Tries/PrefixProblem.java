package Tries;

public class PrefixProblem {
    public static class Node {
    
        Node[] children = new Node[26];
        boolean eow = false;
        int feq = 0;
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
            curr.children[idx].feq++;
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static StringBuilder searchPrifix(String word){
        Node curr = root;
        StringBuilder prefix = new StringBuilder();
        for(int i = 0; i < word.length(); i++){
            int idx = word.charAt(i) - 'a';
            curr = curr.children[idx];
            prefix.append(word.charAt(i));
            if (curr.feq == 1) {
               break; 
            }
        }
        
        return prefix;
    }
    public static void printPrifix(String[] str){
        for (String word : str) {
            System.out.println(searchPrifix(word));
        }
    }
    public static boolean startWitth(String prefix){
        Node curr =root;

        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }
    public static int countPrifix(Node root){
        if (root == null) {
            return 0;
        }
        int count = 0;
        for(int i = 0; i < 26; i++){
            if (root.children[i] != null) {
                count += countPrifix(root.children[i]);
            }
        }
        return count+1;
    }

    public static void main(String[] args) {
        // String[] str = {"zebra", "dog", "duck", "dove"};
        // String prefic[] = {"apple", "app", "mango", "me", "woman"};
        String str = "ababa";

        // creating suffix trie tree
        for (int i = 0; i < str.length(); i++) {
            insert(str.substring(i));
        }

        
        System.out.println(countPrifix(root));;
    }
}
