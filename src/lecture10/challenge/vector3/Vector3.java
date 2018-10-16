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
		return new Vector3(this.getX() + v.getX(), this.getY() + v.getY(), this.getZ() + v.getZ());
	}
	
	public Vector3 crossProduct(Vector3 v) {
		double newX = this.getY() * v.getZ() - this.getZ() * v.getY();
		double newY = this.getZ() * v.getX() - this.getX() * v.getZ();
		double newZ = this.getX() * v.getY() - this.getY() * v.getX();
		
		return new Vector3(newX, newY, newZ);
	}
	
	public double dotProduct(Vector3 v) {
		return this.getX() * v.getX() + this.getY() * v.getY() + this.getZ() * v.getZ();
	}
	
	public Vector3 scalarProduct(double s) {
		return new Vector3(this.getX() * s, this.getY() * s, this.getZ() * s);
	}
	
	public Vector3 scale(double m) {
		double scaleFactor = m / this.getMagnitude();
		return this.scalarProduct(scaleFactor);
	}
	
	public Vector3 getUnitVector() {
		return this.scale(1);
	}
	
	public Vector3 project(Vector3 v) {
		return v.getUnitVector().scalarProduct(this.dotProduct(v));
	}
	
	public String toString() {
		return "[" + this.getX() + ", " + this.getY() + ", " + this.getZ() + "]";
	}
}
