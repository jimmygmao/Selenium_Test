package practice;
import org.sikuli.script.*;


public class dataDriver {

	public static void main(String[] args) {
		Screen s=new Screen();
		//����ͼƬ���·��
		String imgpath="Sikuli-X_img/";
		//˫������chrome�����ͼ��
		try {
			s.doubleClick(imgpath+"chrome.png");
			System.out.println("����");
			//����url
			s.type(imgpath+"url.png", "www.baidu.com");
			s.keyDown(Key.ENTER);
		//	s.click(imgpath+"lianxiang.png");
			Thread.sleep(2000);
			//�ڰٶ���������������ؼ��֣�����,�����������ť
			s.type(imgpath+"sreach_input.png","");
			s.paste("���");
			s.click(imgpath+"sreach_button.png");
		} catch (FindFailed e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("End!");
	}

}
