package userinterface;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.SwingUtilities;


// TODO: Auto-generated Javadoc
/**
 * The Class FbDropDownFrage.
 */
@SuppressWarnings("serial")
public class FbDropDownFrage extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/** The j panel_mainpanel. */
	private JPanel jPanel_mainpanel;
	
	/** The j label_ vorschau. */
	private JLabel jLabel_Vorschau;
	
	/** The j label_ frage_erstellen. */
	private JLabel jLabel_Frage_erstellen;
	
	/** The j text pane_ frageeingabe. */
	private JTextPane jTextPane_Frageeingabe;
	
	/** The j text pane_ frage vorschau. */
	public JTextPane jTextPane_FrageVorschau;
	
	/** The j button_ antwort löschen. */
	private JButton jButton_AntwortLöschen;
	
	/** The j button_ frage löschen. */
	private JButton jButton_FrageLöschen;
	
	/** The j label_meldung. */
	private JLabel jLabel_meldung;
	
	/** The j button_ frageinkl antworten erstellen. */
	private JButton jButton_FrageinklAntwortenErstellen;
	
	/** The j scroll pane_ fragevorschau. */
	private JScrollPane jScrollPane_Fragevorschau;
	
	/** The j button_ antwort hinzufuegen. */
	private JButton jButton_AntwortHinzufuegen;
	
	/** The j text field_ antwort eingabe. */
	private JTextField jTextField_AntwortEingabe;
	
	/** The j label_ antwort hinzufügen. */
	private JLabel jLabel_AntwortHinzufügen;
	
	/** The j button_ frage hinzufuegen. */
	private JButton jButton_FrageHinzufuegen;
	
	/** The j scroll pane_ frage erstellen. */
	private JScrollPane jScrollPane_FrageErstellen;
	
	/** The j label_ frageund antworten erstellen. */
	private JLabel jLabel_FrageundAntwortenErstellen;
	
	/** The j panel_ frage erstellen. */
	private JPanel jPanel_FrageErstellen;
	
	/** The j text pane_ beschreibung_ beschreibung. */
	private JTextPane jTextPane_Beschreibung_Beschreibung;
	
	/** The j combo box_vorschau. */
	public JComboBox jComboBox_vorschau;
	
	/** The j panel_vorschau. */
	private JPanel jPanel_vorschau;
	
	/** The frage. */
	public String frage;
	
	/** The antworten. */
	public ArrayList<String> antworten = new ArrayList<String>();


	/**
	 * Auto-generated main method to display this JFrame.
	 * 
	 * @param args the args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FbDropDownFrage inst = new FbDropDownFrage();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	/**
	 * Instantiates a new fb drop down frage.
	 */
	public FbDropDownFrage() {
		super();
		initGUI();
		this.setTitle("DropDown Frage");
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
				jPanel_mainpanel.setPreferredSize(new java.awt.Dimension(384, 482));
				{
					jLabel_Vorschau = new JLabel();
					jPanel_mainpanel.add(jLabel_Vorschau);
					jLabel_Vorschau.setText("Vorschau:");
					jLabel_Vorschau.setBounds(10, 11, 82, 14);
				}
				{
					jPanel_vorschau = new JPanel();
					jPanel_mainpanel.add(jPanel_vorschau);
					jPanel_vorschau.setBounds(10, 90, 395, 139);
					jPanel_vorschau.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
					jPanel_vorschau.setLayout(null);
					{
						ComboBoxModel jComboBox_vorschauModel = new DefaultComboBoxModel();
						jComboBox_vorschau = new JComboBox();
						jPanel_vorschau.add(jComboBox_vorschau);
						jComboBox_vorschau.setModel(jComboBox_vorschauModel);
						jComboBox_vorschau.setBounds(11, 74, 282, 22);
					}
					{
						jScrollPane_Fragevorschau = new JScrollPane();
						jPanel_vorschau.add(jScrollPane_Fragevorschau);
						jScrollPane_Fragevorschau.setBounds(11, 12, 282, 51);
						jScrollPane_Fragevorschau.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
						{
							jTextPane_FrageVorschau = new JTextPane();
							jScrollPane_Fragevorschau.setViewportView(jTextPane_FrageVorschau);
						}
					}
					{
						jButton_FrageinklAntwortenErstellen = new JButton();
						jPanel_vorschau.add(jButton_FrageinklAntwortenErstellen);
						jButton_FrageinklAntwortenErstellen.setText("Frage inkl. Antworten Erstellen");
						jButton_FrageinklAntwortenErstellen.setBounds(156, 107, 228, 22);
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
						jButton_FrageLöschen = new JButton();
						jPanel_vorschau.add(jButton_FrageLöschen);
						jButton_FrageLöschen.setText("löschen");
						jButton_FrageLöschen.setBounds(303, 12, 81, 51);
						jButton_FrageLöschen.addActionListener(new ActionListener(){
						      public void actionPerformed(ActionEvent arg0) {
						    	  if(!jTextPane_FrageVorschau.getText().isEmpty()){
						    		  jTextPane_FrageVorschau.setText( "" );
						    		  frage = "";
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
						jButton_AntwortLöschen = new JButton();
						jPanel_vorschau.add(jButton_AntwortLöschen);
						jButton_AntwortLöschen.setText("löschen");
						jButton_AntwortLöschen.setBounds(303, 76, 81, 20);
						jButton_AntwortLöschen.addActionListener(new ActionListener(){
						      public void actionPerformed(ActionEvent arg0) {
						    	  if(jComboBox_vorschau.getSelectedItem()!=null){
							    	  if(!jComboBox_vorschau.getSelectedItem().toString().isEmpty()){
							    		  jComboBox_vorschau.removeItem( jComboBox_vorschau.getSelectedItem().toString());
							    		  antworten.remove(jComboBox_vorschau.getSelectedItem().toString());
							    	  }
						    	  }
						    	  else{
						    		  JOptionPane.showMessageDialog(jPanel_mainpanel,
							  			                              "Keine Antwort zum Löschen vorhanden",
							  			                              "Error",
							  			                              JOptionPane.ERROR_MESSAGE) ; 
						    	  }
						    	  
						      }
						});
						
					}
				}
				{
					jTextPane_Beschreibung_Beschreibung = new JTextPane();
					jPanel_mainpanel.add(jTextPane_Beschreibung_Beschreibung);
					jTextPane_Beschreibung_Beschreibung.setText("Hier sehen Sie die Vorschau der Frage, welche Sie hier erstellen. Die Erstellung der Frage bestätigen Sie anschließend mit dem Button \"Frage inkl. Antworten Erstellen\".");
					jTextPane_Beschreibung_Beschreibung.setBackground(new java.awt.Color(236,236,223));
					jTextPane_Beschreibung_Beschreibung.setFont(new java.awt.Font("Calibri",0,12));
					jTextPane_Beschreibung_Beschreibung.setBounds(10, 31, 395, 59);
					jTextPane_Beschreibung_Beschreibung.setEditable(false);
				}
				{
					jPanel_FrageErstellen = new JPanel();
					jPanel_mainpanel.add(jPanel_FrageErstellen);
					jPanel_FrageErstellen.setBounds(10, 260, 395, 228);
					jPanel_FrageErstellen.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
					jPanel_FrageErstellen.setLayout(null);
					{
						jLabel_Frage_erstellen = new JLabel();
						jPanel_FrageErstellen.add(jLabel_Frage_erstellen);
						jLabel_Frage_erstellen.setText("Frage:");
						jLabel_Frage_erstellen.setBounds(11, 12, 52, 14);
					}
					{
						jScrollPane_FrageErstellen = new JScrollPane();
						jPanel_FrageErstellen.add(jScrollPane_FrageErstellen);
						jScrollPane_FrageErstellen.setBounds(67, 13, 317, 48);
						jScrollPane_FrageErstellen.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
						{
							jTextPane_Frageeingabe = new JTextPane();
							jScrollPane_FrageErstellen.setViewportView(jTextPane_Frageeingabe);
						}
					}
					{
						jButton_FrageHinzufuegen = new JButton();
						jPanel_FrageErstellen.add(jButton_FrageHinzufuegen);
						jButton_FrageHinzufuegen.setText("Frage Hinzufügen");
						jButton_FrageHinzufuegen.setBounds(67, 67, 175, 23);
						jButton_FrageHinzufuegen.addActionListener(new ActionListener(){
						      public void actionPerformed(ActionEvent arg0) {
						    	  if(!jTextPane_Frageeingabe.getText().isEmpty()){
						    		  jTextPane_FrageVorschau.setText(jTextPane_Frageeingabe.getText());
						    		  jLabel_meldung.setText( "Frage erfolgreich hinzugefügt" );
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
						jLabel_AntwortHinzufügen = new JLabel();
						jPanel_FrageErstellen.add(jLabel_AntwortHinzufügen);
						jLabel_AntwortHinzufügen.setText("Antwort:");
						jLabel_AntwortHinzufügen.setBounds(11, 109, 43, 14);
					}
					{
						jTextField_AntwortEingabe = new JTextField();
						jPanel_FrageErstellen.add(jTextField_AntwortEingabe);
						jTextField_AntwortEingabe.setBounds(67, 106, 317, 20);
						jTextField_AntwortEingabe.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
					}
					{
						jButton_AntwortHinzufuegen = new JButton();
						jPanel_FrageErstellen.add(jButton_AntwortHinzufuegen);
						jButton_AntwortHinzufuegen.setText("Antwort Hinzufügen");
						jButton_AntwortHinzufuegen.setBounds(67, 132, 175, 24);
						jButton_AntwortHinzufuegen.addActionListener(new ActionListener(){
						      public void actionPerformed(ActionEvent arg0) {
						    	  if(!jTextField_AntwortEingabe.getText().isEmpty()){
						    		  jComboBox_vorschau.addItem(jTextField_AntwortEingabe.getText());
						    		  antworten.add(jTextField_AntwortEingabe.getText());
						    		  jLabel_meldung.setText( "Antwort erfolgreich hinzugefügt" );
						    		  jTextField_AntwortEingabe.setText( "" );
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
						jPanel_FrageErstellen.add(jLabel_meldung);
						jLabel_meldung.setBounds(11, 173, 342, 14);
					}
				}
				{
					jLabel_FrageundAntwortenErstellen = new JLabel();
					jPanel_mainpanel.add(jLabel_FrageundAntwortenErstellen);
					jLabel_FrageundAntwortenErstellen.setText("Frage und Antworten erstellen");
					jLabel_FrageundAntwortenErstellen.setBounds(10, 240, 263, 14);
				}
			}
			pack();
			this.setSize(431, 535);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
