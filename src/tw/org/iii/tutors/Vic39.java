package tw.org.iii.tutors;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Vic39 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		try {
			FileInputStream fin = new FileInputStream("dir1/landscape.jpg");
			FileOutputStream fout = new FileOutputStream("dir2/landscape.jpg");
			// 在read&write過程中，read快write慢，所以當write越多次，執行時間越耗時
			
			// 每次讀 1byte，總執行時間相當耗時
//			int b;
//			while((b = fin.read()) != -1) {
//				fout.write(b);
//			}
			
			// 每次讀 1MB並寫入，效率較高 (處理檔案>2GB 的狀況)
			byte[] buf = new byte[1024*1024]; // 1MB buffer
			int len;
			
			while((len=fin.read(buf)) != -1) {
				// 每次wrtie時，都根據read length的空間
				fout.write(buf, 0, len);
			}
			
			fout.flush();
			fout.close();
			fin.close();
			System.out.println("ok-" + (System.currentTimeMillis()-start) + "ms");
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}

	}

}
