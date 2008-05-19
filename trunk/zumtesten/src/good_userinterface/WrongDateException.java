package good_userinterface;

/**
 * Eigene ExceptionKlasse wird bei bei Datumsvergleich der schiefl�uft aufgerufen
 * In der Klasse FbErstellungGUI geworfen
 * @author Bennrsdorfer Dominik
 *
 */
@SuppressWarnings("serial")
public class WrongDateException extends Exception{

		/**
		 * Konstruktor der die �bergebene Fehler meldung an die Super Kasse weiter gibt
		 * (wird dann als Fehlertext defeniert.
		 * @param fehlermeldung String
		 */
	    public WrongDateException(String fehlermeldung) {
	        super(fehlermeldung);
	    }
}
