package lecture11.standard.shapes;

public class Circle implements IShape {
	private double radius;
	private double area = -1;
	private double circumference = -1;
	
	public Circle(double radius) {
		this.radius = radius;
	}
	
	public double getArea() {
		if (area == -1)
			area = Math.PI * radius * radius;
		return area;
	}
	
	public double getPerimeter() {
		if (circumference == -1)
			circumference = 2 * Math.PI * radius;
		return circumference;
	}
	
	public double getRadius() {
		return radius;
	}
}
