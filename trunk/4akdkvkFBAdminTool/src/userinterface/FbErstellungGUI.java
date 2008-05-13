package userinterface;

import interfaceGuiDb.SchnittstelleFBzuDB;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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
import javax.swing.SwingUtilities;

import db.DbWriter;

import fragen.*;

// TODO: Auto-generated Javadoc
/**
 * The Class FbErstellungGUI.
 */
public class FbErstellungGUI extends javax.swing.JFrame {

	/** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

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
	
	/** The j text field_fb end datum. */
	private JTextField jTextField_fbEndDatum;
	
	/** The j label_fb beschreibung. */
	private JLabel jLabel_fbBeschreibung;
	
	/** The j text field_fb titel. */
	private JTextField jTextField_fbTitel;
	
	/** The j label_ fragebogen_ titel. */
	private JLabel jLabel_Fragebogen_Titel;

	/**
	 * Auto-generated main method to display this JFrame.
	 * 
	 * @param args the args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FbErstellungGUI inst = new FbErstellungGUI();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
				inst.setTitle("Fragebogen-Erstellung");
				inst.setResizable(false);
			}
		});
	}

	/**
	 * Instantiates a new fb erstellung gui.
	 */
	public FbErstellungGUI() {
		super();
		initGUI();
	}
	
