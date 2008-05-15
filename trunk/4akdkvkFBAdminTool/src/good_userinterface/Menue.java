package good_userinterface;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;



/**
 * Diese Klasse repr�sentiert das Men�, welches beim start des Programms angezeit wird.
 * Hier kann der Benutzer seine Auswahl treffen.
 * Es ist ihm m�glich einen Fragebogen zu erstellen oder zu bearbeiten.
 * 
 * @autor: Gerald Maresch
*/
@SuppressWarnings("serial")
public class Menue extends javax.swing.JFrame {
	private JPanel jPanel1;
	private JButton b_exit;
	private JSeparator jSeparator2;
	private JLabel jLabel_logo;
	private JTextPane tp_tipp3;
	private JTextPane tp_tipp2;
	private JButton b_FBBearbeiten;
	private JSeparator jSeparator1;
	private JButton b_FBErstellen;
	private JTextPane tp_tipp1;
	private JLabel jLabel1;
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Menue inst = new Menue();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
				inst.setTitle("Auswahl-Men�");
				inst.setResizable(false);
			}
		});
	}

	public Menue() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			BorderLayout thisLayout = new BorderLayout();
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(thisLayout);
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				jPanel1.setLayout(null);
				jPanel1.setPreferredSize(new java.awt.Dimension(644, 416));
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1);
					jLabel1.setText("Willkommmen in der Fragebogenverwaltung");
					jLabel1.setBounds(94, 39, 419, 23);
					jLabel1.setFont(new java.awt.Font("Tahoma",0,20));
				}
				{
					tp_tipp1 = new JTextPane();
					jPanel1.add(tp_tipp1);
					tp_tipp1.setText("Was wollen Sie tun?");
					tp_tipp1.setEditable(false);
					tp_tipp1.setBackground(new java.awt.Color(236,236,223));
					tp_tipp1.setFont(new java.awt.Font("Calibri",0,12));
					tp_tipp1.setBounds(12, 104, 217, 27);
					tp_tipp1.setName("f");
				}
				{
					b_FBErstellen = new JButton();
					jPanel1.add(b_FBErstellen);
					b_FBErstellen.setText("FB erstellen");
					b_FBErstellen.setBounds(40, 137, 138, 182);
					b_FBErstellen.setIcon(new ImageIcon(getClass().getClassLoader().getResource("good_userinterface/Neu.jpg")));
					final JFrame thisWindow = this;
					b_FBErstellen.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							FbErstellungGUI erstellenGui = new FbErstellungGUI ();
							erstellenGui.setLocationRelativeTo(null);
							erstellenGui.setVisible(true);
							thisWindow.dispose();
						}
					});
				}
				{
					b_FBBearbeiten = new JButton();
					jPanel1.add(b_FBBearbeiten);
					b_FBBearbeiten.setText("FB berabeiten");
					b_FBBearbeiten.setBounds(224, 137, 135, 182);
					b_FBBearbeiten.setIcon(new ImageIcon(getClass().getClassLoader().getResource("good_userinterface/Aendern.jpg")));
				}
				{
					tp_tipp2 = new JTextPane();
					jPanel1.add(tp_tipp2);
					tp_tipp2.setText("Klicken Sie hier um einen neuen Fragebogen anzulegen");
					tp_tipp2.setEditable(false);
					tp_tipp2.setBackground(new java.awt.Color(236,236,223));
					tp_tipp2.setFont(new java.awt.Font("Calibri",0,12));
					tp_tipp2.setName("tp_tipp2");
					tp_tipp2.setBounds(40, 322, 138, 86);
				}
				{
					tp_tipp3 = new JTextPane();
					jPanel1.add(tp_tipp3);
					tp_tipp3.setText("Klicken Sie hier um einen bereits vorhandenen Fragebogen zu bearbeiten");
					tp_tipp3.setEditable(false);
					tp_tipp3.setBackground(new java.awt.Color(236,236,223));
					tp_tipp3.setFont(new java.awt.Font("Calibri",0,12));
					tp_tipp3.setName("tp_tipp3");
					tp_tipp3.setBounds(224, 328, 138, 86);
				}
				{
					jLabel_logo = new JLabel();
					jPanel1.add(jLabel_logo);
					jLabel_logo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("good_userInterface/logo.jpg")));
					jLabel_logo.setBounds(551, 12, 68, 83);
				}
				{
					jSeparator2 = new JSeparator();
					jPanel1.add(jSeparator2);
					jSeparator2.setBounds(40, 426, 563, 10);
				}
				{
					b_exit = new JButton();
					jPanel1.add(b_exit);
					b_exit.setText("   Exit");
					b_exit.setBounds(258, 442, 133, 40);
					b_exit.setIcon(new ImageIcon(getClass().getClassLoader().getResource("good_userinterface/Exit.jpg")));
					b_exit.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							
							System.exit(0);
						}
					});
				}
			}
			{
				jSeparator1 = new JSeparator();
				getContentPane().add(jSeparator1, BorderLayout.NORTH);
			}
			pack();
			this.setSize(652, 529);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}