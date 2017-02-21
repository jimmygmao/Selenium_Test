package practice;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import configuration.ChromeConfigure;


public class Windows {

	public static void main(String[] args) {
		ChromeConfigure d =new ChromeConfigure();
		d.chromeConfigure();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.baidu.com/");
		String sreach_handle=driver.getWindowHandle();
		System.out.println(sreach_handle);
		driver.findElement(By.xpath("//*[@id='u1']/a[7]")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//a[@class='pass-reglink']")).click();
		
		Set<String> handles=driver.getWindowHandles();
		for(String handle:handles){
			if(handle.equals(sreach_handle)==false){
				driver.switchTo().window(handle);
				System.out.println("◊¢≤·“≥√Ê");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				driver.findElement(By.id("TANGRAM__PSP_3__userName")).clear();
				driver.findElement(By.id("TANGRAM__PSP_3__userName")).sendKeys("Œ“œ≤ª∂Chrome");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				driver.close();
			}
		}
		for(String handle:handles){
			if(handle.equals(sreach_handle)){
				driver.switchTo().window(handle);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				driver.findElement(By.className("close-btn")).click();
				driver.findElement(By.id("kw")).sendKeys("»’”ÔŒ“∞Æƒ„");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				driver.close();
			}
		}
		}
}
