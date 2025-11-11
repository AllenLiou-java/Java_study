package tw.org.iii.tutors;

public class Vic15 {

	public static void main(String[] args) {
		int p[] = new int[6];
		for (int i = 0; i < 10; i++) {
			int point = (int) (Math.random() * 9); // 0-8
			System.out.println(point);
			p[point >= 6 ? point - 3 : point]++;
		}

		for (int i = 0; i < p.length; i++) {
			System.out.printf("點數%d出現%d次\n", i, p[i]);
		}

	}

}
