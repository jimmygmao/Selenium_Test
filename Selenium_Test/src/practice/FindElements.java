package practice;
import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import configuration.ChromeConfigure;


public class FindElements {

	public static void main(String[] args) {
		ChromeConfigure d =new ChromeConfigure();
		d.chromeConfigure();
		WebDriver driver=new ChromeDriver();
		File file=new File("auxiliary/Checkbox.html");
		String filePath=file.getAbsolutePath();
		driver.get(filePath);
		//����
/*		List<WebElement> inputs=driver.findElements(By.tagName("input"));
		for(WebElement checkbox:inputs){
			String type=new String(checkbox.getAttribute("typt"));
			if(type.equals("checkbox")){
				checkbox.click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}*/
		//CSS��λ
		List<WebElement> checkboxs=driver.findElements(By.cssSelector("input[type=checkbox]"));
		for(WebElement checkbox:checkboxs){
			checkbox.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//ˢ��һ��
	//	driver.navigate().refresh();
		//ȥ�����һ����
		//Xpath��λ
		List<WebElement> allCheckboxes=driver.findElements(By.xpath("//input[@type='checkbox']"));
		int a=allCheckboxes.size();
		allCheckboxes.get(a-1).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
