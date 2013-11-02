/**
 * @(#)MenuTable.java
 *
 *
 * @author Cecilia Tsoy
 * @version 1.00 2007/10/14
 */

import javax.swing.event.*;
import javax.swing.*;
import javax.swing.table.TableColumn;

public class MenuTable extends JTable implements TableModelListener
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MenuTable(MenuTableModel dataModel) 
    {

        //this.setAutoCreateColumnsFromModel(false);
        int colno = 4;//dataModel.getColumnCount();
        System.out.println("No cols: " + colno);
        for (int i = 0; i < colno; i++)
        {

        	TableColumn column = getColumnModel().getColumn(i);
        	
            if (i == 0)
                column.setPreferredWidth(350); 
            else 
                column.setPreferredWidth(120);
        }        

     }
            
      //protected JScrollPane scrollpane;
      protected MenuTableModel tModel;
    
}