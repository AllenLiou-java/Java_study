package tw.org.iii.tutors;

import tw.org.iii.myclass.TWId;

public class Vic24 {

	public static void main(String[] args) {
		// 說明override
		Vic241 obj1 = new Vic241();
		
		System.out.println(obj1);
		System.out.println(obj1.toString());
		// 以上println的結果相同，也就是object有自動toString
		
		TWId id1 = new TWId(false);
		System.out.println(id1.getId());
		System.out.println(id1);

	}
}

class Vic241 {
	@Override
	public String toString() {
		return "Hello Vic";
	}
}
