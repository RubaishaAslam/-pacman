/*
 * Written By: Rubaisha Aslam 
 * Assignment 4
 * This class represents the data items to be stored in the nodes of the binary search tree 
 * */

public class Pel {
	private int color;
	private Location p;
	
	// Initialize the new Pel coordinate and color 
	public Pel(Location p, int color) {
		 this.p = p;
		 this.color = color;
	 }
	
	// return the location of this Pel
	public Location getLocus() {
		return this.p;
	}
	
	// return the color of this Pel
	public int getColor() {
		return this.color;
	}
}
