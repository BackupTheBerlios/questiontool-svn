package db;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author Sparky
 *
 */
public class DbWriter
{

/**
 * 
 * @return liefert die höchste Fragebogen-ID. Wenn Abfrage fehlgeschlagen wird -1 zurück gegeben.
 */
	public static int getMaxFbID()
	{
		DbConnect.verbinden();
		try
			{
				Statement stmnt = DbConnect.getCon().createStatement();
				ResultSet rs = stmnt
						.executeQuery("SELECT MAX(FB_ID) FROM dbo.Fragebogen");
				rs.next();
				int maxId = rs.getInt(1);
				DbConnect.trennen();
				return maxId;
			}
		catch ( SQLException e )
			{
				DbConnect.trennen();
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
		DbConnect.verbinden();
		try
			{
				Statement stmnt = DbConnect.getCon().createStatement();
				ResultSet rs = stmnt
						.executeQuery("SELECT MAX(F_ID) FROM dbo.Fragen");
				rs.next();
				int maxId = rs.getInt(1);
				DbConnect.trennen();
				return maxId;
			}
		catch ( SQLException e )
			{
				DbConnect.trennen();
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
		DbConnect.verbinden();
		try	{
				PreparedStatement pstmnt = 
					DbConnect.getCon().prepareStatement("INSERT INTO dbo.Fragen (F_Frage) VALUES (?)");
				pstmnt.setString(1, frage);
				int erg = pstmnt.executeUpdate();
				DbConnect.trennen();
				if ( erg > 0 ) {
						return true;
				}
				else{
						return false;
				}
		}
		catch ( SQLException e ) {
				DbConnect.trennen();
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
		DbConnect.verbinden();
		if ( fId != -1 ){
			try {
				PreparedStatement pstmnt = 
					DbConnect.getCon().prepareStatement("INSERT INTO dbo.Antwortenvorgegeben (A_F_ID, A_T_ID, A_Antwort) VALUES (?,?,?)");
				pstmnt.setInt(1, fId);
				pstmnt.setInt(2, typId);
				pstmnt.setString(3, antwort);
				int erg = pstmnt.executeUpdate();
				DbConnect.trennen();
				if ( erg > 0 ){
					return true;
				}
				else {
					return false;
				}
			}//Try zu
			catch ( SQLException e ) {
				DbConnect.trennen();
				e.printStackTrace();
				return false;
			}
		}//if zu
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
		DbConnect.verbinden();
		try
			{
				PreparedStatement pstmnt = 
					DbConnect.getCon().prepareStatement("INSERT INTO dbo.Fragebogen (FB_Beschreibung, FB_Titel, FB_ausfuellen_bis) "
								+ "VALUES (?,?,?)");
				pstmnt.setString(1, beschreibung);
				pstmnt.setString(2, titel);
				//Hier erfolgt die Umwandlung in ein für die Datenbank passendes Datums format(von util.Date zu sql.Date)
				java.sql.Date formatedDate = new java.sql.Date(enddatum.getTime());
				pstmnt.setDate(3, formatedDate);

				int erg = pstmnt.executeUpdate();

				DbConnect.trennen();
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
				e.printStackTrace();
				DbConnect.trennen();
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
		//System.out.println("FBid: " +fbId);
		//System.out.println("Start: " +startFId);
		//System.out.println("Ende: " +endFId);
		DbConnect.verbinden();
		int sortierung = 0;
		for ( int currentfId = startFId; currentfId <= endFId; currentfId++ )
			{
				try
					{
						//System.out.println("CurrentF: " +currentfId);
						sortierung++;
						PreparedStatement pstmnt = 
							DbConnect.getCon().prepareStatement("INSERT INTO dbo.haben (F_ID, FB_ID, sortierung) VALUES (?,?,?)");
						pstmnt.setInt(1, currentfId);
						pstmnt.setInt(2, fbId);
						pstmnt.setInt(3, sortierung);
						pstmnt.executeUpdate();
						pstmnt.close();				
					}
				catch ( SQLException e )
					{
						DbConnect.trennen();
						e.printStackTrace();
						return false;
					}
			}
		DbConnect.trennen();
		return true;
	}
	
	public static boolean speichereTans(ArrayList<String> tans, int fbId)
	{
		for(String t : tans) {
			System.out.println(t);
		}
		DbConnect.verbinden();
		for(String tanId : tans)
			{
				try
					{
						PreparedStatement pstmnt = DbConnect.getCon().prepareStatement("INSERT INTO dbo.TAN (T_ID, FB_ID, T_istgueltig) VALUES (?,?,?)");
						pstmnt.setString(1, tanId);
						pstmnt.setInt(2, fbId);
						pstmnt.setString(3, "j");
						pstmnt.executeUpdate();
						pstmnt.close();
					}
				catch ( SQLException e )
					{
						DbConnect.trennen();
						e.printStackTrace();
						return false;
					}
			}
		DbConnect.trennen();
		return true;
	}
}
