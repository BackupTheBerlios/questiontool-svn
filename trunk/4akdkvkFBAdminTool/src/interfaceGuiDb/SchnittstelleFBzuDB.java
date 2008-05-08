package interfaceGuiDb;


import java.util.Date;
import java.util.ArrayList;

import fragen.Frage;
import fragen.FrageCheckBox;
import fragen.FrageRadio;
import fragen.FrageText;
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
	
	public static void main(String[] args)
	{
		Fragebogen fb = Fragebogen.getInstance();
		fb.setBeschreibung("Test");
		fb.setTitel("Test");
		fb.setEnddatum(new Date(434324234));
		FrageCheckBox fc = new FrageCheckBox("Sein oder nicht sein?");
		fc.addAntwort("test1");
		fc.addAntwort("test2");
		fc.addAntwort("test3");
		
		FrageText ft = new FrageText("Ist der Glaube das Ende allen Wissens?");
		ft.addAntwort("Test1");
		ft.addAntwort("Test2");
		ft.addAntwort("Test3");
		
		FrageRadio fr = new FrageRadio("Wer war Karl Marx?");
		fr.addAntwort("Test122");
		fr.addAntwort("Test12");
		fr.addAntwort("Test2");
		
		fb.addFrage(fc);
		fb.addFrage(ft);
		fb.addFrage(fr);
		
        speicherFb();
		
		
		
		
		
	}
}
