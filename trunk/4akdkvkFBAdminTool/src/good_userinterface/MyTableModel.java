package good_userinterface;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import good_fragen.Frage;


@SuppressWarnings("serial")
public class MyTableModel extends AbstractTableModel
{

	private String[] spaltenNamen = {"FrageNr","Frage"};
    ArrayList<Frage> alleFragen = new ArrayList<Frage>();
    private boolean columnEditable;
    private int column;
    
       
   	public Frage getSelectedFrage(int i)
   	{
   		return alleFragen.get(i);
   	}
   	
    public void arrayListEinfuegen(ArrayList<Frage> arraylist)
    {
          alleFragen = arraylist;
    }
        
        public void loescheFrage(int nr)
        {
        	alleFragen.remove(nr);
        }
        
        public void clearArrayList()
        {
               alleFragen.clear();
        }
    
        public int getColumnCount() {
            return spaltenNamen.length;
        }

        public int getRowCount() {
            return alleFragen.size();
        }

        public String getColumnName(int col) {
            return spaltenNamen[col];
        }

        public Object getValueAt(int row, int col) {
            Frage p = alleFragen.get(row);
            switch (col)
            {
            	case 0: return ""+(row+1);
                case 1: return p.getFrage();
            }
            return col;
        }

        /*
         * JTable uses this method to determine the default renderer/
         * editor for each cell.  If we didn't implement this method,
         * then the last column would contain text ("true"/"false"),
         * rather than a check box.
         */
       /* public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }*/

        /*
         * Don't need to implement this method unless your table's
         * editable.
         */
        public boolean isCellEditable(int row, int col) {
            //Note that the data/cell address is constant,
            //no matter where the cell appears onscreen.
            if(col==column)
            {
                return columnEditable;
            }
            else
            {
                return false;   
            }
        }
        
        public void setEditColumn(boolean a, int col)
        {
            columnEditable=a;
            column=col;
        }

        /*
         * Don't need to implement this method unless your table's
         * data can change.
         */
        public void setValueAt(Object value, int row, int col) {
            
        }
        
        public void addFrage(Frage s)
        {
            alleFragen.add(s);
        }
        
        public int getSize()
        {
        	return alleFragen.size();
        }

        public ArrayList<Frage> gibFragenArray()
        {
        	return alleFragen;
        }
}
