package tw.org.iii.tutors;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GuessNumber extends JFrame implements ActionListener {
	private JButton guess;
	private JTextField input;
	private JTextArea log;
	private String answer;
	private int counter;
	private int d = 3;

	public GuessNumber() {
		super("GuessNumber Game");

		// 1.配置版面
		setLayout(new BorderLayout());

		guess = new JButton("Guess");
		input = new JTextField();
		log = new JTextArea();

		add(log, BorderLayout.CENTER);

		JPanel topLine = new JPanel(new BorderLayout());
		topLine.add(input, BorderLayout.CENTER);
		topLine.add(guess, BorderLayout.EAST);

		add(topLine, BorderLayout.NORTH);

		// 2.事件處理
		// 此處的this指的是，當下所處在的類別產生的物件實體
		guess.addActionListener(this);

		// 因為 GuessNumber繼承了 JFrame，所以可以直接使用JFrame的方法
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// 初始化 answer
//		answer = createAnswer(d);
//		System.out.println(answer);
		initGame();
		// 在查找API中的Font類別時，看到第一個protected建構式，直接判斷它不適用，因為protected存取範圍為相同package或繼承的子類別
		// 因為此處並沒有要繼承Font類別來使用
		log.setFont(new Font(null, Font.PLAIN, 48));
	}

	public static void main(String[] args) {
		new GuessNumber();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		counter++;
		// 1. 取input 文字
		String str = input.getText();

		// 2. input 文字加入 log (需保留前面加入的文字)
//		log.append(str + "\n");

		String result = checkAB(str);
		log.append(counter + "." + str + "=>" + result + "\n");

		// 3. 清空input
		input.setText("");

		if (result.equals(d + "A0B")) {
			JOptionPane.showMessageDialog(this, "恭喜猜中!");
			initGame();
		} else if (counter == 2) {
			JOptionPane.showMessageDialog(this, "Loser:" + answer);
			initGame();
		}

	}

	private String checkAB(String g) {
		// 方法內的變數為區域變數，故須先初始化
		int A, B;
		A = B = 0;

		for (int i = 0; i < g.length(); i++) {
			if (g.charAt(i) == answer.charAt(i)) {
				A++;
			} else if (answer.indexOf(g.charAt(i)) != -1) {
				B++;
			}
		}

		return String.format("%dA%dB", A, B);
	}

	private String createAnswer(int d) {
		// 指定位數，每位數均不重複
		int[] poker = new int[10];
		for (int i = 0; i < poker.length; i++) {
			poker[i] = i;
		}

		for (int i = 0; i < poker.length; i++) {
			int rand = (int) (Math.random() * (i + 1));
			// poker[rand] 與 poker[i]交換

			int temp = poker[rand];
			poker[rand] = poker[i];
			poker[i] = temp;
		}

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < d; i++) {
			sb.append(poker[i]);
		}

		return sb.toString();

	}
	
	private void initGame() {
		answer = createAnswer(d);
		counter = 0;
		input.setText("");
		log.setText("");
	}

}

// interface 的概念：訂定的規格
// implements 實作
// @Override 告訴編譯器正在改寫此方法
