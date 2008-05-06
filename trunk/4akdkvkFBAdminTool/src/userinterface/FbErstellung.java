package userinterface;

import java.util.GregorianCalendar;

public class FbErstellung
{	
	private static Fragebogen frageBogen;
	private String fbBeschreibung;
	private String fbTitel;
	private GregorianCalendar fbEndDatum;
	
	public FbErstellung(String fbBeschreibung,String fbTitel, GregorianCalendar fbEndDatum){
		
		frageBogen = frageBogen.getInstance();
		
		frageBogen.setBeschreibung(fbBeschreibung);
		frageBogen.setTitel(fbTitel);
		frageBogen.setEnddatum(fbEndDatum);
	}

}
