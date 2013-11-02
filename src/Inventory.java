/**
 * @(#)Inventory.java
 *
 *
 * @author Cecilia Tsoy
 * @version 1.00 2007/10/14
 */
public class Inventory 
{

    public Inventory(Ingredients m, int a) 
    {
        material = m;
        amount = a;
    }
    
    /* Return the Ingredient of Inventory */
    public Ingredients getName(){
        return material;
    }
    
    /* Return the amount of Inventory */
    public int getAmount(){
        return amount;
    }
    
    /* Return the amount of Inventory */
    public int setAmount(int amt){
        amount = amt;
        return amount;
    }
    
    /* Update and return the amount of Inventory */
    public int order(int count){
        return (amount += count);
    }
    
    /* Update the amount of Inventory after sales */
    public void used(int count){
        amount -= count;
    }
    
    protected Ingredients material;
    protected int amount;
}