import java.awt.EventQueue;

public interface ControlInterface {

	public void startMainGUI();
	
	public void startAddGameGUI();
	
	public void startAddTeamGUI();
	
	public void startAddPlayerGUI();
	
	public List<Spiel> allGames();
	
	public List<Spieler> allPlayers();
	
	public List<Team> ligaStand(int pGameID);
	
	public void startGetGameGUI();
	
	public void startGetTeamGUI();
	
	public List<Team> listTeams(int pGameID);
	
	public void addPlayer(String pName, int pJahr, int pGameID, int pTeamID);
	
	public void addGame(String pTyp);
	
	public void addTeam(String pName, int pGameID);
	
	public void testData();
	
	public Spiel findActiveGame(int pGameID);
	
	public Team findActiveTeam(Spiel pGame, int pTeamID);
}
