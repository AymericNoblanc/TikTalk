package controller;

import javax.annotation.processing.Generated;

import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;

@Generated(value = "org.junit-tools-1.0.6")
public class ServerThreadTest {

	private ServerThread createTestSubject() {
		return new ServerThread(null);
	}

	@MethodRef(name = "run", signature = "()V")
	@Test
	public void testRun() throws Exception {
		ServerThread testSubject;

		// default test
		testSubject = createTestSubject();
		testSubject.run();
	}
}