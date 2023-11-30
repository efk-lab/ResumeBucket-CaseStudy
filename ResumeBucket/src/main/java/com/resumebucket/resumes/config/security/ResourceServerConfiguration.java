package com.resumebucket.resumes.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

import com.resumebucket.resumes.constant.Role;
import com.resumebucket.resumes.error.ResumeBucketAccessDeniedHandler;
import com.resumebucket.resumes.error.ResumeBucketAuthenticationEntryPoint;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
	
	private final ResumeBucketAuthenticationEntryPoint resumeBucketAuthenticationEntryPoint;
	
	private final String RESOURCE_SERVER_RESOURCE_ID = "resumeBucketApi";

	public ResourceServerConfiguration(ResumeBucketAuthenticationEntryPoint resumeBucketAuthenticationEntryPoint) {
		this.resumeBucketAuthenticationEntryPoint = resumeBucketAuthenticationEntryPoint;
	}

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.resourceId(RESOURCE_SERVER_RESOURCE_ID);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.antMatcher("/resumebucket/**").authorizeRequests()
				.antMatchers("/resumebucket/registry/sign-up").permitAll()
				.antMatchers("/resumebucket/resume/registry").hasAuthority(Role.USER.name())
				.antMatchers("/resumebucket/resume/details").hasAnyAuthority(Role.ADMIN.name(), Role.USER.name())
				.antMatchers("/resumebucket/resume/contact").hasAuthority(Role.USER.name())
				.antMatchers("/resumebucket/resume/summary").hasAuthority(Role.USER.name())
				.antMatchers("/resumebucket/resume/experiences").hasAuthority(Role.USER.name())
				.antMatchers("/resumebucket/resume/educations").hasAuthority(Role.USER.name())
				.antMatchers("/resumebucket/resume/certificates").hasAuthority(Role.USER.name())
				.antMatchers("/resumebucket/resume/skills").hasAuthority(Role.USER.name())
				.antMatchers("/resumebucket/resume/awards").hasAuthority(Role.USER.name())
				.antMatchers("/resumebucket/resume/languages").hasAuthority(Role.USER.name())
				.antMatchers("/resumebucket/resume/interests").hasAuthority(Role.USER.name())
				.antMatchers("/resumebucket/resume/removal").hasAnyAuthority(Role.ADMIN.name(), Role.USER.name())
				.antMatchers("/resumebucket/resume/search").hasAnyAuthority(Role.ADMIN.name(), Role.USER.name())
				.antMatchers("/resumebucket/statistics/where-they-live").hasAnyAuthority(Role.ADMIN.name(), Role.USER.name())
				.antMatchers("/resumebucket/statistics/where-they-study").hasAnyAuthority(Role.ADMIN.name(), Role.USER.name())
				.antMatchers("/resumebucket/**").authenticated().anyRequest().authenticated().and().exceptionHandling()
				.authenticationEntryPoint(resumeBucketAuthenticationEntryPoint)
				.accessDeniedHandler(new ResumeBucketAccessDeniedHandler());

	}
}
