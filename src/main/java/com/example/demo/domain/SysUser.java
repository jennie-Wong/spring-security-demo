package com.example.demo.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysUser implements  Serializable,UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String username;
	private String password;
	@Column(name = "create_date")
	private Date createDate;
	private boolean accountnonexpired;
	private boolean accountnonlocked;
	private boolean credentialsnonexpired;
	private boolean enabled;

	@Transient
	private List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", createDate=" + createDate +
				", accountNonExpired=" + credentialsnonexpired +
				", accountNonLocked=" + accountnonlocked +
				", credentialsNonExpired=" + credentialsnonexpired +
				", enabled=" + enabled +
				", authorities=" + authorities +
				'}';
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public boolean isAccountnonexpired() {
		return accountnonexpired;
	}

	public void setAccountnonexpired(boolean accountnonexpired) {
		this.accountnonexpired = accountnonexpired;
	}

	public boolean isAccountnonlocked() {
		return accountnonlocked;
	}

	public void setAccountnonlocked(boolean accountnonlocked) {
		this.accountnonlocked = accountnonlocked;
	}

	public boolean isCredentialsnonexpired() {
		return credentialsnonexpired;
	}

	public void setCredentialsnonexpired(boolean credentialsnonexpired) {
		this.credentialsnonexpired = credentialsnonexpired;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public List<GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
}
