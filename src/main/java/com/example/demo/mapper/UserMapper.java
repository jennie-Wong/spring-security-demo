package com.example.demo.mapper;

import com.example.demo.domain.Premission;
import com.example.demo.domain.SysUser;
import com.example.demo.util.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper extends BaseMapper<SysUser> {

    public SysUser selectByUserName(@Param("userName") String userName);

    List<Premission> findPreMissionByUserName(String userName);



}
