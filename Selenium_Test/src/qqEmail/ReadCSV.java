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
			reader.readHeaders();//������ͷ �����Ҫ��ͷ�Ļ�����Ҫд���.
			while(reader.readRecord()){//���ж������ͷ������
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
			System.out.println("�Ҳ���ָ�����ļ�");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("��ȡ�ļ����ݴ���");
			e.printStackTrace();	
		}
	}
}