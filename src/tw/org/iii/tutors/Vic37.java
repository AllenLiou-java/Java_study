package tw.org.iii.tutors;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Vic37 {
	// 若要讀中文，可將串流換成FileReader
	// FileReader(fileName) => 用Char、String方式讀取(讀取文字檔)
	// 讀取文字檔時會用到兩個物件
	// FileReader => fr = new FileReader(fileName)
	// BufferedReader => br = new BufferedReader(fr)
	public static void main(String[] args) {
		try {
			FileReader reader = new FileReader("dir1/Vic.txt");
			
			int r;			
			while((r = reader.read()) != -1) {
				System.out.print((char) r);
			}
			
			reader.close();
			System.out.println("OK");
		} catch (FileNotFoundException e) {
			System.out.println(e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e);
		}
		

	}

}
