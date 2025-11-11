package tw.org.iii.tutors;

import java.util.Scanner;

public class Vic08 {

	public static void main(String[] args) {
		/*
		 	判斷閏年｜平年
			閏年規則
			除以 4 能整除，且除以 100 不能整除
			如果剛好是 100 的倍數，且除以 400 能整除
		 */
		
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("請輸入年分：");
		int year = scanner.nextInt();
		
		if (year % 4 == 0) {
			if(year % 100 == 0) {
				if(year % 400 ==0) {
					System.out.println("閏-29");
				} else {
					System.out.println("平-28");
				}
			} else {
				System.out.println("閏-29");
			}
		} else {
			System.out.println("平-28");
		}
	}

}
