package good_userinterface;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;


/**
 * Diese Klasse repräsentiert das Menü, welches beim start des Programms angezeit wird.
 * Hier kann der Benutzer seine Auswahl treffen.
 * Es ist ihm möglich einen Fragebogen zu erstellen oder zu bearbeiten.
 * 
 * @autor: Gerald Maresch
*/
@SuppressWarnings("serial")
public class Menue extends javax.swing.JFrame {
	
	private JTextPane jTextPane_drucken;
	private JPanel jPanel1;
	private JButton jButton_print;
	private JMenuBar jMenuBar1;
	private JMenu jMenu1;
	private JButton b_exit;
	private JSeparator jSeparator2;
	private JLabel jLabel_logo;
	private JTextPane tp_tipp2;
	private JSeparator jSeparator1;
	private JButton b_FBErstellen;
	private JLabel jLabel1;
	private JMenu jMenu2;
	private JMenuItem jItem2;
	private JMenuItem jItem3;
	
	
	public Menue() {
		super();
		initGUI();
		setLocationRelativeTo(null);
		setVisible(true);
		setTitle("Auswahl-Menü");
		setResizable(false);
	}	
	
	private void initGUI() {
		try {
			BorderLayout thisLayout = new BorderLayout();
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(thisLayout);
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				{
					//Menü Hirachie bauen
					jMenu1 = new JMenu("Einstellungen");
					jMenuBar1.add(jMenu1);
					jMenu2 = new JMenu("Datenbank");					
					jItem2 = new JMenuItem("Access Datenbank");
					jItem3 = new JMenuItem("Microsof SQL-Server");
					jMenu2.add(jItem2);
					jMenu2.add(jItem3);
					jMenu1.add(jMenu2);
					jMenu1 = new JMenu("?");
					jMenuBar1.add(jMenu1);
					jItem2 = new JMenuItem("About"); //Kleines Fenster mit beschreibung und wers codiert hat
					jItem3 = new JMenuItem("Help me"); //Kleines Hilfe Menü
					jMenu1.add(jItem2);
					jMenu1.add(jItem3);
					
				}
			}
			{
				jSeparator1 = new JSeparator();
				getContentPane().add(jSeparator1, BorderLayout.NORTH);
			}
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				jPanel1.setLayout(null);
				jPanel1.setPreferredSize(new java.awt.Dimension(624, 425));
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1);
					jLabel1.setText("Willkommmen in der Fragebogenverwaltung");
					jLabel1.setBounds(33,12, 419, 23);
					jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20));
				}
				{
					b_FBErstellen = new JButton();
					jPanel1.add(b_FBErstellen);
					File f = new File(
							"C:\\Programme\\Meinungsforschung\\Bilder\\Neu.jpg");
					if (f.exists()) {
						b_FBErstellen
								.setIcon(new ImageIcon(
										"C:\\Programme\\Meinungsforschung\\Bilder\\Neu.jpg"));
					} else {
						b_FBErstellen.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource(
										"good_userinterface/ds/Neu.jpg")));
					}
					b_FBErstellen.setText("FB erstellen");
					b_FBErstellen.setBounds(17, 100, 189, 182);
					final JFrame thisWindow = this;
					b_FBErstellen.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							FbErstellungGUI erstellenGui = new FbErstellungGUI ();
							erstellenGui.setLocationRelativeTo(null);
							erstellenGui.setVisible(true);
							thisWindow.dispose();
							dispose();
						}
					});
				}
				{
					tp_tipp2 = new JTextPane();
					jPanel1.add(tp_tipp2);
					tp_tipp2
							.setText("Klicken Sie hier um einen neuen Fragebogen anzulegen");
					tp_tipp2.setEditable(false);
					tp_tipp2.setBackground(new java.awt.Color(236, 236, 223));
					tp_tipp2.setFont(new java.awt.Font("Calibri", 0, 12));
					tp_tipp2.setName("tp_tipp2");
					tp_tipp2.setBounds(17, 287, 189, 69);
				}
				{
					jLabel_logo = new JLabel();
					jPanel1.add(jLabel_logo);
					File f = new File(
							"C:\\Programme\\Meinungsforschung\\Bilder\\logo.jpg");
					if (f.exists()) {
						jLabel_logo
								.setIcon(new ImageIcon(
										"C:\\Programme\\Meinungsforschung\\Bilder\\logo.jpg"));
					} else {
						jLabel_logo.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource(
										"good_userinterface/ds/logo.jpg")));
					}
					jLabel_logo.setBounds(205, 41, 68, 83);
				}
				{
					jSeparator2 = new JSeparator();
					jPanel1.add(jSeparator2);
					jSeparator2.setBounds(40, 374, 392, 10);
				}
				{
					b_exit = new JButton();
					jPanel1.add(b_exit);
					File f = new File(
							"C:\\Programme\\Meinungsforschung\\Bilder\\Exit.jpg");
					if (f.exists()) {
						b_exit
								.setIcon(new ImageIcon(
										"C:\\Programme\\Meinungsforschung\\Bilder\\Exit.jpg"));
					} else {
						b_exit.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource(
										"good_userinterface/ds/Exit.jpg")));
					}
					b_exit.setText("   Exit");
					b_exit.setBounds(120, 390, 242, 40);
					b_exit.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							System.exit(0);
						}
					});
				}
				{
					jButton_print = new JButton();
					jPanel1.add(jButton_print);
					File f = new File(
							"C:\\Programme\\Meinungsforschung\\Bilder\\drucken.jpg");
					if (f.exists()) {
						jButton_print
								.setIcon(new ImageIcon(
										"C:\\Programme\\Meinungsforschung\\Bilder\\drucken.jpg"));
					} else {
						jButton_print.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource(
										"good_userinterface/ds/drucken.jpg")));
					}
					jButton_print.setText("  Tans drucken");
					jButton_print.setBounds(285, 101, 185, 180);
					final JFrame thisWindow2 = this;
					jButton_print.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							TansGUI tanGui = new TansGUI();
							tanGui.setLocationRelativeTo(null);
							tanGui.setVisible(true);
							thisWindow2.dispose();
							//dispose();
						}
					});
				}
				{
					jTextPane_drucken = new JTextPane();
					jPanel1.add(jTextPane_drucken);
					jTextPane_drucken
							.setText("Klicken Sie hier um einen Fragebogen zu wählen von dem Sie Tans drucken wollen");
					jTextPane_drucken.setEditable(false);
					jTextPane_drucken.setBackground(new java.awt.Color(236,
							236, 223));
					jTextPane_drucken.setFont(new java.awt.Font("Calibri", 0,
							12));
					jTextPane_drucken.setName("tp_tipp3");
					jTextPane_drucken.setBounds(285, 286, 185, 70);
				}
			}
			pack();
			this.setSize(498, 533);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
