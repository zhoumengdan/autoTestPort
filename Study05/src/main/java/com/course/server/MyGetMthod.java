package com.course.server;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Leslie H C Wang
 * @date 2023/8/23 12:32
 */

@RestController
public class MyGetMthod {

    /**
     *获取cookie的get请求方法
     */
    @RequestMapping(value = "/getCookies",method = RequestMethod.GET)
    public String getCookies(HttpServletResponse response){
        //HttpServletRequest 装请求信息的类
        //HttpServletResponse 装响应信息的类
        Cookie cookie = new Cookie("login","true");
        response.addCookie(cookie);
        return "恭喜你返回cookies成功";

    }

    /**
     * 必须携带cookie进行get请求的方法
     */
    @RequestMapping(value = "/get/with/cookies",method = RequestMethod.GET)
    public String getWithCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)) {
            return "需要携带cookie才能访问成功";
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("login") & cookie.getValue().equals("true")) {
                return "恭喜携带cookie访问成功";
            }
        }
        return "需要携带cookie才能访问成功";
    }

    /**
     * 必须携带参数才能请求的get方法
     */
    /**
     * 开发一个需要携带参数才能访问的get请求。
     * 第一种实现方式 url: key=value&key=value
     * 我们来模拟获取商品列表
     */
    @RequestMapping(value = "/get/with/param",method = RequestMethod.GET)
    public Map<String,Integer> getList(@RequestParam Integer start,@RequestParam Integer end){
        Map<String,Integer> myList = new HashMap<>();
        myList.put("鞋",400);
        myList.put("干脆面",1);
        myList.put("衬衫",300);
        return myList;
    }


    /**
     * 第二种需要携带参数访问的get请求
     * url:ip:port/get/with/param/10/20
     */
    @RequestMapping(value = "/get/with/param/{start}/{end}")
    public Map myGetList(@PathVariable Integer start,@PathVariable Integer end){

        Map<String,Integer> myList = new HashMap<>();

        myList.put("鞋",400);
        myList.put("干脆面",1);
        myList.put("衬衫",300);

        return  myList;

    }

}
