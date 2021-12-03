package com.nttdata.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecutiryConfig extends WebSecurityConfigurerAdapter{

	
	
	@Autowired
	UserDetailsService usd;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers("/registro","/","/usuario/registrar","/producto","/categoria","/home").permitAll()
		.anyRequest().authenticated()//css/**, js/**, //registro	
		
			.and()
		.formLogin()
			.defaultSuccessUrl("/home",true)
			.loginPage("/login")
			.permitAll()
			.usernameParameter("email").passwordParameter("password")
			.and().csrf().disable()
		//.logout()
			//.permitAll()
		
		;

		
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptpasswordEncoder() {
	return new BCryptPasswordEncoder();
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usd).passwordEncoder(bCryptpasswordEncoder());
	}
	
	
}
