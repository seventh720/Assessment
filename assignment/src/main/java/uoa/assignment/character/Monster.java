package uoa.assignment.character;

import java.util.Random;

public class Monster extends GameCharacter {

	public  Monster(String name) {
		super(name);
	}


	public void hurtCharacter(GameCharacter character) {
		// Remove 20 health points if the character did not defend successfully
        if (!character.successfulDefense()) {
            int currentHealth = character.getHealth();
            character.setHealth(currentHealth - 20);
        }
	}

	
	public boolean successfulDefense() {
		// Randomly decide whether the character can defend successfully
        Random random = new Random();
        return random.nextBoolean();
	}


	
	public String decideMove () {		
		return "move";
	}

}
