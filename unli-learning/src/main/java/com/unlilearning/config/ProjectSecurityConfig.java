package com.unlilearning.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests((authz) -> authz.anyRequest().permitAll());
//		http.formLogin().and().httpBasic();
		http.authorizeRequests()
		.mvcMatchers("/home").permitAll()
		.mvcMatchers("/dashboard").authenticated()
		.antMatchers("/login").permitAll()
		.anyRequest().authenticated()
		.and().formLogin()
		.loginPage("/login")
		.defaultSuccessUrl("/dashboard")
		.failureUrl("/login?error=true").permitAll()
		.and()
		.logout().logoutSuccessUrl("/login?logout=true").invalidateHttpSession(true)
		.permitAll()
		.and().httpBasic();

		return http.build();

	}

	@Bean
	public InMemoryUserDetailsManager inMemory() {
		UserDetails user = User.withDefaultPasswordEncoder().username("hubert").password("hubert").roles("ADMIN")
				.build();

		return new InMemoryUserDetailsManager(user);
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
	return authenticationConfiguration.getAuthenticationManager();
	}
//	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
}
