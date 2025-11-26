package tw.org.iii.tutors;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Vic41 {

	public static void main(String[] args) {
		try {
			
			// 若需要解碼，則使用FileInputStream 和 InputStreamReader解碼
			// FileInputStream旨在讀取原始位元組流，例如影像資料。 若要讀取字元流，請考慮使用 FileReader。
			FileInputStream fin = new FileInputStream("dir1/mask.csv");
			// InputStreamReader 是位元組流到字元流的橋樑：它讀取位元組並使用指定的字元集將其解碼為字元charset。
			InputStreamReader ir = new InputStreamReader(fin, "UTF-8");
			// 為了獲得最佳效率，可以考慮將 InputStreamReader 封裝在 BufferedReader 中
			// 透過 BufferedReader的	readLine()，可整行讀取
			BufferedReader reader = new BufferedReader(ir);
			
			//若不需要解碼過程，則可以直接由 FileReader取代(業界寫法)
//			FileReader fr = new FileReader("dir1/mask.csv");
//			BufferedReader reader = new BufferedReader(fr);

			String line;
			while ((line = reader.readLine()) != null) {
				String[] rowData = line.split(",");
				System.out.println(rowData[2] + ":" + rowData[7]+ ":" + rowData[8]);
				
			}

			fin.close();
//			fr.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
