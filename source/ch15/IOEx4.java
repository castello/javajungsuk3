import java.io.*;
import java.util.Arrays;	

class IOEx4 {
	public static void main(String[] args) {
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;

		byte[] temp = new byte[4];

		ByteArrayInputStream  input  = null;
		ByteArrayOutputStream output = null;

		input  = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();

		try {
			while(input.available() > 0) {
				int len = input.read(temp); // 읽어 온 데이터의 개수를 반환한다.
				output.write(temp, 0, len); // 읽어 온 만큼만 write한다.
			}
		} catch(IOException e) {}

		outSrc = output.toByteArray();

		System.out.println("Input Source  :" + Arrays.toString(inSrc));
		System.out.println("temp          :" + Arrays.toString(temp));
		System.out.println("Output Source :" + Arrays.toString(outSrc));
	}
}
