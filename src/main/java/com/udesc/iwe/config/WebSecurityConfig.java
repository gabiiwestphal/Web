package com.udesc.iwe.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
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
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.udesc.iwe.exception.CustomAccessDeniedHandler;

@Component
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomAccessDeniedHandler customAccessDeniedHandler;
	
	@Value("${frontend.url}")
	private String frontendUrl;
	
	public WebSecurityConfig(CustomAccessDeniedHandler customAccessDeniedHandler) {
		this.customAccessDeniedHandler = customAccessDeniedHandler;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		super.configure(auth);
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
        .cors().and().csrf().disable()
            .authorizeRequests()            .antMatchers("/**").permitAll()
                .antMatchers("/livros/cadastrar", "/livros/deletar/**", "/livros/atualizar/**", "/usuarios/cadastrar", "/usuarios/buscar/**", "/usuarios/atualizar/**", "/usuarios/deletar/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
            .formLogin()
            .loginPage(frontendUrl + "/users/login")
            .permitAll()
                .and()
            .httpBasic()
                .and()
            .exceptionHandling().accessDeniedHandler(customAccessDeniedHandler);
    }
    
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin(frontendUrl); // Permitir solicitações de todas as origens
        configuration.addAllowedMethod("*"); // Permitir todos os métodos HTTP
        configuration.addAllowedHeader("*"); // Permitir todos os cabeçalhos
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source; 
    }

}


