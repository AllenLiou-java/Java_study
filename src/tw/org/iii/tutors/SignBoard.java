package tw.org.iii.tutors;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import tw.org.iii.myclass.SignView;

public class SignBoard extends JFrame {
	private SignView signView;

	public SignBoard() {
		super("Ã±¦WªO");
		setSize(640, 480);

		setLayout(new BorderLayout());

		signView = new SignView();
		add(signView, BorderLayout.CENTER);

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new SignBoard();

	}

}
