/**
 * 控制器类，用于处理客户端的 HTTP 请求。
 * 该类被标记为 @RestController，表示它是一个 REST 风格的控制器，
 * 其中的方法返回值会直接写入 HTTP 响应体（通常是 JSON 或纯文本），
 * 而不是跳转到视图模板。
 */

package com.example.helloworld.controller;

import org.springframework.web.bind.annotation.*;

@RestController  //类变成了控制器就可以去接受客户端的请求了
public class HelloController {

    //http://www.baidu.com/s/xx   协议:http，域名:www.baidu.com，路径:/s/xx
    //http://localhost:8080/hello  协议:http，域名:localhost，端口:8080，路径：/hello
    //@GetMapping("/hello")  //浏览器等会回发送get请求来访问这个方法,链接地址是"/hello"

    //http://localhost:8080/hello？nickname=zhangsan&phone=123456
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(@RequestParam(value = "nickname",required = false) String name, String phone){
        System.out.println(phone);  //在终端输出
        return "hello world 你好"+name+phone;  //在网页显示
    }
}
