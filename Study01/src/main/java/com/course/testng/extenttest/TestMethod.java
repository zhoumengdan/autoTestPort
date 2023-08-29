package com.course.testng.extenttest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

/**
 * @author Leslie H C Wang
 * @date 2023/8/20 13:03
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
        Assert.assertEquals(1,3);
    }

    @Test
    public void logDemo(){
        Reporter.log("这是我自己的日志");
        throw new RuntimeException("这是我自己抛出的异常");
    }
}
