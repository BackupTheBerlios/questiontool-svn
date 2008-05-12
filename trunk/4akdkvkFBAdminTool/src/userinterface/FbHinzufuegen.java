package userinterface;
public class FbHinzufuegen 
{
	public static FbHinzufuegenGUI gui1;
	fragen.Fragebogen fb1 = fragen.Fragebogen.getInstance();
	public static FbHinzufuegen FBfh = new FbHinzufuegen();
	
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

}
