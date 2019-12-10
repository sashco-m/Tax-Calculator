import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class TipCalculatorMistelbacher implements ActionListener
{
    private JButton ok, clear;
    private JTextField textBill, textPeople, textPercentage;
    private JLabel gTO, tAO, pPO;

    public TipCalculatorMistelbacher (JPanel p, JLabel title, JLabel totalBill, JLabel totalPeople, JLabel tipPercent, JLabel grandTot, JLabel tipAmount, JLabel perPerson, JLabel grandTotOut, JLabel tipAmountOut, JLabel perPersonOut, JLabel image)
    {
	//image stuff
	ImageIcon tipFinal = new ImageIcon ("tipFinal.png");
	//this allows me to resize the image however I like
	//I researched this section
	Image img = tipFinal.getImage ();
	BufferedImage bi = new BufferedImage (img.getWidth (null), img.getHeight (null), BufferedImage.TYPE_INT_ARGB);
	Graphics g = bi.createGraphics ();
	g.drawImage (img, 0, 200, 210, 280, null);//manually adjust the size of the image
	ImageIcon newTip = new ImageIcon (bi);
	image.setIcon (newTip);//new adjusted image

	//creating objects
	ok = new JButton ("OK");
	clear = new JButton ("CLEAR");
	textBill = new JTextField ();
	textPeople = new JTextField ();
	textPercentage = new JTextField ();

	//labels
	gTO = grandTotOut;
	tAO = tipAmountOut;
	pPO = perPersonOut;

	//add action listener
	ok.addActionListener (this);
	clear.addActionListener (this);

	//test
	//perPersonOut.setText("hello");
	//outputs are in a LABEL
	//adding to the panel
	p.add (image);
	p.add (title);
	p.add (totalBill);
	p.add (totalPeople);
	p.add (tipPercent);
	p.add (ok);
	p.add (clear);
	p.add (textBill);
	p.add (textPeople);
	p.add (textPercentage);

	//labels for output
	p.add (grandTot);
	p.add (tipAmount);
	p.add (perPerson);
	p.add (gTO);
	p.add (tAO);
	p.add (pPO);

	//setting bounds
	title.setBounds (120, 0, 300, 40);
	totalBill.setBounds (220, 50, 100, 20);
	textBill.setBounds (320, 50, 100, 20);
	totalPeople.setBounds (220, 90, 100, 20);
	textPeople.setBounds (320, 90, 100, 20);
	image.setBounds (0, 0, 300, 350);
	tipPercent.setBounds (220, 130, 100, 20);
	textPercentage.setBounds (320, 130, 100, 20);

	//centering text
	textBill.setHorizontalAlignment (JTextField.CENTER);
	textPeople.setHorizontalAlignment (JTextField.CENTER);
	textPercentage.setHorizontalAlignment (JTextField.CENTER);

	//space for buttons
	ok.setBounds (240, 180, 80, 30);
	clear.setBounds (320, 180, 80, 30);
	grandTot.setBounds (220, 230, 100, 20);
	gTO.setBounds (320, 230, 100, 20);
	tipAmount.setBounds (220, 270, 100, 20);
	tAO.setBounds (320, 270, 100, 20);
	perPerson.setBounds (220, 310, 100, 20);
	pPO.setBounds (320, 310, 100, 20);


	//centering the text on the labels and adding border
	gTO.setHorizontalAlignment (SwingConstants.CENTER);
	tAO.setHorizontalAlignment (SwingConstants.CENTER);
	pPO.setHorizontalAlignment (SwingConstants.CENTER);

	gTO.setBorder (BorderFactory.createLineBorder (Color.black));
	tAO.setBorder (BorderFactory.createLineBorder (Color.black));
	pPO.setBorder (BorderFactory.createLineBorder (Color.black));
	//customize
	Color c = new Color (0, 58, 77);
	Color b = new Color (0, 179, 179);
	title.setForeground (c);
	totalBill.setForeground (c);
	totalPeople.setForeground (c);
	tipPercent.setForeground (c);
	grandTot.setForeground (c);
	tipAmount.setForeground (c);
	perPerson.setForeground (c);
	ok.setBackground (b);
	clear.setBackground (b);


    }


    public void actionPerformed (ActionEvent e)
    {
	int error = 0, totalPeople;
	double totalBill, tipPercent, tip;
	NumberFormatException f=new NumberFormatException();
	
	if (e.getSource () == ok)
	{
	    //changing the color from red back to white
	    textBill.setBackground (Color.white);
	    textPeople.setBackground (Color.white);
	    textPercentage.setBackground (Color.white);

	    try
	    {
		totalBill = Double.parseDouble (textBill.getText ());
		if(totalBill<0)//manually throwing an exception if it is less than zero
		    throw f;
		
		error = 1; //allows the catch block to know which text field to highlight/return focus

		totalPeople =Integer.parseInt (textPeople.getText ());
		if(totalPeople<1)
		    throw f; //exception thrown if there is less than 1 person
		    
		error = 2;
		
		tipPercent = Double.parseDouble (textPercentage.getText ());
		if(tipPercent<0)
		    throw f; //exception thrown if a negative tip is used
		
		//calculations
		tip = totalBill * tipPercent / 100.0;

		tAO.setText ("$" + Math.round (tip * 100) / 100.0);

		gTO.setText ("$" + Math.round ((tip + totalBill) * 100) / 100.0);

		pPO.setText ("$" + Math.round (((tip + totalBill) / totalPeople) * 100) / 100.0);


	    }
	    catch (NumberFormatException n)
	    {
		JOptionPane.showMessageDialog (null, "Please fill in the required fields!", "Invalid data!", JOptionPane.ERROR_MESSAGE);
		if (error == 0)
		{
		    textBill.setText ("");
		    textBill.requestFocus ();
		    textBill.setBackground (Color.red);
		}
		else if (error == 1)
		{
		    textPeople.setText ("");
		    textPeople.requestFocus ();
		    textPeople.setBackground (Color.red);
		}
		else
		{
		    textPercentage.setText ("");
		    textPercentage.requestFocus ();
		    textPercentage.setBackground (Color.red);
		}
	    }

	}
	else if (e.getSource () == clear)
	{
	    textBill.setText ("0");
	    textBill.requestFocus ();
	    textPeople.setText ("1");
	    textPercentage.setText ("0");
	    //labels
	    gTO.setText ("");
	    tAO.setText ("");
	    pPO.setText ("");
	    //changing the color from red back to white
	    textBill.setBackground (Color.white);
	    textPeople.setBackground (Color.white);
	    textPercentage.setBackground (Color.white);


	}

    }
}
