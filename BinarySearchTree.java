/*
 * Written By: Rubaisha Aslam 
 * Assignment 4
 * This class implements an ordered dictionary using a binary search tree
 * Node of the tree will store Pel object; 
 * the characteristic Location of the Pel object stored in a node will be its key attribute
 * the BST internal node will have data and leaves will be notes with no data
 */

public class BinarySearchTree implements BinarySearchTreeADT {
	private BNode root;

	// create a tree with root
	public BinarySearchTree() {
		root = new BNode(); 
	}
	/*
	 * takes in the root and key 
	 * check if root is leaf if yes return node
	 * else return find the node that has the name value as given key
	 * or do a recursive call to the left or right till found 
	 */
	private BNode findNode(BNode r, Location key) {
		if (r.isLeaf())
			return r;
		else{
			Location loc = r.getData().getLocus();
			if (loc.compareTo(key) == 0)
				return r;
			else if (loc.compareTo(key) == -1) {
			    return findNode(r.rightChild(), key);
			    }
			else {
			    return findNode(r.leftChild(), key);
			}
		}
	}
	
	/*
	 * takes the root and key and calls findNode method
	 * return the Pel object of the key else null
	 */
	public Pel get(BNode r, Location key) {
		return findNode(r, key).getData();  
	}

	/*
	 * takes in the root and Pel newData
	 * if node is not a leaf so already there throw error 
	 * else update the parent, left and right child 
	 */
	public void put (BNode r, Pel newData) throws DuplicatedKeyException{
		Location loc = newData.getLocus();
		BNode p = findNode(r, loc);
		if (!p.isLeaf()) {
			throw new DuplicatedKeyException("ALREADY THERE");
		}else {
			p.setContent(newData);
			p.setLeftChild(new BNode());
			p.setRightChild(new BNode());
			p.leftChild().setParent(p);
			p.rightChild().setParent(p);
		}
	}
	
	/*
	 * takes in the root and key 
	 * removes data containing the key if in tree else throws exception
	 */
	public void remove(BNode r, Location Key) throws InexistentKeyException {
		BNode p = findNode(r, Key);
		if (p.isLeaf()) {
			throw new InexistentKeyException("NOT THERE");
		}else {
			BNode pParent = p.parent();
			// check if left or right are leaf 
				//if yes check if the parent is null 
				//if not null check if the p parent child (left or right) equals to the p vale if so child p 
					// if yes remove p and set p parent child to the left or right node of p 
			if (p.leftChild().isLeaf()) {
				BNode child = p.rightChild(); 
				if (pParent == null) {
					root = child;
				}else {
					if (pParent.leftChild().getData().getLocus().compareTo(p.getData().getLocus()) == 0) {
						pParent.setLeftChild(child);
						child.setParent(pParent);				}
					else {
						pParent.setRightChild(child);
						child.setParent(pParent);}}
				return;}
			else if (p.rightChild().isLeaf()) {
				BNode childl = p.leftChild(); 
				if (pParent == null) {
					root = childl;
				}else {
					if (pParent.leftChild().getData().getLocus().compareTo(p.getData().getLocus()) == 0) {
						pParent.setLeftChild(childl);
						childl.setParent(pParent);}
					else {
						pParent.setRightChild(childl);
						childl.setParent(pParent);}}
				return;}
			else {
				try {
					//else find the smallest node and set it as p and remove that node from tree and its location
					Pel s = smallest(p.rightChild());
					p.setContent(s);
					BNode temp = findNode(p.rightChild(), s.getLocus());
					remove(temp, s.getLocus());
					}
				catch (EmptyTreeException e) {
					System.out.println("Empty tree");
					}
				}
			}
		}
	
	/*
	 * takes in the root and key 
	 * return successor = the largest node than smaller key 
	 */
	public Pel successor (BNode r, Location key) {
		if (r.isLeaf()){
			return null;
		}
		else {
			BNode p = findNode(r, key);
			if (!p.isLeaf() && !p.rightChild().isLeaf()) {
				try {
					return smallest(p.rightChild());
				}
				catch (EmptyTreeException e) {
					System.out.println("Empty tree.");
				}
			}else {
				BNode pParent = p.parent();
				// check if parent of p is not null and if the parent value is less than the key trying to find the successor of value
				while (pParent != null && pParent.getData().getLocus().compareTo(key) < 0) {
					pParent = pParent.parent();
				}
				if (pParent == null) {
					return null;
				}
				else{
					return pParent.getData();
				}
			}
		}
		return null;
	}
	
	/*
	 * takes in the root and key 
	 * return predecessor=  the smallest node than larger  key 
	 */
	public Pel predecessor (BNode r, Location key) {
		if (r.isLeaf()){
			return null;
		}
		else {
			BNode p = findNode(r, key);
			if ( !p.isLeaf() && !p.leftChild().isLeaf()) {
				try {
					return largest(p.leftChild());
				}
				catch (EmptyTreeException e) {
					System.out.println("Empty Tree");
				}
			}else {
				BNode pParent = p.parent();
				// check if parent of p is not null and if the parent value is more than the key trying to find the predecessor of value
				while (pParent != null && pParent.getData().getLocus().compareTo(key) > 0) {
					pParent = pParent.parent();
				}
				if (pParent == null) {
					return null;
				}
				else{
					return pParent.getData();
				}
			}
		}
		return null;
	}
	
	 /*
	  * input the root of the tree 
	  * returns the node storing the smallest tree (left child) or exception if the tree has no data	 
	  */
	 public Pel smallest(BNode r) throws EmptyTreeException{
			if (r.isLeaf()) {
				throw new EmptyTreeException("TREE IS NOT THERE BRO");
			}else {
				BNode p = r;
				while (!p.isLeaf()) {
					p = p.leftChild();
				}
				return p.parent().getData();
			}
		}
	 
	 /*
	  * input the root of the tree 
	  * returns the node storing the largest tree (right child) or exception if the tree has no data	 
	  */
	 public Pel largest(BNode r) throws EmptyTreeException{
			if (r.isLeaf()) {
				throw new EmptyTreeException("TREE IS NOT THERE BRO");
			}else {
				BNode p = r;
				while (!p.isLeaf()) {
					p = p.rightChild();
				}
				return p.parent().getData();
			}}
	
	 // return the root of BST
	public BNode getRoot() {
		return root;
	}
}
