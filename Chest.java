/*
* Chest.java
* Author: Faraz Sunil
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

