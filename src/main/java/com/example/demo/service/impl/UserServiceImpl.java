package com.example.demo.service.impl;

import com.example.demo.domain.SysUser;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    
    @Override
    public SysUser selectByUserName(String userName) {
        SysUser sysUser = userMapper.selectByUserName(userName);
        return sysUser;
    }
}
