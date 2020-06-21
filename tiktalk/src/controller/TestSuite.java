package controller;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(

{ ServerThreadTest.class, InitialServerTest.class, DBConnectionTest.class, FirstServerTest.class,
		MainControllerCTest.class, MainControllerSTest.class, SimpleClientTest.class })
public class TestSuite { // nothing
}
