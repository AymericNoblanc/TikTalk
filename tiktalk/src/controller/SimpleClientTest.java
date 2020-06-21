package controller;

import javax.annotation.processing.Generated;

import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;

@Generated(value = "org.junit-tools-1.0.6")
public class SimpleClientTest {

	private SimpleClient createTestSubject() {
		return new SimpleClient();
	}

	@MethodRef(name = "connect", signature = "(QString;)I")
	@Test
	public void testConnect() throws Exception {
		SimpleClient testSubject;
		String ip = "";
		int result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.connect(ip);
	}
}