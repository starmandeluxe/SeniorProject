import javax.swing.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.text.DecimalFormat;

/*
 * This class handles any event when the Menu JTable
 * in Tapioca King is changed
 *
 */
public class MyTableModelListener implements TableModelListener
{
	boolean flag = false;
	boolean flag2 = false;

	MenuTableModel tModel;
	//create a Decimal Format object to convert the double to a 
	//price format string
   	DecimalFormat df = new DecimalFormat("###0.00");
   	
   	//dialog window to display error message
   	JFrame drinkDialog = new JFrame();
	
	// It is necessary to keep the table since it is not possible
	// to determine the table from the event's source
	MyTableModelListener(MenuTableModel m) 
	{
		tModel = m;
	}
	
	public void tableChanged(TableModelEvent e) 
	{
		if (flag == true)
		{
			flag = false;
			return;
		}
		
		if (flag2 == true)
		{
			flag2 = false;
			return;
		}
			

		int mColIndex = e.getColumn();
		int firstRow = e.getFirstRow();
        int lastRow = e.getLastRow();
        int rowct = tModel.getDefMod().getRowCount();


		switch (e.getType()) 
		{
              case TableModelEvent.INSERT:
                // The inserted rows are in the range [firstRow, lastRow]
                for (int r=firstRow; r<=rowct; r++) 
                {
                    // Row r was inserted
                }
                break;
              case TableModelEvent.UPDATE:
                if (firstRow == TableModelEvent.HEADER_ROW) 
                {
                    if (mColIndex == TableModelEvent.ALL_COLUMNS) 
                    {
                        // A column was added
                        System.out.println("col added");
                    } 
                    else 
                    {
                        // Column mColIndex in header changed
                        System.out.println("col header changed");
                    }
                } 
                else 
                {
                    // The rows in the range [firstRow, lastRow] changed
                    
                    for (int r=firstRow; r<=rowct; r++) 
                    {
                        // Row r was changed
    
                        if (mColIndex == TableModelEvent.ALL_COLUMNS) 
                        {
                            // All columns in the range of rows have changed
                            
                            System.out.println("all cols changed");
                        } 
                        else 
                        {
                        	Double oldData = null;
                        	Double data = null;
                        	
                            // Column mColIndex changed
                            try
					        {
						        
						        oldData = tModel.getDrinks().get(firstRow).getPrice();
						        data = Double.parseDouble(((DefaultTableModel)e.getSource()).getValueAt(firstRow, mColIndex).toString());
						        
						        
						        tModel.getDrinks().get(firstRow).setPrice(data);
						        tModel.getDrinks().get(firstRow).calculateProfit();
						        Double newProfit = tModel.getDrinks().get(firstRow).getProfit();
						        
						        flag = true;
						      
						        ((DefaultTableModel)e.getSource()).setValueAt(df.format(newProfit), firstRow, mColIndex+1);
						        
						        flag2 = true;
						        ((DefaultTableModel)e.getSource()).setValueAt(df.format(data), firstRow, mColIndex);

						    }
					        catch (NumberFormatException ex)
					        {
					            System.out.println(ex);
					            JOptionPane.showMessageDialog(drinkDialog,
						        "Sale price must be numeric value",
						        "Drink Creation Failed",
						        JOptionPane.ERROR_MESSAGE);
						        ((DefaultTableModel)e.getSource()).setValueAt(df.format(oldData), firstRow, mColIndex);						        
						        return;
					        }
					        
					        
                        }
                    }
                }
                break;
              case TableModelEvent.DELETE:
                // The rows in the range [firstRow, lastRow] changed
                for (int r=firstRow; r<=lastRow; r++) 
                {
                	//System.out.println("row r deleted");
                    // Row r was deleted
                }
                break;
            }
	}
}
