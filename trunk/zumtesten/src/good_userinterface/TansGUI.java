package good_userinterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

import printer.SimpleFilePrinter;

import db.DBReader;


/**
 * Klasse ist ein JFrame und ermöglicht den Benutzer Tans zu Drucken.
 * Werden für das Einloggen bei der Auswertung benötigt.
 * Vorgang dauert aber ein bisschen. Hinweis ist vorgegeben.
 * Alle Frageboegen werden hier angezeigt nur von dem gewählten wird gedruckt.
 * @author Bennersdorfer Dominik
 *
 */
@SuppressWarnings("serial")
public class TansGUI extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JPanel jPanel1;
	private JButton jButton_Drucken;
	private JList jList_Frageboegen;
	private JButton b_zurueck;
	private JLabel jLabel_Drucken;
	private JTextPane jTextPane_info;

	/**
	 * Standard Konstruktor der Klasse erzeugt das JFrame
	 */
	public TansGUI() {
		super("Tans Drucken");
		initGUI();
	}
	
	/**
	 * Initialisierungsmethode baut die Komplette Gui auf wird im Konstruktur aufgerufen
	 */
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			setResizable(false);
			setBackground(new java.awt.Color(236,236,223));
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1);
				jPanel1.setBounds(0, 0, 364, 273);
				jPanel1.setLayout(null);
				jPanel1.setBackground(new java.awt.Color(236,236,223));
				jPanel1.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
				{
					jButton_Drucken = new JButton();
					jPanel1.add(jButton_Drucken);
					jButton_Drucken.setText("Drucken");
					jButton_Drucken.setBounds(201, 157, 141, 23);
					jButton_Drucken.addActionListener(new ActionListener() {
						@SuppressWarnings("static-access")
						public void actionPerformed(ActionEvent e) {
							int value = -1 ;
							value = jList_Frageboegen.getSelectedIndex();
							if (value == -1){
								JOptionPane.showMessageDialog(null, "Bitte wählen Sie zuerst einen Fragebogen aus!",
										"Keine Auswahl vorgenommen", JOptionPane.INFORMATION_MESSAGE);
							}
							else {
								value++;
								ArrayList<String> tans = getTans(value);
								String fbname = getFbname(value);
								SimpleFilePrinter sfp = new SimpleFilePrinter(tans,fbname);
								if (sfp.setupPageFormat()) {
								     if (sfp.setupJobOptions()) {
								       try {
								         sfp.printFile();
								         meldung();
								       }
								       catch (Exception ex) {
								    	   	ex.printStackTrace();
								       }//catch zu
								     }//inneres if zu
								   }//äußeres if zu
							}//else zu
						}//action performed zu
					});//action Listener zu
				}//Bereischabschnitt zu
				{
					JScrollPane jScrollPane1 = new JScrollPane();
					jPanel1.add(jScrollPane1);
					{
						jScrollPane1.setBounds(35, 58, 156, 161);
						Object []fbs = getFbs();
						ListModel jList_FrageboegenModel = new DefaultComboBoxModel(fbs);
						jList_Frageboegen = new JList();
						jList_Frageboegen.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						jList_Frageboegen.setModel(jList_FrageboegenModel);
						jList_Frageboegen.setFont(new java.awt.Font("Calibri",0,12));
						jList_Frageboegen.setBounds(35, 58, 160, 161);
						jScrollPane1.setViewportView(jList_Frageboegen);
					}
				}
				{
					jTextPane_info = new JTextPane();
					jPanel1.add(jTextPane_info);
					jTextPane_info.setText("Suchen Sie sich einen Fragebogen aus und Klicken sie auf \"Drucken\". Der Vorgang nimmt ein bisschen Zeit in Anspruch.");
					jTextPane_info.setBackground(new java.awt.Color(236,236,223));
					jTextPane_info.setFont(new java.awt.Font("Calibri",0,12));
					jTextPane_info.setEditable(false);
					jTextPane_info.setBounds(201, 58, 154, 128);
				}
				{
					jLabel_Drucken = new JLabel();
					jPanel1.add(jLabel_Drucken);
					jLabel_Drucken.setText("Tans Drucken");
					jLabel_Drucken.setBounds(130, 12, 144, 27);
					jLabel_Drucken.setFont(new java.awt.Font("Calibri",1,20));
				}
				{
					b_zurueck = new JButton();
					jPanel1.add(b_zurueck);
					b_zurueck.setText("Zurück zum Menü");
					b_zurueck.setBounds(201, 191, 141, 23);
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
			} //Bereichsabschnitt zu
			pack();
			this.setSize(364, 265);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Mehtode hohl alle Fragebogen namen und gibt sie zurück
	 * @return namen Object[]
	 */
	private Object[] getFbs() {
		ArrayList<String> fbs = DBReader.getFbNamen();
		Object[] namen = fbs.toArray();
		return namen;
	}
	
	/**
	 * Methode hohlt alls Tans eines Fragebogens anhand seiner ID.
	 * @param fid int 
	 * @return tans ArrayList<String>
	 */
	private ArrayList<String> getTans(int fid) {
		ArrayList<String> tans = DBReader.getTans(fid);
		return tans;
	}

	/**
	 * Methode hohlt einen Fragebogen namen anhand eines Values(int)(FragebogenID)
	 * @param value int fragebogen id automatisch berechnet
	 * @return fragebogenname String
	 */
	private String getFbname(int value) {
		String fragebogenname = DBReader.getFbName(value);
		return fragebogenname;
	}
	
	/**
	 * Methode gibt eine Meldung in Form von JOption Pane aus
	 * wird aufgerufen nachdem man Tans gedruckt hat
	 */
	private void meldung(){
	    Object[] options = {"Weitere Tans Drucken","Zurück ins Menü"};
	    int n = JOptionPane.showOptionDialog(this,
	    		"Ihre Tans wurden gedruckt.",
	    		"Drucken erfolgreich",
	    		JOptionPane.YES_NO_OPTION,
	    		JOptionPane.QUESTION_MESSAGE,
	    		null,     //do not use a custom Icon
	    		options,  //the titles of buttons
	    		options[0]); //default button title
	    if(n==0){
	    	//weitere Tans drucken
	    }
	    else{
	    	  final JFrame thisWindow2 = this;
              Menue menue = new Menue ();
              thisWindow2.dispose();
              menue.setLocationRelativeTo(null);
              menue.setVisible(true);
	    }
	}
}