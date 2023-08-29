package com.course.testng.Groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

/**
 * @author Leslie H C Wang
 * @date 2023/8/17 15:47
 */
public class GroupOnMethod {

    @Test(groups="server")
    public void test1(){
        System.out.println("这是服务端组的测试方法1111");
    }

    @Test(groups="server")
    public void test2(){
        System.out.println("这是服务端组的测试方法2222");
    }

    @Test(groups="client")
    public void test3(){
        System.out.println("这是客户端组的测试方法3333");
    }

    @Test(groups="client")
    public void test4(){
        System.out.println("这是客户端组的测试方法4444");
    }

    @BeforeGroups(groups="server")
    public void beforeGroupsOnServer(){
        System.out.println("在服务端组运行之前运行的方法");
    }

    @AfterGroups(groups="server")
    public void afterGroupsOnServer(){
        System.out.println("在服务端组运行之后运行的方法");
    }

    @BeforeGroups(groups="client")
    public void beforeGroupsOnClient(){
        System.out.println("在客户端组运行之前运行的方法");
    }

    @AfterGroups(groups="client")
    public void afterGroupsOnClient(){
        System.out.println("在客户端组运行之后运行的方法");
    }


}
