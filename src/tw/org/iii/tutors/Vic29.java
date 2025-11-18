package tw.org.iii.tutors;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Vic29 extends JFrame {
	JButton b1, b2, b3;
	JTextArea textArea;

	public Vic29() {

		setSize(640, 480);

		setLayout(new BorderLayout());

		JPanel top = new JPanel(new FlowLayout());
		b1 = new JButton("B1");
		b2 = new JButton("B2");
		b3 = new JButton("B3");
		top.add(b1);
		top.add(b2);
		top.add(b3);

		add(top, BorderLayout.NORTH);

		textArea = new JTextArea();
		add(textArea, BorderLayout.CENTER);

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		initEvent();
	}

	// 將事件觸發獨立出來
	private void initEvent() {
		// TODO 設定按鈕監聽
		MyListener myListener = new MyListener();
		b1.addActionListener(myListener);
		b2.addActionListener(myListener);
		b3.addActionListener(myListener);

		// 同一物件可允許加上多個 addActionListener, 以下透過閉包方式直接實作ActionListener介面
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 將要執行的對應事件獨立在外，方便管理
				clickB1();
			}
		});
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 將要執行的對應事件獨立在外，方便管理
				clickB2();

			}
		});

		// 在 textArea物件上加上滑鼠事件 MouseListener、MouseMotionListener
		// 因為 MouseListener、MouseMotionListener 都是介面，若要使用這些介面，則必須實作該介面下的所有方法(共7個方法)
		// 此時 可以透過抽象類別 - MouseAdapter 來實作此兩介面的部分方法
		// 抽象類別皆有實作指定的介面，但實作的方法的內容都是空的，此時開發者可以透過子類別繼承並override指定的方法
		MyMouseListener listener = new MyMouseListener();
		textArea.addMouseListener(listener);
		textArea.addMouseMotionListener(listener);

	}

	// 建立內部類別
	private class MyMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			// Override 主要是將父類別的方法發揚光大，但因父類別為抽象類別，方法的內部是空的，故此地方的super有或沒有都一樣
//			super.mouseClicked(e);
			System.out.println("mouseClicked");
		}

		@Override
		public void mouseDragged(MouseEvent e) {
//			super.mouseDragged(e);
			System.out.println("mouseDragged_" + e.getX() + "x" + e.getY());
		}
	}

	private void clickB1() {
		System.out.println("clickB1");
	}

	private void clickB2() {
		System.out.println("clickB2");
	}

	// 類別中的類別，也擁有類別修飾字
	private class MyListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// 取得按鈕名稱
			System.out.println(e.getActionCommand());

			// 取得事件觸發的timestamp
			System.out.println(e.getWhen());

			// getSource取得將事件初始化的物件
			Object obj = e.getSource();
			if (obj == b1) {
				System.out.println("B1 get");
			} else if (obj == b2) {
				System.out.println("B2 get");
			} else if (obj == b3) {
				System.out.println("B3 get");
			}

		}

	}

	public static void main(String[] args) {
		new Vic29();

	}

}
