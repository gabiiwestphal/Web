package com.udesc.iwe.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;

import com.udesc.iwe.exception.CustomAccessDeniedHandler;

@Component
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomAccessDeniedHandler customAccessDeniedHandler;
	
	public WebSecurityConfig(CustomAccessDeniedHandler customAccessDeniedHandler) {
		this.customAccessDeniedHandler = customAccessDeniedHandler;
	}


    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
            .username("user")
            .password(passwordEncoder().encode("password"))
            .roles("USER")
            .build();
        UserDetails admin = User.builder()
            .username("admin")
            .password(passwordEncoder().encode("adminpassword"))
            .roles("ADMIN")
            .build();
        return new InMemoryUserDetailsManager(user, admin);
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .csrf().disable()
            .authorizeRequests()
                .antMatchers("/livros/cadastrar", "/livros/deletar/**", "/livros/atualizar/**", "/usuarios/cadastrar", "/usuarios/buscar/**", "/usuarios/atualizar/**", "/usuarios/deletar/**").hasRole("ADMIN")
                .anyRequest().permitAll()
                .and()
            .formLogin()
                .and()
            .httpBasic()
                .and()
            .exceptionHandling().accessDeniedHandler(customAccessDeniedHandler);
    }


}


