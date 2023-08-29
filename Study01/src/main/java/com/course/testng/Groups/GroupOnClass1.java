package com.course.testng.Groups;

import org.testng.annotations.Test;

/**
 * @author Leslie H C Wang
 * @date 2023/8/17 16:27
 */

@Test(groups="student")
public class GroupOnClass1 {
    public void stu1(){
        System.out.println("GroupOnClass1中的stu1运行");
    }

    public void stu2(){
        System.out.println("GroupOnClass1中的stu2运行");
    }
}
