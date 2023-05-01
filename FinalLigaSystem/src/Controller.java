import java.awt.EventQueue;

public class Controller{

	private Verwaltung vw;
	@SuppressWarnings("unused")
	private MainGUI mainGUI;
	@SuppressWarnings("unused")
	private NewGameGUI newGameGUI;
	@SuppressWarnings("unused")
	private NewTeamGUI newTeamGUI;
	@SuppressWarnings("unused")
	private NewPlayerGUI newPlayerGUI;
	@SuppressWarnings("unused")
	private MatchmakingGUI getMatchmakingGUI;
	@SuppressWarnings("unused")
	private SearchTeamGUI getTeamGUI;
	private Controller controller = this;

	public Controller(Verwaltung pVW) {
		vw = pVW;
	}

	public void startMainGUI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainGUI = new MainGUI(controller);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void startAddGameGUI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newGameGUI = new NewGameGUI(controller, mainGUI);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void startAddTeamGUI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newTeamGUI = new NewTeamGUI(controller, mainGUI);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void startAddPlayerGUI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newPlayerGUI = new NewPlayerGUI(controller, mainGUI);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void startMatchmakingGUI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					getMatchmakingGUI = new MatchmakingGUI(controller);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void startGetTeamGUI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					getTeamGUI = new SearchTeamGUI(controller);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public List<Spiel> allGames() {
		return vw.getSpieleListe();
	}
	
	public List<Spieler> allPlayers(){
		return vw.allPlayers();
	}

	public List<Team> ligaStand(int pGameID) {
		return vw.ligaStand(pGameID);
	}

	public List<Team> listTeams(int pGameID) {
		return vw.listTeams(pGameID);
	}

	public void addPlayer(String pName, int pJahr, int pGameID, int pTeamID) {
		vw.addPlayer(pName, pJahr, pGameID, pTeamID);
	}

	public void addGame(String pTyp) {
		vw.addGame(pTyp);
	}

	public void addTeam(String pName, int pGameID) {
		vw.addTeam(pName, pGameID);
	}

	public void testData() {
		vw.testData();
	}

	public Spiel findActiveGame(int pGameID) {
		return vw.findActiveGame(pGameID);
	}

	public Team findActiveTeam(Spiel pGame, int pTeamID) {
		return vw.findActiveTeam(pGame, pTeamID);
	}

	public void addWin(int pGameID, int pTeamID) {
		vw.addWin(pGameID, pTeamID);
	}
	
	public void clearData() {
		vw.clearData();
	}
	
	public void delGame(int pGameID) {
		vw.delGame(pGameID);
	}
	
	public void delTeam(int pGameID, int pTeamID) {
		vw.delTeam(pGameID, pTeamID);
	}
	
	public void delPlayer(int pGameID, int pTeamID, int pPlayerID) {
		vw.delPlayer(pGameID, pTeamID, pPlayerID);
	}
	
	public List<Match> listShuffle(List<Team> pList, Spiel pSpiel) {
		return vw.listShuffle(pList, pSpiel);
	}
	
	public List<Spiel> createGameListCopy(List<Spiel> pList) {
		return vw.createGameListCopy(pList);
	}

	public List<Team> createTeamListCopy(List<Team> pList) {
		return vw.createTeamListCopy(pList);
	}

}
