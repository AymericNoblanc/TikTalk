package controller;

import javax.annotation.processing.Generated;

import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;

@Generated(value = "org.junit-tools-1.0.6")
public class FirstServerTest {

	private FirstServer createTestSubject() {
		return new FirstServer();
	}

	@MethodRef(name = "connect", signature = "(QString;)V")
	@Test
	public void testConnect() throws Exception {
		FirstServer testSubject;
		String ip = "";

		// default test
		testSubject = createTestSubject();
		testSubject.connect(ip);
	}

	@MethodRef(name = "newServerThread", signature = "(I)V")
	@Test
	public void testNewServerThread() throws Exception {
		FirstServer testSubject;
		int port = 0;

		// default test
		testSubject = createTestSubject();
		testSubject.newServerThread(port);
	}

	@MethodRef(name = "main", signature = "([QString;)V")
	@Test
	public void testMain() throws Exception {
		String[] args = new String[] { "" };

		// default test
		FirstServer.main(args);
	}
}