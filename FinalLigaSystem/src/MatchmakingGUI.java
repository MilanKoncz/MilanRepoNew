import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

public class MatchmakingGUI {

	JFrame matchmaking;
	private Controller controller;
	private JTable tableUpcoming;
	private JComboBox comboBox;
	private JButton bShuffle;
	private List<Match> matches = new List<Match>();
	private JLabel lTeam1;
	private JLabel lTeam2;
	private Team team1;
	private Team team2;
	private JButton bWinner0;
	private JButton bWinner1;
	private JLabel lError;

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
	public MatchmakingGUI(Controller pController) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		controller = pController;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("unchecked")
	private void initialize() {
		matchmaking = new JFrame();
		matchmaking.setResizable(false);
		matchmaking.setTitle("Matchmaking");
		matchmaking.setBounds(100, 100, 805, 783);
		matchmaking.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		matchmaking.getContentPane().setLayout(null);
		matchmaking.setVisible(true);

		JButton bExit = new JButton("Exit");
		bExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				matchmaking.dispose();
			}
		});
		bExit.setBounds(314, 671, 144, 46);
		matchmaking.getContentPane().add(bExit);

		JLabel lblNewLabel = new JLabel("VS.");
		lblNewLabel.setFont(new Font("Year supply of fairy cakes", Font.BOLD, 72));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(314, 48, 144, 137);
		matchmaking.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Select Game:");
		lblNewLabel_1.setBounds(314, 11, 125, 14);
		matchmaking.getContentPane().add(lblNewLabel_1);

		comboBox = new JComboBox();
		comboBox.setBounds(314, 35, 125, 22);
		matchmaking.getContentPane().add(comboBox);

		Spiel s0 = new Spiel(null, 0);
		s0.setMatchOrder(true);
		comboBox.addItem(new ComboItem("<Select Game>", s0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(138, 262, 512, 311);
		matchmaking.getContentPane().add(scrollPane);

		tableUpcoming = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tableUpcoming.getTableHeader().setReorderingAllowed(false);
		tableUpcoming.getTableHeader().setResizingAllowed(false);
		tableUpcoming
				.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Match ID", "Team IDs", "Teams" }));
		scrollPane.setViewportView(tableUpcoming);

		bWinner0 = new JButton("Declare Winner");
		bWinner0.setEnabled(false);
		bWinner0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				team1.addWin();
				bWinner0.setEnabled(false);
				bWinner1.setEnabled(false);
				lTeam1.setText("");
				lTeam2.setText("");

				if (tableUpcoming.getSelectedRow() != -1) {
					ComboItem activeItem = (ComboItem) comboBox.getSelectedItem();
					Spiel activeGame = activeItem.getValue();
					List<Match> matchList = activeGame.getMatchList();
					int matchID = (Integer) tableUpcoming.getValueAt(tableUpcoming.getSelectedRow(), 0);

					matchList.toFirst();
					while (matchList.hasAccess()) {
						if (matchList.getContent().getMatchID() == matchID) {
							matchList.remove();
							;

						}
						matchList.next();
					}

				}

				updateTable();
			}
		});
		bWinner0.setBounds(77, 147, 125, 23);
		matchmaking.getContentPane().add(bWinner0);

		bWinner1 = new JButton("Declare Winner");
		bWinner1.setEnabled(false);
		bWinner1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				team2.addWin();
				bWinner0.setEnabled(false);
				bWinner1.setEnabled(false);
				lTeam1.setText("");
				lTeam2.setText("");

				if (tableUpcoming.getSelectedRow() != -1) {
					ComboItem activeItem = (ComboItem) comboBox.getSelectedItem();
					Spiel activeGame = activeItem.getValue();
					List<Match> matchList = activeGame.getMatchList();
					int matchID = (Integer) tableUpcoming.getValueAt(tableUpcoming.getSelectedRow(), 0);

					matchList.toFirst();
					while (matchList.hasAccess()) {
						if (matchList.getContent().getMatchID() == matchID) {
							matchList.remove();
							;

						}
						matchList.next();
					}

				}

				updateTable();
			}
		});
		bWinner1.setBounds(596, 147, 125, 23);
		matchmaking.getContentPane().add(bWinner1);

		bShuffle = new JButton("Create Matchmaking Order");
		bShuffle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					ComboItem activeItem = (ComboItem) comboBox.getSelectedItem();
					Spiel activeGame = activeItem.getValue();
					List<Team> list = controller
							.createTeamListCopy(((ComboItem) comboBox.getSelectedItem()).getValue().getTeamList());
					matches = controller.listShuffle(list, activeGame);
					activeGame.setMatchOrder(true);
					bShuffle.setEnabled(false);
					updateTable();

				} catch (ArrayIndexOutOfBoundsException el) {
					lError.setText("Nicht genug Teams in der Liga vorhanden!");

				} catch (NotEnoughTeamsException nete) {
					lError.setText("Nicht genug Teams in der Liga vorhanden!");
				}

			}
		});
		bShuffle.setEnabled(false);
		bShuffle.setBounds(298, 584, 179, 23);
		matchmaking.getContentPane().add(bShuffle);

		JLabel label = new JLabel("Next Matches:");
		Font font = label.getFont();
		@SuppressWarnings("rawtypes")
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		label.setFont(font.deriveFont(attributes));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(265, 237, 253, 14);
		matchmaking.getContentPane().add(label);

		JLabel lblNewLabel_2 = new JLabel("Team 1:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_2.setBounds(38, 59, 46, 14);
		matchmaking.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Team 2:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_2_1.setBounds(553, 59, 46, 14);
		matchmaking.getContentPane().add(lblNewLabel_2_1);

		lTeam1 = new JLabel("");
		lTeam1.setHorizontalAlignment(SwingConstants.CENTER);
		lTeam1.setBounds(77, 109, 105, 27);
		matchmaking.getContentPane().add(lTeam1);

		lTeam2 = new JLabel("");
		lTeam2.setHorizontalAlignment(SwingConstants.CENTER);
		lTeam2.setBounds(596, 109, 105, 27);
		matchmaking.getContentPane().add(lTeam2);

		lError = new JLabel("");
		lError.setForeground(new Color(255, 0, 0));
		lError.setHorizontalAlignment(SwingConstants.CENTER);
		lError.setBounds(206, 618, 365, 27);
		matchmaking.getContentPane().add(lError);

		updateCombo();
		updateTable();

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				bShuffle.setEnabled(false);
				bWinner0.setEnabled(false);
				bWinner1.setEnabled(false);
				updateTable();
				lTeam1.setText("");
				lTeam2.setText("");
				lError.setText("");

			}
		});

		ListSelectionModel listSelectionModel0 = (ListSelectionModel) tableUpcoming.getSelectionModel();
		listSelectionModel0.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent event) {
				if (tableUpcoming.getSelectedRow() != -1) {

					bWinner0.setEnabled(true);
					bWinner1.setEnabled(true);
					Match activeMatch = null;
					int matchID = (Integer) tableUpcoming.getValueAt(tableUpcoming.getSelectedRow(), 0);

					matches.toFirst();
					while (matches.hasAccess()) {
						if (matches.getContent().getMatchID() == matchID) {
							activeMatch = matches.getContent();
						}
						matches.next();
					}

					if (activeMatch != null) {
						team1 = activeMatch.getTeam0();
						team2 = activeMatch.getTeam1();

						lTeam1.setText(team1.getTeamname());
						lTeam2.setText(team2.getTeamname());
					}
				}

			}
		});

	}

	public JLabel getErrorLabel() {
		return lError;
	}

	public void updateCombo() {
		List<Spiel> games = controller.allGames();
		games.toFirst();
		while (games.hasAccess()) {
			comboBox.addItem(new ComboItem(games.getContent().getType(), games.getContent()));
			games.next();
		}
	}

	public void updateTable() {
		if (((ComboItem) comboBox.getSelectedItem()) != null) {
			ComboItem activeItem = (ComboItem) comboBox.getSelectedItem();
			Spiel activeGame = activeItem.getValue();
			List<Match> matchList = activeGame.getMatchList();
			Match activeMatch;

			DefaultTableModel model = (DefaultTableModel) tableUpcoming.getModel();
			model.setRowCount(0);
			if (activeGame.getMatchOrder()) {
				matchList.toFirst();
				while (matchList.hasAccess()) {
					activeMatch = matchList.getContent();
					model.addRow(new Object[] { activeMatch.getMatchID(), activeMatch.getTeamIDs(),
							activeMatch.getTeamNames() });
					matchList.next();
				}

			} else {
				bShuffle.setEnabled(true);
			}
		}

	}
}
