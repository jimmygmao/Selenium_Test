package practice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import configuration.ChromeConfigure;

public class Download {

	public static void main(String[] args) {
		ChromeConfigure d =new ChromeConfigure();
		DesiredCapabilities cap=d.download();
		WebDriver driver = new ChromeDriver(cap);
		driver.get("http://im.qq.com/pcqq/");
		driver.findElement(By.id("package_url")).click();
	}
	

}