package tw.org.iii.tutors;

import javax.swing.JFrame;

public class Vic22 extends JFrame {
	// 若未建立建構式，編譯器會自動從父類別取「無參數建構式」
	public Vic22() {
		// super(); 隱含super
		
		// 直接super父類別的「帶參數建構式」
		super("我的視窗程式");
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Vic22();

	}

}
