/* 
 * Challenge++ Exercise
 * 
 * Write a program that takes an axis-aligned rectangle and rotates it
 * clockwise around its center (not relative to the origin). Your program
 * should take 5 parameters: top, right, bottom, left boundaries of the
 * rectangle (in that order), then the angle in degrees. All inputs (and outputs)
 * may be decimals. Output the coordinates of all four rotated corners in some
 * logical order.
 * 
 * Inputs are assumed to be clean (i.e. no input checking)
 */

public class RotateRect {
	public static void main(String[] args) {
		// Parse arguments
		Point bottomLeft = new Point();
		bottomLeft.x = Double.parseDouble(args[3]);
		bottomLeft.y = Double.parseDouble(args[2]);
		Point topRight = new Point();
		topRight.x = Double.parseDouble(args[1]);
		topRight.y = Double.parseDouble(args[0]);
		Point topLeft = new Point();
		topLeft.x = bottomLeft.x;
		topLeft.y = topRight.y;
		Point bottomRight = new Point();
		bottomRight.x = topRight.x;
		bottomRight.y = bottomLeft.y;
		double angle = Double.parseDouble(args[4]);
		
		// Calculate center
		Point center = new Point();
		center.x = (topRight.x + bottomLeft.x) / 2;
		center.y = (topRight.y + bottomLeft.y) / 2;
		
		// Apply rotation to all four points
		bottomLeft = rotate(bottomLeft, angle, center);
		topRight = rotate(topRight, angle, center);
		topLeft = rotate(topLeft, angle, center);
		bottomRight = rotate(bottomRight, angle, center);
		
		// Print results
		System.out.println("Point order is (in terms of original positions): bottom left, top left, top right, bottom right.");
		
		bottomLeft.printPoint();
		topLeft.printPoint();
		topRight.printPoint();
		bottomRight.printPoint();
	}
	
	// Helper class to store point data and a method for printing the coordinates.
	public static class Point {
		double x, y;
		
		void printPoint() {
			System.out.println("(" + String.format("%.2f", this.x) + ", " + String.format("%.2f", this.y) + ")");
		}
	}
	
	// Method that does the math for rotating points
	private static Point rotate(Point p, double d, Point c) {
		// The math (trig functions) for rotation about a center assumes counter-clockwise rotation in radians
		d = Math.toRadians(360 - d);
		
		// Translate points to be centered around origin
		double offsetX = p.x - c.x;
		double offsetY = p.y - c.y;
		
		// Calculate x position as if it were rotating around origin
		// newX = x * cos(d) - y * sin(d)
		double newX = offsetX * Math.cos(d) - offsetY * Math.sin(d);
		
		// Calculate y position as if it were rotating around origin
		// newY = x * sin(d) + y * cos(d)
		double newY = offsetX * Math.sin(d) + offsetY * Math.cos(d);
		
		// Translate new points back to original center
		newX += c.x;
		newY += c.y;
		
		// Assign new coordinates to new Point
		Point rotatedPoint = new Point();
		rotatedPoint.x = newX;
		rotatedPoint.y = newY;
		
		return rotatedPoint;
	}
}