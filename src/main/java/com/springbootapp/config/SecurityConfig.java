package com.springbootapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = false, jsr250Enabled = false)
public class SecurityConfig {

    public SecurityConfig(){
        System.out.println("sss");
    }

    private static final String[] WHITE_LIST_URL = {
            "/**",
            "/auth/**",
            "/v3/api-docs/**",
            "/v3/api-docs.yaml",
            "/swagger-ui/**",
            "/swagger-ui.html",
            "/error",
    };

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .cors(cors -> cors.disable())
                .formLogin(login -> login.disable())
                .logout(logout -> logout.disable())
                .httpBasic(httpBasic -> httpBasic.disable())
                .anonymous(anonyms -> anonyms.disable())
                .headers(headers -> headers.httpStrictTransportSecurity(HeadersConfigurer.HstsConfig::disable))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                        .requestMatchers(WHITE_LIST_URL).permitAll()
                        .anyRequest().authenticated())
                .sessionManagement(ssmgt -> ssmgt.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();
    }
}
