package com.tecmaral.simulador;



import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @author mgonzalezdi
 *mvn -Dtest=TestApp1 test -Djava.net.preferIPv
 *
 */
public class TestApp1 {

	@Test
	public void testPrintHelloWorld() {

		Assert.assertEquals(Application.getHelloWorld(), "Hello World");

	}

	@Test
	public void testPrintHelloWorld2() {

		Assert.assertEquals(Application.getHelloWorld2(), "Hello World 2");

	}

}
