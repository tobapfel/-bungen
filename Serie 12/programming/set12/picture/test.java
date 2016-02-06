package programming.set12.picture;

import acm.program.GraphicsProgram;

public class test extends GraphicsProgram {
	@Override
	public void run() {
		for (int i = 10; i > 5; i--) {
			// Math.abs(i - 10) * 10) + x
			println(Math.abs(i - 10));
			println(Math.abs(i - 10) * 10);
		}
	}

}
