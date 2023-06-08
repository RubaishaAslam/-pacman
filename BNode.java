/*
 * Written By: Rubaisha Aslam 
 * Assignment 4
 * This class represents the nodes of the binary search tree
 * Each node such as parent, left and right would store an object of the class Pel
 */

public class BNode {
	private Pel valuePel;
	private BNode left;
	private BNode right;
	private BNode parent;

	/*
	 * Initialize the Pel value, BNode value left, right and parent
	 */
	public BNode (Pel value, BNode left, BNode right, BNode parent) {
		 this.valuePel = value;
		 this.left = left;
		 this.right = right;
		 this.parent = parent;
		 
	 }
	
	// set the values to null to initialize the leaf node 
	public BNode() {
		valuePel = null;
		left = null;
		right = null;
		parent = null;
	}
	
	// return parent of node
	public BNode parent(){
		return parent;
	
	}
	
	// set parent of this node with the value 
	public void setParent(BNode newParent) {
		parent = newParent;
	}
	
	// set left child of this node with the value
	public void setLeftChild (BNode p) {
		left = p;
	}
	
	// set right child of this node with the value
	public void setRightChild (BNode p) {
		 right =p;
	 }
	
	// store the Pel value in this node 
	public void setContent(Pel value) {
		 valuePel = value;
	 }
	
	// check if valuePel is empty to see if it is a leaf or not 
	public boolean isLeaf() {
		 if (valuePel == null) {
			 return true;
		 }
		 return false;
	 }
	
	// return the Pel object in this node 
	public Pel getData() {
		 return valuePel;
	 }
	
	// return the left child of this node 
	public BNode leftChild() {
		 return left;
	 }
	
	// return the right child of this node 
	public BNode rightChild() {
		 return right;
	 }
}
