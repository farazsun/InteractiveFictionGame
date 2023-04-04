/*
* [Chest].java
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
public class Chest {
	
	// Creating a class instance for the key.
	private Key rightKey;
	
	// Variable used to determine if the chest is locked in the isLocked() method.
	private boolean locked = true;
	
	// Variable storing the contents inside the chest.
	private String content;

	/**
	 * This method is used by the Map class, you won't need to call it yourself
	 * It should result in this chest being locked and storing which key locked it.
	 */
	public void lock(Key theKey) {
		this.rightKey = theKey;
		locked = true;
	}
	
	/**
	 * If theKey is the same key that was used to lock this chest, then
	 * the chest is unlocked.  Otherwise this method does nothing.
	 */
	public void unLock(Key theKey) {
		if (theKey.equals(this.rightKey)) {
			locked = false;
		}
	}
	
	/**
	 * Should return true if the chest is locked, false otherwise
	 */
	public boolean isLocked() {
		boolean isLocked;
		if (locked) {
			isLocked = true;
		}
		else {
			isLocked = false;
		}
		return isLocked;
	}
	
	/**
	 * Return a string describing the contents of the chest.
	 */
	public String getContents() {
		return content;
	}
	
	/**
	 * Set the contents of the chest to this string.  You should not need to call
	 * this method in your program (though you have to implement it anyway).
	 */
	public void setContents(String contents) {
		this.content = contents;
	}
	
	
	
}

