package tw.org.iii.tutors;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Vic43 {

	public static void main(String[] args) {
		try {
			ObjectInputStream oin = new ObjectInputStream(new FileInputStream("dir1/vic.score"));
//			Object obj = oin.readObject();
			Student s1 = (Student)oin.readObject();
			Student s2 = (Student)oin.readObject();
			oin.close();
			
			System.out.println(s1.getName() + ":" + s1.score() + ":" + s1.avg());
			System.out.println(s2.getName() + ":" +s2.score() + ":" + s2.avg());
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
