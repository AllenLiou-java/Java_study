package tw.org.iii.tutors;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Vic40 {
	// 一次讀，速度較快
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		File file = new File("dir1/landscape.jpg");
		
		try {
			FileInputStream fin = new FileInputStream(file);
			byte[] buf = new byte[(int)file.length()];
			fin.read(buf);
			fin.close();
			
			FileOutputStream fout = new FileOutputStream("dir2/test.jpg");
			fout.write(buf);
			fout.flush();
			fout.close();
			System.out.println("ok-" + (System.currentTimeMillis()-start) + "ms");
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}

	}

}
