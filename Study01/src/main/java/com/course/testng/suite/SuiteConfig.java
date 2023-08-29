package com.course.testng.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

/**
 * @author Leslie H C Wang
 * @date 2023/8/17 14:30
 */
public class SuiteConfig {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuite执行啦");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite执行啦");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("beforeTest");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("afterTest");
    }
}
