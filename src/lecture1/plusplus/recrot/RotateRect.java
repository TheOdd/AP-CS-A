package lecture1.plusplus.recrot;

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
        // WS: simplify using constructor
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
        // WS: Points can now rotate themselves
        bottomLeft.rotate(angle, center);
        topRight.rotate(angle, center);
        topLeft.rotate(angle, center);
        bottomRight.rotate(angle, center);

        // Print results
        System.out.println("Point order is (in terms of original positions): bottom left, top left, top right, bottom right.");

        // WS: since these now return strings, we change the output pattern a little:
        System.out.println(bottomLeft.toString() 
                + "\n" + topLeft.toString() 
                + "\n" + topRight.toString() 
                + "\n" + bottomRight.toString());
    }
}
