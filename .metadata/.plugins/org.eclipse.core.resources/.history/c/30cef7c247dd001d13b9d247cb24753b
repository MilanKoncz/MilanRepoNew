import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewPlayerGUI {

	JFrame frmNeuerSpieler;
	private JTextField tfName;
	private JTextField tfJahr;
	private Controller controller;
	private JTextField tfGameID;
	private JTextField tfTeamID;
	private MainGUI mainGUI;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public NewPlayerGUI(Controller pController, MainGUI pMainGUI) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
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
		frmNeuerSpieler.setBounds(100, 100, 450, 230);
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
				
				String name = tfName.getText();
				int jahr = Integer.parseInt(tfJahr.getText());
				int gameID = Integer.parseInt(tfGameID.getText());
				int teamID = Integer.parseInt(tfTeamID.getText());
				
				controller.addPlayer(name, jahr, gameID, teamID);
				mainGUI.updatePlayers();
				frmNeuerSpieler.dispose();
				
			}
		});
		bSubmit.setBounds(155, 137, 89, 23);
		frmNeuerSpieler.getContentPane().add(bSubmit);
		
		tfGameID = new JTextField();
		tfGameID.setColumns(10);
		tfGameID.setBounds(176, 70, 222, 20);
		frmNeuerSpieler.getContentPane().add(tfGameID);
		
		tfTeamID = new JTextField();
		tfTeamID.setColumns(10);
		tfTeamID.setBounds(176, 103, 222, 20);
		frmNeuerSpieler.getContentPane().add(tfTeamID);
		
		JLabel lblSpielId = new JLabel("Spiel ID");
		lblSpielId.setBounds(10, 73, 113, 14);
		frmNeuerSpieler.getContentPane().add(lblSpielId);
		
		JLabel lblTeamId = new JLabel("Team ID");
		lblTeamId.setBounds(10, 109, 113, 14);
		frmNeuerSpieler.getContentPane().add(lblTeamId);
	}
}
