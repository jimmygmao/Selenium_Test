package junitTest;

import static org.junit.Assert.*;
import org.junit.*;

public class AnnotationsTest {

	@BeforeClass //�����з�������֮ǰ���С�
	public static void beforeClass(){
		System.out.println("beforeClass--���з�������֮ǰ����");
	}

	@AfterClass //�����з�������֮������
	public static void afterClass(){
		System.out.println("afterClass--�����з�������֮������");
	}

	@Before //ÿ�����Է�������֮ǰ����
	public void before(){
		System.out.println("before==ÿ�����Է�������֮ǰ����");
	}

	@After //ÿ�����Է�������֮������
	public void after(){
		System.out.println("after==ÿ�����Է�������֮������");
	}

	@Test
	public void testAdd() {
		int z=new Count().add(5,3);
		assertEquals(8,z);
		System.out.println("test Run through");
	}

	@Test ()
	public void testdivision(){
		System.out.println("in Test Division");
	}

	@Ignore //��ʾ��������ǲ������е�
	@Test
	//timeout ��ʾҪ�󷽷��� 100 ������������ɣ����򱨴�
	(expected=java.lang.ArithmeticException.class,timeout=100) 
	public void testDivide(){
		int z =new Count().divide(8,2);
		System.out.println(z);
	}
}
