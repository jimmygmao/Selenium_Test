package practice;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import configuration.ChromeConfigure;


public class Video {

	public static void main(String[] args) {
		ChromeConfigure d=new ChromeConfigure();
		d.chromeConfigure();
		WebDriver driver=new ChromeDriver();
		Screen s=new Screen();
		String imgpath="Sikuli-X_img/";
		driver.get("http://m.yikuaiqu.com/common/about");
		driver.findElement(By.className("js-toggle")).click();
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0,10000);");
		WebElement frame=driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[14]/div/iframe"));
		driver.switchTo().frame(frame);
		try {
			Thread.sleep(3000);
			File srcFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File("d:\\screenshot.png"));
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
/*		WebElement video=driver.findElement(By.tagName("embed"));
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		String videoSrc=(String)jse.executeScript("return arguments[0].currentSrc;", video);
		System.out.println(videoSrc);
		jse.executeScript("return arguments[0].play();", video);
		try {
			Thread.sleep(150000);
			File srcFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File("d:\\screenshot.png"));
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		jse.executeScript("return arguments[0].pause();",video);*/
		
		
		
		try {
			s.click(imgpath+"video2.png");
			Thread.sleep(150000);
			s.click(imgpath+"Stop.png");
		} catch (FindFailed e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
}
