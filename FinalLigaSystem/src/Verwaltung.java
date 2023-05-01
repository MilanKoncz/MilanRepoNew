import java.util.Random;

public class Verwaltung {

	private List<Spiel> alleSpiele = new List<Spiel>();
	private int idCounter = 0;

	public void testData() {
		Spiel s0 = new Spiel("CSGO", 1);
		s0.addTeam(new Team("Kings", 1));
		s0.addTeam(new Team("Queens", 2));
		s0.getTeamList().toFirst();
		s0.getTeamList().getContent().addMember(new Spieler("Milan", 2006, 1));
		s0.getTeamList().getContent().addMember(new Spieler("Justus", 2006, 2));
		s0.getTeamList().next();
		s0.getTeamList().getContent().addMember(new Spieler("Lisa", 2006, 3));
		s0.getTeamList().getContent().addMember(new Spieler("Lena", 2006, 4));
		Spiel s1 = new Spiel("Fortnite", 2);
		s1.addTeam(new Team("McDonads", 1));
		s1.addTeam(new Team("BoergerKing", 2));
		s1.getTeamList().toFirst();
		s1.getTeamList().getContent().addMember(new Spieler("Robin", 2006, 1));
		s1.getTeamList().getContent().addMember(new Spieler("Jonas", 2006, 2));
		s1.getTeamList().next();
		s1.getTeamList().getContent().addMember(new Spieler("Felix", 2006, 3));
		s1.getTeamList().getContent().addMember(new Spieler("Richard", 2006, 4));
		alleSpiele.append(s0);
		alleSpiele.append(s1);
	}

	public Spiel findActiveGame(int pGameID) {

		boolean gefunden = false;
		Spiel activeGame = null;

		alleSpiele.toFirst();
		while (alleSpiele.hasAccess() && !gefunden) {
			if (alleSpiele.getContent().getID() == pGameID) {
				activeGame = alleSpiele.getContent();
				gefunden = true;
			} else {
				alleSpiele.next();
			}
		}
		return activeGame;
	}

	public Team findActiveTeam(Spiel pGame, int pTeamID) {

		boolean gefunden = false;
		Team activeTeam = null;
		List<Team> alleTeams = pGame.getTeamList();

		alleTeams.toFirst();
		while (alleTeams.hasAccess() && !gefunden) {
			if (alleTeams.getContent().getID() == pTeamID) {
				activeTeam = alleTeams.getContent();
				gefunden = true;
			} else {
				alleTeams.next();
			}
		}
		return activeTeam;
	}

	public List<Spiel> createGameListCopy(List<Spiel> pList) {
		List<Spiel> sortiert = new List<Spiel>();
		pList.toFirst();
		while (pList.hasAccess()) {
			sortiert.append(pList.getContent());
			pList.next();
		}
		return sortiert;
	}

	public List<Team> createTeamListCopy(List<Team> pList) {
		List<Team> sortiert = new List<Team>();
		pList.toFirst();
		while (pList.hasAccess()) {
			sortiert.append(pList.getContent());
			pList.next();
		}
		return sortiert;
	}

	public List<Match> listShuffle(List<Team> pList, Spiel pSpiel) {

		int matchIDCounter = 1;
		List<Match> matches = new List<Match>();
		
		// List to Array
		int z = 0;
		pList.toFirst();
		while (pList.hasAccess()) {
			z++;
			pList.next();
		}

		Team[] teams = new Team[z];
		pList.toFirst();
		for (int i = 0; i < teams.length; i++) {
			teams[i] = pList.getContent();
			pList.next();
		}
		
		// Randomize Array
		Random random = new Random();
		for (int i = teams.length - 1; i > 0; i--) {
			int index = random.nextInt(i + 1);
			Team temp = teams[index];
			teams[index] = teams[i];
			teams[i] = temp;
		}

		// Create Matches
		for (int i = 0; i < teams.length; i += 2) {
	        Match match = new Match(matchIDCounter, teams[i], teams[i + 1]);
	        matchIDCounter++;
	        matches.append(match);
	    }
		
		pSpiel.setMatches(matches);
		return matches;

	}

