package com.wang;

import com.wang.sevice.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ImauSpringbootDemoApplicationTests {

    @Autowired
    Hello hello;

    @Autowired
    UserServiceImpl userService;

    @Test
    void contextLoads(){
        userService.addUser("丁真","123456");
    }

    @Test
    void test(){

    }
}
