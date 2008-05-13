package good_userinterface;

import java.util.Date;
import fragen.*;

/**
 * FÜR WAS GIBTS DIESE KLASSE ??? KOPIERTS EUCH MAL ALLES LOKAL RUNTER UND DANN LÖSCHT DIESE KLASSE. WETTEN ES GEHT ALLES ? ;)
 * sorry #@&% Caps lock =)
 * @author Sparky
 *
 */
public class FbErstellung
{	
	private static Fragebogen frageBogen;
	
	public FbErstellung(String fbBeschreibung,String fbTitel, Date fbEndDatum)
	{
		frageBogen = Fragebogen.getInstance();
		frageBogen.setBeschreibung(fbBeschreibung);
		frageBogen.setTitel(fbTitel);
		frageBogen.setEnddatum(fbEndDatum);
	}

}
