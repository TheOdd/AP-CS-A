package lecture11.standard.shapes;

// a is side length, b is base length, height is in reference to b as bottom side

public class Parallelogram implements IShape {
	private double a, b, height;
	private double area = -1;
	private double perimeter = -1;
	
	public Parallelogram(double a, double b, double height) {
		this.a = a;
		this.b = b;
		this.height = height;
	}
	
	public double getArea() {
		if (area == -1)
			area = b * height;
		return area;
	}
	
	public double getPerimeter() {
		if (perimeter == -1)
			perimeter = 2 * (a + b);
		return perimeter;
	}
	
	public double getSide() {
		return a;
	}
	
	public double getBase() {
		return b;
	}
	
	public double getHeight() {
		return height;
	}
}
