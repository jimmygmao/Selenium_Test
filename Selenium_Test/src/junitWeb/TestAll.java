package junitWeb;

	import org.junit.runner.RunWith;
	import org.junit.runners.Suite;
	import org.junit.runners.Suite.SuiteClasses;
	@RunWith(Suite.class)
	@SuiteClasses({
	BaiduTest.class,
	YoudaoTest.class,
	})
	public class TestAll {
		
	}

