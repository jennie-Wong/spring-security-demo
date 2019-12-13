package com.example.demo.domain;

import javax.persistence.Table;
import java.io.Serializable;
@Table(name = "sys_user_role")
public class UserRole implements Serializable {
    private  Integer userId;
    private Integer roleId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
