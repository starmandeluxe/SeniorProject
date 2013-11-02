import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class Uniform extends JPanel
                               implements ActionListener,
                                          ChangeListener 
    {
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		public JLabel banner;
	    public JColorChooser tcc;
	
	    public Uniform() {
	        super(new BorderLayout());
			banner = new JLabel("Store Name", JLabel.CENTER);
	        //Set up banner to use as custom preview panel
	        //banner = new JLabel("Welcome to the Tutorial Zone!",
	        //                    JLabel.CENTER);
	        banner.setForeground(Color.yellow);
	        banner.setBackground(Color.blue);
	        banner.setOpaque(true);
	        
	        banner.setFont(new Font("SansSerif", Font.BOLD, 24));
	        banner.setPreferredSize(new Dimension(100, 65));
	
	        JPanel bannerPanel = new JPanel(new BorderLayout());
	        bannerPanel.add(banner, BorderLayout.CENTER);
	        bannerPanel.setBorder(BorderFactory.createTitledBorder("Uniform Color"));
	
	        //Set up color chooser for setting background color
	        JPanel panel = new JPanel(); //use FlowLayout
	        JButton bcc = new JButton("Select This Color");
	        bcc.setFont(new Font("Tahoma", Font.BOLD, 14));
	        bcc.addActionListener(this);
	        //bcc.getSelectionModel().addChangeListener(this);
	        panel.add(bcc);
	        //panel.setBorder(BorderFactory.createTitledBorder(
	         //                       "Choose Background Color"));
	
	        //Set up color chooser for setting text color
	        tcc = new JColorChooser();
	        tcc.getSelectionModel().addChangeListener(this);
	        tcc.setBorder(BorderFactory.createTitledBorder("Choose Text Color"));
	
	        //Remove the preview panel
	        tcc.setPreviewPanel(new JPanel());
	
	        //Override the chooser panels with our own
	        //AbstractColorChooserPanel panels[] = { new CrayonPanel() };
	        //tcc.setChooserPanels(panels);
	        tcc.setColor(banner.getBackground());
	
	        add(bannerPanel, BorderLayout.PAGE_START);
	        add(panel, BorderLayout.CENTER);
	        add(tcc, BorderLayout.PAGE_END);
	    }
	
	    public void actionPerformed(ActionEvent e) {
	        /*Color newColor = JColorChooser.showDialog(
	                                       Uniform.this,
	                                       "Choose Background Color",
	                                       banner.getBackground());
	        if (newColor != null) {
	            banner.setBackground(newColor);
	        }*/
	    }
	    
	
	    public void stateChanged(ChangeEvent e) {
	        Color newColor = tcc.getColor();
	        banner.setBackground(newColor);
	    }
	}