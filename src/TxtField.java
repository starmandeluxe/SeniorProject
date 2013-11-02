import javax.swing.*;
import java.awt.event.*;

/*
 * Class that creates a text field that
 * can be cleared out
 *
 */
class TxtField extends JTextField
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int limit;
	
	TxtField(String s, int limit)
	{
		super(s);
		
		this.limit = limit;
		
		addKeyListener(new KeyAdapter() 
		{
			public void keyTyped(KeyEvent e) 
			{
				if (getText().length() >= TxtField.this.limit)
				e.consume();
			}
		});
	}
} 