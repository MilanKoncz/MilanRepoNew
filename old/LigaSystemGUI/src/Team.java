
public class Team {

	private int wins = 0;
	private String teamname;
	private int id;
	private int idCounter = 1;
	private List<Spieler> member = new List<Spieler>();

	public Team(String pTeamname, int pID) {
		teamname = pTeamname;
		id = pID;
	}

	public int getID() {
		return id;
	}

	public void addWin() {
		wins++;
	}

	public int getWins() {
		return wins;
	}

	public String getTeamname() {
		return teamname;
	}

	public void addMember(Spieler pSpieler) {
		idCounter++;
		member.append(pSpieler);
	}

	public void removeMember(Spieler pSpieler) {
		int id = pSpieler.getID();
		member.toFirst();
		while (member.hasAccess()) {
			if (id == member.getContent().getID()) {
				member.remove();
			} else {
				member.next();
			}
		}
	}

	public String getPlayerInfo() {
		String result = "";
		member.toFirst();
		while (member.hasAccess()) {
			result = result + (member.getContent().getName()) + ", ";
			member.next();
		}
		return result;
	}

	public List<Spieler> getPlayerList() {
		return member;
	}

	public int getidCounter() {
		return idCounter;
	}
}