package src.Tree;

public class InorderTreeTraversalWithoutRecursionAndWithoutStack {
	Node root;

	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	/*
	 * Function to traverse a binary tree without recursion and without stack
	 */
	void MorrisTraversal(Node root) {
		Node current, pre;

		if (root == null)
			return;

		current = root;
		while (current != null) {
			if (current.left == null) {
				System.out.print(current.data + " ");
				current = current.right;
			} else {
				/*
				 * Find the inorder predecessor of current
				 */
				pre = current.left;
				while (pre.right != null && pre.right != current)
					pre = pre.right;

				/*
				 * Make current as right child of its inorder predecessor
				 */
				if (pre.right == null) {
					pre.right = current;
					current = current.left;
				}

				/*
				 * Revert the changes made in the 'if' part to restore the original tree i.e.,
				 * fix the right child of predecessor
				 */
				else {
					pre.right = null;
					System.out.print(current.data + " ");
					current = current.right;
				}
			}
		}
	}

	public static void main(String args[]) {
		InorderTreeTraversalWithoutRecursionAndWithoutStack tree = new InorderTreeTraversalWithoutRecursionAndWithoutStack();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.MorrisTraversal(tree.root);
	}
}