public class Verwaltung {

	private List<Spiel> alleSpiele = new List<Spiel>();

	public void testData() {
		Spiel s0 = new Spiel("CSGO");
		s0.addTeam(new Team(2, "Kings"));
		s0.addTeam(new Team(2, "Queens"));
		s0.getTeamList().toFirst();
		s0.getTeamList().getContent().addMember(new Spieler("Milan", 2006, 1));
		s0.getTeamList().getContent().addMember(new Spieler("Justus", 2006, 2));
		s0.getTeamList().next();
		s0.getTeamList().getContent().addMember(new Spieler("Lisa", 2006, 3));
		s0.getTeamList().getContent().addMember(new Spieler("Lena", 2006, 4));
		alleSpiele.append(s0);
	}

	public String ligaStand() { // 0
		String ergebnis;
	}

	public List<Spiel> getSpieleListe() {
		return alleSpiele;
	}

	public void addTeam(Team pTeam) { // 2

	}

	public void addPlayer(Spieler pSpieler) { // 3

	}

	public String getPlayers() { // 5

	}

	public void addGame() { // 1

	}

	public String getTeams() { // 4

	}

	public String input(String pEingabe) {

		switch (pEingabe) {

		case "0":
			return "ok";
		case "1":
			
		case "2":
		case "3":
		case "4":
		case "5":
		case "6":
		default:
			return "default error";
		}
	}
}
