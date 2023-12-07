package uoa.assignment.character;

import java.util.Random;

public class Monster extends GameCharacter {

	public  Monster(String name) {
		super(name);
	}


	public void hurtCharacter(GameCharacter character) {
		// Remove 20 health points if the player did not defend successfully
        if (!character.successfulDefense()) {
            int currentHealth = character.getHealth();
            character.setHealth(currentHealth - 20);
            System.out.println("!!HIT!!" + this.sayName() " successfully attacked " + character.sayName());
        }else{
            System.out.println("!!MISS!! " + character.sayName() + " successfully defended attack from " + this.sayName());
        }        
        }
	}

	
	public boolean successfulDefense() {
		// Randomly decide whether the monster can defend successfully
        Random random = new Random();
        return random.nextBoolean();
	}

	
	public String decideMove () {		
	    // Randomly decide the move direction
        String[] directions = {"up", "down", "left", "right"};
        Random random = new Random();
        int randomIndex = random.nextInt(directions.length);
        return directions[randomIndex];
    }
}
