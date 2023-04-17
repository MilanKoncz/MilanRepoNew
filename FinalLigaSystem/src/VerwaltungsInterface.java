
public interface VerwaltungsInterface {

	void testData();

	Spiel findActiveGame(int pGameID);

	Team findActiveTeam(Spiel pGame, int pTeamID);

	List<Spiel> createGameListCopy(List<Spiel> pList);

	List<Team> createTeamListCopy(List<Team> pList);

	String[][] listShuffle(List<Team> pList);

	List<Team> ligaStand(int pSpielID);

	List<Spiel> getSpieleListe();

	List<Spieler> allPlayers();

	void addGame(String pTyp);

	void addTeam(String pName, int pGameID);

	void addPlayer(String pName, int pJahr, int pGameID, int pTeamID);

	List<Team> listTeams(int pGameID);

	void addWin(int pGameID, int pTeamID);

}