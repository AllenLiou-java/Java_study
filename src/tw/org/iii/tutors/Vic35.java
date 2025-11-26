package tw.org.iii.tutors;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Vic35 {

	// OutputStream
	// OutputStream 為抽象類別，其中有一抽象方法 write()，每次寫一個byte的資料出去

	public static void main(String[] args) {

		// 系統是依據使用者的工作路徑來解釋相對路徑
		File here = new File("dir1");
		// 取得File物件中抽象路徑名稱的絕對路徑
		System.out.println(here.getAbsolutePath());
		// 驗證檔案是否存在
		System.out.println(here.exists() ? "OK1" : "XX");

		// ========== 建立資料夾 & 目錄 ==========

		// File.mkdir() 建立檔案夾
		File dir2 = new File("dir2");
		if (!dir2.exists()) {
			dir2.mkdir();
		}

		// File.mkdirs() 一起幫忙建立父檔案夾
		File dir3 = new File("dir2/dir3");
		if (!dir3.exists()) {
			dir2.mkdirs();
		}

		// 建構式也可以拋出例外(錯誤)
		// 以下須注意Exception的順序，因為 IOException 為 FileNotFoundException父類別，所以IOException 應放最後面捕捉例外
		
		String mesg = "Hello, World!\n1234567\n7654321\n";
		try {
			// FileOutputStream開關之間，檔案就已被建立了
			// 檔案內容的附加（添加）資料，在檔案開啟串流時就要先決定，
			// 也就是new FileOutputStream(“dir1/vic.txt”, true) 時，參見api的建構式第二個參數 boolean append。
			FileOutputStream fout = new FileOutputStream("dir1/Vic.txt", true);
			fout.write(mesg.getBytes());
			// 關閉串流之前，必須先flush
			fout.flush();
			// output的資料出去後記得要close
			fout.close();
			System.out.println("OK2");
		} catch (FileNotFoundException e) {
			System.out.println(e.toString());
		} catch (IOException e) {
			System.out.println(e.toString());
		}

	}

}
