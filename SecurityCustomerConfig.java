package com.example.finalprojecbackend.config;

import com.example.finalprojecbackend.service.MyCustomerDetailsService;
import com.example.finalprojecbackend.service.MyMerchantDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityCustomerConfig extends WebSecurityConfigurerAdapter {

    private final MyCustomerDetailsService mycustomerDetailsService;
    private final MyMerchantDetailsService mymerchentDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(mycustomerDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
//    @Override
///    protected void configure(AuthenticationManagerBuilder auh) throws Exception {
////        auh.userDetailsService(mymerchentDetailsService).passwordEncoder(new BCryptPasswordEncoder());
////    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/v1/auth2/register/**","/api/v1/auth/register/**","/api/v1/auth2/login/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }
}