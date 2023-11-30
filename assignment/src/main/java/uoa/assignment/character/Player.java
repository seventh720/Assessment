package uoa.assignment.character;

import java.util.Random;

public class Player extends GameCharacter{

	public Player(String name) {
		super(name);
	}

    @Override
    public void hurtCharacter(GameCharacter character) {
        // Remove 50 health points if the monster did not defend successfully
        if (!character.successfulDefense()) {
            int currentHealth = character.getHealth();
            character.setHealth(currentHealth - 50);
        }
    }

    @Override
    public boolean successfulDefense() {
        // Randomly decide whether the monster can defend successfully with a 30% chance of successful defense
        Random random = new Random();
        return random.nextDouble() <= 0.3;
    }

    
    public String decideMove() {
        return "move";
    }
}