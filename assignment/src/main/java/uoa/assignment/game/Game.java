package uoa.assignment.game;

import uoa.assignment.character.GameCharacter;
import uoa.assignment.character.Monster;
import uoa.assignment.character.Player;

public class Game {
    
    private Map map;
    private static boolean gameOver = false;

    public Game(int mapHeight, int mapWidth) {
        // instantiate and initialize a Map object
        map = new Map(mapHeight, mapWidth);

        //  print the layout to the console
        map.printLayout();

    }
    			
    public Map getMap() {
        return map;
    }
    
    public boolean nextRound (String input) {
        // Move the player based on user input
        Player player = (Player) map.characters[0];
        GameLogic.moveCharacter(input, map, player);

        // Move all living monsters automatically
        for (int i = 1; i < map.characters.length; i++) {
            GameCharacter character = map.characters[i];
            if (character instanceof Monster && character.getHealth() > 0) {
                String monsterMove = ((Monster) character).decideMove();
                GameLogic.moveCharacter(monsterMove, map, character);               
            }
        }

         // Print the health status of each character
        for (GameCharacter character : map.characters) {
            System.out.println("Health " + character.sayName() + ": " + character.getHealth());
        }

        // Player's move
        System.out.println("Player"+ " is moving " + input); 

        // Monster's move
        for (int i = 1; i < map.characters.length; i++) {
            GameCharacter character = map.characters[i];
            if (character.getHealth() > 0) {
                System.out.println(character.sayName() + " is moving " + ((Monster) character).decideMove());
            }
        }

        map.printLayout();


    if (areAllMonstersDead()) {
            System.out.println("YOU HAVE WON!");
            gameOver = true;
            return true;
        }

        // Check if the player has died
        if (player.getHealth() <= 0) {
            System.out.println("YOU HAVE DIED!");
            gameOver = true;
            return true;
        }

        return false;
    }

    private boolean areAllMonstersDead() {
        for (int i = 1; i < map.characters.length; i++) {
            GameCharacter character = map.characters[i];
            if (character instanceof Monster && character.getHealth() > 0) {
                return false;
            }
        }
        return true;
    }

    // Additional method to check if the game is over
    public static boolean isGameOver() {
        return gameOver;
    }
}