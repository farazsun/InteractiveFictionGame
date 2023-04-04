/*
* Player.java
* Author: Faraz Sunil
*/
public class Player {
	
	// Creating the variables storing the x and y coordinates of the player.
	private int x;
	private int y;
	
	// Creating class instances of the lamp and key.
	private Lamp lamp;
	private Key key;
	
	// This method sets the value of x to the parameter.
	public void setX(int X) {
		this.x = X;
	}
	// This method returns the value of x.
	public int getX() {
		return this.x;
	}
	
	// This method sets the value of y to the parameter.
	public void setY(int Y) {
		this.y = Y;
	}
	
	// This method returns the value of y.
	public int getY() {
		return this.y;
	}
	
	// This method returns the lamp.
	public Lamp getLamp() {
		return lamp;
	}
	
	// This method sets the lamp to the parameter.
	public void setLamp(Lamp lamp) {
		this.lamp = lamp;
	}
	
	// This method returns the key.
	public Key getKey() {
		return key;
	}
	
	// This method sets the key to be the parameter.
	public void setKey(Key key) {
		this.key = key;
	}
}
