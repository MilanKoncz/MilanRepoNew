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

	private JTextArea textArea;
	JFrame frmLigasystemV;
	private JTextField tfInput;
	private Controller controller;
	private JTable table0;
	private JTable table1;
	private JTable table2;
	private JTable table3;
	private JButton bAllTeams;
	private JButton bAllPlayers;
	private JButton bTest;
	private JButton bLiga;
	
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
		frmLigasystemV.setBounds(100, 100, 1200, 675);
		frmLigasystemV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLigasystemV.getContentPane().setLayout(null);
		frmLigasystemV.setVisible(true);

		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(489, 82, 333, 20);
		frmLigasystemV.getContentPane().add(textArea);

		JLabel lblNewLabel = new JLabel("Willkommen zum Ligasystem!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel.setBounds(26, 23, 277, 32);
		frmLigasystemV.getContentPane().add(lblNewLabel);

		JLabel lblAusgabefeld = new JLabel("Ausgabe-Feld:");
		lblAusgabefeld.setBounds(489, 52, 277, 32);
		frmLigasystemV.getContentPane().add(lblAusgabefeld);

		JLabel lblEingabe = new JLabel("Eingabe:");
		lblEingabe.setBounds(26, 52, 277, 32);
		frmLigasystemV.getContentPane().add(lblEingabe);

		tfInput = new JTextField();
		tfInput.setBounds(26, 84, 288, 20);
		frmLigasystemV.getContentPane().add(tfInput);
		tfInput.setColumns(10);

		JButton bAllGames = new JButton("Alle Spiele ausgeben");
		bAllGames.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Spiel> allGames = controller.allGames();
				allGames.toFirst();
				DefaultTableModel model = (DefaultTableModel) table3.getModel();
				model.setRowCount(0);
				while (allGames.hasAccess()) {
					model.addRow(new Object[] { allGames.getContent().getID(), allGames.getContent().getType() });
					allGames.next();
				}
				bAllTeams.setEnabled(false);
				bAllPlayers.setEnabled(false);
			}
		});
		bAllGames.setBounds(578, 495, 266, 23);
		frmLigasystemV.getContentPane().add(bAllGames);

		bTest = new JButton("Erzeuge Testdaten");
		bTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				controller.testData();
				textArea.setText("Test-Daten wurden erzeugt.");
				bTest.setEnabled(false);

			}
		});
		bTest.setBounds(26, 563, 266, 23);
		frmLigasystemV.getContentPane().add(bTest);

		bAllTeams = new JButton("Teams ausgeben");
		bAllTeams.setEnabled(false);
		bAllTeams.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int gameID = (Integer) table3.getValueAt(table3.getSelectedRow(), 0);
				Spiel activeGame = controller.findActiveGame(gameID);
				List<Team> allTeams = activeGame.getTeamList();

				allTeams.toFirst();
				DefaultTableModel model = (DefaultTableModel) table1.getModel();
				model.setRowCount(0);
				while (allTeams.hasAccess()) {
					model.addRow(new Object[] { allTeams.getContent().getID(), allTeams.getContent().getTeamname(),
							allTeams.getContent().getPlayerInfo() });
					allTeams.next();
				}
				bAllPlayers.setEnabled(false);
			}
		});

		bAllTeams.setBounds(578, 529, 266, 23);
		frmLigasystemV.getContentPane().add(bAllTeams);

		bAllPlayers = new JButton("Spieler ausgeben");
		bAllPlayers.setEnabled(false);
		bAllPlayers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int teamID = (Integer) table1.getValueAt(table1.getSelectedRow(), 0);
				int gameID = (Integer) table3.getValueAt(table3.getSelectedRow(), 0);
				Spiel activeGame = controller.findActiveGame(gameID);
				Team activeTeam = controller.findActiveTeam(activeGame, teamID);
				List<Spieler> allPlayers = activeTeam.getPlayerList();

				allPlayers.toFirst();
				DefaultTableModel model = (DefaultTableModel) table2.getModel();
				model.setRowCount(0);
				while (allPlayers.hasAccess()) {
					model.addRow(new Object[] { allPlayers.getContent().getID(), allPlayers.getContent().getName(),
							allPlayers.getContent().getBirthYear() });
					allPlayers.next();
				}

			}
		});
		bAllPlayers.setBounds(578, 563, 266, 23);
		frmLigasystemV.getContentPane().add(bAllPlayers);

		JButton bAddPlayer = new JButton("Spieler hinzufuegen");
		bAddPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				controller.startAddPlayerGUI();
			}
		});
		bAddPlayer.setBounds(302, 563, 266, 23);
		frmLigasystemV.getContentPane().add(bAddPlayer);

		JButton bAddTeam = new JButton("Team hinzufuegen");
		bAddTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				controller.startAddTeamGUI();
			}
		});
		bAddTeam.setBounds(302, 529, 266, 23);
		frmLigasystemV.getContentPane().add(bAddTeam);

		JButton bSpiel = new JButton("Turnier/Spiel hinzufuegen");
		bSpiel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				controller.startAddGameGUI();
			}
		});
		bSpiel.setBounds(302, 495, 266, 23);
		frmLigasystemV.getContentPane().add(bSpiel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 243, 288, 201);
		frmLigasystemV.getContentPane().add(scrollPane);

		table0 = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table0.getTableHeader().setReorderingAllowed(false);
		table0.getTableHeader().setResizingAllowed(false);
		scrollPane.setViewportView(table0);
		table0.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Team ID", "Wins", "Liga-Rank"
			}
		));

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(343, 243, 255, 201);
		frmLigasystemV.getContentPane().add(scrollPane_1);

		table1 = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table1.getTableHeader().setReorderingAllowed(false);
		table1.getTableHeader().setResizingAllowed(false);
		table1.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Team ID", "Team Name", "Members" }));
		scrollPane_1.setViewportView(table1);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(621, 243, 223, 201);
		frmLigasystemV.getContentPane().add(scrollPane_2);

		table2 = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table2.getTableHeader().setReorderingAllowed(false);
		table2.getTableHeader().setResizingAllowed(false);
		table2.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Player ID", "Name", "Birthyear" }));
		scrollPane_2.setViewportView(table2);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(893, 99, 255, 487);
		frmLigasystemV.getContentPane().add(scrollPane_3);

		table3 = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table3.getTableHeader().setReorderingAllowed(false);
		table3.getTableHeader().setResizingAllowed(false);
		scrollPane_3.setViewportView(table3);
		table3.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Game ID", "Game Type" }));

		bLiga = new JButton("Ligastand ausgeben");
		bLiga.setEnabled(false);
		bLiga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int rank = 1;
				int gameID = (Integer) table3.getValueAt(table3.getSelectedRow(), 0);
				Spiel activeGame = controller.findActiveGame(gameID);
				List<Team> sorted = controller.ligaStand(activeGame.getID());
				
				sorted.toFirst();
				DefaultTableModel model = (DefaultTableModel) table0.getModel();
				model.setRowCount(0);
				while (sorted.hasAccess()) {
					model.addRow(new Object[] { sorted.getContent().getID(), sorted.getContent().getWins(),rank });
					rank++;
					sorted.next();
				}
				bLiga.setEnabled(false);
			}
		});
		bLiga.setBounds(26, 495, 266, 23);
		frmLigasystemV.getContentPane().add(bLiga);

		JButton bMasterPlayers = new JButton("Alle Spieler ausgeben");
		bMasterPlayers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				List<Spieler> allPlayers = controller.allPlayers();

				allPlayers.toFirst();
				DefaultTableModel model = (DefaultTableModel) table2.getModel();
				model.setRowCount(0);
				while (allPlayers.hasAccess()) {
					model.addRow(new Object[] { allPlayers.getContent().getID(), allPlayers.getContent().getName(),
							allPlayers.getContent().getBirthYear() });
					allPlayers.next();
				}
			}
		});
		bMasterPlayers.setBounds(26, 529, 266, 23);
		frmLigasystemV.getContentPane().add(bMasterPlayers);
		
		JButton bSave = new JButton("Save Config");
		bSave.setBounds(26, 126, 288, 23);
		frmLigasystemV.getContentPane().add(bSave);
		
		JButton bLoad = new JButton("Load Config");
		bLoad.setBounds(26, 160, 288, 23);
		frmLigasystemV.getContentPane().add(bLoad);
		
		JButton bMatchmaking = new JButton("Start Matchmaking");
		bMatchmaking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controller.startMatchmakingGUI();
			}
		});
		bMatchmaking.setBounds(415, 131, 346, 80);
		frmLigasystemV.getContentPane().add(bMatchmaking);

		ListSelectionModel listSelectionModel0 = (ListSelectionModel) table3.getSelectionModel();
		listSelectionModel0.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent event) {
				bAllTeams.setEnabled(true);
				bLiga.setEnabled(true);
			}
		});

		ListSelectionModel listSelectionModel1 = (ListSelectionModel) table1.getSelectionModel();
		listSelectionModel1.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent event) {
				bAllPlayers.setEnabled(true);
			}
		});

		
	}
}
