/*
 * Written By: Rubaisha Aslam 
 * Student Number: 251179721
 * Assignment 4
 * This class represents the location (x, y) of a pel will be used in other classes 
 * */

public class Location {
	private int x;
	private int y;
	
	// Initialize the x and y value 
	public Location (int x, int y) {
		this.x =x;
		this.y = y;
	}
	
	// return x coordinate
	public int getx() {
		return x;
	}
	// returns y coordinate
	public int gety() {
		return y;
	}
	
	/*
	 * compareTo compares this location to given/other location
	 * if this is greater than other return 1
	 * if this is less than other return -1
	 * if this is same return 0
	 * else return -10
	 */
	public int compareTo(Location p) {
		if (this.gety() > p.gety()) {
			return 1; 
			}
		if (this.gety() == p.gety() && this.getx() > p.getx()) {
			return 1;
			}
		if (this.gety() == p.gety() && this.getx() == p.getx()) {
			return 0;
			}
		if (this.gety() < p.gety()) {
			return -1;
		}
		if (this.gety() == p.gety() && this.getx() < p.getx()) {
			return -1;
		}
		return -10;
		
	}
}
