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
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

 @Configuration
public class SecurityConfig {

     @Bean
     public BCryptPasswordEncoder passwordEncoder(){
         return new BCryptPasswordEncoder();

     }

     @Bean
     public DaoAuthenticationProvider authenticationProvider(UserDetailsService userDetailsService){

         DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
         auth.setUserDetailsService(userDetailsService);
         auth.setPasswordEncoder(passwordEncoder());
         return auth;
     }

   @Bean

    public SecurityFilterChain filterChain(HttpSecurity http, DaoAuthenticationProvider authProvider) throws Exception{
       http.authenticationProvider(authProvider);

        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/register").permitAll()
                        .requestMatchers(HttpMethod.POST,"/register").permitAll()
                        .requestMatchers(HttpMethod.GET,"/allstudent").hasRole("STUDENT")
                        .requestMatchers(HttpMethod.GET,"/allstudent/**").hasRole("STUDENT")
                        .requestMatchers(HttpMethod.GET,"/allteacher").hasRole("TEACHER")
                        .requestMatchers(HttpMethod.GET,"/allteacher/**").hasRole("TEACHER")
                        .requestMatchers(HttpMethod.POST,"/allteacher").hasRole("TEACHER")


.anyRequest().authenticated()










        );
        http.httpBasic(Customizer.withDefaults());

        http.csrf(csrf->csrf.disable());
return http.build();

    }

}
