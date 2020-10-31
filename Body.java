import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import javax.swing.JPanel;

import java.util.Random;


public class Body extends JPanel
{
	String name;
	double mass, xVel, yVel, xCoord, yCoord, F, xForce, yForce;
	double gC = 6.67e-11;
	int size;
	Color clr;
	int num;
	Random rand = new Random();
	
	
	public Body(String input)
	{
		String[] info = input.split(",");
		
		name = info[0];
		mass = Double.parseDouble(info[1]);
		xCoord = Double.parseDouble(info[2]);
		yCoord = Double.parseDouble(info[3]);
		xVel = Double.parseDouble(info[4]);
		yVel = Double.parseDouble(info[5]);
		size = Integer.parseInt(info[6]);
		
		int r = rand.nextInt(255);
		int gr = rand.nextInt(255);	
		int b = rand.nextInt(255);
		clr = new Color(r, gr, b);
		
		num++;
	}
	public void display(Graphics g)
	{
		g.setColor(clr);
		g.fillOval((int)xCoord, (int)yCoord, (int)size,(int) size);
	}

	public void update()
	{
		xVel += xForce/mass;
		yVel += yForce/mass;
		xCoord += xVel;
		yCoord += yVel;
	}
	
	public void force(Body b2, double scale)
	{
		double xDiff = Math.abs(this.xCoord-b2.xCoord) * scale;
		double yDiff = Math.abs(this.yCoord-b2.yCoord) * scale;
		double r = (Math.hypot(xDiff, yDiff));
		double mass1 = this.mass;
		double mass2 = b2.mass;
		F = (gC * (mass1 * mass2))/(r * r);
		xForce = F * xDiff / r;
		yForce = F * yDiff / r;
		
	}
	
	
}
