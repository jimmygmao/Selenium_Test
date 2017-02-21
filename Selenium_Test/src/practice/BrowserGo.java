package practice;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

import configuration.ChromeConfigure;

public class BrowserGo {
	public static void main(String[] args) {
		ChromeConfigure d =new ChromeConfigure();
		d.chromeConfigure();
		WebDriver driver=new ChromeDriver();
	//	String firstUrl="http://www.baidu.com";
		String SecondUrl="http://news.baidu.com";
	//	driver.get(firstUrl);
		driver.get(SecondUrl);
		//driver.navigate().back();
	//	driver.navigate().forward();
		driver.navigate().refresh();
	//	driver.quit();
	}

}
