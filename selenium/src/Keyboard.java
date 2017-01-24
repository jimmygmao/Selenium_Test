import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Keyboard {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.baidu.com/");
		WebElement input=driver.findElement(By.id("kw"));
		input.sendKeys("seleniumm");
		input.sendKeys(Keys.BACK_SPACE);
		input.sendKeys(Keys.SPACE);
		input.sendKeys("½Ì³Ì");
		input.sendKeys(Keys.CONTROL,"a");
		//input.sendKeys(Keys.CONTROL,"x");
		input.sendKeys(Keys.CONTROL,"c");
		input.sendKeys(Keys.CONTROL,"v");
		input.sendKeys(Keys.ENTER);
		driver.quit();
	}

}
