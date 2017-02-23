package junitTest;

import static org.junit.Assert.*;

import org.junit.Test;

public class CountTest {
	@Test
	public void testAdd(){
		int z=new Count().add(3, 5);
		//查看两个对象是否相等
		assertEquals(z,8);
		//查看两个对象是否不相等
		assertNotEquals(z, 8);
	}
	@Test
	public void primeTest(){
		int n=7;
		int m=10;
		//查看运行结果是否为 true
		assertTrue(Count.prime(n));
		//查看运行结果是否为 false
		assertFalse(Count.prime(m));
	}

}
