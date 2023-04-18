import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class NewPlayerGUI {

	JFrame frmNeuerSpieler;
	private JTextField tfName;
	private JTextField tfJahr;
	private Controller controller;
	private MainGUI mainGUI;
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
	public NewPlayerGUI(Controller pController, MainGUI pMainGUI) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		controller = pController;
		mainGUI = pMainGUI;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNeuerSpieler = new JFrame();
		frmNeuerSpieler.setResizable(false);
		frmNeuerSpieler.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmNeuerSpieler.setTitle("Neuer Spieler");
		frmNeuerSpieler.setBounds(100, 100, 440, 160);
		frmNeuerSpieler.getContentPane().setLayout(null);
		frmNeuerSpieler.setVisible(true);

		JLabel lblNameDesSpielers = new JLabel("Name des Spielers");
		lblNameDesSpielers.setBounds(10, 11, 113, 14);
		frmNeuerSpieler.getContentPane().add(lblNameDesSpielers);

		JLabel lblGeburtsjahr = new JLabel("Geburtsjahr");
		lblGeburtsjahr.setBounds(10, 42, 113, 14);
		frmNeuerSpieler.getContentPane().add(lblGeburtsjahr);

		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(176, 8, 222, 20);
		frmNeuerSpieler.getContentPane().add(tfName);

		tfJahr = new JTextField();
		tfJahr.setColumns(10);
		tfJahr.setBounds(176, 39, 222, 20);
		frmNeuerSpieler.getContentPane().add(tfJahr);

		JButton bSubmit = new JButton("Submit");
		bSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int jahr;
				String name = tfName.getText();
				try {
					jahr = Integer.parseInt(tfJahr.getText());
					JTable tableGames = mainGUI.getGameTable();
					JTable tableTeams = mainGUI.getTeamTable();
					int gameID = (Integer) tableGames.getValueAt(tableGames.getSelectedRow(), 0);
					int teamID = (Integer) tableTeams.getValueAt(tableTeams.getSelectedRow(), 0);

					controller.addPlayer(name, jahr, gameID, teamID);
					mainGUI.updatePlayers();
					//mainGUI.updateTeams();
					//mainGUI.getBDelTeam().setEnabled(false);
					//mainGUI.getBAddPlayer().setEnabled(false);
					frmNeuerSpieler.dispose();
				} catch (NumberFormatException e1) {
					lError.setText("Invalid Number!");
				}

				catch (ArrayIndexOutOfBoundsException e1) {
					lError.setText("No valid Team Selected!");
				}

			}
		});
		bSubmit.setBounds(155, 89, 89, 23);
		frmNeuerSpieler.getContentPane().add(bSubmit);

		lError = new JLabel("");
		lError.setForeground(new Color(255, 0, 0));
		lError.setBounds(176, 64, 158, 14);
		frmNeuerSpieler.getContentPane().add(lError);
	}
}
