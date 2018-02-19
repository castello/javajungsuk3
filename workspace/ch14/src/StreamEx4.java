import java.util.*;
import java.util.stream.*;

class StreamEx4 {
	public static void main(String[] args) {

		Stream<String[]> strArrStrm = Stream.of(
			new String[]{"abc", "def", "jkl"},
			new String[]{"ABC", "GHI", "JKL"}
		);

//		Stream<Stream<String>> strStrmStrm = strArrStrm.map(Arrays::stream);
		Stream<String> strStrm = strArrStrm.flatMap(Arrays::stream);

		strStrm.map(String::toLowerCase)
			   .distinct()
			   .sorted()
			   .forEach(System.out::println);
		System.out.println();

		String[] lineArr = {
			"Believe or not It is true",
			"Do or do not There is no try",
		};

		Stream<String> lineStream = Arrays.stream(lineArr);
		lineStream.flatMap(line -> Stream.of(line.split(" +")))
				  .map(String::toLowerCase)
				  .distinct()
				  .sorted()
				  .forEach(System.out::println);
		System.out.println();

		Stream<String> strStrm1 = Stream.of("AAA", "ABC", "bBb", "Dd");
		Stream<String> strStrm2 = Stream.of("bbb", "aaa", "ccc", "dd");

		Stream<Stream<String>> strStrmStrm = Stream.of(strStrm1, strStrm2);

		Stream<String> strStream = strStrmStrm
									.map(s -> s.toArray(String[]::new))  
		    						.flatMap(Arrays::stream);
		strStream.map(String::toLowerCase)
				 .distinct()
				 .forEach(System.out::println);
	}
}
