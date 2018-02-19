import java.time.*;
import java.time.format.*;

class DateFormatterEx1 {
	public static void main(String[] args) {
		ZonedDateTime zdateTime = ZonedDateTime.now();

		String[] patternArr = {
				"yyyy-MM-dd HH:mm:ss",         
				"''yy년 MMM dd일 E요일", 	
				"yyyy-MM-dd HH:mm:ss.SSS Z VV",	
				"yyyy-MM-dd hh:mm:ss a",			
				"오늘은 올 해의 D번째 날입니다.",     	
				"오늘은 이 달의 d번째 날입니다.",     	
				"오늘은 올 해의 w번째 주입니다.",     	
				"오늘은 이 달의 W번째 주입니다.",     	
				"오늘은 이 달의 W번째 E요일입니다."   	
		};

		for(String p : patternArr) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(p);
			System.out.println(zdateTime.format(formatter));	
		}
	} // main의 끝
}
