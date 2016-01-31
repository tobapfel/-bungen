import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;
import java.awt.Color;
import acm.graphics.*;

public class PiApproximator extends GraphicsProgram {
	/**
	 * Randomly generates a new point whose x and y coordinates lie between -1
	 * and 1.
	 * 
	 * @return random point.
	 */
	public GPoint randomPoint() {
	    RandomGenerator rn = new RandomGenerator();
	    RandomGenerator rm = new RandomGenerator();
	    double r1 = rn.nextDouble(-1d, 1d);
	    double r2 = rm.nextDouble(-1d, 1d);
	    return new GPoint (r1,r2);
	    
	    
	}

	/**
	 * Checks if the point with the given coordinates is inside the circle with
	 * radius 1 centered at the coordinate system's origin.
	 * 
	 * @param unitPoint
	 *            the point to check.
	 * @return {@code true} if the point is inside the circle, {@code false} if
	 *         it's not.
	 */
	public boolean isInCircle(GPoint unitPoint) {
	    double x = unitPoint.getX();
	    double y = unitPoint.getY();
	    if (Math.pow(x, 2)+Math.pow(y, 2) < 1){
	    	return true;
	    }
	    else {
	    	return false;
	    }
	    
	}
	public void run(){
		int n = 0;
		GRect rect = new GRect(100,100,400,400);
		add (rect);
		for (int i = 0; i < 10000; i++){
			GPoint point = randomPoint (); //zufällg Ausgewählter Punkt
			double x = (point.getX()+1)*200.0+100.0; //extrahiert die x-Koordiante aus GPoint und verschiebt diese in das Quadrat
			double y = (point.getY()+1)*200.0+100.0; //extrahiert die y-Koordinate aus GPoint und verschiebt diese in das Quadrat
			GOval oval = new GOval (x,y,1.0,1.0);
			if (isInCircle(point)){ // Prüfen ob Punkt im Kreis
				n += 1;
				oval.setColor(Color.BLUE);
			}
			add (oval); //Zeichnen des Punkts.
		}
		double pi = (n/10000.0)*4.0; // Berechenen des ungefairen PI
		println (pi);
	}
}
