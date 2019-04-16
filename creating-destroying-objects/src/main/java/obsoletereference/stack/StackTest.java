package obsoletereference.stack;

import obsoletereference.stack.Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push("One");
        stack.push("Two");
        stack.push("Three");
        stack.push("Four");
        stack.push("Five");

        try {
            System.out.println(stack.pop());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
