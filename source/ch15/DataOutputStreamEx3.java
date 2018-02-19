import java.io.*;

class DataOutputStreamEx3 {
	public static void main(String args[]) {
		int[] score = { 100, 90, 95, 85, 50 }; 

		try {
			FileOutputStream fos = new FileOutputStream("score.dat");
			DataOutputStream dos = new DataOutputStream(fos);

			for(int i=0; i<score.length;i++) {
				dos.writeInt(score[i]);				
			}

			dos.close();
		} catch (IOException e) {
			e.printStackTrace();		
		}
	} // main
}
