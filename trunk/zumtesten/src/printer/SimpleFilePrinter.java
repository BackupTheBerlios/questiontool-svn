package printer;
/* SimpleFilePrinter.java */

import java.awt.*;
import java.awt.print.*;
import java.io.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;


/**
 * Die Klasse SimpleFilePrinter druckt die TANs aus.
 * Sie verlangt eine ArrayList vom Typ String. 3 Tans werden nebeneinander ausgedruckt
 * Nach dem Erstellen des Fragebogens öffnet sich ein Druckdialog, wo der Drucker ausgewählt werden kann.
 */
public class SimpleFilePrinter
implements Printable
{
  //---Konstanten--------------------------------------
  /** The Constant RESMUL. */
  private static final int RESMUL = 4;

  //---Membervariablen---------------------------------
  /** The pjob. */
  private PrinterJob       pjob;
  
  /** The pageformat. */
  private PageFormat       pageformat;
  
  /** Das Hilfsobjekt */
  private FilePrintHelper  fph;
  
  
  /** Diese Datei wird gelesen */
  private RandomAccessFile in;
  
  /** The tan. */
  private ArrayList<String> tan;
  
  /** Der Fragebogenname*/
  private String fbname;

  //---Konstruktoren-----------------------------------
  /**
   * Konstruktor
   * 
   * @param tan Eine ArrayList vom Typ String, wo die TANs gespeichert sind
   */
  public SimpleFilePrinter(ArrayList<String> tan,String fbname)
  {
    this.pjob  = PrinterJob.getPrinterJob();
    this.tan=tan;
    this.fbname=fbname;
  }

  
  /**
   * Richtet die Seite ein
   * 
   * @return true, if successful
   */
  public boolean setupPageFormat()
  {
    PageFormat defaultPF = pjob.defaultPage();
    this.pageformat = pjob.pageDialog(defaultPF);
    pjob.setPrintable(this, this.pageformat);
    return (this.pageformat != defaultPF);
  }

  /**
   * Gibt die Druckeigenschaften zurück.
   * 
   * @return true, if successful
   */
  public boolean setupJobOptions()
  {
    return pjob.printDialog();
  }

  /**
   * Druckt die file.
   * 
   * @throws PrinterException the printer exception
   * @throws IOException Signals that an I/O exception has occurred.
   */
  public void printFile()
  throws PrinterException, IOException
  {
    fph = new FilePrintHelper();
    in = new RandomAccessFile(schreibeTempDatei(), "r");
    pjob.print();
    in.close();

  }

  /**
   * Schreibe temp datei.
   * 
   * @return the file
   */
  public File schreibeTempDatei()
  {
	  File file = new File("Fragebogen", ".tmp");
	  try {
		 file = File.createTempFile("Fragebogen", ".tmp");
		    PrintWriter out
		    = new PrintWriter(new BufferedWriter(new FileWriter(file)));
		    int counter = 0;
		    for (String s: tan)
		    {
		    	counter++;
		     	out.write(s + "        ");
		    	
		    	if (counter%3 == 0 )
		    	{
		    		out.println();
		    		out.println();
		    		out.println();
		    		out.println();
		    		out.println();
		    	}
		      }
		    out.flush();
		    return file;
	} catch (IOException e) {

		e.printStackTrace();
	}
	 return file;
  }
  
  
  //---Implementierung von Printable-------------------
  /* (non-Javadoc)
   * @see java.awt.print.Printable#print(java.awt.Graphics, java.awt.print.PageFormat, int)
   */
  public int print(Graphics g, PageFormat pf, int page)
  throws PrinterException
  {
    int ret = PAGE_EXISTS;
    String line = null;
    try {
      if (fph.knownPage(page)) {
        in.seek(fph.getFileOffset(page));
        line = in.readLine();
      } else {
        long offset = in.getFilePointer();
        line = in.readLine();
        if (line == null) {
          ret = NO_SUCH_PAGE;
        } else {
          fph.createPage(page);
          fph.setFileOffset(page, offset);
        }
      }
      if (ret == PAGE_EXISTS) {
        //Seite ausgeben, Grafikkontext vorbereiten
        Graphics2D g2 = (Graphics2D)g; 
        g2.scale(1.0 / RESMUL, 1.0 / RESMUL);
        int ypos = (int)pf.getImageableY() * RESMUL;
        int xpos = ((int)pf.getImageableX() + 2) * RESMUL;
        int yd = 12 * RESMUL;
        int ymax = ypos + (int)pf.getImageableHeight() * RESMUL - yd;
        //Seitentitel ausgeben
        ypos += yd; 
        g2.setColor(Color.black);
        g2.setFont(new Font("Monospaced", Font.BOLD, 10 * RESMUL));
        g.drawString(fbname +" Seite " + (page + 1), xpos, ypos);
        g.drawLine(
          xpos,
          ypos + 6 * RESMUL,
          xpos + (int)pf.getImageableWidth() * RESMUL,
          ypos + 6 * RESMUL
        );
        ypos += 2 * yd;
        //Zeilen ausgeben
        g2.setColor(new Color(0, 0, 127)); 
        g2.setFont(new Font("Monospaced", Font.PLAIN, 10 * RESMUL));
        while (line != null) {
          g.drawString(line, xpos, ypos);
          ypos += yd;
          if (ypos >= ymax) {
            break;
          }
          line = in.readLine();
        }
      }
    } catch (IOException e) {
      throw new PrinterException(e.toString());
    }
    return ret;
  }
}