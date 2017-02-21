package practice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import configuration.ChromeConfigure;


public class TitleRul {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		ChromeConfigure d =new ChromeConfigure();
		d.chromeConfigure();
		driver.get("https://mail.qq.com/");
		System.out.println("Before login================"); 
		//获取当前的 title 和 url 
		System.out.printf("title of current page is %s\n", driver.getTitle()); 
		System.out.printf("url of current page is %s\n", driver.getCurrentUrl());
		//登录 126 邮箱 
		driver.switchTo().frame("login_frame");
		driver.findElement(By.id("switcher_plogin")).click();
		driver.findElement(By.id("u")).clear(); 
		driver.findElement(By.id("u")).sendKeys("892458803"); 
		driver.findElement(By.id("p")).clear(); 
		driver.findElement(By.id("p")).sendKeys("386166631070707"); 
		driver.findElement(By.id("login_button")).click();
		System.out.println("After login================"); 

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.navigate().refresh();
		driver.findElement(By.id("pp")).clear(); 
		driver.findElement(By.id("pp")).sendKeys("dgm0218"); 
		driver.findElement(By.id("btlogin")).click();
		//获取当前的 title 和 url 
		System.out.printf("title of current page is %s\n", driver.getTitle()); 
		System.out.printf("url of current page is %s\n", driver.getCurrentUrl());
		//获得登录用户名 
		driver.switchTo().frame("mainFrame");
		String text = driver.findElement(By.className("black")).getText(); 
		System.out.println(text);
		
	}


	

}
