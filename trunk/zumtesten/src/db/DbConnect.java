package db;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DbConnect {
	
	/**
	 * Connection con
	 */
	private static Connection con;

	/**
	 * Initialisierung der Connection (DB Trerber, Verbindungsaufbau
	 * @return liefert true wenn Verbinung zu Datenbank erfolgreich war. Anderfalls false.
	 */
	public static boolean verbinden()
	{
		if (getConnectionString() == null)
		{
			JOptionPane.showMessageDialog(null,
                    "Es ist keine Konfigurationsdatei vorhanden.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE) ;
			Setup inst = new Setup();
			inst.setLocationRelativeTo(null);
			inst.setVisible(true);
		}
		else {
			try {
				Class.forName( "net.sourceforge.jtds.jdbc.Driver" );
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			try {
				con = DriverManager.getConnection( "jdbc:jtds:sqlserver://"+getConnectionString()[0]+":" + getConnectionString()[2] +"/" + getConnectionString()[1] + ";" ,getConnectionString()[3], getConnectionString()[4] );
			} catch (SQLException e) {
			e.printStackTrace();
			}
		}
		return true;
	}
	
	/**
	 * Methode trennt verbindung zur DB
	 * @return liefert true wenn Verbindung zu Datenbank erfolgreich getrennt wurde. Anderfalls false.
	 */
	public static boolean trennen() 
	{
		try {
			 con.close();
			 return true;
		}
		catch ( SQLException e ) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Getter für die Connection 
	 * @return
	 */
	public static Connection getCon() {
		return con;
	}
	
	/**
	 * Gibt den Connection String zurück.
	 *
	 * @return the connection string
	 */
	public static String[] getConnectionString()
	{
		String[] daten = new String[5];
		File file = new File("db.ini");
		if (file.exists())
		{
			try {
				BufferedReader in
				   = new BufferedReader(new FileReader(file));
				for (int i=0; i<5; i++)
				{
					daten[i] = in.readLine();
				}
				daten[4] = VerschluesselnMitJava.entschlusseln(daten[4]);

			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				
			}
		}
		else
		{
			daten = null;
		}
		return daten;
	}
}
