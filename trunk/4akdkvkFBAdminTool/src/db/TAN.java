package db;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class TAN {
	
	private static TAN instance = null;
	
	public TAN ()
	{
		
	}
	
	public static TAN getInstance ()
	{
		if (instance == null)
		{
			instance = new TAN();
		}
		return instance;
	}
	
	/**
	 * 
	 * @param fbId -> int -> Die Id des zu erstellenden Fragebogens
	 * @param anzahlbefragte -> int -> Die Anzahl der Befragten für die dieser Fragebogen erstellt werden soll
	 * @param spezialTan -> String -> Setz die letzten beiden stellen des TANs nach individuellen Wünschen (ist Standardmäßig mit "00" zu stezen!)
	 * @return -> ArrayList<String> -> Die erzeugten TANs (anzusprechen von Index 0 bis (anzahlbefragte - 1)) 
	 * TAN: Xxxxx xxxx xx xx xx xx
	 * Ersten 5 Stellen -> Fragebogen ID
	 * Nächsten 4 Stellen -> Benutzer IDs d.h. wenn den Fragebogen 30 Leute ausfüllen sollen dann stehen da die Zahlen 0 bis 29
	 * Nächsten 2 Stellen -> Tag (01 - 31)
	 * Nächsten 2 Stellen -> Monat (01 – 12)
	 * Nächsten 2 Stellen -> Jahreszahl (01 - 12)
	 * letzten beiden Stellen -> Als reserve, sollen standardmäßig mit 00 gefüllt werden. Sollte uns nachträglich noch etwas einfallen können wir diese Stellen dazu verwenden
	 */
	public static ArrayList<String> getTANS (int fbId, int anzahlbefragte, String spezialTan)
	{
		ArrayList<String> ergebnis = new ArrayList<String> ();
		
		for (int i = 0; i < anzahlbefragte; i++)
		{
			String a = "";
			
			//Erstellen der ersten 5 Stellen (Frageboden ID)
			String fbID = fbId + "";
			String fragebogenId = "";
			int laengefbId = fbID.length();
			
			switch (laengefbId)
			{
			case 1:
				fragebogenId = "0000" + fbId;
				break;
				
			case 2:
				fragebogenId = "000" + fbId;
				break;
				
			case 3:
				fragebogenId = "00" + fbId;
				break;
				
			case 4:
				fragebogenId = "0" + fbId;
				break;
				
			case 5:
				fragebogenId = "" + fbId;
				break;
			}
			a = fragebogenId;
			
			//Erstellen der nächsten 4 Stellen (Benutzer IDs):
			String anzahl = anzahlbefragte + "";
			int laengeanzahl = anzahl.length();
			
			switch (laengeanzahl)
			{
			case 1:
				anzahl = "0000" + i;
				break;
				
			case 2:
				anzahl = "000" + i;
				break;
				
			case 3:
				anzahl = "00" + i;
				break;
				
			case 4:
				anzahl = "0" + i;
				break;
				
			case 5:
				anzahl = "" + i;
				break;
			}			
			a = fragebogenId + anzahl + "";
			
			//Erstellen der nächsten 2 Stellen (Monat der Erstellung):
			GregorianCalendar gc = new GregorianCalendar ();
			//int day = gc.get(Calendar.DAY_OF_MONTH);
			int day = 1;
			String dayStr = day + "";
			int laengeday = dayStr.length();
			if (laengeday == 1)
			{
				dayStr = "0" + day;
			}
			a = fragebogenId + anzahl + dayStr + "";
						
			
			//Erstellen der nächsten 2 Stellen (Monat der Erstellung):
			int month = gc.get(Calendar.MONTH);
			//Monat muss +1 gerechnet werden da die Monate intern von 0 bis 11 gezählt werden
			month = month + 1;
			String monthStr = month + "";
			int laengemonth = monthStr.length();
			if (laengemonth == 1)
			{
				monthStr = "0" + month;
			}
				a = fragebogenId + anzahl + dayStr + monthStr + "";
			
				
			
			//Erstellen der nächsten 2 Stellen (Monat der Erstellung):
			int year = gc.get(Calendar.YEAR);
			a = fragebogenId + anzahl + day + month + year + "";	
			
			a = fragebogenId + anzahl + dayStr + monthStr + year + spezialTan;
			ergebnis.add(a);
		}		
		
		return ergebnis;
	}

}
