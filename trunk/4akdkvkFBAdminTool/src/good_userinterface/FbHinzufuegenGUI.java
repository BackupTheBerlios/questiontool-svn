package good_userinterface;

import interfaceGuiDb.SchnittstelleFBzuDB;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import db.DbWriter;
import db.TAN;

import good_fragen.*;

/**
 * 
 * @author 
 *
 */
public class FbHinzufuegenGUI 
{
	
	private static FbHinzufuegenGUI instance = null;
	private static JFrame hauptfenster; //JFrame was ich verwende
	private static JPanel hauptpanel;   //JPanel welches in der ContentPane drinnen ist
	private static JPanel panelCenter;
	private static JLabel labelFragenEingefuegt = null;
	private	static String ausgewaehlt = null;
	private static Frage hinzugefuegteFrage = null;
	private static MyTableModel tableModel1;
	private static JTable table1;
	private static JButton button1;
	private static JButton button2;
	private static JButton button3;
	private static JPanel panelKnoepfe;
	private static String frageAendern = null;
	
	/**
	 * 
	 */
	public FbHinzufuegenGUI()
	{
		//Windows Look an Feel erstellen
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		tableModel1 = new MyTableModel();
		table1 = new JTable(tableModel1);
		button1 = new JButton("Hinzufügen");
		button2 = new JButton("Details anzeigen");
		button3 = new JButton("Auswahl Löschen");
		panelKnoepfe = new JPanel();
		hauptfensterOeffnen();
		holeBestehendeFragen();
	}
	
	/**
	 * 
	 */
	public void hauptfensterOeffnen()
	{
		//***********Hauptfenster wird erstellt******************
		hauptfenster = new JFrame("Fragen Hinzufuegen");
		hauptfenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = hauptfenster.getContentPane();
		hauptfenster.setResizable(false);
		hauptpanel = new JPanel();
		
		//**********Hauptpanel Border, Optik....etc. Einstellungen für hauptpanel
		hauptfensterEdit(); // hauptfensterEdit() wird hier aufgerufen		
		contentPane.add(hauptpanel);
		//**********Erstellte Komponente zu Frame hinzufügen*******
		hauptfenster.setPreferredSize(new Dimension(820,610));
		hauptfenster.setContentPane(contentPane);
		hauptfenster.pack();
		hauptfenster.setVisible(true);
		//hauptfenster.setResizable(false);
	}
	
	/**
	 * 
	 */
	public void hauptfensterEdit()
	{
		hauptpanel.setLayout(new BorderLayout());
		JPanel panelNorth = new JPanel();
		panelCenter = new JPanel();
		JLabel labelTitel = new JLabel("Fragen Hinzufügen");
		Font titelFont = new Font("Calibri",1,20);
		labelTitel.setFont(titelFont);
		panelCenter.setBorder(new EtchedBorder());		
		panelCenterEdit();
		panelNorth.add(labelTitel);
		hauptpanel.add(panelNorth, BorderLayout.NORTH);
		hauptpanel.add(panelCenter, BorderLayout.CENTER);
	}
	
