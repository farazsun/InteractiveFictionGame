/*
* [Adventure].java
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
import java.util.Scanner;

public class Adventure {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// Created a player and map.
		Player player = new Player();
		Map map = new Map();
		
		// Creating class instances for the adventure class.
		Lamp adventureLamp;
		Key adventureKey;
		Chest adventureChest;
		
		
		System.out.println("Welcome to UGA Adventures: Episode 1\n"
				+ "The Adventure of the Cave of Redundancy Adventure\n"
				+ "By: Ryan Cullen\n");
		
		player.setX(0); player.setY(0); // Setting the player's initial position to (0,0).
		
		// Getting the description of the room the player is currently in (0,0).
		System.out.println(map.getRoom(player.getX(), player.getY()).getDescription());
		
		boolean continueTheGame = true; // Game continues until continueTheGame is set to false (set to false when the player finds gold or dies).
		
		while (continueTheGame) {
			// User's command will be stored as userInput.
			String userInput = scan.nextLine();
			
			// If the room does not have a lamp, "No lamp present." is outputted to the user. Else, the lamp is transitioned from the room to the user,
			// and then the lamp is cleared from the room.
			if (userInput.equalsIgnoreCase("GET LAMP")) {
				if (map.getRoom(player.getX(), player.getY()).getLamp() == null) {
					System.out.println("No lamp present.");
				}
				else {
					System.out.println("OK");
					adventureLamp = map.getRoom(player.getX(), player.getY()).getLamp();
					player.setLamp(adventureLamp);
					map.getRoom(player.getX(), player.getY()).clearLamp(); 
				}
			}
			
			// If the user does not have the lamp, then he/she does not have a lamp to light. Else, the lamp is lit, and isLit is set to true.
			else if (userInput.equalsIgnoreCase("LIGHT LAMP")) {
				if (player.getLamp() == null) {
					System.out.println("You don't have the lamp to light.");
				}
				else {
					System.out.println("OK");
					player.getLamp().setIsLit(true);
				}
			}
			
			// If the room is dark and the player does not have the lamp, or the player has the lamp but it is not lit, then the player dies, and 
			// continueTheGame is set to false, ending the while loop and game. Else, whether the user can go north is analyzed. If the user can go 
			// north, the player's position is updated. They are warned they may be eaten by a grue if they do not have the lamp, or if they have it
			// but it is not lit. Else, they get the description of the room. If the user cannot go north, the user is informed they can't go that way.
			else if (userInput.equalsIgnoreCase("NORTH")) {
				if ((map.getRoom(player.getX(), player.getY()).isDark() && player.getLamp() == null) || 
						(map.getRoom(player.getX(), player.getY()).isDark() && player.getLamp() != null && player.getLamp().getIsLit() == false)) {
					continueTheGame = false;
					System.out.println("You have stumbled into a passing grue, and have been eaten");
				}				
				else if (map.getRoom(player.getX(), player.getY()).canGoNorth()) {
					player.setX(player.getX() - 1);
					if ((map.getRoom(player.getX(), player.getY()).isDark() && player.getLamp() == null) || 
							(map.getRoom(player.getX(), player.getY()).isDark() && player.getLamp() != null && player.getLamp().getIsLit() == false)) {
						System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
					}
					else {
						System.out.println(map.getRoom(player.getX(), player.getY()).getDescription());
					}
					
				}
				else if (map.getRoom(player.getX(), player.getY()).canGoNorth() == false){
					System.out.println("Can't go that way");
				}
			}
			
			// If the room is dark and the player does not have the lamp, or the player has the lamp but it is not lit, then the player dies, and 
			// continueTheGame is set to false, ending the while loop and game. Else, whether the user can go south is analyzed. If the user can go 
			// south, the player's position is updated. They are warned they may be eaten by a grue if they do not have the lamp, or if they have it
			// but it is not lit. Else, they get the description of the room. If the user cannot go south, the user is informed they can't go that way.
			else if (userInput.equalsIgnoreCase("SOUTH")) {
				if ((map.getRoom(player.getX(), player.getY()).isDark() && player.getLamp() == null) || 
						(map.getRoom(player.getX(), player.getY()).isDark() && player.getLamp() != null && player.getLamp().getIsLit() == false)) {
					continueTheGame = false;
					System.out.println("You have stumbled into a passing grue, and have been eaten");
				}				
				else if (map.getRoom(player.getX(), player.getY()).canGoSouth()) {
					player.setX(player.getX() + 1);
					if ((map.getRoom(player.getX(), player.getY()).isDark() && player.getLamp() == null) || 
							(map.getRoom(player.getX(), player.getY()).isDark() && player.getLamp() != null && player.getLamp().getIsLit() == false)) {
						System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
					}
					else {
						System.out.println(map.getRoom(player.getX(), player.getY()).getDescription());
					}
				}
				else if (map.getRoom(player.getX(), player.getY()).canGoSouth() == false){
					System.out.println("Can't go that way");
				}
			}
			
			// If the room is dark and the player does not have the lamp, or the player has the lamp but it is not lit, then the player dies, and 
			// continueTheGame is set to false, ending the while loop and game. Else, whether the user can go east is analyzed. If the user can go 
			// east, the player's position is updated. They are warned they may be eaten by a grue if they do not have the lamp, or if they have it
			// but it is not lit. Else, they get the description of the room. If the user cannot go east, the user is informed they can't go that way.
			else if (userInput.equalsIgnoreCase("EAST")) {
				if ((map.getRoom(player.getX(), player.getY()).isDark() && player.getLamp() == null) || 
						(map.getRoom(player.getX(), player.getY()).isDark() && player.getLamp() != null && player.getLamp().getIsLit() == false)) {
					continueTheGame = false;
					System.out.println("You have stumbled into a passing grue, and have been eaten");
				}				
				else if (map.getRoom(player.getX(), player.getY()).canGoEast()) {
					player.setY(player.getY() + 1);
					if ((map.getRoom(player.getX(), player.getY()).isDark() && player.getLamp() == null) || 
							(map.getRoom(player.getX(), player.getY()).isDark() && player.getLamp() != null && player.getLamp().getIsLit() == false)) {
						System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
					}
					else {
						System.out.println(map.getRoom(player.getX(), player.getY()).getDescription());
					}
				}
				else if (map.getRoom(player.getX(), player.getY()).canGoEast() == false){
					System.out.println("Can't go that way");
				}
			}
			
			// If the room is dark and the player does not have the lamp, or the player has the lamp but it is not lit, then the player dies, and 
			// continueTheGame is set to false, ending the while loop and game. Else, whether the user can go west is analyzed. If the user can go 
			// west, the player's position is updated. They are warned they may be eaten by a grue if they do not have the lamp, or if they have it
			// but it is not lit. Else, they get the description of the room. If the user cannot go west, the user is informed they can't go that way.
			else if (userInput.equalsIgnoreCase("WEST")) {
				if ((map.getRoom(player.getX(), player.getY()).isDark() && player.getLamp() == null) || 
						(map.getRoom(player.getX(), player.getY()).isDark() && player.getLamp() != null && player.getLamp().getIsLit() == false)) {
					continueTheGame = false;
					System.out.println("You have stumbled into a passing grue, and have been eaten");
				}				
				else if (map.getRoom(player.getX(), player.getY()).canGoWest()) {
					player.setY(player.getY() - 1);
					if ((map.getRoom(player.getX(), player.getY()).isDark() && player.getLamp() == null) || 
							(map.getRoom(player.getX(), player.getY()).isDark() && player.getLamp() != null && player.getLamp().getIsLit() == false)) {
						System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
					}
					else {
						System.out.println(map.getRoom(player.getX(), player.getY()).getDescription());
					}
				}
				else if (map.getRoom(player.getX(), player.getY()).canGoWest() == false){
					System.out.println("Can't go that way");
				}
			}
			
			// If the room is dark and the player doesn't have the lamp, or they have the lamp but it's not lit, then the player is warned he/she may
			// be eaten by a grue. Else, the player is given a description of the room. In addition, if the lamp, key, or chest is present in the
			// room, the user is informed. Then, if the user can go north, south, east, and/or west, then the user is informed of these possible exits.
			else if (userInput.equalsIgnoreCase("LOOK")) {
				if ((map.getRoom(player.getX(), player.getY()).isDark() && player.getLamp() == null) || 
						(map.getRoom(player.getX(), player.getY()).isDark() && player.getLamp() != null && player.getLamp().getIsLit() == false)) {
					System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
				}
				else {
					System.out.println(map.getRoom(player.getX(), player.getY()).getDescription());
					if (map.getRoom(player.getX(), player.getY()).getLamp() != null) {
						System.out.println("There is an old oil lamp that was made long ago here.");
					}
					if (map.getRoom(player.getX(), player.getY()).getKey() != null) {
						System.out.println("You see an outline of a key on a dusty shelf that's covered in dust.");
					}
					if (map.getRoom(player.getX(), player.getY()).getChest() != null) {
						System.out.println("There is a large, wooden, massive, oaken chest here with the word \"CHEST\" carved into it");
					}
					
					System.out.print("Exits are: ");
					if (map.getRoom(player.getX(), player.getY()).canGoNorth()) {
						System.out.println("north");
					}
					if (map.getRoom(player.getX(), player.getY()).canGoSouth()) {
						System.out.println("south");
					}
					if (map.getRoom(player.getX(), player.getY()).canGoEast()) {
						System.out.println("east");
					}
					if (map.getRoom(player.getX(), player.getY()).canGoWest()) {
						System.out.println("west");
					}
				}
			}
			
			// If the key is present in the room, the key transitions from the room to the user, and then the key is cleared from the room. If the key
			// is not present in the room, the user is notified there is no key present.
			else if (userInput.equalsIgnoreCase("GET KEY")) {
				if (map.getRoom(player.getX(), player.getY()).getKey() != null) {
					System.out.println("OK");
					adventureKey = map.getRoom(player.getX(), player.getY()).getKey();
					player.setKey(adventureKey);
					map.getRoom(player.getX(), player.getY()).clearKey();
				}
				else {
					System.out.println("No key present");
				}
			}
			
			// If there is no chest present in the room, then the user is informed there is no chest present. Else, if the chest is locked, the user
			// is informed the chest is locked. Else, the user wins the game when getting all the gold, and the while loop and thus game ends.
			else if (userInput.equalsIgnoreCase("OPEN CHEST")) {
				if (map.getRoom(player.getX(), player.getY()).getChest() == null) {
					System.out.println("No chest present");
				}
				else {
					adventureChest = map.getRoom(player.getX(), player.getY()).getChest();
					if (adventureChest.isLocked()) {
						System.out.println("The chest is locked");
					}
					else {
						System.out.println("all the gold");
						continueTheGame = false;
					}
				}
			}
			
			// If the player does not have the key, the user is informed they need the key to unlock the chest. If there is no chest present in the
			// room, the user is informed there is no chest. Else, the key is used to unlock the chest.
			else if (userInput.equalsIgnoreCase("UNLOCK CHEST")) {
				if (player.getKey() == null) {
					System.out.println("Need a key to do any unlocking!");
				}
				else if (map.getRoom(player.getX(), player.getY()).getChest() == null) {
					System.out.println("No chest to unlock");
				}
				else {
					adventureChest = map.getRoom(player.getX(), player.getY()).getChest();
					adventureKey = player.getKey();
					
					adventureKey.use(adventureChest);
					System.out.println("OK");
				}
			}
			
			// If the user's input is not one of the commands, then the user is informed, and the user can enter another command.
			else {
				System.out.println("I'm sorry I don't know how to do that.");
			}
		}
		scan.close();
	}
}
