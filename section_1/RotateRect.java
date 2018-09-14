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
		double bottomLeft[] = {Double.parseDouble(args[3]), Double.parseDouble(args[2])};
		double topRight[] = {Double.parseDouble(args[1]), Double.parseDouble(args[0])};
		double topLeft[] = {Double.parseDouble(args[3]), Double.parseDouble(args[0])};
		double bottomRight[] = {Double.parseDouble(args[1]), Double.parseDouble(args[2])};
		double angle = Double.parseDouble(args[4]);
		
		// Calculate center
		double center[] = {((topRight[0] + bottomLeft[0]) / 2), ((topRight[1] + bottomLeft[1]) / 2)};
		
		// Apply rotation to all four points
		bottomLeft = rotate(bottomLeft, angle, center);
		topRight = rotate(topRight, angle, center);
		topLeft = rotate(topLeft, angle, center);
		bottomRight = rotate(bottomRight, angle, center);
		
		// Print results
		System.out.println("Point order is (in terms of original positions): bottom left, top left, top right, bottom right.");
		
		printPoint(bottomLeft);
		printPoint(topLeft);
		printPoint(topRight);
		printPoint(bottomRight);
	}
	
	// Helper method to print each point
	static void printPoint(double[] point) {
		System.out.println("(" + String.format("%.2f", point[0]) + ", " + String.format("%.2f", point[1]) + ")");
	}
	
	// Method that does the math for rotating points
	private static double[] rotate(double[] point, double d, double[] center) {
		// The math (trig functions) for rotation about a center assumes counter-clockwise rotation in radians
		d = Math.toRadians(360 - d);
		
		// Assign arguments to individual variables
		double x = point[0];
		double y = point[1];
		double cx = center[0];
		double cy = center[1];
		
		// Translate points to be centered around origin
		double offsetX = x - cx;
		double offsetY = y - cy;
		
		// Calculate x position as if it were rotating around origin
		// newX = x * cos(d) - y * sin(d)
		double newX = offsetX * Math.cos(d) - offsetY * Math.sin(d);
		
		// Calculate y position as if it were rotating around origin
		// newY = x * sin(d) + y * cos(d)
		double newY = offsetX * Math.sin(d) + offsetY * Math.cos(d);
		
		// Translate new points back to original center
		newX += cx;
		newY += cy;
		
		return new double[] {newX, newY};
	}
}