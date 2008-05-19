package db;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import java.io.*;


/**
 * Diese Klasse ist dazu da um die Konfigurationsdatei zu erstellen.
 * Sie wird unter db.ini abgespeichert. Das Passwort wird verschlüsselt gespeichert.
 * @author Linzatti Christian
 */
@SuppressWarnings("serial")
public class Setup extends javax.swing.JFrame {
	
	/** Label ueberschrift. */
	private JLabel ueberschrift;
	
	/** Label Datenbankserver */
	private JLabel LDatenbankserver;
	
	/** Label Port */
	private JLabel LPort;
	
	/** Label Beschreibung Default Port. */
	private JLabel ldefault;
	
	/** Label speichern */
	private JLabel lspeichern;
	
	/** JTextField datenbankname. */
	private JTextField datenbankname;
	
	/** Label Datenbankname. */
	private JLabel ldatenbankname;
	
	/** Passwortfeld. */
	private JPasswordField passwort;
	
	/** JTextField Port. */
	private JTextField port;
	
	/** Label Port */
	private JLabel lport;
	
	/** Label Version */
	private JLabel lversion;
	
	/** Speicher Button */
	private JButton speichern;
	
	/** TextFeld Servername. */
	private JTextField server;
	
	/** Textfeld Username */
	private JTextField username;
	
	/** Textfekd Passwort */
	private JLabel lPasswort;
	
	/** Label Username */
	private JLabel lusername;
	
	/** Ein File Objekt welches auf db.ini zeigt */
	private File file;
	

	/**
	 * Main Methode
	  */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Setup inst = new Setup();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
				}
		});
	}
	
	/**
	 * Konstruktor
	 */
	public Setup() {
		super();
		initGUI();
		read();
		
	}
	
	/**
	 * Initialisiert die Gui
	 */
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Konfiguration des Servers");
			{
				ueberschrift = new JLabel();
				getContentPane().add(ueberschrift);
				ueberschrift.setText("Verbindung zum Datenbankserver");
				ueberschrift.setBounds(17, 12, 267, 14);
				ueberschrift.setFont(new java.awt.Font("Tahoma",0,16));
			}
			{
				LDatenbankserver = new JLabel();
				getContentPane().add(LDatenbankserver);
				LDatenbankserver.setText("Datenbankserver");
				LDatenbankserver.setBounds(33, 60, 111, 14);
			}
			{
				LPort = new JLabel();
				getContentPane().add(LPort);
				LPort.setText("Port");
				LPort.setBounds(34, 120, 57, 14);
			}
			{
				lusername = new JLabel();
				getContentPane().add(lusername);
				lusername.setText("Username");
				lusername.setBounds(34, 160, 92, 14);
			}
			{
				lPasswort = new JLabel();
				getContentPane().add(lPasswort);
				lPasswort.setText("Passwort");
				lPasswort.setBounds(34, 196, 98, 14);
			}
			{
				username = new JTextField();
				getContentPane().add(username);
				username.setBounds(144, 157, 108, 21);
			}
			{
				lport = new JLabel();
				getContentPane().add(lport);
				lport.setBounds(147, 60, 10, 10);
			}
			{
				server = new JTextField();
				getContentPane().add(server);
				server.setBounds(144, 57, 110, 21);
			}
			{
				speichern = new JButton();
				getContentPane().add(speichern);
				speichern.setText("speichern");
				speichern.setBounds(144, 234, 98, 21);
				speichern.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						save();
					}
				});
			}
			{
				lversion = new JLabel();
				getContentPane().add(lversion);
				lversion.setText("Microsoft SQL Server");
				lversion.setBounds(61, 35, 138, 14);
			}
			{
				
								{
					passwort = new JPasswordField();
					getContentPane().add(getPasswortx());
					passwort.setBounds(144, 193, 108, 21);
				}
								{
									port = new JTextField();
									getContentPane().add(getJTextField1());
									port.setBounds(144, 117, 55, 21);
								}
								{
									ldatenbankname = new JLabel();
									getContentPane().add(ldatenbankname);
									ldatenbankname.setText("Datenbankname");
									ldatenbankname.setBounds(33, 88, 111, 14);
								}
								{
									datenbankname = new JTextField();
									getContentPane().add(getDatenbankname());
									datenbankname.setBounds(144, 84, 110, 21);
								}
								{
									lspeichern = new JLabel();
									getContentPane().add(lspeichern);
									lspeichern.setText("speichern");
									lspeichern.setBounds(32, 235, 112, 14);
								}
								{
									ldefault = new JLabel();
									getContentPane().add(ldefault);
									ldefault.setText("Default: 1433");
									ldefault.setBounds(205, 120, 79, 14);
								}
			}
			pack();
			this.setSize(299, 327);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}				
	
	/**
	 * Liest die Konfiguation und füllt die Textfelder aus
	 */
	public void read()
	{
		 file = new File("db.ini");
		if (file.exists())
		{
			try {
				BufferedReader in
				   = new BufferedReader(new FileReader(file));
				server.setText(in.readLine());
				datenbankname.setText(in.readLine());
				port.setText(in.readLine());
				username.setText(in.readLine());
				passwort.setText(VerschluesselnMitJava.entschlusseln(in.readLine()));
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Speichert die Einstellungen in der Konfiguationsdatei ab.
	 */
	@SuppressWarnings({ "deprecation", "deprecation" })
	public void save()
	{
		if ((server.getText().length() > 0 ) && (port.getText().length()>0) && (username.getText().length() > 0) && (passwort.getText().length() > 0) )
		{
			try {
				PrintWriter out
				   = new PrintWriter(new BufferedWriter(new FileWriter(file)));
				out.println(server.getText());
				out.println(datenbankname.getText());
				out.println(port.getText());
				out.println(username.getText());
				out.println(VerschluesselnMitJava.verschluessel(passwort.getText()));
				out.flush();
				out.close();
				JOptionPane.showMessageDialog(null,
	                      "Die Einstellungen wurden gesichert",
	                      "Error",
	                      JOptionPane.ERROR_MESSAGE) ;
					this.dispose();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
		else
		{
			JOptionPane.showMessageDialog(null,
                      "Bitte füllen Sie alle Felder aus",
                      "Error",
                      JOptionPane.ERROR_MESSAGE) ;
		}
	}
	
	/**
	 * Gets the passwortx.
	 * 
	 * @return the passwortx
	 */
	public JPasswordField getPasswortx() {
		return passwort;
	}
	
	/**
	 * Gets the j text field1.
	 * 
	 * @return the j text field1
	 */
	public JTextField getJTextField1() {
		return port;
	}
	
	/**
	 * Gibt den Datenbanknamen zurück
	 * 
	 * @return  datenbankname
	 */
	public JTextField getDatenbankname() {
		return datenbankname;
	}
}
