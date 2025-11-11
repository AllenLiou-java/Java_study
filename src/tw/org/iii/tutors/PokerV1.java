package tw.org.iii.tutors;

import java.util.Arrays;

public class PokerV1 {

	public static void main(String[] args) {
//		隨機產生不重複的52個數字，並存成陣列，計算運算時間

		long start = System.currentTimeMillis();

		int p[] = new int[52];
		int point;
		boolean isRepeat;

		for (int i = 0; i < p.length; i++) {
			point = (int) (Math.random() * 52 + 1);

//			check repeat
			isRepeat = false;
			for (int j = 0; j < i; j++) {
				if (p[j] == point) {
					isRepeat = true;
					break;	// 強迫跳離迴圈
				}
			}

			if (isRepeat) {
				i--;
			} else {
				p[i] = point;
				System.out.println(p[i]);
			}

		}

		System.out.println("------");
		System.out.println(System.currentTimeMillis() - start);
	}

}
