package tw.org.iii.tutors;

import java.util.Arrays;

public class PokerV2 {

	public static void main(String[] args) {
//		隨機產生不重複的52個數字，並存成陣列，計算運算時間
//		使用do while
		int p[] = new int[5];
		int point;
		boolean isRepeat;

		for (int i = 0; i < p.length; i++) {

			do {
				point = (int) (Math.random() * 5 + 1);
				isRepeat = false;

				for (int j = 0; j < i; j++) {
					if (p[j] == point) {
						isRepeat = true;
						break;
					}
				}

			} while (isRepeat);

			p[i] = point;
			System.out.println(p[i]);

		}
		
		System.out.println("------");

	}

}
