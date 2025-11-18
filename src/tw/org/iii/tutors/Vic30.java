package tw.org.iii.tutors;

import java.util.HashSet;
import java.util.TreeSet;

public class Vic30 {

	/**
	 * java.util => Interfaces => Collection<E> 
	 * // Collection 中，可以指定元素的型別(泛型) 
	 * // public interface Set<E> extends Collection<E>
	 * // 介面可以繼承(extends)，且可允許extends多個；但 class 類別的繼承(extends) 只允許一個
	 * // Interface Set<E>為介面，可透過HashSet、TreeSet實作 
	 * // HashSet特性：裡面的元素「不會重複」，「沒有順序性」 
	 * // TreeSet特性：裡面的元素「不會重複」，「有順序性」
	 */

	public static void main(String[] args) {
		// 預設的 HashSet<E> 中，若沒加上<E>指定的元素類別，則元素視為Object
		HashSet set = new HashSet<>();
		set.add(123); // 指定的元素為 int 基本型別，這邊會 autoboxing，會自動將 int 型別的值轉換成 Integer 物件。
		set.add("Vic");
		set.add(12.3);
		System.out.println(set.size()); // size = 3

		set.add(123);
		System.out.println(set.size()); // size = 3，因set元素「不會重複」

		set.add(321);
		System.out.println(set.size()); // size = 4

		System.out.println(set.toString()); // [Vic, 321, 12.3, 123]，set中的元素順序與輸入的順序不同 => set「沒有順序性」

		// ======== 實作應用 ========
		// ===== 使用 HashSet =====
		HashSet<Integer> lotto1 = new HashSet<>();
		while (lotto1.size() < 6) {
			lotto1.add((int) (Math.random() * 49 + 1));
		}
		System.out.println(lotto1); // 此時會產生 不重複的號碼，但「不具順序性」- [48, 21, 45, 30, 14, 31]

		// ===== 使用 TreeSett =====
		TreeSet<Integer> lotto2 = new TreeSet<>();
		while (lotto2.size() < 6) {
			lotto2.add((int) (Math.random() * 49 + 1));
		}
		System.out.println(lotto2); // 此時會產生 不重複的號碼，且「具順序性」- [2, 5, 32, 38, 39, 41]
		
		// ===== 逐一尋訪 =====
		/* 陣列專用for迴圈
		 * for(declaration : expression)
			{
			   ...
			}
		 * */
		for(Integer i: lotto2 ) {
			System.out.println(i);
		}
	}

}

//簽名功能
//1. 要有簽名板 => component 繼承觀念
//2. 抓取在簽名板上的 drag 位置資訊 (x, y)
//3. 儲存點位置的資料結構