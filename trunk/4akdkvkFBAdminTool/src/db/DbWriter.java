package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import fragen.Frage;
import fragen.Fragebogen;

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
	
	//2 in Fragen und danach in haben
	public static boolean speichereFrage(Frage f, int fbId)
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
	//3 in Antwortvorgegeben
	public static boolean speichereAntwort(ArrayList<String> antwort, int typId, int fId)
	{
		return true;
	}
	//1 //aufzteilen auf einzelne Strings usw also nicht ganzes FB objekt
	public static boolean speichereFragebogen(Fragebogen fb )
	{
		return true;
	}
	
	//4 ? wo is TAN-Code vielleicht die ID?
	public static boolean speichereTan(int fbId, int tId)
	{
		return true;
	}

}
