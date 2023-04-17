import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewTeamGUI {

	JFrame frmNeuesTeam;
	private JTextField tfName;
	private Controller controller;
	private JTextField tfID;
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
	public NewTeamGUI(Controller pController, MainGUI pMainGUI) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
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
		frmNeuesTeam.setBounds(100, 100, 450, 206);
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
				
				int id = Integer.parseInt(tfID.getText());
				String name = tfName.getText();
				controller.addTeam(name, id);
				mainGUI.updateTeams();
				frmNeuesTeam.dispose();
			}
		});
		bSubmit.setBounds(155, 130, 89, 23);
		frmNeuesTeam.getContentPane().add(bSubmit);
		
		JLabel lblSpielId = new JLabel("Spiel ID");
		lblSpielId.setBounds(10, 80, 113, 14);
		frmNeuesTeam.getContentPane().add(lblSpielId);
		
		tfID = new JTextField();
		tfID.setColumns(10);
		tfID.setBounds(155, 77, 222, 20);
		frmNeuesTeam.getContentPane().add(tfID);
	}
}
