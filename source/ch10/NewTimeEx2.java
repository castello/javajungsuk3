import java.time.*;
import java.time.temporal.*;

class NewTimeEx2 {
	public static void main(String[] args) {
		LocalDate date = LocalDate.of(2015, 12, 31); // 2015년 12월 31일
		LocalTime time = LocalTime.of(12,34,56);     // 12시 23분 56초

		// 2015년 12월 31일 12시 23분 56초
		LocalDateTime dt  = LocalDateTime.of(date, time);
	
		ZoneId zid = ZoneId.of("Asia/Seoul");
		ZonedDateTime zdt = dt.atZone(zid);
//		String strZid = zdt.getZone().getId();

		ZonedDateTime seoulTime = ZonedDateTime.now();
		ZoneId nyId = ZoneId.of("America/New_York");
	     ZonedDateTime nyTime = ZonedDateTime.now().withZoneSameInstant(nyId);

		// ZonedDatetime -> OffsetDateTime
		OffsetDateTime odt = zdt.toOffsetDateTime();

		System.out.println(dt);
		System.out.println(zid);
		System.out.println(zdt);
		System.out.println(seoulTime);
		System.out.println(nyTime);
		System.out.println(odt);
	}
}
