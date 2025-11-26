package tw.org.iii.tutors;

public class Vic34 {

	public static void main(String[] args) {
//		Vic342 obj1 = new Vic342();
//		Vic342 obj2 = new Vic342();
		
		Vic341.m1();
	}

}

// 在執行建構式以前，物件已經存在，所以建構式主要是將已產生的物件進行初始化。
// class 裡面分兩類 「有 static」、「無 static」
// 「有 static」- 屬於該類別共有的，不需要物件即可呼叫，所以無法存取物件裡的屬性(如下方： static 無法存取物件的 a 變數)
// 「無 static」 - 需建立物件實體後，才可呼叫的屬性與方法
class Vic341 {
	int a = 10;
	{
		System.out.println("Vic341:{ }" + a);
	}
	static {
		System.out.println("static Vic341:{ }");
	}
	Vic341(){
		System.out.println("Vic341()");
	}
	static void m1(){
		System.out.println("static:m1()");
	}
}

class Vic342 extends Vic341 {
	{
		System.out.println("Vic342:{ }" + a);
	}
	static {
		System.out.println("static Vic342:{ }");
	}
	Vic342(){
		//super
		System.out.println("Vic342()");
	}
}
