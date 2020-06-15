package File;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileProcess {
	public int readFile(String[] arrInfo, String nameFile) throws Exception {
		File f1 = new File("./" + nameFile);
		// f1.createNewFile();

		FileReader fr = new FileReader(f1);
		BufferedReader br = new BufferedReader(fr);
		String tmp;
		int count = 0;
		try {
			while ((tmp = br.readLine()) != null) {
				arrInfo[count] = tmp;
				// System.out.println(tmp);
				count++;
			}

		} catch (Exception e) {
			e.printStackTrace();
			fr.close();
			br.close();
			return -1;
		}
		fr.close();
		br.close();

		return count;
	}

	public boolean writeFile(String[] arrInfo, int number, String nameFile) throws Exception {
		File f2 = new File(nameFile);
		FileWriter fw = new FileWriter(f2);

		try {
			for (int i = 0; i < number; i++)
				fw.write(arrInfo[i] + "\n");
		} catch (Exception e) {
			e.printStackTrace();
			fw.close();
			return false;
		}

		fw.close();
		return true;
	}

	public boolean writeFile(String str, String nameFile) throws Exception {
		File f2 = new File(nameFile);
		FileWriter fw = new FileWriter(f2, true);
		try {
			fw.write(str + "\n");
		} catch (Exception e) {
			e.printStackTrace();
			fw.close();
			return false;
		}

		fw.close();
		return true;
	}
}
