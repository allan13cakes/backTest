package automation.file;

import java.io.BufferedReader;
import java.io.FileReader;

public class BufferedReaderClient {
	public static void main(String[] args) throws Exception {
		String filePath = "/Users/qiuguozhong/Downloads/数据/2000W酒店开房数据库/酒店开房数据库-A-0001-200W.csv";
		BufferedReaderClient client = new BufferedReaderClient();
		client.read(filePath);
	}
	
	public void read(String filePath) throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		String line = reader.readLine();
		System.out.println(line);
		reader.close();
	}
}
