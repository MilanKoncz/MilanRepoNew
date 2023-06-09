
public class Spiel {
	
	private String typ;
	private int id;
	private int idCounter = 1;
	private int matchIDCounter = 1;
	private boolean matchOrder = false;
	
	private List<Team> alleTeams = new List<Team>();
	private List<Match> matches = new List<Match>();
	
	public Spiel(String pTyp, int pID) {
		typ = pTyp;
		id = pID;
	}
	
	public void addTeam(Team pTeam) {
		idCounter++;
		alleTeams.append(pTeam);
	}
	
	public void addMatch(Match pMatch) {
		matchIDCounter++;
		matches.append(pMatch);
	}
	
	public void setMatches(List<Match> pMatches) {
		matches = pMatches;
	}
	
	public List<Match> getMatchList() {
		return matches;
	}
	
	public List<Team> getTeamList(){
		return alleTeams;
	}
	
	public String getTeams() {
		String result = "";
		alleTeams.toFirst();
		while(alleTeams.hasAccess()) {
			result = result + (alleTeams.getContent().getTeamname()) + ", ";
			alleTeams.next();
		}
		return result;
	}
	
	public String getType() {
		return typ;
	}
	
	public int getID() {
		return id;
	}
	
	public int getidCounter() {
		return idCounter;
	}

	public boolean getMatchOrder() {
		return matchOrder;
	}

	public void setMatchOrder(boolean pMatchOrder) {
		matchOrder = pMatchOrder;
	}
	
}
