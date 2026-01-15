package com.example.Employee.config;

import org.springframework.security.config.Customizer;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

 @Bean      
 public UserDetailsManager users(DataSource dataSource) {
     return new JdbcUserDetailsManager(dataSource);
 }

  @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {    
        http.csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> {
                auth.requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE");
                auth.requestMatchers(HttpMethod.PATCH, "/api/employees/**").hasRole("MANAGER");
                auth.requestMatchers(HttpMethod.POST, "/api/employees/**").hasRole("MANAGER");
                auth.requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("MANAGER");
                auth.anyRequest().authenticated();
            })
            .httpBasic(Customizer.withDefaults());  
        return http.build();
    }

}