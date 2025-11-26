package tw.org.iii.tutors;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Vic36 {
	// InputStream => 用Byte方式讀取(讀取影音檔或是圖檔)
	// InputStream 為抽象類別，其中有一抽象方法 read()，故需要開發者將其實作，因為有可能從記憶體或檔案讀取，怎麼讀由開發者依需求實作。

	// FileReader(fileName) => 用Char、String方式讀取(讀取文字檔)
	public static void main(String[] args) {

		/*
		 * 
		 * 
		 * try {
			 * 
			 * // read() 每次執行只讀 1byte的資料，若讀取中文字，則會發生錯誤 
			 * // int r; 
			 * // while((r = fin.read())!= -1) { System.out.print((char)r); }
			 * 
			 * 
			 * // 以下方法雖可用，但仍無法完全解決讀取中文問題(故不建議透過 FileInputStream 讀取文字檔)
			 * 
			 * FileInputStream fin = new FileInputStream("dir1/Vic.txt"); 
			 * byte[] buf = new byte[4]; 
			 * int len;
			 * 
			 * // 透過 read方法將fin資料讀進buf，根據buf初始位元組數來決定每次讀進buf的資料長度 
			 * while((len = fin.read(buf)) != -1) { System.out.print(new String(buf, 0, len)); }
			 * 
			 * 
			 * fin.close(); 
			 * System.out.println("OK"); 
		 * } 
		 * catch (FileNotFoundException e) {e.printStackTrace(); } 
		 * catch (IOException e) { e.printStackTrace(); }
		 * 
		 */
		
		//以上的解法：一次讀取
		File file = new File("dir1/Vic.txt");
		try {
			FileInputStream fin = new FileInputStream(file);
			
			// file.length() 回傳long資料，這邊強制轉型為int
			// 因為轉型為int，故buf的空間最大讀 2GB的檔案，若是超過2GB，則使用while迴圈
			/*
			 * int 最大正值 2147483647/1024/1024/1024 ≒ 2
			 * 1 Kilobyte (KB) = 1024 Bytes
			 * 1 Megabyte (MB) = 1024 KB
			 * 1 Gigabyte (GB) = 1024 MB
			 * */

			byte[] buf = new byte[(int) file.length()];	
			
			fin.read(buf);
			System.out.println(new String(buf));
			
			fin.close();
			System.out.println("OK");
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
		

	}

}
