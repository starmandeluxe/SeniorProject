/* 
 * Tapioca King
 *
 * Senior Project (Java Applet Game)
 * CSC 491/492
 *
 * Fall 2007- Spring 2008 
 *
 * By Alex Kort and Cecilia Tsoy
 * akort@calpoly.edu,ctsoy@calpoly.edu
 *
 * Professor Aaron Keen, Advisor
 *
 */
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.*;
import java.awt.Dimension;

import javax.swing.*;

import java.applet.*;
import java.awt.*;

import javax.swing.event.*;
import javax.swing.table.*;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;
import javax.swing.JDialog;

import java.text.DateFormat;
import java.util.Vector;
import java.lang.Double;

import javax.swing.Timer;

import java.util.StringTokenizer;

import javax.swing.text.*;

import java.util.Random;
import java.lang.Math;

public class TapiocaKing extends JApplet implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//create final strings to identify the cards
	final static String TITLE = "Card for Title";
	final static String MENU = "Card for Menu";
	final static String SETTINGS = "Card for Settings";
	final static String INTERFACE = "Card for Interface";
	final static String CREDITS = "Card for Credits";
	final static String OPTIONS = "Card for Options";
	final static String INMENU = "Card for In-Game Menu";
	final static String TUT1 = "Card for 1st tutorial page";
	final static String TUT2 = "Card for 2nd tutorial page";
	final static String TUT3 = "Card for 3rd tutorial page";
	final static String TUT4 = "Card for 4th tutorial page";
	final static String TUT5 = "Card for 5th tutorial page";
	final static String TUT6 = "Card for 6th tutorial page";
   	
   	public static Frame app;
   	
   	//indicates a new game was started
   	public boolean newgameflag = false;
   	public boolean ingameflag = false;
   	
   	public static boolean isRes = false;
   	
   	//define panels and global variables
   	JPanel panel;
   	JPanel panel2;
   	JPanel panel3;
   	JPanel panel4;
   	JPanel inmenu;
   	JPanel cred;
   	JPanel opt;
   	JPanel tut1;
   	JPanel tut2;
   	JPanel tut3;
   	JPanel tut4;
   	JPanel tut5;
   	//JPanel tut6;
   	JPanel sub2;
	JPanel cards;
	
	
	MediaTracker mt;
  	Image boba;
   	boolean msgon = false;
   	
   	int uniform;
   	String storenm = "Store Name";
   	TxtField storename;
   	
   	//The Day counter is an integer and increments
    int d = 0;
    JTextField date;
    
	DateFormat dtfmt = DateFormat.getDateInstance(DateFormat.MEDIUM);
	
   	//create a Decimal Format object to convert the double to a 
	//price format string
   	DecimalFormat df = new DecimalFormat("###0.00");
   	
   	//dialog window to display error message
   	JFrame drinkDialog = new JFrame();
   	//dialog to display exit confirmation
   	JFrame exitDialog = new JFrame();
    JFrame pauseDialog = new JFrame();
   	//hire research team dialog
   	JFrame hire = new JFrame();
   	//research complete dialog
   	static JFrame resDone = new JFrame();
   	
   	//arrays to track weekly summary data
    int[] custom = new int[7];
    int[] walks = new int[7];
    double[] revenue = new double[7];
    double[] revenueE = new double[7];
    double[] expenses = new double[7];
    int[] dsold = new int[7];
    double[] tprofit = new double[7];
   	int sindex = -1;
   	
   	//for the supply text fields that calculates 
   	//how much each amount of supply will cost
   	double cupcalc;
   	double napcalc;
   	double strawcalc;
   	double ingcalc;
   	
   	//initial prices of the supplies
   	double initcup;
   	double initstraw;
   	double initnap;
   	
   	//The table and its model to represent the Menu
   	MenuTable mtable = null;
   	MenuTableModel tmodel; 
   		
   	JTable table;
	Vector<?> rows,columns;
	DefaultTableModel tabModel;
   	
   	//List box for store interior selection
    static DefaultListModel<String> listModel_interior;
   	static JList<String> inter;
	JScrollPane sp_interior;
	
   	//interior list selected index
   	int interInd;
   	
   	//set initial monetary amount to 100 dollars
   	static double money = 100;
   	static JTextField moneyfield;
   	
   	double[] egoals = {500.00, 800.00, 1000.00, 2000.00};
   	double[] mgoals = {700.00, 800.00, 1200.00, 2000.00};
   	double[] hgoals = {650.00, 800.00, 1200.00, 2000.00};
   	double[] goals = new double[3];
   	
   	//only calculate the goals once!
   	boolean goal1flag = false;
   	boolean goal2flag = false;
   	boolean goal3flag = false;
   	boolean goal4flag = false;
   	
   	//set initial drink research cost to 10 dollars
    double dCost = 0.0;
    JTextField drinkCostField;
   	
   	//vars to keep track of supply amounts
   	Inventory cupsupply;
   	Inventory napsupply;
   	Inventory strawsupply;
   	Inventory ingsupply;
   	
   	//combo boxes for ingredients to research
   	static JComboBox<String> tea_box;
	static JComboBox<String> syrup_box;
	static JComboBox<String> addon_box;
   	
   	//components to display the supply amounts in the game
   	JTextField cupamt;
   	JTextField strawamt;
   	JTextField napamt;
   	JTextField ingamt;
   	
   	//components of the supplies tab to calculate supply prices
   	JTextField costField1;
	JTextField costField2;
	JTextField costField3;
	//Ingredients supply amount text box
    JTextField costField4;
    
    TxtField drinkname;
	TxtField salesprice;
    
    //supplies comboboxes
    JComboBox<String> cupcombo;
	JComboBox<String> strawcombo;
	JComboBox<String> napcombo;
   	
   	// Text field to display the current goal
   	JTextField goalField;
   	
   	//A products object to represent a drink
   	Products p;
   	Ingredients i1 = Ingredients.MilkTea, 
   		i2 = Ingredients.None, 
   		i3 = Ingredients.Tapioca;
    Ingredients[] i = {i1, i2, i3};
    
    HireDialog hd;
   	
   	Timer t1;
   	Timer tDate;
   	Timer tRandEvents;
   	Timer tCusts;
   	Timer tCustDown;
   	Timer tCustUp;
   	static Timer tRes;
   	static Timer tCountdown;
   	final Random eventgen = new Random();
   	
   	//counter for research days
   	static float dayCount = 0;
   	
   	//The text area to display messages on a timer
   	static JTextPane events;
    static JScrollPane sp_events;
    
    //Styled Document allows for text to be formatted and
    //displayed in colors
    static Style style;
    static Style style2;
    static Style style3;
    static Style style4;
    static StyledDocument doc;
    
    //jlabels for promotion tab
    JLabel desc1;
    JLabel desc2;
    
    //global audio clip for title page //song
    static AudioClip song;
    //global audio clip for menu //song
    static AudioClip song2;
	//global audio clip for in-game //song
	static AudioClip song3;
	//cash register sound effect
	AudioClip cashsong;
	
    int cus_current;    // current number of customers
    float min_cus = 3;        // minimum number of customers
    float max_cus = 10;        // maximum number of customers
    float diff_cus = 7;      // difference between max and min customers
    
    //flag is the date the promotion period ends, otherwise, flag = -1
    int flyer_flag = -1;   
    int coupon_flag = -1;  
    int magazine_flag = -1;  
    int tv_flag = -1;    
        
    //Random generator for number of customers
    Random cus_gen = new Random();
    
    //Random generator for which drink the customer buys
    Random drink_gen = new Random();
    
    //Random generator for how many drinks each customer buys
    Random item_gen = new Random();
    
    //random that decides if a customer will walk out or not
    Random decide = new Random();
    
    //Ingredients supply amount combo box
    JComboBox<String> ingcombo;
    
    int temp_cus, temp_order;
    int numDrinks;
    
    //when calculating ingredient prices,
    // divide by this number of ingredients in a drink
    int divisor = 1;
    
    //description string when selecting difficulty
    JLabel difString;
    //combo box to select difficulty setting
    JComboBox<String> difficulty;
    
    //check box in options card
    JCheckBox musicCheck;
    
    //check box in options card
    JCheckBox soundCheck;
    
    //Button in the options card to pause the game
    JButton pause;
    
    //only play //songs when this flag is true
    boolean soundflag = true;
    //only play sound effects when this flag is true
    boolean fxflag = true;
    
    //if true, stop //song 3, if false, stop //song 1
    boolean songflag = false;
    
    //flag to check if a customer bought any drinks
    boolean boughtflag = false;
    
    //flag to check if the game is paused
    boolean pauseflag = false;
    
    //flag to add customers for space, hollywood, jungle only once
    boolean spaceflag = false;
    boolean hollyflag = false;
    boolean jungleflag = false;
    //flags to display alerts only once when out of supplies
    boolean supout1 = true;
    boolean supout2 = true;
    boolean supout3 = true;
    boolean supout4 = true;
    
    //Supplies Ingredients Icon
    ImageIcon ingIcon = createImageIcon("images/supply_ing.jpg");
    final JButton ings = new JButton("<html><CENTER>Purchase<br>Ingredients</CENTER></html>", ingIcon);
   
    // Interior Design Preview Picture in Research Tab
    final JLabel inter_design2 = new JLabel(createImageIcon("images/classic_ex.jpg"));
    
    // Interior Design Combo Box in Research Tab
    final static JComboBox<String> interBox = new JComboBox<String>();
    
    //store tab
    final JLabel store_ceiling = new JLabel(createImageIcon("images/store_jungle_ceiling.jpg"));
    final JLabel store_customers = new JLabel(createImageIcon("images/store_customer_ori.jpg"));
    final JLabel store_money = new JLabel(createImageIcon("images/store_money_jungle.jpg"));
    final JLabel store_fridge = new JLabel(createImageIcon("images/store_fridge_work.jpg"));
    final JLabel store_blender = new JLabel(createImageIcon("images/store_blender_work.jpg"));
    final JLabel store_ing = new JLabel(createImageIcon("images/store_ing_work.jpg"));
    final JLabel store_cups = new JLabel(createImageIcon("images/store_cup_work.jpg"));
    final JLabel store_napkin = new JLabel(createImageIcon("images/store_napkin_work.jpg"));
    final JLabel store_straw = new JLabel(createImageIcon("images/store_straw_work.jpg"));
    final JLabel store_staff = new JLabel(createImageIcon("images/store_staff_green.jpg"));
    final JLabel store_rack = new JLabel(createImageIcon("images/store_rack_jungle.jpg"));
    final JLabel store_stand = new JLabel(createImageIcon("images/store_stand1.jpg"));
    final JLabel store_table1 = new JLabel(createImageIcon("images/store_jtable1_empty.jpg"));
    final JLabel store_table2 = new JLabel(createImageIcon("images/store_jtable2_empty.jpg"));
    final JLabel store_table3 = new JLabel(createImageIcon("images/store_jtable3_empty.jpg"));
    final JLabel store_counter1 = new JLabel(createImageIcon("images/store_jcounter1.jpg"));
    final JLabel store_counter2 = new JLabel(createImageIcon("images/store_jcounter2.jpg"));
    final JLabel store_counter3 = new JLabel(createImageIcon("images/store_jcounter3.jpg"));
    
    // flags for broken appliances
    int brokeFridge = -1;
    int brokeBlend = -1;
    
    //variables used in the research method
    static String res = "";
    static int resdays = 0;
    static boolean isIng;
    static int box = 0;
	
	/*
	 * init method to start the applet
	 */
	public void init()
	{
		money = 100.0;
		
		//initialize the songs, ONLY FOR BROWSER APPLET VERSION
		
		song = getAudioClip(getDocumentBase(), "sounds/NameYourFriends.au");
		song2 = getAudioClip(getDocumentBase(), "sounds/ChillSong.au");
		song3 = getAudioClip(getDocumentBase(), "sounds/ProgHouse.au");
		cashsong = getAudioClip(getDocumentBase(), "sounds/cash_register.au");

		
		cupsupply = new Inventory(Ingredients.Cup, 20);
   		napsupply = new Inventory(Ingredients.Napkin, 20);
   		strawsupply = new Inventory(Ingredients.Straw, 20);
   	 	ingsupply = new Inventory(Ingredients.General, 20);
   	 	money = 100;
		d = 0;
		dCost = 0.0;
		storenm = "Tapioca King";
		interInd = 0;
		if (interBox != null)
			interBox.removeAllItems();
        	hd = new HireDialog(app, "Hire a Research Team");
              
		
		//set the initial layout and create all the cards
		JPanel p = createCard1(panel);
		JPanel p2 = createCard2(panel2);
		JPanel p3 = createCard3(panel3);
		JPanel p4 = createCard4(panel4);
		JPanel menu = createInMenu(inmenu);
		JPanel cr = createCreditCard(opt);
		JPanel op = createOptionCard(cred);
		JPanel tuto1 = createTut1(tut1);
		JPanel tuto2 = createTut2(tut2);
		JPanel tuto3 = createTut3(tut3);
		JPanel tuto4 = createTut4(tut4);
		JPanel tuto5 = createTut5(tut5);
		
		//add the cards
		cards = new JPanel(new CardLayout());
		cards.add(p, TITLE);
		cards.add(p2, MENU);
		cards.add(cr, CREDITS);
		cards.add(op, OPTIONS);
		cards.add(p3, SETTINGS);
		cards.add(p4, INTERFACE);
		cards.add(menu, INMENU);
		cards.add(tuto1, TUT1);
		cards.add(tuto2, TUT2);
		cards.add(tuto3, TUT3);
		cards.add(tuto4, TUT4);
		cards.add(tuto5, TUT5);

		add(BorderLayout.CENTER, cards);

	}
	
	//reinitialize everything when starting a new game
	public void initNewGame()
	{
		/*
		 * Important: reinitialize the underlying products
		 * and other such data as well.
		 */
		
		i1 = Ingredients.MilkTea; 
   		i2 = Ingredients.None; 
   		i3 = Ingredients.Tapioca;
    		i = new Ingredients[]{i1, i2, i3};
		cupsupply = new Inventory(Ingredients.Cup, 20);
   		napsupply = new Inventory(Ingredients.Napkin, 20);
   		strawsupply = new Inventory(Ingredients.Straw, 20);
   	 	ingsupply = new Inventory(Ingredients.General, 20);
		money = 100;
		d = 0;
		dCost = 0.0;
		storenm = "Tapioca King";
		interInd = 0;
		interBox.removeAllItems();
		
		hd = new HireDialog(app, "Hire a Research Team");
		
		cards.removeAll();	
		JPanel p = createCard1(panel);
		cards.add(p, TITLE);
			
		JPanel p2 = createCard2(panel2);
		JPanel p3 = createCard3(panel3);
		JPanel p4 = createCard4(panel4);
		JPanel menu = createInMenu(inmenu);
		JPanel cr = createCreditCard(cred);
		JPanel op = createOptionCard(opt);
		JPanel tuto1 = createTut1(tut1);
		JPanel tuto2 = createTut2(tut2);
		JPanel tuto3 = createTut3(tut3);
		JPanel tuto4 = createTut4(tut4);
		JPanel tuto5 = createTut5(tut5);
		
		cards.add(p2, MENU);
		cards.add(cr, CREDITS);
		cards.add(op, OPTIONS);
		cards.add(p3, SETTINGS);
		cards.add(p4, INTERFACE);
		cards.add(menu, INMENU);
		cards.add(tuto1, TUT1);
		cards.add(tuto2, TUT2);
		cards.add(tuto3, TUT3);
		cards.add(tuto4, TUT4);
		cards.add(tuto5, TUT5);
		
		
	}
	
	/*
	 * Method that creates the card for the option screen,
	 * where the player can change the music settings
	 * or pause the game
	 */
	public JPanel createOptionCard(JPanel panel)
	{
		//define components
		panel = new JPanel();
		panel.setBackground(Color.white);
		panel.setLayout(new BorderLayout());
		
		JPanel buttonBar = new JPanel();
		buttonBar.setBackground(Color.white);
		JPanel centerpane = new JPanel();
		centerpane.setBackground(Color.white);
		centerpane.setLayout(new BoxLayout(centerpane, BoxLayout.Y_AXIS));
		
		//set fonts and alignment
		JLabel header = new JLabel("Options");
		header.setFont(new Font("Verdana", Font.BOLD, 18));
		header.setHorizontalAlignment((int)CENTER_ALIGNMENT);
		
		pause = new JButton("Pause Game");
		pause.setEnabled(false);
		
		musicCheck = new JCheckBox("Music is On", true);
		soundCheck = new JCheckBox("Sound Effects are On", true);
		
		//create a button to go back to the main menu
		final JButton backButton = new JButton();
		backButton.setText("Back");
		backButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		backButton.setHorizontalAlignment((int)CENTER_ALIGNMENT);
		
		buttonBar.add(backButton);
		
		backButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
				CardLayout cl = (CardLayout)(cards.getLayout());
				if (ingameflag == false)
					cl.show(cards, MENU);
				else
				{
					cl.show(cards, INMENU);
				}
				
			}
		});
		
		//button that turns the music on and off
		musicCheck.setHorizontalAlignment((int)CENTER_ALIGNMENT);
		musicCheck.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (!musicCheck.isSelected())
				{
					musicCheck.setText("Music is Off");
					soundflag = false;
					if (songflag)
					{
						if (song3 != null)
							song3.stop();	
					}	
					else
					{
						if (song2 != null)
							song2.stop();
					}
					
				}
				else
				{
					musicCheck.setText("Music is On");
					soundflag = true;
					if (songflag)
					{
						if (song3 != null)
							song3.loop();
					}
					else
					{
						if (song2 != null)
							song2.loop();
					}
				}
			}
		});
		
		
		//button that turns the sound effects on and off
		soundCheck.setHorizontalAlignment((int)CENTER_ALIGNMENT);
		soundCheck.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (!soundCheck.isSelected())
				{
					soundCheck.setText("Sound Effects are Off");
					fxflag = false;
					
				}
				else
				{
					soundCheck.setText("Sound Effects are On");
					fxflag = true;
				}
			}
		});
		
		//button that handles the pause functionality
		pause.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		    	
		    	pause.setText("Unpause Game");
		    	
		    	if (pauseflag == false)
		    	{
			    	pauseflag = true;
			    	backButton.setEnabled(false);
			    	tDate.stop();
					t1.stop();
					tRandEvents.stop();
					tCusts.stop();
					if (tCustDown != null)
						tCustDown.stop();
					if (tCustUp != null)
						tCustUp.stop();
					if (tRes != null)
						tRes.stop();
					if (tCountdown != null)
						tCountdown.stop();

				}
				else if (pauseflag == true)
				{
					pause.setText("Pause Game");
					pauseflag = false;
					backButton.setEnabled(true);
                    t1.start();
                    tDate.start();
					tRandEvents.start();

					tCusts.start();
					if (tCustDown != null)
						tCustDown.start();
					if (tCustUp != null)
						tCustUp.start();
					if (tRes != null)
						tRes.start();
					if (tCountdown != null)
						tCountdown.start();
				}
				
				
		    }
		});
		
		panel.add(header, BorderLayout.NORTH);
		
		panel.add(centerpane, BorderLayout.CENTER);
		
		centerpane.add(Box.createRigidArea(new Dimension(20,80)));
		
		centerpane.add(musicCheck, Component.CENTER_ALIGNMENT);
		
		centerpane.add(Box.createRigidArea(new Dimension(20,40)));
		
		centerpane.add(soundCheck, Component.CENTER_ALIGNMENT);
		
        centerpane.add(Box.createRigidArea(new Dimension(20,40)));
        
        centerpane.add(pause, Component.CENTER_ALIGNMENT);
		
		panel.add(buttonBar, BorderLayout.SOUTH);
		
		return panel;
	}
	
	/*
	 *
	 * Method that creates the credits screen
	 *
	 */
	public JPanel createCreditCard(JPanel panel)
	{
		//define components
		panel = new JPanel();
		panel.setBackground(Color.white);
		panel.setLayout(new BorderLayout());
		
		JPanel buttonBar = new JPanel();
		buttonBar.setBackground(Color.white);
		
		//set fonts and alignment
		JLabel header = new JLabel("Credits");
		header.setFont(new Font("Verdana", Font.BOLD, 18));
		header.setHorizontalAlignment((int)CENTER_ALIGNMENT);
		
		JTextArea body = new JTextArea();
		//body.setEditable(false);
		
		//create the text for the credits
		body.setText("Tapioca King\n\n2007-2008\n by Alex Kort and Cecilia Tsoy" +
		"\n\n CPE 491/492 Senior Project\nDr. Aaron Keen\nCal Poly San Luis Obispo\n\n\n\n"
		+ "Special Thanks To:\nAlan Kort\nDerrek Karamanos\n\n\n" +
		"Music from \"Gunbound\" Property of Softnyx, Co., Ltd.\n" +
		"Music from \"Portal\" Property of Valve Corporation");
		
		//specify alignment and color of the text area
		body.setMargin(new Insets(50, 270, 50, 50));
		body.setLineWrap(true);
		body.setPreferredSize(new Dimension(500, 100));
		body.setMinimumSize(new Dimension(500, 100));
		body.setMaximumSize(new Dimension(500, 100));
		body.setBackground(new Color(238, 238, 238));
		
		//create a button to go back to the main menu
		JButton backButton = new JButton();
		backButton.setText("Back");
		backButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		backButton.setHorizontalAlignment((int)CENTER_ALIGNMENT);
		
		buttonBar.add(backButton);
		
		backButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
				CardLayout cl = (CardLayout)(cards.getLayout());
				if (ingameflag == false)
					cl.show(cards, MENU);
				else
				{
					cl.show(cards, INMENU);
				}
				
			}
		});
		
		panel.add(header, BorderLayout.NORTH);
		
		panel.add(body, BorderLayout.CENTER);
		
		panel.add(buttonBar, BorderLayout.SOUTH);
		
		return panel;
	}
	
	/*
	 *
	 * Method that creates the first tutorial card
	 *
	 */
	public JPanel createTut1(JPanel panel)
	{
        panel = new JPanel();
        panel.setBackground(Color.white);
        tutorLayout customLayout = new tutorLayout();

        panel.setFont(new Font("Helvetica", Font.PLAIN, 16));
        panel.setLayout(customLayout);
        
        //image
        JLabel pic = new JLabel(createImageIcon("images/tutor1.jpg"));
        pic.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        panel.add(pic);
        
        //context
        String context = "1) Type in your store name at the store banner.\n\n";
        context += "2) Pick an interior design from the list. A preview is provided below the list.\n\n";
        context += "3) Choose the uniform color from the drop-down menu.\n\n";
        context += "4) Set the game difficulty.\n\n"; 
        context += "5) Click 'Start!' and it will bring you to the game! \n";
            
        
        JTextArea conArea = new JTextArea(context);
        conArea.setLineWrap(true);
        conArea.setWrapStyleWord(true);
        panel.add(conArea);
        
        //Main Menu Button
        JButton mainMenu = new JButton("Main Menu");
        panel.add(mainMenu);
        
        mainMenu.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                
                if (ingameflag == false)
                	((CardLayout)cards.getLayout()).show(cards, MENU);
                else
                	((CardLayout)cards.getLayout()).show(cards, INMENU);
                
            }
        });
        
        // Previous button set disabled
        JButton prevP = new JButton("Previous");
        prevP.setEnabled(false);
        panel.add(prevP);
        
        // Next button
        JButton nextP = new JButton("Next");
        panel.add(nextP);
        nextP.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                
                ((CardLayout)cards.getLayout()).show(cards, TUT2);
                
            }
        });
        
		return panel;
	}
	
	/*
	 * Method that creates the second tutorial card
	 */
	public JPanel createTut2(JPanel panel)
	{
        panel = new JPanel();
        panel.setBackground(Color.white);
        tutorLayout customLayout = new tutorLayout();

        panel.setFont(new Font("Helvetica", Font.PLAIN, 16));
        panel.setLayout(customLayout);
        
        //image
        JLabel pic = new JLabel(createImageIcon("images/tutor2.jpg"));
        pic.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        panel.add(pic);
        
        //context
        String context = "1) After the game starts, go to the 'Research' tab and create a drink ";
        context += "so customers can start coming in.\n\n";
        context += "2) Pick the ingredient combination from the drop-down menus. ";
        context += "A tea is required while syrup and add-ons are optional.\n\n";
        context += "3) Name your drink or use the auto-name-generator. A drink must have a name.\n\n";
        context += "4) Set the sales price for your drink. Don't set it too high or customers would walk away!\n\n";
        context += "5) Click 'Create!' and your newly created drink will be shown in the menu. \n";
            
        
        JTextArea conArea = new JTextArea(context);
        conArea.setLineWrap(true);
        conArea.setWrapStyleWord(true);
        panel.add(conArea);
        
        //Main Menu button
        JButton mainMenu = new JButton("Main Menu");
        panel.add(mainMenu);
        
        mainMenu.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (ingameflag == false)
                	((CardLayout)cards.getLayout()).show(cards, MENU);
                else
                	((CardLayout)cards.getLayout()).show(cards, INMENU);
                
            }
        });
        
        //Previous button
        JButton prevP = new JButton("Previous");
        panel.add(prevP);
        prevP.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                
                ((CardLayout)cards.getLayout()).show(cards, TUT1);
                
            }
        });
        
        //Next button
        JButton nextP = new JButton("Next");
        panel.add(nextP);
        nextP.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                
                ((CardLayout)cards.getLayout()).show(cards, TUT3);
                
            }
        });
		return panel;
	}
	
	/*
	 * Method that creates the third tutorial card
	 */
	public JPanel createTut3(JPanel panel)
	{
		panel = new JPanel();
        panel.setBackground(Color.white);
        tutorLayout customLayout = new tutorLayout();

        panel.setFont(new Font("Helvetica", Font.PLAIN, 16));
        panel.setLayout(customLayout);
        
        //image
        JLabel pic = new JLabel(createImageIcon("images/tutor3.jpg"));
        pic.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        panel.add(pic);
        
        //context
        String context = "1) All the drinks created from the 'Research' tab are shown in the 'Menu' tab.\n\n ";
        context += "2) The sales price of each drinks can be edited by double clicking its 'Sales Price' field.\n\n";
        context += "3) Press ENTER on the keyboard or click elsewhere to save the change.\n\n";
        context += "4) Keep the price reasonable or customers will refuse to buy any!\n\n";
              
        
        JTextArea conArea = new JTextArea(context);
        conArea.setLineWrap(true);
        conArea.setWrapStyleWord(true);
        panel.add(conArea);
        
        //Main Menu button
        JButton mainMenu = new JButton("Main Menu");
        panel.add(mainMenu);
        
        mainMenu.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                
                ((CardLayout)cards.getLayout()).show(cards, MENU);
                
            }
        });
        
        //Previous button
        JButton prevP = new JButton("Previous");
        panel.add(prevP);
        prevP.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                
                ((CardLayout)cards.getLayout()).show(cards, TUT2);
                
            }
        });
        
        //Next button
        JButton nextP = new JButton("Next");
        panel.add(nextP);
        nextP.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                
                ((CardLayout)cards.getLayout()).show(cards, TUT4);
                
            }
        });
		return panel;
	}
	
	/*
	 * Method that creates the fourth tutorial card
	 */
	public JPanel createTut4(JPanel panel)
	{
		panel = new JPanel();
        panel.setBackground(Color.white);
        tutorLayout customLayout = new tutorLayout();

        panel.setFont(new Font("Helvetica", Font.PLAIN, 16));
        panel.setLayout(customLayout);
        
        //image
        JLabel pic = new JLabel(createImageIcon("images/tutor4.jpg"));
        pic.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        panel.add(pic);
        
        //context
        String context = "1) This is the Supplies Tab. Buy ingredients from here when they run low by clicking on their buttons.\n\n ";
        context += "2) You can change the number of each supply you buy at a time. When you're low you should change this number to be higher!\n\n";
        context += "3) The cost to buy that number of supplies is indicated below each supply button.\n\n";
        context += "4) Watch your funds, don't buy so many supplies that you run out of money.\n\n";
              
        
        JTextArea conArea = new JTextArea(context);
        conArea.setLineWrap(true);
        conArea.setWrapStyleWord(true);
        panel.add(conArea);
        
        //Main Menu button
        JButton mainMenu = new JButton("Main Menu");
        panel.add(mainMenu);
        
        mainMenu.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                
                if (ingameflag == false)
                	((CardLayout)cards.getLayout()).show(cards, MENU);
                else
                	((CardLayout)cards.getLayout()).show(cards, INMENU);
                
            }
        });
        
        //Previous button
        JButton prevP = new JButton("Previous");
        panel.add(prevP);
        prevP.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                
                ((CardLayout)cards.getLayout()).show(cards, TUT3);
                
            }
        });
        
        //Next button
        JButton nextP = new JButton("Next");
        panel.add(nextP);
        nextP.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                
                ((CardLayout)cards.getLayout()).show(cards, TUT5);
                
            }
        });
		return panel;
	}
	
	/*
	 * Method that creates the fifth tutorial card
	 */
	public JPanel createTut5(JPanel panel)
	{
		panel = new JPanel();
        panel.setBackground(Color.white);
        tutorLayout customLayout = new tutorLayout();

        panel.setFont(new Font("Helvetica", Font.PLAIN, 16));
        panel.setLayout(customLayout);
        
        //image
        JLabel pic = new JLabel(createImageIcon("images/tutor5.jpg"));
        pic.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        panel.add(pic);
        
        //context
        String context = "1) To progress in Tapioca King, you must fulfill each goal ";
        context += "as indicated at the top of the window. Otherwise, your game will end.\n\n";
        context += "2) In the Research Tab, click on the \"Hire a Research Team\" button";
        context += " to acquire new ingredients and interior designs.\n\n";
        context += "3) In the Promotion tab, buy you choice of promotion packages to get more customers in your store.\n\n";
        context += "4) Messages and alerts are shown in the events box.\n\n";
        context += "5) For more details, refer to the manual for reference.\n";
            
        
        JTextArea conArea = new JTextArea(context);
        conArea.setLineWrap(true);
        conArea.setWrapStyleWord(true);
        panel.add(conArea);
        
        //Main Menu button
        JButton mainMenu = new JButton("Main Menu");
        panel.add(mainMenu);
        
        mainMenu.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (ingameflag == false)
                	((CardLayout)cards.getLayout()).show(cards, MENU);
                else
                	((CardLayout)cards.getLayout()).show(cards, INMENU);
                
            }
        });
        
        //Previous button
        JButton prevP = new JButton("Previous");
        panel.add(prevP);
        prevP.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                
                ((CardLayout)cards.getLayout()).show(cards, TUT4);
                
            }
        });
        
        //Next button
        JButton nextP = new JButton("Next");
        panel.add(nextP);
        nextP.setEnabled(false);
        nextP.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                
                ((CardLayout)cards.getLayout()).show(cards, TUT6);
                
            }
        });
		return panel;
	}
	
	
	/*
	 * Method that creates the first card, the title screen
	 */
	public JPanel createCard1(JPanel panel)
	{
        
		//define components and sub panels
		JLabel text;
   		JButton startButton;
		panel = new JPanel();
		panel.setBackground(Color.white);
		
		JPanel sub2 = new JPanel();
		sub2.setBackground(Color.white);
		JPanel sub3 = new JPanel();
		sub3.setBackground(Color.white);
		panel.setLayout(new BorderLayout());
	
		panel.add(BorderLayout.SOUTH, sub3);
		
		
		text = new JLabel("Tapioca King");
		text.setFont(new Font("Arial Black", Font.BOLD, 22));
		text.setHorizontalAlignment((int)CENTER_ALIGNMENT);
		
		panel.add("North", text);
		
		//create start button and set the font
		startButton = new JButton("Start");
		startButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		//insert the logo picture in the title screen
		JLabel pic = new JLabel(createImageIcon("images/throne.jpg"));
		//updatePicture(pic, "throne.jpg");
		panel.add("Center", pic);
		
		//switch to the next card when start is pressed
		startButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (soundflag)
				{
					if (song != null)
						song.stop();
				}
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards, MENU);
				
				if (soundflag)
				{
					if (song2 != null)
						song2.loop();
				}
			}
		});
		
		sub3.add(startButton);
		if (newgameflag == false)
		{
			if (soundflag)
			{
				if (song != null)
					song.loop();
			}	
        }
        else
        	newgameflag = false;
		return panel;
	}
	
	
	
	/*
	 * Method that creates the second card, the Main Menu
	 */
	public JPanel createCard2(JPanel panel2)
	{
		//define components
		JLabel text;
		JButton newGame;
		JButton tutorial;
		JButton options;
		JButton credits;
		JButton exit;	
		
		//initialize components
		panel2 = new JPanel();
                
		gmenuLayout customLayout = new gmenuLayout();
		
        panel2.setLayout(customLayout);
		panel2.setBackground(Color.white);
		
		//initialize buttons and panels and set fonts
		text = new JLabel("Tapioca King Main Menu");
		text.setFont(new Font("Tahoma", Font.BOLD, 14));
		text.setHorizontalAlignment((int)CENTER_ALIGNMENT);
		panel2.add(text);
		
		newGame = new JButton("New Game");
		newGame.setFont(new Font("Tahoma", Font.BOLD, 14));
		newGame.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel2.add(newGame);
		
		tutorial = new JButton("Quick Guide");
		tutorial.setFont(new Font("Tahoma", Font.BOLD, 14));
		tutorial.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		options = new JButton("Options");
		options.setFont(new Font("Tahoma", Font.BOLD, 14));
		options.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		credits = new JButton("Credits");
		credits.setFont(new Font("Tahoma", Font.BOLD, 14));
		credits.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		exit = new JButton("Exit Game");
		exit.setFont(new Font("Tahoma", Font.BOLD, 14));
		exit.setAlignmentX(Component.LEFT_ALIGNMENT);
		
	
		//Make all the buttons the same width, very important
		JButton[] card2buttons = {newGame, tutorial, options, credits};
		equalSizes(card2buttons);
		
        panel2.add(tutorial);
        
        panel2.add(options);
        
        panel2.add(credits);
        
        panel2.add(exit);
        
        final JLabel set_king = new JLabel(createImageIcon("images/menu_first.jpg"));
        panel2.add(set_king);
		
		//add functionality to the buttons, change cards as necessary
		newGame.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				((CardLayout)cards.getLayout()).show(cards, SETTINGS);
			}
		});
        newGame.addMouseListener(new MouseListener()
        {
            public void mouseEntered(MouseEvent e)
            {
                set_king.setIcon(createImageIcon("images/menu_newgame.jpg"));
            }       
            public void mouseExited(MouseEvent e)
            {
                set_king.setIcon(createImageIcon("images/menu_first.jpg"));
                
            }
            public void mouseClicked(MouseEvent e)
            {
            }
            public void mousePressed(MouseEvent e)
            {
            }
            public void mouseReleased(MouseEvent e)
            {
            }

        });
        
        tutorial.addMouseListener(new MouseListener()
        {
            public void mouseEntered(MouseEvent e)
            {
                set_king.setIcon(createImageIcon("images/menu_tutor.jpg"));
            }       
            public void mouseExited(MouseEvent e)
            {
                set_king.setIcon(createImageIcon("images/menu_first.jpg"));
                
            }
            public void mouseClicked(MouseEvent e)
            {
            }
            public void mousePressed(MouseEvent e)
            {
            }
            public void mouseReleased(MouseEvent e)
            {
            }

        });
        tutorial.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                ((CardLayout)cards.getLayout()).show(cards, TUT1);
            }
        });
		
		credits.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				((CardLayout)cards.getLayout()).show(cards, CREDITS);
			}
		});
		
        credits.addMouseListener(new MouseListener()
        {
            public void mouseEntered(MouseEvent e)
            {
                set_king.setIcon(createImageIcon("images/menu_credits.jpg"));
            }       
            public void mouseExited(MouseEvent e)
            {
                set_king.setIcon(createImageIcon("images/menu_first.jpg"));
                
            }
            public void mouseClicked(MouseEvent e)
            {
            }
            public void mousePressed(MouseEvent e)
            {
            }
            public void mouseReleased(MouseEvent e)
            {
            }

        });
		
		options.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				songflag = false;
				((CardLayout)cards.getLayout()).show(cards, OPTIONS);
			}
		});
        options.addMouseListener(new MouseListener()
        {
            public void mouseEntered(MouseEvent e)
            {
                set_king.setIcon(createImageIcon("images/menu_option.jpg"));
            }       
            public void mouseExited(MouseEvent e)
            {
                set_king.setIcon(createImageIcon("images/menu_first.jpg"));
                
            }
            public void mouseClicked(MouseEvent e)
            {
            }
            public void mousePressed(MouseEvent e)
            {
            }
            public void mouseReleased(MouseEvent e)
            {
            }

        });
		
		exit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ingameflag = false;
				Object[] options = {"Yes","No"};
				int n = JOptionPane.showOptionDialog(exitDialog,
				    "Your current game will end.\n"
				    + "Are you sure you want to exit?", "Exit?",
				    JOptionPane.YES_NO_OPTION,
				    JOptionPane.QUESTION_MESSAGE,
				    null,     //do not use a custom Icon
				    options,  //the titles of buttons
				    options[0]); //default button title
				
				if (n == JOptionPane.YES_OPTION)
				{
        			
        			if (soundflag)
        			{
        				if (song2 != null)
	        				song2.stop();
	        			if (song3 != null)
	        				song3.stop();
	        			if (song != null)
	        				song.loop();
	        		}
					((CardLayout)cards.getLayout()).show(cards, TITLE);
				}
				else
					return;
			}
		});
        exit.addMouseListener(new MouseListener()
        {
            public void mouseEntered(MouseEvent e)
            {
                set_king.setIcon(createImageIcon("images/menu_newexit.jpg"));
            }       
            public void mouseExited(MouseEvent e)
            {
                set_king.setIcon(createImageIcon("images/menu_first.jpg"));
                
            }
            public void mouseClicked(MouseEvent e)
            {
            }
            public void mousePressed(MouseEvent e)
            {
            }
            public void mouseReleased(MouseEvent e)
            {
            }

        });
		

		
        
		return panel2;
	}
	
	/*
	 * Method that creates the in-game Main Menu
	 */
	public JPanel createInMenu(JPanel panel2)
	{
		//define components
		JLabel text;
		JButton newGame;
		JButton tutorial;
		JButton options;
		JButton credits;
		JButton exit;
		JButton resGame;	
		
		//initialize components
		panel2 = new JPanel();
		panel2.setBackground(Color.white);
		
       inmenuLayout customLayout = new inmenuLayout();
        
        panel2.setLayout(customLayout);
		
    	//initialize buttons and panels and set fonts
		text = new JLabel("Tapioca King Main Menu");
		text.setFont(new Font("Verdana", Font.BOLD, 18));
		text.setHorizontalAlignment((int)CENTER_ALIGNMENT);
		panel2.add(text);
		
		resGame = new JButton("Resume Game");
		resGame.setFont(new Font("Tahoma", Font.BOLD, 14));
		resGame.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel2.add(resGame);
		
		newGame = new JButton("New Game");
		newGame.setFont(new Font("Tahoma", Font.BOLD, 14));
		newGame.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		tutorial = new JButton("Quick Guide");
		tutorial.setFont(new Font("Tahoma", Font.BOLD, 14));
		tutorial.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		options = new JButton("Options");
		options.setFont(new Font("Tahoma", Font.BOLD, 14));
		options.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		credits = new JButton("Credits");
		credits.setFont(new Font("Tahoma", Font.BOLD, 14));
		credits.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		exit = new JButton("Exit Game");
		exit.setFont(new Font("Tahoma", Font.BOLD, 14));
		exit.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		//Make all the buttons the same width, very important
		JButton[] card2buttons = {newGame, tutorial, options, credits};
		equalSizes(card2buttons);
		
        panel2.add(newGame);
		
        panel2.add(tutorial);
        
        panel2.add(options);
        
        panel2.add(credits);
        
        panel2.add(exit);
        
        final JLabel set_king = new JLabel(createImageIcon("images/menu_resume.jpg"));
        panel2.add(set_king);
		
		//add functionality to the buttons, change cards as necessary
		resGame.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				((CardLayout)cards.getLayout()).show(cards, INTERFACE);
			}
		});
		
        resGame.addMouseListener(new MouseListener()
        {
            public void mouseEntered(MouseEvent e)
            {
                set_king.setIcon(createImageIcon("images/menu_resume.jpg"));
            }       
            public void mouseExited(MouseEvent e)
            {
                set_king.setIcon(createImageIcon("images/menu_resume.jpg"));
                
            }
            public void mouseClicked(MouseEvent e)
            {
            }
            public void mousePressed(MouseEvent e)
            {
            }
            public void mouseReleased(MouseEvent e)
            {
            }

        });
		newGame.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//popup a dialog to confirm new game
				Object[] options = {"Yes","No"};
				int n = JOptionPane.showOptionDialog(exitDialog,
				    "Your current game will end.\n"
				    + "Are you sure you want to start a new game?", "Exit?",
				    JOptionPane.YES_NO_OPTION,
				    JOptionPane.QUESTION_MESSAGE,
				    null,     //do not use a custom Icon
				    options,  //the titles of buttons
				    options[0]); //default button title
				
				if (n == JOptionPane.YES_OPTION)
				{
					ingameflag = false;
					newgameflag = true;
                    pause.setEnabled(false);
					initNewGame();
					((CardLayout)cards.getLayout()).show(cards, SETTINGS);
					if (soundflag)
					{
						if (song3 != null)
							song3.stop();
						if (song2 != null)
							song2.loop();
					}
				}
				else
					return;
				
			}
		});
		
		credits.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				((CardLayout)cards.getLayout()).show(cards, CREDITS);
			}
		});
		
        tutorial.addMouseListener(new MouseListener()
        {
            public void mouseEntered(MouseEvent e)
            {
                set_king.setIcon(createImageIcon("images/menu_tutor.jpg"));
            }       
            public void mouseExited(MouseEvent e)
            {
                set_king.setIcon(createImageIcon("images/menu_resume.jpg"));
                
            }
            public void mouseClicked(MouseEvent e)
            {
            }
            public void mousePressed(MouseEvent e)
            {
            }
            public void mouseReleased(MouseEvent e)
            {
            }

        });
        
        tutorial.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                ((CardLayout)cards.getLayout()).show(cards, TUT1);
            }
        });
        
        credits.addMouseListener(new MouseListener()
        {
            public void mouseEntered(MouseEvent e)
            {
                set_king.setIcon(createImageIcon("images/menu_credits.jpg"));
            }       
            public void mouseExited(MouseEvent e)
            {
                set_king.setIcon(createImageIcon("images/menu_resume.jpg"));
                
            }
            public void mouseClicked(MouseEvent e)
            {
            }
            public void mousePressed(MouseEvent e)
            {
            }
            public void mouseReleased(MouseEvent e)
            {
            }

        });
		
		options.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				songflag = true;
				((CardLayout)cards.getLayout()).show(cards, OPTIONS);
			}
		});
        options.addMouseListener(new MouseListener()
        {
            public void mouseEntered(MouseEvent e)
            {
                set_king.setIcon(createImageIcon("images/menu_option.jpg"));
            }       
            public void mouseExited(MouseEvent e)
            {
                set_king.setIcon(createImageIcon("images/menu_resume.jpg"));
                
            }
            public void mouseClicked(MouseEvent e)
            {
            }
            public void mousePressed(MouseEvent e)
            {
            }
            public void mouseReleased(MouseEvent e)
            {
            }

        });
		
		exit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//popup a dialog to confirm exit
				ingameflag = false;
				Object[] options = {"Yes","No"};
				int n = JOptionPane.showOptionDialog(exitDialog,
				    "Your current game will end.\n"
				    + "Are you sure you want to exit?", "Exit?",
				    JOptionPane.YES_NO_OPTION,
				    JOptionPane.QUESTION_MESSAGE,
				    null,     //do not use a custom Icon
				    options,  //the titles of buttons
				    options[0]); //default button title
				
				if (n == JOptionPane.YES_OPTION)
				{
					if (soundflag)
					{
						if (song3 != null)
							song3.stop();
						if (song != null)
							song.loop();
					}
                    pause.setEnabled(false);
					initNewGame();
					((CardLayout)cards.getLayout()).show(cards, TITLE);
				}
				else
					return;
			}
		});
        exit.addMouseListener(new MouseListener()
        {
            public void mouseEntered(MouseEvent e)
            {
                set_king.setIcon(createImageIcon("images/menu_exit.jpg"));
            }       
            public void mouseExited(MouseEvent e)
            {
                set_king.setIcon(createImageIcon("images/menu_resume.jpg"));
                
            }
            public void mouseClicked(MouseEvent e)
            {
            }
            public void mousePressed(MouseEvent e)
            {
            }
            public void mouseReleased(MouseEvent e)
            {
            }

        });
		

		
		return panel2;
	}
	
	/*
	 * Method that creates the 3rd card, the Settings screen
	 */
	public JPanel createCard3(JPanel panel3)
	{
		//define components
		panel3 = new JPanel();
		panel3.setBackground(Color.white);
		new JLayeredPane();
		JLabel interlabel;
	    JLabel colorlabel;
	    JLabel storelbl;
	    JButton start;
	    JButton cancel;
	    final JComboBox<String> unicolor;
	    final JList<String> interior;
	    JScrollPane sp_interior;
	    JLabel header;
	    JLabel difLabel;
	    
	    inter = new JList<String>();
	
		//initialize and add the components
	    settingsLayout customLayout = new settingsLayout();
	
	    panel3.setFont(new Font("Helvetica", Font.PLAIN, 12));
	    panel3.setBackground(Color.white);
	    panel3.setLayout(customLayout);
   
	    storelbl = new JLabel(createImageIcon("images/storename.jpg"));
	    panel3.add(storelbl);
	
        storename = new TxtField("Tapioca King", 22);
        storename.setBorder(null);

	    panel3.add(storename);
	
	    interlabel = new JLabel("Interior");
	    panel3.add(interlabel);
	    
	    JLabel kingbl = new JLabel(createImageIcon("images/setup_king.jpg"));
        panel3.add(kingbl);
	
	    colorlabel = new JLabel("Uniform Color:");
	    panel3.add(colorlabel);
	
	    start = new JButton("Start!");
	    start.setFont(new Font("Tahoma", Font.BOLD, 14));
	    panel3.add(start);
	    
	    //when settings have been decided upon, clicking
	    //the save button will use these settings and 
	    //proceed to the main game card
	    
	
		//initialize and add functionality to the cancel button
	    cancel = new JButton("Cancel");
	    cancel.setFont(new Font("Tahoma", Font.BOLD, 14));
	    panel3.add(cancel);
	
		//crete the combobox for uniform colors
		//adding a variety of colors to choose from
	    unicolor = new JComboBox<String>();
	    unicolor.addItem("Red");
	    unicolor.addItem("Green");
	    unicolor.addItem("Blue");
	    panel3.add(unicolor);

		//add items to the list box to choose the interior styles
	    listModel_interior = new DefaultListModel<String>();
	    listModel_interior.addElement("Classic");
	    listModel_interior.addElement("Trendy");
	    interior = new JList<String>(listModel_interior);
	    interior.setSelectedIndex(0);
	    interior.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    interior.addListSelectionListener(new ListSelectionListener()
	    {
		    public void valueChanged(ListSelectionEvent e) 
		    {
		    	if (e.getValueIsAdjusting() == false) 
		    	{
					interInd = interior.getSelectedIndex();					
					inter.setSelectedIndex(interInd);
				}
			}
		});


        final JLabel inter_design1 = new JLabel(createImageIcon("images/classic_ex.jpg"));
        inter_design1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        interior.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    int index = interior.locationToIndex(e.getPoint());
                    if (index == 0)
                        inter_design1.setIcon(createImageIcon("images/classic_ex.jpg"));
                    if (index == 1)
                        inter_design1.setIcon(createImageIcon("images/modern_ex.jpg"));
                }
            }
        });
        panel3.add(inter_design1);
        
        

	    sp_interior = new JScrollPane(interior);
	    panel3.add(sp_interior);
	    
	    header = new JLabel("Setup Your Store!");
	    header.setFont(new Font("Dialog", Font.BOLD, 14));
	    panel3.add(header);
	    
	    difLabel = new JLabel("Select Game Difficulty");
	    panel3.add(difLabel);
	    
	    difficulty = new JComboBox<String>();
	    difficulty.addItem("Select...");
	    difficulty.addItem("Easy");
	    difficulty.addItem("Normal");
	    difficulty.addItem("Hard");
	    
		//set the goals array to the selected difficulty goals
	    goals = mgoals;

	    panel3.add(difficulty);
	    
	    difString = new JLabel("");
	    panel3.add(difString);
	    
	    JLabel unibl = new JLabel(createImageIcon("images/uniform.jpg"));
        panel3.add(unibl);
        
        
        
 
        
	    //handle setting the difficulty of the game
	    difficulty.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int c = difficulty.getSelectedIndex();
				switch (c)
				{
					case 0:
						//no difficulty
						
						difString.setText("");
						break;
					case 1:
						//easy difficulty
						goals = egoals;
						difString.setText("Everyone Loves Tapioca!");
						
						//give the user more default customers
						min_cus = 5;
						max_cus = 15;
						diff_cus = 10;
						cupsupply = new Inventory(Ingredients.Cup, 50);
				   		napsupply = new Inventory(Ingredients.Napkin, 50);
				   		strawsupply = new Inventory(Ingredients.Straw, 50);
				   	 	ingsupply = new Inventory(Ingredients.General, 50);
				   	 	
				   	 	cupamt.setText(Integer.toString(cupsupply.getAmount()));
					   	strawamt.setText(Integer.toString(strawsupply.getAmount()));
					   	napamt.setText(Integer.toString(napsupply.getAmount()));
					   	ingamt.setText(Integer.toString(ingsupply.getAmount()));
					   	
                        //change the cost of supplies
                        tmodel.setCupCost(.05);
                        tmodel.setStrawCost(.02);
                        tmodel.setNapkinCost(.02);
                        
                        //cost of napkins
                        napcalc = tmodel.getInCost().get(Ingredients.Napkin)
                            * Double.parseDouble((String)napcombo.getSelectedItem());
                        costField1.setText(df.format(napcalc));
                        costField1.setEditable(false);
                        
                        //cost of straws
                        strawcalc = tmodel.getInCost().get(Ingredients.Straw)
                            * Double.parseDouble((String)strawcombo.getSelectedItem());
                        costField2.setText(df.format(strawcalc));
                        costField2.setEditable(false);
                        
                        //cost of cups
                        cupcalc = tmodel.getInCost().get(Ingredients.Cup)
                            *Double.parseDouble((String)cupcombo.getSelectedItem());
                        costField3.setText(df.format(cupcalc));
                        costField3.setEditable(false);
                        break;
					case 2:
						//normal difficulty
						goals = mgoals;
						difString.setText("Business as Usual");
						
						//change the cost of supplies
						tmodel.setCupCost(.07);
						tmodel.setStrawCost(.03);
						tmodel.setNapkinCost(.03);
						
						//cost of napkins
						napcalc = tmodel.getInCost().get(Ingredients.Napkin)
							* Double.parseDouble((String)napcombo.getSelectedItem());
				        costField1.setText(df.format(napcalc));
        				costField1.setEditable(false);
        				
        				//cost of straws
						strawcalc = tmodel.getInCost().get(Ingredients.Straw)
							* Double.parseDouble((String)strawcombo.getSelectedItem());
				        costField2.setText(df.format(strawcalc));
				        costField2.setEditable(false);
				        
				        //cost of cups
						cupcalc = tmodel.getInCost().get(Ingredients.Cup)
							*Double.parseDouble((String)cupcombo.getSelectedItem());
				        costField3.setText(df.format(cupcalc));
				        costField3.setEditable(false);
						break;
					case 3:
						//hard difficulty
						goals = hgoals;
						difString.setText("Tough Crowd.");
						
						//give the user less default customers
						min_cus = 1;
						max_cus = 7;
						diff_cus = 7;
						
						//change the cost of supplies
						tmodel.setCupCost(.10);
						tmodel.setStrawCost(.05);
						tmodel.setNapkinCost(.05);
						
						//cost of napkins
						napcalc = tmodel.getInCost().get(Ingredients.Napkin)
							* Double.parseDouble((String)napcombo.getSelectedItem());
				        costField1.setText(df.format(napcalc));
        				costField1.setEditable(false);
        				
        				//cost of straws
						strawcalc = tmodel.getInCost().get(Ingredients.Straw)
							* Double.parseDouble((String)strawcombo.getSelectedItem());
				        costField2.setText(df.format(strawcalc));
				        costField2.setEditable(false);
				        
				        //cost of cups
						cupcalc = tmodel.getInCost().get(Ingredients.Cup)
							*Double.parseDouble((String)cupcombo.getSelectedItem());
				        costField3.setText(df.format(cupcalc));
				        costField3.setEditable(false);
				        
				        cupsupply = new Inventory(Ingredients.Cup, 0);
				   		napsupply = new Inventory(Ingredients.Napkin, 0);
				   		strawsupply = new Inventory(Ingredients.Straw, 0);
				   	 	ingsupply = new Inventory(Ingredients.General, 0);
				   	 	
				   	 	cupamt.setText(Integer.toString(cupsupply.getAmount()));
					   	strawamt.setText(Integer.toString(strawsupply.getAmount()));
					   	napamt.setText(Integer.toString(napsupply.getAmount()));
					   	ingamt.setText(Integer.toString(ingsupply.getAmount()));
						break;
				}
			}
		});
	    
	    //clear the store name text field when it is clicked in
	    storename.addMouseListener(new MouseListener()
	    {
	    	boolean nameflag = false;
	    	public void mouseEntered(MouseEvent e)
	    	{
	    	}    	
	    	public void mouseExited(MouseEvent e)
	    	{
	    	}
	    	public void mouseClicked(MouseEvent e)
	    	{
	    		if (nameflag == false)
	    		{
	    			storename.setText("");
	    		}
	    		nameflag = true;
	    	}
	    	public void mousePressed(MouseEvent e)
	    	{
	    		if (nameflag == false)
	    		{
	    			storename.setText("");
	    		}
	    		nameflag = true;
	    	}
	    	public void mouseReleased(MouseEvent e)
	    	{
	    	}

	    });
	    
	    //this will save the setup and start the game
	    start.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ingameflag = true;
				
				storenm = storename.getText();
				if (storenm.trim().equals("") || storenm.trim().equals("Type Here") || storenm == null)
				{
					JOptionPane.showMessageDialog(drinkDialog,
					    "Please Enter a Name for Your Store",
					    "Setup Your Tapioca Store",
					    JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if (difficulty.getSelectedIndex() == 0)
				{
					JOptionPane.showMessageDialog(drinkDialog,
					    "Please Choose a Difficulty",
					    "Setup Your Tapioca Store",
					    JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if (soundflag)
				{
					if (song2 != null)
						song2.stop();
				}
					
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards, INTERFACE);
				
				if (soundflag)
				{
					if (song3 != null)
						song3.loop();
				}
				
				//enable the pause button when inside the game
				pause.setEnabled(true);
			
				
                uniform = unicolor.getSelectedIndex();
                compareUniform();
                
                interInd = interior.getSelectedIndex();
                compareInterior();
                compareIntPreview();
                interBox.setSelectedIndex(interInd);
                store_fridge.setIcon(createImageIcon("images/store_fridge_work.jpg"));
                store_blender.setIcon(createImageIcon("images/store_blender_work.jpg"));
                store_napkin.setIcon(createImageIcon("images/store_napkin_work.jpg"));
                store_straw.setIcon(createImageIcon("images/store_straw_work.jpg"));
                store_cups.setIcon(createImageIcon("images/store_cup_work.jpg"));
                store_ing.setIcon(createImageIcon("images/store_ing_work.jpg"));
				
				//set the day counter in the date box
				date.setText(""+d);
                goalField.setText("Have more than $500.00 by the end of Day 20.");
                
                setupTimers();
        	}
		});
                
				
		
		cancel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				((CardLayout)cards.getLayout()).show(cards, MENU);	
			}
		});
	
	    setSize(getPreferredSize());
	    return panel3;
	}
	
	/*
	 * Method that creates the 4th card, the
	 * main game screen with tabs. This is where
	 * gameplay begins.
	 */
	public JPanel createCard4(JPanel panel4)
	{
		//create the tabbed pane
		JTabbedPane tp = new JTabbedPane();
		panel4 = new JPanel(new BorderLayout());
		panel4.setBackground(Color.white);
		panel4.add(BorderLayout.CENTER, tp);
		
		//create the top portion of the window, where the 
		//status and variables are displayed
		JPanel sub = new JPanel();
		sub.setBackground(Color.white);
		abovetabsLayout customLayout = new abovetabsLayout();

        sub.setFont(new Font("Helvetica", Font.PLAIN, 12));
        sub.setLayout(customLayout);

        JLabel dateLabel = new JLabel("Day:");
        sub.add(dateLabel);

		
		// Date field    
        date = new JTextField();
        date.setFont(new Font("Arial", Font.PLAIN, 14));
               
        date.setEditable(false);
        sub.add(date);

        JButton menu = new JButton("Main Menu");
        sub.add(menu);

        JLabel dollar = new JLabel("Total Funds:  $");
        sub.add(dollar);

        moneyfield = new JTextField(df.format(money));
        moneyfield.setEditable(false);
        
        sub.add(moneyfield);

        JLabel cuplabel = new JLabel("Cups:");
        sub.add(cuplabel);

        JLabel strawlabel = new JLabel("Straws:");
        sub.add(strawlabel);

        JLabel naplabel = new JLabel("Napkins:");
        sub.add(naplabel);

        JLabel tealabel = new JLabel("Ingredients:");
        sub.add(tealabel);

        cupamt = new JTextField(Integer.toString(cupsupply.getAmount()));
        cupamt.setEditable(false);
        sub.add(cupamt);

        strawamt = new JTextField(Integer.toString(strawsupply.getAmount()));
        strawamt.setEditable(false);
        sub.add(strawamt);

        napamt = new JTextField(Integer.toString(napsupply.getAmount()));
        napamt.setEditable(false);
        sub.add(napamt);

        ingamt = new JTextField(Integer.toString(ingsupply.getAmount()));
        ingamt.setEditable(false);
        sub.add(ingamt);
        
        JLabel goalLabel = new JLabel("Goal: ");
		sub.add(goalLabel);

        goalField = new JTextField();
        goalField.setFont(new Font("Arial", Font.PLAIN, 14));
               
        goalField.setEditable(false);
        sub.add(goalField);
        
        //the events text area will show game messages
        events = new JTextPane();
        events.setFont(new Font("Arial", Font.PLAIN, 14));
        events.setEditable(false);
        sp_events = new JScrollPane(events);
        sub.add(sp_events);
		
		//when the menu button is clicked, go back to the main menu card
		menu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{	
				((CardLayout)cards.getLayout()).show(cards, INMENU);
			}
		});
		
		panel4.add(BorderLayout.NORTH, sub);
		
		//create the separate tab panels, add them to the central tabbed pane
		JPanel sub1 = new JPanel();
		sub1.setBackground(Color.white);
		createStoreTab(sub1);
		JPanel sub3 = new JPanel();
		sub3.setBackground(Color.white);
		createMenuTab(sub3);
		JPanel sub2 = new JPanel();
		sub2.setBackground(Color.white);
		createSuppliesTab(sub2);		
		JPanel sub4 = new JPanel();
		sub4.setBackground(Color.white);
		createResearchTab(sub4);
		JPanel sub5 = new JPanel();
		sub5.setBackground(Color.white);
		createPromotionTab(sub5);
		
		tp.addTab("Store", sub1);
		tp.addTab("Supplies", sub2);
		tp.addTab("Menu", sub3);
		tp.addTab("Research", sub4);
		tp.addTab("Promotion", sub5);
		
		return panel4;
	}
	
	/*
	 * Method that creates the store tab where store activity is shown
	 */
	public void createStoreTab(JPanel tab)
	{
		//create components
    	
    	
    	//set the component locations
		storeLayout customLayout = new storeLayout();

        tab.setFont(new Font("Helvetica", Font.PLAIN, 12));
        tab.setLayout(customLayout);
		
           
        tab.add(store_ceiling);
        
        tab.add(store_customers);
        
        tab.add(store_money);

        tab.add(store_fridge);
        
        tab.add(store_blender);
        
        tab.add(store_ing);
        
        tab.add(store_cups);
        
        tab.add(store_napkin);
        
        tab.add(store_straw);
        
        compareUniform();
        
        tab.add(store_staff);
    
        tab.add(store_rack);
        
        tab.add(store_stand);
        
        tab.add(store_counter1);
        tab.add(store_counter2);
        tab.add(store_counter3);
        
        tab.add(store_table1);
        tab.add(store_table2);
        tab.add(store_table3);

		

        setSize(getPreferredSize());
	}
	
	/*
	 * Method that creates the tab for buying more supplies
	 */
	public void createSuppliesTab(JPanel tab)
	{
		// Define supplies tab and its components
		JButton cups;
	    JButton straws;
	    JButton napkins;
	    
	    //JButton ings;
	    JLabel reorder1;
	    JLabel reorder2;
	    JLabel reorder3;
	    JLabel reorder4;
	    
	    JLabel costLabel1;
	    JLabel costLabel2;
	    JLabel costLabel3;
	    JLabel costLabel4;
	    
	    JLabel supTitle;
	    
	    ImageIcon cupIcon = createImageIcon("images/supply_cup.jpg");
	    ImageIcon strawIcon = createImageIcon("images/supply_straw.jpg");
	    ImageIcon napIcon = createImageIcon("images/supply_napkin.jpg");
	    

    	//set the locations of the components
        suppliesLayout customLayout = new suppliesLayout();

        tab.setFont(new Font("Helvetica", Font.PLAIN, 12));
        tab.setLayout(customLayout);

		//define buttons
        cups = new JButton("<html><CENTER>Purchase<br>Cups</CENTER></html>", cupIcon);
        // Place text above icon
        cups.setBackground(new Color(253, 188, 33));
    	cups.setVerticalTextPosition(SwingConstants.TOP);
    	cups.setHorizontalTextPosition(SwingConstants.CENTER);
    	
        cups.setFont(new Font("Tahoma", Font.BOLD, 14));
        tab.add(cups);
        
        cups.setForeground(Color.white);

        straws = new JButton("<html><CENTER>Purchase<br>Straws</CENTER></html>", strawIcon);
        // Place text above icon
        straws.setBackground(new Color(39, 58, 151));
    	straws.setVerticalTextPosition(SwingConstants.TOP);
    	straws.setHorizontalTextPosition(SwingConstants.CENTER);
    	
        straws.setFont(new Font("Tahoma", Font.BOLD, 14));
        straws.setForeground(Color.white);
        tab.add(straws);

        napkins = new JButton("<html><CENTER>Purchase<br>Napkins</CENTER></html>", napIcon);
        // Place text above icon
        napkins.setBackground(new Color(211, 33, 43));
    	napkins.setVerticalTextPosition(SwingConstants.TOP);
    	napkins.setHorizontalTextPosition(SwingConstants.CENTER);
        napkins.setForeground(Color.white);
        napkins.setFont(new Font("Tahoma", Font.BOLD, 14));
        tab.add(napkins);

        
        ings.setBackground(new Color(145, 244, 111));
        ings.setEnabled(false);
        ings.setFont(new Font("Tahoma", Font.BOLD, 14));
        ings.setVerticalTextPosition(SwingConstants.TOP);
        ings.setHorizontalTextPosition(SwingConstants.CENTER);
        ings.setForeground(Color.white);
        tab.add(ings);

		//define labels
        reorder1 = new JLabel("Reorder");
        tab.add(reorder1);

        reorder2 = new JLabel("Reorder");
        tab.add(reorder2);

        reorder3 = new JLabel("Reorder");
        tab.add(reorder3);

        reorder4 = new JLabel("Reorder");
        tab.add(reorder4);

		//define amount combos
        cupcombo = new JComboBox<String>();
        cupcombo.addItem("25");
        cupcombo.addItem("50");
        cupcombo.addItem("100");
        cupcombo.addItem("200");
        cupcombo.addItem("500");
        cupcombo.addItem("1000");
        tab.add(cupcombo);

        strawcombo = new JComboBox<String>();
        strawcombo.addItem("25");
        strawcombo.addItem("50");
        strawcombo.addItem("100");
        strawcombo.addItem("200");
        strawcombo.addItem("500");
        strawcombo.addItem("1000");
        tab.add(strawcombo);

        napcombo = new JComboBox<String>();
        napcombo.addItem("100");
        napcombo.addItem("200");
        napcombo.addItem("300");
        napcombo.addItem("500");
        napcombo.addItem("1000");
        tab.add(napcombo);

        ingcombo = new JComboBox<String>();
        ingcombo.addItem("12");
        ingcombo.addItem("24");
        ingcombo.addItem("48");
        ingcombo.addItem("96");
        ingcombo.addItem("180");
        ingcombo.addItem("300");
        ingcombo.addItem("600");
        tab.add(ingcombo);
        
        //define cost calculating fields
        costLabel1 = new JLabel("Cost:      $");
        tab.add(costLabel1);

        costLabel2 = new JLabel("Cost:      $");
        tab.add(costLabel2);

        costLabel3 = new JLabel("Cost:      $");
        tab.add(costLabel3);

        costLabel4 = new JLabel("Cost:      $");
        tab.add(costLabel4);

		
		
		
		//cost of napkins

        costField1 = new JTextField(df.format(napcalc));
        tab.add(costField1);

		//cost of straws
        costField2 = new JTextField(df.format(strawcalc));
        tab.add(costField2);

		//cost of cups
        costField3 = new JTextField(df.format(cupcalc));
        tab.add(costField3);

		//cost of tea
		
		ingcalc = calculateIngSetCost() * Double.parseDouble((String)ingcombo.getSelectedItem());
        costField4 = new JTextField(df.format(ingcalc));
        costField4.setEditable(false);
        tab.add(costField4);
        
        //add title label
        supTitle = new JLabel("Order More Supplies Here");
        tab.add(supTitle);
        
        //tab functionality
        
        //calculate in real time the price of the supply as
        //each supply amount in the combo boxes is selected
        cupcombo.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{
				cupcalc = tmodel.getInCost().get(Ingredients.Cup)*Double.parseDouble((String)cupcombo.getSelectedItem());
				costField3.setText(df.format(cupcalc));
			}
		});
		
		strawcombo.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				strawcalc = tmodel.getInCost().get(Ingredients.Straw)*Double.parseDouble((String)strawcombo.getSelectedItem());
				costField2.setText(df.format(strawcalc));
			}
		});
		
		napcombo.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				napcalc = tmodel.getInCost().get(Ingredients.Napkin)*Double.parseDouble((String)napcombo.getSelectedItem());
				costField1.setText(df.format(napcalc));
			}
		});
		
        ingcombo.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
              updateIngSetCost();  
			}
		});
        
        //When the supply buttons are pressed, the specified
        //amount is ordered. Money is subtracted and supplies
        //are added
        cups.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				money -= cupcalc;
				expenses[sindex] += cupcalc;
				if (money < 0)
				{
					//if not enough money to buy this supply, do
					//not subtract funds and issue an error message
					money += cupcalc;
					expenses[sindex] -= cupcalc;
					JOptionPane.showMessageDialog(drinkDialog,
					    "Sorry, there are not enough funds to buy more cups.",
					    "Insufficient Funds",
					    JOptionPane.ERROR_MESSAGE);
					return;
				}
				moneyfield.setText(df.format(money));
				
				cupsupply.order(Integer.parseInt((String)cupcombo.getSelectedItem()));
				cupamt.setText(Integer.toString(cupsupply.getAmount()));
				
                checkSupplies();
			}
		});
		
		straws.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				money -= strawcalc;
				expenses[sindex] += strawcalc;
				if (money < 0)
				{
					//if not enough money to buy this supply, do
					//not subtract funds and issue an error message
					money += strawcalc;
                    expenses[sindex] -= strawcalc;
					JOptionPane.showMessageDialog(drinkDialog,
					    "Sorry, there are not enough funds to buy more straws.",
					    "Insufficient Funds",
					    JOptionPane.ERROR_MESSAGE);
					return;
				}
				moneyfield.setText(df.format(money));
				strawsupply.order(Integer.parseInt((String)strawcombo.getSelectedItem()));
				strawamt.setText(Integer.toString(strawsupply.getAmount()));
                checkSupplies();
			}
		});
		
		napkins.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				money -= napcalc;
                expenses[sindex] += napcalc;
				if (money < 0)
				{
					//if not enough money to buy this supply, do
					//not subtract funds and issue an error message
					money += napcalc;
                    expenses[sindex] -= napcalc;
					JOptionPane.showMessageDialog(drinkDialog,
					    "Sorry, there are not enough funds to buy more napkins.",
					    "Insufficient Funds",
					    JOptionPane.ERROR_MESSAGE);
					return;
				}
				moneyfield.setText(df.format(money));
				napsupply.order(Integer.parseInt((String)napcombo.getSelectedItem()));
				napamt.setText(Integer.toString(napsupply.getAmount()));
				checkSupplies();
			}
		});
		
		ings.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				money -= ingcalc;
                expenses[sindex] += ingcalc;
				if (money < 0)
				{
					//if not enough money to buy this supply, do
					//not subtract funds and issue an error message
					money += ingcalc;
                    expenses[sindex] -= ingcalc;
					JOptionPane.showMessageDialog(drinkDialog,
					    "Sorry, there are not enough funds to buy more Ingredients.",
					    "Insufficient Funds",
					    JOptionPane.ERROR_MESSAGE);
					return;
				}
				moneyfield.setText(df.format(money));
                ingsupply.order(Integer.parseInt((String)ingcombo.getSelectedItem()));
				ingamt.setText(Integer.toString(ingsupply.getAmount()));
                checkSupplies();
			}
		});

        setSize(getPreferredSize());

	}
	
	/*
	 * Method that creates the tab that holds the menu table
	 */
	public void createMenuTab(JPanel tab)
	{
		tabModel= new DefaultTableModel()
		{
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void setValueAt(Object aValue, int row, int column) 
			{
		        @SuppressWarnings("unchecked")
				Vector<Object> rowVector = (Vector<Object>)dataVector.elementAt(row);
		        rowVector.setElementAt(aValue, column);
		        fireTableCellUpdated(row, column);
		    }

		};
		
		tabModel.addColumn("Product Name");
		tabModel.addColumn("Cost");
		tabModel.addColumn("Sales Price");
		tabModel.addColumn("Profit");
		tabModel.addColumn("Ingredients");
		
		table = new JTable(tabModel)
		{
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column)
			{
				if (column == 2)
		            return true;
		        else
		            return false;
			}
		};

		int cols = table.getColumnCount();
		for (int i = 0; i < cols; i++)
        {
        
        	TableColumn column = table.getColumnModel().getColumn(i);
        	
            if (i == 0)
                column.setPreferredWidth(200); 
            else if (i == 4)
                column.setPreferredWidth(300);
            else 
                column.setPreferredWidth(70);
        }

       tab.add(table.getTableHeader(), BorderLayout.NORTH);
       tab.add(table,BorderLayout.CENTER);
       tab.setMinimumSize(new Dimension(500, 500));

	   tmodel = new MenuTableModel(tabModel);
	   tabModel.addTableModelListener(new MyTableModelListener(tmodel));
		
        i1 = Ingredients.MilkTea; 
        i2 = Ingredients.None; 
        i3 = Ingredients.Tapioca;
        i = new Ingredients[]{i1, i2, i3};
        
        
	}
	
	/*
	 * Method that creates the tab for researching and
	 * creating new drinks
	 */
	public void createResearchTab(JPanel tab)
	{
		//declare components
		JLabel tea;
	    JLabel syrup;
	    JLabel addons;
	    JButton create;
	    JLabel cost1;
	    JLabel cost2;
	    JLabel cost3;
	    JLabel sales;
	    JLabel totalcost1;
	    JLabel totalcost2;
	    JLabel totdolsign;
	    final JTextField teacostfield;
	    final JTextField syrupcostfield;
	    final JTextField addoncostfield;
	    final JTextField totalcostfield;
	    JLabel name;
	    JLabel interlabel;
	    JButton hireteam;
	    JLabel resTitle;
	    JButton generate;
	    
	    //initialize components
        researchLayout customLayout = new researchLayout();

        tab.setFont(new Font("Helvetica", Font.PLAIN, 12));
        tab.setLayout(customLayout);

        tea = new JLabel("Tea");
        tab.add(tea);

        syrup = new JLabel("Syrup");
        tab.add(syrup);

        addons = new JLabel("Add-ons");
        tab.add(addons);

        create = new JButton("Create!");
        create.setFont(new Font("Tahoma", Font.BOLD, 12));
        tab.add(create);

        tea_box = new JComboBox<String>();
        tea_box.addItem("Milk Tea");
        tea_box.addItem("Water");
        tab.add(tea_box);

        syrup_box = new JComboBox<String>();
        syrup_box.addItem("None");
        syrup_box.addItem("Peach");
        syrup_box.addItem("Lychee");
        
        
        tab.add(syrup_box);

        addon_box = new JComboBox<String>();
        addon_box.addItem("Tapioca");
        addon_box.addItem("None");
        tab.add(addon_box);
        
        tea_box.setSelectedItem("Milk Tea");
        syrup_box.setSelectedItem("None");
        addon_box.setSelectedItem("Tapioca");

        drinkname = new TxtField("", 25);
        tab.add(drinkname);

        name = new JLabel("Name Your Drink:");
        tab.add(name);

        interlabel = new JLabel("Interior Designs:");
        tab.add(interlabel);

        hireteam = new JButton("Hire a Research Team");
        hireteam.setFont(new Font("Tahoma", Font.BOLD, 12));
        tab.add(hireteam);

      
        interBox.addItem("Classic");
        interBox.addItem("Trendy");
        tab.add(interBox);
        
        cost1 = new JLabel("Cost:   $");
        tab.add(cost1);
        teacostfield = new JTextField(df.format(tmodel.getInCost().get(i[0])));
        teacostfield.setEditable(false);
        tab.add(teacostfield);
        cost2 = new JLabel("Cost:   $");
        tab.add(cost2);
        syrupcostfield = new JTextField(df.format(tmodel.getInCost().get(i[1])));
        syrupcostfield.setEditable(false);
        tab.add(syrupcostfield);
        cost3 = new JLabel("Cost:   $");
        tab.add(cost3);
        addoncostfield = new JTextField(df.format(tmodel.getInCost().get(i[2])));
        addoncostfield.setEditable(false);
        tab.add(addoncostfield);
        
        totalcost1 = new JLabel("Total Cost to");
        tab.add(totalcost1);
        totalcost2 = new JLabel("Make This Drink:");
        tab.add(totalcost2);
        totalcostfield = new JTextField(df.format(calculateCost(i).doubleValue()));
        totalcostfield.setEditable(false);
        tab.add(totalcostfield);
        
        totdolsign = new JLabel("$");
        tab.add(totdolsign);
        
        resTitle = new JLabel("Create Your Own Drink And Add It To The Menu!");
        tab.add(resTitle);
        
        sales = new JLabel("Sell this Drink for:    $");
        tab.add(sales);
        salesprice = new TxtField("", 5);
        tab.add(salesprice);
        
        generate = new JButton("Auto-Generate");
        tab.add(generate);
        
        JLabel drinkCost = new JLabel("Cost to develop a drink: $");
        tab.add(drinkCost);
        
        drinkCostField = new JTextField(df.format(dCost));
        drinkCostField.setEditable(false);
        tab.add(drinkCostField);
        
        JLabel changeInfer = new JLabel("Modify the Store by Choosing from the Following Interior Designs");
        tab.add(changeInfer);
        
        JLabel hireR1 = new JLabel("Hire a Research Team to Develop New Ingredients or Interior Designs");
        tab.add(hireR1);
        
        
        inter_design2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
        interBox.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                if (interBox.getSelectedIndex() == 0)
                    inter_design2.setIcon(createImageIcon("images/classic_ex.jpg"));
                if (interBox.getSelectedIndex() == 1)
                    inter_design2.setIcon(createImageIcon("images/modern_ex.jpg"));
				if (interBox.getSelectedIndex() == 2)
                    inter_design2.setIcon(createImageIcon("images/space_ex.jpg"));
                if (interBox.getSelectedIndex() == 3)
                    inter_design2.setIcon(createImageIcon("images/hollywood_ex.jpg"));
                if (interBox.getSelectedIndex() == 4)
                {
                	inter_design2.setIcon(createImageIcon("imgaes/jungle_ex.jpg"));
                }
            }
        });
        
        tab.add(inter_design2);
        
        JButton intComfirm = new JButton("Change Design");
        tab.add(intComfirm);
        
        intComfirm.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                interInd = interBox.getSelectedIndex();
                compareInterior();
            }
        });

        //when generate is clicked, a drink name should be placed in the text field
        generate.addActionListener(new ActionListener()
		{
			StringTokenizer st;
			String s;
			public void actionPerformed(ActionEvent e)
			{
				s = "";
							
                st = new StringTokenizer((String)addon_box.getSelectedItem());
                String s2 = st.nextToken();
                if (!s2.equals("None"))
                    s += s2 + " ";
				
				st = new StringTokenizer((String)syrup_box.getSelectedItem());
				String s1 = st.nextToken();
				if (!s1.equals("None"))
					s += s1 + " ";
					
				st = new StringTokenizer((String)tea_box.getSelectedItem());
				String teast = st.nextToken();
				
				if (!teast.equals("Water"))
                    s += teast + " Tea";
                    
				drinkname.setText(s);
			}
		});
        
        //listen for changes in the tea combo box
        tea_box.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String teasel = (String)tea_box.getSelectedItem();
				if (teasel.equals("Water"))
				{
					i[0] = Ingredients.Water;
					i1 = Ingredients.Water;
					teacostfield.setText(df.format(tmodel.getInCost().get(i1)));
					double total = calculateCost(i).doubleValue();
					totalcostfield.setText(df.format(total));
				}
				else if (teasel.equals("Milk Tea"))
				{
					i[0] = Ingredients.MilkTea;
					i1 = Ingredients.MilkTea;
					teacostfield.setText(df.format(tmodel.getInCost().get(i1)));
					double total = calculateCost(i).doubleValue();
					totalcostfield.setText(df.format(total));
				}
				else if (teasel.equals("Black Tea"))
				{
					i[0] = Ingredients.BlackTea;
					i1 = Ingredients.BlackTea;
					teacostfield.setText(df.format(tmodel.getInCost().get(i1)));
					double total = calculateCost(i).doubleValue();
					totalcostfield.setText(df.format(total));
				}
				else if (teasel.equals("Rose Tea"))
				{
					i[0] = Ingredients.RoseTea;
					i1 = Ingredients.RoseTea;
					teacostfield.setText(df.format(tmodel.getInCost().get(i1)));
					double total = calculateCost(i).doubleValue();
					totalcostfield.setText(df.format(total));
				}
				else if (teasel.equals("Green Tea"))
				{
					i[0] = Ingredients.GreenTea;
					i1 = Ingredients.GreenTea;
					teacostfield.setText(df.format(tmodel.getInCost().get(i1)));
					double total = calculateCost(i).doubleValue();
					totalcostfield.setText(df.format(total));
				}
			}
		});
		
		//listen for changes in the syrup combo box
		syrup_box.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String syrupsel = (String)syrup_box.getSelectedItem();
				if (syrupsel.equals("None"))
				{
					i[1] = Ingredients.None;
					i2 = Ingredients.None;
					syrupcostfield.setText(df.format(tmodel.getInCost().get(i2)));
					double total = calculateCost(i).doubleValue();
					totalcostfield.setText(df.format(total));
				}
				else if (syrupsel.equals("Peach"))
				{
					i[1] = Ingredients.Peach;
					i2 = Ingredients.Peach;
					syrupcostfield.setText(df.format(tmodel.getInCost().get(i2)));
					double total = calculateCost(i).doubleValue();
					totalcostfield.setText(df.format(total));
				}
				else if (syrupsel.equals("Lychee"))
				{
					i[1] = Ingredients.Lychee;
					i2 = Ingredients.Lychee;
					syrupcostfield.setText(df.format(tmodel.getInCost().get(i2)));
					double total = calculateCost(i).doubleValue();
					totalcostfield.setText(df.format(total));
				}
				else if (syrupsel.equals("Passion Fruit"))
				{
					i[1] = Ingredients.PassionFruit;
					i2 = Ingredients.PassionFruit;
					syrupcostfield.setText(df.format(tmodel.getInCost().get(i2)));
					double total = calculateCost(i).doubleValue();
					totalcostfield.setText(df.format(total));
				}
				else if (syrupsel.equals("Strawberry"))
				{
					i[1] = Ingredients.Strawberry;
					i2 = Ingredients.Strawberry;
					syrupcostfield.setText(df.format(tmodel.getInCost().get(i2)));
					double total = calculateCost(i).doubleValue();
					totalcostfield.setText(df.format(total));
				}
				else if (syrupsel.equals("Mango"))
				{
					i[1] = Ingredients.Mango;
					i2 = Ingredients.Mango;
					syrupcostfield.setText(df.format(tmodel.getInCost().get(i2)));
					double total = calculateCost(i).doubleValue();
					totalcostfield.setText(df.format(total));
				}
				else if (syrupsel.equals("Apple"))
				{
					i[1] = Ingredients.Apple;
					i2 = Ingredients.Apple;
					syrupcostfield.setText(df.format(tmodel.getInCost().get(i2)));
					double total = calculateCost(i).doubleValue();
					totalcostfield.setText(df.format(total));
				}
				else if (syrupsel.equals("Coffee"))
				{
					i[1] = Ingredients.Coffee;
					i2 = Ingredients.Coffee;
					syrupcostfield.setText(df.format(tmodel.getInCost().get(i2)));
					double total = calculateCost(i).doubleValue();
					totalcostfield.setText(df.format(total));
				}
				else if (syrupsel.equals("Lemon"))
				{
					i[1] = Ingredients.Lemon;
					i2 = Ingredients.Lemon;
					syrupcostfield.setText(df.format(tmodel.getInCost().get(i2)));
					double total = calculateCost(i).doubleValue();
					totalcostfield.setText(df.format(total));
				}
			}
		});
		
		//listen for changes in the addon combo box
		addon_box.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String addonsel = (String)addon_box.getSelectedItem();
				if (addonsel.equals("None"))
				{
					i[2] = Ingredients.None;
					i3 = Ingredients.None;
					addoncostfield.setText(df.format(tmodel.getInCost().get(i3)));
					double total = calculateCost(i).doubleValue();
					totalcostfield.setText(df.format(total));
				}
				else if (addonsel.equals("Tapioca"))
				{
					i[2] = Ingredients.Tapioca;
					i3 = Ingredients.Tapioca;
					addoncostfield.setText(df.format(tmodel.getInCost().get(i3)));
					double total = calculateCost(i).doubleValue();
					totalcostfield.setText(df.format(total));
				}
				else if (addonsel.equals("Aloe"))
				{
					i[2] = Ingredients.Aloe;
					i3 = Ingredients.Aloe;
					addoncostfield.setText(df.format(tmodel.getInCost().get(i3)));
					double total = calculateCost(i).doubleValue();
					totalcostfield.setText(df.format(total));
				}
				else if (addonsel.equals("Jelly"))
				{
					i[2] = Ingredients.Jelly;
					i3 = Ingredients.Jelly;
					addoncostfield.setText(df.format(tmodel.getInCost().get(i3)));
					double total = calculateCost(i).doubleValue();
					totalcostfield.setText(df.format(total));
				}
				else if (addonsel.equals("Lychee Coconut"))
				{
					i[2] = Ingredients.Lychee;
					i3 = Ingredients.Lychee;
					addoncostfield.setText(df.format(tmodel.getInCost().get(i3)));
					double total = calculateCost(i).doubleValue();
					totalcostfield.setText(df.format(total));
				}
			}
		});
		
        
        //create the drink and add it to the menu
        create.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
                             
				Ingredients[] i = {i1,i2,i3};
				
				calculateCost(i).doubleValue();
				
				//display error messages if drink cannot be created yet
				if (drinkname.getText().trim().equals("") || drinkname.getText() == null)
				{
					
					JOptionPane.showMessageDialog(drinkDialog,
					    "This drink does not have a name",
					    "Drink Creation Failed",
					    JOptionPane.ERROR_MESSAGE);

				}
			    else if (salesprice.getText().trim().equals("") || salesprice.getText() == null)
			    {
			        JOptionPane.showMessageDialog(drinkDialog,
			            "This drink does not have a sale price",
			            "Drink Creation Failed",
			            JOptionPane.ERROR_MESSAGE);
			    }
				else
				{
					checkAddProduct(i, drinkname, salesprice);
				}					
				
			}
		});
		
		hireteam.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (isRes == true)
				{
					JOptionPane.showMessageDialog(hire,
                        "Sorry, please wait until current research is finished.",
                        "Hiring Error",
                        JOptionPane.ERROR_MESSAGE);
                        return;
				}
				hd.pack();
        		hd.setLocationRelativeTo(app);
        		hd.setVisible(true);
			}
		});

        setSize(getPreferredSize());
	}
	
	//Creates the promotion tab
	public void createPromotionTab(JPanel tab)
	{
        promoteLayout customLayout = new promoteLayout();
        
        //setup all the promotion components
        
        tab.setFont(new Font("Helvetica", Font.PLAIN, 12));
        tab.setLayout(customLayout);
	   
        new JLabel("Flyers will be posted around your neighborhood");
        new JLabel("for 7 days in a cost of $20.00");
        
        JButton flyerButton = new JButton("Buy Flyers for $20.00");
        flyerButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        tab.add(flyerButton);
        
        new JLabel("Coupons will be given to customers ");
        new JLabel("after each purchase for 7 days in a cost of $50.00");
        
        JButton couponButton = new JButton("Buy Coupons for $50.00");
        couponButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        tab.add(couponButton);
        
        new JLabel("Your store's advertisements will appear ");
        new JLabel("in popular magazines for 7 days in a cost of $100.00");

        JButton adButton = new JButton("Buy Magazine Ads for $100.00");
        adButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        tab.add(adButton);
        
        new JLabel("Your store will appear in TV commercials");
        new JLabel("for 7 days in a cost of $300.00");
        
        JButton comButton = new JButton("Buy TV Commercials for $300.00");
        comButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        tab.add(comButton);
        
        JLabel pageTitle = new JLabel("Choose from the following promotion " +
        	"plans to increase the popularity of your store."); 
        JLabel pageTitle2 = new JLabel("Roll over each purchase plan for a description.");
        tab.add(pageTitle);
        tab.add(pageTitle2);
        
        desc1 = new JLabel("");
        desc2 = new JLabel("");
        
        new JLabel("");
        
        tab.add(desc1);
        tab.add(desc2);
        
        //Flyer button purchase
        flyerButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                
                if (money < 80)
                {
                	//if not enough money to purchase flyers, do
                    //not subtract funds and issue an error message
                    JOptionPane.showMessageDialog(drinkDialog,
                        "This Promotion Plan Requires a Fund Surplus of at least $80",
                        "Promotion Plan Purchase Failed",
                        JOptionPane.ERROR_MESSAGE);
                        return;
                }
                money -= 20;
                expenses[sindex] += 20;
                moneyfield.setText(df.format(money));
                    
                JOptionPane.showMessageDialog(drinkDialog,
                        "Thank you for buying the flyers promotion plan.",
                        "Promotion Plan Purchased",
                        JOptionPane.PLAIN_MESSAGE);    
                            
                min_cus = min_cus * 1.2f;
                max_cus = max_cus * 1.2f;
                diff_cus = max_cus - min_cus;
                flyer_flag = d + 7;    
                
                try
				{
			            doc.insertString(doc.getLength(), "Flyer Promotion Period Has Started.\n", events.getStyle("Black"));
					sp_events.getVerticalScrollBar().getModel().setValue(
					sp_events.getVerticalScrollBar().getModel().getMaximum());
				}
				catch (BadLocationException exc)
				{
					System.out.println("Bad Loc Exc");
				}
            }
        });
        
        flyerButton.addMouseListener(new MouseListener()
	    {
	    	public void mouseEntered(MouseEvent e)
	    	{
	    		desc1.setText("Flyers will be posted around your neighborhood");
	    		desc2.setText("for 7 days for a cost of $20.00");
	    	}    	
	    	public void mouseExited(MouseEvent e)
	    	{
	    		desc1.setText("");
	    		desc2.setText("");
	    	}
	    	public void mouseClicked(MouseEvent e)
	    	{
	    	}
	    	public void mousePressed(MouseEvent e)
	    	{
	    	}
	    	public void mouseReleased(MouseEvent e)
	    	{
	    	}

	    });
        
        //Coupon button purchase
        couponButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                
                if (money < 100)
                {
                    //if not enough money to purchase coupons, do
                    //not subtract funds and issue an error message
                    JOptionPane.showMessageDialog(drinkDialog,
                        "This Promotion Plan Requires a Fund Surplus of at least $100",
                        "Promotion Plan Purchase Failed",
                        JOptionPane.ERROR_MESSAGE);
                        return;
                }
                money -= 50;
                expenses[sindex] += 50;
                moneyfield.setText(df.format(money));
                    
                JOptionPane.showMessageDialog(drinkDialog,
                        "Thank you for buying the coupon promotion plan.",
                        "Promotion Plan Purchased",
                        JOptionPane.PLAIN_MESSAGE);    
                            
                min_cus = min_cus * 1.5f;
                max_cus = max_cus * 1.5f;
                diff_cus = max_cus - min_cus;
                coupon_flag = d + 7; 
                
                try
				{
			            doc.insertString(doc.getLength(), "Coupon Promotion Period Has Started.\n", events.getStyle("Black"));
					sp_events.getVerticalScrollBar().getModel().setValue(
					sp_events.getVerticalScrollBar().getModel().getMaximum());
				}
				catch (BadLocationException exc)
				{
					System.out.println("Bad Loc Exc");
				}   
            }
        });
        
        couponButton.addMouseListener(new MouseListener()
	    {
	    	public void mouseEntered(MouseEvent e)
	    	{
	    		desc1.setText("Coupons will be given to customers");
	    		desc2.setText("after each purchase for 7 days for a cost of $50.00");
	    	}    	
	    	public void mouseExited(MouseEvent e)
	    	{
	    		desc1.setText("");
	    		desc2.setText("");
	    	}
	    	public void mouseClicked(MouseEvent e)
	    	{
	    	}
	    	public void mousePressed(MouseEvent e)
	    	{
	    	}
	    	public void mouseReleased(MouseEvent e)
	    	{
	    	}

	    });
        
        //magazine ad button purchase
        adButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                
                if (money < 200)
                {
                    //if not enough money to purchase ads, do
                    //not subtract funds and issue an error message
                    JOptionPane.showMessageDialog(drinkDialog,
                        "This Promotion Plan Requires a Fund Surplus of at least $200",
                        "Promotion Plan Purchase Failed",
                        JOptionPane.ERROR_MESSAGE);
                        return;
                }
                money -= 100;
                expenses[sindex] += 100;
                moneyfield.setText(df.format(money));
                    
                 JOptionPane.showMessageDialog(drinkDialog,
                        "Thank you for buying the magazine promotion plan.",
                        "Promotion Plan Purchased",
                        JOptionPane.PLAIN_MESSAGE);
                            
                min_cus = min_cus * 1.75f;
                max_cus = max_cus * 1.75f;
                diff_cus = max_cus - min_cus;
                magazine_flag = d + 7;
                
                try
				{
			            doc.insertString(doc.getLength(), "Magazine Promotion Period Has Started.\n", events.getStyle("Black"));
					sp_events.getVerticalScrollBar().getModel().setValue(
					sp_events.getVerticalScrollBar().getModel().getMaximum());
				}
				catch (BadLocationException exc)
				{
					System.out.println("Bad Loc Exc");
				}
            }
        });
        
        adButton.addMouseListener(new MouseListener()
	    {
	    	public void mouseEntered(MouseEvent e)
	    	{
	    		desc1.setText("Your store's advertisements will appear");
	    		desc2.setText("in popular magazines for 7 days for a cost of $100.00");
	    	}    	
	    	public void mouseExited(MouseEvent e)
	    	{
	    		desc1.setText("");
	    		desc2.setText("");
	    	}
	    	public void mouseClicked(MouseEvent e)
	    	{
	    	}
	    	public void mousePressed(MouseEvent e)
	    	{
	    	}
	    	public void mouseReleased(MouseEvent e)
	    	{
	    	}

	    });
        
        //TV commercial button purchase
        comButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                
                if (money < 500)
                {
                    //if not enough money to purchase commercial, do
                    //not subtract funds and issue an error message
                    JOptionPane.showMessageDialog(drinkDialog,
                        "This Promotion Plan Requires a Fund Surplus of at least $500",
                        "Promotion Plan Purchase Failed",
                        JOptionPane.ERROR_MESSAGE);
                        return;
                }
                money -= 300;
                expenses[sindex] += 300;
                moneyfield.setText(df.format(money));
                    
                JOptionPane.showMessageDialog(drinkDialog,
                        "Thank you for buying the TV commercial promotion plan.",
                        "Promotion Plan Purchased",
                        JOptionPane.PLAIN_MESSAGE);    
                            
                min_cus = min_cus * 2;
                max_cus = max_cus * 2;
                diff_cus = max_cus - min_cus;
                tv_flag = d + 7;
                
                try
				{
			            doc.insertString(doc.getLength(), "Television Promotion Period Has Started.\n", events.getStyle("Black"));
					sp_events.getVerticalScrollBar().getModel().setValue(
					sp_events.getVerticalScrollBar().getModel().getMaximum());
				}
				catch (BadLocationException exc)
				{
					System.out.println("Bad Loc Exc");
				} 
            }
        });
        
        comButton.addMouseListener(new MouseListener()
	    {
	    	public void mouseEntered(MouseEvent e)
	    	{
	    		desc1.setText("Your store will appear in a TV commercial");
	    		desc2.setText("for 7 days for a cost of $300.00");
	    	}    	
	    	public void mouseExited(MouseEvent e)
	    	{
	    		desc1.setText("");
	    		desc2.setText("");
	    	}
	    	public void mouseClicked(MouseEvent e)
	    	{
	    	}
	    	public void mousePressed(MouseEvent e)
	    	{
	    	}
	    	public void mouseReleased(MouseEvent e)
	    	{
	    	}

	    });
	}
	
	//Check if a promotion plan expires.
	// Number of customers is slightly reduced after each promotion period ends.
	public void checkPromotionEnd (int current_day)
	{
	   if (flyer_flag == current_day)
	   {
			min_cus = min_cus * 0.95f;
			max_cus = max_cus * 0.95f;
			flyer_flag = -1;
	           	try
			{
		            doc.insertString(doc.getLength(), "Flyer Promotion Period Has Ended.\n", events.getStyle("Black"));
				sp_events.getVerticalScrollBar().getModel().setValue(
				sp_events.getVerticalScrollBar().getModel().getMaximum());
			}
			catch (BadLocationException exc)
			{
				System.out.println("Bad Loc Exc");
			}
	   }
	   if (coupon_flag == current_day)
	   {
			min_cus = min_cus * 0.9f;
			max_cus = max_cus * 0.9f;
			coupon_flag = -1;
			try
			{
				doc.insertString(doc.getLength(), "Coupon Promotion Period Has Ended.\n", events.getStyle("Black"));
				sp_events.getVerticalScrollBar().getModel().setValue(
				sp_events.getVerticalScrollBar().getModel().getMaximum());
			}
			catch (BadLocationException exc)
			{
				System.out.println("Bad Loc Exc");
			}
	   }
	   if (magazine_flag == current_day)
	   {
			min_cus = min_cus * 0.95f;
			max_cus = max_cus * 0.95f;
			magazine_flag = -1;
			try
			{
		        doc.insertString(doc.getLength(), "Magazine Promotion Period Has Ended.\n", events.getStyle("Black"));
				sp_events.getVerticalScrollBar().getModel().setValue(
				sp_events.getVerticalScrollBar().getModel().getMaximum());
			}
			catch (BadLocationException exc)
			{
				System.out.println("Bad Loc Exc");
			}
	   }
	   if (tv_flag == current_day)
	   {
			min_cus = min_cus * 0.85f;
			max_cus = max_cus * 0.85f;
			tv_flag = -1;
			try
			{
		            doc.insertString(doc.getLength(), "Television Promotion Period Has Ended.\n", events.getStyle("Black"));
				sp_events.getVerticalScrollBar().getModel().setValue(
				sp_events.getVerticalScrollBar().getModel().getMaximum());
			}
			catch (BadLocationException exc)
			{
				System.out.println("Bad Loc Exc");
			}
	   }
       	   diff_cus = max_cus - min_cus;
	}
	
	//Method that begins the research for the specified item on a timer
	public static void startResearch(final String res1, final int days1, 
		final boolean isIng1, final int box1)
	{
		res = res1;
		resdays = days1;
		isIng = isIng1;
		box = box1;
		
		doc = (StyledDocument)events.getDocument();
		style = doc.addStyle("Red", null);
		style4 = doc.addStyle("Green", null);
		style2 = doc.addStyle("Black", null);
		StyleConstants.setForeground(style, Color.red);
		StyleConstants.setForeground(style4, Color.green);
		StyleConstants.setForeground(style2, Color.black);
		isRes = true;
		
		int delay = 60000*resdays;
		tRes = new Timer(delay, new tResListener());
		tRes.setRepeats(false);
		tRes.start(); 


		
		String startres = "Team hired to research ";
		String startres2 = ". Days remaining: ";
		
		try
		{
			doc.insertString(doc.getLength(), startres, events.getStyle("Black"));
			doc.insertString(doc.getLength(), res, events.getStyle("Green"));
	            doc.insertString(doc.getLength(), startres2, events.getStyle("Black"));
	            doc.insertString(doc.getLength(), Long.toString(resdays), events.getStyle("Green"));
	            doc.insertString(doc.getLength(), "\n", events.getStyle("Black"));
			sp_events.getVerticalScrollBar().getModel().setValue(
			sp_events.getVerticalScrollBar().getModel().getMaximum());
		}
		catch (BadLocationException exc)
		{
			System.out.println("Bad Loc Exc");
		}
	}	
	
	public void itemStateChanged(ItemEvent evt) 
	{
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
    }
	
	
	private void equalSizes(JComponent[] components)
	{
		int width = 0;
		int height = 0;
		for (int i = 0; i < components.length; i++)
		{
		  Dimension d = components[i].getPreferredSize();
		  width = Math.max(width, d.width);
		  height = Math.max(height, d.height);
		}
		Dimension dimension = new Dimension(width, height);
		for (int i = 0; i < components.length; i++)
		{
		  components[i].setMaximumSize(dimension);
		}
	}

	/* Calculate and return the cost of a list of Ingredients */
    private Double calculateCost(Ingredients[] raw)
    {
        /* Include the cost of straw, napkin and cup */
        Double c_cost = new Double(0.0); 
        c_cost += 0.07;
        
        for (int i = 0; i < raw.length; i++){
        	if (raw[i] != null)
            	c_cost += tmodel.getInCost().get(raw[i]);
        }
        return new Double(df.format(c_cost));
    }
    
    protected void updatePicture(JLabel pic, String fname) {
        //Get the icon corresponding to the image.
        ImageIcon icon = createImageIcon(
                                    "images/" + fname);
        pic.setIcon(icon);
        pic.setToolTipText(fname);
        if (icon == null) {
            pic.setText("Missing Image");
        } else {
            pic.setText(null);
        }
    }

    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = TapiocaKing.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
	
	 
	
  	
  	//Keep track of the goals and check if the player reached the intended goal.
  	private void checkGoal (int current_date)
  	{
  		if (goal1flag == false)
  		{
  			goal1flag = true;
  			goals[0] += money;
  		}
  		
  	    if (current_date < 21)
  	    {
  	        goalField.setText("Have more than $" + 
  	        	df.format(goals[0]) + " by the end of Day 20.");
  	    }
  	    else if (current_date == 21)
  	    {
  	        if (money >= goals[0])
  	        {
  	        	if (goal2flag == false)
		  		{
		  			goal2flag = true;
		  			goals[1] += money;
		  		}
                JOptionPane.showMessageDialog(drinkDialog,
                        "Congratulations! You have reached the goal!\n"+
                            "Your next goal is to have more than $" + 
                            df.format(goals[1]) + " by the end of Day 30.",
                        "Goal Reached",
                        JOptionPane.INFORMATION_MESSAGE);
                goalField.setText("Have more than $" + 
                	df.format(goals[1]) + " by the end of Day 30.");
  	        }
  	        else 
  	        {
                JOptionPane.showMessageDialog(drinkDialog,
                        "Since you have not reached the goal, your business failed.\n "+
                            "Try again!",
                        "Game Over",
                        JOptionPane.ERROR_MESSAGE);
                    initNewGame();    
  	        }
            
  	    }
  	    else if ((current_date > 20) && (current_date < 31))
  	    {
  	    	
            goalField.setText("Have more than $" + 
            	df.format(goals[1]) + " by the end of Day 30.");
  	    }
  	    else if (current_date == 31)
  	    {
            if (money >= goals[1])
            {
                JOptionPane.showMessageDialog(drinkDialog,
                        "Congratulations! You have reached the goal!\n"+
                            "Your next goal is to have at least 10 " + 
                            "drinks on menu by the end of Day 40.",
                        "Goal Reached",
                        JOptionPane.INFORMATION_MESSAGE);
                goalField.setText("Have at least 10 drinks on menu by the end of Day 40.");
            }
            else 
            {
                JOptionPane.showMessageDialog(drinkDialog,
                        "Since you have not reached the goal, your business failed.\n "+
                            "Try again!",
                        "Game Over",
                        JOptionPane.ERROR_MESSAGE);
                initNewGame(); 
            }
  	    }
        else if ((current_date > 30) && (current_date < 41)){
            goalField.setText("Have at least 10 drinks on menu by the end of Day 40.");
        }
        else if (current_date == 41)
        {
            if (table.getRowCount() > 9)
            {
            	if (goal3flag == false)
		  		{
		  			goal3flag = true;
		  			goals[2] += money;
		  		}
                JOptionPane.showMessageDialog(drinkDialog,
                        "Congratulations! You have reached the goal!\n"+
                            "Your next goal is to have more than $" +
                            df.format(goals[2]) + " by the end of Day 50.",
                        "Goal Reached",
                        JOptionPane.INFORMATION_MESSAGE);
                goalField.setText("Have more than $" + 
                	df.format(goals[2]) + " by the end of Day 50.");
            }
            else 
            {
                JOptionPane.showMessageDialog(drinkDialog,
                        "Since you have not reached the goal, your business failed.\n "+
                            "Try again!",
                        "Game Over",
                        JOptionPane.ERROR_MESSAGE);
                initNewGame();
            }
        }
        else if ((current_date >40) && (current_date < 51))
        {
            goalField.setText("Have more than $" + 
            	df.format(goals[2]) + " by the end of Day 50.");
        }
        else if (current_date == 51)
        {
            if (money >= goals[2])
            {
            	if (goal4flag == false)
		  		{
		  			goal4flag = true;
		  			goals[3] += money;
		  		}
                JOptionPane.showMessageDialog(drinkDialog,
                        "Congratulations! You have reached the goal!\n"+
                            "Your next goal is to have more than $" + 
                            df.format(goals[3]) + " by the end of Day 60.",
                        "Goal Reached",
                        JOptionPane.INFORMATION_MESSAGE);
                goalField.setText("Have more than $" + df.format(goals[3]) + " by the end of Day 60.");
            }
            else 
            {
                JOptionPane.showMessageDialog(drinkDialog,
                        "Since you have not reached the goal, your business failed.\n "+
                            "Try again!",
                        "Game Over",
                        JOptionPane.ERROR_MESSAGE);
                initNewGame();
            }
        }
        else if ((current_date >50) && (current_date < 61))
        {
            goalField.setText("Have more than $" + df.format(goals[3]) + " by the end of Day 60.");
        }
        else if (current_date == 61)
        {
            if (money >= goals[3])
            {
                JOptionPane.showMessageDialog(drinkDialog,
                        "Congratulations! You have reached all the goals and finished the game!\n"+
                            "You are the true Tapioca King!",
                        "Goal Reached",
                        JOptionPane.INFORMATION_MESSAGE);
                goalField.setText("You have completed all the goals.");
            }
            else 
            {
                JOptionPane.showMessageDialog(drinkDialog,
                        "Since you have not reached the goal, your business failed.\n "+
                            "Try again!",
                        "Game Over",
                        JOptionPane.ERROR_MESSAGE);
                initNewGame();
            }
        }
  	}
  	
  	private void generateDailySales()
  	{
        
        //generate number of customers
        temp_cus = cus_gen.nextInt(Math.round(diff_cus)+1);
        cus_current = Math.round(temp_cus + min_cus);
        
        //divide the customers throughout the day to stagger purchases
        double dubtime = 60000/cus_current;
        Double dub = new Double(dubtime);
        int custtime = dub.intValue();
        
        //Start bringing in customers
        tCusts = new Timer(custtime, new tCustsListener());
		tCusts.setInitialDelay(custtime);
		tCusts.start(); 


        
 	}
  	
  	private void setupTimers()
  	{
		//setup the day counting timer
		//increments the day each iteration
		
        tDate = new Timer(60000, new tDateListener());
		tDate.setInitialDelay(0);
		tDate.start();
				
				
		//create a color style for the text area
		doc = (StyledDocument)events.getDocument();
		style = doc.addStyle("Blue", null);
		style2 = doc.addStyle("Black", null);
		style3 = doc.addStyle("Red", null);
		style4 = doc.addStyle("Green", null);
		StyleConstants.setForeground(style, Color.blue);
		StyleConstants.setForeground(style2, Color.black);
		StyleConstants.setForeground(style3, Color.red);
		StyleConstants.setForeground(style4, Color.green);
		
		//print intial message into the events box
		try
		{	
			doc.insertString(doc.getLength(), storenm, events.getStyle("Blue"));
			doc.insertString(doc.getLength(), " is open for business.\n", events.getStyle("Green"));
			doc.insertString(doc.getLength(), 
				"Start Creating Your Menu!\n", events.getStyle("Black"));
		}
		catch (BadLocationException exc)
		{
			System.out.println("Bad Loc Exc");
		}
		
		//move the scroll bar to the top
	    sp_events.getVerticalScrollBar().setValue(0);
		
		
		//setup a timer to check how the store is doing
		//with money and supplies  
        t1 = new Timer(15011, new t1Listener());
		t1.setInitialDelay(15011);
		t1.start(); 

        
        //timer that generates random events 
        //display the random events in the specified interval
        int daymult = 1*60000;
        tRandEvents = new Timer(63030, new tRandEventsListener());
		tRandEvents.setInitialDelay(daymult);
		tRandEvents.start(); 


  	}
  	
  	//Method That Makes a Purchase for Each customer 
  	private boolean purchaseDrink(int o)
  	{
  	    
  		boolean flag = true;
  	    
        if (cupsupply.getAmount() < 1) 
        {
        	if (supout1 == true)
        	{
	            try
	            {
	                walks[sindex] += 1;
		            doc.insertString(doc.getLength(), 
		            	"Alert: There aren't enough cups to make another drink!\n", 
		            	events.getStyle("Red"));
		            	sp_events.getVerticalScrollBar().getModel().setValue(
			sp_events.getVerticalScrollBar().getModel().getMaximum());
	                store_cups.setIcon(createImageIcon("images/store_cup_broke.jpg"));
				}
				catch (BadLocationException e)
				{
					System.out.println("Insert Doc Error in Purchase Drink");
				}
				
				supout1 = false;
			}
			
			flag = false;
        }
        else if (napsupply.getAmount() < 2) 
        {
        	if (supout2 == true)
        	{
	            try
	            {
	                walks[sindex] += 1;
		            doc.insertString(doc.getLength(), 
		            	"Alert: There aren't enough napkins to make another drink!\n", 
		            	events.getStyle("Red"));
		            	sp_events.getVerticalScrollBar().getModel().setValue(
			sp_events.getVerticalScrollBar().getModel().getMaximum());
	                store_napkin.setIcon(createImageIcon("images/store_napkin_broke.jpg"));
				}
				catch (BadLocationException e)
				{
					System.out.println("Insert Doc Error in Purchase Drink");
				}
				
				supout2 = false;
			}
			
			flag = false;
        }
        else if (strawsupply.getAmount() < 1) 
        {
        	if (supout3 == true)
        	{
	            try
	            {
                    walks[sindex] += 1;
		            doc.insertString(doc.getLength(), 
		            	"Alert: There aren't enough straws to make another drink!\n", 
		            	events.getStyle("Red"));
		            	sp_events.getVerticalScrollBar().getModel().setValue(
			sp_events.getVerticalScrollBar().getModel().getMaximum());
	                store_straw.setIcon(createImageIcon("images/store_straw_broke.jpg"));
				}
				catch (BadLocationException e)
				{
					System.out.println("Insert Doc Error in Purchase Drink");
				}
				
				supout3 = false;
			}
			
			flag = false;
        }
        else 
        {    
        	if (cupsupply.getAmount() >= 1) 
        	{
        		supout1 = true;	
        	}
        	if (strawsupply.getAmount() >= 1) 
        	{
        		supout2 = true;	
        	}
        	if (napsupply.getAmount() >= 2) 
        	{
        		supout3 = true;	
        	}
        	
        
            Products order = tmodel.getDrinks().get(o);
            Ingredients [] order_list = order.getIngredients();
            int t = order_list.length;
            if (ingsupply.getAmount() < t) 
  	    	{
  	    		if (supout4 == true)
  	    		{
		            try
		            {
                        walks[sindex] += 1;
		            	String msg = "Alert: There aren't enough ingredients to make another drink!\n";
			            doc.insertString(doc.getLength(), msg, events.getStyle("Red"));
			            sp_events.getVerticalScrollBar().getModel().setValue(
			sp_events.getVerticalScrollBar().getModel().getMaximum());
			            store_ing.setIcon(createImageIcon("images/store_ing_broke.jpg"));
						
					}
					catch (BadLocationException e)
					{
						System.out.println("Insert Doc Error in Purchase Drink");
					}
					
					supout4 = false;
				}
					
				return false;			
  	    	}
  	    	else
  	    	{
        		supout4 = true;	
  	    	}
            
      	    money += order.getPrice();
            dsold[sindex] += 1;
      	    revenue[sindex] += order.getPrice();
      	    moneyfield.setText(df.format(money));  
      	    
      	    
      	    ingsupply.used(t);
      	    cupsupply.used(1);
      	    napsupply.used(2);
      	    strawsupply.used(1);
      	    
            cupamt.setText(Integer.toString(cupsupply.getAmount()));
            strawamt.setText(Integer.toString(strawsupply.getAmount()));
            napamt.setText(Integer.toString(napsupply.getAmount()));
            ingamt.setText(Integer.toString(ingsupply.getAmount()));
            
            checkSupplies();
            
        
        }
        sp_events.getVerticalScrollBar().getModel().setValue(
			sp_events.getVerticalScrollBar().getModel().getMaximum());
		
		return flag;
  	}
  	
  	//Perform error checking on the drink created and add it to the menu table if it passed all the tests.
  	private void checkAddProduct(Ingredients[] i, TxtField drinkname, TxtField salesprice)
  	{
  		Double s = null;
                    
	    //display more error messages
	    try
	    {
	        s = Double.parseDouble(salesprice.getText());
	    }
	    catch(Exception ex){
	        JOptionPane.showMessageDialog(drinkDialog,
	        "Sale price must be a numeric value",
	        "Drink Creation Failed",
	        JOptionPane.ERROR_MESSAGE);
	        return;
	    }
	    
		p = new Products(drinkname.getText(), s, i, tmodel);
		if (tmodel.noIngs(p) == 1)
		{
			JOptionPane.showMessageDialog(drinkDialog,
		    "A drink must have ingredients",
		    "Drink Creation Failed",
		    JOptionPane.ERROR_MESSAGE);
		    return;
		}
		else if (tmodel.noIngs(p) == 2)
		{
			JOptionPane.showMessageDialog(drinkDialog,
		    "A drink cannot only have add-ons",
		    "Drink Creation Failed",
		    JOptionPane.ERROR_MESSAGE);
		    return;
		}
		else if (tmodel.ingsExist(p))
		{
			JOptionPane.showMessageDialog(drinkDialog,
		    "A drink with these ingredients already exists",
		    "Drink Creation Failed",
		    JOptionPane.ERROR_MESSAGE);
		    return;
		}
		else if (tmodel.drinkExists(p))
		{
			JOptionPane.showMessageDialog(drinkDialog,
		    "A drink with this name has already been added",
		    "Drink Creation Failed",
		    JOptionPane.ERROR_MESSAGE);
		    return;
		}
		else
		{
			money -= dCost;
            expenses[sindex] += dCost;
	        if (money < 0)
	        {
	            //if not enough money to buy this supply, do
	            //not subtract funds and issue an error message
	            money += dCost;
	            expenses[sindex] -= dCost;
	            JOptionPane.showMessageDialog(drinkDialog,
	                "Insufficient funds for creating a new drink",
	                "Drink Creation Failed",
	                JOptionPane.ERROR_MESSAGE);
	            return;
	        }
	        
	        //Adding a drink to table model.
			tmodel.addDrink(p);
			max_cus += 1;
			min_cus += 1;
			diff_cus = max_cus - min_cus;
			
			drinkname.setText("");
			salesprice.setText("");
			
			JOptionPane.showMessageDialog(drinkDialog,
		    "A new product has been added to the menu",
		    "Success", JOptionPane.INFORMATION_MESSAGE);
		    tmodel.printDrinks();

		    
	        moneyfield.setText(df.format(money));
	        
	        //Update the cost for creating the next new drink.
	        if (table.getRowCount() == 0)
	        	dCost = 0.0;
	        else if (table.getRowCount() < 3)
	            dCost = 10.0;
	        else if (table.getRowCount() < 5)
	            dCost = 20.0;
	        else if (table.getRowCount() < 10)
	            dCost = 50.0;
	        drinkCostField.setText(df.format(dCost));
	        
	        // Ingredient set cost updated
	        updateIngSetCost();
		}
  	}
  	
  	//Pick out random events to display in events box
  	private String generateEvents(int pick)
  	{
  	    String str = "";
        switch (pick)
        {
            case 0:
            	if (money >= 100)
                {
	                str = "The store's fridge " +
	                "went down and needs maintenance! -$50\n";
	                money -= 50;
                    expenses[sindex] += 50;
	                moneyfield.setText(df.format(money));
	                
	                store_fridge.setIcon(createImageIcon("images/store_fridge_broke.jpg"));
	                brokeFridge = d+1;
	            }
                break;
            case 1:
                str = "An employee has quit! -5 customers\n";
                min_cus -= 5;
                max_cus -= 5;
                diff_cus = max_cus - min_cus;
                

				tCustDown = new Timer(120000, new tCustDownListener());
				tCustDown.setRepeats(false);
				tCustDown.setInitialDelay(120000);
				tCustDown.start(); 

                if (min_cus <= 1)
                	min_cus = 1;
                if (max_cus <= 1)
                	max_cus = 1;
                diff_cus = max_cus - min_cus;
                break;
            case 2:
            	if (money >= 100)
                {
	                str = "The store's blender broke! -$50\n";
	                money -= 75;
                    expenses[sindex] += 75;
	                moneyfield.setText(df.format(money));
	                store_blender.setIcon(createImageIcon("images/store_blender_broke.jpg"));
	                brokeBlend = d + 1;
	            }
                break;
            case 3:
            	if (ingsupply.getAmount() >= 85)
                {
	                str = "Some ingredients became spoiled! -20 Ingredients\n";
                    ingsupply.used(20);
                    ingamt.setText(Integer.toString(ingsupply.getAmount()));
                }
                break;
            case 4:
            	if (money >= 150)
                {
	                str = "There was an earthquake! -$100\n";
	                money -= 100;
                    expenses[sindex] += 100;
	                moneyfield.setText(df.format(money));
	            }
                break;
            case 5:
            	if (money >= 150)
                {
	                str = "A burgler broke into the store and stole $100!\n";
	                money -= 100;
                    expenses[sindex] += 100;
	                moneyfield.setText(df.format(money));
	            }
                break;
            case 6:
                str = "A rival tapioca store presented a new product! -5 customers\n";
                min_cus -= 5;
                max_cus -= 5;
                diff_cus = max_cus - min_cus;

				tCustDown = new Timer(120000, new tCustDownListener());
				tCustDown.setRepeats(false);
				tCustDown.setInitialDelay(120000);
				tCustDown.start(); 

                if (min_cus <= 1)
                    min_cus = 1;
                if (max_cus <= 1)
                    max_cus = 1;
                    
                diff_cus = max_cus - min_cus;
                break;
            case 7:
            	if (money >= 100)
                {
	                str = "Some punks vandalized the store! -$50\n";
	                money -= 50;
                    expenses[sindex] += 50;
	                moneyfield.setText(df.format(money));
	            }
                break;
            case 8:
                str = "An employee has fallen ill and is in the " +
                    "hospital temporarily! -5 customers\n";
                min_cus -= 5;
                max_cus -= 5;
                
                diff_cus = max_cus - min_cus;

				tCustDown = new Timer(120000, new tCustDownListener());
				tCustDown.setRepeats(false);
				tCustDown.setInitialDelay(120000);
				tCustDown.start(); 

                if (min_cus <= 1)
                    min_cus = 1;
                if (max_cus <= 1)
                    max_cus = 1;
                    
                diff_cus = max_cus - min_cus;
                break;
            case 9:
                if (money >= 50)
                {
	                str = "An employee dropped some drinks! -$2\n";
	                money -= 2;
                    expenses[sindex] += 2;
	                moneyfield.setText(df.format(money));
	            }
                break;
            case 10:
                str = "Ingredients became cheaper! +$50\n";
                money += 50;
                revenueE[sindex] += 50;
                moneyfield.setText(df.format(money));
                break;
            case 11:
                str = "Rent is lowered! +$100\n";
                money += 100;
                revenueE[sindex] += 100;
                moneyfield.setText(df.format(money));
                break;
            case 12:
                str = "You catered the drinks for a company party! +$100\n";
                money += 100;
                revenueE[sindex] += 100;
                moneyfield.setText(df.format(money));
                break;
            case 13:
                str = "You hired a new employee! +3 customers\n";
                max_cus += 3;
                min_cus += 3;
                tCustUp = new Timer(120000, new tCustUpListener());
				tCustUp.setRepeats(false);
				tCustUp.setInitialDelay(120000);
				tCustUp.start(); 
                diff_cus = max_cus - min_cus;
                break;
            case 14:
                str = "A hit magazine picked your store as one of the Top 10 stores in the city! +3 customers\n";
                max_cus += 3;
                min_cus += 3;
                tCustUp = new Timer(120000, new tCustUpListener());
				tCustUp.setRepeats(false);
				tCustUp.setInitialDelay(120000);
				tCustUp.start(); 
                diff_cus = max_cus - min_cus;
                break;
            case 15:
                str = "A new department store is opened near your store! +3 customers\n";
                max_cus += 3;
                min_cus += 3;
                tCustUp = new Timer(120000, new tCustUpListener());
				tCustUp.setRepeats(false);
				tCustUp.setInitialDelay(120000);
				tCustUp.start(); 
                diff_cus = max_cus - min_cus;
                break;
            case 16:
                str = "A baseball team just finished a game and came to your store to buy drinks! +$30\n";
                money += 30;
                revenueE[sindex] += 30;
                moneyfield.setText(df.format(money));
                break;
            case 17:
                str = "Today is such a hot day! People are thirsty! +5 customers\n";
                max_cus += 5;
                min_cus += 5;
                tCustUp = new Timer(120000, new tCustUpListener());
                tCustUp.setRepeats(false);
                tCustUp.setInitialDelay(120000);
                tCustUp.start(); 
                diff_cus = max_cus - min_cus;
                break;
            case 18:
                str = "Today is freezing! People don't want cold drinks. -5 customers\n";
                max_cus -= 5;
                min_cus -= 5;
                diff_cus = max_cus - min_cus;
                tCustDown = new Timer(120000, new tCustDownListener());
                tCustDown.setRepeats(false);
                tCustDown.setInitialDelay(120000);
                tCustDown.start(); 
                
                if (min_cus <= 1)
                    min_cus = 1;
                if (max_cus <= 1)
                    max_cus = 1;
                diff_cus = max_cus - min_cus;
                break;
                
                
        }
        return str;
  	}
  	
  	//Calculate the cost of 1 set of Ingredients. 
  	//The total cost of a set is depended on the Ingredients that are used in the menu table.
  	private double calculateIngSetCost()
  	{
  		
     int item_loop = tmodel.getDrinks().size();
     
        double item_cost = 0;
        
        for (int e = 0; e < item_loop; e++)
        {
        	  double temp = 0;
              Ingredients [] temp_ing = tmodel.getDrinks().get(e).getIngredients();
              int list_loop = temp_ing.length;

              divisor = temp_ing.length-1;
              
              if (divisor == 0)
              {
              	divisor = 1;
              }
              
              for(int s = 0; s < list_loop; s++)
              {
                  temp += tmodel.getInCost().get(temp_ing[s]);
              }
              if (temp > item_cost)
              {
                  item_cost = temp;
              }
        }
        
        if (item_cost > 0)
        {
        	ings.setEnabled(true);
        }
        
        return item_cost;
  	}
  	
  	//Update the Ingredient supply cost in the Supplies tab.
  	private void updateIngSetCost() {
         ingcalc = calculateIngSetCost() * (Double.parseDouble((String)ingcombo.getSelectedItem())/divisor);
         costField4.setText(df.format(ingcalc));
  	}
  	
  	//Print out message in events box that the sales price for drinks is too expensive.
  	// i.e. Profit > $5.00
  	private void printWalkOut(String name)
  	{
  	    walks[sindex] += 1;
        try
        {
            String walk = "A customer walked out because ";
            walk += name + " was too expensive!\n";
            doc.insertString(doc.getLength(), 
                walk, 
                events.getStyle("Red"));
        }
        catch (BadLocationException e)
        {
            System.out.println("Bad Loc Exceptiom In prices too high");
        }
        sp_events.getVerticalScrollBar().getModel().setValue(
			sp_events.getVerticalScrollBar().getModel().getMaximum());
  	}
  	
  	
  	/*
  	 *  Swing timer class for the message box strings
  	 *
  	 */
  	private class t1Listener implements ActionListener 
  	{
	    public void actionPerformed(ActionEvent e) 
	    {

	    	if (money >= 50)
            	{
	            	String str;
	            	boolean flag = true;
	            	//set message according to supplies needed
	            	if (cupsupply.getAmount() + napsupply.getAmount() + strawsupply.getAmount() + ingsupply.getAmount() == 0)
	            	    str = "Warning: The store is out of supplies.\n";
	            	else if (cupsupply.getAmount() + strawsupply.getAmount() + napsupply.getAmount() == 0)
	            	    str = "Warning: The store is out of cups, straws and napkins.\n";
	            	else if (cupsupply.getAmount() + strawsupply.getAmount() + ingsupply.getAmount() == 0)
                        str = "Warning: The store is out of cups, straws and ingredients.\n";
	            	else if (cupsupply.getAmount() + napsupply.getAmount() + ingsupply.getAmount() == 0)
                        str = "Warning: The store is out of cups, napkins and ingredients.\n";
	            	else if (strawsupply.getAmount() + napsupply.getAmount() + ingsupply.getAmount() == 0)
                        str = "Warning: The store is out of straws, napkins and ingredients.\n";
	            	else if (cupsupply.getAmount() + strawsupply.getAmount() == 0)
	            	    str = "Warning: The store is out of cups and straws.\n";
	            	else if (cupsupply.getAmount() + napsupply.getAmount() == 0)
	            	    str = "Warning: The store is out of cups and napkins.\n";
	            	else if (cupsupply.getAmount() + ingsupply.getAmount() == 0)
	            	    str = "Warning: The store is out of cups and ingredients.\n";
	            	else if (strawsupply.getAmount() + napsupply.getAmount() == 0)
	            	    str = "Warning: The store is out of straws and napkins.\n"; 
	            	else if (strawsupply.getAmount() + ingsupply.getAmount() == 0)
                        str = "Warning: The store is out of straws and ingredients.\n";
	            	else if (napsupply.getAmount() + ingsupply.getAmount() == 0)
                        str = "Warning: The store is out of napkins and ingredients.\n";   
	            	else if (cupsupply.getAmount() == 0)
	            	    str = "Warning: The store is out of cups.\n";
	            	else if (napsupply.getAmount()== 0)
                        str = "Warning: The store is out of napkins.\n";
	            	else if (strawsupply.getAmount() == 0)
                        str = "Warning: The store is out of straws.\n";
	            	else if (ingsupply.getAmount() == 0)
                        str = "Warning: The store is out of ingredients.\n";
	            	else
	            	{		
	            		flag = false;            	
	            	    str = " is doing fine.\n";
	            	}
	            	
	            	//set the text in the events box, move the scroll bar
	            	//to the bottom
	            	try
	            	{
		            	if (flag == true)
		            	{
		            		doc.insertString(doc.getLength(), str, events.getStyle("Black"));
		            		sp_events.getVerticalScrollBar().getModel().setValue(
								sp_events.getVerticalScrollBar().getModel().getMaximum());
		            	}
		            	else
		            	{
		            		doc.insertString(doc.getLength(), storenm, events.getStyle("Blue")); 
		            		doc.insertString(doc.getLength(), str, events.getStyle("Black"));
		            		sp_events.getVerticalScrollBar().getModel().setValue(
								sp_events.getVerticalScrollBar().getModel().getMaximum());
		            	}
		            }
		            catch (BadLocationException exc)
		            {
		            	System.out.println("Bad Loc Exc");
		            }
	            	
	            	
	            }
	            else if (money < 50)
	            {
	            	//set the text in the events box if the store is low on funds
	            	String str = "Warning: " + storenm + " is low on money.\n";
	            	try
	            	{
	            		doc.insertString(doc.getLength(), str, events.getStyle("Black"));
	            		sp_events.getVerticalScrollBar().getModel().setValue(
							sp_events.getVerticalScrollBar().getModel().getMaximum());
	            	}
	            	catch (BadLocationException exc)
		            {
		            	System.out.println("Bad Loc Exc");
		            }
	            	
	            }
	    }	    	    
  	}
  	
  	private void checkSupplies()
  	{
  	    if (cupsupply.getAmount() < 5)
            store_cups.setIcon(createImageIcon("images/store_cup_broke.jpg"));
        else
            store_cups.setIcon(createImageIcon("images/store_cup_work.jpg"));
        
        if (ingsupply.getAmount() < 5)
            store_ing.setIcon(createImageIcon("images/store_ing_broke.jpg"));
        else
            store_ing.setIcon(createImageIcon("images/store_ing_work.jpg"));
            
        if (strawsupply.getAmount() < 5)
            store_straw.setIcon(createImageIcon("images/store_straw_broke.jpg"));
        else
            store_straw.setIcon(createImageIcon("images/store_straw_work.jpg"));
        
        if (napsupply.getAmount() < 5)
            store_napkin.setIcon(createImageIcon("images/store_napkin_broke.jpg"));
        else
            store_napkin.setIcon(createImageIcon("images/store_napkin_work.jpg"));
  	}
  	
  	/* Find out the choice of uniform from user and reset the store graphics */
    private void compareUniform()
    {
        if (uniform == 0)
            store_staff.setIcon(createImageIcon("images/store_staff_red.jpg"));
        if (uniform == 2)
            store_staff.setIcon(createImageIcon("images/store_staff_blue.jpg"));
        if (uniform == 1)
            store_staff.setIcon(createImageIcon("images/store_staff_green.jpg"));
    }
    
    private void compareIntPreview()
    {
        if (interInd == 0)
            inter_design2.setIcon(createImageIcon("images/classic_ex.jpg"));
        if (interInd == 1)
            inter_design2.setIcon(createImageIcon("images/modern_ex.jpg"));
    }
    
    private void compareInterior()
    {
        if (interInd == 0)
        {
            store_ceiling.setIcon(createImageIcon("images/store_classic_ceiling.jpg"));
            store_table1.setIcon(createImageIcon("images/store_ctable1_empty.jpg"));
            store_table2.setIcon(createImageIcon("images/store_ctable2_empty.jpg"));
            store_table3.setIcon(createImageIcon("images/store_ctable3_empty.jpg"));
            store_counter1.setIcon(createImageIcon("images/store_ccounter1.jpg"));
            store_counter2.setIcon(createImageIcon("images/store_ccounter2.jpg"));
            store_counter3.setIcon(createImageIcon("images/store_ccounter3a.jpg"));
            store_customers.setIcon(createImageIcon("images/store_customer_ori.jpg"));
            store_money.setIcon(createImageIcon("images/store_money_classic.jpg"));
            store_rack.setIcon(createImageIcon("images/store_rack_classic.jpg"));
        }
        else if (interInd == 1)
        {
            store_ceiling.setIcon(createImageIcon("images/store_modern_ceiling.jpg"));
            store_table1.setIcon(createImageIcon("images/store_mtable1_empty.jpg"));
            store_table2.setIcon(createImageIcon("images/store_mtable2_empty.jpg"));
            store_table3.setIcon(createImageIcon("images/store_mtable3_empty.jpg"));
            store_counter1.setIcon(createImageIcon("images/store_mcounter1.jpg"));
            store_counter2.setIcon(createImageIcon("images/store_mcounter2.jpg"));
            store_counter3.setIcon(createImageIcon("images/store_mcounter3.jpg"));
            store_customers.setIcon(createImageIcon("images/store_customer_modern.jpg"));
            store_money.setIcon(createImageIcon("images/store_money_modern.jpg"));
            store_rack.setIcon(createImageIcon("images/store_rack_modern.jpg"));

        }
        else if (interInd == 2)
        {
        	if (spaceflag == false)
			{
				spaceflag = true;
				min_cus += 5;
				max_cus += 5;
				diff_cus = max_cus - min_cus;
			}
            store_ceiling.setIcon(createImageIcon("images/store_space_ceiling.jpg"));
            store_table1.setIcon(createImageIcon("images/store_mtable1_empty.jpg"));
            store_table2.setIcon(createImageIcon("images/store_stable2_empty.jpg"));
            store_table3.setIcon(createImageIcon("images/store_mtable3_empty.jpg"));
            store_counter1.setIcon(createImageIcon("images/store_scounter1.jpg"));
            store_counter2.setIcon(createImageIcon("images/store_scounter2.jpg"));
            store_counter3.setIcon(createImageIcon("images/store_scounter3.jpg"));
            store_customers.setIcon(createImageIcon("images/store_customer_space.jpg"));
            store_money.setIcon(createImageIcon("images/store_money_space.jpg"));
            store_rack.setIcon(createImageIcon("images/store_rack_space.jpg"));
        }
        else if (interInd == 3)
        {
            if (hollyflag == false)
            {
                hollyflag = true;
                min_cus += 7;
                max_cus += 7;
                diff_cus = max_cus - min_cus;
            }
            store_ceiling.setIcon(createImageIcon("images/store_hollywood_ceiling.jpg"));
            store_table1.setIcon(createImageIcon("images/store_htable1_empty.jpg"));
            store_table2.setIcon(createImageIcon("images/store_htable2_empty.jpg"));
            store_table3.setIcon(createImageIcon("images/store_htable3_empty.jpg"));
            store_counter1.setIcon(createImageIcon("images/store_hcounter1.jpg"));
            store_counter2.setIcon(createImageIcon("images/store_hcounter2.jpg"));
            store_counter3.setIcon(createImageIcon("images/store_hcounter3.jpg"));
            store_customers.setIcon(createImageIcon("images/store_customer_ori.jpg"));
            store_money.setIcon(createImageIcon("images/store_money_hollywood.jpg"));
            store_rack.setIcon(createImageIcon("images/store_rack_hollywood.jpg"));
        }
        else if (interInd == 4)
        {
        	if (jungleflag == false)
            {
                jungleflag = true;
                min_cus += 10;
                max_cus += 10;
                diff_cus = max_cus - min_cus;
            }
            store_ceiling.setIcon(createImageIcon("images/store_jungle_ceiling.jpg"));
            store_table1.setIcon(createImageIcon("images/store_jtable1_empty.jpg"));
            store_table2.setIcon(createImageIcon("images/store_jtable2_empty.jpg"));
            store_table3.setIcon(createImageIcon("images/store_jtable3_empty.jpg"));
            store_counter1.setIcon(createImageIcon("images/store_jcounter1.jpg"));
            store_counter2.setIcon(createImageIcon("images/store_jcounter2.jpg"));
            store_counter3.setIcon(createImageIcon("images/store_jcounter3.jpg"));
            store_customers.setIcon(createImageIcon("images/store_customer_ori.jpg"));
            store_money.setIcon(createImageIcon("images/store_money_jungle.jpg"));
            store_rack.setIcon(createImageIcon("images/store_rack_jungle.jpg"));
        }
    }
    
    /*
     * This class creates a dialog that
     * shows a jtable of statistics
     * over the past 7 days
     *
     */
    private class Summary extends JDialog
    {
    
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private JPanel dpanel;
    	private JPanel sub;
        
        DecimalFormat df = new DecimalFormat("###0.00");
        JButton ok;
        JLabel sumtitle;
        JTable sumtable;
        JLabel totprof;
        
        public Summary(Frame aFrame, String title) 
        {
            super(aFrame, title, true);
            
            setDefaultCloseOperation(
			    JDialog.DO_NOTHING_ON_CLOSE);
			addWindowListener(new WindowAdapter() {
			    public void windowClosing(WindowEvent we) {
			        System.out.println("Cannot Close, Press OK");
			    }
			});

            //pause game
	    	tDate.stop();
			t1.stop();
			if (tRandEvents != null)
				tRandEvents.stop();
			if (tCusts != null)
				tCusts.stop();
			if (tCustDown != null)
				tCustDown.stop();
			if (tCustUp != null)
				tCustUp.stop();

			if (tCountdown != null)
				tCountdown.stop();

            setPreferredSize(new Dimension(700, 320));
            
            
            dpanel = new JPanel();
            dpanel.setLayout(new BorderLayout());
            
            sub = new JPanel();
            sub.setLayout(new BoxLayout(sub, BoxLayout.PAGE_AXIS));
            dpanel.add(sub, BorderLayout.CENTER);
            
            add(dpanel);
            
            
            sumtitle = new JLabel("This Week's Business Summary");
            sumtitle.setHorizontalAlignment((int)CENTER_ALIGNMENT);
            dpanel.add(sumtitle, BorderLayout.NORTH);
            
            //Generate strings for the last 7 days
            String day1 = "Day " + Integer.toString(d-7);
            String day2 = "Day " + Integer.toString(d-6);
            String day3 = "Day " + Integer.toString(d-5);
            String day4 = "Day " + Integer.toString(d-4);
            String day5 = "Day " + Integer.toString(d-3);
            String day6 = "Day " + Integer.toString(d-2);
            String day7 = "Day " + Integer.toString(d-1);
            
            String[] columnNames = {" ", day1, day2, day3, 
                day4, day5, day6, day7};
            
            Object[][] data = {
                {"Customers Served", custom[0], custom[1], custom[2],
                    custom[3], custom[4], custom[5], custom[6]},
                {"Customers Lost", walks[0], walks[1], walks[2], walks[3],
                    walks[4], walks[5], walks[6]},
                {"Number of Drinks Sold", dsold[0], dsold[1], dsold[2],
                    dsold[3], dsold[4], dsold[5], dsold[6]},
                {"Expenses", "$" + df.format(expenses[0]),
                    "$" + df.format(expenses[1]),
                    "$" + df.format(expenses[2]), "$" + df.format(expenses[3]), 
                    "$" + df.format(expenses[4]), "$" + df.format(expenses[5]), 
                    "$" + df.format(expenses[6])},
                {"Revenue from Events", "$" + df.format(revenueE[0]),
                    "$" + df.format(revenueE[1]),
                    "$" + df.format(revenueE[2]), "$" + df.format(revenueE[3]), 
                    "$" + df.format(revenueE[4]), "$" + df.format(revenueE[5]), 
                    "$" + df.format(revenueE[6])},
                {"Revenue from Sales", "$" + df.format(revenue[0]),
                    "$" + df.format(revenue[1]),
                    "$" + df.format(revenue[2]), "$" + df.format(revenue[3]), 
                    "$" + df.format(revenue[4]), "$" + df.format(revenue[5]),
                    "$" + df.format(revenue[6])},
                {"Total Profits", "$" + df.format(tprofit[0]),
                    "$" + df.format(tprofit[1]),
                    "$" + df.format(tprofit[2]), "$" + df.format(tprofit[3]), 
                    "$" + df.format(tprofit[4]), "$" + df.format(tprofit[5]),
                    "$" + df.format(tprofit[6])}
            };
            
            sumtable = new JTable(data, columnNames);
            
            TableColumn column = sumtable.getColumnModel().getColumn(0);
            
            column.setPreferredWidth(150); 
                
            JScrollPane sp = new JScrollPane(sumtable);
            sp.setPreferredSize(new Dimension(500, 300));
            
            sub.add(sp, BorderLayout.CENTER);
            
            double weekprofit = tprofit[0] + tprofit[1] + tprofit[2]
            	+ tprofit[3] + tprofit[4] + tprofit[5] + tprofit[6];  
            String totprofst = "Total Profits for the Whole Week: $" 
            	+ df.format(weekprofit);
            totprof=  new JLabel(totprofst);
            sub.add(totprof, BorderLayout.SOUTH);
            sub.add(Box.createRigidArea(new Dimension(10,50)));
            
            ok = new JButton("OK");
            
            ok.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                	//unpause game
                    t1.start();
                    tDate.start();
					if (tRandEvents != null)
						tRandEvents.start();
					if (tCusts != null)
						tCusts.start();
					if (tCustDown != null)
						tCustDown.start();
					if (tCustUp != null)
						tCustUp.start();
					if (tCountdown != null)
						tCountdown.start();
						
                    setVisible(false);
                }
            });
            ok.setPreferredSize(new Dimension(50, 30));
            dpanel.add(ok, BorderLayout.SOUTH);
        }
        
    }
    
  	
  	/*
  	 *  Swing timer class for the day timer
  	 *
  	 */
  	private class tDateListener implements ActionListener 
  	{
	    public void actionPerformed(ActionEvent e) 
	    {
	    	sindex++;
	    	if (sindex != 0)
	    	{
		    	tprofit[sindex-1] = (revenue[sindex-1] 
	                + revenueE[sindex-1])
	                - expenses[sindex-1];
            }
	    	if (sindex >6)
            {
                sindex = 0;
            }
            
			d++;
			
			
				
            if ((((d-1) %7) == 0) && d != 1)
            {
                Summary sum = new Summary(app, "Weekly Summary");
                sum.pack();
                sum.setLocationRelativeTo(app);
                sum.setVisible(true);
                
                for (int i = 0; i < 7; i++)
                {
                    custom[i] = 0;
                    walks[i] = 0;
                    revenue[i] = 0.0;
                    expenses[i] = 0.0;
                    dsold[i] = 0;
                }
            }
            
            
            	
	        checkPromotionEnd(d);
	        date.setText(""+d);
	        checkGoal(d);
	        
	        if (brokeFridge == d)
	        {
	           store_fridge.setIcon(createImageIcon("images/store_fridge_work.jpg"));
	           brokeFridge = -1;
	        }
	        if (brokeBlend ==d)
	        {
	           store_blender.setIcon(createImageIcon("images/store_blender_work.jpg"));
	           brokeBlend = -1;
	        }
	        
	        if (tCusts != null)
	        {
	        	tCusts.stop();
	        }
	        	        	
	        generateDailySales();
            				        
	        //display a dialog when the timer reaches the first
	        //goal. If the goal was reached, display a success
	        //message, otherwise, the game ends.
	        if (d == 30)
	        {
	        	if (money == 500)
	        	{
	        		JOptionPane.showMessageDialog(drinkDialog,
		    		"You've reached a goal!" +
		    		"\nYour store is off to a good start, Keep it up!",
		    		"Goal Attained",
		    		JOptionPane.INFORMATION_MESSAGE);
	        	}
	        }
		}
	}
	
	/*
  	 *  Swing timer class for the research timer
  	 *
  	 */
	private static class tResListener implements ActionListener 
  	{
	    public void actionPerformed(ActionEvent e) 
	    {
	    	isRes = false;
	        JOptionPane.showMessageDialog(resDone,
            "Research of " + res + " completed!",
            "Research Complete",
            JOptionPane.INFORMATION_MESSAGE);
            
            tRes.stop();
            
            if (isIng)
            {
            	if (box == 1)
            	{
            		tea_box.addItem(res);
            	}
            	else if (box == 2)
            	{
            		syrup_box.addItem(res);
            	}
            	else if (box == 3)
            	{
            		addon_box.addItem(res);
            	}
            }
            else
            {
                interBox.addItem(res);
            	listModel_interior.addElement(res);
            	inter.setModel(listModel_interior);
            }
		}
	}
	
	@SuppressWarnings("unused")
	private static class tCountdownListener implements ActionListener 
  	{
	    public void actionPerformed(ActionEvent e) 
	    {
	    	dayCount += .5;
			
			float daysrem = resdays-dayCount;
			if (daysrem >= 0)
			{
				String countmsg = "Researching ";
				String countmsg2 = "... Days remaining: ";
				
				try
				{	
					doc.insertString(doc.getLength(), countmsg, events.getStyle("Black"));
					doc.insertString(doc.getLength(), res, events.getStyle("Green"));
			        doc.insertString(doc.getLength(), countmsg2, events.getStyle("Black"));
			        doc.insertString(doc.getLength(), Float.toString(daysrem), events.getStyle("Green"));
			        doc.insertString(doc.getLength(), "\n", events.getStyle("Black"));
					sp_events.getVerticalScrollBar().getModel().setValue(
						sp_events.getVerticalScrollBar().getModel().getMaximum());
			            		
				}
				catch (BadLocationException exc)
				{
					System.out.println("Bad Loc Exc");
				}
			}
			
			if (dayCount == resdays)
			{
			    dayCount = 0;
				tCountdown.stop();
			}
		}
	}
	
	private class tRandEventsListener implements ActionListener 
  	{
	    public void actionPerformed(ActionEvent e) 
	    {
	    	if (money >= 100)
        	{
            	int eventNum = eventgen.nextInt(19);
            	
            	//Generate Events through random number
            	String str = generateEvents(eventNum);
            	
            	try
            	{
            		doc.insertString(doc.getLength(), str, events.getStyle("Red"));
            		sp_events.getVerticalScrollBar().getModel().setValue(
							sp_events.getVerticalScrollBar().getModel().getMaximum());
            		
            	}
            	catch (BadLocationException exc)
	            {
	            	System.out.println("Bad Loc Exc");
	            }
	        }
		}
	}
	
	private class tCustDownListener implements ActionListener 
  	{
	    public void actionPerformed(ActionEvent e) 
	    {
	    	min_cus += 5;
			max_cus += 5;
			diff_cus = max_cus - min_cus;
			tCustDown.stop();
		}
	}
	
	private class tCustUpListener implements ActionListener 
  	{
	    public void actionPerformed(ActionEvent e) 
	    {
	    	min_cus -= 3;
			max_cus -= 3;
			diff_cus = max_cus - min_cus;
			tCustUp.stop();
		}
	}
	
	private class tCustsListener implements ActionListener 
  	{
	    public void actionPerformed(ActionEvent e) 
	    {
	    	boolean flag = true;
    		int decision = 0;
    		if (table.getRowCount() > 0)
    		{
    		    // Generate the number of drinks a transaction contains
    		    int temp_num = item_gen.nextInt(3) + 1;
    		    for(int z = 0; z < temp_num; z++)
    		    {
    		    	flag = true;
    		        //Generate which drink the customer would buy from the menu.
                    temp_order = drink_gen.nextInt(table.getRowCount()) + 1;
                    
                    int o = temp_order-1;
                    Products order = tmodel.getDrinks().get(o);
                    Ingredients[] order_ings = order.getIngredients();
                    
                    if (order_ings[0] != Ingredients.Water &&
                    	order_ings[1] != Ingredients.None && 
                    	order_ings[2] != Ingredients.None)
                    {
                    
                        //A customer would not buy a drink if the drink is too expensive.
                        //PRICES GENERATED FOR ALL 3 INGREDIENTS USED
                        if (order.getProfit() <= 5.10)
                        {
                            boughtflag = purchaseDrink(o);
                        }
                        else if (order.getProfit() <= 6.10)
                        {
                        	//customer will buy 1 out of 2 times
                        	decision = decide.nextInt(2);
                        	if (decision == 0)
                        	{
                            	printWalkOut(order.getName());
                            	flag = false;
                            }
                            else
                            	boughtflag = purchaseDrink(o);	
                        }
                        else if (order.getProfit() <= 6.50)
                        {
                        	//customer will buy 1 out of 3 times
                        	decision = decide.nextInt(3);
                        	if (decision == 0 || decision == 1)
                            {
                            	printWalkOut(order.getName());
                            	flag = false;
                            }
                            else
                            	boughtflag = purchaseDrink(o);	
                        }
                        else if (order.getProfit() <= 7.00)
                        {
                        	//customer will buy 1 out of 5 times
                        	decision = decide.nextInt(5);
                        	if (decision == 0 || decision == 1
                        		|| decision == 2 || decision == 3)
                            {
                            	printWalkOut(order.getName());
                            	flag = false;
                            }
                            else
                            	boughtflag = purchaseDrink(o);	
                        }
                        else
                        {
                        	{
                            	printWalkOut(order.getName());
                            	flag = false;
                            }
                        }
                    }
                    else if ((order_ings[0] != Ingredients.Water &&
                    	order_ings[1] != Ingredients.None) ||
                    	(order_ings[0] != Ingredients.Water &&
                    	order_ings[2] != Ingredients.None) || 
                    	(order_ings[1] != Ingredients.None &&
                    	order_ings[2] != Ingredients.None))
                    {
                    
                        //A customer would not buy a drink if the drink is too expensive.
                        //PRICES GENERATED FOR 2 INGREDIENTS USED
                        if (order.getProfit() <= 3.10)
                        {
                            boughtflag = purchaseDrink(o);
                        }
                        else if (order.getProfit() <= 4.10)
                        {
                        	//customer will buy 1 out of 2 times
                        	decision = decide.nextInt(2);
                        	if (decision == 0)
                        	{
                            	printWalkOut(order.getName());
                            	flag = false;
                            }
                            else
                            	boughtflag = purchaseDrink(o);	
                        }
                        else if (order.getProfit() <= 5.00)
                        {
                        	//customer will buy 1 out of 3 times
                        	decision = decide.nextInt(3);
                        	if (decision == 0 || decision == 1)
                            {
                            	printWalkOut(order.getName());
                            	flag = false;
                            }
                            else
                            	boughtflag = purchaseDrink(o);	
                        }
                        else if (order.getProfit() <= 5.50)
                        {
                        	//customer will buy 1 out of 5 times
                        	decision = decide.nextInt(5);
                        	if (decision == 0 || decision == 1
                        		|| decision == 2 || decision == 3)
                            {
                            	printWalkOut(order.getName());
                            	flag = false;
                            }
                            else
                            	boughtflag = purchaseDrink(o);	
                        }
                        else
                        {
                        	{
                            	printWalkOut(order.getName());
                            	flag = false;
                            }
                        }
                    }
                    else if (order_ings[0] != Ingredients.Water || 
                    	order_ings[1] != Ingredients.None ||
                    	order_ings[2] != Ingredients.None)
                    {
                    
                        //A customer would not buy a drink if the drink is too expensive.
                        //PRICES GENERATED FOR 1 INGREDIENT USED
                        if (order.getProfit() <= 2.10)
                        {
                            boughtflag = purchaseDrink(o);
                        }
                        else if (order.getProfit() <= 3.10)
                        {
                        	//customer will buy 1 out of 2 times
                        	decision = decide.nextInt(2);
                        	if (decision == 0)
                        	{
                            	printWalkOut(order.getName());
                            	flag = false;
                            }
                            else
                            	boughtflag = purchaseDrink(o);	
                        }
                        else if (order.getProfit() <= 4.00)
                        {
                        	//customer will buy 1 out of 3 times
                        	decision = decide.nextInt(3);
                        	if (decision == 0 || decision == 1)
                            {
                            	printWalkOut(order.getName());
                            	flag = false;
                            }
                            else
                            	boughtflag = purchaseDrink(o);	
                        }
                        else if (order.getProfit() <= 4.50)
                        {
                        	//customer will buy 1 out of 5 times
                        	decision = decide.nextInt(5);
                        	if (decision == 0 || decision == 1
                        		|| decision == 2 || decision == 3)
                            {
                            	printWalkOut(order.getName());;
                            	flag = false;
                            }
                            else
                            	boughtflag = purchaseDrink(o);	
                        }
                        else
                        {
                        	{
                            	printWalkOut(order.getName());
                            	flag = false;
                            }
                        }
                        
                    }
                    else if (order_ings[0] == Ingredients.Water && 
                    	order_ings[1] == Ingredients.None &&
                    	order_ings[2] == Ingredients.None)
                    {
                    
                        //A customer would not buy a drink if the drink is too expensive.
                        //PRICES GENERATED FOR JUST WATER
                        if (order.getProfit() > 0.07)
                        {
                        	printWalkOut(order.getName());
                            flag = false;
                        }
                        else
                        {
                        	purchaseDrink(o);
                        	custom[sindex] += 1;
                        	String boughtStr = "";

				      	    if (temp_num <= 1)
				      	    	boughtStr = "A customer bought water.\n";
				      	    else
				      	    {
				      	    	boughtStr = "A customer bought " + temp_num + " waters\n";
				      	    }
				      	    
				      	    try
				            {
					            doc.insertString(doc.getLength(), boughtStr, events.getStyle("Green"));
							}
							catch (BadLocationException exc)
							{
								System.out.println("Insert Doc Error in Purchase Drink");
							}
		    				sp_events.getVerticalScrollBar().getModel().setValue(
								sp_events.getVerticalScrollBar().getModel().getMaximum());
                        }
                        
                    }

    		    }
    		    
    		    //print message if a customer bought a drink
    		    if (flag == true && boughtflag == true)
    		    {
    		    	if (fxflag)
					{
						if (cashsong != null)
							cashsong.play();
					}
					
        		    String boughtStr = "";
                    custom[sindex] += 1;
		      	    if (temp_num <= 1)
		      	    	boughtStr = "A customer bought a drink!\n";
		      	    else
		      	    {
		      	    	boughtStr = "A customer bought " + temp_num + " drinks!\n";
		      	    }
		      	    
		      	    try
		            {
			            doc.insertString(doc.getLength(), boughtStr, events.getStyle("Green"));
					}
					catch (BadLocationException exc)
					{
						System.out.println("Insert Doc Error in Purchase Drink");
					}
    				sp_events.getVerticalScrollBar().getModel().setValue(
						sp_events.getVerticalScrollBar().getModel().getMaximum());
				}
        		            
	        }
		}
	}
	
	/*
	 * Main method that starts the Application version
	 *
	 */
	public static void main(String args []) 
	{

    	app = new Frame("Tapioca King");  
   	    app.setSize(750, 650);                         //set Frame: width, height

    	app.addWindowListener(      //Register an anonymous class as a listener.
        	new WindowAdapter() 
        	{
            	public void windowClosing(WindowEvent e) 
            	{  
            		
            		if (song != null)
            			song.stop();
            		if (song2 != null)
            			song2.stop();
            		if (song3 != null)
            			song3.stop();
            			

               		System.exit( 0 );
            	}
         	}
    	);
    	
    	try 
		{  
    		UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel" ); 
    		//UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel" ); 
		} 
		catch(Exception e) 
		{
			System.out.println(e);
		} 

    	final TapiocaKing applet = new TapiocaKing();         //create the applet.
    	applet.init();                                //initialize applet.
    	applet.start();                               //start applet.

    	app.add( applet, BorderLayout.CENTER );       //add applet to center of frame.
    	app.setVisible( true );                    //Make frame visible.

  	}
  	
  	//Applet method that is called when applet starts
  	public void start()
	{
		System.out.println("Tapioca King starting...");
	}
	
	//Applet method that is called when applet stops
	public void stop()
	{
		if (song != null)
			song.stop();
		if (song2 != null)
			song2.stop();
		if (song3 != null)
			song3.stop();
		if (cashsong != null)
			cashsong.stop();
		
		System.out.println("Applet stopping.");
	}
	
	//Applet method that is called when applet is destroyed
	public void destroy()
	{
		if (song != null)
			song.stop();
		if (song2 != null)
			song2.stop();
		if (song3 != null)
			song3.stop();
		if (cashsong != null)
			cashsong.stop();
		
		System.out.println("Destroy method called.");
	}
   
	public void actionPerformed(ActionEvent e)
	{
		
	}
}
