import java.awt.*;

/*
 * Class that handles the layout of components
 * in the tutorial sections of Tapioca Kings
 *
 */
public class tutorLayout implements LayoutManager 
	{
	
	    public tutorLayout() 
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
	        dim.width = 632 + insets.left + insets.right;
        	dim.height = 391 + insets.top + insets.bottom;

	
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
	        //image
	        c = parent.getComponent(0);
	        if (c.isVisible()) {c.setBounds(insets.left+150,insets.top+10,388,350);}
	        
	        // Context
            c = parent.getComponent(1);
            if (c.isVisible()) {c.setBounds(insets.left+100,insets.top+370,500,200);}
            
            // Main Menu Button
            c = parent.getComponent(2);
            if (c.isVisible()) {c.setBounds(insets.left+100,insets.top+600,150,25);}
            
            // Previous Page Button
            c = parent.getComponent(3);
            if (c.isVisible()) {c.setBounds(insets.left+390,insets.top+600,100,25);}
            
            // Next Page Button
            c = parent.getComponent(4);
            if (c.isVisible()) {c.setBounds(insets.left+500,insets.top+600,100,25);}
	        
            
            
	    }
	}