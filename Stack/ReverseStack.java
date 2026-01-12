package Stack;

import java.util.Stack;

public class ReverseStack {
    public static void pushAtBottom(Stack<Integer> stack, int val){

        if (stack.isEmpty()) {
            stack.push(val);
            return;
        }

        int top = stack.pop();
        pushAtBottom(stack, val);
        stack.push(top);
    }

    public static void reverseStack(Stack<Integer> stack){
        if (stack.isEmpty()) {
            return;
        }

        int top = stack.pop();
        reverseStack(stack);
        pushAtBottom(stack, top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        reverseStack(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
