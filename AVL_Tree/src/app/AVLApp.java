package app;

import java.util.*;
import java.io.*;

import structures.*;

public class AVLApp {
	
	static AVLTree avlTree = null;
	static Scanner kb;

    static void put() 
    throws IOException {
    	System.out.print("\tEnter key(int)-value(string) pair to insert, separated by spaces: ");
    	int key = kb.nextInt();
    	String value = kb.next();
		String oldval = avlTree.put(key,value);
		if (oldval != null) {
			System.out.println("\treplaced (" + key + "," + oldval + ") with (" + key + "," + value + ")");
		} else {
			System.out.println("\tinserted (" + key + "," + value + ")");
		}
    }
    
    static void get() 
    throws IOException {
    	System.out.print("\tEnter key(int): ");
    	int key = kb.nextInt();
    	String value = avlTree.get(key);
		if (value != null) {
			System.out.println("\tfound (" + key + "," + value + ") in the tree");
		} else {
			System.out.println("\tkey " + key + " is not in the tree");
		}
    }
    
    static void build() 
    throws IOException {
    	System.out.print("\tEnter name of file that has sorted list of (key,value) pairs: ");
		String fileName = kb.next();
		
		Scanner sc = new Scanner(new File(fileName));
	
		// first line is number of pairs
		int n = sc.nextInt();
		ArrayList<KeyValuePair> al = new ArrayList<KeyValuePair>(n);
	
		for (int i = 0 ; i < n ; i++) {
			al.add(new KeyValuePair(sc.nextInt(), sc.next()));
		}
		
		avlTree = AVLTree.makeAVLTree(al);
    }
    
    static void makeIsomorphic() 
    throws IOException {
    	System.out.print("\tEnter name of AVL-balanced BST signature file: ");
		String fileName = kb.next();
		
		Scanner sc = new Scanner(new File(fileName));
		
		int size = sc.nextInt();
		
		KeyValuePair[] pre = new KeyValuePair[size];
		for (int i = 0 ; i < size ; i++) {
			pre[i] = new KeyValuePair(sc.nextInt(), sc.next());
		}
		KeyValuePair[] in = new KeyValuePair[size];
		for (int i = 0 ; i < size ; i++) {
			in[i] = new KeyValuePair(sc.nextInt(), sc.next());
		}
		
		BSTNode bstRoot = BSTNode.buildTree(pre, in);
		avlTree = AVLTree.makeIsomorphicAVL(bstRoot);
    }
    
    public static void main(String[] args) throws IOException {

    	kb = new Scanner(System.in);
    	
    	while (true) {
    		System.out.print("Do you want to (b)uild an AVL tree from a sorted list, or\n" +
    							"build an (i)somorphic AVL tree from an AVL-balanced BST, or \n" +
    							"(s)tart from scratch?\n" +
    							"Enter b, or i or s: ");
    		String line = kb.next();
    		if (line.length() == 0) { continue; }
    		char ch = line.charAt(0);
    		if (ch == 'b') {
    			build(); 
    			break;
    		} else if (ch == 's') {
    			avlTree = new AVLTree();
    			break;
    		} else if (ch == 'i') {
    			makeIsomorphic();
    			break;
    		} else {
    			continue;
    		}
    	}
    	System.out.println("\t...Tree is ready\n\n");
    	
    	while (true) {
    		System.out.print("\tDo you want to (i)insert/put, (g)et, (p)print, or (q)uit? ");
    		String line = kb.next();
    		if (line.equals("")) {
    			continue;
    		} 

    		switch(line.charAt(0)) {
    		case 'q': System.exit(0);
    		case 'i': put(); break;
    		case 'g': get(); break;			
    		case 'p': print();
    		}
    	}
    }

    static void print() {
    	System.out.print("\n\tpreorder: ");
    	avlTree.printPreorder();
    	System.out.print("\tinorder: ");
    	avlTree.printInorder();
    	System.out.println();
    }
}

	    
