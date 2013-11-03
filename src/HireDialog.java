import javax.swing.JOptionPane;
import javax.swing.JDialog;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

/*
 * Class HireDialog creates the Hire Dialog
 * Window that pops up when the hire button
 * is pressed. This dialog allows the user 
 * to select a category to research and 
 * will start researching.
 *
 */
class HireDialog extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel dpanel;

	DecimalFormat df = new DecimalFormat("###0.00");
	JFrame hireDialog = new JFrame();
	ButtonGroup cbg;
	JRadioButton teaRad;
	JRadioButton interior;
	JButton hire;
	JButton cancel;
	JRadioButton int4;
	JLabel intLabel;
	JTextField teaBox;
	JLabel price;
	JLabel resTime;
	JTextField costfield;
	JTextField timefield;
	JTextField syrupBox;
	JTextField addBox;
	JRadioButton syrupRad;
	JRadioButton addRad;
	JRadioButton noneSelected;
	JLabel daysLabel;
	String indChoice = "";
	JLabel title1;
	JLabel title2;

	String resChoice = "";

	// tells if item researched is an ingredient or interior
	boolean isIng = true;

	// tells which combo box is researched
	// 0 = interior
	// 1 = tea
	// 2 = syrup
	// 3 = addon
	int box = 0;

	String[] tealist = { "Black Tea", "Rose Tea", "Green Tea" };

	int tind = 0;

	String[] syrlist = { "Apple", "Lemon", "PassionFruit", "Strawberry",
			"Mango", "Coffee" };

	static int sind = 0;

	String[] addlist = { "Aloe", "Jelly", "LycheeCoconut" };

	static int aind = 0;

	String[] intlist = { "Space", "Hollywood", "Jungle" };

	static int iind = 0;

	/** Creates the reusable dialog. */
	public HireDialog(Frame aFrame, String title) {
		super(aFrame, title, true);
		// setLocation(200,200);
		setPreferredSize(new Dimension(325, 375));

		dpanel = new JPanel();

		add(dpanel);

		HireDialogLayout customLayout = new HireDialogLayout();

		dpanel.setFont(new Font("Helvetica", Font.PLAIN, 12));
		dpanel.setLayout(customLayout);

		cbg = new ButtonGroup();
		teaRad = new JRadioButton("Tea", false);
		cbg.add(teaRad);
		dpanel.add(teaRad);

		hire = new JButton("Hire");
		dpanel.add(hire);

		cancel = new JButton("Cancel");
		dpanel.add(cancel);

		intLabel = new JLabel(" - or - ");
		dpanel.add(intLabel);

		interior = new JRadioButton("Interiors", false);
		cbg.add(interior);
		dpanel.add(interior);

		price = new JLabel("Hire Cost:    $");
		dpanel.add(price);

		resTime = new JLabel("Research Duration");
		dpanel.add(resTime);

		costfield = new JTextField("");
		costfield.setEditable(false);
		dpanel.add(costfield);

		timefield = new JTextField("");
		timefield.setEditable(false);
		dpanel.add(timefield);

		syrupBox = new JTextField();
		syrupBox.setEditable(false);

		addBox = new JTextField();
		addBox.setEditable(false);

		syrupRad = new JRadioButton("Syrup", false);
		cbg.add(syrupRad);
		dpanel.add(syrupRad);

		addRad = new JRadioButton("Add-Ons", false);
		cbg.add(addRad);
		dpanel.add(addRad);

		daysLabel = new JLabel("Days");
		dpanel.add(daysLabel);

		title1 = new JLabel("Choose the Category That You Would");
		title2 = new JLabel("Like Your Team to Research");
		dpanel.add(title1);
		dpanel.add(title2);

		noneSelected = new JRadioButton();
		cbg.add(noneSelected);
		noneSelected.setVisible(false);

		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				setVisible(false);
			}
		});

		// Ensure the text field always gets the first focus.
		addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent ce) {
				// textField.requestFocusInWindow();
			}
		});

		teaRad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isIng = true;
				box = 1;
				if (teaRad.isSelected()) {

					indChoice = "tea";

					String teasel = tealist[tind];
					System.out.println("TIND: " + tind);
					System.out.println("TEA SELECTION: " + teasel);
					if (teasel.equals("Black Tea")) {
						costfield.setText(df.format(20.00));
						timefield.setText("1");
						resChoice = "Black Tea";
					} else if (teasel.equals("Rose Tea")) {
						costfield.setText(df.format(30.00));
						timefield.setText("2");
						resChoice = "Rose Tea";
					} else if (teasel.equals("Green Tea")) {
						costfield.setText(df.format(40.00));
						timefield.setText("3");
						resChoice = "Green Tea";
					}
				}
			}
		});

		syrupRad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isIng = true;
				box = 2;
				if (syrupRad.isSelected()) {
					indChoice = "syrup";

					String syrupsel = syrlist[sind];

					System.out.println("SIND: " + sind);
					System.out.println("SYR SELECTION: " + syrupsel);

					if (syrupsel.equals("PassionFruit")) {
						costfield.setText(df.format(30.00));
						timefield.setText("1");
						resChoice = "Passion Fruit";
					} else if (syrupsel.equals("Strawberry")) {
						costfield.setText(df.format(40.00));
						timefield.setText("2");
						resChoice = "Strawberry";
					} else if (syrupsel.equals("Mango")) {
						costfield.setText(df.format(40.00));
						timefield.setText("3");
						resChoice = "Mango";
					} else if (syrupsel.equals("Apple")) {
						costfield.setText(df.format(30.00));
						timefield.setText("2");
						resChoice = "Apple";
					} else if (syrupsel.equals("Coffee")) {
						costfield.setText(df.format(50.00));
						timefield.setText("3");
						resChoice = "Coffee";
					} else if (syrupsel.equals("Lemon")) {
						costfield.setText(df.format(20.00));
						timefield.setText("1");
						resChoice = "Lemon";
					}
				}
			}
		});

		addRad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isIng = true;
				box = 3;
				if (addRad.isSelected()) {
					indChoice = "add";

					String addonsel = addlist[aind];
					System.out.println("AIND: " + sind);
					System.out.println("ADD SELECTION: " + addonsel);

					if (addonsel.equals("Aloe")) {
						costfield.setText(df.format(40.00));
						timefield.setText("1");
						resChoice = "Aloe";
					} else if (addonsel.equals("Jelly")) {
						costfield.setText(df.format(50.00));
						timefield.setText("2");
						resChoice = "Jelly";
					} else if (addonsel.equals("Lychee Coconut")) {
						costfield.setText(df.format(60.00));
						timefield.setText("3");
						resChoice = "Lychee Coconut";
					}
				}
			}
		});

		interior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				box = 0;
				isIng = false;
				if (interior.isSelected()) {
					String intsel = intlist[iind];

					System.out.println("IIND: " + sind);
					System.out.println("INT SELECTION: " + intsel);

					if (intsel.equals("Space")) {
						costfield.setText(df.format(100.00));
						timefield.setText("2");
						resChoice = "Space";
					} else if (intsel.equals("Hollywood")) {
						costfield.setText(df.format(200.00));
						timefield.setText("3");
						resChoice = "Hollywood";
					} else if (intsel.equals("Jungle")) {
						costfield.setText(df.format(300.00));
						timefield.setText("4");
						resChoice = "Jungle";
					}
				}
			}
		});

		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});

		// This button hires a team, gets the selected
		// category, price, and research time
		hire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cost = (String) costfield.getText();
				if (cost.equals("")) {
					JOptionPane
							.showMessageDialog(
									hireDialog,
									"You must select a research item before hiring a team.",
									"Hiring Error", JOptionPane.ERROR_MESSAGE);
					return;
				} else {

					if (resChoice == "Space" && TapiocaKing.money <= 200) {
						JOptionPane
								.showMessageDialog(
										hireDialog,
										"You must have over 200 dollars in funds to hire this team",
										"Hiring Error",
										JOptionPane.ERROR_MESSAGE);
						return;
					} else if (resChoice == "Hollywood"
							&& TapiocaKing.money <= 300) {
						JOptionPane
								.showMessageDialog(
										hireDialog,
										"You must have over 300 dollars in funds to hire this team",
										"Hiring Error",
										JOptionPane.ERROR_MESSAGE);
						return;
					} else if ((resChoice == "Jungle" || resChoice == "Coffee" || resChoice == "Lychee Coconut")
							&& TapiocaKing.money <= 400) {
						JOptionPane
								.showMessageDialog(
										hireDialog,
										"You must have over 400 dollars in funds to hire this team",
										"Hiring Error",
										JOptionPane.ERROR_MESSAGE);
						return;
					} else if ((resChoice == "Green Tea"
							|| resChoice == "Black Tea" || resChoice == "Rose Tea")
							&& TapiocaKing.money <= 80) {
						JOptionPane
								.showMessageDialog(
										hireDialog,
										"You must have over 80 dollars in funds to hire this team",
										"Hiring Error",
										JOptionPane.ERROR_MESSAGE);
						return;
					} else if ((resChoice == "Passion Fruit" || resChoice == "Aloe")
							&& TapiocaKing.money <= 80) {
						JOptionPane
								.showMessageDialog(
										hireDialog,
										"You must have over 80 dollars in funds to hire this team",
										"Hiring Error",
										JOptionPane.ERROR_MESSAGE);
						return;
					} else if ((resChoice == "Jelly" || resChoice == "Strawberry")
							&& TapiocaKing.money <= 150) {
						JOptionPane
								.showMessageDialog(
										hireDialog,
										"You must have over 150 dollars in funds to hire this team",
										"Hiring Error",
										JOptionPane.ERROR_MESSAGE);
						return;
					} else if ((resChoice == "Apple" || resChoice == "Lemon")
							&& TapiocaKing.money <= 100) {
						JOptionPane
								.showMessageDialog(
										hireDialog,
										"You must have over 100 dollars in funds to hire this team",
										"Hiring Error",
										JOptionPane.ERROR_MESSAGE);
						return;
					} else if ((resChoice == "Mango")
							&& TapiocaKing.money <= 200) {
						JOptionPane
								.showMessageDialog(
										hireDialog,
										"You must have over 200 dollars in funds to hire this team",
										"Hiring Error",
										JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					//this handles the purchase of the research. Subtract from the total funds
					//and add to the expenses
					//Show error if there weren't enough funds to hire the team
					double sub = Double.parseDouble((String) costfield
							.getText());
					TapiocaKing.money -= sub;
					TapiocaKing.expenses[TapiocaKing.sindex] += sub;
					if (TapiocaKing.money < 0) {
						TapiocaKing.money += sub;
						TapiocaKing.expenses[TapiocaKing.sindex] -= sub;
						JOptionPane
								.showMessageDialog(
										hireDialog,
										"Insufficient funds for hiring a research team",
										"Hiring Error",
										JOptionPane.ERROR_MESSAGE);
						return;
					}

					int days = Integer.parseInt((String) timefield.getText());
					System.out.println("Days: " + days);

					TapiocaKing.moneyfield.setText(df.format(TapiocaKing.money));
					JOptionPane.showMessageDialog(hireDialog,
							"Team hired successfully. Research will commence.",
							"Researching", JOptionPane.INFORMATION_MESSAGE);

					setVisible(false);

					if (indChoice.equals("tea")) {
						tind++;
						init();
						System.out.println("TEA IND ADDED: " + tind);
						if (tind > 2) {
							teaRad.setEnabled(false);
						}
					} else if (indChoice.equals("syrup")) {
						init();
						System.out.println("SYRUP IND ADDED: " + sind);
						sind++;
						if (sind > 5) {
							syrupRad.setEnabled(false);
						}
					} else if (indChoice.equals("add")) {
						init();
						System.out.println("ADD IND ADDED: " + aind);
						aind++;
						if (aind > 3) {
							addRad.setEnabled(false);
						}
					} else {
						//the index of the list of interiors is auto-incremented
						//so that the next one can be researched when clicked again,
						//or the button disabled when all interiors have been achieved
						System.out.println("INT IND ADDED: " + iind);
						iind++;
						init();
						if (iind == 3) {
							interior.setEnabled(false);
						}
					}

					if (iind > 2 && tind > 2 && sind > 5 && aind > 3) {
						hire.setEnabled(false);
					}

					TapiocaKing.startResearch(resChoice, days, isIng, box);
					return;
				}
			}
		});
	}

	// reset the button group
	public void init() {
		noneSelected.setSelected(true);
	}

	public void actionPerformed(ActionEvent e) {

	}
}
