package com.example.gymProject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurity {
//	@Bean
//	public WebSecurityCustomizer webSecurityCustomizer(WebSecurity web) {
//		return web -> web.ignoring().requestMatchers("/html/css");
//	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//	    return httpSecurity
//	        .csrf(csrf -> csrf.disable())
//	        .authorizeHttpRequests(auth -> auth
//	            .requestMatchers("/").permitAll()
//	            .anyRequest().authenticated()
//	        )
//	        .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//	        .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
//	        .httpBasic(Customizer.withDefaults())
//	        .build();
		return httpSecurity
				.authorizeHttpRequests(authco -> authco
						.requestMatchers("/css/**","/js/**").permitAll()
						.requestMatchers("/**").permitAll()

						)
				.build();

	}




}
