package good_userinterface;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.io.File;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import org.jdesktop.swingx.JXDatePicker;
import good_fragen.*;

/**
 * 
 * @author Daniel Lazarevic
 * Mit dieser GUI kann man einen Fragebogen erstellen.
 * Man muss zuerst den Fragebogennamen eingeben, anschlie�end gibt
 * man die Bezeichnung des Fragebogens ein.
 * 
 * Danach wird das Enddatum des Fragebogens eingegeben
 * 
 * Letztendlich wird die Anzahl der befragten Personen eingegeben, dies
 * ist wichtig f�r die TAN-Erstellung
 */
@SuppressWarnings("serial")
public class FbErstellungGUI extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/** The j panel_mainwindow. */
	private JPanel jPanel_mainwindow;
	
	/** The j label_titel_ fragebogen erstellung. */
	private JLabel jLabel_titel_FragebogenErstellung;
	
	/** The j text area_fb beschreibung. */
	private JTextArea jTextArea_fbBeschreibung;
	
	/** The j scroll pane_fb beschreibung. */
	private JScrollPane jScrollPane_fbBeschreibung;
	
	/** The j label_fb end datum. */
	private JLabel jLabel_fbEndDatum;
	
	/** The j button_ erstellen. */
	private JButton jButton_Erstellen;

	 /** The jButton_bzurueck */
	private JButton b_zurueck;
	
	/** The j separator4. */
	private JSeparator jSeparator4;
	
	/** The j text field_ anzahl. */
	private JTextField jTextField_Anzahl;
	
	/** The j label1. */
	private JLabel jLabel1;
	
	/** The j text pane1. */
	private JTextPane jTextPane1;
	
	/** The j label_logo. */
	private JLabel jLabel_logo;
	
	/** The j separator3. */
	private JSeparator jSeparator3;
	
	/** The j separator2. */
	private JSeparator jSeparator2;
	
	/** The j separator1. */
	private JSeparator jSeparator1;
	
	/** The j text pane_ beschreibung_ erstellen. */
	private JTextPane jTextPane_Beschreibung_Erstellen;
	
	/** The j text pane_ beschreibung_ enddatum. */
	private JTextPane jTextPane_Beschreibung_Enddatum;
	
	/** The j text pane_ beschreibung_ beschreibung. */
	private JTextPane jTextPane_Beschreibung_Beschreibung;
	
	/** The j text pane_ titel_ beschreibung. */
	private JTextPane jTextPane_Titel_Beschreibung;
	
	/** The j label_fb beschreibung. */
	private JLabel jLabel_fbBeschreibung;
	
	/** The j text field_fb titel. */
	private JTextField jTextField_fbTitel;
	
	/** The j label_ fragebogen_ titel. */
	private JLabel jLabel_Fragebogen_Titel;

	private JXDatePicker jTextField_fbEndDatum;
	
	/**
	 * 
	 */
	public FbErstellungGUI() {
		super();
		setLocationRelativeTo(null);
		setVisible(true);
		setTitle("Fragebogen-Erstellung");
		setResizable(false);
		initGUI();
	}
	
	/**
	 * 
	 */
	@SuppressWarnings("deprecation")
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jPanel_mainwindow = new JPanel();
				getContentPane().add(jPanel_mainwindow, BorderLayout.CENTER);
				jPanel_mainwindow.setLayout(null);
				jPanel_mainwindow.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
				jPanel_mainwindow.setPreferredSize(new java.awt.Dimension(360, 516));
				jPanel_mainwindow.setBackground(new java.awt.Color(236,236,223));
				{
					jLabel_titel_FragebogenErstellung = new JLabel();
					jPanel_mainwindow.add(jLabel_titel_FragebogenErstellung);
					jLabel_titel_FragebogenErstellung.setText("Erstellen des Fragebogen");
					jLabel_titel_FragebogenErstellung.setBounds(12, 12, 219, 34);
					jLabel_titel_FragebogenErstellung.setFont(new java.awt.Font("Calibri",1,20));
				}
				{
					jLabel_Fragebogen_Titel = new JLabel();
					jPanel_mainwindow.add(jLabel_Fragebogen_Titel);
					jLabel_Fragebogen_Titel.setText("Titel:");
					jLabel_Fragebogen_Titel.setBounds(13, 121, 87, 16);
				}
				{
					jTextField_fbTitel = new JTextField();
					jPanel_mainwindow.add(jTextField_fbTitel);
					jTextField_fbTitel.setBounds(100, 118, 239, 22);
					jTextField_fbTitel.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
				}
				{
					jLabel_fbBeschreibung = new JLabel();
					jPanel_mainwindow.add(jLabel_fbBeschreibung);
					jLabel_fbBeschreibung.setText("Beschreibung:");
					jLabel_fbBeschreibung.setBounds(16, 221, 87, 16);
				}
				{
					jScrollPane_fbBeschreibung = new JScrollPane();
					jPanel_mainwindow.add(jScrollPane_fbBeschreibung);
					jScrollPane_fbBeschreibung.setBounds(102, 221, 239, 96);
					{
						jTextArea_fbBeschreibung = new JTextArea();
						jScrollPane_fbBeschreibung.setViewportView(jTextArea_fbBeschreibung);
						jTextArea_fbBeschreibung.setBounds(74, 207, 236, 93);
						jTextArea_fbBeschreibung.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
						jTextArea_fbBeschreibung.setPreferredSize(new java.awt.Dimension(221, 255));
						jTextArea_fbBeschreibung.setSize(255, 255);
					}
				}
				{
					jLabel_fbEndDatum = new JLabel();
					jPanel_mainwindow.add(jLabel_fbEndDatum);
					jLabel_fbEndDatum.setText("Enddatum:");
					jLabel_fbEndDatum.setBounds(16, 427, 86, 16);
					jLabel_fbEndDatum.setBackground(new java.awt.Color(236,236,223));
				}
				{
					jTextPane_Titel_Beschreibung = new JTextPane();
					jPanel_mainwindow.add(jTextPane_Titel_Beschreibung);
					jTextPane_Titel_Beschreibung.setText("Geben Sie hier den Titel des Fragebogens ein. Dieser repr�sentiert den Fragebogen. Dieser sollte f�r nachfolgende Arbeiten aussagekr�ftig sein.");
					jTextPane_Titel_Beschreibung.setBounds(13, 58, 296, 54);
					jTextPane_Titel_Beschreibung.setBackground(new java.awt.Color(236,236,223));
					jTextPane_Titel_Beschreibung.setFont(new java.awt.Font("Calibri",0,12));
					jTextPane_Titel_Beschreibung.setEditable(false);
				}
				{
					jTextPane_Beschreibung_Beschreibung = new JTextPane();
					jPanel_mainwindow.add(jTextPane_Beschreibung_Beschreibung);
					jTextPane_Beschreibung_Beschreibung.setText("Geben Sie hier eine kurze Beschreibung, diese ist beliebig zu gestalten, da diese nur f�r den Benutzer eine kurze Beschreibung bietet.");
					jTextPane_Beschreibung_Beschreibung.setBounds(13, 163, 296, 52);
					jTextPane_Beschreibung_Beschreibung.setBackground(new java.awt.Color(236,236,223));
					jTextPane_Beschreibung_Beschreibung.setFont(new java.awt.Font("Calibri",0,12));
					jTextPane_Beschreibung_Beschreibung.setEditable(false);
				}
				{
					jTextPane_Beschreibung_Enddatum = new JTextPane();
					jPanel_mainwindow.add(jTextPane_Beschreibung_Enddatum);
					jTextPane_Beschreibung_Enddatum.setText("Geben Sie hier das End-Datum ein, dieses ist f�r die Verf�gbarkeit des Fragebogens wichtig. Der Fragebogen ist bist zum End-Datum beantwortbar. Nach Ablauf des End-Datums wird die Verf�gbarkeit f�r den Fragebogen eingestellt.");
					jTextPane_Beschreibung_Enddatum.setBounds(13, 331, 296, 87);
					jTextPane_Beschreibung_Enddatum.setBackground(new java.awt.Color(236,236,223));
					jTextPane_Beschreibung_Enddatum.setFont(new java.awt.Font("Calibri",0,12));
					jTextPane_Beschreibung_Enddatum.setEditable(false);
				}
				{
					jButton_Erstellen = new JButton();
					jPanel_mainwindow.add(jButton_Erstellen);
					jButton_Erstellen.setText("erstellen");
					jButton_Erstellen.setBounds(188, 621, 117, 24);
					jButton_Erstellen.setFont(new java.awt.Font("Calibri",0,12));
					jButton_Erstellen.addActionListener(new ActionListener(){
					      public void actionPerformed(ActionEvent arg0) {				    	  
					    	  if(  !jTextField_fbTitel.getText().toString().equals("")
					    	     &&!jTextArea_fbBeschreibung.getText().toString().equals("")
					    	     &&jTextField_fbEndDatum.getDate() != null
					    	     &&!jTextField_Anzahl.getText().toString().equals( "" )){    			    		  
					    								    	
										try {
												//Endadatum zusammenst�ckeln 
												Date dt = jTextField_fbEndDatum.getDate();

												Date dt2 = new Date();//heutiges Datum f�r pr�fung ben�tigt
												SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");	
												sdf.format(dt); 	// ins Format dd.MM.yyyy bringen
												sdf.format(dt2);	// ins Format dd.MM.yyyy bringen
												//Pr�fen ob Datum g�ltig ist d.h. gr�sser als Heute
											    
												int check =dt2.compareTo(dt);
												/* int compareTo(another Date)
												 * Vergleicht zwei Datum-Objekte und gibt 0 zur�ck, 
												 * falls beide die gleiche Zeit repr�sentieren. 
												 * Der R�ckgabewert ist kleiner 0, falls das Datum des aufrufenden Exemplars
												 * vor dem Datum von anotherDate ist, sonst gr��er 0.
												 */
												
												if(check ==0 || check >0){
													throw new WrongDateException("Datum ist ung�ltig.");
												}
										    	//Enddatum setzten
										    	Fragebogen.getInstance().setEnddatum(dt);
										    	//Titel setzen
										    	Fragebogen.getInstance().setTitel(jTextField_fbTitel.getText().toString());
										    	
										    	//Beschreibung setzen
										    	Fragebogen.getInstance().setBeschreibung(jTextArea_fbBeschreibung.getText().toString());
										    	
							    	            //Anzahl der Befragten setzen
										    	int anz = Integer.parseInt(jTextField_Anzahl.getText().toString());
										    	Fragebogen.getInstance().setAnzahl(anz);
										    	
										    	//Fenster Schlie�en
							    	            dispose();
							    	            //Weiter zur n�chste Gui (Fragen hinzuf�gen)
							    	            @SuppressWarnings("unused")
												FbHinzufuegenGUI fbhgui= new FbHinzufuegenGUI();	
											} 
											catch (WrongDateException e) {
												JOptionPane.showMessageDialog(jPanel_mainwindow,
				  			                              "Ung�tliges Datum. Vergewissern Sie sich das das Enddatum gr�sser als das heutige ist.",
				  			                              "Error",
				  			                              JOptionPane.ERROR_MESSAGE) ;
											}
											catch(NumberFormatException e) {
												JOptionPane.showMessageDialog(jPanel_mainwindow,
				  			                              "Bitte nur Zahlen bei der Anzahl eingeben.",
				  			                              "Falsche Eingaben",
				  			                              JOptionPane.ERROR_MESSAGE) ;
											}
					    	  }//if zu
					    	  else{				    		  
					    		  String meldung="";					    		  
					    		  if(jTextField_fbTitel.getText().toString().equals(""))
					    			  meldung+=" -Titel\n";					    		  
					    		  if(jTextArea_fbBeschreibung.getText().toString().equals(""))
					    			  meldung+=" -Beschreibung\n";					    		  
					    		  if(jTextField_fbEndDatum.getDate() == null)
					    			  meldung+=" -EndDatum";					    		  
					    		  if(jTextField_Anzahl.getText().toString().equals(""))
					    			  meldung+=" -Anzahl der Teilnehmer";					    						    		  
					    		  JOptionPane.showMessageDialog(jPanel_mainwindow,
					  			                              "Bitte f�llen Sie alle Felder aus!\n" +
					  			                              "Sie haben folgende Felder nicht ausgef�llt: \n"+meldung,
					  			                              "Error",
					  			                              JOptionPane.ERROR_MESSAGE) ;
					    	  }		    	  
					      }
					});
				}
				{
					jTextPane_Beschreibung_Erstellen = new JTextPane();
					jPanel_mainwindow.add(jTextPane_Beschreibung_Erstellen);
					jTextPane_Beschreibung_Erstellen.setText("Um den Fragebogen mit den oben angef�hrten Daten zu erstellen klicken sie auf den Erstellen-Button.");
					jTextPane_Beschreibung_Erstellen.setBounds(16, 573, 322, 41);
					jTextPane_Beschreibung_Erstellen.setBackground(new java.awt.Color(236,236,223));
					jTextPane_Beschreibung_Erstellen.setEditable(false);
				}
				{
					jSeparator1 = new JSeparator();
					jPanel_mainwindow.add(jSeparator1);
					jSeparator1.setBounds(16, 149, 323, 10);
				}
				{
					jSeparator2 = new JSeparator();
					jPanel_mainwindow.add(jSeparator2);
					jSeparator2.setBounds(18, 321, 320, 10);
				}
				{
					jSeparator3 = new JSeparator();
					jPanel_mainwindow.add(jSeparator3);
					jSeparator3.setBounds(16, 452, 315, 9);
				}
				{
					jTextPane1 = new JTextPane();
					jPanel_mainwindow.add(jTextPane1);
					jTextPane1.setText("Geben Sie hier die Anzahl der zu befragenden Personen ein, diese ist wichtig f�r die TAN-Generierung!");
					jTextPane1.setEditable(false);
					jTextPane1.setBackground(new java.awt.Color(236,236,223));
					jTextPane1.setBounds(16, 461, 322, 41);
				}
				{
					jLabel1 = new JLabel();
					jPanel_mainwindow.add(jLabel1);
					jLabel1.setText("Anzahl:");
					jLabel1.setBackground(new java.awt.Color(236,236,223));
					jLabel1.setBounds(16, 508, 86, 16);
				}
				{
					jTextField_Anzahl = new JTextField();
					jPanel_mainwindow.add(jTextField_Anzahl);
					jTextField_Anzahl.setBounds(102, 505, 153, 19);
					jTextField_Anzahl.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
				}
				{
					jSeparator4 = new JSeparator();
					jPanel_mainwindow.add(jSeparator4);
					jSeparator4.setBounds(16, 552, 315, 15);
				}
				{
					jLabel_logo = new JLabel();
					jPanel_mainwindow.add(jLabel_logo);
					File f = new File("C:\\Programme\\Meinungsforschung\\Bilder\\logo.jpg"); 
					if(f.exists()){
						jLabel_logo.setIcon(new ImageIcon("C:\\Programme\\Meinungsforschung\\Bilder\\logo.jpg"));
					}
					else{
						jLabel_logo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("good_userinterface/ds/logo.jpg")));
					}
					jLabel_logo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("good_userinterface/ds/logo.jpg")));
					jLabel_logo.setBounds(279, -4, 80, 106);
				}
				{
					jTextField_fbEndDatum = new JXDatePicker();
					jTextField_fbEndDatum.setFormats(new String[] {"EEEE dd.MM.yyyy"});
					jTextField_fbEndDatum.setLinkDate(System.currentTimeMillis(),
			            "Heute ist der {0,date}");
					jTextField_fbEndDatum.getMonthView().setFirstDayOfWeek(Calendar.MONDAY);
					jTextField_fbEndDatum.getMonthView().setDayForeground(Calendar.SUNDAY, Color.RED);
					jTextField_fbEndDatum.getMonthView().setDaysOfTheWeek(
			            new String[]{"S", "M", "D", "M", "D", "F", "S"});
					jPanel_mainwindow.add(jTextField_fbEndDatum);
					jTextField_fbEndDatum.setBounds(100, 428, 155, 20);
		         }
				 {
					 b_zurueck = new JButton();
					 jPanel_mainwindow.add(b_zurueck);
					 b_zurueck.setText("Zur�ck zum Men�");
					 b_zurueck.setBounds(33, 620, 117, 23);
					 final JFrame thisWindow = this;
					 b_zurueck.addActionListener(new ActionListener() {
						 public void actionPerformed(ActionEvent evt) {
							 Menue menue = new Menue ();
							 thisWindow.dispose();
                             menue.setLocationRelativeTo(null);
                             menue.setVisible(true);
						 }
					 });
				}
			}
			pack();
			this.setSize(376, 689);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
