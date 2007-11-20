import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.*;
import java.util.Date;

/**
 * Klasse erstellt eine Simple Textdatei mit bestimmten Anfangstext
 * und kann in diese schreiben
 * Praktisch für eine Log-File
 * 
 * Nicht vergessen sonst steht nichts in der Datei
 * BufferedWriter.close(); // Call close() when finished writing, otherwise data may not be written to disk.
 * @author Bennersdorfe Dminik
 *
 */
public class reporter {

	final File f = new File("\\PR.log");
	private BufferedWriter fileout;
	private Date datum = new Date();

	public reporter()
	{
		createLogFile();
	}
	
	private void createLogFile()
	{
		try{
			fileout = new BufferedWriter(new FileWriter(f));
			fileout.write("Log File erstellt am: " + datum);
			fileout.close(); // Call close() when finished writing, otherwise data may not be written to disk.
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Achtung "\n" Windows eigener Texteditor ist zum Dumm für den Zeilenumbruch mittels \n
	 * Notepad++ oder Wordpad stehlt es richtig dar, Windows Standard Editor schreibt alles in einer Wurscht
	 * zb. Erstellt am: Sat Oct 20 20:24:16 CEST 2007/nhallo/ntest
	 * @param s String 
	 */
	public void writeLog(String s)
	{
		try{
			fileout = new BufferedWriter(new FileWriter(f,true)); // f=File, boolean true für append Modus
			fileout.write("\n"+s + new Date());
			fileout.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}