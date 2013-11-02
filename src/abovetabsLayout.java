import java.awt.*;

/*
 * Class that handles the layout of the 
 * components above the tabs in Tapioca King.
 *
 */
public class abovetabsLayout implements LayoutManager {

	    public abovetabsLayout() {
	    }
	
	    public void addLayoutComponent(String name, Component comp) {
	    }
	
	    public void removeLayoutComponent(Component comp) {
	    }
	
	    public Dimension preferredLayoutSize(Container parent) {
	        Dimension dim = new Dimension(0, 0);
	
	        Insets insets = parent.getInsets();
	        dim.width = 730 + insets.left + insets.right;
	        dim.height = 200 + insets.top + insets.bottom;
	
	        return dim;
	    }
	
	    public Dimension minimumLayoutSize(Container parent) {
	        Dimension dim = new Dimension(0, 0);
	        return dim;
	    }
	
	    public void layoutContainer(Container parent) {
	        Insets insets = parent.getInsets();
	
	        Component c;
	        //date label
	        c = parent.getComponent(0);
	        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+8,72,24);}
	        //date field
	        c = parent.getComponent(1);
	        if (c.isVisible()) {c.setBounds(insets.left+45,insets.top+8,50,24);}
	        //MenuButton
	        c = parent.getComponent(2);
	        if (c.isVisible()) {c.setBounds(insets.left+555,insets.top+48,150,24);}
	        //Total label + Dollar sign
	        c = parent.getComponent(3);
	        if (c.isVisible()) {c.setBounds(insets.left+535,insets.top+8,100,24);}
	        //Money Field
	        c = parent.getComponent(4);
	        if (c.isVisible()) {c.setBounds(insets.left+630,insets.top+8,65,24);}
	        //Cup Label
	        c = parent.getComponent(5);
	        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+48,40,24);}
	        //Straw Label
	        c = parent.getComponent(6);
	        if (c.isVisible()) {c.setBounds(insets.left+105,insets.top+48,48,24);}
	        //Napkin Label
	        c = parent.getComponent(7);
	        if (c.isVisible()) {c.setBounds(insets.left+215,insets.top+48,56,24);}
	        //Ingredients Label
	        c = parent.getComponent(8);
	        if (c.isVisible()) {c.setBounds(insets.left+330,insets.top+48,100,24);}
	        //Cup Field
	        c = parent.getComponent(9);
	        if (c.isVisible()) {c.setBounds(insets.left+50,insets.top+48,48,24);}
	        //Straw Field
	        c = parent.getComponent(10);
	        if (c.isVisible()) {c.setBounds(insets.left+160,insets.top+48,48,24);}
	        //Napkin Field
	        c = parent.getComponent(11);
	        if (c.isVisible()) {c.setBounds(insets.left+275,insets.top+48,48,24);}
	        //Ingredients Field
	        c = parent.getComponent(12);
	        if (c.isVisible()) {c.setBounds(insets.left+415,insets.top+48,48,24);}
	        
	        //Goal Label
	        c = parent.getComponent(13);
            if (c.isVisible()) {c.setBounds(insets.left+130,insets.top+8,50,24);}
            
            //Goal Field
            c = parent.getComponent(14);
            if (c.isVisible()) {c.setBounds(insets.left+170,insets.top+8,350,24);}
            
            //Message Box (Text Area)
            c = parent.getComponent(15);
            if (c.isVisible()) {c.setBounds(insets.left+100,insets.top+100,552,80);}
	    }
	}
