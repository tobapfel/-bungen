import acm.program.GraphicsProgram;

import java.awt.Color;

import acm.graphics.*;
import acm.program.*;

public class Olympia extends GraphicsProgram {
	public void run() {
		GArc AB = new GArc (20,20,200,200,-85,355);
		AB.setColor(Color.BLUE);
		add (AB);
		GArc AS = new GArc (230,20,200,200,-85,265);
		AS.setColor(Color.BLACK);
		add (AS);
		GArc As = new GArc (230,20,200,200,-175,85);
		As.setColor(Color.BLACK);
		add(As);
		GArc AR = new GArc (440,20,200,200,-175,355);
		AR.setColor(Color.RED);
		add(AR);
		GArc AY = new GArc (125,125,200,200,95,265);
		AY.setColor(Color.YELLOW);
		add (AY);
		GArc Ay = new GArc (125,125,200,200,5,85);
		Ay.setColor(Color.YELLOW);
		add (Ay);
		GArc AG = new GArc (335,125,200,200,95,265);
		AG.setColor(Color.GREEN);
		add (AG);
		GArc Ag = new GArc (335,125,200,200,5,85);
		Ag.setColor(Color.GREEN);
		add (Ag);
		
	}

}
