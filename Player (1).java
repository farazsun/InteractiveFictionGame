/*
* [Player].java
* Author: [RYAN CULLEN]
* Statement of Academic Honesty:
*
* The following code represents my own work. I have neither
* received nor given inappropriate assistance. I have not copied
* or modified code from anywhere other than the authorized
* sources. I recognize that any unauthorized sharing, assistance,
* or plagiarism will be handled in accordance with both the
* University of Georgia's Academic Honesty Policy and the
* policies of this course. I recognize that my work is based on
* an assignment created by the Department of Computer
* Science at the University of Georgia. Any publishing or posting
* of source code at any time for this project is prohibited.
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
