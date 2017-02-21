package practice;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import configuration.ChromeConfigure;


public class CookieOpe {
	public static void main(String[] args) {
		ChromeConfigure d=new ChromeConfigure();
		d.chromeConfigure();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.baidu.com");
		
		Cookie c1=new Cookie("name","key-aaaaaaaa");
		Cookie c2=new Cookie("value","vcalue-asfasfa");
		driver.manage().addCookie(c1);
		driver.manage().addCookie(c2);
		
		// ��� cookie
		Set<Cookie> coo = driver.manage().getCookies();
		// ��ӡ cookie
		System.out.println(coo);
		
		//ɾ������cookie
		//driver.manage().deleteAllCookies();
		//driver.manage().deleteCookie(c1);
		System.out.println(driver.manage().getCookieNamed("BD_UPN"));
	}
}