
public class Spieler {
	
	private String name;
	private int birthYear;
	private int id;
	
	public Spieler(String pName, int pBirthYear, int pId) {
		name = pName;
		birthYear = pBirthYear;
		id = pId;
	}
	
	public String getName() {
		return name;
	}
	
	public int getBirthYear() {
		return birthYear;
	}
	
	public int getID() {
		return id;
	}
}
