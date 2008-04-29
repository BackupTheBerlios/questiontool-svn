package db;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 * 
 * @author Gerald Maresh
 *
 */
public class FBSpeichern {
	
	private DBReader dbr = new DBReader ();
	
	/**
	 * 
	 * @param id int
	 * @param bezeichnung Strubg
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
