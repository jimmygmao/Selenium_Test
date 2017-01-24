import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class Test7z {

	public static void main(String[] args) {
		ChromeConfigure d =new ChromeConfigure();
		DesiredCapabilities cap=d.download();
		WebDriver driver = new ChromeDriver(cap);
		driver.get("https://www.wxw7z.com/");
		driver.findElement(By.linkText("商品分类")).click();
		driver.findElement(By.className("goodsCat_btn")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.className("i_ct_choice")).click();
		List<WebElement> classs=driver.findElements(By.xpath("//b[@class='i_mo_wei']"));
		for(WebElement cl:classs){
			cl.click();
		}
		driver.findElement(By.className("i_ct_sure")).click();
	}
}
