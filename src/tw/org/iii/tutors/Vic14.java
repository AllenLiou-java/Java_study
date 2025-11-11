package tw.org.iii.tutors;

public class Vic14 {

	public static void main(String[] args) {
		// 繦诀玻ネ1~6计狡玻ネ100Ωだ参璸瞷Ω计
		int p1,p2,p3,p4,p5,p6;
		p1=p2=p3=p4=p5=p6=0;
		
		for(int i=0; i<100; i++) {
			int p = (int) (Math.random()*6+1);
			
			switch (p) {
				case 1: p1++; break;
				case 2: p2++; break;
				case 3: p3++; break;
				case 4: p4++; break;
				case 5: p5++; break;
				case 6: p6++; break;
			}
		}
		
		System.out.printf("计%d瞷%dΩ\n", 1, p1);
		System.out.printf("计%d瞷%dΩ\n", 2, p2);
		System.out.printf("计%d瞷%dΩ\n", 3, p3);
		System.out.printf("计%d瞷%dΩ\n", 4, p4);
		System.out.printf("计%d瞷%dΩ\n", 5, p5);
		System.out.printf("计%d瞷%dΩ\n", 6, p6);
	}

}
