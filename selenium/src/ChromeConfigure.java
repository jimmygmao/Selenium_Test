import java.awt.Toolkit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


public class ChromeConfigure {
	
	  public void chromeConfigure(){
		System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");

	}
	  public void maximise(WebDriver driver) { 
	    	final JavascriptExecutor js = (JavascriptExecutor) driver;
	    	js.executeScript("window.open('','testwindow','width=400,height=200')");
	    	driver.close();
	    	driver.switchTo().window("testwindow");
	    	js.executeScript("window.moveTo(0,0);");
	    	/*1280和1024分别为窗口的宽和高，可以用下面的代码得到
	            screenDims = Toolkit.getDefaultToolkit().getScreenSize();  
	            width = (int) screenDims.getWidth();  
	            height = (int) screenDims.getHeight();   */
	    	js.executeScript("window.resizeTo(1280,1024);");
	    	System.out.println(Toolkit.getDefaultToolkit().getScreenSize().getWidth());
	    	System.out.println(Toolkit.getDefaultToolkit().getScreenSize().getHeight());
	        } 
}
