package userinterface;

import java.util.Date;
import java.util.GregorianCalendar;
import fragen.*;

public class FbErstellung
{	
	private static Fragebogen frageBogen;
	private String fbBeschreibung;
	private String fbTitel;
	private GregorianCalendar fbEndDatum;
	
	public FbErstellung(String fbBeschreibung,String fbTitel, Date fbEndDatum){
		
		frageBogen = frageBogen.getInstance();
		frageBogen.setBeschreibung(fbBeschreibung);
		frageBogen.setTitel(fbTitel);
		frageBogen.setEnddatum(fbEndDatum);
	}

}
