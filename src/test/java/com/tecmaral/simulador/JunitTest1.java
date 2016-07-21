package com.tecmaral.simulador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author mgonzalesdi
 * To run the entire unit test (TestApp1 and TestApp2), issue this command :
 * mvn test
 * mvn -Dtest=JunitTest1 test -Djava.net.preferIPv4Stack=true
 * mvn -Dtest=TestApp1 test -Djava.net.preferIPv4Stack=true

   Run to see: 
	@BeforeClass - oneTimeSetUp
	@Before - setUp
	@Test - testEmptyCollection
	@After - tearDown
	@AfterClass - oneTimeTearDown

 */
public class JunitTest1 { 

    @SuppressWarnings("rawtypes")
	private Collection collection;

    @BeforeClass
    public static void oneTimeSetUp() {
        // one-time initialization code   
    	System.out.println("@BeforeClass - oneTimeSetUp");
    }

    @AfterClass
    public static void oneTimeTearDown() {
        // one-time cleanup code
    	System.out.println("@AfterClass - oneTimeTearDown");
    }

    @SuppressWarnings("rawtypes")
	@Before
    public void setUp() {
        collection = new ArrayList();
        System.out.println("@Before - setUp");
    }

    @After
    public void tearDown() {
        collection.clear();
        System.out.println("@After - tearDown");
    }

    @Test
    public void testEmptyCollection() {
        assertTrue(collection.isEmpty());
        System.out.println("@Test - testEmptyCollection");
    }

    @SuppressWarnings("unchecked")
	@Test
    public void testOneItemCollection() {
        collection.add("itemA");
        assertEquals(1, collection.size());
        System.out.println("@Test - testOneItemCollection");
    }
}
