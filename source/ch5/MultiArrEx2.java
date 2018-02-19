import java.util.*;

class MultiArrEx2 {
	public static void main(String[] args) {
		final int SIZE = 5;
		int x = 0 , y = 0;
		int num = 0;

		int[][] bingo = new int[SIZE][SIZE];
		Scanner scanner = new Scanner(System.in);

		// 배열의 모든 요소를 1부터 SIZE*SIZE까지의 숫자로 초기화
		for(int i=0;i<SIZE;i++) {
			for(int j=0;j<SIZE;j++) {
				bingo[i][j] = i*SIZE + j + 1;
			}
		}

		// 배열에 저장된 값을 뒤섞는다.(shuffle)
		for(int i=0;i<SIZE;i++) {
			for(int j=0;j<SIZE;j++) {
				x = (int)(Math.random() * SIZE);
				y = (int)(Math.random() * SIZE);

				// bingo[i][j]와 임의로 선택된 값(bingo[x][y])을 바꾼다.
				int tmp =  bingo[i][j];
				bingo[i][j] = bingo[x][y];
				bingo[x][y] = tmp;
			}
		}

		do {
			for(int i=0;i<SIZE;i++) {
				for(int j=0;j<SIZE;j++)
					System.out.printf("%2d ", bingo[i][j]);	
				System.out.println();
			}
			System.out.println();
		
			System.out.printf("1~%d의 숫자를 입력하세요.(종료:0)>", SIZE*SIZE);
			String tmp = scanner.nextLine(); // 화면에서 입력받은 내용을 tmp에 저장
			num = Integer.parseInt(tmp);     // 입력받은 문자열(tmp)를 숫자로 변환

			// 입력받은 숫자와 같은 숫자가 저장된 요소를 찾아서 0을 저장
			outer:
			for(int i=0;i<SIZE;i++) {
				for(int j=0;j<SIZE;j++) {
					if(bingo[i][j]==num) {
						bingo[i][j] = 0;
						break outer; // 2중 반복문을 벗어난다.
					}
				}
			}
		} while(num!=0); 
	} // main의 끝
}
