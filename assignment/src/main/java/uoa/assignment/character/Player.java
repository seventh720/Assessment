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

    public void attack(Monster monster) {
        // 这里可以根据需要实现攻击逻辑
        // 假设攻击成功，怪物减少 50 健康值
        monster.setHealth(monster.getHealth() - 50);
    }

}