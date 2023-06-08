package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SpringSecurityConfig {

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		// TODO Auto-generated method stub
//		super.configure(http);
//		http.csrf().disable();
//		http.formLogin().disable();
//	}
	
//	@Bean
//	public UserDetailsService userDetailsService() {
//		// ok for demo
//		org.springframework.security.core.userdetails.User.UserBuilder users = org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder();
//
//		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//		manager.createUser(users.username("user").password("password").roles("role1").build());
//		manager.createUser(users.username("admin").password("password").roles("role2").build());
//		return manager;
//	}
	
	@Bean
	public InMemoryUserDetailsManager userDetailsManager(){
		UserDetails john = User.builder().username("john").password("{noop}Test123").roles("Employee").build();
		UserDetails marry = User.builder().username("marry").password("{noop}Test123").roles("Employee","Manager").build();
		UserDetails susan = User.builder().username("susan").password("{noop}Test123").roles("Employee","Manager", "Admin").build();
		return new InMemoryUserDetailsManager(john, marry, susan);
		
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(configure -> configure.antMatchers(HttpMethod.GET, "/todos").hasRole("Employee").antMatchers(HttpMethod.POST, "/todos").hasRole("Manager"));
		http.httpBasic(Customizer.withDefaults());
		http.csrf(csrf->csrf.disable());
		return http.build();
	
	}
	
}