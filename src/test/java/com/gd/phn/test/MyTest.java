package com.gd.phn.test;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class MyTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MyTest ( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( MyTest .class );
    }

    /**
     * Rigourous Test :-)
     */
	public void testMethod()
    {
		assertTrue( true );
//由于test部分找不到配置文件因此需要重新加载配置文件
    /* ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:conf/spring-mybatis-shiro.xml"});*/
	/*	userService = (UserService) context.getBean("userServiceImpl");*/
        
    }
}
