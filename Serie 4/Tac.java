import acm.program.GraphicsProgram;
import acm.graphics.*;
import acm.program.*;
import acm.program.ConsoleProgram;

public class Tac extends GraphicsProgram {
	public void run() {
		int x, x1, y, y1;
		int x11, x12, y11, y12, x21, x22, y21, y22;
		add(new GLine(100, 200, 400, 200));
		add(new GLine(100, 300, 400, 300));
		add(new GLine(200, 100, 200, 400));
		add(new GLine(300, 100, 300, 400));

		for (int n = 1; n <= 9; n++) {

			int m = n % 2;
			if (m == 1) {
				do {
					x = readInt("Player 1 X: ");
					y = readInt("Player 1 Y: ");
				} while (y < 1 || y > 3 || x < 1 || x > 3);
				

				x11 = x * 100;
				x12 = x * 100 + 100;
				x21 = x * 100 + 100;
				x22 = x * 100;

				y11 = y * 100;
				y12 = y * 100 + 100;
				y21 = y * 100;
				y22 = y * 100 + 100;
				add(new GLine(x11, y11, x12, y12));
				add(new GLine(x21, y21, x22, y22));
			} else if (m == 0) {
				do {
					x1 = readInt("Player 2 X: ");
					y1 = readInt("Player 2 Y: ");
				} while (y1 < 1 || y1 > 3 || x1 < 1 || x1 > 3);
				x1 = x1 * 100;
				y1 = y1 * 100;
				GArc arc = new GArc(x1, y1, 100, 100, 0, 360);
				add(arc);
			}
		}
	}

}
