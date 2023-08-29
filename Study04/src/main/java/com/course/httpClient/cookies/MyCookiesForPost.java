package com.course.httpClient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Leslie H C Wang
 * @date 2023/8/22 15:28
 */
public class MyCookiesForPost {
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
        String testUrl;
        testUrl = url+bundle.getString("getCookies.uri");

        cookieStore = new BasicCookieStore();

        HttpGet get = new HttpGet(testUrl);
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
    public void testPostWithCookies() throws IOException {
        //拼接测试url
        String testUrl = url+bundle.getString("postWithCookies.uri");

        //创建post请求对象
        HttpPost post = new HttpPost(testUrl);

        //设置请求头信息
        post.setHeader("content-type","application/json");

        //给请求参数
        JSONObject param = new JSONObject();
        param.put("name","zhaoliu");
        param.put("sex", "woman");
        //将参数信息放到请求方法里
        StringEntity entity = new StringEntity(param.toString());
        post.setEntity(entity);

        //给cookies信息
        CloseableHttpClient client = HttpClientBuilder.create().setDefaultCookieStore(this.cookieStore).build();

        //执行post请求
        HttpResponse response = client.execute(post);

        //获得请求结果实体
        String result = EntityUtils.toString(response.getEntity());
        System.out.println(result);

        //判断结果是否符合预期
        JSONObject resultJson = new JSONObject(result);
        //获取json字段的结果值
        String success = resultJson.getString("zhaoliu");
        String status = resultJson.getString("status");
        //对比预期结果
        Assert.assertEquals("success",success);
        Assert.assertEquals("1",status);

    }

}
