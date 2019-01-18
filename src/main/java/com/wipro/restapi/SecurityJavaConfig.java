package com.wipro.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;

@Configuration
@EnableWebSecurity
public class SecurityJavaConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	RestAuthenticationEntryPoint restAuthenticationEntryPoint;
	
	@Autowired
	RequestAwareAuthenticationSuccessHandler authenticationSuccessHandler;
	
	@Autowired
	RequestAwareAuthenticationFailureHandler authenticationFailureHandler;
	
	
	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
	    auth.inMemoryAuthentication()
	        .withUser("admin").password("12345").roles("ADMIN")
	        .and()
	        .withUser("user").password("12345").roles("USER");
	}
	
	

	/*@Autowired
	protected void configureGlobal(final AuthenticationManagerBuilder auth) throws Exception {
	    auth.inMemoryAuthentication()
	        .withUser("admin").password("12345").roles("ADMIN")
	        .and()
	        .withUser("user").password("12345").roles("USER");
	}*/
	
/*	@Bean
	public PasswordEncoder  encoder() {
	    return new BCryptPassowordEncoder();
	}*/
	
	@Override
	protected void configure(HttpSecurity http) throws Exception { 
	    System.out.println("Called configure method");
		http
	    .csrf().disable()
	    .exceptionHandling()//.loginProcessingUrl("/login")
       // .usernameParameter("admin")
        //.passwordParameter("12345")
	    .authenticationEntryPoint(restAuthenticationEntryPoint)
	    .and()
	    .authorizeRequests()
	    //.antMatchers("/api/foos").authenticated()
	    //.antMatchers("/api/admin/**").hasRole("ADMIN")
	    .antMatchers("/customers1/**").hasRole("ADMIN")
	    .and()
	    .formLogin()
	    .successHandler(authenticationSuccessHandler)
	    .failureHandler(authenticationFailureHandler)
	    .and()
	    .logout();
		//http.addFilterAfter(new CsrfTokenResponseHeaderBindingFilter(), CsrfFilter.class);
	}

}
/*
@Component
class DomainAwarePermissionEvaluator implements PermissionEvaluator {

	@Override
	public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
		System.out.println("check permission '{}' for user '{}' for target '{}'" + permission +  authentication.getName()+targetDomainObject);

		
				return hasRole("ROLE_ADMIN", authentication);
		
		//return true;
		//return false;
	}

	@Override
	public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType,
			Object permission) {
		return hasPermission(authentication, new CustomerDetails(), permission);
		//return false;
	}
	
}*/
