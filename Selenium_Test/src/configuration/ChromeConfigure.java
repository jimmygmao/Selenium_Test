package configuration;

import java.awt.Toolkit;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeConfigure {
	public static String CHROMEADDRESS="";
	public static final String HOMECOMPUTERNAME="Lenovo-PC";
	public static final String COMPANYCOMPUTERNAME="JimmyDeng";
	public static final String CHROMEADDRESS1 = "C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe";
	public static final String CHROMEADDRESS2 = "C:/Users/jimmy/AppData/Local/Google/Chrome/Application/chromedriver.exe";
	public static String PERSONALATTRIBUTES="";
	public static final String PERSONALATTRIBUTES1="--user-data-dir=C:/Users/lenovo/AppData/Local/Google/Chrome/User Data";
	public static final String PERSONALATTRIBUTES2="--user-data-dir=C:/Users/jimmy.deng/AppData/Local/Google/Chrome/User Data";
	/**
	 * �жϵ�������
	 */
	public static void Demo(){
		InetAddress a;
		String b = null;
		try {
			a = InetAddress.getLocalHost();
			b=a.getHostName();
			System.out.println(b);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		if(b.equals(HOMECOMPUTERNAME)){
			CHROMEADDRESS=CHROMEADDRESS1;
			PERSONALATTRIBUTES=PERSONALATTRIBUTES1;
		}else if(b.equals(COMPANYCOMPUTERNAME)){
			CHROMEADDRESS=CHROMEADDRESS2;
			PERSONALATTRIBUTES=PERSONALATTRIBUTES2;
		}
	}
	
	/**
	 * CHromeDriver��ַ
	 */
	public static void chromeConfigure() {
		Demo();
		System.setProperty("webdriver.chrome.driver",CHROMEADDRESS);
	}

	/**
	 * ���ø߶ȿ��
	 * @param driver
	 */
	public void maximise(WebDriver driver) {
		final JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.open('','testwindow','width=400,height=200')");
		driver.close();
		driver.switchTo().window("testwindow");
		js.executeScript("window.moveTo(0,0);");
		/*
		 * 1280��1024�ֱ�Ϊ���ڵĿ�͸ߣ�����������Ĵ���õ� screenDims =
		 * Toolkit.getDefaultToolkit().getScreenSize(); width = (int)
		 * screenDims.getWidth(); height = (int) screenDims.getHeight();
		 */
		js.executeScript("window.resizeTo(1280,1024);");
		System.out.println(Toolkit.getDefaultToolkit().getScreenSize()
				.getWidth());
		System.out.println(Toolkit.getDefaultToolkit().getScreenSize()
				.getHeight());
	}
	/**
	 * ���ùȸ�����û�
	 * @return
	 */
	public DesiredCapabilities download(){
		chromeConfigure();
		String downloadFilepath = "F:/";
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		ChromeOptions options = new ChromeOptions();
		//0��ʾ������
		chromePrefs.put("profile.default_content_settings.popups", 0);
		//���ص�ַ
		chromePrefs.put("download.default_directory", downloadFilepath);
		
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		options.addArguments(PERSONALATTRIBUTES);
		options.setExperimentalOption("prefs", chromePrefs);
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		return cap;
	}
}
