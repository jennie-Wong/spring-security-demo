package com.example.demo.domain;

import javax.persistence.Table;
import java.io.Serializable;
@Table(name = "role_premission")
public class RolePremission implements Serializable {
    private Integer roleId;
    private Integer premissionId;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPremissionId() {
        return premissionId;
    }

    public void setPremissionId(Integer premissionId) {
        this.premissionId = premissionId;
    }
}
