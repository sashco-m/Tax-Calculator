import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class TipCalculatorMistelbacherUser
{
    public static void main (String[] args)
    {

	JFrame f = new JFrame ("Tip Calculator");

	JPanel p = new JPanel ();
	p.setLayout(null);
	JLabel title = new JLabel ("Tip Calculator");
	title.setFont (new Font ("Dialog", Font.BOLD, 30));
	//input titles
	JLabel totalBill = new JLabel ("Total bill:");

	JLabel totalPeople = new JLabel ("Total people:");

	JLabel tipPercent = new JLabel ("Tip percentage:");
	//img
	JLabel image = new JLabel ();
	
	//output titles
	JLabel grandTot = new JLabel ("GRAND TOTAL:");

	JLabel tipAmount = new JLabel ("TIP AMOUNT:");

	JLabel perPerson = new JLabel ("TOTAL/PERSON:");
	
	JLabel grandTotOut = new JLabel ("");
	
	JLabel tipAmountOut = new JLabel ("");
	
	JLabel perPersonOut = new JLabel ("");
	
	CloseWindow cw=new CloseWindow(f);

	p.setBackground (Color.white);
	f.setSize (450, 375);
	f.setDefaultCloseOperation (JFrame.DO_NOTHING_ON_CLOSE);
	f.setResizable (false);

	
	f.setContentPane (p);
	f.setVisible (true);
	
	TipCalculatorMistelbacher t = new TipCalculatorMistelbacher (p, title, totalBill, totalPeople, tipPercent, grandTot, tipAmount, perPerson,grandTotOut,tipAmountOut,perPersonOut,image);
    
	
	}
}
