package qqEmail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MailLogin{
	//��¼����
	public static void login(WebDriver driver,String username, String password){
		driver.get("https://mail.qq.com/");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.switchTo().frame("login_frame");
		driver.findElement(By.className("switch_btn")).click();
		driver.findElement(By.id("u")).clear();
		driver.findElement(By.id("u")).sendKeys(username);
		driver.findElement(By.id("p")).clear();
		driver.findElement(By.id("p")).sendKeys(password);
		driver.findElement(By.className("login_button")).click();
	}
	//��������
	public static void independentPassword(WebDriver driver,String password2){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.navigate().refresh();
		driver.findElement(By.id("pp")).sendKeys(password2);
		driver.findElement(By.id("pp")).submit();
	}
	//�˳�
	public static void logout(WebDriver driver){
		driver.findElement(By.linkText("�˳�")).click();
	}
}
