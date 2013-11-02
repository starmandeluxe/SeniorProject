/**
 * @(#)Products.java
 *
 *
 * @author Cecilia Tsoy, Alex Kort
 * @version 1.00 2007/10/14
 */

import java.text.DecimalFormat;

/**
 * This class creates a product for customers to buy and 
 * to be put on the menu. A Product has ingredients, 
 * price, and cost
 *
 */
public class Products 
{
    DecimalFormat df = new DecimalFormat("###0.00");
    
    /* Create a new drink */    
    public Products(String name, Double price, Ingredients[] addOn, MenuTableModel Model)
    {
        model = Model;
        pName = name;
        pPrice = price;
        pAddon = addOn;
        pCost = calculateCost(addOn, Model);
        pProfit = calculateProfit();
    }
    
    public Products(String name, Ingredients[] addOn, MenuTableModel Model)
    {
        model = Model;
        pName = name;
        pAddon = addOn;
        pPrice = 0.0;
        pCost = calculateCost(addOn, Model);
        pProfit = 0.0;
    }
    
   
    
    /* Calculate and return the cost of a list of Ingredients */
    protected Double calculateCost(Ingredients[] raw, MenuTableModel Model)
    {
        /* Include the cost of straw, napkin and cup */
        Double c_cost = new Double(0.0); 
        c_cost += 0.07;
        
        for (int i = 0; i < raw.length; i++)
        {
        	if (raw[i] != null)
            	c_cost += Model.getInCost().get(raw[i]);
        }
        return new Double(df.format(c_cost));
    }
    
    /* Calculate and return the profit of the product */
    protected Double calculateProfit()
    {
        pProfit = pPrice - pCost;
        return new Double(df.format(pProfit));
    }
    
    /* Return the profit of the product */
    public Double getProfit()
    {
        return pProfit;
    }
    
    /* Return the name of the product */
    public String getName()
    {
        return pName;
    }
    
    /* Return the cost of the product */
    public Double getCost()
    {
        return pCost;
    }
    
    /* Return the sales price of the product */
    public Double getPrice()
    {
        return pPrice;
    }
    
    /* Return the list of Ingredients */
    public Ingredients[] getIngredients(){
        return pAddon;
    }
    
    /* Modify or set the sales price of the product.
     * Update the profit of the product.
     */
    public void setPrice(Double p)
    {
        pPrice = p;
        pProfit = calculateProfit();
    }
    
    /* Return the list of Ingredients in a String format */
    public String toStringIngred()
    {
        String ingred = "";
        
        for (int i = 0; i < pAddon.length; i++)
        {
            if (!pAddon[i].toString().equals("None"))
            {
                ingred += pAddon[i].toString();
                
                if (i == 0 && pAddon[i+1].toString().equals("None") && pAddon[i+2].toString().equals("None"))
                {
                	break;
                }
                else if (i == 1 && pAddon[i+1].toString().equals("None"))
                {
                	break;	
                }
                else if (!(i+1 == pAddon.length))
                    ingred += ", ";
            }
        }
        return ingred;
    }
    
    protected String pName;
    protected Double pCost;
    protected Double pPrice;
    protected Double pProfit;
    protected Ingredients[] pAddon;
    protected MenuTableModel model;
    
}
