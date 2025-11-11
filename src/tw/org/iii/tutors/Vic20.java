package tw.org.iii.tutors;

import tw.org.iii.myclass.TWId;

public class Vic20 {

	public static void main(String[] args) {
		// 說明1
		// String 物件一旦建構式給值完成後，字串物件的內容就不能被改變
		// 當 "Vic" 建立後，記憶體(pool)中會檢查是否有 "Vic"存在，若沒有，則建立 "Vic"物件，並將位址指向給s1
		// 若再建立相同的 "Vic"物件時，因記憶體(pool)中已存在，則會將原本就存在的 "Vic"物件的位址傳給s2
		// 所以 s1 == s2
		String s1 = "Vic";
		String s2 = "Vic";
		System.out.println(s1 == s2);

		System.out.println("比較字串物件是否相同");
		// 若透過 new String 給定一樣的值 "Vic"，此時會在記憶體建立一個新空間存取，故在將值傳遞給s3時，因為此「字串物件」是新建立的，故s1 !=
		// s3
		String s3 = new String("Vic");
		System.out.println(s1 == s3);

		// 同理s4是新建立的「字串物件」，故s3 != s4
		String s4 = new String("Vic");
		System.out.println(s3 == s4);

		// 若是要比較「字串內容」是否相同，可以使用 String.equals()
		System.out.println("比較字串內容是否相同");
		System.out.println("s1 == s3? " + s1.equals(s3));
		System.out.println("s3 == s4? " + s3.equals(s4));

		System.out.println("兩個等號 == ，比較基本型別是否相同");
		System.out.println(".equals方法，比較值是否相同");

		// 說明2
		System.out.println("---------");
		String b1 = new String("Vic"); // 建立新的字串物件
		String b2 = b1; // 將以建立的字串物件傳給b2
		b1 = "BBB"; // 再 String pool中建立 "BBB"，並將位址傳給b1
		System.out.println(b1 == b2); // 所以 兩者不同(指向的位址不同)

		// 說明3
		System.out.println("---------");
		// 透過字串方法，仍不能改變原本內容
		String c1 = new String("Vic");
		c1.concat("Liou");
		System.out.println(c1); // 此時c1的值仍未改變
		// 主要原因是concat會return 新的字串內容，而不是改變原始字串物件
		String c2 = c1.concat("Liou");
		System.out.println(c2);

		// 若要變更字串，會使用StringBuffer、StringBuilder

		// 說明4
		System.out.println("---------");

		
		TWId id1 = new TWId();
		TWId id2 = new TWId(false);
		TWId id3 = new TWId(1);
		TWId id4 = new TWId(false,1);
		
		System.out.println(id1.getId());
		System.out.println(id2.getId());
		System.out.println(id3.getId());
		System.out.println(id4.getId());
		
		TWId id = TWId.createTWId("X111934909");
		System.out.println(id.getId());

	}

}
