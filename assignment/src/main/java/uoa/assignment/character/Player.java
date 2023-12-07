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
            System.out.println("!!HIT!! Player successfully attacked " + character.sayName());
        }else{
            System.out.println("!!MISS!! " + character.sayName() + " successfully defended attack from " + this.sayName());
        }
        // Check if the character is a Monster and its health is now zero or below
        if (character instanceof Monster && character.getHealth() <= 0) {
            // Monster is defeated
            System.out.println(character.sayName() + " has been defeated!");
        }
    }

    @Override
    public boolean successfulDefense() {
        // Randomly decide whether the player can defend successfully with a 30% chance of successful defense
        Random random = new Random();
        return random.nextDouble() <= 0.3;
    }


    public String decideMove() {
        return "move";
    }

}