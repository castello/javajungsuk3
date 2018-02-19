import java.io.*;

class FileEx6 {
	static int found = 0;
	
	public static void main(String args[]) {
		if(args.length != 2) {
			System.out.println("USAGE : java FileEx6 DIRECTORY KEYWORD");
			System.exit(0);
		}

		File dir = new File(args[0]);
		String keyword = args[1];

		if(!dir.exists() || !dir.isDirectory()) {
			System.out.println("유효하지 않은 디렉토리입니다.");
			System.exit(0);
		} 

		try {
			findInFiles(dir, keyword);
		} catch(IOException e) {
			e.printStackTrace();
		}

		System.out.println();
		System.out.println("총 " + found + "개의 라인에서 '" + keyword + "'을/를 발견하였습니다. ");
	} // main

	public static void findInFiles(File dir, String keyword) throws IOException
     {
		File[] files = dir.listFiles();

		for(int i=0; i < files.length; i++) {
			if(files[i].isDirectory()) {
				findInFiles(files[i], keyword);
			} else {
				String filename  = files[i].getName();
				String extension = filename.substring(filename.lastIndexOf(".")+1);
				extension = "," + extension + "," ;

				if(",java,txt,bak,".indexOf(extension) == -1) continue;

				filename = dir.getAbsolutePath() + File.separator + filename;

				FileReader     fr = new FileReader(files[i]);
				BufferedReader br = new BufferedReader(fr);

				String data = "";
				int lineNum = 0;

				while((data=br.readLine())!=null) {
					lineNum++;
					if(data.indexOf(keyword)!=-1) {
						found++;
						System.out.println("["+filename+ "("+lineNum+")" + "]" + data);
					}
				} // while
				
				br.close();
			}
		} // for
	} // findInFiles
} // class
