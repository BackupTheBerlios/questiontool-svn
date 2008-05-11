package db;

import java.sql.Connection;
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
	 * Der Datenbankname ist noch nicht bekannt, muss noch eingefügt werden
	 * Stellt verbindung her
	 * 
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
	 * Schließt verbindung
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
	 * ABLAUF zuerst fbid merken dann fragen speichern tabelle: Fragen
	 * *****fid´s merken mit linzi klären ob Autowert oder nicht alle Antworten
	 * die zur frage passen speichern Tabelle: Antwortenvorgebene speichern in
	 * Tabelle: haben(alle Fragen plus F-ID) Dann Fragebogen in
	 * Fragebogentabelle speichern
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


	// 2 in Fragen und danach in haben
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


	// 3 in Antwortvorgegeben
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


	@SuppressWarnings("deprecation")
	public static boolean speichereFragebogen(String titel,
			String beschreibung, Date enddatum)
	{
		verbinden();
		try
			{
				int month = enddatum.getMonth();
				month++;
				enddatum.setMonth(month);
				PreparedStatement pstmnt = con
						.prepareStatement("INSERT INTO dbo_Fragebogen (FB_Beschreibung, FB_Titel, FB_ausfuellen_bis) "
								+ "VALUES (?,?,?)");
				//Datumsproblem lösen
				Calendar stCal = Calendar.getInstance();
				java.sql.Date sqlendDate = new java.sql.Date(stCal.getTimeInMillis());
				//Statemnet aufbauen
				pstmnt.setString(1, beschreibung);
				pstmnt.setString(2, titel);
				pstmnt.setDate(3, sqlendDate);

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


	// 4
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

}
