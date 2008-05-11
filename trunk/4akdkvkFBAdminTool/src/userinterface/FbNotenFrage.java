package userinterface;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.SwingUtilities;


public class FbNotenFrage extends javax.swing.JFrame {
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
	private JPanel jPanel_mainpanel;
	private JTextPane jTextPane_Beschreibung_Beschreibung;
	private JTextPane jTextPane_Frageeingabe;
	private JButton jButton_Frageerstellen;
	private JScrollPane jScrollPane_Frageeingabe;
	private JLabel jLabel_Frage;
	private String frage;


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
				FbNotenFrage inst = new FbNotenFrage();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public FbNotenFrage() {
		super();
		initGUI();
		this.setTitle( "Noten Frage" );
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jPanel_mainpanel = new JPanel();
				getContentPane().add(jPanel_mainpanel, BorderLayout.CENTER);
				jPanel_mainpanel.setPreferredSize(new java.awt.Dimension(415, 238));
				jPanel_mainpanel.setLayout(null);
				{
					jTextPane_Beschreibung_Beschreibung = new JTextPane();
					jPanel_mainpanel.add(jTextPane_Beschreibung_Beschreibung);
					jTextPane_Beschreibung_Beschreibung.setText("Hier sehen Sie die Vorschau der Frage, " +
							"welche Sie hier erstellen. Die Erstellung der Frage bestätigen Sie anschließend mit " +
							"dem Button \"Frage erstellen\". Zu beachten ist, Sie geben hier" +
							" nur die gewünschte Frage ein, die Antwortmöglichkeiten werden automatisch mit der " +
							"Notenskala zwischen 1-5 definiert.");
					jTextPane_Beschreibung_Beschreibung.setEditable(false);
					jTextPane_Beschreibung_Beschreibung.setBackground(new java.awt.Color(236,236,223));
					jTextPane_Beschreibung_Beschreibung.setFont(new java.awt.Font("Calibri",0,12));
					jTextPane_Beschreibung_Beschreibung.setBounds(10, 11, 395, 88);
				}
				{
					jLabel_Frage = new JLabel();
					jPanel_mainpanel.add(jLabel_Frage);
					jLabel_Frage.setText("Frage:");
					jLabel_Frage.setBounds(10, 117, 59, 14);
				}
				{
					jScrollPane_Frageeingabe = new JScrollPane();
					jPanel_mainpanel.add(jScrollPane_Frageeingabe);
					jScrollPane_Frageeingabe.setBounds(69, 117, 336, 61);
					jScrollPane_Frageeingabe.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
					{
						jTextPane_Frageeingabe = new JTextPane();
						jScrollPane_Frageeingabe.setViewportView(jTextPane_Frageeingabe);
					}
				}
				{
					jButton_Frageerstellen = new JButton();
					jPanel_mainpanel.add(jButton_Frageerstellen);
					jButton_Frageerstellen.setText("Frage erstellen");
					jButton_Frageerstellen.setBounds(69, 189, 152, 23);
					jButton_Frageerstellen.addActionListener(new ActionListener(){
					      public void actionPerformed(ActionEvent arg0) {
					    	  if(!jTextPane_Frageeingabe.getText().isEmpty()){
					    		  frage=jTextPane_Frageeingabe.getText();
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
			}
			pack();
			this.setSize(431, 260);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