	public List<Team> ligaStand(int pSpielID) {
		Team tmp;
		List<Team> sortiert = new List<Team>();
		Spiel activeGame = findActiveGame(pSpielID);

		if (activeGame != null) {
			List<Team> unsortiert = createTeamListCopy(activeGame.getTeamList());
			while (!unsortiert.isEmpty()) {
				unsortiert.toFirst();
				tmp = unsortiert.getContent();
				while (unsortiert.hasAccess()) {
					if (unsortiert.getContent().getWins() > tmp.getWins()) {
						tmp = unsortiert.getContent();
					}
					unsortiert.next();
				}
				sortiert.append(tmp);
				unsortiert.toFirst();
				while (tmp.getID() != unsortiert.getContent().getID()) {
					unsortiert.next();
				}
				unsortiert.remove();
			}
			return sortiert;
		}
		return null;
	}

	public List<Spiel> getSpieleListe() {
		return alleSpiele;
	}

	public List<Spieler> allPlayers() {

		List<Spieler> allPlayers = new List<Spieler>();

		alleSpiele.toFirst();
		while (alleSpiele.hasAccess()) {
			alleSpiele.getContent().getTeamList().toFirst();
			while (alleSpiele.getContent().getTeamList().hasAccess()) {
				alleSpiele.getContent().getTeamList().getContent().getPlayerList().toFirst();
				while (alleSpiele.getContent().getTeamList().getContent().getPlayerList().hasAccess()) {
					allPlayers.append(alleSpiele.getContent().getTeamList().getContent().getPlayerList().getContent());
					alleSpiele.getContent().getTeamList().getContent().getPlayerList().next();
				}
				alleSpiele.getContent().getTeamList().next();
			}
			alleSpiele.next();
		}

		return allPlayers;
	}

	public void addGame(String pTyp) {
		idCounter++;
		Spiel newGame = new Spiel(pTyp, idCounter);
		alleSpiele.append(newGame);
	}

	public void addTeam(String pName, int pGameID) {

		int id;
		Spiel activeGame = findActiveGame(pGameID);

		if (activeGame != null) {
			id = activeGame.getidCounter();
			activeGame.addTeam(new Team(pName, id));
		}
	}

	public void addPlayer(String pName, int pJahr, int pGameID, int pTeamID) {

		Spiel activeGame = findActiveGame(pGameID);
		Team activeTeam = findActiveTeam(activeGame, pTeamID);
		int playerID = activeTeam.getidCounter();

		activeTeam.addMember(new Spieler(pName, pJahr, playerID));

	}

	public List<Team> listTeams(int pGameID) {

		Spiel activeGame = findActiveGame(pGameID);

		List<Team> alleTeams = activeGame.getTeamList();

		return alleTeams;
	}

	public void addWin(int pGameID, int pTeamID) {
		Team activeTeam = findActiveTeam(findActiveGame(pGameID), pTeamID);
		activeTeam.addWin();
	}

	public void clearData() {
		alleSpiele = new List<Spiel>();

	}

	public void delGame(int pGameID) {
		alleSpiele.toFirst();
		while (alleSpiele.hasAccess()) {
			if (alleSpiele.getContent().getID() == pGameID) {
				alleSpiele.remove();
			} else {
				alleSpiele.next();
			}

		}

	}

	public void delTeam(int pGameID, int pTeamID) {
		Spiel activeGame = findActiveGame(pGameID);
		List<Team> alleTeams = activeGame.getTeamList();
		alleTeams.toFirst();
		while (alleTeams.hasAccess()) {
			if (alleTeams.getContent().getID() == pTeamID) {
				alleTeams.remove();
			} else {
				alleTeams.next();
			}

		}

	}

	public void delPlayer(int pGameID, int pTeamID, int pPlayerID) {
		Spiel activeGame = findActiveGame(pGameID);
		Team activeTeam = findActiveTeam(activeGame, pTeamID);
		List<Spieler> alleSpieler = activeTeam.getPlayerList();
		alleSpieler.toFirst();
		while (alleSpieler.hasAccess()) {
			if (alleSpieler.getContent().getID() == pPlayerID) {
				alleSpieler.remove();
			} else {
				alleSpieler.next();
			}

		}

	}
}
