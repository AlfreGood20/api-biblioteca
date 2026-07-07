package com.api.biblioteca.configurations;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import com.api.biblioteca.exceptions.CustomAccessDeniedHandler;
import com.api.biblioteca.exceptions.CustomAuthenticationEntryPoint;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final AuthenticationProvider authenticationProvider;

    private final CustomAuthenticationEntryPoint authenticationEntryPoint;
    private final CustomAccessDeniedHandler accessDeniedHandler;
    private final FilterJwt filterJwt;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http

            .authorizeHttpRequests(auth -> auth
                .requestMatchers("auth/**").permitAll()
                
                .anyRequest().authenticated()
            )

            .csrf(csrf -> csrf.disable())

            .cors(cors -> cors
                .configurationSource(request -> {
                    CorsConfiguration configuracion = new CorsConfiguration();

                    configuracion.setAllowCredentials(true);
                    configuracion.setAllowedOriginPatterns(Arrays.asList("http://localhost:5173"));
                    configuracion.setAllowedMethods(Arrays.asList("GET","POST","PUT","PATCH","DELETE"));
                    configuracion.setAllowedHeaders(Arrays.asList("*"));

                    return configuracion;
                })
            )

            .authenticationProvider(authenticationProvider)

            .addFilterBefore(filterJwt, UsernamePasswordAuthenticationFilter.class)

            //SIN ESTADO
            .sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )

            .exceptionHandling(exception -> exception
                .accessDeniedHandler(accessDeniedHandler)
                .authenticationEntryPoint(authenticationEntryPoint)
            )

            
            .httpBasic(httpBasic -> httpBasic.disable());

        return http.build();
    }
}
