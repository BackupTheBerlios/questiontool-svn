package userinterface;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.SwingUtilities;


// TODO: Auto-generated Javadoc
/**
 * The Class FbRadioFrage.
 */
@SuppressWarnings("serial")
public class FbRadioFrage extends javax.swing.JFrame {
	
	/** The j panel_mainpanel. */
	private JPanel jPanel_mainpanel;
	
	/** The j label_ vorschau. */
	private JLabel jLabel_Vorschau;
	
	/** The j scroll pane1. */
	private JScrollPane jScrollPane1;
	
	/** The j text pane_ frageeingabe. */
	private JTextPane jTextPane_Frageeingabe;
	
	/** The j text pane_ frage vorschau. */
	public JTextPane jTextPane_FrageVorschau;
	
	/** The j button_ frageinkl antworten erstellen. */
	private JButton jButton_FrageinklAntwortenErstellen;
	
	/** The j button_ radio button loeschen. */
	private JButton jButton_RadioButtonLoeschen;
	
	/** The j panel1. */
	public JPanel jPanel1;
	
	/** The j label_meldung. */
	private JLabel jLabel_meldung;
	
	/** The j button_ antwort hinzufuegen. */
	private JButton jButton_AntwortHinzufuegen;
	
	/** The j text field_ antwort hinzufuegen. */
	private JTextField jTextField_AntwortHinzufuegen;
	
	/** The j button_ frage hinzufuegen. */
	private JButton jButton_FrageHinzufuegen;
	
	/** The j panel_ fragenund antworten hinzufuegen. */
	private JPanel jPanel_FragenundAntwortenHinzufuegen;
	
	/** The j label_ antwort hinzufuegen. */
	private JLabel jLabel_AntwortHinzufuegen;
	
	/** The j scroll pane_ frage hinzufuegen. */
	private JScrollPane jScrollPane_FrageHinzufuegen;
	
	/** The j label_ frage hinzufuegen. */
	private JLabel jLabel_FrageHinzufuegen;
	
	/** The j label_ antwortenund fragen hinzufuegen. */
	private JLabel jLabel_AntwortenundFragenHinzufuegen;
	
	/** The j button_ frage loeschen. */
	private JButton jButton_FrageLoeschen;
	
	/** The j scroll pane_ fragevorschau. */
	private JScrollPane jScrollPane_Fragevorschau;
	
	/** The j panel_vorschau. */
	private JPanel jPanel_vorschau;
	
	/** The j text pane_ beschreibung_ beschreibung. */
	private JTextPane jTextPane_Beschreibung_Beschreibung;
	
	/** The antworten. */
	public ArrayList<String> antworten;
	
	/** The buttongroup. */
	public ButtonGroup buttongroup;
	
	/** The buttons. */
	public List<JRadioButton> buttons;
	
	/** The frage. */
	public String frage;


	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * Auto-generated main method to display this JFrame.
	 * 
	 * @param args the args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FbRadioFrage inst = new FbRadioFrage();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	/**
	 * Instantiates a new fb radio frage.
	 */
	public FbRadioFrage() {
		super();
		initGUI();
		this.setTitle( "RadioButton Frage" );
		antworten = new ArrayList<String>();
		buttongroup = new ButtonGroup();
		buttons = new ArrayList< JRadioButton >();
	}
	
