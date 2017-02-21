package qqEmail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import configuration.ChromeConfigure;

public class LoginQq {

	public static void main(String[] args) {
		String filePath="TestDate/qqEmail.csv";
		ReadCSV.readTxtFile(filePath);
	}
	
	//Æô¶¯WebDriver
	public static void driver(String username, String password,String password2) {
		ChromeConfigure d=new ChromeConfigure();
		d.chromeConfigure();
		WebDriver driver=new ChromeDriver();
		
		transfer(driver,username,password,password2);
		
		try {
			Thread.sleep(2000);
			MailLogin.logout(driver);
			Thread.sleep(2000);
			driver.quit();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static void transfer(WebDriver driver,String username, String password,String password2){
		if(password2.equals("")){
			MailLogin.login(driver,username,password);
		}else{
			MailLogin.login(driver,username,password);
			MailLogin.independentPassword(driver,password2);
		}
	}
}