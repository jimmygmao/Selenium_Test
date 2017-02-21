package practice;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import configuration.ChromeConfigure;


public class CookieExa {

	public static void main(String[] args) {
		ChromeConfigure d =new ChromeConfigure();
		d.chromeConfigure();
		DesiredCapabilities cap=d.download();
		WebDriver driver=new ChromeDriver(cap);
		driver.get("http://www.baidu.com");
/*		driver.findElement(By.linkText("登录")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		driver.findElement(By.id("TANGRAM__PSP_8__userName")).clear();
		driver.findElement(By.id("TANGRAM__PSP_8__userName")).sendKeys("892458803@qq.com");
		driver.findElement(By.id("TANGRAM__PSP_8__password")).clear();
		driver.findElement(By.id("TANGRAM__PSP_8__password")).sendKeys("dgm0218");
		driver.findElement(By.id("TANGRAM__PSP_8__submit")).click();*/
		Set<Cookie> coo=driver.manage().getCookies();
		System.out.println(coo);
	}

}
