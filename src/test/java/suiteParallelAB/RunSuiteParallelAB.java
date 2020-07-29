package suiteParallelAB;

import java.util.Arrays;

import org.testng.TestNG;

public class RunSuiteParallelAB {

	public static void main(String[] args) {
		TestNG t = new TestNG();
		t.setTestSuites(Arrays.asList(System.getProperty("user.dir")+"//MegasuiteAB.xml"));
		t.setSuiteThreadPoolSize(2);
		t.run();

	}

}
