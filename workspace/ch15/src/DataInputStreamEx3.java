import java.io.*;

class DataInputStreamEx3 {
	public static void main(String args[]) {
		int sum   = 0;
		int score = 0;

		try (FileInputStream fis = new FileInputStream("score.dat");
		     DataInputStream dis = new DataInputStream(fis)) 
		{
			
			while(true) {
				score = dis.readInt();
				System.out.println(score);	
				sum += score;
			}
		} catch (EOFException e) {
			System.out.println("점수의 총합은 " + sum +"입니다.");
		} catch (IOException ie) {
			ie.printStackTrace();
		} // try
	} // main
}
