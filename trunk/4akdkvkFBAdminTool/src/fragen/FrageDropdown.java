package fragen;
/**
 * 
 * @author Christoph Riebenbauer
 *
 */

public class FrageDropdown extends Frage {

	private final int typ = 4;
	/**
	 * Erstellt die neue Frage
	 * @param frage
	 */
	public FrageDropdown(String frage) {
		super(frage);
		// TODO Auto-generated constructor stub
	}
	/**
	 * Gibt den Typ zur�ck
	 */
	public int getTyp() {
		return typ;
	}

}
