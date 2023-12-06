package uoa.assignment.game;

import uoa.assignment.character.GameCharacter;
import uoa.assignment.character.Monster;
import uoa.assignment.character.Player;

public class Map {

    public String [][] layout;
    public GameCharacter characters [] ;
 
    Map (int height, int width) {
        //initilaize a 2D array layout
	    layout = new String[height][width];

        //initilaize characters which can hold four objects
        characters = new GameCharacter[4];

        //initialize the array
        initialiseArray();   
    }
    


    private void initialiseArray(){
        for (int i = 0; i < layout.length; i++){
            for (int j = 0; j < layout[i].length; j++) {
                layout[i][j] = ".";
            }
        }
    }

    public void printLayout() {
        for (String[] row : layout) {
            for (String cell : row) {
                System.out.print(cell);
            }
            System.out.println(); 
        }
    }
}
