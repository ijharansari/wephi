package com.alfabita.wephi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {
    private static final String LOGIN_URL = "/login";
    private final CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    /*private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;*/
    //permit all url for get method
    String[] getPermittedURL = {
            "/",
            "/css/**",
            "/js/**",
            "/font/**",
            "/image/**",
            "/icon/**",
            "/login/**",
            "/public/**",
            "/resource/**",
            "/fontawesome-free-6.5.1/css/**",
            "/fontawesome-free-6.5.1/webfonts/**",
            "/user/register/**",
            "/user/exists/**",
            "/demo/**",
            "/user/forget/password/**",
            "/user/change/forget/password/**",
            "/payment/return/**"
    };

    //permit all url for post method
    String[] postPermittedURL = {
            "/v1/user/create/**",
            "/v1/user/login/**",
            "/user/register/**",
            "/payment/webhook/**",
            "/form/jotform/webhook/**",
            "/i18n/change/locale/**",
            "/user/forget/password/link/**",
            "/user/forget/password/**",
            "/payment/create-checkout-session/**",
            "/payment/cinet/callback/**"
    };
    String[] putPermittedURL = {
            "/language/change/**"
    };

    String [] apiPostPermittedURL = {
            "/api/v1/auth/login/**",
            "/api/v1/auth/create/**"
    };
    public SecurityConfiguration(CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler) {
        this.customAuthenticationSuccessHandler = customAuthenticationSuccessHandler;
        /*this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;*/
    }

    /*@Bean
    @Order(1)
    SecurityFilterChain apiSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .securityMatcher("/api/**")
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers(apiPostPermittedURL).permitAll();
                    auth.anyRequest().authenticated();
                }).exceptionHandling(ex -> ex.authenticationEntryPoint(jwtAuthenticationEntryPoint))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }*/
    @Bean
    @Order(1)
    public SecurityFilterChain formBaedSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authConfig -> {
                    authConfig.requestMatchers(HttpMethod.GET, getPermittedURL).permitAll();
                    authConfig.requestMatchers(HttpMethod.POST,postPermittedURL).permitAll();
                    authConfig.requestMatchers(HttpMethod.PUT,putPermittedURL).permitAll();
                    authConfig.anyRequest().authenticated();
                })
                .formLogin(form -> form
                        .loginPage(LOGIN_URL)
                        .loginProcessingUrl(LOGIN_URL)
                        .defaultSuccessUrl("/login/success")
                        .successHandler(customAuthenticationSuccessHandler)
                        .usernameParameter("user")
                        .passwordParameter("password")
                )
                .cors(AbstractHttpConfigurer::disable)
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl(LOGIN_URL)
                        .deleteCookies("JSESSIONID")
                );

        return http.build();
    }
}