	/**
	 * 
	 */
	public void panelCenterEdit()
	{
		panelCenter.setLayout(new BorderLayout());
		JPanel panelCenterNorth = new JPanel();
		panelCenterNorth.setBorder(new EmptyBorder(10,10,10,10));
		panelCenterNorth.setLayout(new BoxLayout(panelCenterNorth,BoxLayout.X_AXIS));
		JPanel panelNorthBox = new JPanel();
		panelNorthBox.setLayout(new BoxLayout(panelNorthBox,BoxLayout.Y_AXIS));
		JLabel labelFBAttribut1 = new JLabel("Titel:  "+Fragebogen.getInstance().getTitel());
		JLabel labelFBAttribut2 = new JLabel("Beschreibung:  "+Fragebogen.getInstance().getBeschreibung());
		JLabel labelFBAttribut3 = new JLabel("Enddatum:  "+Fragebogen.getInstance().getEnddatum());
		JLabel labelFBAttribut4 = new JLabel("Gültig für:  "+Fragebogen.getInstance().getAnzahl() + " Personen");
		panelNorthBox.add(labelFBAttribut1);
		panelNorthBox.add(labelFBAttribut2);
		panelNorthBox.add(labelFBAttribut3);
		panelNorthBox.add(labelFBAttribut4);
		
		JSplitPane splitPaneCenter = new JSplitPane();
		JPanel leftPanel = new JPanel();
		leftPanel.setPreferredSize(new Dimension(350,540));
		//Knöpfe Konfigurieren
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				if(table1.getSelectedRow()<0){
					meldungAnzeigen("Sie haben keine Zeile markiert. Wählen Sie bitte eine Zeile aus der Tabelle aus!");
				}
				else {
					aendereFrage(tableModel1.getSelectedFrage(table1.getSelectedRow()));
				}
			}
		});
		button3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
					if(table1.getSelectedRow()<0) {
						meldungAnzeigen("Sie haben keine Zeile markiert. Wählen Sie bitte eine Zeile aus der Tabelle aus!");
					}
					else
					{
						int wahl = JOptionPane.showConfirmDialog(hauptfenster, "Wollen Sie wirklich die markierte Frage löschen?","Achtung",2);
						if(wahl==0)	{
							loescheFrage();
							aendereStatusLabel();
						}
				}
			}
		});
		JScrollPane scrollpane1 = new JScrollPane(table1);
		scrollpane1.setPreferredSize(new Dimension(300,400));
		JPanel leftPanel2 = new JPanel();
		leftPanel2.add(scrollpane1);
		leftPanel.add(leftPanel2);
		panelKnoepfe.setVisible(false);
		panelKnoepfe.setLayout(new BoxLayout(panelKnoepfe,BoxLayout.X_AXIS));
		panelKnoepfe.add(button2);
		panelKnoepfe.add(button3);
		leftPanel.add(panelKnoepfe);
		labelFragenEingefuegt = new JLabel("Sie haben noch keine Fragen hinzugefügt");
		JPanel panelFragenEingefuegt = new JPanel();
		panelFragenEingefuegt.add(labelFragenEingefuegt);
		leftPanel.add(panelFragenEingefuegt);
		
		JPanel rightPanel = new JPanel();
		JPanel rightPanel2 = new JPanel();
		rightPanel2.setPreferredSize(new Dimension(280,280));
		rightPanel2.setLayout(new BoxLayout(rightPanel2,BoxLayout.Y_AXIS));
		JPanel labelPanel1 = new JPanel();
		JLabel labelHinzufuegen = new JLabel("Frage Hinzufügen");
		labelPanel1.add(labelHinzufuegen);
		rightPanel2.add(labelPanel1);
		JPanel groupPanel = new JPanel();
		groupPanel.setBorder(new EtchedBorder());
		groupPanel.setLayout(new BoxLayout(groupPanel,BoxLayout.Y_AXIS));
		
		JRadioButton radioButton1 = new JRadioButton("Auswahlliste");
		radioButton1.setActionCommand(radioButton1.getText());
		radioButton1.setToolTipText("Aus einer Liste mit Antworten wird eine Antwort ausgewählt");
		JRadioButton radioButton2 = new JRadioButton("Eine Antwortmöglichkeit");
		radioButton2.setActionCommand(radioButton2.getText());
		radioButton2.setToolTipText("Nur eine Antwortmöglichkeiten von vielen erlaubt");
		final JRadioButton radioButton3 = new JRadioButton("Mehrere Antwortmöglichkeiten");
		radioButton3.setActionCommand(radioButton3.getText());
		radioButton3.setToolTipText("Mehrere Auswahlmöglichkeiten mit Hilfe von Checkboxen");
		JRadioButton radioButton4 = new JRadioButton("Einzeiliger Text");
		radioButton4.setActionCommand(radioButton4.getText());
		radioButton4.setToolTipText("Antwort kann in einem Einzeiligen Textfeld eingetragen werden");
		JRadioButton radioButton5 = new JRadioButton("Mehrzeiliger Text");
		radioButton5.setActionCommand(radioButton5.getText());
		radioButton5.setToolTipText("Antwort kann in einem Mehrzeiligen Textfeld eingetragen werden");
		JRadioButton radioButton6 = new JRadioButton("Notensystem");
		radioButton6.setActionCommand(radioButton6.getText());
		radioButton6.setToolTipText("Auswahlmöglichkeiten wie im Schulsystem. Noten von 1 bis 5");
		final ButtonGroup buttongroup1 = new ButtonGroup();
		buttongroup1.add(radioButton1);
		buttongroup1.add(radioButton2);
		buttongroup1.add(radioButton3);
		buttongroup1.add(radioButton4);
		buttongroup1.add(radioButton5);
		buttongroup1.add(radioButton6);
		groupPanel.add(radioButton1);
		groupPanel.add(radioButton2);
		groupPanel.add(radioButton3);
		groupPanel.add(radioButton4);
		groupPanel.add(radioButton5);
		groupPanel.add(radioButton6);
		rightPanel2.add(groupPanel);
		rightPanel.add(rightPanel2);
		JPanel panelButton = new JPanel();
		panelButton.setLayout(new BoxLayout(panelButton,BoxLayout.Y_AXIS));
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
					try
					{
						ausgewaehlt = null;
						ButtonModel selected = buttongroup1.getSelection();
						ausgewaehlt = selected.getActionCommand();
						button1.setEnabled(false);
						frageHinzufuegen(ausgewaehlt,false);
					}
					catch(NullPointerException exc)
					{
						meldungAnzeigen("Bitte wählen Sie eine Auswahlmöglichkeit aus");
					}
			}
		});
		JButton button4 = new JButton("Abspeichern und Abschließen");
		//ALLES SPEICHERN
		button4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) 
			{
				//titel, beschreibung, datum wurden schon in FbErstellungGUI zum Fragebogen hinzugefügt
				//tans, fragenlist --> muss noch in das Fragebogenobjekt geschrieben werden
				
				//FID Berechnen
				int FID = DbWriter.getMaxFID(); //Fragebogen id (die, die er bekommt) getMaxFID liefert -1 bei fehler
				FID++;//Ansonsten wird falsche Frage genommen(eine ID zu niedrig)
				if(FID > 0) {
					//Tans berechnen
					ArrayList<String> tans = TAN.getTANS(FID, Fragebogen.getInstance().getAnzahl(), ":)");
					//Tans im Fragebogen speichern
					Fragebogen.getInstance().setTans(tans);
				}
				
				Fragebogen.getInstance().setFragenList(tableModel1.gibFragenArray());
				SchnittstelleFBzuDB.speicherFb();
				//noch prüfung einbaun
	            JOptionPane.showMessageDialog(hauptfenster,
                          "Fragebogen wurde erfolgreich erstellt. Sie können nun Fragen zuordnen.",
                          "Erfolg",
                          JOptionPane.INFORMATION_MESSAGE) ;
				hauptfenster.dispose();
			}
		});
		
		panelButton.add(button1);
		JLabel emptyLabel = new JLabel("             ");
		JLabel emptyLabel2 = new JLabel("             ");
		panelButton.add(emptyLabel);
		panelButton.add(emptyLabel2);
		panelButton.add(button4);
		rightPanel2.add(panelButton);	
		splitPaneCenter.setLeftComponent(leftPanel);
		splitPaneCenter.setRightComponent(rightPanel);
		panelCenterNorth.add(panelNorthBox);
		panelCenter.add(panelCenterNorth, BorderLayout.NORTH);
		panelCenter.add(splitPaneCenter,BorderLayout.CENTER);
	}
	
	/**
	 * 
	 * @param titel
	 * @param vorhanden
	 */
	public void frageHinzufuegen(String titel, boolean vorhanden)
	{
		if(titel.equals("Auswahlliste"))
		{
			FbDropDownFrage fbDDF1 = new FbDropDownFrage();
			fbDDF1.setVisible(true);
			if(vorhanden==true)	{
				Frage frage1 = tableModel1.getSelectedFrage(table1.getSelectedRow());	
				String frage = frage1.getFrage();
				ArrayList<String> answers = frage1.getAntworten();
				fbDDF1.getJTextPane_FrageVorschau().setText(frage);
				fbDDF1.setFrage(frage);
				fbDDF1.setAntworten(answers);
				for(String h : answers)	{
					fbDDF1.getJComboBox_vorschau().addItem(h);
				}
			}
		}
		else if(titel.equals("Eine Antwortmöglichkeit"))
		{
			//FbRadioFrage.main(a);
			FbRadioFrage fbRF1 = new FbRadioFrage();
			fbRF1.setVisible(true);
			if(vorhanden==true)	{
				Frage frage1 = tableModel1.getSelectedFrage(table1.getSelectedRow());	
				String frage = frage1.getFrage();
				ArrayList<String> answers = frage1.getAntworten();
				fbRF1.getJTextPane_FrageVorschau().setText(frage);
				fbRF1.setFrage(frage);
				fbRF1.setAntworten(answers);
				int y=9;
		        int i=0;
		    	for(String s : answers){
		    		  JRadioButton b= new JRadioButton(s);
		    		  fbRF1.getJPanel1().add( b );
		    		  b.setActionCommand(""+i);
		    		  b.setBounds( 11, y, 93, 23 );
		    		  y+=25;
		    		  fbRF1.getButtons().add( b ); 
		    		  fbRF1.getButtongroup().add( b ); 
		    		  i++;
		    	}
			}
		}
		else if(titel.equals("Mehrere Antwortmöglichkeiten")) 
		{
				//FbCheckBoxFrage.main(a);
				FbCheckBoxFrage fbCBF1 = new FbCheckBoxFrage();
				fbCBF1.setVisible(true);
				if(vorhanden==true) {
					Frage frage1 = tableModel1.getSelectedFrage(table1.getSelectedRow());	
					String frage = frage1.getFrage();
					ArrayList<String> answers = frage1.getAntworten();
					fbCBF1.getJTextPane_FrageVorschau().setText(frage);
					fbCBF1.setFrage(frage);
					fbCBF1.setAntworten(answers);
					fbCBF1.checkboxenEinfügen(answers);
				}
		}
		else if(titel.equals("Einzeiliger Text"))
		{
				//FbTextFrage.main(a);
				FbTextFrage fbTF1 = new FbTextFrage();
				fbTF1.setVisible(true);
				if(vorhanden==true)	{
					Frage frage1 = tableModel1.getSelectedFrage(table1.getSelectedRow());	
					String frage = frage1.getFrage();
					fbTF1.setFrage(frage);
					fbTF1.getJTextPane_Frageeingabe().setText(frage);
				}
		}
		else if(titel.equals("Mehrzeiliger Text"))
		{
				//FbTextFrage.main(a);
				FbTextFrage fbTF1 = new FbTextFrage();
				fbTF1.setVisible(true);
				if(vorhanden==true)	{
					Frage frage1 = tableModel1.getSelectedFrage(table1.getSelectedRow());	
					String frage = frage1.getFrage();
					fbTF1.setFrage(frage);
					fbTF1.getJTextPane_Frageeingabe().setText(frage);
				}
		}
		else 
		{
				FbNotenFrage fbNF1 = new FbNotenFrage();
				fbNF1.setVisible(true);
				if(vorhanden==true) {
					Frage frage1 = tableModel1.getSelectedFrage(table1.getSelectedRow());	
					String frage = frage1.getFrage();
					fbNF1.setFrage(frage);
					fbNF1.getJTextPane_Frageeingabe().setText(frage);
				}
		}
	}		

	/**
	 * 
	 * @param meldung
	 */
	public static void meldungAnzeigen(String meldung)
	{
		JOptionPane.showMessageDialog(hauptfenster, 
				meldung,
				"Achtung", 
		JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * 
	 * @param frage
	 * @param antworten
	 * @return
	 */
	public static boolean hinzufuegenInTable(String frage, ArrayList<String> antworten)
	{
		boolean vorhanden = false;
		if(frageAendern==null)	{
			for(Frage frage1 : tableModel1.alleFragen) {
				if(frage1.getFrage().equals(frage))	{
						vorhanden = true;
						meldungAnzeigen("Sie versuchen eine Frage hinzuzufügen, die schon vorhanden ist! Geben Sie eine andere Frage ein!");
				}
			}
			if(vorhanden==false) {
				if(ausgewaehlt.equals("Auswahlliste"))
				{
					hinzugefuegteFrage = new FrageDropdown(frage);
				}
				else if(ausgewaehlt.equals("Eine Antwortmöglichkeit  "))
				{
					hinzugefuegteFrage = new FrageRadio(frage);
				}
				else if(ausgewaehlt.equals("Mehrere Antwortmöglichkeiten  "))
				{
					hinzugefuegteFrage = new FrageCheckBox(frage);
				}
				else if(ausgewaehlt.equals("Einzeiliger Text  "))
				{
					hinzugefuegteFrage = new FrageText(frage);
				}
				else if(ausgewaehlt.equals("Mehrzeiliger Text  "))
				{
					hinzugefuegteFrage = new FrageText(frage);
				}
				else {
					hinzugefuegteFrage = new FrageNoten(frage);
				}
				//Antworten hinzufügen	
				if(antworten!=null)	{
						hinzugefuegteFrage.setAntworten(antworten);
				}
				hinzugefuegteFrage.setFragentyp(ausgewaehlt);
				tableModel1.addFrage(hinzugefuegteFrage);
				tableModel1.fireTableDataChanged();
				aendereStatusLabel();
				hinzugefuegteFrage = null;
			} //if zu inneres
		}//if zu (äusseres
		else {
			for(Frage frage1 : tableModel1.alleFragen) {
				if(frage1.getFrage().equals(frageAendern))	{
					frage1.setFrage(frage);
				}
			}
			tableModel1.fireTableDataChanged();
			frageAendern = null;
		}//else zu
		return vorhanden;
	} // methode zu
	
	/**
	 * 
	 */
	public static void aendereStatusLabel()
	{
		if(tableModel1.alleFragen.size()>0)	{
			labelFragenEingefuegt.setText("Sie haben "+tableModel1.getSize()+" Frage(n) hinzugefügt!");
			panelKnoepfe.setVisible(true);
		}
		else {
			labelFragenEingefuegt.setText("Sie haben keine Fragen hinzugefügt!");
			panelKnoepfe.setVisible(false);
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public static FbHinzufuegenGUI getInstance()
	{
		if ( instance == null )
			{
				instance = new FbHinzufuegenGUI();

			}
		return instance;
	}
	
	/**
	 * 
	 * @param frage1
	 */
	public void aendereFrage(Frage frage1)
	{
		frageHinzufuegen(frage1.getFragentyp(),true);
		frageAendern = frage1.getFrage();
	}
	
	/**
	 * 
	 */
	public void loescheFrage()
	{
		tableModel1.loescheFrage(table1.getSelectedRow());
		tableModel1.fireTableDataChanged();
	}
	
	/**
	 * 
	 */
	public void holeBestehendeFragen()
	{
		tableModel1.arrayListEinfuegen(Fragebogen.getInstance().getFragenList());
		tableModel1.fireTableDataChanged();
		aendereStatusLabel();
	}

	/**
	 * 
	 * @return
	 */
	public JButton getButton1() {
		return button1;
	}
}
