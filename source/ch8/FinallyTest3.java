class FinallyTest3 {
	public static void main(String args[]) {
		// method1()은 static메서드이므로 인스턴스 생성없이 직접 호출이 가능하다.
		FinallyTest3.method1();		
        System.out.println("method1()의 수행을 마치고 main메서드로 돌아왔습니다.");
	}	// main메서드의 끝

	static void method1() {
		try {
			System.out.println("method1()이 호출되었습니다.");
			return;		// 현재 실행 중인 메서드를 종료한다.
		}	catch (Exception e)	{
			e.printStackTrace();
		} finally {
			System.out.println("method1()의 finally블럭이 실행되었습니다.");
		}
	}	// method1메서드의 끝
}
