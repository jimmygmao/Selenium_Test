import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Download {

	public static void main(String[] args) {
		ChromeConfigure d =new ChromeConfigure();
		d.chromeConfigure();
		String downloadFilepath = "F:/";
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		ChromeOptions options = new ChromeOptions();
		//0表示不弹窗
		chromePrefs.put("profile.default_content_settings.popups", 0);
		//下载地址
		chromePrefs.put("download.default_directory", downloadFilepath);
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		options.addArguments("--user-data-dir=C:/Users/lenovo/AppData/Local/Google/Chrome/User Data");
		options.setExperimentalOption("prefs", chromePrefs);
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		WebDriver driver = new ChromeDriver(cap);
		driver.get("http://im.qq.com/pcqq/");
		driver.findElement(By.id("package_url")).click();
	}
	

}

