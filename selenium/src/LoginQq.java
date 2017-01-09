import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginQq {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
/*		driver.get("https://www.wxw7z.com/");
		driver.findElement(By.linkText("µÇÂ¼")).click();
		driver.findElement(By.id("phone")).sendKeys("13549893438");
		driver.findElement(By.id("pwd")).sendKeys("123456");
		driver.findElement(By.className("u_logo")).click();*/
		
		driver.get("https://ssl.zc.qq.com/chs/index.html");
		driver.findElement(By.id("nick")).sendKeys("I Love You");
		driver.findElement(By.id("nick")).submit();
	}
}