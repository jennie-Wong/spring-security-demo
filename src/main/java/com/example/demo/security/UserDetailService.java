package com.example.demo.security;


import com.example.demo.domain.SysUser;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDetailService implements UserDetailsService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

	//查询数据库密码

		SysUser sysUser = userMapper.selectByUserName(username);
		System.out.println("============这是数据库查询比较的结果==================="+ sysUser);

		List<String> roles=new ArrayList<>();
		//return  CurrentUser.CurrentUserInstance(sysUser,roles);
		return sysUser;
	}
}
