package HAJavaStudyHW02_1;

public class Character_NPC extends Character implements Attack {

	public int damage;
	String union;

	public Character_NPC(String chName) {
		super(chName);
	}

	public void WarCry() {
		this.Cry("For the " + this.union + "!!!");
	}
}