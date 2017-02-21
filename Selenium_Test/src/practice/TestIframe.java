package practice;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import configuration.ChromeConfigure;


public class TestIframe {
	public static void main(String[] args){
		ChromeConfigure d =new ChromeConfigure();
		d.chromeConfigure();
		WebDriver driver=new ChromeDriver();
		File file=new File("auxiliary/Ifame.html");
		String filePath=file.getAbsolutePath();
		driver.get(filePath);
		WebElement vf=driver.findElement(By.xpath("//iframe[@id='if']"));
		driver.switchTo().frame(vf);
		driver.findElement(By.id("kw")).sendKeys("hehe");
		//�˻���һ����
		driver.switchTo().defaultContent();
	}
}
