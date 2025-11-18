package tw.org.iii.tutors;

import java.util.LinkedList;

// Interface List<E>
// ArrayList =>運用JAVA 陣列原理，適用元素變動低時，效能較好
// LinkedList => 適用元素變動高時，效能較好

public class Vic31 {

	public static void main(String[] args) {
		// LinkedList 元素值「可重複」、「有順序性」
		LinkedList<String> list1 = new LinkedList<>();
		list1.add("Vic");
		list1.add("Eric");
		list1.add("Vic");
		list1.add("Amy");
		
		System.out.println(list1); // [Vic, Eric, Vic, Amy]
		
		// 反序儲存資料
		LinkedList<String> list2 = new LinkedList<>();
		list2.add(0,"Vic");
		list2.add(0,"Eric");
		list2.add(0,"Vic");
		list2.add(0,"Amy");
		
		System.out.println(list2); // [Amy, Vic, Eric, Vic]

	}

}
