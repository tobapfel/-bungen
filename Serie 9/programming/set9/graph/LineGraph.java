package programming.set9.graph;

import acm.program.GraphicsProgram;
import acm.graphics.*;

import java.awt.Color;
import java.awt.color.*;
import java.util.Iterator;

public class LineGraph extends GraphicsProgram {
	/**
	 * Plots the given set of data points. For each data point, a small circle
	 * is added to the drawing area, and each neighbouring set of circles is
	 * connected by a line. The data set's name should be added in the form of a
	 * label near the leftmost circle. Everything is to be drawn in the given
	 * color.
	 * 
	 * In the x direction, the circles should be evenly distributed over the
	 * whole width of the dawing area. In the y direction, the top border of the
	 * drawing area should represent the given maximum y value, and the bottom
	 * border of the drawing area should represent the given minimum y value.
	 * Leave a small border around the drawing area to keep circles from being
	 * cut off.
	 * 
	 * @param name
	 *            the data set's name.
	 * @param color
	 *            the color to use for displaying the data set.
	 * @param data
	 *            the data set to be plotted. You can assume that this will
	 *            contain at least one item.
	 * @param minY
	 *            minimum Y value that can properly be displayed in the window.
	 * @param maxY
	 *            maximum Y value that can properly be displayed in the window.
	 *            You can assume that maxY is greater than minY.
	 */
	public void plotGraph(String name, Color color, double[] data, double minY, double maxY) {
		double y1 = 0;	// 1. y - coordinate
		double y2 = 0;  // 2. y - coordinate
		double x1 = 0;	// 1. x - coordinate
		double x2 = 0;	// 2. x - coordinate
		double height = getHeight(); //get height from Window
		double width = getWidth(); // get width from Window
		double y = (100 / (maxY - minY)) * height;	//calculate ratio between coordinates and Window
		y = y / 100;
		double x = width / (data.length - 1); // calculates x interval
		for (int i = 0; i < data.length; i++) { 
			if (data.length == 1 || data[0] == data[1]){ 
				y1 = height / 2;
			}
			else {
				y1 = (height - (data[i] * y)) + minY * y; // calculates y value
			}
			x1 = x * i; // calculates x value
			GOval oval = new GOval(x1 - 2.5, y1 - 2.5, 5, 5);
            oval.setColor(color);
            oval.setFillColor(color);
            oval.setFilled(true);
            add(oval);
            if (i != 0){
            GLine line = new GLine (x1,y1,x2,y2);
            line.setColor(color);
            add (line);
            }
            x2 = x1; // saves last coordinates
            y2 = y1;
			
		}
		GLabel label = new GLabel(name, (x / 2) - 10, (height - (data[0] * y1)) - 10);
		label.setColor(color);
		add(label);

	}

	/**
	 * Same as {@link #plotGraph(String, Color, double[], double, double)}, but
	 * calculates the minimum and maximum Y values necessary to completely fit
	 * the data set inside the drawing area. If the minimum and maximum Y values
	 * are equal (let's call that value {@code yVal}, call
	 * {@link #plotGraph(String, Color, double[], double, double)} with the
	 * minimum and maximum Y values chosen such that {@code yVal} is in the
	 * middle. That is, if all values of the data array are equal, the line
	 * graph should be a horizontal line through the window's center.
	 * 
	 * @param name
	 *            the data set's name.
	 * @param color
	 *            the color to use for displaying the data set.
	 * @param data
	 *            the data set itself.
	 */
	public void plotGraph(String name, Color color, double[] data) {
		double min = Math.pow(1 * 10, 1000000000);
		double next = 0;
		for (int i = 0; i < data.length; i++) {
			next = data[i];
			if (min > next) {
				min = next;
			}
		}
		double max = 0;
		double nxt = 0;
		for (int j = 0; j < data.length; j++) {
			nxt = data[j];
			if (max < nxt) {
				max = nxt;
			}
		}
		plotGraph(name, color, data, min, max);
	}

	public void run() {
		setSize(600, 300);
		validate();
		double[] data = new double[5];
		data[0] = 10;
		data[1] = 60;
		data[2] = 40;
		data[3] = 50;
		data[4] = 20;
		String name = "hallo";
		Color color = Color.BLUE;
		plotGraph(name, color, data);
	}

}
