package db;
import java.sql.SQLException;
import java.util.ArrayList;
import fragen.Frage;


/**
 * 
 * @author Gerald Maresh
 *
 */
public class FBSpeichern {
	
	/**
	 * Befüllt eine ArrayList<Frage> mit Fragen aus der Datenbank und gibt diese zurück
	 * @param id int
	 * @param bezeichnung String
	 * @param where int
	 * @return fragen ArrayList<Frage>
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public ArrayList<Frage> leseFragen (int id, String bezeichnung, int where ) throws SQLException, ClassNotFoundException
	{
		ArrayList<Frage> fragen = new ArrayList<Frage> ();
		DBReader.init("");		
		fragen = DBReader.getTableFragen(id,bezeichnung,where);
		DBReader.close();
		return fragen;
	}
}
