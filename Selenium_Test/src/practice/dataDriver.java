package practice;
import org.sikuli.script.*;


public class dataDriver {

	public static void main(String[] args) {
		Screen s=new Screen();
		//定义图片存放路径
		String imgpath="Sikuli-X_img/";
		//双击桌面chrome浏览器图标
		try {
			s.doubleClick(imgpath+"chrome.png");
			System.out.println("结束");
			//输入url
			s.type(imgpath+"url.png", "www.baidu.com");
			s.keyDown(Key.ENTER);
		//	s.click(imgpath+"lianxiang.png");
			Thread.sleep(2000);
			//在百度输入框输入搜索关键字：日语,并点击搜索按钮
			s.type(imgpath+"sreach_input.png","");
			s.paste("你好");
			s.click(imgpath+"sreach_button.png");
		} catch (FindFailed e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("End!");
	}

}
