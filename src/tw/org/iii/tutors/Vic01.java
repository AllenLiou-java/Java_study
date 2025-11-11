package tw.org.iii.tutors;

public class Vic01 {

	public static void main(String[] args) {
		// byte, short, int, long
		// byte： 2^8 => -128 ~ 127
		// short：2^16 => -32768 ~ 32767
		// int：2^32 => 
		// long：2^64 => 
		
		short var1;
		var1 = -129;
		System.out.println(var1);
		
		byte var2 = 123;
		System.out.println(var2);
		
		//	指數值後面加上一個大寫L，否則會報錯
		long num=32967359818L;
		System.out.println("num="+num);

	}

}
