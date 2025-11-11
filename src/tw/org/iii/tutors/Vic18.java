package tw.org.iii.tutors;

import tw.org.iii.myclass.Bike;

public class Vic18 {

	public static void main(String[] args) {
		Bike mybike = new Bike();
		Bike urbike = new Bike("blue");

		mybike.upSpeed();
		mybike.upSpeed();
		mybike.upSpeed();
		mybike.downSpeed();
		urbike.upSpeed();
		urbike.upSpeed();
		urbike.downSpeed();

		System.out.println(mybike.getSpeed());
		System.out.println(urbike.getSpeed());

		do {
			mybike.upSpeed();
		} while (mybike.getSpeed() < 10);

		System.out.println(mybike.getSpeed());

		while (urbike.getSpeed() < 10) {
			urbike.upSpeed();
		}
		System.out.println(urbike.getSpeed());

		System.out.println(urbike.getColor());

//		String name = null;
//		System.out.println(name);
		
		System.out.println(mybike.getColor());
		mybike.changeColor(null);
		System.out.println(mybike.getColor());

	}

}
