package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import fragen.Frage;

public class DbWriter
{
	public static Connection con;


	// Der Datenbankname ist noch nicht bekannt, muss noch eingefügt werden
	// Stellt verbindung her
	private boolean verbinde()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("jdbc:odbc:DBNAME");
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


	// Schließt verbindung
	private boolean close()
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
	
	
	public static boolean speichereFragebogen(Frage f)
	{
		/*
		 * ABLAUF
		 * zuerst fbid merken
		 * dann fragen speichern tabelle: Fragen
		 * *****fid´s merken mit linzi klären ob Autowert oder nicht
		 * alle Antworten die zur frage passen speichern Tabelle: Antwortenvorgebene
		 * speichern in Tabelle: haben(alle Fragen plus F-ID)
		 * Dann Fragebogen in Fragebogentabelle speichern
		 */
		return true;
	}

}
