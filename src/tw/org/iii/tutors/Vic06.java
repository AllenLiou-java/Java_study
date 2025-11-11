package tw.org.iii.tutors;

public class Vic06 {

	public static void main(String[] args) {
		//	0 ~ 100 隨機產生，共101個整數值	
		int intScore = (int) (Math.random()*101);
		System.out.println(intScore);
		System.out.println(intScore>=60?"Pass":"Down");
	}

}
