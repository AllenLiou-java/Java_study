package tw.org.iii.tutors;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Vic42 {
	// 在進行資料的io時，先確認資料是否為 Serializable
	public static void main(String[] args) {
		try {
			Student s1 = new Student(100, 90, 80, "Vic");
			Student s2 = new Student(90, 80, 70, "Tina");
			ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream("dir1/vic.score"));
			
			oout.writeObject(s1);
			oout.writeObject(s2);
			oout.flush();
			oout.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}

// Serializable 介面無任何須實作的方法，直接 implements 即可
class Student implements Serializable {
	int ch, math, eng;
	// 加入物件型別資料
	String name;

	Student(int ch, int math, int eng, String name) {
		this.ch = ch;
		this.math = math;
		this.eng = eng;
		this.name = name;
	}

	int score() {
		return ch + math + eng;
	}

	double avg() {
		return score() / 3.0;
	}
	
	String getName() {
		return name;
	}
}

// 物件 & 物件內的屬性 都需要是 Serializable
// 因為 基本型別會 自動轉成物件，所以已是 Serializable


