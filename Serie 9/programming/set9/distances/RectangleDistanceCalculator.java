package programming.set9.distances;

import java.awt.geom.Rectangle2D;

public class RectangleDistanceCalculator {
	/**
	 * Calculates the minimum distance between any two rectangles in the given
	 * array. The distance between two rectangles is defined as the length of
	 * the shortest line that can be drawn between them. If two rectangles
	 * overlap, their distance is defined to be 0. A distance can of course
	 * never be negative.
	 * 
	 * @param rectangles
	 *            array of rectangles.
	 * @return minimum distance between any pair of rectangles, or -1 if the
	 *         array contains fewer than 2 rectangles.
	 */
	public double minDistance(Rectangle2D.Double[] rectangles) {
		double x = 0;
		double x1 = 0;
		double y = 0;
		double y1 = 0;
		double width = 0;
		double width1 = 0;
		double height = 0;
		double height1 = 0;
		double xw = 0;
		double yh = 0;
		double x1w = 0;
		double y1h = 0;
		double dx = 0;
		double dy = 0;
		double diffx = 0;
		double diffy = 0;
		double diff = 0;
		double minDiff = Double.POSITIVE_INFINITY;
		if (rectangles.length <= 1){
			return -1;
		}
		for (Rectangle2D rect : rectangles) {
			for (Rectangle2D rect1 : rectangles) {
				if (rect == rect1) {
					continue;
				} else {
					x = rect.getX();
					y = rect.getY();
					width = rect.getWidth();
					height = rect.getHeight();
					x1 = rect1.getX();
					y1 = rect1.getY();
					width1 = rect1.getWidth();
					height1 = rect1.getHeight();
					xw = x + width;
					x1w = x1 + width1;
					if ((x <= x1w && x >= x1) || (xw <= x1w && xw >= x1) || (x1 <= xw && x1 >= x)
							|| (x1w <= xw && x1w >= x)) { // Check if intervals overlap
						dx = 0; // distance = 0
					} else {
						diffx = Math.min(Math.min(Math.abs(x1 - x), Math.abs(x1w - xw)),
								Math.min(Math.abs(x - x1w), Math.abs(x1 - xw))); // shortest distance between intervals
					}
					yh = y + height;
					y1h = y1 +  height1;
					if ((y <= y1h && y >= y1) || (yh <= y1h && yh >= y1) || (y1 <= yh && y1 >= y)
							|| (y1h <= yh && y1h >= y)) { // Check if intervals overlap
						dy = 0; // distance = 0
					} else {
						diffy = Math.min(Math.min(Math.abs(y1 - y), Math.abs(y1h - yh)),
								Math.min(Math.abs(y - y1h), Math.abs(y1 - yh))); // shortest distance between intervals
					}
					diff = Math.sqrt(Math.pow(diffx, 2) + Math.pow(diffy, 2)); // calculate distance between rects with pythagoras
					minDiff = Math.min(minDiff, diff);
				}
			}
		}
		return minDiff;
	}

}
