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
	 * mit einer neuen ArrayList für Antworten
	 * @param frage
	 */
	public Frage (String frage)
	{
		antworten = new ArrayList<String>();
		this.frage = frage;
	}

	/**
	 * Hier werden die Antworten in einer ArrayList zurückgegeben
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
	 * Fügt eine neue Antwort hinzu
	 * @param antwort
	 */
	public void addAntwort(String antwort)
	{
		antworten.add(antwort);
	}
	
	/**
	 * Löscht eine Antwort
	 * @param antwort
	 */
	public void deleteAntwort (String antwort)
	{
		antworten.remove(antwort);
	}
	
	/**
	 * Gibt den Fragentext zurück
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
	//Die Abstrakte Methode ist wichtig, denn ohne diese wäre Speicherung der Frage wesentlich umständlicher
	public abstract int getTyp();

}
