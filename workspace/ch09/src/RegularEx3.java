import java.util.regex.*;	// Pattern과 Matcher가 속한 패키지

class RegularEx3{
	public static void main(String[] args) {
		String source  = "HP:011-1111-1111, HOME:02-999-9999 ";
		String pattern = "(0\\d{1,2})-(\\d{3,4})-(\\d{4})";

		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(source);

		int i=0;

		while(m.find()) {
			System.out.println( ++i + ": " + m.group() + " -> "+ m.group(1) +", "+ m.group(2)+", "+ m.group(3));		
		}
	} // main의 끝
}
