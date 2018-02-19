class PointTest2 {
	public static void main(String argsp[]) {
		Point3D p3 = new Point3D();
		System.out.println("p3.x=" + p3.x);
		System.out.println("p3.y=" + p3.y);
		System.out.println("p3.z=" + p3.z);
	}
}

class Point {
	int x=10;	
	int y=20;

	Point(int x, int y) {

		this.x = x;
		this.y = y;
	}
}

class Point3D extends Point {
	int z=30;

	Point3D() {
		this(100, 200, 300);	// Point3D(int x, int y, int z)를 호출한다.
	}

	Point3D(int x, int y, int z) {
		super(x, y);			// Point(int x, int y)를 호출한다.
		this.z = z;
	}
}
