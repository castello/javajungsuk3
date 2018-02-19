class ExceptionEx14 {
	public static void main(String[] args) {
		try  {
				method1();		
		} catch (Exception e)	{
				System.out.println("main메서드에서 예외가 처리되었습니다.");
				e.printStackTrace();
		}
	}	// main메서드의 끝

	static void method1() throws Exception {
		throw new Exception();
	}	// method1()의 끝
} // class의 끝
