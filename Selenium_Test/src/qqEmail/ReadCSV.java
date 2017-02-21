package qqEmail;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import com.csvreader.CsvReader;

public class ReadCSV {
	public static void readTxtFile(String filePath){
		ArrayList<String[]> csvList=new ArrayList<String[]>();
		try {
			CsvReader reader=new CsvReader(filePath,',',Charset.forName("SJIS"));
			reader.readHeaders();//跳过表头 如果需要表头的话，不要写这句.
			while(reader.readRecord()){//逐行读入除表头的数据
				csvList.add(reader.getValues());
			}
			reader.close();		

			for(int row=0;row<csvList.size()-1;row++){
				String username=(csvList.get(row)[0]);
				String password=(csvList.get(row)[1]);
				String password2=(csvList.get(row)[2]);
				System.out.println(username+'-'+password+'-'+password2);
				LoginQq.driver(username, password, password2);
			}
		} catch (FileNotFoundException e) {
			System.out.println("找不到指定的文件");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("读取文件内容错误");
			e.printStackTrace();	
		}
	}
}