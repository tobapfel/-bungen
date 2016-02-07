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

	/**
	 * Draws Patchworks in a grid with {@code row} rows and {@code col} columns
	 * 
	 * @param row
	 *            the number of rows
	 * @param col
	 *            the number of columns
	 */
	private void createPatches(int row, int col) {
		assert row >= 0 : row;
		assert col >= 0 : col;
		setSize(100 * col + 200, row * 100 + 200); // resize the window with
													// border
		for (int i = 1; i <= row; i++) { // rows
			for (int j = 1; j <= col; j++) { // column
				GRect rect = new GRect(100 * j, 100 * i, 100, 100); // draws a
																	// rectangle
				add(rect);
				addRandomPatch(100 * j, 100 * i); // fills rectangle
			}
		}

	}

	/**
	 * draws a random Patchwork at a give position
	 * 
	 * @param x
	 *            the x-coordinate of the Patchwork
	 * @param y
	 *            the y-coordinate of the Patchwork
	 */
	private void addRandomPatch(int x, int y) {
		assert !(x < 0) : x;
		assert !(y < 0) : y;
		Random rd = new Random();
		switch (rd.nextInt(3)) { // choose a random patchwork
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

	/**
	 * draws a random Patchwork at a give position
	 * 
	 * @param x
	 *            the x-coordinate of the Patchwork
	 * @param y
	 *            the y-coordinate of the Patchwork
	 */
	private void patch3(int x, int y) {
		assert !(x < 0) : x;
		assert !(y < 0) : y;
		GRect background = new GRect(x, y, 100, 100); // draws a background
														// rectangle
		background.setFillColor(radomColor());
		background.setFilled(true);
		add(background);
		Random rn = new Random();
		for (int i = 0; i < 1000; i++) {
			GRect rect = new GRect(x + rn.nextInt(90) + 1, y + rn.nextInt(90) + 1, 10, 10); // draws
																							// a
																							// rectangle
																							// at
																							// a
																							// random
																							// position
			rect.setColor(radomColor());
			rect.setFilled(true);
			add(rect);
		}

	}

	/**
	 * draws a random Patchwork at a give position
	 * 
	 * @param x
	 *            the x-coordinate of the Patchwork
	 * @param y
	 */
	private void patch2(int x, int y) {
		assert !(x < 0) : x;
		assert !(y < 0) : y;
		int pos = 0;
		for (int i = 10; i > 0; i -= 2) {

			GRect rect = new GRect(x + pos, y + pos, i * 10, i * 10); // draws a
																		// rectangle
			rect.setColor(radomColor());
			rect.setFilled(true);
			add(rect);
			GOval oval = new GOval(x + pos, y + pos, i * 10, i * 10); // draws a
																		// circle
			oval.setColor(radomColor());
			oval.setFilled(true);
			add(oval);
			pos += 10; // sets the position of next objects
			assert pos <= 50 : pos;

		}

	}

	/**
	 * draws a random Patchwork at a give position
	 * 
	 * @param x
	 *            the x-coordinate of the Patchwork
	 * @param y
	 */
	private void patch1(int x, int y) {
		assert !(x < 0) : x;
		assert !(y < 0) : y;
		GRect rect = new GRect(x, y, 100, 100); // draws a background rectangle
		rect.setFillColor(radomColor());
		rect.setFilled(true);
		add(rect);
		int pos = 0;
		for (int i = 100; i > 0; i -= 2) {
			GOval oval = new GOval(pos + x, pos + y, i, i); // draws a circle
			oval.setColor(radomColor());
			oval.setFilled(true);
			add(oval);
			pos += 1; // calculate the position of the next circle
			assert pos <= 100 : pos;
		}

	}

	/**
	 * generates a random color
	 * 
	 * @return a random color
	 */
	public Color radomColor() {
		Random rd = new Random();
		float r = rd.nextFloat(); // generates a random value for red
		float g = rd.nextFloat(); // generates a random value for green
		float b = rd.nextFloat(); // generates a random value for blue
		return new Color(r, g, b); // creates new color
	}

}
