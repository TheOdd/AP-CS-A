package lecture11.standard.shapes;

/*
 * Standard Exercise
 * Shapes
 * 
 * Define an interface for (2-D) Shapes which should include, at minimum, a method for getting the
 * area and a method for getting the perimeter. Write classes for (at minimum) Triangle, Circle,
 * Parallelogram, and Rectangle. Use subclasses where logical (even if somewhat trivial in this example).
 */

public interface IShape {
	public double getArea();
	public double getPerimeter();
}
