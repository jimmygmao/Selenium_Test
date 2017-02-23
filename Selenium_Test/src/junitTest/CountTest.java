package junitTest;

import static org.junit.Assert.*;

import org.junit.Test;

public class CountTest {
	@Test
	public void testAdd(){
		int z=new Count().add(3, 5);
		//�鿴���������Ƿ����
		assertEquals(z,8);
		//�鿴���������Ƿ����
		assertNotEquals(z, 8);
	}
	@Test
	public void primeTest(){
		int n=7;
		int m=10;
		//�鿴���н���Ƿ�Ϊ true
		assertTrue(Count.prime(n));
		//�鿴���н���Ƿ�Ϊ false
		assertFalse(Count.prime(m));
	}

}
