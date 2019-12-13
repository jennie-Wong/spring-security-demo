package com.example.demo.service;

import com.example.demo.domain.SysUser;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
     SysUser selectByUserName(String userName);
}
