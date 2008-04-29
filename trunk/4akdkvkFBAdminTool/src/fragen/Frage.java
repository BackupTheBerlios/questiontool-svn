package fragen;
import java.util.ArrayList;




public abstract class Frage {
	
	private String frage;
	private ArrayList<String> antworten;
	
	public Frage (String frage)
	{
		antworten = new ArrayList<String>();
		this.frage = frage;
	}

	public ArrayList<String> getAntworten() {
		return antworten;
	}

	public void setAntworten(ArrayList<String> antworten) {
		this.antworten = antworten;
	}
	
	public void addAntwort(String antwort)
	{
		antworten.add(antwort);
	}
	
	public void deleteAntwort (String antwort)
	{
		antworten.remove(antwort);
	}
	
	public String getFrage() {
		return frage;
	}

	public void setFrage(String frage) {
		this.frage = frage;
	}
	//Die Abstrakte Methode ist wichtig, denn ohne diese wäre Speicherung der Frage wesentlich umständlicher
	public abstract int getTyp();

}
