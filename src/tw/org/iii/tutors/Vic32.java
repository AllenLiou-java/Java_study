package tw.org.iii.tutors;

public class Vic32 {

	public static void main(String[] args) {
		// try catch 說明
		// java.lang > Exceptions >Class Exception >Class Throwable >Class RuntimeException
		// 1. Class Exception的子類別中，只要是RuntimeException的子類別都是發生在執行階段，所以其編譯期間都pass。
			// 所以此種RuntimeException的錯誤拋出，方便開發者自訂錯誤處理。
		// 2. Class Exception的子類別中，除了RuntimeException的錯誤，其他的錯誤在編譯期間會顯示錯誤，必須事先錯誤處理。
		// 3. 若在try catch中若有多個錯誤，要注意catch error的順序，錯誤的類別越小，排序越前面。
		// 4. 若在處理過程不想細分錯誤類別的處置方式，可以直接使用 catch(Exception e) 承接所有的錯誤，統一進行處理。
		
		int[] a = new int[3];
		System.out.println(a[2]);
		
		// 執行以下將會出錯，出錯後程式不會再往下執行，所以不會print出 OK
		// ArrayIndexOutOfBoundsException 是 RuntimeException的子類別，所以不會強迫事先錯誤處理
//		System.out.println(a[3]);	// Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3

		//進行錯誤處理
		try {
			System.out.println(a[3]);
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Ooops!");
		}
		
		System.out.println("OK");
		
		
		// =====================================================
		
		// 建立Bird物件實體 
		Bird b1 = new Bird();
		// 因為setLeg方法「throws Exception」的錯誤 並非是RuntimeException，故需要先進行錯誤處理
		try {
			b1.setLeg(2);
		} catch(Exception e) {
			System.out.println("not bird!");
		}
		
		
		// =====================================================
		
		// 建立Cat物件實體
		Cat c1 = new Cat();
		// 因為setLeg方法「throws RuntimeException」的錯誤，故不用先進行錯誤處理
		c1.setLeg(4);
		
		
		// =====================================================
		// 若在try catch中若有多個錯誤，要注意catch error的順序，錯誤的類別越小，排序越前面。
		// 如果 catch(Exception e2) 放在最前面捕捉，則會發生錯誤，因為ArrayIndexOutOfBoundsException是 Exception子類別，
		// 所有錯誤類別會直接被 Exception捕捉
		
		try {
			System.out.println(a[3]);
			b1.setLeg(4);
		} catch(ArrayIndexOutOfBoundsException e1) {
			System.out.println("go wrong!");
		} catch(Exception e2) {
			System.out.println("i'm not a bird!");
		}
		
		// 若是不想細分錯誤類別，可以改成以下
		try {
			System.out.println(a[3]);
			b1.setLeg(4);
		} catch(Exception e) {
			System.out.println("go wrong, but not why!");
		}
	}

}

class Bird {
	int leg;
	
	// 若方法內部有 throw Exception物件，則再方法外記得加上 throws Exception
	void setLeg(int leg) throws Exception {
		if(leg>=0 && leg<=2) {
			this.leg = leg;
		}else {
			throw new Exception();
		}
	}
}

class Cat {
	int leg;
	
	// 若方法內部有 throw Exception物件，則再方法外記得加上 throws Exception
	void setLeg(int leg) throws RuntimeException {
		if(leg>=0 && leg<=4) {
			this.leg = leg;
		}else {
			throw new RuntimeException();
		}
	}
}
