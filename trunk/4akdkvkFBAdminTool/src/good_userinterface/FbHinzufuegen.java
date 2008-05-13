package good_userinterface;
public class FbHinzufuegen 
{
	private static FbHinzufuegenGUI gui1;
	private static FbHinzufuegen FBfh = new FbHinzufuegen();
	private static good_fragen.Fragebogen fb1 = good_fragen.Fragebogen.getInstance();
	
	public FbHinzufuegen()
	{
	}
	
	public static void main(String[] args) 
	{
		gui1 = new FbHinzufuegenGUI();
	}
	
	public static FbHinzufuegen gib_Klasse()
	{
		return FBfh;
	}
	
	public static FbHinzufuegenGUI gibGUI()
	{
		return gui1;
	}
	
	public String getTitel()
	{
		return fb1.getTitel();
	}
	
	public String getBeschreibung()
	{
		return fb1.getBeschreibung();
	}

	public static FbHinzufuegenGUI getGui1() {
		return gui1;
	}

	public static FbHinzufuegen getFBfh() {
		return FBfh;
	}

	public static good_fragen.Fragebogen getFb1() {
		return fb1;
	}

}
