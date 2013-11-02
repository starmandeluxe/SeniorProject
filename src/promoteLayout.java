import java.awt.*;

/*
 * Class that handles the layout of the 
 * promotion tab
 *
 */
public class promoteLayout implements LayoutManager 
	{

	    public promoteLayout() 
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
	        
	        //Flyers	        
	        c = parent.getComponent(0);
	        if (c.isVisible()) {c.setBounds(insets.left+60,insets.top+90,250,24);}	        
	           
	        //Coupons        
	        c = parent.getComponent(1);
	        if (c.isVisible()) {c.setBounds(insets.left+60,insets.top+170,250,24);}
	        
	        //Magazine ads       
	        c = parent.getComponent(2);
	        if (c.isVisible()) {c.setBounds(insets.left+60,insets.top+240,250,24);}	  
	        
	        //TV Commercials  
	        c = parent.getComponent(3);
	        if (c.isVisible()) {c.setBounds(insets.left+60,insets.top+315,250,24);}	      
	           
	        //page title  
            c = parent.getComponent(4);
            if (c.isVisible()) {c.setBounds(insets.left+100,insets.top+20,600,24);}
            c = parent.getComponent(5);
            if (c.isVisible()) {c.setBounds(insets.left+200,insets.top+40,600,24);}
            
            //description
            c = parent.getComponent(6);
            if (c.isVisible()) {c.setBounds(insets.left+360,insets.top+200,600,24);}
            c = parent.getComponent(7);
            if (c.isVisible()) {c.setBounds(insets.left+360,insets.top+225,600,24);}          
	    }
	}