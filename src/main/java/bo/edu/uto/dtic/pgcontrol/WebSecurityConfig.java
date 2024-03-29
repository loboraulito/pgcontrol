package bo.edu.uto.dtic.pgcontrol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Autowired
	private CustomUserDetailService userDetailService;

	@Bean
	public static PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/error"
						,"/"
						, "/principal/home"
						, "/assets/**"
						, "/static/favicon.ico"
						, "/enlaces/renderMenu"
						, "/prueba/index").permitAll()
				.anyRequest().authenticated()
			)
			.formLogin((form) -> form
				.loginPage("/seguridad/login")
				.permitAll()
				.defaultSuccessUrl("/principal/index")
				.loginProcessingUrl("/login")
				.failureUrl("/seguridad/login?error=true")
				.permitAll()
			)
			.logout((logout) -> logout
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.permitAll()
			);
		return http.build();
	}

	public void configure(AuthenticationManagerBuilder builder) throws Exception{
		builder.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
	}
}
