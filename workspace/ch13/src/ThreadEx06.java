import javax.swing.JOptionPane;

class ThreadEx06 {
	public static void main(String[] args) throws Exception
	{
		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요."); 
		System.out.println("입력하신 값은 " + input + "입니다.");

		for(int i=10; i > 0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch(Exception e ) {}
		}
	}
}
