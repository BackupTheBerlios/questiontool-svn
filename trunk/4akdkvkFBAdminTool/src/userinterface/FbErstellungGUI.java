package userinterface;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import fragen.*;

/**
 * This was not edited by Jigloo ;D
 * @author 
 *
 */
public class FbErstellungGUI extends javax.swing.JFrame {

	/**
     * 
     */
    private static final long serialVersionUID = 1L;

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	

	
	private JPanel jPanel_mainwindow;
	private JLabel jLabel_titel_FragebogenErstellung;
	private JTextArea jTextArea_fbBeschreibung;
	private JScrollPane jScrollPane_fbBeschreibung;
	private JLabel jLabel_fbEndDatum;
	private JButton jButton_Erstellen;
	private JLabel jLabel_logo;
	private JSeparator jSeparator3;
	private JSeparator jSeparator2;
	private JSeparator jSeparator1;
	private JTextPane jTextPane_Beschreibung_Erstellen;
	private JTextPane jTextPane_Beschreibung_Enddatum;
	private JTextPane jTextPane_Beschreibung_Beschreibung;
	private JTextPane jTextPane_Titel_Beschreibung;
	private JTextField jTextField_fbEndDatum;
	private JLabel jLabel_fbBeschreibung;
	private JTextField jTextField_fbTitel;
	private JLabel jLabel_Fragebogen_Titel;

