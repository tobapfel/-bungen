import acm.program.GraphicsProgram;
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.color.*;

public class Rainbow extends GraphicsProgram {
	public void run() {
		Color Sky = new Color(157,217,237);
		setBackground(Sky);
		GArc Arc = new GArc (20,20,300,300,0,180);
		Arc.setFilled(true);
		Arc.setColor(Color.RED);
		add (Arc);
		GArc Arc1 = new GArc (30,30,280,280,0,180);
		Arc1.setFilled(true);
		Arc1.setColor(Color.ORANGE);
		add (Arc1);
		GArc Arc2 = new GArc (40,40,260,260,0,180);
		Arc2.setFilled(true);
		Arc2.setColor(Color.YELLOW);
		add (Arc2);
		GArc Arc3 = new GArc (50,50,240,240,0,180);
		Arc3.setFilled(true);
		Arc3.setColor(Color.GREEN);
		add (Arc3);
		GArc Arc4 = new GArc (60,60,220,220,0,180);
		Arc4.setFilled(true);
		Arc4.setColor(Color.CYAN);
		add (Arc4);
		GArc Arc5 = new GArc (70,70,200,200,0,180);
		Arc5.setFilled(true);
		Arc5.setColor(Color.BLUE);
		add (Arc5);
		GArc Arc6 = new GArc (80,80,180,180,0,180);
		Arc6.setFilled(true);
		Arc6.setColor(Sky);
		add (Arc6);
	}

}
