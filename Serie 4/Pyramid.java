import acm.program.GraphicsProgram;
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;

public class Pyramid extends GraphicsProgram {
	public void run(){
		int n = readInt ("Enter the number of bricks in the bottom layer: ");
		for (int i = n; i>0;i--){
			for (int j = i; j>0; j--){
				double x = j*100+(n-i)*50;
				double y = i*50;
				GRect rect = new GRect (x,y,100,50);
				double bg = 220d/(n-1);
				bg= bg*(n-i);
				int g = (int)bg;
				Color layer = new Color (255,g,g);
				rect.setFillColor(layer);
				rect.setFilled(true);
				add (rect);
			}
		}
	}

}
