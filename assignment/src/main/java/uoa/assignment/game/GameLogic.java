package uoa.assignment.game;

import java.util.Scanner;

import uoa.assignment.character.GameCharacter;
import uoa.assignment.character.Player;
import uoa.assignment.character.Monster;

public class GameLogic {

	public static void moveCharacter(String input, Map gameMap, GameCharacter character) {
		 
        // check print value 
        switch (input.toLowerCase()) {
            case "up":
                break;
            case "down":
                break;
            case "left":
                break;
            case "right":
                break;
            default:
                System.out.println("Use only keywords up, down, left, right");
                break;
        }
	}
	
}
