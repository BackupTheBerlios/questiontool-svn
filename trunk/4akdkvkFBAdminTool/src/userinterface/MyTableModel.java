package userinterface;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;


// TODO: Auto-generated Javadoc
/**
 * The Class MyTableModel.
 */
public class MyTableModel extends AbstractTableModel
{

	/** The spalten namen. */
	private String[] spaltenNamen = {"FrageNr","Frage"};
    
    /** The alle fragen. */
    ArrayList<Frage> alleFragen = new ArrayList<Frage>();
    
    /** The column editable. */
    private boolean columnEditable;
    
    /** The column. */
    private int column;
    
    /**
     * Instantiates a new my table model.
     */
    public MyTableModel()
        {
             
        }
        
    	/**
	     * Gets the selected frage.
	     * 
	     * @param i the i
	     * 
	     * @return the selected frage
	     */
	    public Frage getSelectedFrage(int i)
    	{
    		return alleFragen.get(i);
    	}
        
        /**
         * Array list einfuegen.
         * 
         * @param arraylist the arraylist
         */
        public void arrayListEinfuegen(ArrayList<Frage> arraylist)
        {
               alleFragen = arraylist;
        }
        
        /**
         * Loesche frage.
         * 
         * @param nr the nr
         */
        public void loescheFrage(int nr)
        {
        	alleFragen.remove(nr);
        }
        
        /**
         * Clear array list.
         */
        public void clearArrayList()
        {
               alleFragen.clear();
        }
    
        /* (non-Javadoc)
         * @see javax.swing.table.TableModel#getColumnCount()
         */
        public int getColumnCount() {
            return spaltenNamen.length;
        }

        /* (non-Javadoc)
         * @see javax.swing.table.TableModel#getRowCount()
         */
        public int getRowCount() {
            return alleFragen.size();
        }

        /* (non-Javadoc)
         * @see javax.swing.table.AbstractTableModel#getColumnName(int)
         */
        public String getColumnName(int col) {
            return spaltenNamen[col];
        }

        /* (non-Javadoc)
         * @see javax.swing.table.TableModel#getValueAt(int, int)
         */
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
        /* (non-Javadoc)
         * @see javax.swing.table.AbstractTableModel#isCellEditable(int, int)
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
        
        /**
         * Setzt die edit column.
         * 
         * @param a the a
         * @param col the col
         */
        public void setEditColumn(boolean a, int col)
        {
            columnEditable=a;
            column=col;
        }

        /*
         * Don't need to implement this method unless your table's
         * data can change.
         */
        /* (non-Javadoc)
         * @see javax.swing.table.AbstractTableModel#setValueAt(java.lang.Object, int, int)
         */
        public void setValueAt(Object value, int row, int col) {
            
        }
        
        /**
         * Adds the frage.
         * 
         * @param s the s
         */
        public void addFrage(Frage s)
        {
            alleFragen.add(s);
        }
        
        /**
         * Gets the size.
         * 
         * @return the size
         */
        public int getSize()
        {
        	return alleFragen.size();
        }

        /**
         * Gib fragen array.
         * 
         * @return the array list< frage>
         */
        public ArrayList<Frage> gibFragenArray()
        {
        	return alleFragen;
        }
}
