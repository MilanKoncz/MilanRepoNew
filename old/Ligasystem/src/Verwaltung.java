public class Verwaltung implements guiInterface {

	private List<Spiel> alleSpiele = new List<Spiel>();

	public List<Spiel> getSpiele() {
		return alleSpiele;
	}

	public void addTeam(Team pTeam) {
		alleSpiele.getContent().addTeam(pTeam);
	}

	public void addPlayer(Spieler pSpieler) {
		alleSpiele.getContent().getTeamList().getContent().addMember(pSpieler);
	}

	/*
	 * public String getPlayer() {
	 * 
	 * }
	 * 
	 * public String getTeam() {
	 * 
	 * }
	 */

	public String input(String pEingabe) {

		switch (pEingabe) {
		case "add_game":
			return "Spiel wurde hinzugefügt!";
		case "add_team":
			return "Team wurde hinzugefügt!";
		case "Spieler wurde hinzugefügt!":
			return "pl";
		case "teamlist":
			return alleSpiele.getContent().getTeams();
		case "playerlist":
			return alleSpiele.getContent().getTeamList().getContent().getPlayers();
		default:
			return "Error";
		}
	}
}
