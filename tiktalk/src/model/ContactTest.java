package model;

import javax.annotation.processing.Generated;

import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;

@Generated(value = "org.junit-tools-1.0.6")
public class ContactTest {

	private Contact createTestSubject() {
		return new Contact(0, "");
	}

	@MethodRef(name = "getContactID", signature = "()I")
	@Test
	public void testGetContactID() throws Exception {
		Contact testSubject;
		int result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getContactID();
	}

	@MethodRef(name = "setContactID", signature = "(I)V")
	@Test
	public void testSetContactID() throws Exception {
		Contact testSubject;
		int contactID = 0;

		// default test
		testSubject = createTestSubject();
		testSubject.setContactID(contactID);
	}

	@MethodRef(name = "getContactPseudo", signature = "()QString;")
	@Test
	public void testGetContactPseudo() throws Exception {
		Contact testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getContactPseudo();
	}

	@MethodRef(name = "setContactPseudo", signature = "(QString;)V")
	@Test
	public void testSetContactPseudo() throws Exception {
		Contact testSubject;
		String contactPseudo = "";

		// default test
		testSubject = createTestSubject();
		testSubject.setContactPseudo(contactPseudo);
	}

	@MethodRef(name = "toString", signature = "()QString;")
	@Test
	public void testToString() throws Exception {
		Contact testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.toString();
	}
}