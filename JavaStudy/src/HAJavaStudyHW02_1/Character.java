package HAJavaStudyHW02_1;

public abstract class Character {
	protected String name, tribe;
	protected int level, hpMax, hpNow, mpMax, mpNow;

	protected Character(String chName) {
		this.name = chName;
	}

	protected void Talk(String talkStr) {
		System.out.println("[" + name + "]: " + talkStr);
	}

	protected void Cry(String cryStr) {
		System.out.println("<[" + name + "]: " + cryStr + ">");
	}
}