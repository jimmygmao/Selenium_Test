package junitTest;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import configuration.ChromeConfigure;

public class Webdriver {
	//初始化定义私有变量 driver 为驱动，
	//baseUrl 为基本 URL 地址，
	//acceptNextAlert 表示是否继续接受下一个警告，初始化状态为 ture。
	//verificationErrors 用来存放错误的字符串变量
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	
	//setUp()用于设置初始化工作，在每一个测试用例前先被执行
	//@Before 注释的方法会在每个用例之前执行
	@Before
	public void setUp() throws Exception {
		ChromeConfigure.chromeConfigure();
		driver = new ChromeDriver();
		baseUrl = "https://www.baidu.com/";
		//设定的浏览器的超时时间为 30 秒
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	//执行用例
	//@Test 注释的方法表示一个测试用例。
	@Test
	public void testWebdriver() throws Exception {
		driver.get(baseUrl + "/");
		driver.findElement(By.id("kw")).clear();
		driver.findElement(By.id("kw")).sendKeys("selenium");
		driver.findElement(By.id("su")).click();
	}
	
	//tearDown()方法在每个测试方法执行后调用，这个方法用于完成测试用例执行后的清理工作，如退出浏览器、关闭驱动，恢复用例执行前的状态等
	//@After 注释的方法会在每个用例后执行。
	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
	
	//isElementPresent()方法用来查找页面元素是否存在
	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	//isAlertPresent()方法用于判断当前页面是否存在警告框
	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert().getText();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}
	
	//closeAlertAndGetItsText()关闭警告并且获得警告信息
	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();//忽略此警告
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
