package practice;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import configuration.ChromeConfigure;


public class Timeout {

	public static void main(String[] args) {
		ChromeConfigure d =new ChromeConfigure();
		d.chromeConfigure();
		WebDriver driver=new ChromeDriver();
		//ҳ����س�ʱʱ������Ϊ 5s
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.get("http://www.baidu.com/");
		
		//��λ����ʱ�� 10s ��ʱ��, ��� 10s �ڻ���λ�������׳��쳣 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		driver.findElement(By.id("kw33")).sendKeys("selenium");
		//�첽�ű��ĳ�ʱʱ�����ó� 3s 
		driver.manage().timeouts().setScriptTimeout(3, TimeUnit.SECONDS);
	}

}
