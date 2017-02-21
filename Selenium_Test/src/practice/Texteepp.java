package practice;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import configuration.ChromeConfigure;


public class Texteepp {

	public static void main(String[] args) {
		String text="input text";
		String js = "var sum=document.getElementsByName('company_introduce'); sum.value='" + text + "';";
		ChromeConfigure d=new ChromeConfigure();
		d.chromeConfigure();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1280,1024));
		driver.get("http://www.wxeepp.com");

		((JavascriptExecutor)driver).executeScript("window.scrollTo(500,100);");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.linkText("登录")).click();
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
		driver.findElement(By.linkText("企业信息")).click();
		driver.findElement(By.linkText("编辑")).click();
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0,1000);");
		//driver.findElement(By.name("company_introduce")).sendKeys("123123123");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		((JavascriptExecutor)driver).executeScript(js);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(text);

	}

}
