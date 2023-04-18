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

public class NewGameGUI {

	JFrame frmNeuesTurnierErstellen;
	private JTextField tfTyp;
	private Controller controller;
	private MainGUI mainGUI;

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
	public NewGameGUI(Controller pController, MainGUI pMainGUI) throws ClassNotFoundException, InstantiationException,
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
		frmNeuesTurnierErstellen = new JFrame();
		frmNeuesTurnierErstellen.setTitle("Neues Turnier");
		frmNeuesTurnierErstellen.setResizable(false);
		frmNeuesTurnierErstellen.setBounds(100, 100, 271, 157);
		frmNeuesTurnierErstellen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmNeuesTurnierErstellen.getContentPane().setLayout(null);
		frmNeuesTurnierErstellen.setVisible(true);

		JLabel lblNewLabel = new JLabel("Spieltyp");
		lblNewLabel.setBounds(10, 11, 113, 14);
		frmNeuesTurnierErstellen.getContentPane().add(lblNewLabel);

		tfTyp = new JTextField();
		tfTyp.setBounds(10, 36, 222, 20);
		frmNeuesTurnierErstellen.getContentPane().add(tfTyp);
		tfTyp.setColumns(10);

		JButton bSubmit = new JButton("Submit");
		bSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String typ = tfTyp.getText();
				controller.addGame(typ);
				mainGUI.updateGames();
				JTable tableTeams = mainGUI.getTeamTable();
				JTable tableLiga = mainGUI.getLigaTable();
				DefaultTableModel model0 = (DefaultTableModel) tableTeams.getModel();
				model0.setRowCount(0);
				DefaultTableModel model1 = (DefaultTableModel) tableLiga.getModel();
				model1.setRowCount(0);
				mainGUI.getBAddTeam().setEnabled(false);
				mainGUI.getBDelGame().setEnabled(false);
				mainGUI.getBAddPlayer().setEnabled(false);
				mainGUI.getBDelTeam().setEnabled(false);
				mainGUI.getBLiga().setEnabled(false);
				frmNeuesTurnierErstellen.dispose();
			}
		});
		bSubmit.setBounds(74, 88, 89, 23);
		frmNeuesTurnierErstellen.getContentPane().add(bSubmit);
	}
}
