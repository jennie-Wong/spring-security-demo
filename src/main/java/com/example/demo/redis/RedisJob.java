package com.example.demo.redis;

import com.example.demo.domain.SysUser;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author:WANGJING
 * @Date: 2019/12/12 10:33
 */
@Component
@Configurable
@EnableScheduling
public class RedisJob {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private RedisUtil redisUtil;


	//@Scheduled(cron = "0 0/1 * * * ?")

	int i=0;
	@Scheduled(fixedRate = 1000 * 3000)
	public void redisCache(){
		//把所有的user加载进来


		List<SysUser> list=null;
				//userMapper.selectAll();
		redisUtil.setKeyTimes("allUser",list.toString(),10L,TimeUnit.MINUTES);
		System.out.println("=========定时任务执行=========="+i++);
	}

}
