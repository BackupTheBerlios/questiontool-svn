package interfaceGuiDb;


import java.util.Date;
import java.util.ArrayList;

import fragen.Frage;
import fragen.FrageCheckBox;
import fragen.FrageRadio;
import fragen.FrageText;
import fragen.Fragebogen;
import db.DbWriter;
/**
 * Diese Klasse bildet die Schnittstelle zwischen der Datenbank und der Anwendung. Wenn Fragebogenerstellung beendet wird, kommt diese
 * Klasse zum Einsatz.
 * 
 * @author Edenhofer
 *
 */
public class SchnittstelleFBzuDB
{
	/**
	 * Diese Methode benutze alle Methoden der Klasse DbWriter um den Fragenbogen(Singleton) in die Db zu speichern.
	 */
	public static void speicherFb()
	{
		Fragebogen fb = Fragebogen.getInstance();
		boolean erg = DbWriter.speichereFragebogen(fb.getTitel(), fb.getBeschreibung(), fb.getEnddatum());
		if(erg)
			{
				int fbId = DbWriter.getMaxFbID();
				ArrayList<Frage> fragen = fb.getFragenList();
				int startFId = DbWriter.getMaxFID();
				startFId++;//Ansonsten wird falsche Frage genommen, eine ID zu niedrig
				for(Frage f : fragen)
					{
						DbWriter.speichereFrage(f.getFrage());//Setzt ID eins höher
						ArrayList<String> antworten = f.getAntworten();
						for(String a : antworten)
						{
							DbWriter.speichereAntwort(a, f.getTyp());
						}
					}
				int endFId = DbWriter.getMaxFID();
				
				DbWriter.speichereInHaben(startFId, endFId, fbId);
				DbWriter.speichereTans(fb.getTans(), fbId);
			}

	}
	
}
