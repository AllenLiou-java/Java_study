package tw.org.iii.tutors;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Vic44 {

	public static void main(String[] args) {
		Vic443 obj = new Vic443();
		try {
			// 資料序列化
			ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream("dir1/test.object"));
			
			oout.writeObject(obj);
			oout.flush();
			oout.close();
			
			System.out.println("----------------");
			
			// 資料解序列化
			ObjectInputStream oin = new ObjectInputStream(new FileInputStream("dir1/test.object"));
			Vic443 s1 = (Vic443)oin.readObject();
			oin.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}

class Vic441 {
	Vic441() {
		System.out.println("Vic441()");
	}
}

class Vic442 extends Vic441 {
	Vic442() {
		System.out.println("Vic442()");
	}
}

class Vic443 extends Vic442  implements Serializable{
	Vic443() {
		System.out.println("Vic443()");
	}
}


/* 1. 輸出結果
 *  當 Vic443 implements Serializable時，輸出結果
 *  
 *  Vic441()
	Vic442()
	Vic443()
	----------------
	Vic441()
	Vic442()
 * 
 * */ 

// 虛線上半段的結果： 因為在io過程，會先將祖宗八代全部叫近來，建構出物件實體
// 虛線下半段的為解序列化的執行階段：因為Vic443以實作 Serializable，因為父類別與祖父類別皆未實作 Serializable，
// 為了讓祖宗八代都進來，解序列化後會想辦法將祖宗八代加進來


/* 2. 輸出結果
*  當 Vic442 implements Serializable時，輸出結果
*  
*  Vic441()
	Vic442()
	Vic443()
	----------------
	Vic441()
* 
* */ 

/* 3. 輸出結果
*  當 Vic441 implements Serializable時，輸出結果
*  
*  Vic441()
	Vic442()
	Vic443()
	----------------
* 
* */ 
