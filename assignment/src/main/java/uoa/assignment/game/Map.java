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
    
        // create an instance of player and place it in specific position
        Player player = new Player("Player");
        player.row = height - 1;
        player.column = width - 1;
        characters[0] = player;
        layout[player.row][player.column] = "*";

        // create three instances of monster and place them in specific positions
        Monster monster1 = new Monster("Monster1");
        monster1.row = 0;
        monster1.column = width - 1;
        characters[1] = monster1;
        layout[monster1.row][monster1.column] = "%";

        Monster monster2 = new Monster("Monster2");
        monster2.row = height - 1;
        monster2.column = 0;
        characters[2] = monster2;
        layout[monster2.row][monster2.column] = "%";

        Monster monster3 = new Monster("Monster3");
        monster3.row = 0;
        monster3.column = 0;
        characters[3] = monster3;
        layout[monster3.row][monster3.column] = "%";
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
            System.out.println();  //new line
        }
    }

}

