import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.*;
import java.awt.event.*;


public class Universe extends JPanel implements ActionListener
{
	mylist<Body> universe;
	Double scale;
	Timer timer = new Timer (5,this);
	
	public Universe(mylist array,double scale)
	{
		universe = array;
		this.scale = scale;
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		for (int i =0; i<universe.size(); i++)
		{
			universe.get(i).display(g);
		}
		timer.start();
	}
	/*public void actionPerformed(ActionEvent e)
	{
		for (int i =0; i<universe.size(); i++)
		{
			universe.get(i).update();
			repaint();
		}
	}*/
	
	public void actionPerformed(ActionEvent e)
	{
		for (int i =0; i<universe.size(); i++)
		{
			for (int j =0; j<universe.size(); j++)
			{
				if(i != j)
				{
					universe.get(i).force(universe.get(j),scale);
				}
			}

		}
		for ( int i = 0; i< universe.size(); i++)
		{
			universe.get(i).update();
			repaint();
		}
	}
}
