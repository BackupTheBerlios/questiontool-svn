package fragen;

/**
 * 
 * @author Christoph Riebenbauer
 *
 */

public class FrageTextArea extends Frage {

	private final int typ = 5;
	/**
	 * Erstellt eine neue Frage
	 * @param frage
	 */
	public FrageTextArea(String frage) {
		super(frage);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Gibt den Typ zurück
	 */
	public int getTyp() {
		return typ;
	}
	
}
