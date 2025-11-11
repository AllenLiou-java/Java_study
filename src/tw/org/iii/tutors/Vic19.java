package tw.org.iii.tutors;

public class Vic19 {

	public static void main(String[] args) {
		String str1 = new String();
		byte[] b1 = { 97, 98, 99, 100 };
		String str2 = new String(b1);		// a,b,c,d
		String str3 = new String(b1, 1, 2);
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		
		String str4 = "Vic"; //透過給值，直接將值存在記憶體空間，所以不透過new，也可產生字串物件
		System.out.println(str2.charAt(2));
		System.out.println(str4.charAt(1));
	}

}
