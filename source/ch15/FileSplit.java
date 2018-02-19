import java.io.*;

class FileSplit {
	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("USAGE : java FileSplit filename SIZE_KB");
			System.exit(0); // 프로그램을 종료한다.
		}

		final int VOLUME = Integer.parseInt(args[1]) * 1000;

		try {
			String filename = args[0];

			FileInputStream     fis = new FileInputStream(filename);
			BufferedInputStream bis = new BufferedInputStream(fis);

			FileOutputStream     fos = null;
			BufferedOutputStream bos = null;

			int data = 0;
			int i = 0;
			int number = 0;

			while((data = bis.read()) != -1) {
				if (i%VOLUME==0) {
					if (i!=0) {
						bos.close();
					}

					fos = new FileOutputStream(filename + "_."+ ++number);
					bos = new BufferedOutputStream(fos);
				}
				bos.write(data);
				i++;
			}

			bis.close();
			bos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	// end of try-catch
	} // end of main
} // end of class FileSplit
