package fragen;
/**
 * 
 * @author Christoph Riebenbauer
 *
 */

public class FrageText extends Frage {

	private final int typ = 3;
	/**
	 * Erstellt eine neue Frage
	 * @param frage
	 */
	public FrageText(String frage) {
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
