import java.util.*;
import java.text.*;

class MessageFormatEx1 {
	public static void main(String[] args) {
		String msg = "Name: {0} \nTel: {1} \nAge:{2} \nBirthday:{3}";

		Object[] arguments = {
			"¿Ã¿⁄πŸ","02-123-1234", "27", "07-09"
		};

		String result = MessageFormat.format(msg, arguments);
		System.out.println(result);
	}
}
