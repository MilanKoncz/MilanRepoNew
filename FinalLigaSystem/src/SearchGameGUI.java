import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SearchGameGUI {

	JFrame frmSpielAuswaehlen;
	private Controller controller;
	private JTextField tfEingabe;

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
	public SearchGameGUI(Controller pController) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		controller = pController;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSpielAuswaehlen = new JFrame();
		frmSpielAuswaehlen.setResizable(false);
		frmSpielAuswaehlen.setTitle("Spiel auswaehlen");
		frmSpielAuswaehlen.setBounds(100, 100, 450, 183);
		frmSpielAuswaehlen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmSpielAuswaehlen.getContentPane().setLayout(null);
		frmSpielAuswaehlen.setVisible(true);
		
		JButton bSubmit = new JButton("Submit");
		bSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				frmSpielAuswaehlen.dispose();
			}
		});
		bSubmit.setBounds(167, 109, 89, 23);
		frmSpielAuswaehlen.getContentPane().add(bSubmit);
		
		JLabel lblNewLabel = new JLabel("Spiel ID zu dem Ausgeben aller Teams eingeben:");
		lblNewLabel.setBounds(10, 11, 257, 14);
		frmSpielAuswaehlen.getContentPane().add(lblNewLabel);
		
		tfEingabe = new JTextField();
		tfEingabe.setBounds(10, 36, 236, 20);
		frmSpielAuswaehlen.getContentPane().add(tfEingabe);
		tfEingabe.setColumns(10);
	}
}
