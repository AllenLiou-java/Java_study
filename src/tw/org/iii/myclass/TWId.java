package tw.org.iii.myclass;

public class TWId {
	private String id;

	// 為了讓建構式 與 isRightId同時都能使用letters，故將此提取出來
	// 因letters存在於{...}的作用域中，且不允許被變更，故設定private
	// 為了能讓 isRightId 內部使用letters，須加上static
	private static String letters = "ABCDEFGHJKLMNPQRSTUVXYWZIO";

	// 建立多個建構式(overloading )，此方式便於維護
	// 目標：透過建構式初始化物件時，就產生一組有效的 id

	public TWId() {
		this((int) (Math.random() * 2 + 1) == 1);
	}

	public TWId(boolean isMale) {
		this(isMale, (int) (Math.random() * 26));
	}

	public TWId(int area) {
		this((int) (Math.random() * 2 + 1) == 1, area);
	}

	// 使用最多引數的建構子 產生 id的邏輯
	// 在物件中都可以呼叫 static 方法，如同 任何時候都能呼叫 Math.random()
	public TWId(boolean isMale, int area) {
		/*
		 * String temp = letters.substring(area, area+1); temp += isMale? "1":"2";
		 * 以上此種寫法每產生一碼，就會變更一次字串，這種方式在JAVA中會一直佔有記憶體空間，進而影響效能，不太建議這樣寫。 因為會一直變更字串內容，故建議使用
		 * StringBuffer
		 */

		// super()
		StringBuffer sb = new StringBuffer(letters.substring(area, area + 1));
		sb.append(isMale ? "1" : "2");

		// 隨機產生第 3~9 碼
		for (int i = 0; i < 7; i++) {
			sb.append((int) (Math.random() * 10));
		}

		// 產生最後一碼，且要符合編碼規則
		for (int i = 0; i < 10; i++) {
			String temp = sb.toString();
			if (isRightId(temp + i)) {
				this.id = temp + i;
				break;
			}
		}

	}

	// 此建構式的內容是直接將引數指定給物件屬性，若是宣告為public，則外部都能隨意變更物件屬性，此情況將不被允許，故要變更為private
	private TWId(String id) {
		this.id = id;
	}

	public static TWId createTWId(String id) {
		TWId temp = null;
		if (isRightId(id)) {
			temp = new TWId(id);
		}
		return temp;
	}

	public String getId() {
		return id;
	}

	// static 不需要new 物件實體即可呼叫使用，例如：Math.random()
	public static boolean isRightId(String id) {
		boolean ret = false;
//		String letters = "ABCDEFGHJKLMNPQRSTUVXYWZIO";
		if (id.matches("[A-Z][12][0-9]{8}")) {

			char c1 = id.charAt(0);
			int n12 = letters.indexOf(c1) + 10; // isRightId方法為static，因在執行時該類別的物件尚未產生，故無法呼叫到letters，除非letters設定為static
			int n1 = n12 / 10;
			int n2 = n12 % 10;
//			System.out.printf("%d:%d\n", n1, n2);

			int n3 = Integer.parseInt(id.substring(1, 2));
			int n4 = Integer.parseInt(id.substring(2, 3));
			int n5 = Integer.parseInt(id.substring(3, 4));
			int n6 = Integer.parseInt(id.substring(4, 5));
			int n7 = Integer.parseInt(id.substring(5, 6));
			int n8 = Integer.parseInt(id.substring(6, 7));
			int n9 = Integer.parseInt(id.substring(7, 8));
			int n10 = Integer.parseInt(id.substring(8, 9));
			int n11 = Integer.parseInt(id.substring(9, 10));

			int n = n1 * 1 + n2 * 9 + n3 * 8 + n4 * 7 + n5 * 6 + n6 * 5 + n7 * 4 + n8 * 3 + n9 * 2 + n10 * 1 + n11 * 1;
//			System.out.println(n);

			return n % 10 == 0;
		}
		return ret;
	}

	@Override
	public String toString() {

		return id;
	}

	@Override
	public boolean equals(Object obj) {
		return this.getId().equals(((TWId) obj).getId());
	}

}
