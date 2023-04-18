import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.JScrollPane;

public class MainGUI {
	JFrame frmLigasystemV;
	private Controller controller;
	private JTable tableLiga;
	private JTable tableTeams;
	private JTable tablePlayers;
	private JTable tableGames;
	private JButton bTest;
	private JButton bLiga;
	private JButton bAddTeam;
	private JButton bAddPlayer;
	private JButton bDelPlayer;
	private JButton bDelTeam;
	private JButton bDelGame;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 * 
	 * @throws UnsupportedLookAndFeelException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	public MainGUI(Controller pController) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		controller = pController;
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("serial")
	private void initialize() {
		frmLigasystemV = new JFrame();
		frmLigasystemV.setTitle("LigaSystem V3");
		frmLigasystemV.setResizable(false);
		frmLigasystemV.setBounds(100, 100, 1159, 509);
		frmLigasystemV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLigasystemV.getContentPane().setLayout(null);
		frmLigasystemV.setVisible(true);

		JLabel lblNewLabel = new JLabel("Willkommen zum Ligasystem!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel.setBounds(495, 11, 277, 32);
		frmLigasystemV.getContentPane().add(lblNewLabel);

		bTest = new JButton("Erzeuge Testdaten");
		bTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				controller.testData();
				updateGames();
				bTest.setEnabled(false);

			}
		});
		bTest.setBounds(1005, 438, 128, 23);
		frmLigasystemV.getContentPane().add(bTest);

		bAddPlayer = new JButton("Spieler hinzufuegen");
		bAddPlayer.setEnabled(false);
		bAddPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				controller.startAddPlayerGUI();
			}
		});
		bAddPlayer.setBounds(872, 282, 266, 23);
		frmLigasystemV.getContentPane().add(bAddPlayer);

		bAddTeam = new JButton("Team hinzufuegen");
		bAddTeam.setEnabled(false);
		bAddTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				controller.startAddTeamGUI();
			}
		});
		bAddTeam.setBounds(596, 282, 266, 23);
		frmLigasystemV.getContentPane().add(bAddTeam);

		JButton bSpiel = new JButton("Liga hinzufuegen");
		bSpiel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				controller.startAddGameGUI();
			}
		});
		bSpiel.setBounds(320, 282, 266, 23);
		frmLigasystemV.getContentPane().add(bSpiel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 52, 288, 212);
		frmLigasystemV.getContentPane().add(scrollPane);

		tableLiga = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tableLiga.getTableHeader().setReorderingAllowed(false);
		tableLiga.getTableHeader().setResizingAllowed(false);
		scrollPane.setViewportView(tableLiga);
		tableLiga.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Liga-Rank", "Team ID", "Wins" }));

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(596, 52, 266, 212);
		frmLigasystemV.getContentPane().add(scrollPane_1);

		tableTeams = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tableTeams.getTableHeader().setReorderingAllowed(false);
		tableTeams.getTableHeader().setResizingAllowed(false);
		tableTeams
				.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Team ID", "Team Name", "Members" }));
		scrollPane_1.setViewportView(tableTeams);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(872, 52, 266, 212);
		frmLigasystemV.getContentPane().add(scrollPane_2);

		tablePlayers = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tablePlayers.getTableHeader().setReorderingAllowed(false);
		tablePlayers.getTableHeader().setResizingAllowed(false);
		tablePlayers
				.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Player ID", "Name", "Birthyear" }));
		scrollPane_2.setViewportView(tablePlayers);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(320, 52, 266, 212);
		frmLigasystemV.getContentPane().add(scrollPane_3);

		tableGames = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tableGames.getTableHeader().setReorderingAllowed(false);
		tableGames.getTableHeader().setResizingAllowed(false);
		scrollPane_3.setViewportView(tableGames);
		tableGames.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Game ID", "Game Type" }));

		bLiga = new JButton("Ligastand ausgeben");
		bLiga.setEnabled(false);
		bLiga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int rank = 1;
				int gameID = (Integer) tableGames.getValueAt(tableGames.getSelectedRow(), 0);
				Spiel activeGame = controller.findActiveGame(gameID);
				List<Team> sorted = controller.ligaStand(activeGame.getID());

				sorted.toFirst();
				DefaultTableModel model = (DefaultTableModel) tableLiga.getModel();
				model.setRowCount(0);
				while (sorted.hasAccess()) {
					model.addRow(new Object[] { rank, sorted.getContent().getID(), sorted.getContent().getWins() });
					rank++;
					sorted.next();
				}
			}
		});
		bLiga.setBounds(10, 282, 288, 23);
		frmLigasystemV.getContentPane().add(bLiga);

		JButton bMasterPlayers = new JButton("Alle Spieler ausgeben");
		bMasterPlayers.setEnabled(false);
		bMasterPlayers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				List<Spieler> allPlayers = controller.allPlayers();

				allPlayers.toFirst();
				DefaultTableModel model = (DefaultTableModel) tablePlayers.getModel();
				model.setRowCount(0);
				while (allPlayers.hasAccess()) {
					model.addRow(new Object[] { allPlayers.getContent().getID(), allPlayers.getContent().getName(),
							allPlayers.getContent().getBirthYear() });
					allPlayers.next();
				}
			}
		});
		bMasterPlayers.setBounds(10, 316, 288, 23);
		frmLigasystemV.getContentPane().add(bMasterPlayers);

		JButton bSave = new JButton("Save Config");
		bSave.setBounds(1005, 404, 128, 23);
		frmLigasystemV.getContentPane().add(bSave);

		JButton bLoad = new JButton("Load Config");
		bLoad.setBounds(1005, 372, 128, 23);
		frmLigasystemV.getContentPane().add(bLoad);

		JButton bMatchmaking = new JButton("Start Matchmaking");
		bMatchmaking.setFont(new Font("Toledo", Font.ITALIC, 18));
		bMatchmaking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				controller.startMatchmakingGUI();
			}
		});
		bMatchmaking.setBounds(480, 372, 203, 71);
		frmLigasystemV.getContentPane().add(bMatchmaking);

		JButton bClear = new JButton("Clear All Data");
		bClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.clearData();
				updateGames();
				updateTeams();
				updatePlayers();
				DefaultTableModel model = (DefaultTableModel) tableTeams.getModel();
				model.setRowCount(0);
				DefaultTableModel model2 = (DefaultTableModel) tableLiga.getModel();
				model2.setRowCount(0);
				bAddTeam.setEnabled(false);
				bLiga.setEnabled(false);
				bAddPlayer.setEnabled(false);
				bTest.setEnabled(true);
				bDelGame.setEnabled(false);
				bDelTeam.setEnabled(false);
				bDelPlayer.setEnabled(false);
			}
		});
		bClear.setBounds(10, 438, 128, 23);
		frmLigasystemV.getContentPane().add(bClear);

		bDelGame = new JButton("Liga loeschen");
		bDelGame.setEnabled(false);
		bDelGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int gameID = (Integer) tableGames.getValueAt(tableGames.getSelectedRow(), 0);
				controller.delGame(gameID);
				updateGames();
				updateTeams();
				updatePlayers();
				DefaultTableModel model = (DefaultTableModel) tableTeams.getModel();
				model.setRowCount(0);
				DefaultTableModel model2 = (DefaultTableModel) tablePlayers.getModel();
				model2.setRowCount(0);
				bDelGame.setEnabled(false);
				bDelTeam.setEnabled(false);
				bDelPlayer.setEnabled(false);
				bAddTeam.setEnabled(false);
			}
		});
		bDelGame.setBounds(320, 316, 266, 23);
		frmLigasystemV.getContentPane().add(bDelGame);

		bDelTeam = new JButton("Team loeschen");
		bDelTeam.setEnabled(false);
		bDelTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int gameID = (Integer) tableGames.getValueAt(tableGames.getSelectedRow(), 0);
				int teamID = (Integer) tableTeams.getValueAt(tableTeams.getSelectedRow(), 0);
				controller.delTeam(gameID, teamID);
				updateTeams();
				updatePlayers();
				DefaultTableModel model2 = (DefaultTableModel) tablePlayers.getModel();
				model2.setRowCount(0);
				bDelTeam.setEnabled(false);
				bDelPlayer.setEnabled(false);
				bAddPlayer.setEnabled(false);
			}
		});
		bDelTeam.setBounds(596, 316, 266, 23);
		frmLigasystemV.getContentPane().add(bDelTeam);

		bDelPlayer = new JButton("Spieler Loeschen");
		bDelPlayer.setEnabled(false);
		bDelPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int gameID = (Integer) tableGames.getValueAt(tableGames.getSelectedRow(), 0);
				int teamID = (Integer) tableTeams.getValueAt(tableTeams.getSelectedRow(), 0);
				int playerID = (Integer) tablePlayers.getValueAt(tablePlayers.getSelectedRow(), 0);
				controller.delPlayer(gameID, teamID, playerID);
				updatePlayers();

				bDelPlayer.setEnabled(false);
			}
		});
		bDelPlayer.setBounds(872, 316, 266, 23);
		frmLigasystemV.getContentPane().add(bDelPlayer);

		ListSelectionModel listSelectionModel0 = (ListSelectionModel) tableGames.getSelectionModel();
		listSelectionModel0.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent event) {
				updateTeams();
				DefaultTableModel model = (DefaultTableModel) tablePlayers.getModel();
				model.setRowCount(0); // Game Table Listener
				bAddTeam.setEnabled(true);
				bLiga.setEnabled(true);
				bAddPlayer.setEnabled(false);
				bDelGame.setEnabled(true);
				bDelTeam.setEnabled(false);
				bDelPlayer.setEnabled(false);
			}
		});

		ListSelectionModel listSelectionModel1 = (ListSelectionModel) tableTeams.getSelectionModel();
		listSelectionModel1.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent event) {
				updatePlayers();
				bAddPlayer.setEnabled(true); // Team Table Listener
				bDelTeam.setEnabled(true);
				bDelPlayer.setEnabled(false);
			}
		});

		ListSelectionModel listSelectionModel2 = (ListSelectionModel) tablePlayers.getSelectionModel();
		listSelectionModel2.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent event) {
				bDelPlayer.setEnabled(true); // Player Table Listener
			}
		});

	}

	public void updateGames() {
		List<Spiel> allGames = controller.allGames();
		allGames.toFirst();
		DefaultTableModel model = (DefaultTableModel) tableGames.getModel();
		model.setRowCount(0);
		while (allGames.hasAccess()) {
			model.addRow(new Object[] { allGames.getContent().getID(), allGames.getContent().getType() });
			allGames.next();
		}
	}

	public void updateTeams() {
		if (!tableGames.getSelectionModel().isSelectionEmpty()) {
			int gameID = (Integer) tableGames.getValueAt(tableGames.getSelectedRow(), 0);
			Spiel activeGame = controller.findActiveGame(gameID);
			List<Team> allTeams = activeGame.getTeamList();

			allTeams.toFirst();
			DefaultTableModel model = (DefaultTableModel) tableTeams.getModel();
			model.setRowCount(0);
			while (allTeams.hasAccess()) {
				model.addRow(new Object[] { allTeams.getContent().getID(), allTeams.getContent().getTeamname(),
						allTeams.getContent().getPlayerInfo() });
				allTeams.next();
			}
		}
	}

	public void updatePlayers() {
		if (!tableTeams.getSelectionModel().isSelectionEmpty() && !tableGames.getSelectionModel().isSelectionEmpty()) {
			int teamID = (Integer) tableTeams.getValueAt(tableTeams.getSelectedRow(), 0);
			int gameID = (Integer) tableGames.getValueAt(tableGames.getSelectedRow(), 0);
			Spiel activeGame = controller.findActiveGame(gameID);
			Team activeTeam = controller.findActiveTeam(activeGame, teamID);
			List<Spieler> allPlayers = activeTeam.getPlayerList();

			allPlayers.toFirst();
			DefaultTableModel model = (DefaultTableModel) tablePlayers.getModel();
			model.setRowCount(0);
			while (allPlayers.hasAccess()) {
				model.addRow(new Object[] { allPlayers.getContent().getID(), allPlayers.getContent().getName(),
						allPlayers.getContent().getBirthYear() });
				allPlayers.next();
			}
		}
	}

	public JTable getGameTable() {
		return tableGames;
	}

	public JTable getTeamTable() {
		return tableTeams;
	}

	public JTable getPlayerTable() {
		return tablePlayers;
	}
	
	public JTable getLigaTable() {
		return tableLiga;
	}

	public JButton getBAddTeam() {
		return bAddTeam;
	}

	public JButton getBAddPlayer() {
		return bAddPlayer;
	}

	public JButton getBDelGame() {
		return bDelGame;
	}

	public JButton getBDelTeam() {
		return bDelTeam;
	}

	public JButton getBDelPlayer() {
		return bDelPlayer;
	}
	
	public JButton getBLiga() {
		return bLiga;
	}
}
