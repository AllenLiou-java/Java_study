package tw.org.iii.tutors;

public class Vic23 {

	public static void main(String[] args) {
		// 等號左邊 宣告， 右邊 建立物件
		Vic233 obj1 = new Vic233();

		// 注意：不能使用interface來建立物件，因Vic233已實作Vic231的介面，固可透過Vic233來建立物件
		Vic231 obj2 = new Vic233();
		Vic232 obj3 = new Vic233();

		obj1.m1();
		obj2.m2();
		obj3.m3();

		// 直接實作介面
		Vic231 obj4 = new Vic231() {

			@Override
			public void m1() {

			}

			@Override
			public void m2() {

			}

		};
		obj4.m1();

		// 因obj2骨子裡為Vic233類別的物件，故可以強制轉型為Vic233
		Vic233 obj5 = (Vic233) obj2;
		obj5.m3();

	}

}

// ※注意：同一個檔案中，最外層只會有一個public，class名稱與檔名相同
// interface 都是public
// interface 主要是在訂規格，不進行實作，也沒有任何物件
// interface 沒有建構式，因為它並非用來建立物件的
// 即將實作interface的方法都是public
interface Vic231 {
	void m1();

	void m2();
}

interface Vic232 {
	void m3();

	void m4();
}

class Vic233 implements Vic231, Vic232 {

	@Override
	public void m1() {
		System.out.println("Vic233:m1()");
	}

	@Override
	public void m2() {
		System.out.println("Vic233:m2()");
	}

	@Override
	public void m3() {
		System.out.println("Vic233:m3()");
	}

	@Override
	public void m4() {
		System.out.println("Vic233:m4()");
	}

}
