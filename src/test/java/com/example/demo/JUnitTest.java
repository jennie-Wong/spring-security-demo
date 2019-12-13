package com.example.demo;


import com.example.demo.domain.SysUser;
import com.example.demo.mapper.UserMapper;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@WebAppConfiguration
public class JUnitTest {

    @Autowired
    private UserMapper userMapper;


    @Test
    public void test() {
        SysUser sysUser = userMapper.selectByUserName("cc");
        System.out.println(sysUser);
    }
}




