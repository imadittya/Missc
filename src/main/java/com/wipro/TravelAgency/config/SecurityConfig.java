package com.wipro.TravelAgency.config;

import com.wipro.TravelAgency.exceptionHandler.CustomAuthenticationEntryPoint;
import com.wipro.TravelAgency.filter.JwtFilter;
import com.wipro.TravelAgency.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private JwtFilter jwtFilter;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().requestMatchers("/authFailure");
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)

    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests().requestMatchers("/user/signup","/user/login","/swagger-ui/**")
                .permitAll().anyRequest().authenticated()
                .and().exceptionHandling().authenticationEntryPoint(customAccessDeniedHandler())
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }

    // config for swagger-ui for spring security

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().requestMatchers("/v2/api-docs",
                "/v3/api-docs",
                "/configuration/ui",
                "/swagger-resources/**",
                "/configuration/security",
                "/swagger-ui.html",
                "/webjars/**");
    }

    @Bean
    public CustomAuthenticationEntryPoint customAccessDeniedHandler()
    {
        return new CustomAuthenticationEntryPoint();
    }
}

