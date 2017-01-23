import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Keyboard {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://yunpan.360.cn/");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.navigate().refresh();
		driver.findElement(By.id("quc_account_100672634")).clear();
		driver.findElement(By.id("quc_account_100672634")).sendKeys("892458803");
		driver.findElement(By.id("quc_password_100672635")).clear();
		driver.findElement(By.id("quc_password_100672635")).sendKeys("386166631070707");
		driver.findElement(By.className("quc-submit quc-button quc-button-sign-in")).click();

	}
}