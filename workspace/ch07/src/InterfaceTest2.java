 class A2 {
    void autoPlay(I i) {
          i.play();
     }
 }

 interface I {
      public abstract void play();
 }

 class B2 implements I {
     public void play() {
          System.out.println("play in B class");
     }
 }

 class C2 implements I {
     public void play() {
          System.out.println("play in C class");
     }
 }

class InterfaceTest2 {
	public static void main(String[] args) {
		A2 a = new A2();
		a.autoPlay(new B2()); // void autoPlay(I i)호출
		a.autoPlay(new C2()); // void autoPlay(I i)호출
	}
}
