package com.pokemonreview.api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    //private JwtRequestFilter jwtRequestFilter;

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        //JWTGenerator jwtGenerator = new JWTGenerator();
        //String hardcodedToken = jwtGenerator.generateHardcodedToken("MateiCozac");
        //System.out.println("Token is: " + hardcodedToken);
        http
                .csrf().disable()
                //.addFilterBefore(new JWTAuthenticationFilter("/api/**", jwtGenerator), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .antMatchers("/api/auth/**").permitAll()
                                .antMatchers("/api/public/**").permitAll()
                                .antMatchers("/api/pokemons/**").permitAll()
                                .antMatchers("/api/pokemon/**").permitAll()
                                .anyRequest().authenticated()
                )
                .sessionManagement(sessionManagement ->
                        sessionManagement
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .httpBasic();


        return http.build();
    }
}
