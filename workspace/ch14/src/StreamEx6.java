import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

class StreamEx6 {
	public static void main(String[] args) {
		Student3[] stuArr = {
			new Student3("이자바", 3, 300),
			new Student3("김자바", 1, 200),
			new Student3("안자바", 2, 100),
			new Student3("박자바", 2, 150),
			new Student3("소자바", 1, 200),
			new Student3("나자바", 3, 290),
			new Student3("감자바", 3, 180)	
		};

		// 학생 이름만 뽑아서 List<String>에 저장
		List<String> names = Stream.of(stuArr).map(Student3::getName)
									          .collect(Collectors.toList());
		System.out.println(names);

		// 스트림을 배열로 변환
		Student3[] stuArr2 = Stream.of(stuArr).toArray(Student3[]::new);

		for(Student3 s : stuArr2)
			System.out.println(s);

		// 스트림을 Map<String, Student3>로 변환. 학생 이름이 key 
		Map<String,Student3> stuMap = Stream.of(stuArr)
						                   .collect(Collectors.toMap(s->s.getName(), p->p));
		for(String name : stuMap.keySet())
			System.out.println(name +"-"+stuMap.get(name));
		
		long count = Stream.of(stuArr).collect(counting());
		int totalScore = Stream.of(stuArr)
                               .collect(summingInt(Student3::getTotalScore));
		System.out.println("count="+count);
		System.out.println("totalScore="+totalScore);

		totalScore = Stream.of(stuArr)
			               .collect(reducing(0, Student3::getTotalScore, Integer::sum));
		System.out.println("totalScore="+totalScore);

		Optional<Student3> topStudent = Stream.of(stuArr)
		                                     .collect(maxBy(Comparator.comparingInt(Student3::getTotalScore)));
		System.out.println("topStudent="+topStudent.get());

		IntSummaryStatistics stat = Stream.of(stuArr)
					                      .collect(summarizingInt(Student3::getTotalScore));
		System.out.println(stat);

		String stuNames = Stream.of(stuArr)
							    .map(Student3::getName)
							    .collect(joining(",", "{", "}"));
		System.out.println(stuNames);
	}
}

class Student3 implements Comparable<Student> {
	String name;
	int ban;
	int totalScore;

	Student3(String name, int ban, int totalScore) { 
		this.name =name;
		this.ban =ban;
		this.totalScore =totalScore;
	}

	public String toString() { 
	   return String.format("[%s, %d, %d]", name, ban, totalScore).toString(); 
	}

	String getName() { return name;}
	int getBan() { return ban;}
	int getTotalScore() { return totalScore;}

	public int compareTo(Student s) {
		return s.totalScore - this.totalScore;
	}
}
