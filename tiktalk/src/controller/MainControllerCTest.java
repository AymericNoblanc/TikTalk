package controller;

import javax.annotation.processing.Generated;

import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;

@Generated(value = "org.junit-tools-1.0.6")
public class MainControllerCTest {

	private MainControllerC createTestSubject() {
		return new MainControllerC();
	}

	@MethodRef(name = "main", signature = "([QString;)V")
	@Test
	public void testMain() throws Exception {
		String[] args = new String[] { "" };

		// default test
		MainControllerC.main(args);
	}

	@MethodRef(name = "launchClient", signature = "()V")
	@Test
	public void testLaunchClient() throws Exception {
		MainControllerC testSubject;

		// default test
		testSubject = createTestSubject();
		testSubject.launchClient();
	}
}