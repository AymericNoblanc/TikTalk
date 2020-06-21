package model;

import java.sql.Timestamp;

import javax.annotation.processing.Generated;

import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;

@Generated(value = "org.junit-tools-1.0.6")
public class MessageTest {

	private Message createTestSubject() {
		return new Message(0, 0, 0, null, "", "");
	}

	@MethodRef(name = "setId", signature = "(I)V")
	@Test
	public void testSetId() throws Exception {
		Message testSubject;
		int id = 0;

		// default test
		testSubject = createTestSubject();
		testSubject.setId(id);
	}

	@MethodRef(name = "getId", signature = "()I")
	@Test
	public void testGetId() throws Exception {
		Message testSubject;
		int result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getId();
	}

	@MethodRef(name = "getEnvoyeur", signature = "()I")
	@Test
	public void testGetEnvoyeur() throws Exception {
		Message testSubject;
		int result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getEnvoyeur();
	}

	@MethodRef(name = "setEnvoyeur", signature = "(I)V")
	@Test
	public void testSetEnvoyeur() throws Exception {
		Message testSubject;
		int envoyeur = 0;

		// default test
		testSubject = createTestSubject();
		testSubject.setEnvoyeur(envoyeur);
	}

	@MethodRef(name = "getRecever", signature = "()I")
	@Test
	public void testGetRecever() throws Exception {
		Message testSubject;
		int result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getRecever();
	}

	@MethodRef(name = "setRecever", signature = "(I)V")
	@Test
	public void testSetRecever() throws Exception {
		Message testSubject;
		int recever = 0;

		// default test
		testSubject = createTestSubject();
		testSubject.setRecever(recever);
	}

	@MethodRef(name = "getPseudoEnvoyeur", signature = "()QString;")
	@Test
	public void testGetPseudoEnvoyeur() throws Exception {
		Message testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getPseudoEnvoyeur();
	}

	@MethodRef(name = "setPseudoEnvoyeur", signature = "(QString;)V")
	@Test
	public void testSetPseudoEnvoyeur() throws Exception {
		Message testSubject;
		String pseudoEnvoyeur = "";

		// default test
		testSubject = createTestSubject();
		testSubject.setPseudoEnvoyeur(pseudoEnvoyeur);
	}

	@MethodRef(name = "getDateSQL", signature = "()Qjava.sql.Timestamp;")
	@Test
	public void testGetDateSQL() throws Exception {
		Message testSubject;
		Timestamp result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getDateSQL();
	}

	@MethodRef(name = "setDateSQL", signature = "(Qjava.sql.Timestamp;)V")
	@Test
	public void testSetDateSQL() throws Exception {
		Message testSubject;
		Timestamp dateSQL = null;

		// default test
		testSubject = createTestSubject();
		testSubject.setDateSQL(dateSQL);
	}

	@MethodRef(name = "getTxt", signature = "()QString;")
	@Test
	public void testGetTxt() throws Exception {
		Message testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getTxt();
	}

	@MethodRef(name = "setTxt", signature = "(QString;)V")
	@Test
	public void testSetTxt() throws Exception {
		Message testSubject;
		String txt = "";

		// default test
		testSubject = createTestSubject();
		testSubject.setTxt(txt);
	}

	@MethodRef(name = "toString", signature = "()QString;")
	@Test
	public void testToString() throws Exception {
		Message testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.toString();
	}
}