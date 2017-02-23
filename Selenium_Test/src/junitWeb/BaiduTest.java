package junitWeb;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import configuration.ChromeConfigure;

public class BaiduTest {
	private WebDriver driver;
	private String baiduUrl;
	private StringBuffer verificationErrors=new StringBuffer();
	
	@Before
	public void setUp(){
		ChromeConfigure.chromeConfigure();
		driver=new ChromeDriver();
		baiduUrl="https://www.baidu.com/";
		//设定的浏览器的超时时间为 30 秒
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void testCase(){
		driver.get(baiduUrl+"/");
		driver.findElement(By.id("kw")).clear();
		driver.findElement(By.id("kw")).sendKeys("junit");
		driver.findElement(By.id("su")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String title=driver.getTitle();
		assertEquals(title,"junit_百度搜索");
	}
	
	@After
	public void tearDown(){
		driver.quit();
		String verificationErrorString=verificationErrors.toString();
		if(!"".equals(verificationErrorString)){
			fail(verificationErrorString);
		}
	}
}
