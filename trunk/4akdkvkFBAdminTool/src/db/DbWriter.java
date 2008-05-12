package db;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

/**
 * 
 * @author Sparky
 *
 */
public class DbWriter
{
	public static Connection con;


	/**
	 * 
	 * @return liefert true wenn Verbinung zu Datenbank erfolgreich war. Anderfalls false.
	 */
	private static boolean verbinden()
	{
		try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				con = DriverManager.getConnection("jdbc:odbc:Fragebogen");
				con.setAutoCommit(true);
				return true;
			}
		catch ( ClassNotFoundException e )
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		catch ( SQLException e )
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
	}


	/**
	 * 
	 * @return liefert true wenn Verbindung zu Datenbank erfolgreich getrennt wurde. Anderfalls false.
	 */
	private static boolean trennen()
	{
		try
			{
				con.close();
				return true;
			}
		catch ( SQLException e )
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
	}


/**
 * 
 * @return liefert die höchste Fragebogen-ID. Wenn Abfrage fehlgeschlagen wird -1 zurück gegeben.
 */
	public static int getMaxFbID()
	{
		verbinden();
		try
			{
				Statement stmnt = con.createStatement();
				ResultSet rs = stmnt
						.executeQuery("SELECT MAX(FB_ID) FROM dbo_Fragebogen");
				rs.next();
				int maxId = rs.getInt(1);
				trennen();
				return maxId;
			}
		catch ( SQLException e )
			{
				// TODO Auto-generated catch block
				trennen();
				e.printStackTrace();
				return -1;
			}
	}

	/**
	 * 
	 * @return liefert die höchste Fragen-ID. Wenn Abfrage fehlgeschlagen wird -1 zurück gegeben.
	 */
	public static int getMaxFID()
	{
		verbinden();
		try
			{
				Statement stmnt = con.createStatement();
				ResultSet rs = stmnt
						.executeQuery("SELECT MAX(F_ID) FROM dbo_Fragen");
				rs.next();
				int maxId = rs.getInt(1);
				trennen();
				return maxId;
			}
		catch ( SQLException e )
			{
				// TODO Auto-generated catch block
				trennen();
				e.printStackTrace();
				return -1;
			}

	}


	/**
	 * 
	 * @param frage(String) Fragentext
	 * @return liefert true wenn Fragen erfolgreich in die Datenbank geschrieben wurde. Annderfalls liefert die Methode false.
	 */
	public static boolean speichereFrage(String frage)
	{
		verbinden();

		try
			{
				PreparedStatement pstmnt = con
						.prepareStatement("INSERT INTO dbo_Fragen (F_Frage) VALUES (?)");
				pstmnt.setString(1, frage);
				int erg = pstmnt.executeUpdate();
				trennen();
				if ( erg > 0 )
					{
						return true;
					}
				else
					{
						return false;
					}

			}
		catch ( SQLException e )
			{
				// TODO Auto-generated catch block
				trennen();
				e.printStackTrace();
				return false;
			}

	}


	/**
	 * 
	 * @param antwort(String) Antworttext
	 * @param typId(int) Gibt den Typ der Frage an, der der Antwort zugeordnet ist
	 * @return
	 */
	public static boolean speichereAntwort(String antwort, int typId)
	{
		// Es wird zuerst die ID der MAX Frage ermittelt
		// Diese ID ist ,wenn die Methode speichereAntwort ausgeführt wird, die
		// FragenId die zu dieser Antwort gehört
		// siehe SchnittstelleFbzuDB ab Zeile 20
		int fId = getMaxFID(); // ID der vorher gespeicherten Frage
		verbinden();
		if ( fId != -1 )
			{
				try
					{
						PreparedStatement pstmnt = con
								.prepareStatement("INSERT INTO dbo_Antwortenvorgegeben (A_F_ID, A_T_ID, A_Antwort) VALUES (?,?,?)");
						pstmnt.setInt(1, fId);
						pstmnt.setInt(2, typId);
						pstmnt.setString(3, antwort);

						int erg = pstmnt.executeUpdate();

						trennen();
						if ( erg > 0 )
							{
								return true;
							}
						else
							{
								return false;
							}
					}
				catch ( SQLException e )
					{
						// TODO Auto-generated catch block
						trennen();
						e.printStackTrace();
						return false;
					}
			}
		return false;
	}
/**
 * 
 * @param titel(String) Titel des Fragebongens
 * @param beschreibung(String) Beschreibung des Fragebogens
 * @param enddatum(java.util.Date) Datum bis wann der Fragebogen gültig ist
 * @return liefert true wenn Fragebongen erfolgreich gespeichert wurde. Anderfall false.
 */
	public static boolean speichereFragebogen(String titel,
			String beschreibung, java.util.Date enddatum)
	{
		verbinden();
		try
			{
				PreparedStatement pstmnt = con
						.prepareStatement("INSERT INTO dbo_Fragebogen (FB_Beschreibung, FB_Titel, FB_ausfuellen_bis) "
								+ "VALUES (?,?,?)");
				pstmnt.setString(1, beschreibung);
				pstmnt.setString(2, titel);
				//Hier erfolgt die Umwandlung in ein für die Datenbank passendes Datums format(von util.Date zu sql.Date)
				java.sql.Date formatedDate = new java.sql.Date(enddatum.getTime());
				pstmnt.setDate(3, formatedDate);


				int erg = pstmnt.executeUpdate();

				trennen();
				if ( erg > 0 )
					{
						return true;
					}
				else
					{
						return false;
					}
			}
		catch ( SQLException e )
			{
				// TODO Auto-generated catch block

				e.printStackTrace();
				trennen();
				return false;
			}

	}


	/**
	 * Diese Methode speichert alle Fragen die zu einem Fragebogen gehören.
	 * @param startFId(int) Anfang-ID der Frage
	 * @param endFId(int) End-ID der Frage
	 * @param fbId(int) Fragebogen-ID. Alle Fragen werden diesem Fragebogen zugeordnet.
	 * @return
	 */
	public static boolean speichereInHaben(int startFId, int endFId, int fbId)
	{
		System.out.println("FBid: " +fbId);
		System.out.println("Start: " +startFId);
		System.out.println("Ende: " +endFId);
		verbinden();
		int sortierung = 0;
		for ( int currentfId = startFId; currentfId <= endFId; currentfId++ )
			{
				try
					{
						System.out.println("CurrentF: " +currentfId);
						sortierung++;
						PreparedStatement pstmnt = con
								.prepareStatement("INSERT INTO dbo_haben (F_ID, FB_ID, sortierung) VALUES (?,?,?)");
						pstmnt.setInt(1, currentfId);
						pstmnt.setInt(2, fbId);
						pstmnt.setInt(3, sortierung);
						pstmnt.executeUpdate();
						pstmnt.close();
				
					}
				catch ( SQLException e )
					{
						trennen();
						e.printStackTrace();
						return false;

					}
			}
		trennen();
		return true;
	}
	
	public static boolean speichereTans(ArrayList<String> tans, int fbId)
	{
		verbinden();
		for(String tanId : tans)
			{
				try
					{
						PreparedStatement pstmnt = con.prepareStatement("INSERT INTO dbo_TAN (T_ID, FB_ID, T_istgueltig) VALUES (?,?,?)");
						pstmnt.setString(1, tanId);
						pstmnt.setInt(2, fbId);
						pstmnt.setString(3, "j");
						pstmnt.executeUpdate();
						pstmnt.close();
					}
				catch ( SQLException e )
					{
						// TODO Auto-generated catch block
						trennen();
						e.printStackTrace();
						return false;
					}
			}
		trennen();
		return true;
	}

}
