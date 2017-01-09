import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class BrowserGo {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");
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
