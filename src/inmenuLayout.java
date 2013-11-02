import java.awt.*;

/*
 * Class that handles the layout of the 
 * in-game menu components
 *
 */
public class inmenuLayout implements LayoutManager
	{
	
	    public inmenuLayout() 
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
	        //title text
            c = parent.getComponent(0);
            if (c.isVisible()) {c.setBounds(insets.left+200,insets.top+10,300,45);}
	        //resume game button
	        c = parent.getComponent(1);
	        if (c.isVisible()) {c.setBounds(insets.left+100,insets.top+85,200,35);}
	        //new game button
	        c = parent.getComponent(2);
	        if (c.isVisible()) {c.setBounds(insets.left+100,insets.top+145,200,35);}
	         //tutorial button
            c = parent.getComponent(3);
            if (c.isVisible()) {c.setBounds(insets.left+100,insets.top+205,200,35);}
			 //options button
            c = parent.getComponent(4);
            if (c.isVisible()) {c.setBounds(insets.left+100,insets.top+265,200,35);}          
             //credits button    
            c = parent.getComponent(5);
            if (c.isVisible()) {c.setBounds(insets.left+100,insets.top+325,200,35);}
             //exit button
            c = parent.getComponent(6);
            if (c.isVisible()) {c.setBounds(insets.left+100,insets.top+375,200,35);}
            //mascot image
            c = parent.getComponent(7);
            if (c.isVisible()) {c.setBounds(insets.left+350,insets.top+75,341,550);}
	    }
	}