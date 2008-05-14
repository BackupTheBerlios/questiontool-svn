package fragen;
import java.util.ArrayList;

/**
 * 
 * @author Christoph Riebenbauer
 *
 */


public abstract class Frage {
	
	private String frage;
	private ArrayList<String> antworten;
	
	/**
	 * Frage wird erstellt
	 * mit einer neuen ArrayList f�r Antworten
	 * @param frage
	 */
	public Frage (String frage)
	{
		antworten = new ArrayList<String>();
		this.frage = frage;
	}

	/**
	 * Hier werden die Antworten in einer ArrayList zur�ckgegeben
	 * @return
	 */
	public ArrayList<String> getAntworten() {
		return antworten;
	}

	/**
	 * Setzt alle Antworten
	 * @param antworten
	 */
	public void setAntworten(ArrayList<String> antworten) {
		this.antworten = antworten;
	}
	
	/**
	 * F�gt eine neue Antwort hinzu
	 * @param antwort
	 */
	public void addAntwort(String antwort)
	{
		antworten.add(antwort);
	}
	
	/**
	 * L�scht eine Antwort
	 * @param antwort
	 */
	public void deleteAntwort (String antwort)
	{
		antworten.remove(antwort);
	}
	
	/**
	 * Gibt den Fragentext zur�ck
	 * @return
	 */
	public String getFrage() {
		return frage;
	}

	/**
	 * Setzt den Fragentext
	 * @param frage
	 */
	public void setFrage(String frage) {
		this.frage = frage;
	}
	//Die Abstrakte Methode ist wichtig, denn ohne diese w�re Speicherung der Frage wesentlich umst�ndlicher
	public abstract int getTyp();

}
