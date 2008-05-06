package userinterface;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.SwingUtilities;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
@SuppressWarnings("serial")
public class FbCheckBoxFrage extends javax.swing.JFrame {
	private JPanel jPanel_mainpanel;
	private JLabel jLabel_Vorschau;
	private JScrollPane jScrollPane1;
	private JTextPane jTextPane_Frageeingabe;
	private JTextPane jTextPane_FrageVorschau;
	private JButton jButton_FrageinklAntwortenErstellen;
	private JButton jButton_CheckBoxButtonLoeschen;
	private JPanel jPanel1;
	private JLabel jLabel_meldung;
	private JButton jButton_AntwortHinzufuegen;
	private JTextField jTextField_AntwortHinzufuegen;
	private JButton jButton_FrageHinzufuegen;
	private JPanel jPanel_FragenundAntwortenHinzufuegen;
	private JLabel jLabel_AntwortHinzufuegen;
	private JScrollPane jScrollPane_FrageHinzufuegen;
	private JLabel jLabel_FrageHinzufuegen;
	private JLabel jLabel_AntwortenundFragenHinzufuegen;
	private JButton jButton_FrageLoeschen;
	private JScrollPane jScrollPane_Fragevorschau;
	private JPanel jPanel_vorschau;
	private JTextPane jTextPane_Beschreibung_Beschreibung;
	private ArrayList<String> antworten;
	private String frage;
	private  ButtonGroup buttongroup;
	private List<JCheckBox> checkboxes;

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FbCheckBoxFrage inst = new FbCheckBoxFrage();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public FbCheckBoxFrage() {
		super();
		initGUI();
		this.setTitle( "Checkbox Frage" );
		antworten = new ArrayList<String>();
		buttongroup = new ButtonGroup();
		checkboxes = new ArrayList< JCheckBox >();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jPanel_mainpanel = new JPanel();
				getContentPane().add(jPanel_mainpanel, BorderLayout.CENTER);
				jPanel_mainpanel.setLayout(null);
				jPanel_mainpanel.setPreferredSize(new java.awt.Dimension(452, 485));
				{
					jLabel_Vorschau = new JLabel();
					jPanel_mainpanel.add(jLabel_Vorschau);
					jLabel_Vorschau.setText("Vorschau:");
					jLabel_Vorschau.setBounds(10, 11, 82, 14);
				}
				{
					jTextPane_Beschreibung_Beschreibung = new JTextPane();
					jPanel_mainpanel.add(jTextPane_Beschreibung_Beschreibung);
					jTextPane_Beschreibung_Beschreibung.setText("Hier sehen Sie die Vorschau der Frage, welche Sie hier erstellen. Die Erstellung der Frage best�tigen Sie anschlie�end mit dem Button \"Frage inkl. Antworten Erstellen\".");
					jTextPane_Beschreibung_Beschreibung.setBackground(new java.awt.Color(236,236,223));
					jTextPane_Beschreibung_Beschreibung.setFont(new java.awt.Font("Calibri",0,12));
					jTextPane_Beschreibung_Beschreibung.setBounds(10, 31, 431, 59);
					jTextPane_Beschreibung_Beschreibung.setEditable(false);
				}
				{
					jPanel_vorschau = new JPanel();
					jPanel_mainpanel.add(jPanel_vorschau);
					jPanel_vorschau.setBounds(10, 90, 431, 210);
					jPanel_vorschau.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
					jPanel_vorschau.setLayout(null);
					{
						jScrollPane_Fragevorschau = new JScrollPane();
						jPanel_vorschau.add(jScrollPane_Fragevorschau);
						jScrollPane_Fragevorschau.setBounds(11, 12, 322, 43);
						jScrollPane_Fragevorschau.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
						{
							jTextPane_FrageVorschau = new JTextPane();
							jScrollPane_Fragevorschau.setViewportView(jTextPane_FrageVorschau);
						}
					}
					{
						jButton_FrageLoeschen = new JButton();
						jPanel_vorschau.add(jButton_FrageLoeschen);
						jButton_FrageLoeschen.setText("l�schen");
						jButton_FrageLoeschen.setBounds(343, 12, 77, 43);
						jButton_FrageLoeschen.addActionListener(new ActionListener(){
						      public void actionPerformed(ActionEvent arg0) {
						    	  if(!jTextPane_FrageVorschau.getText().isEmpty()){
						    		  jTextPane_FrageVorschau.setText( "" );
						    		  frage ="";
						    	  }
						    	  else{
						    		  JOptionPane.showMessageDialog(jPanel_mainpanel,
							  			                              "Es ist keine Frage vorhanden zum L�schen",
							  			                              "Error",
							  			                              JOptionPane.ERROR_MESSAGE) ; 
						    	  }
						    	  
						      }
						});
					}
					{
						jScrollPane1 = new JScrollPane();
						jPanel_vorschau.add(jScrollPane1);
						jScrollPane1.setBounds(11, 66, 322, 110);
						{
							jPanel1 = new JPanel();
							jScrollPane1.setViewportView(jPanel1);
							jPanel1.setPreferredSize(new java.awt.Dimension(237, 300));
							jPanel1.setLayout(null);
						}
					}
					{
						jButton_CheckBoxButtonLoeschen = new JButton();
						jPanel_vorschau.add(jButton_CheckBoxButtonLoeschen);
						jButton_CheckBoxButtonLoeschen.setText("l�schen");
						jButton_CheckBoxButtonLoeschen.setBounds(343, 66, 77, 25);
						jButton_CheckBoxButtonLoeschen.addActionListener(new ActionListener(){
						      public void actionPerformed(ActionEvent arg0) {
						    	  if(antworten.size()>0){
						    		 //System.out.println(buttongroup.getButtonCount());
						    		 
						    		  try{
						    			  
						    			  ButtonModel buttonmodel = buttongroup.getSelection();
							    		  String auswahl = buttonmodel.getActionCommand();
							    		  antworten.remove( Integer.parseInt( auswahl ) );
						    			  					    			  
						    			  if(!checkboxes.isEmpty()){
							    			  for(int i=0; i<checkboxes.size();i++)
							    				  checkboxes.remove( i );
							    		  }
							    		 
						    			  jPanel1 = new JPanel();
											jScrollPane1.setViewportView(jPanel1);
											jPanel1.setPreferredSize(new java.awt.Dimension(237, 300));
											jPanel1.setLayout(null);
							    		  //buttons = new ArrayList< JRadioButton >();
							    		  //int y=69;//immer +25
							    		  int y=9;
							    		  int i=0;
							    		  for(String s : antworten){
							    			  JCheckBox b= new JCheckBox(s);
							    			  jPanel1.add( b );
							    			  b.setActionCommand(""+i);
							    			  b.setBounds( 11, y, 93, 23 );
							    			  y+=25;
							    			  checkboxes.add( b );
							    			  buttongroup.add( b );
							    			  
							    			  i++;
							    		  }
						    		  }
						    		  catch(NullPointerException exc){
						    			  //dsdf
						    		  }
						    	  
						    	  }
						    	  else{
						    		  JOptionPane.showMessageDialog(jPanel_mainpanel,
							  			                              "Sie haben keine Frage ausgew�hlt",
							  			                              "Error",
							  			                              JOptionPane.ERROR_MESSAGE) ; 
						    	  }
						    	  
						      }
						});
						
					}
					{
						jButton_FrageinklAntwortenErstellen = new JButton();
						jPanel_vorschau.add(jButton_FrageinklAntwortenErstellen);
						jButton_FrageinklAntwortenErstellen.setText("Fragen inkl. Antworten erstellen");
						jButton_FrageinklAntwortenErstellen.setBounds(231, 182, 188, 21);
						jButton_FrageinklAntwortenErstellen.addActionListener(new ActionListener(){
						      public void actionPerformed(ActionEvent arg0) {
						      }
						});
					}
					{
						
					}
				}
				{
					jPanel_FragenundAntwortenHinzufuegen = new JPanel();
					jPanel_mainpanel.add(jPanel_FragenundAntwortenHinzufuegen);
					jPanel_FragenundAntwortenHinzufuegen.setBounds(10, 323, 429, 172);
					jPanel_FragenundAntwortenHinzufuegen.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
					jPanel_FragenundAntwortenHinzufuegen.setLayout(null);
					{
						jLabel_FrageHinzufuegen = new JLabel();
						jPanel_FragenundAntwortenHinzufuegen.add(jLabel_FrageHinzufuegen);
						jLabel_FrageHinzufuegen.setText("Frage:");
						jLabel_FrageHinzufuegen.setBounds(11, 12, 60, 14);
					}
					{
						jScrollPane_FrageHinzufuegen = new JScrollPane();
						jPanel_FragenundAntwortenHinzufuegen.add(jScrollPane_FrageHinzufuegen);
						jScrollPane_FrageHinzufuegen.setBounds(75, 12, 345, 48);
						jScrollPane_FrageHinzufuegen.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
						{
							jTextPane_Frageeingabe = new JTextPane();
							jScrollPane_FrageHinzufuegen.setViewportView(jTextPane_Frageeingabe);
						}
					}
					{
						jLabel_AntwortHinzufuegen = new JLabel();
						jPanel_FragenundAntwortenHinzufuegen.add(jLabel_AntwortHinzufuegen);
						jLabel_AntwortHinzufuegen.setText("Antwort:");
						jLabel_AntwortHinzufuegen.setBounds(11, 99, 64, 14);
					}
					{
						jButton_FrageHinzufuegen = new JButton();
						jPanel_FragenundAntwortenHinzufuegen.add(jButton_FrageHinzufuegen);
						jButton_FrageHinzufuegen.setText("Frage Hinzuf�gen");
						jButton_FrageHinzufuegen.setBounds(75, 66, 201, 23);
						jButton_FrageHinzufuegen.addActionListener(new ActionListener(){
						      public void actionPerformed(ActionEvent arg0) {
						    	  if(!jTextPane_Frageeingabe.getText().isEmpty()){
						    		  jTextPane_FrageVorschau.setText(jTextPane_Frageeingabe.getText());
						    		  jLabel_meldung.setText( "Frage erfolgreich hinzugef�gt" );
						    		  frage = jTextPane_Frageeingabe.getText();
						    		  jTextPane_Frageeingabe.setText("");
						    	  }
						    	  else{
						    		  JOptionPane.showMessageDialog(jPanel_mainpanel,
							  			                              "Sie haben keine Frage eingegeben",
							  			                              "Error",
							  			                              JOptionPane.ERROR_MESSAGE) ; 
						    	  }
						    	  
						      }
						});
					}
					{
						jTextField_AntwortHinzufuegen = new JTextField();
						jPanel_FragenundAntwortenHinzufuegen.add(jTextField_AntwortHinzufuegen);
						jTextField_AntwortHinzufuegen.setBounds(75, 96, 345, 20);
						jTextField_AntwortHinzufuegen.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
					}
					{
						jButton_AntwortHinzufuegen = new JButton();
						jPanel_FragenundAntwortenHinzufuegen.add(jButton_AntwortHinzufuegen);
						jButton_AntwortHinzufuegen.setText("Antwort Hinzuf�gen");
						jButton_AntwortHinzufuegen.setBounds(75, 122, 201, 21);
						jButton_AntwortHinzufuegen.addActionListener(new ActionListener(){
						      public void actionPerformed(ActionEvent arg0) {
						    	  if(!jTextField_AntwortHinzufuegen.getText().isEmpty()){
						    		  //jComboBox_vorschau.addItem(jTextField_AntwortHinzufuegene.getText());
						    		  
						    		  //jRadioButton1 = new JRadioButton();
									  //jPanel_vorschau.add(jRadioButton1);
									  //jRadioButton1.setText("jRadioButton1");
						    		  //jButton_FrageHinzufuegen.setBounds(75, 66, 201, 23);
						    		  //jTextField_AntwortHinzufuegen.setBounds(75, 96, 278, 20);
									  //jRadioButton1.setBounds(11, 69, 93, 23);
						    		  //public void setBounds(int x, int y, int width, int height);
						    		  //public void setBounds(Rectangle r);
						    		  
						    		  antworten.add(jTextField_AntwortHinzufuegen.getText());
						    		  
						    		  if(!checkboxes.isEmpty()){
						    			  for(int i=0; i<checkboxes.size();i++)
						    				  checkboxes.remove( i );
						    		  }
						    		 
						    		  jPanel1 = new JPanel();
										jScrollPane1.setViewportView(jPanel1);
										jPanel1.setPreferredSize(new java.awt.Dimension(237, 300));
										jPanel1.setLayout(null);
						    		  //buttons = new ArrayList< JRadioButton >();
						    		  //int y=69;//immer +25
						    		  int y=9;
						    		  int i=0;
						    		  for(String s : antworten){
						    			  JCheckBox b= new JCheckBox(s);
						    			  //jPanel1.add( b );
						    			  jPanel1.add( b );
						    			  b.setActionCommand(""+i);
						    			  b.setBounds( 11, y, 93, 23 );
						    			  y+=25;
						    			  checkboxes.add( b );
						    			  
						    			  buttongroup.add( b );
						    			  
						    			  i++;
						    		  }
						    		  
						    
						    		  jLabel_meldung.setText( "Antwort erfolgreich hinzugef�gt" );
						    		  jTextField_AntwortHinzufuegen.setText( "" );
						    	  }
						    	  else{
						    		  JOptionPane.showMessageDialog(jPanel_mainpanel,
							  			                              "Sie haben keine Antwort eingegeben",
							  			                              "Error",
							  			                              JOptionPane.ERROR_MESSAGE) ; 
						    	  }
						    	  
						      }
						});
					}
					{
						jLabel_meldung = new JLabel();
						jPanel_FragenundAntwortenHinzufuegen.add(jLabel_meldung);
						jLabel_meldung.setBounds(11, 154, 342, 14);
					}
				}
				{
					jLabel_AntwortenundFragenHinzufuegen = new JLabel();
					jPanel_mainpanel.add(jLabel_AntwortenundFragenHinzufuegen);
					jLabel_AntwortenundFragenHinzufuegen.setText("Antworten und Fragen Hinzuf�gen");
					jLabel_AntwortenundFragenHinzufuegen.setBounds(10, 300, 244, 19);
				}
			}
			pack();
			this.setSize(467, 545);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}