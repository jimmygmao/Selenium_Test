import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class Mouse {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
/*		driver.get("http://pan.baidu.com/");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//driver.navigate().refresh();
		driver.findElement(By.linkText("ÕÊºÅµÇÂ¼")).click();
		driver.findElement(By.id("TANGRAM__PSP_4__userName")).clear();
		driver.findElement(By.id("TANGRAM__PSP_4__userName")).sendKeys("892458803@qq.com");
		driver.findElement(By.id("TANGRAM__PSP_4__password")).clear();
		driver.findElement(By.id("TANGRAM__PSP_4__password")).sendKeys("dgm0218");
		driver.findElement(By.id("TANGRAM__PSP_4__submit")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.switchTo().alert().accept();
		driver.findElement(By.className("welcome-close icon icon-close close-addAnimation")).click();*/
		driver.get("https://www.baidu.com/");
		Actions action=new Actions(driver);
		//action.contextClick(driver.findElement(By.id("kw"))).perform();	
		//action.clickAndHold(driver.findElement(By.linkText("ÉèÖÃ"))).perform();
		//action.doubleClick(driver.findElement(By.id("su"))).perform();
		WebElement f1=driver.findElement(By.linkText("Å´Ã×"));
		WebElement f2=driver.findElement(By.id("kw"));
		action.dragAndDrop(f1, f2).perform();
		action.release().perform(); 
		
	}
}
