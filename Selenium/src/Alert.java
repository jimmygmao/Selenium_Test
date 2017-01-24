import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class Alert {
	/**
	 *  Û±Í
	 * @param args
	 */
	public static void main(String[] args) {
		ChromeConfigure d=new ChromeConfigure();
		d.chromeConfigure();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.baidu.com/");
		Actions actions=new Actions(driver);
		actions.clickAndHold(driver.findElement(By.linkText("…Ë÷√"))).perform();
		actions.clickAndHold(driver.findElement(By.className("setpref"))).perform();
		driver.findElement(By.className("setpref")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.className("prefpanelgo")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.switchTo().alert().accept();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}

}
