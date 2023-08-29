package com.tester.extent.demo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

/**
 * @author Leslie H C Wang
 * @date 2023/8/18 12:39
 */
public class TestMethod {

    @Test
    public void test1(){
        Assert.assertEquals(1,1);
    }

    @Test
    public void test2(){
        Assert.assertEquals("aaa","aaa");
    }

    @Test
    public void test3(){
        Assert.assertEquals(1,2);
    }

    @Test
    public void logDemo(){
        Reporter.log("这是我们自己写的日志：");
        throw new RuntimeException("这是我自己运行时异常");
    }


}
