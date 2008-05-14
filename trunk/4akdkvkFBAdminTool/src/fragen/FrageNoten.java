package fragen;

/**
 * 
 * @author Christoph Riebenbauer
 *
 */
public class FrageNoten extends Frage {

	private final int typ = 6;
	/**
	 * Erstellt eine neue Frage
	 * @param frage
	 */
	public FrageNoten(String frage) {
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
