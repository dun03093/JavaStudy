package HAJavaStudyHW02_2;

public class Character_NPC extends Character implements Attack {
	
	public int damage;
	public String union;

	public Character_NPC(String chName) {
		super(chName);
	}

	public void WarCry() {
		this.Cry("For the " + this.union + "!!!");
	}

	@Override
	public void Attack(Character attackCharcter) {

	}
}