import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewTeamGUI {

	JFrame frmNeuesTeam;
	private JTextField tfName;
	private Controller controller;
	private MainGUI mainGUI;
	private MatchmakingGUI matchmakingGUI;

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
	public NewTeamGUI(Controller pController, MainGUI pMainGUI, MatchmakingGUI pMatchmakingGUI) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		matchmakingGUI = pMatchmakingGUI;
		controller = pController;
		mainGUI = pMainGUI;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNeuesTeam = new JFrame();
		frmNeuesTeam.setTitle("Neues Team");
		frmNeuesTeam.setResizable(false);
		frmNeuesTeam.setBounds(100, 100, 429, 158);
		frmNeuesTeam.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmNeuesTeam.getContentPane().setLayout(null);
		frmNeuesTeam.setVisible(true);

		JLabel lblNameDesTeams = new JLabel("Name des Teams");
		lblNameDesTeams.setBounds(10, 35, 113, 14);
		frmNeuesTeam.getContentPane().add(lblNameDesTeams);

		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(155, 32, 222, 20);
		frmNeuesTeam.getContentPane().add(tfName);

		JButton bSubmit = new JButton("Submit");
		bSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JTable tableGames = mainGUI.getGameTable();
				int id = (Integer) tableGames.getValueAt(tableGames.getSelectedRow(), 0);
				String name = tfName.getText();
				controller.addTeam(name, id);
				mainGUI.updateTeams();
				mainGUI.getBAddPlayer().setEnabled(false);
				mainGUI.getBDelPlayer().setEnabled(false);
				JTable tablePlayer = mainGUI.getPlayerTable();
				DefaultTableModel model = (DefaultTableModel) tablePlayer.getModel();
				model.setRowCount(0);
				int gameID = (Integer) mainGUI.getGameTable().getValueAt(tableGames.getSelectedRow(), 0);
				controller.findActiveGame(gameID).setMatchOrder(false);
				try {
					matchmakingGUI.getErrorLabel().setText("");
				}catch(NullPointerException el) {
					
				}
				frmNeuesTeam.dispose();
			}
		});
		bSubmit.setBounds(167, 85, 89, 23);
		frmNeuesTeam.getContentPane().add(bSubmit);
	}
}
