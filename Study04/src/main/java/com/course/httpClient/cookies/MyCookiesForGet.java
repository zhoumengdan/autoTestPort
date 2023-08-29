package com.course.httpClient.cookies;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.*;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Leslie H C Wang
 * @date 2023/8/22 10:11
 */
public class MyCookiesForGet {

    private ResourceBundle bundle;
    private String url;
    private CookieStore cookieStore;

    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");
    }

    @Test
    public void testGetCookies() throws IOException {
        //从配置文件中拼接url
        String uri;
        uri = url+bundle.getString("getCookies.uri");

        cookieStore = new BasicCookieStore();

        HttpGet get = new HttpGet(uri);
        CloseableHttpClient client = HttpClientBuilder.create().setDefaultCookieStore(cookieStore).build();
        HttpResponse response = client.execute(get);
        String result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);


        //获取cookies信息
        List<Cookie> cookieList = cookieStore.getCookies();
        for (Cookie cookie:cookieList) {
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie:name="+name+";  value="+value);
        }

    }

    @Test(dependsOnMethods = "testGetCookies")
    public void testGetWithCookies() throws IOException {
        String uri = url+bundle.getString("getWithCookies.uri");

        HttpGet get  = new HttpGet(uri);


        CloseableHttpClient client = HttpClientBuilder.create().setDefaultCookieStore(cookieStore).build();

        HttpResponse response = client.execute(get);
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println(statusCode);
        if(statusCode == 200){
            String result = EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(result);
        }


    }



}
