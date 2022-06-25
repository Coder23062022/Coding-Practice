package src.LinkedList;

public class DeleteKthLastNode {
	static Node head;

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static void main(String[] args) {
		int k = 3;
		insert(5);
		insert(4);
		insert(3);
		insert(2);
		insert(1);

		// Delete the 3rd node from the last
		deleteNode(head, k);
	}

	static void insert(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

	static void deleteNode(Node node, int k) {
		// First reverse the list
		Node reverseList = reverse(head);

		// Store head node
		Node temp = reverseList;

		// If head or first node needs to be removed
		if (k == 0 || k == 1) {
			reverseList = temp.next;
		}

		// Find previous node of the node to be deleted
		for (int i = 1; temp != null && i < k - 1; i++) {
			temp = temp.next;
		}

		// If position is more than number of nodes
		if (temp == null || temp.next == null)
			return;

		// Unlink the deleted node from list
		temp.next = temp.next.next;

		printList(reverseList);
	}

	static void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	static Node reverse(Node node) {
		Node next = null;
		Node prev = null;
		Node curr = node;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		node = prev;
		return node;
	}
}