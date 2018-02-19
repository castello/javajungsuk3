import java.awt.*;
import java.awt.event.*;

class  InnerEx8 {
	public static void main(String[] args) {
		Button b = new Button("Start");
		b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("ActionEvent occurred!!!");
				}
			} // 익명 클래스의 끝
		);
	} // main메서드의 끝
} // InnerEx8클래스의 끝
