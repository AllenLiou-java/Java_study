package tw.org.iii.tutors;

public class Vic09 {

	public static void main(String[] args) {
		/*
			++a，--a ：先進行自增或自減運算，再進行表達式運算
			a++，a-- ：先進行表達式運算，再進行自增或自減運算
		
			x 的運算過程：a+1 > 乘2 > 指定給x
			y 的運算過程：2*b > 指定給y > b+1

		*/
		
		int a = 5;
		int b = 5;
		int x = 2*++a;
		int y = 2*b++;
		System.out.println("a=" + a + ",x=" + x);
		System.out.println("b=" + b + ",y=" + y);
		
		
		int a1 = 10,  b1 = 3;
		if (--a1 >= 10 & b1-- <= 10) {
			System.out.println(
				String.format("true => a=%d,b=%d", a1, b1));
		}else {
			System.out.println(String.format("false => a=%d,b=%d", a1, b1));
		}
		
		int c = 2, d = 3;
		System.out.println(c ^ d);
	}

}
