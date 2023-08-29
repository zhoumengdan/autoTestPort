package com.course.httpClient.demo;

import com.sun.org.apache.xpath.internal.functions.FuncUnparsedEntityURI;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author Leslie H C Wang
 * @date 2023/8/21 13:54
 */
public class MyHttpClient {

    @Test
    public void test1() throws IOException {
        //建一个get方法请求地址
        HttpGet get = new HttpGet("http://baidu.com");
        //建一个默认client
        HttpClient client = HttpClients.createDefault();
        //执行get请求，得到响应结果
        HttpResponse response = client.execute(get);
        //得到响应的实体结果
        String result = EntityUtils.toString(response.getEntity());
        System.out.println(result);
    }
}
