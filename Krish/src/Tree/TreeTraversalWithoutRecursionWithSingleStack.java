package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Node {
	int data;
	Node left, right;

	Node(int key) {
		this.data = key;
	}
}

public class TreeTraversalWithoutRecursionWithSingleStack {
	Node root;
	Stack<Node> stack = new Stack<Node>();

	void inOrderTraversal() {
		if (root == null)
			return;

		Node curr = root;

		while (curr != null || !stack.isEmpty()) {
			// Reach the left most Node of the curr Node
			while (curr != null) {
				// Place pointer to a tree node on the stack before traversing the node's left
				// subtree
				stack.push(curr);
				curr = curr.left;
			}
			// Current must be NULL at this point
			curr = stack.pop();
			System.out.println(curr.data);
			// We have visited the node and its left subtree. Now, it's right subtree's turn
			curr = curr.right;
		}
	}

	void preOrderTraversal() {
		if (root == null)
			return;

		stack.push(root);

		while (!stack.isEmpty()) {
			Node myNode = stack.peek();
			System.out.println(myNode.data);
			stack.pop();

			if (myNode.right != null) {
				stack.push(myNode.right);
			}

			if (myNode.left != null) {
				stack.push(myNode.left);
			}
		}
	}

	void postOrderTraversal() {
		// Check for empty tree
		if (root == null)
			return;

		List<Integer> list = new ArrayList<Integer>();
		Node prev = null;

		stack.push(root);

		while (!stack.isEmpty()) {
			Node current = stack.peek();

			/*
			 * go down the tree in search of a leaf an if so process it and pop stack
			 * otherwise move down
			 */
			if (prev == null || prev.left == current || prev.right == current) {
				if (current.left != null)
					stack.push(current.left);
				else if (current.right != null)
					stack.push(current.right);
				else {
					stack.pop();
					list.add(current.data);
				}

				/*
				 * go up the tree from left node, if the child is right push it onto stack
				 * otherwise process parent and pop stack
				 */
			} else if (current.left == prev) {
				if (current.right != null)
					stack.push(current.right);
				else {
					stack.pop();
					list.add(current.data);
				}

				/*
				 * go up the tree from right node and after coming back from right node process
				 * parent and pop stack
				 */
			} else if (current.right == prev) {
				stack.pop();
				list.add(current.data);
			}
			prev = current;
		}
		list.forEach(System.out::println);
	}

	public static void main(String[] args) {
		TreeTraversalWithoutRecursionWithSingleStack ttwr = new TreeTraversalWithoutRecursionWithSingleStack();
		ttwr.root = new Node(1);
		ttwr.root.left = new Node(2);
		ttwr.root.right = new Node(3);
		ttwr.root.left.left = new Node(4);
		ttwr.root.left.right = new Node(5);
		System.out.println("Inorder Traversal:");
		ttwr.inOrderTraversal();
		System.out.println("Preorder Traversal:");
		ttwr.preOrderTraversal();
		System.out.println("Postorder Traversal:");
		ttwr.postOrderTraversal();
	}
}