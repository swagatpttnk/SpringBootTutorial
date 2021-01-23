package com.boot.poc.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${demo.security.user.name}")
    String username ;

    @Value("${demo.security.user.password}")
    String password;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        System.out.printf("Username/password:%s / %s \n ",username,password);
        auth.inMemoryAuthentication().withUser(username)
                .password(password).roles("USER");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
//        http
//                //HTTP Basic authentication
//                .httpBasic()
//                .and()
//                .authorizeRequests()
//                .antMatchers( "/swagger-ui**").permitAll()
//                .antMatchers("/versioning**").hasRole("USER")
//                .anyRequest().authenticated()
//                .and()
//                .csrf().disable()
//                .formLogin().disable();
        http.authorizeRequests()
                .antMatchers("/swagger-ui**").permitAll()
                .antMatchers("/versioning/**").hasRole("USER")
                .and().httpBasic();

    }

}