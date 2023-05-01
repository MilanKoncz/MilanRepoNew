
public class Match {

	private int matchID;
	private Team team0;
	private Team team1;
	
	public Match(int pID, Team pT0, Team pT1) {
		matchID = pID;
		team0 = pT0;
		team1 = pT1;
	}

	public Team getTeam0() {
		return team0;
	}
	
	public Team getTeam1() {
		return team1;
	}
	
	public String getTeamNames() {
		return (team0.getTeamname() + ", " + team1.getTeamname());
	}
	
	public int getMatchID() {
		return matchID;
	}

	public String getTeamIDs() {
		return (String.valueOf(team0.getID()) + ", " + String.valueOf(team1.getID()));
	}
}
