package userinterface;
// TODO: Auto-generated Javadoc

/**
 * The Class FbHinzufuegen.
 */
public class FbHinzufuegen 
{
	
	/** The gui1. */
	public static FbHinzufuegenGUI gui1;
	
	/** The fb1. */
	fragen.Fragebogen fb1 = fragen.Fragebogen.getInstance();
	
	/** The F bfh. */
	public static FbHinzufuegen FBfh = new FbHinzufuegen();
	
	/**
	 * Instantiates a new fb hinzufuegen.
	 */
	public FbHinzufuegen()
	{
	}
	
	/**
	 * The main method.
	 * 
	 * @param args the arguments
	 */
	public static void main(String[] args) 
	{
		gui1 = new FbHinzufuegenGUI();
	}
	
	/**
	 * Gib_ klasse.
	 * 
	 * @return the fb hinzufuegen
	 */
	public static FbHinzufuegen gib_Klasse()
	{
		return FBfh;
	}
	
	/**
	 * Gib gui.
	 * 
	 * @return the fb hinzufuegen gui
	 */
	public static FbHinzufuegenGUI gibGUI()
	{
		return gui1;
	}
	
	/**
	 * Gets the titel.
	 * 
	 * @return the titel
	 */
	public String getTitel()
	{
		return fb1.getTitel();
	}
	
	/**
	 * Gets the beschreibung.
	 * 
	 * @return the beschreibung
	 */
	public String getBeschreibung()
	{
		return fb1.getBeschreibung();
	}

}
