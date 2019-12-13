package com.example.demo.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailService userDetailsService;

	@Autowired
	private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.antMatchers("/add").permitAll()
				.antMatchers("/oauth/**").permitAll()

				//.antMatchers("/swagger-ui.html","/webjars/**","/v2/**","/swagger-resources/**").permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/login").permitAll()
				.and().logout().permitAll()
				.and().csrf().disable()
		//.httpBasic()
		;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                //.passwordEncoder(passwordEncoder)
//                .withUser("admin")// 管理员，同事具有 ADMIN,USER权限，可以访问所有资源
//                .password(passwordEncoder.encode("admin"))
//                .authorities("ALL");

		auth
				.userDetailsService(userDetailsService)
				.passwordEncoder(passwordEncoder);
    }


	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring(). antMatchers("/swagger-ui.html")
				.antMatchers("/webjars/**")
				.antMatchers("/v2/**")
				.antMatchers("/swagger-resources/**");
	}


	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		AuthenticationManager manager = super.authenticationManagerBean();
		return manager;
	}

}
