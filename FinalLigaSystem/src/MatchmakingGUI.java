import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MatchmakingGUI {

	JFrame matchmaking;
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
	public MatchmakingGUI(Controller pController) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		controller = pController;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
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
	}
}
