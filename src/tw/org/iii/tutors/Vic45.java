package tw.org.iii.tutors;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Vic45 {

	public static void main(String[] args) {
		try {
			InetAddress ip = InetAddress.getByName("192.168.0.191");

			System.out.println(ip.getHostName());
			System.out.println(ip.getHostAddress());
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
