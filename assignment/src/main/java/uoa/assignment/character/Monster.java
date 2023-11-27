package uoa.assignment.character;

import java.util.Random;

public class Monster extends GameCharacter {

	public  Monster(String name) {
		super(name);
	}


	public void hurtCharacter(GameCharacter character) {
		if (!character.successfulDefense()){
            // Remove 50 health points if the character did not defend successfully 
            character.setHealth(character.getHealth() - 50);
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
