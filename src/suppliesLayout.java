import java.awt.*;

/*
 * Class that handles the layout of components
 * in the Supplies Tab of Tapioca King
 *
 */
public class suppliesLayout implements LayoutManager 
	{

	    public suppliesLayout() 
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
	        dim.width = 700 + insets.left + insets.right;
	        dim.height = 445 + insets.top + insets.bottom;
	
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
	        //cups button
			c = parent.getComponent(0);
	        if (c.isVisible()) {c.setBounds(insets.left+24,insets.top+32,144,260);}
	        //straws button
	        c = parent.getComponent(1);
	        if (c.isVisible()) {c.setBounds(insets.left+192,insets.top+32,144,260);}
	        //napkins button
	        c = parent.getComponent(2);
	        if (c.isVisible()) {c.setBounds(insets.left+360,insets.top+32,144,260);}
	        //tea button
	        c = parent.getComponent(3);
	        if (c.isVisible()) {c.setBounds(insets.left+520,insets.top+32,144,260);}
	        
	        //Reorder Label
	        c = parent.getComponent(4);
	        if (c.isVisible()) {c.setBounds(insets.left+56,insets.top+300,72,24);}
	        //Reorder Label
	        c = parent.getComponent(5);
	        if (c.isVisible()) {c.setBounds(insets.left+224,insets.top+300,72,24);}
	        //Reorder Label
	        c = parent.getComponent(6);
	        if (c.isVisible()) {c.setBounds(insets.left+392,insets.top+300,72,24);}
	        //Reorder Label
	        c = parent.getComponent(7);
	        if (c.isVisible()) {c.setBounds(insets.left+552,insets.top+300,72,24);}
	        
	        //ComboBox
	        c = parent.getComponent(8);
	        if (c.isVisible()) {c.setBounds(insets.left+56,insets.top+330,72,24);}
	        //ComboBox
	        c = parent.getComponent(9);
	        if (c.isVisible()) {c.setBounds(insets.left+224,insets.top+330,72,24);}
	        //ComboBox
	        c = parent.getComponent(10);
	        if (c.isVisible()) {c.setBounds(insets.left+392,insets.top+330,72,24);}
	        //ComboBox
	        c = parent.getComponent(11);
	        if (c.isVisible()) {c.setBounds(insets.left+552,insets.top+330,72,24);}
	        
	        //Cost Labels
	        c = parent.getComponent(12);
	        if (c.isVisible()) {c.setBounds(insets.left+24,insets.top+370,100,24);}
	        c = parent.getComponent(13);
	        if (c.isVisible()) {c.setBounds(insets.left+360,insets.top+370,100,24);}
	        c = parent.getComponent(14);
	        if (c.isVisible()) {c.setBounds(insets.left+192,insets.top+370,100,24);}
	        c = parent.getComponent(15);
	        if (c.isVisible()) {c.setBounds(insets.left+520,insets.top+370,100,24);}
	        
	        //Cost Fields
	        c = parent.getComponent(16);
	        if (c.isVisible()) {c.setBounds(insets.left+430,insets.top+370,72,24);}
	        c = parent.getComponent(17);
	        if (c.isVisible()) {c.setBounds(insets.left+262,insets.top+370,72,24);}
	        c = parent.getComponent(18);
	        if (c.isVisible()) {c.setBounds(insets.left+94,insets.top+370,72,24);}
	        c = parent.getComponent(19);
	        if (c.isVisible()) {c.setBounds(insets.left+590,insets.top+370,72,24);}
	        
	        //supplies title label
	        c = parent.getComponent(20);
	        if (c.isVisible()) {c.setBounds(insets.left+24,insets.top+0,200,24);}
	    }
	}
