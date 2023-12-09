package uoa.assignment.game;

import uoa.assignment.character.GameCharacter;
import uoa.assignment.character.Monster;
import uoa.assignment.character.Player;

public class Game {
    
    private Map map;

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
        // move the player based on user input and print Player's move
        Player player = (Player) map.characters[0];
        System.out.println("Player"+ " is moving " + input); 
        GameLogic.moveCharacter(input, map, player);
        
        // move all living monsters automatically and print Monster's move
        for (int i = 1; i < map.characters.length; i++) {
            GameCharacter character = map.characters[i];
            if (character instanceof Monster && character.getHealth() > 0) {
                String monsterMove = ((Monster) character).decideMove();
                System.out.println(character.sayName() + " is moving " + monsterMove);    
                GameLogic.moveCharacter(monsterMove, map, character);               
            }
        }

         // print the health status of each character
        for (GameCharacter character : map.characters) {
            System.out.println("Health " + character.sayName() + ": " + character.getHealth());
        }
          
        map.printLayout();

        // check if the player has won the game
        if (areAllMonstersDead()) {
            System.out.println("YOU HAVE WON!");
            return true;
        }

        // check if the player has died
        if (player.getHealth() <= 0) {
            System.out.println("YOU HAVE DIED!");
            return true;
        }
        return false;
    }

    // check if all monsters have died
    private boolean areAllMonstersDead() {
        for (int i = 1; i < map.characters.length; i++) {
            GameCharacter character = map.characters[i];
            if (character instanceof Monster && character.getHealth() > 0) {
                return false;
            }
        }
        return true;
    }
}