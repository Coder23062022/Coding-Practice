package Stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueues {
	static class Stack {
		Queue<Integer> q1 = new LinkedList<Integer>();
		Queue<Integer> q2 = new LinkedList<Integer>();
		int curr_size;

		Stack() {
			curr_size = 0;
		}

		void push(int x) {
			curr_size++;

			// Push x first in empty q2
			q2.add(x);

			// Push all the remaining elements in q1 to q2.
			while (!q1.isEmpty()) {
				q2.add(q1.peek());
				q1.remove();
			}

			// swap the names of two queues
			Queue<Integer> q = q1;
			q1 = q2;
			q2 = q;
		}

		int pop() {
			if (q1.isEmpty())
				return -1;
			int x = q1.remove();
			curr_size--;
			return x;
		}

		int top() {
			if (q1.isEmpty())
				return -1;
			return q1.peek();
		}

		int size() {
			return curr_size;
		}
	}

	public static void main(String[] args) {
		Stack s = new Stack();
		s.push(1);
		s.push(2);
		s.push(3);

		System.out.println("current size: " + s.size());

		System.out.println("Top element:" + s.top());
		System.out.println("Popped lement:" + s.pop());

		System.out.println("Top element:" + s.top());
		System.out.println("Popped lement:" + s.pop());

		System.out.println("Top element:" + s.top());
		System.out.println("current size: " + s.size());
		System.out.println("Popped lement:" + s.pop());
	}
}