import java.awt.*;

/*
 * Class that handles the layout of
 * the components in the Tapioca King
 * Research Tab
 *
 */
public class researchLayout implements LayoutManager 
	{

	    public researchLayout() 
	    {
	    }
	
	    public void addLayoutComponent(String name, Component comp) 
	    {
	    }
	
	    public void removeLayoutComponent(Component comp) 
	    {
	    }
	
	    public Dimension preferredLayoutSize(Container parent) 
	    {
	        Dimension dim = new Dimension(0, 0);
	
	        Insets insets = parent.getInsets();
	        dim.width = 680 + insets.left + insets.right;
	        dim.height = 438 + insets.top + insets.bottom;
	
	        return dim;
	    }
	
	    public Dimension minimumLayoutSize(Container parent) 
	    {
	        Dimension dim = new Dimension(0, 0);
	        return dim;
	    }
	
	    public void layoutContainer(Container parent) 
	    {
	        Insets insets = parent.getInsets();
	
	        Component c;
	        c = parent.getComponent(0);
	        //Tea Label
	        if (c.isVisible()) {c.setBounds(insets.left+60,insets.top+70,72,24);}
	        c = parent.getComponent(1);
	        //Syrup Label
	        if (c.isVisible()) {c.setBounds(insets.left+172,insets.top+70,72,24);}
	        c = parent.getComponent(2);
	        //Add-on Label
	        if (c.isVisible()) {c.setBounds(insets.left+292,insets.top+70,72,24);}	        
	        	        
	        //Tea Item Combo
	        c = parent.getComponent(4);
	        if (c.isVisible()) {c.setBounds(insets.left+60,insets.top+98,90,24);}
	        //Syrup Item Combo
	        c = parent.getComponent(5);
	        if (c.isVisible()) {c.setBounds(insets.left+172,insets.top+98,100,24);}
	        //Add on Item Combo
	        c = parent.getComponent(6);
	        if (c.isVisible()) {c.setBounds(insets.left+292,insets.top+98,120,24);}	        
	        //Drink Name Field
	        c = parent.getComponent(7);
	        if (c.isVisible()) {c.setBounds(insets.left+180,insets.top+180,150,24);}
	        //Drink Name Label
	        c = parent.getComponent(8);
	        if (c.isVisible()) {c.setBounds(insets.left+60,insets.top+180,130,24);}	  
	        //Interior Label      
	        c = parent.getComponent(9);
	        if (c.isVisible()) {c.setBounds(insets.left+60,insets.top+275,130,24);}
	        //Interior Combo Box
	        c = parent.getComponent(11);
	        if (c.isVisible()) {c.setBounds(insets.left+180,insets.top+275,100,24);}
	        	        
	        //Hire Research Button
	        c = parent.getComponent(10);
	        if (c.isVisible()) {c.setBounds(insets.left+60,insets.top+360,170,25);}
	        	        
	        //Cost Label
	         c = parent.getComponent(12);
	         if (c.isVisible()) {c.setBounds(insets.left+60,insets.top+140,100,24);}	        
	        //teaCost
	         c = parent.getComponent(13);
	         if (c.isVisible()) {c.setBounds(insets.left+115,insets.top+140,35,24);}	        
	        //Cost Label
	         c = parent.getComponent(14);
	         if (c.isVisible()) {c.setBounds(insets.left+170,insets.top+140,100,24);}	        
	        //syrupCost
	         c = parent.getComponent(15);
	         if (c.isVisible()) {c.setBounds(insets.left+226,insets.top+140,35,24);}	        
	        //Cost Label
	         c = parent.getComponent(16);
	         if (c.isVisible()) {c.setBounds(insets.left+290,insets.top+140,100,24);}	        
	        //addonCost
	         c = parent.getComponent(17);
	        if (c.isVisible()) {c.setBounds(insets.left+345,insets.top+140,35,24);}	  
	              
	        //total cost label 1
	         c = parent.getComponent(18);
	         if (c.isVisible()) {c.setBounds(insets.left+545,insets.top+90,100,24);}	        
	        //total cost label 2
	         c = parent.getComponent(19);
	         if (c.isVisible()) {c.setBounds(insets.left+535,insets.top+105,150,24);}	        
	        //total cost field
	         c = parent.getComponent(20);
	        if (c.isVisible()) {c.setBounds(insets.left+540,insets.top+135,80,24);}
	        //total cost dollar sign
	         c = parent.getComponent(21);
	        if (c.isVisible()) {c.setBounds(insets.left+530,insets.top+135,20,24);}	 
	        //Create Button
	        c = parent.getComponent(3);
	        if (c.isVisible()) {c.setBounds(insets.left+540,insets.top+175,80,40);}
	               
	         //research title label
	        c = parent.getComponent(22);
	        if (c.isVisible()) {c.setBounds(insets.left+220,insets.top+0,350,24);}
	        
	        // Sell Drink Label
	        c = parent.getComponent(23);
	        if (c.isVisible()) {c.setBounds(insets.left+60, insets.top+210, 150,24);}
	        
	        //Sales Price Box
            c = parent.getComponent(24);
            if (c.isVisible()) {c.setBounds(insets.left+200, insets.top+210, 50,24);}
            
            //generate drink name button
            c = parent.getComponent(25);
            if (c.isVisible()) {c.setBounds(insets.left+340,insets.top+180,130,24);}
            
            //Drink Research Cost
            c = parent.getComponent(26);
            if (c.isVisible()) {c.setBounds(insets.left+250, insets.top+35, 200, 24);}
            
            //Drink Research Cost Field
            c = parent.getComponent(27);
            if (c.isVisible()) {c.setBounds(insets.left+420, insets.top+35, 50, 24);}
            
            //Interior Design Instructions
            c = parent.getComponent(28);
            if (c.isVisible()) {c.setBounds(insets.left+60, insets.top+245, 480, 24);}
            
            //Hire Research Text
            c = parent.getComponent(29);
            if (c.isVisible()) {c.setBounds(insets.left+60, insets.top+325, 480, 24);}
        
            //Interior Design preview
            c = parent.getComponent(30);
            if (c.isVisible()) {c.setBounds(insets.left+510, insets.top+240, 200, 150);}
            
            //Interior Design Change Confirm Button
            c = parent.getComponent(31);
            if (c.isVisible()) {c.setBounds(insets.left+290, insets.top+275, 150, 24);}
	    }
	}
