package src.Tree;

public class BSTOperations {
	Node root;

	static class Node {
		int value;
		Node left;
		Node right;

		public Node(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}

	void add(int value) {
		root = addElementRecursively(root, value);
	}

	Node addElementRecursively(Node current, int value) {
		// Inserting the value for first time
		if (current == null)
			return new Node(value);

		if (value < current.value) {
			current.left = addElementRecursively(current.left, value);
		} else if (value > current.value) {
			current.right = addElementRecursively(current.right, value);
		} else {
			// value already exists
			return current;
		}
		return current;
	}

	boolean searchElement(int value) {
		return searchElementRecursively(root, value);
	}

	boolean searchElementRecursively(Node current, int value) {
		if (current == null)
			return false;
		if (value == current.value)
			return true;
		return value < current.value ? searchElementRecursively(current.left, value)
				: searchElementRecursively(current.right, value);
	}

	void deleteElement(int value) {
		deleteElementRecursively(root, value);
	}

	Node deleteElementRecursively(Node current, int value) {
		if (current == null) {
			return null;
		}

		if (value == current.value) {
			// when the node is a leaf node
			if (current.left == null && current.right == null) {
				return null;
			}
			// when the node has one child
			if (current.right == null) {
				return current.left;
			}

			if (current.left == null) {
				return current.right;
			}
			// when the node has two children
			int smallestValue = findSmallestValue(current.right);
			current.value = smallestValue; // assign the inorder successor value to the node to delete
			current.right = deleteElementRecursively(current.right, smallestValue); // now we'll delete the node from
																					// the right sub-tree
			return current;
		}
		if (value < current.value) {
			current.left = deleteElementRecursively(current.left, value);
			return current;
		}
		current.right = deleteElementRecursively(current.right, value);
		return current;
	}

	// find the smallest node of the soon to be deleted node's right sub-tree
	// (inorder successor)
	int findSmallestValue(Node root) {
		return root.left == null ? root.value : findSmallestValue(root.left);
	}

	void printTreeInorder(Node root) {
		if (root == null)
			return;
		printTreeInorder(root.left);
		System.out.print(root.value + " ");
		printTreeInorder(root.right);
	}

	public static void main(String[] args) {
		BSTOperations bt = new BSTOperations();
		// Insertion
		bt.add(6);
		bt.add(4);
		bt.add(8);
		bt.add(3);
		bt.add(5);
		bt.add(7);
		bt.add(9);
		// Print the tree in inorder fashion
		bt.printTreeInorder(bt.root);
		// Finding an element
		System.out.println("\n" + bt.searchElement(3));
		// Deletion
		System.out.println("Tree after deletion:");
		bt.deleteElement(4);
		bt.printTreeInorder(bt.root);
	}
}