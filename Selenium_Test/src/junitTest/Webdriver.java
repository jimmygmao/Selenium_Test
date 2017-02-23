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
	//��ʼ������˽�б��� driver Ϊ������
	//baseUrl Ϊ���� URL ��ַ��
	//acceptNextAlert ��ʾ�Ƿ����������һ�����棬��ʼ��״̬Ϊ ture��
	//verificationErrors ������Ŵ�����ַ�������
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	
	//setUp()�������ó�ʼ����������ÿһ����������ǰ�ȱ�ִ��
	//@Before ע�͵ķ�������ÿ������֮ǰִ��
	@Before
	public void setUp() throws Exception {
		ChromeConfigure.chromeConfigure();
		driver = new ChromeDriver();
		baseUrl = "https://www.baidu.com/";
		//�趨��������ĳ�ʱʱ��Ϊ 30 ��
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	//ִ������
	//@Test ע�͵ķ�����ʾһ������������
	@Test
	public void testWebdriver() throws Exception {
		driver.get(baseUrl + "/");
		driver.findElement(By.id("kw")).clear();
		driver.findElement(By.id("kw")).sendKeys("selenium");
		driver.findElement(By.id("su")).click();
	}
	
	//tearDown()������ÿ�����Է���ִ�к���ã��������������ɲ�������ִ�к�������������˳���������ر��������ָ�����ִ��ǰ��״̬��
	//@After ע�͵ķ�������ÿ��������ִ�С�
	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
	
	//isElementPresent()������������ҳ��Ԫ���Ƿ����
	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	//isAlertPresent()���������жϵ�ǰҳ���Ƿ���ھ����
	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert().getText();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}
	
	//closeAlertAndGetItsText()�رվ��沢�һ�þ�����Ϣ
	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();//���Դ˾���
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
