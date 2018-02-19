class OperatorEx29 {
	public static void main(String[] args) {
		byte p =  10;
		byte n = -10;

		System.out.printf(" p  =%d \t%s%n",  p,   toBinaryString(p));
		System.out.printf("~p  =%d \t%s%n", ~p,   toBinaryString(~p));
		System.out.printf("~p+1=%d \t%s%n", ~p+1, toBinaryString(~p+1));
		System.out.printf("~~p =%d \t%s%n", ~~p,  toBinaryString(~~p));
		System.out.println();
		System.out.printf(" n  =%d%n",  n);	
		System.out.printf("~(n-1)=%d%n", ~(n-1));
	} // main의 끝

	// 10진 정수를 2진수로 변환하는 메서드
	static String toBinaryString(int x) {
		String zero = "00000000000000000000000000000000";
		String tmp = zero + Integer.toBinaryString(x);

		return tmp.substring(tmp.length()-32);
	}
}
