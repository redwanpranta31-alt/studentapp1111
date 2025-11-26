 package com.luv2code.studentapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

 @Configuration
public class SecurityConfig {
/*
     @Bean
     public BCryptPasswordEncoder passwordEncoder(){
         return new BCryptPasswordEncoder();

     }

     @Bean
     public DaoAuthenticationProvider authenticationProvider(StudentService studentService){

         DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
         auth.setUserDetailsService(studentService);
         auth.setPasswordEncoder(passwordEncoder());
         return auth;
     }*/

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){

        UserDetails redwan = User.builder()
                .username("redwan")
                .password("{noop}redwan1234")
                .roles("STUDENT")
                .build();

        UserDetails karim = User.builder()
                .username("karim")
                .password("{noop}karim1234")
                .roles("TEACHER")
                .build();

return new InMemoryUserDetailsManager(redwan,karim);

    }
   @Bean

    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET,"/allstudent").hasRole("STUDENT")
                        .requestMatchers(HttpMethod.GET,"/allstudent/**").hasRole("STUDENT")
                        .requestMatchers(HttpMethod.GET,"/allteacher").hasRole("TEACHER")
                        .requestMatchers(HttpMethod.GET,"/allteacher/**").hasRole("TEACHER")
                        .requestMatchers(HttpMethod.POST,"/allteacher").hasRole("TEACHER")












        );
        http.httpBasic(Customizer.withDefaults());

        http.csrf(csrf->csrf.disable());
return http.build();

    }

}
