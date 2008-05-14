package fragen;

import java.util.Date;
import java.util.ArrayList;

/**
 * 
 * @author Christoph Riebenbauer
 *
 */
public class Fragebogen
{

	private static Fragebogen instance = null;
	private String titel;
	private String beschreibung;
	private Date enddatum;
	private ArrayList<Frage> fragenList;
	private int anzahl;
	private ArrayList<String> tans;
	private int id;
 
	/**
	 *  Hier wird ein Fragebogenobjekt erzeugt mit einer neuen Fragen ArrayListe
	 *
	 */
	 public Fragebogen()
	 {
		 fragenList = new ArrayList<Frage>();
	 }
	 /**
	  * 
	  * @return
	  * Es wird Falls noch keine instanz eröffnet ist wird eine neue erstellt
	  * sonst wird die schon eröffnete zurückgegeben
	  */
	public static Fragebogen getInstance()
	{
		if ( instance == null )
			{
				instance = new Fragebogen();

			}
		return instance;
	}
	/**
	 * Gibt die Beschreibung des Fragebogens zurück
	 * @return
	 */
	public String getBeschreibung()
	{
		return beschreibung;
	}

	/**
	 * Setzt die Beschreibung
	 * @param beschreibung
	 */
	public void setBeschreibung(String beschreibung)
	{
		this.beschreibung = beschreibung;
	}


	/**
	 * Gibt das Enddatum zurück
	 * @return
	 */
	public Date getEnddatum()
	{
		return enddatum;
	}
	/**
	 * setzt das Enddatum
	 * @param enddatum
	 */
	public void setEnddatum(Date enddatum)
	{
		//Datum zerlegen und Monat + 1 rechnen
		this.enddatum = enddatum;
	}
	/**
	 * gibt alle Fragen zurück die der Fragebogen enthält
	 * @return
	 */
	public ArrayList<Frage> getFragenList()
	{
		return fragenList;
	}

	/**
	 * Setzt alle Fragen neu
	 * @param fragenList
	 */
	public void setFragenList(ArrayList<Frage> fragenList)
	{
		this.fragenList = fragenList;
	}
	/**
	 * Hier wird eine Frage hinzugefügt
	 * @param frage
	 */
	public void addFrage(Frage frage)
	{
		fragenList.add(frage);
	}

	/**
	 * hier wird eine Frage gelöscht
	 * @param frage
	 */
	public void deleteFrage(Frage frage)
	{
		fragenList.remove(frage);
	}

	/**
	 * hier wird der Titel zurückgegeben
	 * @return
	 */
	public String getTitel()
	{
		return titel;
	}

	/**
	 * gibt den Titel des Fragebogen zurück
	 * @param titel
	 */
	public void setTitel(String titel)
	{
		this.titel = titel;
	}

	/**
	 * gibt die Anzahl zurück, wieviele Leute den Fragebogen bekommen sollen
	 * @return
	 */
	public int getAnzahl()
	{
		return anzahl;
	}


	public void setAnzahl(int anzahl)
	{
		this.anzahl = anzahl;
	}

	public void setTans( ArrayList<String> tans )
    {
	    this.tans = tans;
    }

	public ArrayList<String> getTans()
    {
	    return tans;
    }

	public void setId( int id )
    {
	    this.id = id;
    }

	public int getId()
    {
	    return id;
    }

}
