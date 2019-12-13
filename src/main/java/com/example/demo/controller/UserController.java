package com.example.demo.controller;

import com.example.demo.domain.SysUser;
import com.example.demo.mapper.UserMapper;
import com.example.demo.redis.RedisUtil;
import com.example.demo.service.impl.UserServiceImpl;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {

	private final static Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired(required = true)
	private UserServiceImpl userServiceImpl;

	@Autowired
	private RedisUtil redisUtil;



	@GetMapping("add")
	public String registerUser() {
		SysUser sysUser =new SysUser();

		sysUser.setPassword("123456");
		sysUser.setAccountnonexpired(false);
		sysUser.setAccountnonexpired(false);
		//加密密码
		String newPwd = passwordEncoder.encode(sysUser.getPassword());

		sysUser.setPassword(newPwd);
		int result = userMapper.insertSelective(sysUser);
		if (result >= 1) {
			logger.info("添加用户成功");
		}
		return "success";
	}


	@GetMapping("/findByName")
	public SysUser selectByUserName(@RequestParam("userName") String userName) {
		SysUser sysUser = userServiceImpl.selectByUserName(userName);

		return sysUser;
	}


	@PostMapping("/findAll")
	public String selectAll() {
		//SysUser sysUser = userServiceImpl.selectByUserName(userName);

		String allUser =redisUtil.getValue("allUser");
		return allUser;
	}




}
