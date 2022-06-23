package Stack;

import java.util.Stack;

public class SortStackUsingTempStack {
	public static Stack<Integer> sortStack(Stack<Integer> input) {
		Stack<Integer> tempStack = new Stack<Integer>();
		while (!input.isEmpty()) {
			// pop out the first element
			int temp = input.pop();

			// while temporary stack is not empty and
			// top of stack is greater than temp
			while (!tempStack.isEmpty() && tempStack.peek() > temp) {
				// pop from temporary stack and
				// push it to the input stack
				input.push(tempStack.pop());
			}

			// push temp in temporary of stack
			tempStack.push(temp);
		}
		return tempStack;
	}

	// Driver Code
	public static void main(String args[]) {
		Stack<Integer> input = new Stack<Integer>();
		input.add(34);
		input.add(3);
		input.add(31);
		input.add(98);
		input.add(92);
		input.add(23);

		// This is the temporary stack
		Stack<Integer> tempStack = sortStack(input);
		System.out.println("Sorted numbers are:");

		while (!tempStack.empty()) {
			System.out.print(tempStack.pop() + " ");
		}
	}
}