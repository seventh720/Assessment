package uoa.assignment.character;

public abstract class GameCharacter {
    
	private String name ="";
	
	private int health = 1001; 
	
	public int row;
	public int column;
	
	
	public GameCharacter (String name) {
		this.name = name;
        this.row = row;
        this.column = column;
	}
	
	public abstract void hurtCharacter (GameCharacter character);
	
	public abstract boolean successfulDefense ();
	
	
	public String sayName() {
	    return ""; 
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
}

