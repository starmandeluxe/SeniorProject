import java.awt.*;

/*
 * Class that handles the layout of components
 * in the Settings Screen of Tapioca King
 *
 */
public class settingsLayout implements LayoutManager 
	{
	
	    public settingsLayout() 
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
	        //store image
	        c = parent.getComponent(0);
	        if (c.isVisible()) {c.setBounds(insets.left+50,insets.top+15,350,250);}
	        //store name
	        c = parent.getComponent(1);
	        if (c.isVisible()) {c.setBounds(insets.left+170,insets.top+105,143,20);}
	        //interior label
	        c = parent.getComponent(2);
	        if (c.isVisible()) {c.setBounds(insets.left+440,insets.top+48,72,24);}
            //uniform image
            c = parent.getComponent(3);
            if (c.isVisible()) {c.setBounds(insets.left+20,insets.top+270,400,151);}

	        //color label
	        c = parent.getComponent(4);
	        if (c.isVisible()) {c.setBounds(insets.left+350,insets.top+450,112,24);}
	        //start button
	        c = parent.getComponent(5);
	        if (c.isVisible()) {c.setBounds(insets.left+520,insets.top+500,108,34);}
	        //cancel button
	        c = parent.getComponent(6);
	        if (c.isVisible()) {c.setBounds(insets.left+520,insets.top+540,108,34);}
	        //uniform combobox
	        c = parent.getComponent(7);
	        if (c.isVisible()) {c.setBounds(insets.left+350,insets.top+470,72,24);}
            //interior design image
            c = parent.getComponent(8);
            if(c.isVisible()) {c.setBounds(insets.left+440,insets.top+150,200,150);}
	        //scroll pane
	        c = parent.getComponent(9);
	        if (c.isVisible()) {c.setBounds(insets.left+440,insets.top+80,200,60);}
	        //header label
	        c = parent.getComponent(10);
	        if (c.isVisible()) {c.setBounds(insets.left+290,insets.top+16,200,24);}
	        //difficulty label
	        c = parent.getComponent(11);
	        if (c.isVisible()) {c.setBounds(insets.left+480,insets.top+345,150,24);}
	        //difficulty combo box
	        c = parent.getComponent(12);
	        if (c.isVisible()) {c.setBounds(insets.left+480,insets.top+384,100,24);}
	        //difficulty description label
	        c = parent.getComponent(13);
	        if (c.isVisible()) {c.setBounds(insets.left+480,insets.top+410,180,24);}
	        
            //uniform image label
            c = parent.getComponent(14);
            if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+450,248,108);}
            
            
	    }
	}