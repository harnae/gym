package com.example.gymProject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
//@EnableWebSecurity
public class WebSecurity {
//	@Bean
//	public WebSecurityCustomizer webSecurityCustomizer(WebSecurity web) {
//		return web -> web.ignoring().requestMatchers("/html/css");
//	}

	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
	    return httpSecurity
	        .csrf(csrf -> csrf.disable())
	        .authorizeHttpRequests(auth -> auth
	            .requestMatchers("/").permitAll()
	            .anyRequest().authenticated()
	        )
	        .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
	        .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
	        .httpBasic(Customizer.withDefaults())
	        .build();
	}
}
