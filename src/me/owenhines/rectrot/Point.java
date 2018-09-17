package me.owenhines.rectrot;

// Helper class to store point data and a method for printing the coordinates.
public class Point {
    // WS: use constructor to speed up initialization
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // WS: might be useful to be able to clone a point as well
    public Point(Point p) {
        x = p.x;
        y = p.y;
    }

    double x, y;

    // WS: return a string rather than teach Point how to interact one specific way; we'll just update its toString() method
    @Override
    public String toString() {
        return "(" + String.format("%.2f", this.x) + ", " + String.format("%.2f", this.y) + ")";
    }

    // WS: new function to add two points together to simplify rotation code
    void add(Point p) {
        x += p.x;
        y += p.y;
    }

    // WS: this function is now part of each Point object and updates its own values
    void rotate(double d, Point c) {
        // The math (trig functions) for rotation about a center assumes counter-clockwise rotation in radians
        d = Math.toRadians(360 - d);

        // WS: Create new point based on original, offset by the offset
        Point result = new Point(x, y);
        result.add(new Point(-c.x, -c.y));


        // WS: Do rotation calculations in place
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
