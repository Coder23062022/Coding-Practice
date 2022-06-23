package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseAQueue {
	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);

		q = reverse(q);
		// reversequeue(q);

		while (!q.isEmpty()) {
			System.out.println(q.peek() + " ");
			q.remove();
		}
	}

	// Using Another Queue
	static Queue<Integer> reverse(Queue<Integer> q) {
		Queue<Integer> ans = new LinkedList<>();
		int s = q.size();

		for (int i = 0; i < s; i++) {
			// Get the last element to the front of queue
			for (int j = 0; j < q.size() - 1; j++) {
				int x = q.peek();
				q.remove();
				q.add(x);
			}
			// Get the last element and add it to the new queue
			ans.add(q.peek());
			q.remove();
		}
		return ans;
	}

	// Using Stack
	static void reversequeue(Queue<Integer> q) {
		Stack<Integer> stack = new Stack<>();
		while (!q.isEmpty()) {
			stack.add(q.peek());
			q.remove();
		}
		while (!stack.isEmpty()) {
			q.add(stack.peek());
			stack.pop();
		}
	}
}