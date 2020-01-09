package com.gonnect.spring.security.authorization.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class PersonSecurityConfigurer extends WebSecurityConfigurerAdapter {

    // Create 2 users with role
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}password").roles("USER")
                .and()
                .withUser("admin").password("{noop}password").roles("USER", "ADMIN");

    }

    // NOTE: above roles & users can be loaded from DB
    /*@Bean
    public UserDetailsService userDetailsService() {
        //ok for demo
        User.UserBuilder users = User.withDefaultPasswordEncoder();

        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(users.username("user").password("password").roles("USER").build());
        manager.createUser(users.username("admin").password("password").roles("USER", "ADMIN").build());
        return manager;
    }*/

    // secure the endpoint with HTTP Basic authentication
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                //HTTP Basic authentication
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/persons/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/persons").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/persons/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PATCH, "/persons/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/persons/**").hasRole("ADMIN")
                .and()
                .csrf().disable()
                .formLogin().disable();
    }


}
