package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import fragen.Frage;

/**
 * 
 * @author Gerald Maresch
 *
 */
public class DBReader {
	
	private static Connection conn;
	
	/**
	 * Initialisierung der Connection (DB Trerber, Verbindungsaufbau)
	 * @param nameODBCDatenbank String -> Der Name mit der die Verbindung über ODBC zur Datenabnk hergestellt wurde
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static void init(String nameODBCDatenbank) throws SQLException, ClassNotFoundException 
	{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); // Treiber Registrieren,
		conn = DriverManager.getConnection("jdbc:odbc:" + nameODBCDatenbank); // Verbindung zur Db-Herstellen
		conn.setAutoCommit(true); //Jede Änderung gilt sofort in der Datenbank
	}
	
	/**
	 * Schließen der DB Verbindung
	 * @throws SQLException
	 */
	public static void close() throws SQLException 
	{
		conn.close();
		conn = null;
	}
	
	/**
	 * Methode mit der der Inhalt der Tabelle Fragen in der DB individuell ausgelesen werden kann
	 * @param id int ->id des zu suchenden Datensatzes (Ist 0 wenn ein Select * ausgeführt werden soll)
	 * @param name String -> Bezeichnung des zu suchenden Datensatzes (Ist "" wenn ein Select * ausgeführt werden soll, sonst der Text der zu suchenden Frage)
	 * @param where int -> Nach was soll im Wehre Selektiert werden (0= alle (Select *),1=Select per F_ID, 2= Select per bezeichnung)
	 * @return -> liefert eine ArrayList mit dem Ergebnis des Selects. Ist das Ergebnis ein einzenler Datensatz, so kann dieser 
	 * im Array über den Index 0 angesprochen werden.
	 * @throws SQLException
	 */
	public static ArrayList<Frage> getTableFragen(int id, String bezeichnung, int where)
	throws SQLException 
	{
		Statement stmnt = conn.createStatement();
		
		ResultSet rs = null;
		
		if (id == 0 && where == 0)
		{	
			rs = stmnt.executeQuery("SELECT * FROM Fragen");				
		}			
		if (id != 0 && where == 1)
		{
				rs = stmnt.executeQuery("SELECT * FROM Fragen WHERE f_id=" + id);
		}
		if (bezeichnung.length() > 0 && where == 2)
		{
				rs = stmnt.executeQuery("SELECT * FROM Fragen WHERE f_frage LIKE" + bezeichnung);
		}

		ArrayList<Frage> result = new ArrayList<Frage>();

		while (rs.next()) {
			result.add(new Frage(rs.getString(2)));
		}

		rs.close();
		
		if (result == null)
		{
			throw new NullPointerException ();
		}
		else {
		return result;
		}
	}
}