	/**
	* Auto-generated main method to display this JFrame
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

	public FbErstellungGUI() {
		super();
		initGUI();
	}
	
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
					jTextPane_Titel_Beschreibung.setText("Geben Sie hier den Titel des Fragebogens ein. Dieser repräsentiert den Fragebogen. Dieser sollte für nachfolgende Arbeiten aussagekräftig sein.");
					jTextPane_Titel_Beschreibung.setBounds(13, 58, 296, 54);
					jTextPane_Titel_Beschreibung.setBackground(new java.awt.Color(236,236,223));
					jTextPane_Titel_Beschreibung.setFont(new java.awt.Font("Calibri",0,12));
					jTextPane_Titel_Beschreibung.setEditable(false);
				}
				{
					jTextPane_Beschreibung_Beschreibung = new JTextPane();
					jPanel_mainwindow.add(jTextPane_Beschreibung_Beschreibung);
					jTextPane_Beschreibung_Beschreibung.setText("Geben Sie hier eine kurze Beschreibung, diese ist beliebig zu gestalten, da diese nur für den Benutzer eine kurze Beschreibung bietet.");
					jTextPane_Beschreibung_Beschreibung.setBounds(13, 163, 296, 52);
					jTextPane_Beschreibung_Beschreibung.setBackground(new java.awt.Color(236,236,223));
					jTextPane_Beschreibung_Beschreibung.setFont(new java.awt.Font("Calibri",0,12));
					jTextPane_Beschreibung_Beschreibung.setEditable(false);
				}
				{
					jTextPane_Beschreibung_Enddatum = new JTextPane();
					jPanel_mainwindow.add(jTextPane_Beschreibung_Enddatum);
					jTextPane_Beschreibung_Enddatum.setText("Geben Sie hier das End-Datum ein, dieses ist für die Verfügbarkeit des Fragebogens wichtig. Der Fragebogen ist bist zum End-Datum beantwortbar. Nach Ablauf des End-Datums wird die Verfügbarkeit für den Fragebogen eingestellt.");
					jTextPane_Beschreibung_Enddatum.setBounds(13, 331, 296, 87);
					jTextPane_Beschreibung_Enddatum.setBackground(new java.awt.Color(236,236,223));
					jTextPane_Beschreibung_Enddatum.setFont(new java.awt.Font("Calibri",0,12));
					jTextPane_Beschreibung_Enddatum.setEditable(false);
				}
				{
					jButton_Erstellen = new JButton();
					jPanel_mainwindow.add(jButton_Erstellen);
					jButton_Erstellen.setText("erstellen");
					jButton_Erstellen.setBounds(122, 509, 92, 26);
					jButton_Erstellen.setFont(new java.awt.Font("Calibri",0,12));
					jButton_Erstellen.addActionListener(new ActionListener(){
					      public void actionPerformed(ActionEvent arg0) {
					    	  //jTextField_fbTitel;
					    	//jTextArea_fbBeschreibung
					    	  //jTextField_fbEndDatum
					    	  
					    	  if(  !jTextField_fbTitel.getText().toString().equals("")
					    	     &&!jTextArea_fbBeschreibung.getText().toString().equals("")
					    	     &&!jTextField_fbEndDatum.getText().toString().equals("")){
					    		  
					    		  
					    		  //int date  = 1; 
					    		  //int month = Calendar.JANUARY; 
					    		  //int year  = 1900; 
					    		  //long ms   = new GregorianCalendar( year, month, date ).getTimeInMillis(); 
					    		  //long days = (System.currentTimeMillis() – ms) / (1000*60*60*24); 
					    		  //System.out.println( days );      
					    		  
					    		   
					    		  
					    		  String[] datum = jTextField_fbEndDatum.getText().toString().split("\\p{Punct}");
					    		  System.out.println(jTextField_fbEndDatum.getText().toString());
					    		  for(int i=0;i<datum.length;i++){
					    			  System.out.println(datum[i].toString());
					    		  }
					    		  int day = Integer.valueOf(datum[0]);
					    		  int month = Integer.valueOf(datum[1]);
					    		  int year = Integer.valueOf(datum[2]);
					    		  
					    		  
					    		  try {
					    	            GregorianCalendar gc = new GregorianCalendar();
					    	            gc.setLenient(false);        // must do this
					    	            gc.set(GregorianCalendar.YEAR, year);
					    	            gc.set(GregorianCalendar.MONTH, month);// invalid month
					    	            gc.set(GregorianCalendar.DATE, day);
					    	            gc.getTime(); // exception thrown here
					    	            
					    	            //Hier kommt das Weiterleiten!!!!!!
					    	            
					    	            
					    	            Fragebogen.getInstance().setTitel(jTextField_fbTitel.getText().toString());
					    	            Fragebogen.getInstance().setBeschreibung(jTextArea_fbBeschreibung.getText().toString());
					    	           // Fragebogen.getInstance().setEnddatum(gc);

					    	        }
					    	        catch (Exception e) {
					    	        	JOptionPane.showMessageDialog(jPanel_mainwindow,
							  			                              "Datum existiert nicht, vergewissern Sie sich ob es ein richtiges Datum ist",
							  			                              "Error",
							  			                              JOptionPane.ERROR_MESSAGE) ;
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
					    		  
					    		  
					    		  System.out.println("hehehe");
					    		  JOptionPane.showMessageDialog(jPanel_mainwindow,
					  			                              "Bitte füllen Sie alle Felder aus!\n" +
					  			                              "Sie haben folgende Felder nicht ausgefüllt: \n"+meldung,
					  			                              "Error",
					  			                              JOptionPane.ERROR_MESSAGE) ;
					    	  }
					    	  
					    	  
					      }
					});

				}
				{
					jTextPane_Beschreibung_Erstellen = new JTextPane();
					jPanel_mainwindow.add(jTextPane_Beschreibung_Erstellen);
					jTextPane_Beschreibung_Erstellen.setText("Um den Fragebogen mit den oben angeführten Daten zu erstellen klicken sie auf den Erstellen-Button.");
					jTextPane_Beschreibung_Erstellen.setBounds(16, 467, 322, 41);
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
					jLabel_logo = new JLabel();
					jPanel_mainwindow.add(jLabel_logo);
					jLabel_logo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("UserInterface/logo.jpg")));
					jLabel_logo.setBounds(279, -4, 80, 106);
				}
			}
			pack();
			this.setSize(376, 583);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
