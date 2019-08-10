package Coding_Exam_A;

import java.awt.Color;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class CodingExamA {
	public static void main(String[] args) {
		/*
		 * Write a program that asks the user for three pieces of information.
		 * 1. How many robots
		 * 2. The color of the shapes
		 * 3. How many sides each shape will have
		 * 
		 * Once the information has been collected, the program will then make the requested number of robots
		 * each draw the requested shape in the requested color. The robots should execute at the same time so 
		 * Threads will need to be used. Arrange the robots so that the shapes do not overlap.
		 * For full credit, define the Thread functions using lambdas.
		 * 
		 * See the Coding_Exam_A_Demo.jar for an example of what the finished product should look like.
		 */
		final int num = Integer.parseInt(JOptionPane.showInputDialog("Input the number of robots."));
		final String col = JOptionPane.showInputDialog("Input the color (Red, Green, or Blue)");
		final int sides = Integer.parseInt(JOptionPane.showInputDialog("Input the number of sides (>0)"));
		
		
		
		for(int i = 0; i < num; i++)
		{
			Robot r = new Robot(50*sides*i+50, 500);
			r.setSpeed(200);
			r.setPenColor(getColor(col));
			
			new Thread(() -> {
				
				for(int j = 0; j < sides; j++)
				{
					r.penDown();
					r.move(50);
					r.turn(360/sides);
				}
				r.penUp();
			}).start();
		}
		
	}
	
	public static Color getColor(String s)
	{
		if(s.equalsIgnoreCase("BLUE")) {return Color.BLUE;}
		if(s.equalsIgnoreCase("RED")) {return Color.RED;}
		return Color.GREEN;
	}
	
}
