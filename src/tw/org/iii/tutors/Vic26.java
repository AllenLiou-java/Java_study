package tw.org.iii.tutors;

public class Vic26 {

	public static void main(String[] args) {
		Monster1 m1 = new Monster1();
		Monster2 m2 = new Monster2();
		Boss b1 = new Boss();
		
		toBoyDie(m1);

	}
	
	// 在此類別建立 static 方法 - toBoyDie，此方法的參數只要有實作Monster介面的類別皆可
	static void toBoyDie(Monster monster) {
		monster.fireGoodBoy();
		System.out.println("OK");
	}

}

// 使用interface 訂定monster的規格 - 擁有fireGoodBoy方法
interface Monster {
	void fireGoodBoy();
}

// Monster1類別 實作 interface介面
class Monster1 implements Monster {

	@Override
	public void fireGoodBoy() {
		System.out.println("Monster1:fire");
	}

}

//Monster2類別 實作 interface介面
class Monster2 implements Monster {

	@Override
	public void fireGoodBoy() {
		System.out.println("Monster2:fire");
	}

}

//Boss類別 實作 interface介面
class Boss implements Monster {

	@Override
	public void fireGoodBoy() {
		System.out.println("Boss:fire");
	}

}
