@FunctionalInterface
interface MyFunction {
	void myMethod();
}

class Outer {
	int val=10;	// Outer.this.val				

	class Inner {
		int val=20;	// this.val

		void method(int i) {  // 	void method(final int i) {
			int val=30; // final int val=30;
//			i = 10;      // 에러. 상수의 값을 변경할 수 없음.

			MyFunction f = () -> {
				System.out.println("             i :" + i);
				System.out.println("           val :" + val);
				System.out.println("      this.val :" + ++this.val);
				System.out.println("Outer.this.val :" + ++Outer.this.val);	
			};

			f.myMethod();
		}
	} // Inner클래스의 끝
} // Outer클래스의 끝

class LambdaEx3 {
	public static void main(String args[]) {
		Outer outer = new Outer();
		Outer.Inner inner = outer.new Inner();
		inner.method(100);
	}
}
