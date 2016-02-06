package programming.set12.picture;

import java.awt.Color;
import java.util.Random;

import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class patchwork extends GraphicsProgram {

	@Override
	public void run() {
		int row = readInt("How many rows: ");
		int col = readInt("How many colunm: ");
		createPatches(row, col);

	}

	private void createPatches(int row, int col) {
		setSize(100 * col + 200, row * 100 + 200);
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= col; j++) {
				GRect rect = new GRect(100 * j, 100 * i, 100, 100);
				add(rect);
				addRandomPatch(100 * j, 100 * i);
			}
		}

	}

	private void addRandomPatch(int x, int y) {
		Random rd = new Random();
		switch (rd.nextInt(3)) {
		case 0:
			patch1(x, y);
			break;
		case 1:
			patch2(x, y);
			break;
		case 2:
			patch3(x, y);
			break;
		}

	}

	private void patch3(int x, int y) {

	}

	private void patch2(int x, int y) {
		int pos = 0;
		for (int i = 10; i > 0; i -= 2) {

			GRect rect = new GRect(x + pos, y + pos, i * 10, i * 10);
			rect.setColor(radomColor());
			rect.setFilled(true);
			add(rect);
			GOval oval = new GOval(x + pos, y + pos, i * 10, i * 10);
			oval.setColor(radomColor());
			oval.setFilled(true);
			add(oval);
			pos += 10;

		}

	}

	private void patch1(int x, int y) {
		int pos = 0;
		for (int i = 100; i > 0; i -= 2) {
			GOval oval = new GOval(pos + x, pos + y, i, i);
			oval.setColor(radomColor());
			oval.setFilled(true);
			add(oval);
			pos += 1;
		}

	}

	public Color radomColor() {
		Random rd = new Random();
		float r = rd.nextFloat();
		float g = rd.nextFloat();
		float b = rd.nextFloat();
		return new Color(r, g, b);
	}

}