	/**
	 * Inits the gui.
	 */
	private void initGUI() {
		WindowListener windowListener;
		windowListener = new WindowAdapter(){

			@Override
			public void windowClosing(WindowEvent arg0) 
			{
				FbHinzufuegen.gibGUI().button1.setEnabled(true);
				super.windowClosing(arg0);
			}};
		this.addWindowListener(windowListener);
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
					jTextPane_Beschreibung_Beschreibung.setText("Hier sehen Sie die Vorschau der Frage, welche Sie hier erstellen. Die Erstellung der Frage bestätigen Sie anschließend mit dem Button \"Frage inkl. Antworten Erstellen\".");
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
						jButton_FrageLoeschen.setText("löschen");
						jButton_FrageLoeschen.setBounds(343, 12, 77, 43);
						jButton_FrageLoeschen.addActionListener(new ActionListener(){
						      public void actionPerformed(ActionEvent arg0) {
						    	  if(!jTextPane_FrageVorschau.getText().isEmpty()){
						    		  jTextPane_FrageVorschau.setText( "" );
						    		  frage ="";
						    	  }
						    	  else{
						    		  JOptionPane.showMessageDialog(jPanel_mainpanel,
							  			                              "Es ist keine Frage vorhanden zum Löschen",
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
						jButton_RadioButtonLoeschen = new JButton();
						jPanel_vorschau.add(jButton_RadioButtonLoeschen);
						jButton_RadioButtonLoeschen.setText("löschen");
						jButton_RadioButtonLoeschen.setBounds(343, 66, 77, 25);
						jButton_RadioButtonLoeschen.addActionListener(new ActionListener(){
						      public void actionPerformed(ActionEvent arg0) {
						    	  if(antworten.size()>0){
						    		 //System.out.println(buttongroup.getButtonCount());
						    		 
						    		  try{
						    			  
						    			  ButtonModel buttonmodel = buttongroup.getSelection();
							    		  String auswahl = buttonmodel.getActionCommand();
							    		  antworten.remove( Integer.parseInt( auswahl ) );
						    			  
						    			  if(!buttons.isEmpty()){
							    			  for(int i=0; i<buttons.size();i++)
							    				  buttons.remove( i );
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
							    			  JRadioButton b= new JRadioButton(s);
							    			  jPanel1.add( b );
							    			  b.setActionCommand(""+i);
							    			  b.setBounds( 11, y, 93, 23 );
							    			  y+=25;
							    			  buttons.add( b );
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
							  			                              "Sie haben keine Frage ausgewählt",
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
						      public void actionPerformed(ActionEvent arg0) 
						      {
						    	  if(frage!=null&&antworten!=null)
						    	  {
						    		  setAlwaysOnTop(false);
						    		  boolean vorhanden = FbHinzufuegen.gibGUI().hinzufuegenInTable(frage, antworten);
						    		  if(vorhanden==false)
						    		  {
						    			  FbHinzufuegen.gibGUI().button1.setEnabled(true);
						    			  dispose();
						    		  }
						    		  setAlwaysOnTop(true);
						    	  }
						    	  else
						    	  {
						    		  JOptionPane.showMessageDialog(jPanel_mainpanel, 
						    					"Bitte fügen Sie eine Frage und Antworten ein!",
						    					"Achtung", 
						    			JOptionPane.INFORMATION_MESSAGE);
						    	  }
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
						jButton_FrageHinzufuegen.setText("Frage Hinzufügen");
						jButton_FrageHinzufuegen.setBounds(75, 66, 201, 23);
						jButton_FrageHinzufuegen.addActionListener(new ActionListener(){
						      public void actionPerformed(ActionEvent arg0) {
						    	  if(!jTextPane_Frageeingabe.getText().isEmpty()){
						    		  jTextPane_FrageVorschau.setText(jTextPane_Frageeingabe.getText());
						    		  jLabel_meldung.setText( "Frage erfolgreich hinzugefügt" );
						    		  frage=jTextPane_Frageeingabe.getText();
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
						jButton_AntwortHinzufuegen.setText("Antwort Hinzufügen");
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
						    		  
						    		  if(!buttons.isEmpty()){
						    			  for(int i=0; i<buttons.size();i++)
						    				  buttons.remove( i );
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
						    			  JRadioButton b= new JRadioButton(s);
						    			  jPanel1.add( b );
						    			  b.setActionCommand(""+i);
						    			  b.setBounds( 11, y, 93, 23 );
						    			  y+=25;
						    			  buttons.add( b );
						    			  
						    			  buttongroup.add( b );
						    			  
						    			  i++;
						    		  }
						    		  
						    
						    		  jLabel_meldung.setText( "Antwort erfolgreich hinzugefügt" );
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
					jLabel_AntwortenundFragenHinzufuegen.setText("Antworten und Fragen Hinzufügen");
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
