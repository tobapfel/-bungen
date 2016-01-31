import acm.program.GraphicsProgram;
import acm.graphics.*;
import acm.program.*;

public class Tic extends GraphicsProgram {
	public void run(){
		int x,x1,y,y1;
		int x11,x12,y11,y12,x21,x22,y21,y22;
		
		add(new GLine(100,200,400,200));
		add(new GLine(100,300,400,300));
		add(new GLine(200,100,200,400));
		add(new GLine(300,100,300,400));
		
		y=readInt ("Player 1 Y: ");
		
		y11=y*100;
		y12=y*100+100;
		y21=y*100;
		y22=y*100+100;
		
		x=readInt ("Player 1 X: ");
		
		x11=x*100;
		x12=x*100+100;
		x21=x*100+100;
		x22=x*100;
		
		add (new GLine(x11,y11,x12,y12));
		add (new GLine (x21,y21,x22,y22));
		
		y1=readInt ("Player 2 Y: ");
		y1=y1*100;
		x1=readInt ("Player 2 X: ");
		x1=x1*100;
		
		GArc arc = new GArc(x1,y1,100,100,0,360);
		add(arc);
			
		
	}

}
