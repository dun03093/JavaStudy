package HAJavaStudyHW02_2;

public class Character_PC extends Character implements Attack {

	public int damage;
	String union;

	protected Character_PC(String chName) {
		super(chName);
	}

	@Override
	public void Attack(Character attackCharcter) {

	}
	
	@Override
	public void WarCry() {
		this.Cry("For the " + this.union + "!!!");
	}
}