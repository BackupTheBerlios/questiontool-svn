package fragen;
/**
 * 
 * @author Christoph Riebenbauer
 *
 */

public class FrageRadio extends Frage {

	private final int typ = 1;
	/**
	 * Erstellt eine neue Frage
	 * @param frage
	 */
	public FrageRadio(String frage) {
		super(frage);
		// TODO Auto-generated constructor stub
	}
	/**
	 * gibt den Typ zurück
	 */
	public int getTyp() {
		return typ;
	}

}
