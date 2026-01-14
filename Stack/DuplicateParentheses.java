package Stack;

import java.util.Stack;

public class DuplicateParentheses {
    
    public static boolean isDuplicateParentheses(String str){
        Stack<Character> s = new Stack<>();
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            if (curr != ')' && curr != '}' && curr != ']') {
                s.push(curr);
            }
            else{
                count = 0;
                while (s.peek() != '(' && s.peek() != '{' && s.peek() != '[') {
                    count++;
                    s.pop();
                }
                if (count < 1) {
                    return true;
                }
                else{
                    s.pop();
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "(((a+(b))) + c)";

        System.out.println(isDuplicateParentheses(str));
    }
}
