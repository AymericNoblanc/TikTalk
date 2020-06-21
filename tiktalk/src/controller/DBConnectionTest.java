package controller;

import java.sql.ResultSet;
import java.util.LinkedList;

import javax.annotation.processing.Generated;

import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;

import java.sql.Connection;

import model.Contact;
import model.User;
import model.Message;

import java.sql.Timestamp;

@Generated(value = "org.junit-tools-1.0.6")
public class DBConnectionTest {

	private DBConnection createTestSubject() {
		return new DBConnection();
	}

	@MethodRef(name = "getConnection", signature = "()QConnection;")
	@Test
	public void testGetConnection() throws Exception {
		DBConnection testSubject;
		Connection result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getConnection();
	}

	@MethodRef(name = "dbSelect", signature = "(QString;)QResultSet;")
	@Test
	public void testDbSelect() throws Exception {
		DBConnection testSubject;
		String statementText = "";
		ResultSet result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.dbSelect(statementText);
	}

	@MethodRef(name = "dbUpdate", signature = "(QString;)V")
	@Test
	public void testDbUpdate() throws Exception {
		DBConnection testSubject;
		String statementText = "";

		// default test
		testSubject = createTestSubject();
		testSubject.dbUpdate(statementText);
	}

	@MethodRef(name = "verifUserLogin", signature = "(QString;QString;)Z")
	@Test
	public void testVerifUserLogin() throws Exception {
		DBConnection testSubject;
		String userPseudo = "";
		String userPassword = "";
		boolean result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.verifUserLogin(userPseudo, userPassword);
	}

	@MethodRef(name = "verifUserExists", signature = "(QString;)Z")
	@Test
	public void testVerifUserExists() throws Exception {
		DBConnection testSubject;
		String userPseudo = "";
		boolean result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.verifUserExists(userPseudo);
	}

	@MethodRef(name = "fetchUser", signature = "(QString;)QUser;")
	@Test
	public void testFetchUser() throws Exception {
		DBConnection testSubject;
		String userPseudo = "";
		User result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.fetchUser(userPseudo);
	}

	@MethodRef(name = "fetchPseudo", signature = "(I)QString;")
	@Test
	public void testFetchPseudo() throws Exception {
		DBConnection testSubject;
		int Id = 0;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.fetchPseudo(Id);
	}

	@MethodRef(name = "addUserToDB", signature = "(QString;QString;QString;)V")
	@Test
	public void testAddUserToDB() throws Exception {
		DBConnection testSubject;
		String userPseudo = "";
		String userPassword = "";
		String userIP = "";

		// default test
		testSubject = createTestSubject();
		testSubject.addUserToDB(userPseudo, userPassword, userIP);
	}

	@MethodRef(name = "fetchMessage", signature = "(II)QLinkedList<QMessage;>;")
	@Test
	public void testFetchMessage() throws Exception {
		DBConnection testSubject;
		int user1ID = 0;
		int user2ID = 0;
		LinkedList<Message> result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.fetchMessage(user1ID, user2ID);
	}

	@MethodRef(name = "addMessage", signature = "(IIQjava.sql.Timestamp;QString;)V")
	@Test
	public void testAddMessage() throws Exception {
		DBConnection testSubject;
		int envoyeurID = 0;
		int receveurID = 0;
		Timestamp sqlTimeStamp = null;
		String text = "";

		// default test
		testSubject = createTestSubject();
		testSubject.addMessage(envoyeurID, receveurID, sqlTimeStamp, text);
	}

	@MethodRef(name = "getContactList", signature = "(I)QLinkedList<QContact;>;")
	@Test
	public void testGetContactList() throws Exception {
		DBConnection testSubject;
		int userID = 0;
		LinkedList<Contact> result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getContactList(userID);
	}
}