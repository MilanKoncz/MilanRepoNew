import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchTeamGUI {

	JFrame frmTeamAuswaehlen;
	private Controller controller;

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
	public SearchTeamGUI(Controller pController) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		controller = pController;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTeamAuswaehlen = new JFrame();
		frmTeamAuswaehlen.setResizable(false);
		frmTeamAuswaehlen.setTitle("Team auswaehlen");
		frmTeamAuswaehlen.setBounds(100, 100, 450, 183);
		frmTeamAuswaehlen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmTeamAuswaehlen.getContentPane().setLayout(null);
		frmTeamAuswaehlen.setVisible(true);
		
		JButton bSubmit = new JButton("Submit");
		bSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				frmTeamAuswaehlen.dispose();
			}
		});
		bSubmit.setBounds(167, 109, 89, 23);
		frmTeamAuswaehlen.getContentPane().add(bSubmit);
	}
}
