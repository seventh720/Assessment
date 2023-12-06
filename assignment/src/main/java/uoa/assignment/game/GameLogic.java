package uoa.assignment.game;

import java.util.Scanner;

import uoa.assignment.character.GameCharacter;
import uoa.assignment.character.Player;
import uoa.assignment.character.Monster;

public class GameLogic {

    private Map gameMap;

    public GameLogic(Map gameMap) {
        this.gameMap = gameMap;
    }

	public static void moveCharacter(String input, Map gameMap, GameCharacter character) {
		 
        // check print value 
        switch (input.toLowerCase()) {
            case "up":
                moveUp(character, gameMap);
                break;
            case "down":
                moveDown(character, gameMap);
                break;
            case "left":
                moveLeft(character, gameMap);
                break;
            case "right":
                moveRight(character, gameMap);
                break;
            default:
                System.out.println("Use only keywords up, down, left, right");
                break;
        }
	}


    private static void moveUp(GameCharacter character, Map gameMap) {
    int newRow = character.getRow() - 1;
    int newColumn = character.getColumn();

    updateCharacterPosition(character, gameMap, newRow, newColumn);
}

    private static void moveDown(GameCharacter character, Map gameMap) {
    int newRow = character.getRow() + 1;
    int newColumn = character.getColumn();

    updateCharacterPosition(character, gameMap, newRow, newColumn);
}

    private static void moveRight(GameCharacter character, Map gameMap) {
    int newRow = character.getRow();
    int newColumn = character.getColumn() + 1;

    updateCharacterPosition(character, gameMap, newRow, newColumn);
}

    private static void moveLeft(GameCharacter character, Map gameMap) {
    int newRow = character.getRow();
    int newColumn = character.getColumn() - 1;

    updateCharacterPosition(character, gameMap, newRow, newColumn);
}
    private static boolean isValidPosition(int row, int column, Map gameMap) {
        // check whether new positions are in the map
        return row >= 0 && row < gameMap.layout.length && column >= 0 && column < gameMap.layout[0].length;
    }

    private static void updateCharacterPosition(GameCharacter character, Map gameMap, int newRow, int newColumn) {
        // check whether new positions are in the map
        if (isValidPosition(newRow, newColumn, gameMap)) {
            // clean old positions and set it to "."
            gameMap.layout[character.getRow()][character.getColumn()] = ".";
            // update positions of characters
            character.setRow(newRow);
            character.setColumn(newColumn);
            // Update new positions in layout array
            gameMap.layout[newRow][newColumn] = character instanceof Player ? "*" : "%";
        } else {
            System.out.println("Invalid move. Out of bounds.");
        }
    }
}
