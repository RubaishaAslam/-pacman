/*
 * Written By: Rubaisha Aslam 
 * Assignment 4
 * This class creates the objects for the game to be played. It stores the locus and the BST.
 * */
public class MyObject {
	
	private String type;
	private int height;
	private int width;
	private int id;
	private Location locus;
	private BinarySearchTree tree;

	/*
	 * Initialize the binary tree, id, width, height, type, pos/locus for this myObject
	 */
	public MyObject (int id, int width, int height, String type, Location pos) {
		tree = new BinarySearchTree();
		this.id = id;
		this.width = width;
		this.height = height;
		this.type = type;
		this.locus = pos;
	}
	
	// set type of this myObject
	public void setType (String type) {
		this.type = type;
	}
	
	// returns width of rectangle for this myObject
	public int getWidth () {
		return width;
	}
	
	// returns width of rectangle for this myObject
	public int getHeight() {
		return height;
	}
	
	// returns type of this myObject
	public String getType () {
		return type;
	}
	
	// returns id of this myObject
	public int getId() {
		return this.id;
	}
	
	// returns locus of this myObject
	public Location getLocus() {
		return locus;
	}
	
	// set locus of this myObject to value
	public void setLocus(Location value) {
		this.locus = value;
	}
	
	// insert pix in this myObject tree using put else if error throw exception
	public void addPel(Pel pix) throws DuplicatedKeyException{
		try{
			this.tree.put(this.tree.getRoot(), pix);
		} catch (DuplicatedKeyException e){
			System.out.println("Duplicated key in Tree");
		}
		
	}
	
	/*
	 * takes in the otherOject
	 * checks if the thisMyObject intersects with the otherObject if so return true else false 
	 */
	public boolean intersects (MyObject otherObject) {
		try {
			// find the smallest of this tree
			Pel value= this.tree.smallest(this.tree.getRoot());
			// if smallest is not null
			while(value != null) {
				// use the location formula
				// (x′, y′) = (x + xf − xf′, y + yf − yf′)
				Location loc2 = new Location(value.getLocus().getx() + this.getLocus().getx() - otherObject.getLocus().getx(), 
						value.getLocus().gety() + this.getLocus().gety() - otherObject.getLocus().gety());
				// if there is a value and location that was calculated there and not null return true
				if(otherObject.tree.get(otherObject.tree.getRoot(), loc2) != null) {
					return true;
				}
			// go to successor of this tree and loop again
			value = this.tree.successor(this.tree.getRoot(), value.getLocus());
			}
		} catch (EmptyTreeException e) {
			System.out.println("Empty Tree");
		}
	
	return false;
	
}}
