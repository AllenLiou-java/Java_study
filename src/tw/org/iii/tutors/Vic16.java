package tw.org.iii.tutors;

public class Vic16 {

	public static void main(String[] args) {
		int a[][] = new int[2][];
		a[0] = new int[3];
		a[1] = new int[4];

		a[0][2] = 123;
		a[1][1] = 111;

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.printf("%d\t", a[i][j]);
			}
			System.out.println();
		}

	}

}
