package practice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import configuration.ChromeConfigure;

public class LoginQq {

	public static void main(String[] args) {
		ChromeConfigure d=new ChromeConfigure();
		d.chromeConfigure();
		WebDriver driver=new ChromeDriver();
		driver.get("https://mail.qq.com/");
		driver.switchTo().frame("login_frame");
		driver.findElement(By.className("switch_btn")).click();
		driver.findElement(By.id("u")).clear();
		driver.findElement(By.id("u")).sendKeys("892458803");
		driver.findElement(By.id("p")).clear();
		driver.findElement(By.id("p")).sendKeys("386166631070707");
		driver.findElement(By.className("login_button")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.navigate().refresh();
		driver.findElement(By.id("pp")).sendKeys("dgm0218");
		driver.findElement(By.id("pp")).submit();
		driver.findElement(By.linkText("�˳�")).click();
	}
}