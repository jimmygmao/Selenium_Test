package junitWeb;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import configuration.ChromeConfigure;

public class YoudaoTest {
	private WebDriver driver;
	private String youdaoUrl;
	private StringBuffer verificationErrors=new StringBuffer();
	
	@Before
	public void setUp(){
		ChromeConfigure.chromeConfigure();
		driver=new ChromeDriver();
		youdaoUrl="http://www.youdao.com/";
		//�趨��������ĳ�ʱʱ��Ϊ 30 ��
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void testCase(){
		driver.get(youdaoUrl+"/");
		driver.findElement(By.name("q")).clear();
		driver.findElement(By.id("translateContent")).sendKeys("junit");
		driver.findElement(By.xpath("//*[@id='form']/button")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String title=driver.getTitle();
		assertEquals(title,"��junit��ʲô��˼_Ӣ��junit�ķ���_����_����_�÷�_����_���߷���_�е��ʵ�");
		driver.findElement(By.xpath("/html/body/div[7]/i/a[1]")).click();
	}
/*	@After
	public void tearDown(){
		driver.quit();
		String verificationErrorString=verificationErrors.toString();
		if(!"".equals(verificationErrorString)){
			fail(verificationErrorString);
		}
	}*/
}
