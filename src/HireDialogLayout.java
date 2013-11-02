import java.awt.*;
class HireDialogLayout implements LayoutManager 
{

    public HireDialogLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 388 + insets.left + insets.right;
        dim.height = 309 + insets.top + insets.bottom;

        return dim;
    }

    public Dimension minimumLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);
        return dim;
    }

    public void layoutContainer(Container parent) {
        Insets insets = parent.getInsets();

        Component c;
        //Tea radio
        c = parent.getComponent(0);
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+40,56,24);}
        //Hire Button
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+88,insets.top+280,72,24);}
        //Cancel Button
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+176,insets.top+280,80,24);}
        //or label
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+136,200,24);}
        //research interior label
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+166,200,24);}
        //hire cost label
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+80,insets.top+208,100,24);}
        //duration label
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+50,insets.top+240,120,24);}
        //cost field
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+176,insets.top+208,100,24);}
        //duration field
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+176,insets.top+240,40,24);}
        //syrup radio
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+72,80,24);}
        //addon radio
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+104,100,24);}
        //days label
        c = parent.getComponent(11);
        if (c.isVisible()) {c.setBounds(insets.left+220,insets.top+240,40,24);}
        //Title 1
        c = parent.getComponent(12);
        if (c.isVisible()) {c.setBounds(insets.left+60,insets.top+10,240,20);}
        //Title 2
        c = parent.getComponent(13);
        if (c.isVisible()) {c.setBounds(insets.left+78,insets.top+25,240,20);}
    }
}
