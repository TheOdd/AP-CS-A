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

public class Main {
	public static void main(String[] args) {
		Vector3 a = new Vector3(1, 2, 3);
		Vector3 b = new Vector3(10, 15, 20);
		
		System.out.println("Vector a: " + a);
		System.out.println("Vector b: " + b);
		System.out.print("\n");
		
		System.out.println("Cross-product of a and b: " + b.crossProduct(a));
		System.out.println("Dot-product of a and b: " + b.dotProduct(a));
		System.out.println("Vector a + Vector b: " + a.add(b));
		System.out.println("Vector a scaled to have a magnitude of 6: " + a.toLength(6));
		System.out.println("Vector b scaled to have a magnitude of 6: " + b.toLength(6));
		System.out.println("Unit Vector of a: " + a.getUnitVector());
		System.out.println("Unit Vector of b: " + b.getUnitVector());
		System.out.println("Vector b projected onto Vector a: " + b.projectOnto(a));
		System.out.println("Vector a projected onto Vector b: " + a.projectOnto(b));
		System.out.println("The angle between a and b is: " + a.angleWith(b) + " radians");
	}
}
