import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://mail.qq.com/");
		driver.switchTo().frame("login_frame");
		//driver.get("https://xui.ptlogin2.qq.com/cgi-bin/xlogin?appid=522005705&daid=4&s_url=https://mail.qq.com/cgi-bin/login?vt=passport%26vm=wpt%26ft=loginpage%26target=&style=25&low_login=1&proxy_url=https://mail.qq.com/proxy.html&need_qr=0&hide_border=1&border_radius=0&self_regurl=http://zc.qq.com/chs/index.html?type=1&app_id=11005?t=regist&pt_feedback_link=http://support.qq.com/discuss/350_1.shtml&css=https://res.mail.qq.com/zh_CN/htmledition/style/ptlogin_input24e6b9.css");
		driver.findElement(By.id("switcher_plogin")).click();
		driver.findElement(By.id("u")).clear();
		driver.findElement(By.id("u")).sendKeys("892458803");
		driver.findElement(By.id("p")).clear();
		driver.findElement(By.id("p")).sendKeys("386166631070707");
		driver.findElement(By.id("login_button")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.navigate().refresh();
		//driver.get("https://mail.qq.com/cgi-bin/loginpage?autologin=n&errtype=4&clientuin=892458803&t=ptlogin&vt=passport&clientaddr=892458803&param=&sp=4fbaa5f96f59196MTQ4NDA1MDA1OA&tfcont=22%20serialization%3A%3Aarchive%205%200%200%209%200%200%200%208%20authtype%201%204%207%20spcache%2029%204fbaa5f96f59196MTQ4NDA1MDA1OA%202%20sp%2029%204fbaa5f96f59196MTQ4NDA1MDA1OA%209%20clientuin%209%20892458803%206%20domain%206%20qq.com%202%20vm%203%20wpt%202%20ft%209%20loginpage%207%20account%209%20892458803%209%20qqmailkey%2064%20a933d7a50a94d4211ac4a87254d0b321b427ca2d58ca4bf8e8b52208d66259fa&r=1c6137c950b52f90904bc91cb8ef590a");
		//driver.get("https://rl.mail.qq.com/cgi-bin/getinvestigate?stat=loginerr&code=920&err=&un=&r=0.37130761906420984");
		driver.findElement(By.id("pp")).sendKeys("dgm0218");
		driver.findElement(By.id("btlogin")).click();
	}
}