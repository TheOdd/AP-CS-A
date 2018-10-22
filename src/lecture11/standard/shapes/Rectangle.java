package lecture11.standard.shapes;

public class Rectangle implements IShape {
	private double length, width;
	private double area = -1;
	private double perimeter = -1;
	
	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}
	
	public double getArea() {
		if (area == -1)
			area = length * width;
		return area;
	}
	
	public double getPerimeter() {
		if (perimeter == -1)
			perimeter = 2 * (width + length);
		return perimeter;
	}
	
	public double getLength() {
		return length;
	}
	
	public double getWidth() {
		return width;
	}
}
