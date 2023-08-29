package com.course.testng.Groups;

import org.testng.annotations.Test;

/**
 * @author Leslie H C Wang
 * @date 2023/8/17 16:28
 */

@Test(groups="teacher")
public class GroupOnClass3 {
    public void teac1(){
        System.out.println("GroupOnClass3中的teac1运行");
    }

    public void teac2(){
        System.out.println("GroupOnClass3中的teac2运行");
    }
}
