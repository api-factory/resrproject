/*package com.wipro.restapi;
package com.companyname.springbootcrudrest;

import java.io.Serializable;
import java.security.Principal;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.security.web.savedrequest.NullRequestCache;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages ={"com.restExample","com"})
@EnableJpaAuditing
public class SpringBootCrudRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudRestApplication.class, args);
	}
}

@Configuration
@EnableSpringHttpSession
class HttpSessionConfig {

	@Bean
	SessionRepository<ExpiringSession> inmemorySessionRepository() {
		return new MapSessionRepository();
	}

	@Bean
	HttpSessionStrategy httpSessionStrategy() {
		return new HeaderHttpSessionStrategy();
	}
}

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
class SecurityConfig extends GlobalMethodSecurityConfiguration {

	@Autowired
	private DomainAwarePermissionEvaluator permissionEvaluator;

	@Autowired
	private ApplicationContext applicationContext;

	@Override
	protected MethodSecurityExpressionHandler createExpressionHandler() {

		DefaultMethodSecurityExpressionHandler expressionHandler = new DefaultMethodSecurityExpressionHandler();
		expressionHandler.setPermissionEvaluator(permissionEvaluator);
		expressionHandler.setApplicationContext(applicationContext);

		return expressionHandler;
	}
}

@EnableWebSecurity
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests() //
				.anyRequest().authenticated() //
				.and().requestCache().requestCache(new NullRequestCache()) //
				.and().httpBasic() //
				.and().csrf().disable();
	}

	@Autowired
	void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication() //
				.withUser("user").password("password").authorities("ROLE_USER") //
				.and() //
				.withUser("admin").password("password").authorities("ROLE_USER", "ROLE_ADMIN");
	}
}

@Slf4j
@Component
class DomainAwarePermissionEvaluator implements PermissionEvaluator {

	@Override
	public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {

		log.info("check permission '{}' for user '{}' for target '{}'", permission, authentication.getName(),
				targetDomainObject);

		if ("place-order".equals(permission)) {
			Order order = (Order) targetDomainObject;
			if (order.amount > 500) {
				return hasRole("ROLE_ADMIN", authentication);
			}
		}

		return true;
	}

	@Override
	public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType,
			Object permission) {
		return hasPermission(authentication, new DomainObjectReference(targetId, targetType), permission);
	}

	private boolean hasRole(String role, Authentication auth) {

		if (auth == null || auth.getPrincipal() == null) {
			return false;
		}

		Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();

		if (CollectionUtils.isEmpty(authorities)) {
			return false;
		}

		return authorities.stream().filter(ga -> role.equals(ga.getAuthority())).findAny().isPresent();
	}


	static class DomainObjectReference {
		private final Serializable targetId;
		private final String targetType;
		DomainObjectReference(Serializable targetId,String targetType){
		this.targetId = targetId;
		this.targetType= targetType;
			
		}
	}
}

@RequestMapping("/api/auth")
@RestController
class AuthEndpoint {

	@GetMapping
	Map<String, Object> getToken(HttpSession session) {
		return Collections.singletonMap("session", session.getId());
	}
}

@Secured("ROLE_USER")
@RequestMapping("/api/greet")
@RestController
class GreetingEndpoint {

	@GetMapping
	Map<String, Object> greet(@AuthenticationPrincipal Principal user) {

		Map<String, Object> map = new HashMap<>();
		map.put("user", user.getName());
		return map;
	}
}

@Secured("ROLE_USER")
@RequestMapping("/api/order")
@RestController
class OrderEndpoint {

	@PostMapping
	@PreAuthorize("hasPermission(#order, 'place-order')")
	Map<String, Object> placeOrder(Order order) {

		Map<String, Object> map = new HashMap<>();
		map.put("orderId", UUID.randomUUID());
		return map;
	}
}


class Order {
	double amount;
}

@RequestMapping("/api/admin")
@RestController
class AdminEndpoint {

	@GetMapping
	@Secured("ROLE_ADMIN")
	Map<String, Object> manage(@AuthenticationPrincipal Principal user) {
		return Collections.singletonMap("user", user.getName());
	}
	
}
*/