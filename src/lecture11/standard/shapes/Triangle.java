package lecture11.standard.shapes;

// Assumed to be equilateral

public class Triangle implements IShape {
	private double base, height;
	private double area = -1;
	private double perimeter = -1;
	
	public Triangle(double base, double height) {
		this.base = base;
		this.height = height;
	}
	
	public double getArea() {
		if (area == -1)
			area = 0.5 * base * height;
		return area;
	}
	
	public double getPerimeter() {
		if (perimeter == -1)
			perimeter = 3 * base;
		return perimeter;
	}
	
	public double getBase() {
		return base;
	}
	
	public double getHeight() {
		return height;
	}
}
