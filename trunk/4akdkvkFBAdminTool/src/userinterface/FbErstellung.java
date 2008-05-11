package userinterface;

import java.util.Date;
import fragen.*;

public class FbErstellung
{	
	private static Fragebogen frageBogen;
	
	public FbErstellung(String fbBeschreibung,String fbTitel, Date fbEndDatum)
	{
		frageBogen = frageBogen.getInstance();
		frageBogen.setBeschreibung(fbBeschreibung);
		frageBogen.setTitel(fbTitel);
		frageBogen.setEnddatum(fbEndDatum);
	}

}
