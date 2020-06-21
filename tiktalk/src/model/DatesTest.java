package model;

import java.text.DateFormat;

import javax.annotation.processing.Generated;

import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;

@Generated(value = "org.junit-tools-1.0.6")
public class DatesTest {

	private Dates createTestSubject() {
		return new Dates();
	}

	@MethodRef(name = "nowDate", signature = "()QDateFormat;")
	@Test
	public void testNowDate() throws Exception {
		Dates testSubject;
		DateFormat result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.nowDate();
	}
}