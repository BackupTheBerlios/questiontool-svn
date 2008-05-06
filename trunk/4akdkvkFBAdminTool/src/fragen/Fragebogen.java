package fragen;

import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Fragebogen
{

	private static Fragebogen instance = null;
	private String titel;
	private String beschreibung;
	private GregorianCalendar enddatum;
	private ArrayList<Frage> fragenList;
	private int anzahl;


	 
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


	public GregorianCalendar getEnddatum()
	{
		return enddatum;
	}


	public void setEnddatum(GregorianCalendar enddatum)
	{
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

}
