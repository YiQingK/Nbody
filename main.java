import java.util.Scanner;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;


public class main 
{
	public static void main(String[] args) throws Exception
	{
	int maxX = 768;
	int maxY = 768;
	mylist<Body> bodies;
	try 
	{
	Scanner scan = new Scanner(new File(args[0]));
	String type = scan.nextLine();
	if (type.contains("ArrayList"))
	{
		bodies = new myarraylist<Body>();
	}
	else if (type.contains("LinkedList"))
	{
		bodies = new mylinkedlist<Body>();
	}
	else
	{
		throw new Exception("You did not provide a vaid choice of list type.");
	}
	
	
	Double scale = Double.parseDouble(scan.nextLine());
	
	while (scan.hasNextLine())
	{
		String input = scan.nextLine();
		Body b = new Body(input);
		bodies.add(b);
	}
	
	JFrame jf = new JFrame();
	jf.setTitle("Universe");
	jf.setSize(maxX,maxY);
	Universe uni = new Universe(bodies,scale);
	jf.add(uni);
	jf.setVisible(true);
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	

	}
	catch(FileNotFoundException e)
	{
		System.out.println("File not found...");
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
}
}
