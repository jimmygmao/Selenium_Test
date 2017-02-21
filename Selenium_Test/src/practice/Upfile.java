package practice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import configuration.ChromeConfigure;


public class Upfile {
	public static void main(String[] args) {
		ChromeConfigure d=new ChromeConfigure();
		d.chromeConfigure();
		WebDriver driver=new ChromeDriver();
		d.maximise(driver);
		driver.get("https://www.wxeepp.com");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//html/body/div[1]/div[2]/div/ul[2]/li[1]/a")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.className("name_right")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@id='company_login']/div/ul/li[1]/input")).clear();
		driver.findElement(By.xpath("//*[@id='company_login']/div/ul/li[1]/input")).sendKeys("892458803@qq.com");
		driver.findElement(By.xpath("//*[@id='company_login']/div/ul/li[2]/input")).clear();
		driver.findElement(By.xpath("//*[@id='company_login']/div/ul/li[2]/input")).sendKeys("123456");
		driver.findElement(By.xpath("//*[@id='company_login']/div/div[2]/p[1]/button")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/ul[2]/li[1]/a")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.id("photoimg")).sendKeys("C:/Users/lenovo/Desktop/µÁ”∞.txt");
/*		driver.findElement(By.id("photoimg")).click();
		Runtime rn=Runtime.getRuntime();
		try {
			String str="../selenium/src/upfile.exe";
			rn.exec(str);
		} catch (IOException e) {
			System.out.println("Error to run the exe");
		}*/
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
}
