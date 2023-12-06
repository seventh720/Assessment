package uoa.assignment.game;

import uoa.assignment.character.Monster;

public class Game {
    
    private Map map;

    public Game(int mapHeight, int mapWidth) {
        // instantiate and initialize a Map object
        map = new Map(mapHeight, mapWidth);

        //  print the layout to the console
        map.printLayout();
    }
    			
    public Map getMap() {
        return null;
    }
    
    public boolean nextRound (String input) {
        return true;
    }
   
}