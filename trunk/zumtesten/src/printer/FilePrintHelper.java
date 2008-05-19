package printer;
/* Das ist eine Hilfsklasse, um die Tans auszudrucken */

import java.util.*;

public class FilePrintHelper
{
  //---Membervariablen----------------------------------
  @SuppressWarnings("unchecked")
  Vector pageinfo;

  //---Konstruktor--------------------------------------
  @SuppressWarnings("unchecked")
  public FilePrintHelper()
  {
    pageinfo = new Vector();
  }

  //---Seitendefinition und -abfrage--------------------
  @SuppressWarnings("unchecked")
  public void createPage(int page)
  {
    for (int i = pageinfo.size(); i <= page; ++i) {
      pageinfo.addElement(new Entry());
    }
  }

  public boolean knownPage(int page)
  {
    return page < pageinfo.size();
  }

  //---Verwaltung der Offsets---------------------------
  public long getFileOffset(int page)
  {
    Entry entry = (Entry)pageinfo.elementAt(page);
    return entry.fileoffset;
  }

  public void setFileOffset(int page, long fileoffset)
  {
    Entry entry = (Entry)pageinfo.elementAt(page);
    entry.fileoffset = fileoffset;
  }

  //---Lokale Klasse Entry------------------------------
  static class Entry
  {
    public long fileoffset;

    public Entry()
    {
      this.fileoffset = -1;
    }
  }
}