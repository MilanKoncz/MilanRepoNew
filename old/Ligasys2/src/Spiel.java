
public class Spiel {
	
	private String typ;
	private List<Team> alleTeams = new List<Team>();
	
	public Spiel(String pTyp) {
		typ = pTyp;
	}
	
	public void addTeam(Team pTeam) {
		alleTeams.append(pTeam);
	}
	
	public List<Team> getTeamList(){
		return alleTeams;
	}
	
	public String getTeams() {
		String result = "";
		alleTeams.toFirst();
		while(alleTeams.hasAccess()) {
			result = result + (alleTeams.getContent().getTeamname());
			alleTeams.next();
		}
		return result;
	}
	
	public String getType() {
		return typ;
	}
	
}
