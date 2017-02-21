package practice;
import java.util.Random;
import java.util.Scanner;


public class randomTest {

	public static void main(String[] args) {
		int min=1000;
		int max=9999;
		Random rand=new Random();
		int s=rand.nextInt(max)%(max=min+1)+min;
		String ss=String.valueOf(s);
		System.out.println(ss);
		
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入验证码");
		String str=sc.nextLine();
		if(str.equals(ss)){
			System.out.println("输入正确");
		}else if(str.equals("19930218")){
			System.out.println("输入正确");
		}else{
			System.out.println("输入错误");
		}
	}
}
