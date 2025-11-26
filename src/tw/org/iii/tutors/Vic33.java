package tw.org.iii.tutors;

import java.io.File;
import java.io.IOException;

public class Vic33 {
	// 1. 檔案系統存取
	// 2. 資料庫
	// 3. TCP/UDP/HTTP
	public static void main(String[] args) {
		// java.io > Class File 
		// 
		/* 路徑使用方式，以下兩種皆可
		 * 1.使用跳脫字元 => D:\\Vic Documents\\Java\\Vic.txt
		 * 2.採用Linux寫法 => D:/Vic Documents/Java/Vic.txt
		 * */ 
		
		// 即使檔案不存在，File物件仍可以建立
		File f1 = new File("D:/Vic Documents/Java/Vic2.txt");
		if(f1.exists()) {
			System.out.println("OK");
		}else {
			System.out.println("XX");
			
			// 在編譯前提示有可能會拋出錯誤(此錯誤非RuntimeException)，所以需事先做錯誤處理
			// f1.createNewFile();
			/*
			 * createNewFile() 方法
			 * 回傳 true if the named file does not exist and was successfully created; false if the named file already exists
			 * */
			
			try {
				// 建立新檔
				f1.createNewFile();
			} catch(IOException e) {
				System.out.println("IOException");
			}
			
		}
		

	}

}
