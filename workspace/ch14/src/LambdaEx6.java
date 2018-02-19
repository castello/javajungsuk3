import java.util.function.*;
import java.util.*;

class LambdaEx6 {
	public static void main(String[] args) {
		IntSupplier  s = ()-> (int)(Math.random()*100)+1;
		IntConsumer  c = i -> System.out.print(i+", "); 
		IntPredicate p = i -> i%2==0; 
		IntUnaryOperator op = i -> i/10*10; // i의 일의 자리를 없앤다.

		int[] arr = new int[10];

		makeRandomList(s, arr);
		System.out.println(Arrays.toString(arr));
		printEvenNum(p, c, arr);
		int[] newArr = doSomething(op, arr);
		System.out.println(Arrays.toString(newArr));
	}

	static void makeRandomList(IntSupplier s, int[] arr) {
		for(int i=0;i<arr.length;i++) {
			arr[i] = s.getAsInt();  // get()이 아니라 getAsInt()임에 주의
		}
	}

	static void printEvenNum(IntPredicate p, IntConsumer c, int[] arr) {
		System.out.print("[");
		for(int i : arr) {
			if(p.test(i))
				c.accept(i);
		}	
		System.out.println("]");
	}

	static int[] doSomething(IntUnaryOperator op, int[] arr) {
		int[] newArr = new int[arr.length];

		for(int i=0; i<newArr.length;i++) {
			newArr[i] = op.applyAsInt(arr[i]); // apply()가 아님에 주의
		}	

		return newArr;
	}
}
