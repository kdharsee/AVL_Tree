package structures;

/**
 * This class implements an AVL tree node with balance factors.
 * 
 * @author RU NB CS112
 *
 */
public class AVLTreeNode {
	
	/**
	 * Equal high balance factor representation.
	 */
	public static final int EQUAL_HIGH = 0;
	
	/**
	 * Left high balance factor representation.
	 */
	public static final int LEFT_HIGH = -1;
	
	/**
	 * Right high balance factor representation.
	 */
	public static final int RIGHT_HIGH = 1;
	
	/**
	 * Height of the subtree rooted at this node
	 */
	public int height;
	
	/**
	 * Balance factor of this node
	 */
	public int balanceFactor;
	
	/**
	 * Key stored at this node.
	 */
	public int key;
	
	/**
	 * Value associated with the key stored at this node.
	 */
	public String value;
	
	/**
	 * The left child pointer.
	 */
	public AVLTreeNode left;
	
	/**
	 * The right child pointer.
	 */
	public AVLTreeNode right;
	
	/**
	 * The parent pointer.
	 */
	public AVLTreeNode parent;
	
	/**
	 * Initializes this node with given (key,value) pair. The height of this
	 * node will be initialized to 0, and the balance factor will be initialized
	 * to 0. The left and right children pointers will be initialized to null.
	 * 
	 * @param key Key.
	 * @param value Value associated with key.
	 */
	public AVLTreeNode(int key, String value) {
		this.key = key;
		this.value = value;
		this.balanceFactor = AVLTreeNode.EQUAL_HIGH;
		this.height = 0;
		this.left = null;
		this.right = null;
		this.parent = null;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		char bf = '-';
		if (balanceFactor < 0) { bf = '/'; }
		else if (balanceFactor > 0) { bf = '\\'; }
		return "(" + key + "," + value + "," + height + "," + bf + ")";
	}
}


