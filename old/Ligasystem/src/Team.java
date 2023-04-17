
public class Team {

	private int groeße = 0;
	private int max;
	private String teamname;
	private List<Spieler> member = new List<Spieler>();
	
	public Team(int pMax, String pTeamname) {
		max = pMax;
		teamname = pTeamname;
	}
	
	public String getTeamname() {
		return teamname;
	}
	
	public void addMember(Spieler pSpieler) {
		if(groeße != max) {
		member.append(pSpieler);
		groeße++;
		}
		else {
			System.out.println("Team ist bereits voll!");
		}
	}
	
	public void removeMember(Spieler pSpieler) {
		int id = pSpieler.getID();
		member.toFirst();
		while(member.hasAccess()) {
			if(id == member.getContent().getID()) {
				member.remove();
			}else {
				member.next();
			}
		}
	}
	
	public String getPlayers() {
		String result = "";
		member.toFirst();
		while(member.hasAccess()) {
			result = result + (member.getContent().getName());
			member.next();
		}
		return result;
	}
	
	public List<Spieler> getPlayerList(){
		return member;
	}
}
