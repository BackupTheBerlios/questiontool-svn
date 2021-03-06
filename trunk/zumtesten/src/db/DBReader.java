package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import good_fragen.*;

/**
 * 
 * @author Gerald Maresch
 *
 */
public class DBReader {
	
	/**
	 * Methode mit der der Inhalt der Tabelle Fragen in der DB individuell ausgelesen werden kann
	 * @param id int ->id des zu suchenden Datensatzes (Ist 0 wenn ein Select * ausgef�hrt werden soll)
	 * @param name String -> Bezeichnung des zu suchenden Datensatzes (Ist "" wenn ein Select * ausgef�hrt werden soll, sonst der Text der zu suchenden Frage)
	 * @param where int -> Nach was soll im Wehre Selektiert werden (0= alle (Select *),1=Select per F_ID, 2= Select per bezeichnung)
	 * @return -> liefert eine ArrayList mit dem Ergebnis des Selects. Ist das Ergebnis ein einzenler Datensatz, so kann dieser 
	 * im Array �ber den Index 0 angesprochen werden.
	 * @throws SQLException
	 */
	public static ArrayList<Frage> getTableFragen(int id, String bezeichnung, int where)throws SQLException 
	{
		DbConnect.verbinden();
		Statement stmnt = DbConnect.getCon().createStatement();
				ResultSet rs = null;		
		if (id == 0 && where == 0)
		{	
			rs = stmnt.executeQuery("SELECT DISTINCT dbo.Fragen.F_Frage, dbo.Fragen.F_ID, dbo.Typ.T_ID" +
					"FROM dbo.Typ INNER JOIN (dbo.Fragen INNER JOIN dbo.Antwortenvorgegeben " +
								  "ON dbo.Fragen.F_ID = dbo.Antwortenvorgegeben.A_F_ID) " +
								  "ON dbo.Typ.T_ID = dbo.Antwortenvorgegeben.A_T_ID;");				
		}			
		if (id != 0 && where == 1)
		{
				rs = stmnt.executeQuery("SELECT DISTINCT dbo.Fragen.F_Frage, dbo.Fragen.F_ID, dbo.Typ.T_ID" +
						"FROM dbo.Typ INNER JOIN (dbo.Fragen INNER JOIN dbo.Antwortenvorgegeben " +
								  "ON dbo.Fragen.F_ID = dbo.Antwortenvorgegeben.A_F_ID) " +
								  "ON dbo.Typ.T_ID = dbo.Antwortenvorgegeben.A_T_ID" +
						"WHERE dbo.Fragen.F_ID=" + id+";");
		}
		if (bezeichnung.length() > 0 && where == 2)
		{
			rs = stmnt.executeQuery("SELECT DISTINCT dbo.Fragen.F_Frage, dbo.Fragen.F_ID, dbo.Typ.T_ID" +
					"FROM dbo.Typ INNER JOIN (dbo.Fragen INNER JOIN dbo.Antwortenvorgegeben " +
							  "ON dbo.Fragen.F_ID = dbo.Antwortenvorgegeben.A_F_ID) " +
							  "ON dbo.Typ.T_ID = dbo.Antwortenvorgegeben.A_T_ID" +
					"WHERE dbo.Fragen.F_Frage like '" + bezeichnung +"';");
		}

		ArrayList<Frage> result = new ArrayList<Frage>();

		while (rs.next()) {
			int typ = rs.getInt(3);
			
			switch(typ)
			{
				//Radio Buttons
				case 1: result.add(new FrageRadio(rs.getString(2)));
						break;
				//Checkbox
				case 2: result.add(new FrageCheckBox(rs.getString(2)));
						break;
				//Textfrage
				case 3:
						result.add(new FrageText(rs.getString(2)));
						break;
				//Dropdown Frage
				case 4:
					result.add(new FrageDropdown(rs.getString(2)));
					break;
				//Textarea Frage
				case 5:
					result.add(new FrageTextArea(rs.getString(2)));
					break;
				//Frage mit Notensystem
				case 6:
					result.add(new FrageNoten(rs.getString(2)));
					break;
			}
		}
		rs.close();	
		DbConnect.trennen();
		if (result == null)
		{
			throw new NullPointerException ();
		}
		else {
		return result;
		}
	}
	
	
	/**
	 * Bef�llt eine ArrayList<Frage> mit Fragen aus der Datenbank und gibt diese zur�ck
	 * F�r Fragenbearbeitung ben�tigt
	 * @param id int
	 * @param bezeichnung String
	 * @param where int
	 * @return fragen ArrayList<Frage>
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public ArrayList<Frage> leseFragen (int id, String bezeichnung, int where )
	{
		ArrayList<Frage> fragen = new ArrayList<Frage> ();		
		try {
			fragen = DBReader.getTableFragen(id,bezeichnung,where);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fragen;
	}
	
	/**
	 * Methode gibt alle Fragebogennamen in einer ArrayList<String> zur�ck
	 * Wird f�r die Darstellung im Tan Drucken aufgerufen.
	 * @return ArrayList<String> namen
	 */
	public static ArrayList<String> getFbNamen()
	{
		ArrayList<String> namen = new ArrayList<String>();
		try {
			DbConnect.verbinden();
			Statement stmnt = DbConnect.getCon().createStatement();
			ResultSet rs = null;
			rs = stmnt.executeQuery("SELECT FB_Titel From dbo.Fragebogen");
			while(rs.next()) {
				namen.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		DbConnect.trennen();
		return namen;
	}
	
	/**
	 * Methode gibt Alle Tans eines Fragebogens in form von einer ArrayList<String> retour.
	 * Wird beim Drucken ben�tigt
	 * @param fid int Fragebogen id
	 * @return ArrayList<String> tans ArrayList von Tans
	 */
	public static ArrayList<String> getTans(int fid) 
	{
		ArrayList<String> tans = new ArrayList<String>();
		try {
			DbConnect.verbinden();
			Statement stmnt = DbConnect.getCon().createStatement();
			ResultSet rs = null;
			rs = stmnt.executeQuery("SELECT T_ID From dbo.TAN WHERE FB_ID ="+ fid );
			while(rs.next()) {
				tans.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		DbConnect.trennen();
		return tans;
	}
	
	/**
	 * Hohlt den Fragebogen anhang der Fragebogen ID
	 * @param fid int Fragebogen id
	 * @return name String Fragebogenname
	 */
	public static String getFbName(int fid) 
	{
		String name="";
		try {
			DbConnect.verbinden();
			Statement stmnt = DbConnect.getCon().createStatement();
			ResultSet rs = null;
			rs = stmnt.executeQuery("SELECT FB_Titel From dbo.Fragebogen WHERE FB_ID ="+ fid );
			rs.next();
			name = rs.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		DbConnect.trennen();		
		return name;
	}

/**
	 * Methode gibt Alle Tans eines Fragebogens in form von einer ArrayList<String> retour.
	 * Wird beim Drucken ben�tigt
	 * @param fid int Fragebogen id
	 * @return ArrayList<String> tans ArrayList von Tans
	 */
	public static ArrayList<String> getFragen() 
	{
		ArrayList<String> fragens = new ArrayList<String>();
		try {
			DbConnect.verbinden();
			Statement stmnt = DbConnect.getCon().createStatement();
			ResultSet rs = null;
			rs = stmnt.executeQuery("SELECT F_Frage From dbo.Fragen");
			while(rs.next()) {
				fragens.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		DbConnect.trennen();
		return fragens;
	}
	
}
