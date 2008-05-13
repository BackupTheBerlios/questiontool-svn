package userinterface;
import java.util.ArrayList;


// TODO: Auto-generated Javadoc
/**
 * The Class Frage.
 */
public class Frage {
	
	/** The frage. */
	private String frage;
	
	/** The antworten. */
	private ArrayList<String> antworten;
	
	/** The fragentyp. */
	private String fragentyp;
	
	/**
	 * Instantiates a new frage.
	 * 
	 * @param frage the frage
	 */
	public Frage (String frage)
	{
		this.frage = frage;
	}

	/**
	 * Gets the antworten.
	 * 
	 * @return the antworten
	 */
	public ArrayList<String> getAntworten() {
		return antworten;
	}

	/**
	 * Sets the antworten.
	 * 
	 * @param antworten the new antworten
	 */
	public void setAntworten(ArrayList<String> antworten) {
		this.antworten = antworten;
	}
	
	/**
	 * Adds the antwort.
	 * 
	 * @param antwort the antwort
	 */
	public void addAntwort(String antwort)
	{
		antworten.add(antwort);
	}
	
	/**
	 * Delete antwort.
	 * 
	 * @param antwort the antwort
	 */
	public void deleteAntwort (String antwort)
	{
		antworten.remove(antwort);
	}
	
	/**
	 * Gets the frage.
	 * 
	 * @return the frage
	 */
	public String getFrage() {
		return frage;
	}

	/**
	 * Sets the frage.
	 * 
	 * @param frage the new frage
	 */
	public void setFrage(String frage) {
		this.frage = frage;
	}

	/**
	 * Gets the fragen typ.
	 * 
	 * @return the fragen typ
	 */
	public String getFragenTyp() {
		return fragentyp;
	}

	/**
	 * Sets the fragen typ.
	 * 
	 * @param typ the new fragen typ
	 */
	public void setFragenTyp(String typ) {
		this.fragentyp = typ;
	}
	

}
