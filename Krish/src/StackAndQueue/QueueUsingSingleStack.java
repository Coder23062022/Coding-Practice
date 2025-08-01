package Krish.src.StackAndQueue;

import java.util.Stack;

public class QueueUsingSingleStack {
	static class Queue {
		Stack<Integer> stack = new Stack<>();

		private void enqueue(int i) {
			stack.push(i);
		}

		private int dequeue() throws Exception {
			if (stack.size() == 0)
				throw new Exception("Queue is Empty");

			if (stack.size() == 1)
				return stack.pop();

			int data = stack.pop();
			// recursion
			int retVal = dequeue();
			stack.push(data);
			return retVal;
		}
	}

	public static void main(String[] args) throws Exception {
		Queue queue = new Queue();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);

		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());

	}
}