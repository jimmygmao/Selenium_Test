package junitTest;

	import org.junit.runner.RunWith;
	import org.junit.runners.Suite;
	import org.junit.runners.Suite.SuiteClasses;
	@RunWith(Suite.class)
	@SuiteClasses({
	CountTest.class,
	Webdriver.class,
	AnnotationsTest.class
	})
	public class TestAll {
		
	}

