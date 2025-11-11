package tw.org.iii.tutors;

import java.util.Arrays;

public class Vic13 {

	public static void main(String[] args) {
		int[] a;
		a = new int[3];
		
		System.out.println(a);		// 列印出 陣列的位址
		System.out.println(Arrays.toString(a));		// 陣列轉成字串後列印
		
		
		for(int i=0; i<a.length; i++) {
			System.out.println(a[i]);
		}
		
		System.out.println("------");
		
		a[2] = 123;
		for(int i=0; i<a.length; i++) {
			System.out.println(a[i]);
		}
		
		System.out.println("------");
		
		a = new int[4];
		for(int i=0; i<a.length; i++) {
			System.out.println(a[i]);
		}
		
		
		
		//	靜態初始化
		char[] c = new char[] {'h','e','l','l','o'};
		System.out.println(c);
		System.out.println(c.length);
		
		char[] c2 = {'h','e','l','l','o'};
		System.out.println(c2);
		System.out.println(c2.length);
		
		//	動態初始化
		char[] c3 = new char[5];
		c3[0] = 'h';
		c3[1] = 'e';
		c3[2] = 'l';
		c3[3] = 'l';
		c3[4] = 'o';
		
		System.out.println(c3);
		System.out.println(c3.length);
		
		//	=============== Arrays常用的方法 ===============
		//	1) Arrays.toString(陣列名)
		int[] d = new int[3];
		System.out.println(Arrays.toString(d));		// 陣列轉成字串後列印
		
		//	2) Arrays.sort(陣列名)   將陣列中的元素進行排列(從小到大)
		int[] d2 = new int[] {21, 25, 98, 64, 71};
		Arrays.sort(d2);
		System.out.println(Arrays.toString(d2));
		
		// 3) Arrays.copyOf(陣列名, 新的長度)      // 需要複製一個新陣列時使用
		int[] d3 = {1, 2, 3, 4, 5, 6};
		
		int[] d31 = Arrays.copyOf(d3, 10);
		System.out.println(Arrays.toString(d31));
		
		int[] d32 = Arrays.copyOf(d3, 3);
		System.out.println(Arrays.toString(d32));
		
	}

}
