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
        //WS: simplify using constructor
        Point bottomLeft = new Point(
            Double.parseDouble(args[3]),
            Double.parseDouble(args[2])
        );
        Point topRight = new Point(
            Double.parseDouble(args[1]),
            Double.parseDouble(args[0])
        );
        Point topLeft = new Point(bottomLeft.x, topRight.y);
        Point bottomRight = new Point(topRight.x, bottomLeft.y);
        double angle = Double.parseDouble(args[4]);

        // Calculate center
        Point center = new Point(
            (topRight.x + bottomLeft.x) / 2,
            (topRight.y + bottomLeft.y) / 2
        );
		
        // Apply rotation to all four points
        //WS: Points can now rotate themselves
        bottomLeft.rotate(angle, center);
        topRight.rotate(angle, center);
        topLeft.rotate(angle, center);
        bottomRight.rotate(angle, center);

        // Print results
        System.out.println("Point order is (in terms of original positions): bottom left, top left, top right, bottom right.");

        //WS: since these now return strings, we change the output pattern a little:
        System.out.println(bottomLeft.toString() 
                + "\n" + topLeft.toString() 
                + "\n" + topRight.toString() 
                + "\n" + bottomRight.toString());
    }
	
	// Helper class to store point data and a method for printing the coordinates.
    //WS: in general, we won't want to nest classes inside classes like this or put multiple classes in one file - okay for today
    public static class Point {
        //WS: use constructor to speed up initialization
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
        
        //WS: might be useful to be able to clone a point as well
        public Point(Point p) {
            x = p.x;
            y = p.y;
        }

        double x, y;

        //WS: return a string rather than teach Point how to interact one specific way; we'll just update its toString() method
        @Override
        public String toString() {
                return "(" + String.format("%.2f", this.x) + ", " + String.format("%.2f", this.y) + ")";
        }
        
        //WS: new function to add two points together to simplify rotation code
        void add(Point p) {
            x += p.x;
            y += p.y;
        }
        
        //WS: this function is now part of each Point object and updates its own values
        void rotate(double d, Point c) {
		// The math (trig functions) for rotation about a center assumes counter-clockwise rotation in radians
		d = Math.toRadians(360 - d);
		
		//WS: Create new point based on original, offset by the offset
                Point result = new Point(x, y);
                result.add(new Point(-c.x, -c.y));
                
                
		//WS: Do rotation calculations in place
		// Calculate x position as if it were rotating around origin
		// newX = x * cos(d) - y * sin(d)
		// Calculate y position as if it were rotating around origin
		// newY = x * sin(d) + y * cos(d)
                result = new Point(result.x * Math.cos(d) - result.y * Math.sin(d),
                    result.x * Math.sin(d) + result.y * Math.cos(d));
		
		// Translate new points back to original center
		result.add(c);
		
		// Assign new coordinates to new Point
		x = result.x;
                y = result.y;
	}
    }
}