package uoa.assignment.game;

import uoa.assignment.character.GameCharacter;
import uoa.assignment.character.Player;
import uoa.assignment.character.Monster;

public class GameLogic {

    private Map gameMap;

    public GameLogic(Map gameMap) {
        this.gameMap = gameMap;
    }

    public static void moveCharacter(String input, Map gameMap, GameCharacter character) {


        // Check if the player is attempting to move to a position with a monster
        if (character instanceof Player) {
            checkPlayerAttack(input, (Player)character, (Monster)gameMap.characters[1], gameMap);
            checkPlayerAttack(input, (Player)character, (Monster)gameMap.characters[2], gameMap);
            checkPlayerAttack(input, (Player)character, (Monster)gameMap.characters[3], gameMap);
        }
        else if(character instanceof Monster) {
            checkMonsterAttack(input,(Player)gameMap.characters[0], (Monster)character);
        }

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
        
    private static void checkPlayerAttack(String input, Player player, Monster monster, Map gameMap) {
        if (input.equals("up") && player.getRow() - 1 == monster.getRow() && player.getColumn() == monster.getColumn()) {
            // player attempt to attack monster
            System.out.println("Player is attacking " + monster.sayName());
            player.hurtCharacter(monster);            
            }
            else if(input.equals("down") && player.getRow() + 1 == monster.getRow() && player.getColumn() == monster.getColumn()){
                System.out.println("Player is attacking " + monster.sayName());
                player.hurtCharacter(monster);            
                }
            else if(input.equals("left") && player.getRow() == monster.getRow() && player.getColumn() - 1== monster.getColumn()){
                System.out.println("Player is attacking " + monster.sayName());
                player.hurtCharacter(monster);            
                } 
            else if(input.equals("right") && player.getRow() == monster.getRow() && player.getColumn() + 1 == monster.getColumn()){
                System.out.println("Player is attacking " + monster.sayName());
                player.hurtCharacter(monster);            
                }
        if (monster.getHealth() <= 0) {
            // update the string of monster to "x"
            gameMap.layout[monster.getRow()][monster.getColumn()] = "x";
            // set monster.isdead = true
            monster.setDead(true);
        }        
    }

    private static void checkMonsterAttack(String input, Player player, Monster monster) {
        if (input.equals("up") && monster.getRow() - 1 == player.getRow() && player.getColumn() == monster.getColumn()) {
            // monster attempt to attack player
            System.out.println(monster.sayName() + " is attacking player ");
            monster.hurtCharacter(player);            
            }
            else if(input.equals("down") && monster.getRow() + 1 == player.getRow() && player.getColumn() == monster.getColumn()){
                System.out.println(monster.sayName() + " is attacking player ");
                monster.hurtCharacter(player);             
                }
            else if(input.equals("left") && player.getRow() == monster.getRow() && monster.getColumn() - 1== player.getColumn()){
                System.out.println(monster.sayName() + " is attacking player ");
                monster.hurtCharacter(player);             
                } 
            else if(input.equals("right") && player.getRow() == monster.getRow() && monster.getColumn() + 1 == player.getColumn()){
                System.out.println(monster.sayName() + " is attacking player ");
                monster.hurtCharacter(player);              
                }
    }
    
    private static void moveUp(GameCharacter character, Map gameMap) {
        int newRow = character.getRow() - 1;
        int newColumn = character.getColumn();

        if (isValidPosition(newRow, newColumn, gameMap)) {
            updateCharacterPosition(character, gameMap, newRow, newColumn);
        } else {
            System.out.println("You can't go up. You lose a move.");
        }
    }

    private static void moveDown(GameCharacter character, Map gameMap) {
        int newRow = character.getRow() + 1;
        int newColumn = character.getColumn();

        if (isValidPosition(newRow, newColumn, gameMap)) {
            updateCharacterPosition(character, gameMap, newRow, newColumn);
        } else {
            System.out.println("You can't go down. You lose a move.");
        }
    }

    private static void moveRight(GameCharacter character, Map gameMap) {
        int newRow = character.getRow();
        int newColumn = character.getColumn() + 1;

        if (isValidPosition(newRow, newColumn, gameMap)) {
            updateCharacterPosition(character, gameMap, newRow, newColumn);
        } else {
            System.out.println("You can't go right. You lose a move.");
        }
    }

    private static void moveLeft(GameCharacter character, Map gameMap) {
        int newRow = character.getRow();
        int newColumn = character.getColumn() - 1;

        if (isValidPosition(newRow, newColumn, gameMap)) {
            updateCharacterPosition(character, gameMap, newRow, newColumn);
        } else {
            System.out.println("You can't go left. You lose a move.");
        }
    }

    private static boolean isValidPosition(int row, int column, Map gameMap) {
        // check whether new positions are in the map
        return row >= 0 && row < gameMap.layout.length && column >= 0 && column < gameMap.layout[0].length;
    }

    private static void updateCharacterPosition(GameCharacter character, Map gameMap, int newRow, int newColumn) {
        if (isValidPosition(newRow, newColumn, gameMap)) {
            if (gameMap.layout[newRow][newColumn].equals(".")) {
                // clean old positions and set it to "."
                gameMap.layout[character.getRow()][character.getColumn()] = ".";
                // update positions of characters
                character.setRow(newRow);
                character.setColumn(newColumn);
                // update new positions in layout array
                gameMap.layout[newRow][newColumn] = character instanceof Player ? "*" : "%";                          
            } else if(character instanceof Monster){
                if (gameMap.layout[newRow][newColumn].equals("%")){
                System.out.println("Monster already there so can't move");   
                }
            }
    } else {
        // if new positions are not in the map
        System.out.println("Invalid move. Out of bounds.");
        }
    }
}
