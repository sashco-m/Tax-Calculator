import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CloseWindow implements WindowListener
{
    JFrame f;

    public CloseWindow (JFrame f)
    {
	f.addWindowListener (this);
	this.f = f;
    }


    public void windowActivated (WindowEvent w)
    {
    }


    public void windowClosed (WindowEvent w)
    {
    }


    public void windowOpened (WindowEvent w)
    {
    }


    public void windowDeactivated (WindowEvent w)
    {
    }


    public void windowClosing (WindowEvent w)
    {
	int exit = JOptionPane.showConfirmDialog (null, "Are you sure you want to exit?", "Tip Calculator", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	if (exit == 0)
	    f.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    }


    public void windowIconified (WindowEvent w)
    {
    }


    public void windowDeiconified (WindowEvent w)
    {
    }
}
