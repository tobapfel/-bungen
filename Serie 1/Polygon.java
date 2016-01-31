import acm.program.GraphicsProgram;
import acm.graphics.*;
import acm.io.IODialog;


public class Polygon extends GraphicsProgram {
	public void run(){
		
		double n; //anzahl der ecken
		double s; //zwischenergebnis
		double r=100; //radius
		int x; // 1. X-Koordinate 
		double xd; //1. X-Koordinate in double
		int y; //1. Y-Koordinate
		double yd; //1. Y-Koordinate in double 
		double i; 
		double s1; //Zwischenergebnis
		int x1; // 2. X-Koordinate 
		double x1d; // 2. X-Koordinate in double
		int y1; // 2. Y-Koordinate 
		double y1d; // 2. Y-Koordinate in double 
		IODialog dialog = new IODialog();
		//n = readDouble ("Anzahl der Ecken:");
		n=dialog.readDouble("Anzahl der Ecken: ");
		for (i=0;i<n;i++)
		{
			s = i*(2*Math.PI)/n; //Berechnung des Winkels
			xd= r*Math.cos(s); //Berechnung der X-Koordinate
			yd= r*Math.sin(s); //Berechnug der Y-Koordinate
			x = (int)xd; 
			x = x+120; //X-Koordinate verschieben damit sichbar
			y = (int)yd;
			y = y+120; //Y-Koordinate verschieben ddamit sichbar
			
			s1 = (i+1)*(2*Math.PI)/n;
			x1d= r*Math.cos(s1);
			y1d= r*Math.sin(s1);
			x1 = (int)x1d;
			x1 = x1+120;
			y1 = (int)y1d;
			y1 = y1+120;
			add(new GLine (x,y,x1,y1));
		}
	}


}
