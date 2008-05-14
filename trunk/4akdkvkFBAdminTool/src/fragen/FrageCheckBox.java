package fragen;
/**
 * 
 * @author Christoph Riebenbauer
 *
 */
public class FrageCheckBox extends Frage {

	
	private final int typ = 2;
	/**
	 * Erstellt die neue Frage
	 * @param frage
	 */
	public FrageCheckBox(String frage) {
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
