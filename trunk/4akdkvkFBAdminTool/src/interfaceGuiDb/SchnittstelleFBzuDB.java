package interfaceGuiDb;

import java.util.ArrayList;

import fragen.Frage;
import fragen.Fragebogen;
import db.DbWriter;

public class SchnittstelleFBzuDB
{
	public static boolean speicherFb()
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
			}
		
		
		return true;
	}
}
