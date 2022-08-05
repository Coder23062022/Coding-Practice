package src.Stack;

import java.util.Stack;

//Time complexity: O(n)
//Space complexity: O(n)

public class SortStackUsingTempStack {
    static Stack<Integer> tempStack = new Stack<>();

    static Stack<Integer> sortStack(Stack<Integer> inputStack) {
        while (!inputStack.isEmpty()) {
            //Pop out the top element from input stack.
            int temp = inputStack.pop();

            //While temporary stack is not empty and top of the temp stack is smaller than temp,
            //pop from temporary stack and push it to the input stack.
            while (!tempStack.isEmpty() && tempStack.peek() < temp) {
                inputStack.push(tempStack.pop());
            }

            //Push temp in temporary stack.
            tempStack.push(temp);
        }
        return tempStack;
    }

    // Driver Code
    public static void main(String[] args) {
        Stack<Integer> inputStack = new Stack<>();
        inputStack.add(34);
        inputStack.add(3);
        inputStack.add(31);
        inputStack.add(98);
        inputStack.add(92);
        inputStack.add(23);

        tempStack = sortStack(inputStack);
        System.out.println("Sorted numbers are:");
        while (!tempStack.empty()) {
            System.out.print(tempStack.pop() + " ");
        }
    }
}