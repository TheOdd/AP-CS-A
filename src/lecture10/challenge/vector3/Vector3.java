package lecture10.challenge.vector3;

/*
 * Challenge Exercise
 * Vector3
 * 
 * Write a Vector class with the following specifications:
 * 
 * Include normal vector operations for 3-vectors, including cross product. The cross product of two vectors is another vector.
 * a cross b = ||a|| ||b|| sin(theta) n, where theta is angle between a and b, and n is unit normal vector perpendicular to both
 * a and b. (a1, a2, a3) cross (b1, b2, b3) = (a2 b3 - a3 b2, a3 b1 - a1 b3, a1 b2 - a2 b1). Note that |a cross b| = area of the
 * parallelogram with sides a and b. Cross product arises in definition of torque, angular momentum and vector operator curl.
 * 
 */

public class Vector3 {
	private double x, y, z;
	private double magnitude = -1;
	
	public Vector3(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getZ() {
		return z;
	}
	
	public double getMagnitude() {
		if (magnitude == -1)
			magnitude = Math.sqrt(x * x + y * y + z * z);
		return magnitude;
	}
	
	public Vector3 add(Vector3 v) {
		return new Vector3(x + v.x, y + v.y, z + v.z);
	}
	
	public Vector3 crossProduct(Vector3 v) {
		double newX = z * v.y - y * v.z;
		double newY = x * v.z - z * v.x;
		double newZ = y * v.x - x * v.y;
		
		return new Vector3(newX, newY, newZ);
	}
	
	public double dotProduct(Vector3 v) {
		return x * v.x + y * v.y + z * v.z;
	}
	
	public Vector3 scale(double s) {
		return new Vector3(x * s, y * s, z * s);
	}
	
	public Vector3 toLength(double m) {
		double scaleFactor = m / getMagnitude();
		return scale(scaleFactor);
	}
	
	public Vector3 getUnitVector() {
		return toLength(1);
	}
	
	public Vector3 projectOnto(Vector3 v) {
		return v.getUnitVector().scale(dotProduct(v));
	}
	
	public double angleWith(Vector3 v) {
		return Math.acos(dotProduct(v) / (getMagnitude() * v.getMagnitude()));
	}
	
	public String toString() {
		return "[" + x + ", " + y + ", " + z + "]";
	}
}
