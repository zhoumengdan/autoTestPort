package com.test.example;

import java.util.Scanner;

/**
 * @author Leslie H C Wang
 * @date 2023/8/28 10:08
 */
public class TeatString {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        //去除字符穿甲中的空格
        String str = "jfdskl dsfja dsfja   dsfjakf a ";
        String newstr = str.replace(" ","");
        System.out.println(newstr);

        //分解http地址
        String strurl = "http://work.dahuatech.com:7076/share/index.html?shareVideoId=-721509&playType=1";

        String[] strArr = strurl.split("\\?");
        String[] uri = strArr[0].split("://|:");
        String port = uri[2].substring(0,4);
        String path = uri[2].substring(4);

        String[] param = strArr[1].split("&");
        String[] param1 = param[0].split("=");
        String[] param2 = param[1].split("=");
        System.out.println("{‘协议’：’"+uri[0]+"','域名'：‘"+uri[1]+"','端口'：'"+port+"','路径'：'"+path+"','"+param1[0]+"':'"+param1[1]+"','"+param2[0]+"':'"+param2[1]+"'}");
        StringBuilder stringBuilder = new StringBuilder();

    }
}
