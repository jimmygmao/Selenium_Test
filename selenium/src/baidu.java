import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class baidu {

	public static void main(String[] args) {
		System.out.println("srart selenium");
		System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.baidu.com");
	//	driver.findElement(By.id("kw")).sendKeys("selenium java");
	//	driver.findElement(By.id("su")).click();
	//	driver.findElement(By.partialLinkText("Í¼")).click();
	//	driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/form/span/input")).sendKeys("¹þ¹þ");
	//	driver.findElement(By.xpath("//input[@id='kw' and @name='wd']")).sendKeys("hehe");
	//	driver.findElement(By.cssSelector("form#form>span> input.s_ipt")).sendKeys("hehe");
		//	driver.close();
		WebElement size = driver.findElement(By.id("kw"));
		System.out.println(size.getSize());
		WebElement text = driver.findElement(By.id("cp"));
		System.out.println(text.getText());
		WebElement sx = driver.findElement(By.id("kw"));
		System.out.println(sx.getAttribute("type"));
		WebElement display  = driver.findElement(By.id("kw"));
		System.out.println(display.isDisplayed());
	}
}