package tw.org.iii.tutors;

public class Vic07 {

	public static void main(String[] args) {
		//	0 ~ 100 隨機產生，共101個整數值	
		int intScore = (int) (Math.random()*101);
		System.out.println(intScore);
		
		if(intScore >= 90) {
			System.out.println("A組");
		} else if (intScore >= 80) {
			System.out.println("B組");
		}else if (intScore >= 70) {
			System.out.println("C組");
		}else if (intScore >=60) {
			System.out.println("D組");
		} else {
			System.out.println("F組");
		}
	}

}
