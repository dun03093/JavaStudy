package HAJavaStudyHW02_1;

public class Character_PC extends Character implements Attack {

	public int damage;
	public String union;

	protected Character_PC(String chName) {
		super(chName);
	}

	@Override
	public void WarCry() {
		this.Cry("For the " + this.union + "!!!");
	}
}