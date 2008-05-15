package good_userinterface;

/**
 * Klasse FbHinzufuegen
 * Diese Klasse wird nach dem erstellen eines Fragebogens aufgerufen.
 * Diese Klasse hat 3 Datenfelder:
 * 			.) FbHinzufuegenGUI gui1;
 * 			.) FbHinzufuegen Fbfh;
 * 			.) good_fragen.Fragebogen fb1; (good_fragen ist das Package)
 */
public class FbHinzufuegen 
{
	/**
	 * Datenfelder der Klasse FbHinzufuegen
	 */
	private static FbHinzufuegenGUI gui1;
	private static FbHinzufuegen FBfh = new FbHinzufuegen();
	private static good_fragen.Fragebogen fb1 = good_fragen.Fragebogen.getInstance();
	
	/**
	 * Konstruktor der Klasse FbHinzufuegen
	 * Ist allerdings leer.
	 *
	 */
	public FbHinzufuegen()
	{
	}
	
	/**
	 * Main-Methode der Klasse FbHinzufuegen.
	 * In dieser Methode wird das Datenfeld gui1 initialisiert, und somit aufgerufen.
	 */
	public static void main(String[] args) 
	{
		gui1 = new FbHinzufuegenGUI();
	}
	
	/**
	 * Die Methode gib_Klasse() gibt das Datenfeld Fbfh zurück.
	 */
	public static FbHinzufuegen gib_Klasse()
	{
		return FBfh;
	}
	
	/**
	 * Die Methode FbHinzufuegenGUI gibt das Datenfeld gui1 zurück.
	 */
	public static FbHinzufuegenGUI gibGUI()
	{
		return gui1;
	}
	
	/**
	 * Die Methode getTitel() gibt das Datenfeld titel aus dem Objekt fb1 zurück.
	 */
	public String getTitel()
	{
		return fb1.getTitel();
	}
	
	/**
	 * Die Methode getBeschreibung() gibt das Datenfeld beschreibung aus dem Objekt fb1 zurück.
	 */
	public String getBeschreibung()
	{
		return fb1.getBeschreibung();
	}

	/**
	 * Die Methode FbHinzufuegenGUI gibt das Datenfeld gui1 zurück.
	 */
	public static FbHinzufuegenGUI getGui1() {
		return gui1;
	}

	/**
	 * Die Methode gib_Klasse() gibt das Datenfeld Fbfh zurück.
	 */
	public static FbHinzufuegen getFBfh() {
		return FBfh;
	}

	/**
	 * Die Methode getTitel() gibt das Datenfeld titel aus dem Objekt fb1 zurück.
	 */
	public static good_fragen.Fragebogen getFb1() {
		return fb1;
	}

}
