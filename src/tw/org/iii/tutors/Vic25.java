package tw.org.iii.tutors;

import tw.org.iii.myclass.TWId;

public class Vic25 {

	public static void main(String[] args) {
		TWId id1 = TWId.createTWId("A123456789");
		TWId id2 = TWId.createTWId("A123456789");

		// 因TWId 有override toString方法 - 將id回傳
		// 故 print出的 id1 與 id2 都是 A123456789
		System.out.println(id1);
		System.out.println(id2);

		// id1 與 id2 記憶體位址不同，故此時印出false
		System.out.println(id1 == id2);

		// 因TWId 有override equals方法 - 將兩物件中的 id值進行比對
		// 故此時印出 true
		System.out.println(id1.equals(id2));

	}

}
