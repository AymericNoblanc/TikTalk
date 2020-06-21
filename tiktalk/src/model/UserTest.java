package model;

import javax.annotation.processing.Generated;

import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;

@Generated(value = "org.junit-tools-1.0.6")
public class UserTest {

	private User createTestSubject() {
		return new User(0, "", "", "");
	}

	@MethodRef(name = "getId", signature = "()I")
	@Test
	public void testGetId() throws Exception {
		User testSubject;
		int result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getId();
	}

	@MethodRef(name = "setId", signature = "(I)V")
	@Test
	public void testSetId() throws Exception {
		User testSubject;
		int id = 0;

		// default test
		testSubject = createTestSubject();
		testSubject.setId(id);
	}

	@MethodRef(name = "getPseudo", signature = "()QString;")
	@Test
	public void testGetPseudo() throws Exception {
		User testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getPseudo();
	}

	@MethodRef(name = "setPseudo", signature = "(QString;)V")
	@Test
	public void testSetPseudo() throws Exception {
		User testSubject;
		String pseudo = "";

		// default test
		testSubject = createTestSubject();
		testSubject.setPseudo(pseudo);
	}

	@MethodRef(name = "getPassword", signature = "()QString;")
	@Test
	public void testGetPassword() throws Exception {
		User testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getPassword();
	}

	@MethodRef(name = "setPassword", signature = "(QString;)V")
	@Test
	public void testSetPassword() throws Exception {
		User testSubject;
		String password = "";

		// default test
		testSubject = createTestSubject();
		testSubject.setPassword(password);
	}

	@MethodRef(name = "getIp", signature = "()QString;")
	@Test
	public void testGetIp() throws Exception {
		User testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getIp();
	}

	@MethodRef(name = "setIp", signature = "(QString;)V")
	@Test
	public void testSetIp() throws Exception {
		User testSubject;
		String ip = "";

		// default test
		testSubject = createTestSubject();
		testSubject.setIp(ip);
	}
}