package com.example.gymProject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class WebSecurityConfig {
		
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		return http
				.csrf().disable()
				.authorizeHttpRequests((authz) -> authz
						.requestMatchers("/", "/css/**", "/js/**", "/login", "/newuser","/signup","/loginProc").permitAll()
						.requestMatchers("/userinfo","/main").hasRole("USER")
						.requestMatchers("/admin/**").hasRole("ADMIN")
						.anyRequest().authenticated()
					)
					.formLogin((form) -> form
						.loginPage("/login")
						.loginProcessingUrl("/loginProc")
						.usernameParameter("username")
						.passwordParameter("password")
						.defaultSuccessUrl("/info", true)
						.failureUrl("/login?error=1")
						.permitAll()
					)
					.logout((logout) -> logout
							.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
							.logoutSuccessUrl("/")
							.invalidateHttpSession(true)
							.permitAll())
					.build();
	}	
	
	

}
