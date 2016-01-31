import acm.program.GraphicsProgram;
import acm.graphics.*;
import acm.program.*;

public class Architecture extends GraphicsProgram {
	public void run (){
		add (new GRect (20,80,80,80));
		add (new GRect (50,120,20,40));
		add (new GRect (25,120,20,20));
		add (new GRect (75,120,20,20));
		add (new GLine (20,80,60,20));
		add (new GLine (60,20,100,80));
		add (new GOval (55,140,3,3));
	}

}
