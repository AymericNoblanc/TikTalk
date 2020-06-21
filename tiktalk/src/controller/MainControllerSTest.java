package controller;

import java.sql.SQLException;

import javax.annotation.processing.Generated;

import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;

@Generated(value = "org.junit-tools-1.0.6")
public class MainControllerSTest {

	private MainControllerS createTestSubject() {
		try {
			return new MainControllerS();
		}catch(SQLException e) {
			return null;
		}
	}

	@MethodRef(name = "loginAttempt", signature = "(QDBConnection;QString;QString;)Z")
	@Test
	public void testLoginAttempt() throws Exception {
		MainControllerS testSubject;
		DBConnection dbc = null;
		String userPseudo = "";
		String userPassword = "";
		boolean result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.loginAttempt(dbc, userPseudo, userPassword);
	}

	@MethodRef(name = "addNewUser", signature = "(QDBConnection;QString;QString;QString;)Z")
	@Test
	public void testAddNewUser() throws Exception {
		MainControllerS testSubject;
		DBConnection dbc = null;
		String userPseudo = "";
		String userPassword = "";
		String userIP = "";
		boolean result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.addNewUser(dbc, userPseudo, userPassword, userIP);
	}
}