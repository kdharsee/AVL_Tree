package structures;

import java.util.ArrayList;

/**
 * This class implements an AVL tree.
 * 
 * @author RU NB CS112
 *
 */
public class AVLTree {

	/**
	 * The root of this AVL tree.
	 */
	public AVLTreeNode root;
	
	/**
	 * Number of nodes in this AVL tree. 
	 */
	public int size;
	
	/**
	 * Initializes this AVL tree to empty.
	 *
	 */
	public AVLTree() {
		root = null;
		size = 0;
	}
	
	/**
	 * Searches for the given key in this AVL tree and returns the associated
	 * value if the key exists, otherwise returns null. Search takes 
	 * O(log n) time in the worst case.
	 * 
	 * @param key Key 
	 * @return value associated with key if exists, else null
	 */
	public String get(int key) {
		AVLTreeNode node = root;
		while (node != null) {
			if (key == node.key) {
				return node.value;
			}
			if (key < node.key) {
				node = node.left;
			} else {
				node = node.right;
			}
		}
		return null;
	}

	/**
	 * Inserts a (key,value) pair into this AVL tree. If key already exists, then
	 * replaces the old value with the given value and returns the old. Otherwise,
	 * inserts and returns null. Insertion takes O(log n) time in the worst case.
	 * 
	 * @param key Key 
	 * @param value Value
	 * @return Old value
	 */
	public String put(int key, String value) {
		/** COMPLETE THIS METHOD **/

		// following line is a placeholder for compiler
		return null;
	}

	/**
	 * Makes an isomorphic AVL tree for a given BST that is AVL-balanced, 
	 * in O(n) time. 
	 *  
	 * @param root Root of the BST
	 * @return AVL tree
	 */
	public static AVLTree makeIsomorphicAVL(BSTNode root) {
		/** COMPLETE THIS METHOD **/
		
		// following line is a placeholder for compiler
        return null;
	}
	
	/**
	 * Builds an AVL tree out of an array list of (key,value) pairs sorted in ascending order
	 * of keys, in worst case O(n) time where n is the number of (key,value) pairs.
	 * 
	 * @param al Sorted array list of (key,value) pairs
	 * @return AVL Tree
	 */
	public static AVLTree makeAVLTree(ArrayList<KeyValuePair> al) {
		/** COMPLETE THIS METHOD **/
		
		// following line is a placeholder for compiler
		return null;
	}
	
	public void printPreorder() {
    	printPreorder(root);
    	System.out.println();
    }

    static void printPreorder(AVLTreeNode root) {
    	if (root == null) {
    		return;
    	}

    	System.out.print(" " + root + " ");
    	printPreorder(root.left);
    	printPreorder(root.right);
    }
   
    public void printInorder() {
    	printInorder(root);
    	System.out.println();
    }
    
    static void printInorder(AVLTreeNode root) {
    	if (root == null) {
    		return;
    	}

    	printInorder(root.left);
    	System.out.print(" " + root + " ");
    	printInorder(root.right);
    }
}
