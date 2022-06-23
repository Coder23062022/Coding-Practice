package Tree;

public class InorderPredecessorSuccessorOfAKey {
	class BST {
		BST left; // Left subtree
		BST right; // Right subtree
		int data; // Element

		public BST(int data) {
			this.data = data;
		}
	}

	private int predecessor = -1;
	private int successor = -1;
	private int previous = -1;

	public static void main(String[] args) {
		int val[] = new int[] { 28, 15, 40, 19, 10, 36, 45, 20, 5, 50 };
		int findPreSuc = 28;
		InorderPredecessorSuccessorOfAKey obj = new InorderPredecessorSuccessorOfAKey();
		BST root = obj.createBST(val);
		obj.getPredecessorSuccessor(root, findPreSuc);
		System.out.println("Given node element : " + findPreSuc);
		if (obj.predecessor == -1) {
			System.out.println("No Predecessor for the given node ");
		} else {
			System.out.println("Predecessor : " + obj.predecessor);

		}
		if (obj.successor == -1) {
			System.out.println("No Successor for the given node ");
		} else {
			System.out.println("Successor : " + obj.successor);
		}
	}

	// BST in-order traversal
	public void getPredecessorSuccessor(BST root, int findPreSuc) {
		// Return once we got both Predecessor and Successor
		if (predecessor != -1 && successor != -1) {
			return;
		}
		// Recursive to left subtree
		if (root.left != null) {
			getPredecessorSuccessor(root.left, findPreSuc);
		}
		// Getting Predecessor
		if (root.data == findPreSuc) {
			predecessor = previous;
		}
		// Getting Successor
		if (findPreSuc == previous) {
			successor = root.data;
			previous = root.data;
			return;
		}
		previous = root.data;
		// Recursive to right subtree
		if (root.right != null) {
			getPredecessorSuccessor(root.right, findPreSuc);
		}
	}

	public BST createBST(int[] val) {
		BST root = new BST(val[0]); // Root node with 1st element
		BST tmpRoot = root;

		for (int i = 1; i < val.length; i++) {
			BST lastNode = getLastNode(tmpRoot, val[i]);
			if (val[i] > lastNode.data) {
				BST tmp = new BST(val[i]);
				lastNode.right = tmp;
			} else {
				BST tmp = new BST(val[i]);
				lastNode.left = tmp;
			}
		}
		return root;
	}

	public BST getLastNode(BST root, int val) {
		if (val > root.data) {
			if (root.right == null) {
				return root;
			} else
				return getLastNode(root.right, val);
		} else {
			if (root.left == null) {
				return root;
			} else
				return getLastNode(root.left, val);
		}
	}
}