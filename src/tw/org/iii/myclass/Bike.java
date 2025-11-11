package tw.org.iii.myclass;

public class Bike {
	// 擁有 屬性、方法
	private double speed;
	private String color;

	//	建構式名稱與 class名稱相同
	//	建構式主要負責物件的初始化，在執行之前物件已產生
	public Bike() {
		color = "yellow";
	}

	public Bike(String color) {
		if (color != null) {
			this.color = color;
		} else {
			this.color = "yellow";
		}
	}

	public void upSpeed() {
		speed = speed < 1 ? 1 : speed * 1.2;
	}

	public void downSpeed() {
		speed = speed < 1 ? 0 : speed * 0.7;
	}

	public double getSpeed() {
		return speed;
	}

	public String getColor() {
		return color;
	}

	public void changeColor(String newColor) {
		if (newColor != null) {
			color = newColor;
		}

	}
}
