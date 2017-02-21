package baidu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import configuration.ChromeConfigure;

public class Baidu {

	public static void baiduTest(String testdate) {
		configuration.ChromeConfigure d = new ChromeConfigure();
		d.chromeConfigure();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.baidu.com");
		driver.findElement(By.id("kw")).sendKeys(testdate);
		;
		driver.findElement(By.id("su")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.close();
	}

	public static void readTxtFile(String filePath) {
		String encoding = "GBK";
		String lineTxt = null;
		try {
			File file = new File(filePath);
			if (file.isFile() && file.exists()) {// �ж��ļ��Ƿ����

				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// ���ǵ������ʽ
				BufferedReader bufferedReader = new BufferedReader(read);//�Ѷ�ȡ�����ݻ�������
				while ((lineTxt = bufferedReader.readLine()) != null) {
					System.out.println(lineTxt);
					baiduTest(lineTxt);
				}
				read.close();
			}else{
				System.out.println("�Ҳ���ָ�����ļ�");
			}
		} catch (IOException e) {
			System.out.println("��ȡ�ļ����ݴ���");
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		String filePath="TestDate/Baidudata.txt";
		readTxtFile(filePath);
	}
}
