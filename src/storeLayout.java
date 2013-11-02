import java.awt.*;

/*
 * Class that handles each of the components
 * in the graphical Store Tab of Tapioca King
 *
 */
public class storeLayout implements LayoutManager 
	{

	    public storeLayout() 
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
	        dim.width = 689 + insets.left + insets.right;
	        dim.height = 465 + insets.top + insets.bottom;
	
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
	        //ceiling
	        c = parent.getComponent(0);
	        if (c.isVisible()) {c.setBounds(insets.left+100,insets.top+1,533,34);}
            
            //customer
            c = parent.getComponent(1);
            if (c.isVisible()) {c.setBounds(insets.left+100,insets.top+35,140,239);}
            
            //money
            c = parent.getComponent(2);
            if (c.isVisible()) {c.setBounds(insets.left+240,insets.top+35,86,162);}
            
            //fridge
            c = parent.getComponent(3);
            if (c.isVisible()) {c.setBounds(insets.left+580,insets.top+35,53,148);}
            
            //blender
            c = parent.getComponent(4);
            if (c.isVisible()) {c.setBounds(insets.left+529,insets.top+35,51,70);}
            
            //ingredients
            c = parent.getComponent(5);
            if (c.isVisible()) {c.setBounds(insets.left+474,insets.top+35,55,70);}
            
            //cups
            c = parent.getComponent(6);
            if (c.isVisible()) {c.setBounds(insets.left+434,insets.top+35,40,70);}
            
            //napkins
            c = parent.getComponent(7);
            if (c.isVisible()) {c.setBounds(insets.left+487,insets.top+183,82,62);}
            
            //straws
            c = parent.getComponent(8);
            if (c.isVisible()) {c.setBounds(insets.left+569,insets.top+183,64,62);}
            
            //staff
            c = parent.getComponent(9);
            if (c.isVisible()) {c.setBounds(insets.left+326,insets.top+105,161,93);}
            
            //rack
            c = parent.getComponent(10);
            if (c.isVisible()) {c.setBounds(insets.left+326,insets.top+35,108,70);}
            
            //stand
            c = parent.getComponent(11);
            if (c.isVisible()) {c.setBounds(insets.left+487,insets.top+105,94,79);}            
                
            //counter 1
            c = parent.getComponent(12);
            if (c.isVisible()) {c.setBounds(insets.left+452,insets.top+245,181,82);}                   
                
            //counter 2
            c = parent.getComponent(13);
            if (c.isVisible()) {c.setBounds(insets.left+240,insets.top+197,212,77);}   
                
            //counter 3
            c = parent.getComponent(14);
            if (c.isVisible()) {c.setBounds(insets.left+452,insets.top+198,36,47);}                                 
                
            //table 1
            c = parent.getComponent(15);
            if (c.isVisible()) {c.setBounds(insets.left+452,insets.top+327,181,84);} 
                
            //table 2
            c = parent.getComponent(16);
            if (c.isVisible()) {c.setBounds(insets.left+255,insets.top+274,197,137);}     
                
            //table 3
            c = parent.getComponent(17);
            if (c.isVisible()) {c.setBounds(insets.left+100,insets.top+274,155,137);}                 
	    }
	}