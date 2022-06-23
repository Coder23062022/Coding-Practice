package LinkedList;

class DetectAndRemoveLoopInALinkedList {
	static Node head;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	// Function that detects loop in the list
	void detectAndRemoveLoop(Node node) {
		// If list is empty or has only one node without loop
		if (node == null || node.next == null)
			return;

		Node slow = node, fast = node, prev = null;

		// Move slow and fast 1 and 2 steps ahead respectively.
		slow = slow.next;
		fast = fast.next.next;

		// Search for loop using slow and fast pointers
		while (fast != null && fast.next != null) {
			if (slow == fast)
				break;
//			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		/* If loop exists */
		if (slow == fast) {
			slow = node;
			while (slow != fast) {
				prev = fast;
				slow = slow.next;
				fast = fast.next;
			}

			/* since fast->next is the looping point */
			prev.next = null; /* remove loop */
		}
	}

	// Function to print the linked list
	void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	public static void main(String[] args) {
		DetectAndRemoveLoopInALinkedList list = new DetectAndRemoveLoopInALinkedList();
		head = new Node(50);
		head.next = new Node(20);
		head.next.next = new Node(15);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(10);
		// Creating a loop for testing
		head.next.next.next.next.next = head.next.next;

		// Test case 2
//		head = new Node(1);
//		head.next = new Node(2);
//		head.next.next = new Node(3);
//		head.next.next.next = head;

		list.detectAndRemoveLoop(head);
		System.out.println("Linked List after removing loop : ");
		list.printList(head);
	}
}