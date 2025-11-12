package tw.org.iii.myclass;

// 透過extends來繼承Bike類別
public class BikeV2 extends Bike {
	// 所有類別都一定會有建構式
	// 若類別未定義建構式，編譯器會從父類別中「無傳參數的建構式」拿來給子類別使用
	// 若父類別沒有「無傳參數的建構式」，則子類別需要自己建立
	// 建構式中的第一道敘述句，不是super()就是this

	// 屬性初始化有兩種方式：
	// 1.宣告時直接給值
	// 2.透過建構式初始化
	private int gear; // 0

	public BikeV2() {
//		 super();	//隱含呼叫父類別的屬性
		super("Green"); // 指定要呼叫的父類別建構式 - 帶引數string的建構式
		gear = 1;
	}

	public void addGear() {
		if (gear < 3)
			gear++;
	}

	public void minusGear() {
		if (gear > 1)
			gear--;
	}

	// override 改寫父類別中同名 的方法
	public void upSpeed() {
		// warning：使用來自父類別的屬性，此屬性若設定private，則子類別無法使用
		// 故須將父類別的speed屬性存取修飾字改成 protected
		
		// 1. 將父類別發揚光大 - 直接使用父類別的upSpeed方法，並進一步改寫
//		 super.upSpeed();
//		 speed *= gear;
		
		// 2. 直接抹煞父類別 - 直接將父類別的upSpeed方法改寫
		speed = speed < 1 ? 1 : speed * 1.2*gear;
		
		//以上兩種寫法觀念不同
	}

	/*
	 * ｜修飾字		｜存取範圍					｜ 
	 * ————————————————————————————————————————————— 
	 * ｜public		｜未限制						｜ 
	 * ｜protected	｜相同package或繼承的子類別	｜ 
	 * ｜未寫		｜相同package下				｜ 
	 * ｜private		｜相同類別					｜
	 */
}
