package src.Stack;

import java.util.Stack;

//Time complexity: O(n)
//Time complexity: O(1)

public class CheckIfTwoStacksAreSame {
    static boolean isSameStack(Stack<String> stack1, Stack<String> stack2) {
        // Check if size of both stacks are same
        if (stack1.size() != stack2.size()) {
            return false;
        }

        // Until the stacks are not empty
        // compare top of both stacks
        while (!stack1.empty()) {
            // If the top elements of both stacks are same
            if (stack1.peek() == stack2.peek()) {
                // Pop top of both stacks
                stack1.pop();
                stack2.pop();
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] arr) {
        Stack<String> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();

        stack1.push("Geeks");
        stack1.push("4");
        stack1.push("Geeks");
        stack1.push("Welcomes");
        stack1.push("You");

        stack2.push("Geeks");
        stack2.push("4");
        stack2.push("Geeks");
        stack2.push("Welcomes");
        stack2.push("You");

        if (isSameStack(stack1, stack2))
            System.out.println("Stacks are Same");
        else
            System.out.println("Stacks are not Same");
    }
}