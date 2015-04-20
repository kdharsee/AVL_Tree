package structures;

/**
 * This class implements a binary search tree node that stores
 * (key,value) pairs, where the key is an integer and the value is a string.
 * 
 * @author RU NB CS112
 *
 */
public class BSTNode {
	
	/**
	 * Key stored at this node.
	 */
	int key;
	
	/**
	 * Value associated with the key stored at this node.
	 */
	String value;
	
	/**
	 * The left child pointer.
	 */
	BSTNode left;
	
	/**
	 * The right child pointer.
	 */
	BSTNode right;
	
	/**
	 * Initializes this node with given (key,value) pair. The left and right children 
	 * pointers are initialized to null.
	 * 
	 * @param key Key.
	 * @param value Value associated with key.
	 */
	public BSTNode(int key, String value) {
		this.key = key;
		this.value = value;
		this.left = null;
		this.right = null;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "(" + key + "," + value + ")";
	}
	
	/**
     * Builds a BST given its preorder and inorder traversals.
     * 
     * @param pre Preorder traversal
     * @param in Inorder traversal
     * @return Root of the tree
     * @throws IllegalArgumentException If the tree cannot be built
	 */
	public static BSTNode
	buildTree(KeyValuePair[] pre, KeyValuePair[] in) {
		if ( pre.length != in.length ) {
			throw new IllegalArgumentException("traversals of different lengths");
		}
		else {			
			return buildTree(pre, 0, in, 0, pre.length-1);
		}		
	}

	/**
     * Recursive helper method buildTree.
     * 
     * @param pre Preorder traversal
     * @param i Index in preorder traversal
     * @param in Inorder traversal
     * @param lo Lower endpoint of inorder (sub)traversal
     * @param hi Upper endpoint in inorder (sub)traversal
     * @throws IllegalArgumentException If the tree cannot be built
	 */
	private static BSTNode 
	buildTree(KeyValuePair[] pre, int i, 
			  KeyValuePair[] in, int lo, int hi) {
		if (i >= pre.length || lo > hi) {
			return null;
		}
		BSTNode root = new BSTNode(pre[i].key, pre[i].value);

		// search for pre[i] in in[lo..hi]
		int j;
		for (j=lo; j <= hi; j++) {
			if (pre[i].key == in[j].key) {
				break;
			}
		}
		if (j > hi) {
			throw new IllegalArgumentException("incorrect traversals");
		}

		root.left = buildTree(pre, i+1, in, lo, j-1);
		root.right = buildTree(pre, i+j-lo+1, in, j+1,hi);
		return root;
	}
}