	/**
	 * Inits the gui.
	 */
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
					jTextField_fbEndDatum = new JTextField();
					jPanel_mainwindow.add(jTextField_fbEndDatum);
					jTextField_fbEndDatum.setBounds(102, 424, 80, 22);
					jTextField_fbEndDatum.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
				}
				{
					jTextPane_Titel_Beschreibung = new JTextPane();
					jPanel_mainwindow.add(jTextPane_Titel_Beschreibung);
					jTextPane_Titel_Beschreibung.setText("Geben Sie hier den Titel des Fragebogens ein. Dieser repr‰sentiert den Fragebogen. Dieser sollte f¸r nachfolgende Arbeiten aussagekr‰ftig sein.");
					jTextPane_Titel_Beschreibung.setBounds(13, 58, 296, 54);
					jTextPane_Titel_Beschreibung.setBackground(new java.awt.Color(236,236,223));
					jTextPane_Titel_Beschreibung.setFont(new java.awt.Font("Calibri",0,12));
					jTextPane_Titel_Beschreibung.setEditable(false);
				}
				{
					jTextPane_Beschreibung_Beschreibung = new JTextPane();
					jPanel_mainwindow.add(jTextPane_Beschreibung_Beschreibung);
					jTextPane_Beschreibung_Beschreibung.setText("Geben Sie hier eine kurze Beschreibung, diese ist beliebig zu gestalten, da diese nur f¸r den Benutzer eine kurze Beschreibung bietet.");
					jTextPane_Beschreibung_Beschreibung.setBounds(13, 163, 296, 52);
					jTextPane_Beschreibung_Beschreibung.setBackground(new java.awt.Color(236,236,223));
					jTextPane_Beschreibung_Beschreibung.setFont(new java.awt.Font("Calibri",0,12));
					jTextPane_Beschreibung_Beschreibung.setEditable(false);
				}
				{
					jTextPane_Beschreibung_Enddatum = new JTextPane();
					jPanel_mainwindow.add(jTextPane_Beschreibung_Enddatum);
					jTextPane_Beschreibung_Enddatum.setText("Geben Sie hier das End-Datum ein, dieses ist f¸r die Verf¸gbarkeit des Fragebogens wichtig. Der Fragebogen ist bist zum End-Datum beantwortbar. Nach Ablauf des End-Datums wird die Verf¸gbarkeit f¸r den Fragebogen eingestellt.");
					jTextPane_Beschreibung_Enddatum.setBounds(13, 331, 296, 87);
					jTextPane_Beschreibung_Enddatum.setBackground(new java.awt.Color(236,236,223));
					jTextPane_Beschreibung_Enddatum.setFont(new java.awt.Font("Calibri",0,12));
					jTextPane_Beschreibung_Enddatum.setEditable(false);
				}
				{
					jButton_Erstellen = new JButton();
					jPanel_mainwindow.add(jButton_Erstellen);
					jButton_Erstellen.setText("erstellen");
					jButton_Erstellen.setBounds(122, 615, 92, 26);
					jButton_Erstellen.setFont(new java.awt.Font("Calibri",0,12));
					jButton_Erstellen.addActionListener(new ActionListener(){
					      public void actionPerformed(ActionEvent arg0) {
					    	  //jTextField_fbTitel;
					    	//jTextArea_fbBeschreibung
					    	  //jTextField_fbEndDatum
					    	  
					    	  if(  !jTextField_fbTitel.getText().toString().equals("")
					    	     &&!jTextArea_fbBeschreibung.getText().toString().equals("")
					    	     &&!jTextField_fbEndDatum.getText().toString().equals("")
					    	     &&!jTextField_Anzahl.getText().toString().equals( "" )){
					    		  
					    		  
					    		  //int date  = 1; 
					    		  //int month = Calendar.JANUARY; 
					    		  //int year  = 1900; 
					    		  //long ms   = new GregorianCalendar( year, month, date ).getTimeInMillis(); 
					    		  //long days = (System.currentTimeMillis() ñ ms) / (1000*60*60*24); 
					    		  //System.out.println( days );      			    		  
					    		  
					    		  try {
					    			  String[] datum = jTextField_fbEndDatum.getText().toString().split("\\p{Punct}");
							    		//System.out.println(jTextField_fbEndDatum.getText().toString());
							    		 
							    		int day = Integer.valueOf(datum[0]);
							    		int month = Integer.valueOf(datum[1]);
							    		int year = Integer.valueOf(datum[2]);
					    	            GregorianCalendar gc = new GregorianCalendar();
					    	            gc.setLenient(false);        // must do this
					    	            gc.set(GregorianCalendar.YEAR, year);
					    	            gc.set(GregorianCalendar.MONTH, (month-1));// invalid month
					    	            //-1 muss man rechnen da bei 0 begonnen wird zu z‰hlen 
					    	            //d.h. Dezember = 11 =) (12-1)
					    	            gc.set(GregorianCalendar.DATE, day);
					    	            gc.getTime(); // exception thrown here
					    	            //Hier kommt das Weiterleiten!!!!!!
					    	            
					    	            //Test bemerkung "DATUM" --> 1999 und auch 99 geht bei Jahreszahl
					    	            Fragebogen.getInstance().setTitel(jTextField_fbTitel.getText().toString());
					    	            Fragebogen.getInstance().setBeschreibung(jTextArea_fbBeschreibung.getText().toString());
					    	            
					    	            String datezumabspeichern =day +"."+month+"."+year;
					    	            
					    	            SimpleDateFormat sdf = new SimpleDateFormat( "dd.mm.yyyy" );
					    	            Date dt = (Date) sdf.parse( datezumabspeichern );
					    	            //System.out.println(dt);					    	            
					    	            
					    	            Fragebogen.getInstance().setEnddatum(dt);
					    	            DbWriter.speichereFragebogen(Fragebogen.getInstance().getTitel(), 
					    	           	Fragebogen.getInstance().getBeschreibung(),
					    	           	Fragebogen.getInstance().getEnddatum());
					    	            
					    	            ArrayList<String> tans = new ArrayList<String>();
					    	            /*TAN: Xxxxx xxxx xx xx xx xx
					    	            * Ersten 5 Stellen -> Fragebogen ID
					    	            * N‰chsten 4 Stellen -> Benutzer IDs d.h. wenn den Fragebogen 30 Leute 
					    	            ausf¸llen sollen dann stehen da die Zahlen 0 bis 29
					    	            * N‰chsten 2 Stellen -> Tag (01 - 31)
					    	            * N‰chsten 2 Stellen -> Monat (01 ñ 12)
					    	            * N‰chsten 2 Stellen -> Jahreszahl (01 - 12)
					    	            * letzten beiden Stellen -> Als reserve, sollen standardm‰ﬂig mit 00 
					    	            */
					    	            
					    	            String id = ""+Fragebogen.getInstance().getId();
					    	            System.out.println(id);
					    	            int anzahl = Integer.valueOf(jTextField_Anzahl.getText());
					    	            String tag;
					    	            if(day<10)
					    	            	tag = "0"+day;
					    	            else
					    	            	tag =""+day;
					    	            String monat;
					    	            if(month<10)
					    	            	monat = "0"+month;
					    	            else
					    	            	monat =""+month;
					    	            String jahreszahl;
					    	            if(day<10)
					    	            	jahreszahl = "0"+year;
					    	            else
					    	            	jahreszahl =""+year;				    	            
					    	            String letzte2stellen="00";
					    	            String fragebogenID="";
					    	            String erste5Stellen ="";
					    	            int anzahlDerNullenInDerID =0;
					    	            anzahlDerNullenInDerID = 5-id.length();
				    	            	for(int j=0;j<anzahlDerNullenInDerID;j++)
				    	            		fragebogenID+="0";
				    	            	fragebogenID+=id;
				    	            	//Fragebogen Id an Konsole ausgeben
				    	            	//System.out.println(fragebogenID);				    	            	
				    	            	erste5Stellen += fragebogenID;					    	            
				    	            	String n‰chste4Stellen="";
					    	            for(int i=1;i<anzahl+1;i++){					    	            	
					    	            	if(i<10)
					    	            		n‰chste4Stellen="000";
					    	            	else{
					    	            		if(i<100)
						    	            		n‰chste4Stellen="00";
					    	            		else{
					    	            			if(i<1000)
							    	            		n‰chste4Stellen="0";
					    	            			else
							    	            		n‰chste4Stellen="";
					    	            		}    	
					    	            	}			    	            	
					    	            	n‰chste4Stellen+=""+i;
					    	            	tans.add( erste5Stellen+n‰chste4Stellen+tag+monat+jahreszahl+letzte2stellen);
					    	            	//Probeweise ausgeben auf konsole
					    	            	//System.out.println("Tan:"+erste5Stellen+n‰chste4Stellen+tag+monat+jahreszahl+letzte2stellen);
					    	            }
					    	            Fragebogen.getInstance().setTans( tans );
					    	            SchnittstelleFBzuDB.speicherFb();
					    	            JOptionPane.showMessageDialog(jPanel_mainwindow,
		  			                              "Fragebogen wurde erfolgreich erstellt. Sie kˆnnen nun Fragen zuordnen",
		  			                              "Erfolg",
		  			                              JOptionPane.INFORMATION_MESSAGE) ;	

					    	        }
					    	        catch (Exception e) {
					    	        	JOptionPane.showMessageDialog(jPanel_mainwindow,
							  			                              "Datum existiert nicht, vergewissern Sie sich ob es ein richtiges Datum ist, bzw. haben Sie keine korrekte Anzahl der Teilnehmer angegeben",
							  			                              "Error",
							  			                              JOptionPane.ERROR_MESSAGE) ;							  			                              
					    	        	e.printStackTrace() ;
					    	        }				    		  
					    	  }
					    	  else{
					    		  
					    		  String meldung="";					    		  
					    		  if(jTextField_fbTitel.getText().toString().equals(""))
					    			  meldung+=" -Titel\n";					    		  
					    		  if(jTextArea_fbBeschreibung.getText().toString().equals(""))
					    			  meldung+=" -Beschreibung\n";					    		  
					    		  if(jTextField_fbEndDatum.getText().toString().equals(""))
					    			  meldung+=" -EndDatum";					    		  
					    		  if(jTextField_Anzahl.getText().toString().equals(""))
					    			  meldung+=" -Anzahl der Teilnehmer";					    						    		  
					    		  //System.out.println("hehehe");
					    		  JOptionPane.showMessageDialog(jPanel_mainwindow,
					  			                              "Bitte f¸llen Sie alle Felder aus!\n" +
					  			                              "Sie haben folgende Felder nicht ausgef¸llt: \n"+meldung,
					  			                              "Error",
					  			                              JOptionPane.ERROR_MESSAGE) ;
					    	  }		    	  
					      }
					});
				}
				{
					jTextPane_Beschreibung_Erstellen = new JTextPane();
					jPanel_mainwindow.add(jTextPane_Beschreibung_Erstellen);
					jTextPane_Beschreibung_Erstellen.setText("Um den Fragebogen mit den oben angef¸hrten Daten zu erstellen klicken sie auf den Erstellen-Button.");
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
					jTextPane1.setText("Geben Sie hier die Anzahl der zu befragenden Personen ein, diese ist wichtig f¸r die TAN-Generierung!");
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
					jTextField_Anzahl.setBounds(102, 505, 80, 19);
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
					jLabel_logo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("UserInterface/logo.jpg")));
					jLabel_logo.setBounds(279, -4, 80, 106);
				}
			}
			pack();
			this.setSize(376, 689);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
