package junitTest;

import static org.junit.Assert.*;
import org.junit.*;

public class AnnotationsTest {

	@BeforeClass //的所有方法运行之前运行。
	public static void beforeClass(){
		System.out.println("beforeClass--所有方法运行之前运行");
	}

	@AfterClass //在所有方法运行之后运行
	public static void afterClass(){
		System.out.println("afterClass--在所有方法运行之后运行");
	}

	@Before //每个测试方法运行之前运行
	public void before(){
		System.out.println("before==每个测试方法运行之前运行");
	}

	@After //每个测试方法运行之后运行
	public void after(){
		System.out.println("after==每个测试方法运行之后运行");
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

	@Ignore //表示这个方法是不被运行的
	@Test
	//timeout 表示要求方法在 100 毫秒内运行完成，否则报错
	(expected=java.lang.ArithmeticException.class,timeout=100) 
	public void testDivide(){
		int z =new Count().divide(8,2);
		System.out.println(z);
	}
}
