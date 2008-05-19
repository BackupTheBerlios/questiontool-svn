package good_fragen;

import java.util.Date;
import java.util.ArrayList;

public class Fragebogen
{

	private static Fragebogen instance = null;
	private String titel;
	private String beschreibung;
	private Date enddatum;
	private ArrayList<Frage> fragenList;
	private int anzahl; //hoffentlich anzahl der befragten
	private ArrayList<String> tans;
	private int id;
 
	 public Fragebogen()
	 {
		 fragenList = new ArrayList<Frage>();
	 }

	public static Fragebogen getInstance()
	{
		if ( instance == null )
			{
				instance = new Fragebogen();

			}
		return instance;
	}

	public String getBeschreibung()
	{
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung)
	{
		this.beschreibung = beschreibung;
	}


	public Date getEnddatum()
	{
		return enddatum;
	}

	public void setEnddatum(Date enddatum)
	{
		//Datum zerlegen und Monat + 1 rechnen
		this.enddatum = enddatum;
	}

	public ArrayList<Frage> getFragenList()
	{
		return fragenList;
	}


	public void setFragenList(ArrayList<Frage> fragenList)
	{
		this.fragenList = fragenList;
	}


	public void addFrage(Frage frage)
	{
		fragenList.add(frage);
	}


	public void deleteFrage(Frage frage)
	{
		fragenList.remove(frage);
	}


	public String getTitel()
	{
		return titel;
	}


	public void setTitel(String titel)
	{
		this.titel = titel;
	}


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
