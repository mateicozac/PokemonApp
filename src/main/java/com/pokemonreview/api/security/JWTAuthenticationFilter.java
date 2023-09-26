//package com.pokemonreview.api.security;
//
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
//import javax.servlet.FilterChain;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.ArrayList;
//
//public class JWTAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
//
//    private JWTGenerator jwtGenerator;
//
//    public JWTAuthenticationFilter(String defaultFilterProcessesUrl, JWTGenerator jwtGenerator) {
//        super(defaultFilterProcessesUrl);
//        this.jwtGenerator = jwtGenerator;
//    }
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
//        String header = request.getHeader("Authorization");
//
//        if (header == null || !header.startsWith("Bearer ")) {
//            throw new RuntimeException("JWT Token is missing");
//        }
//
//        String authenticationToken = header.substring(7);
//
//        if (jwtGenerator.validateToken(authenticationToken)) {
//            String username = jwtGenerator.getUsernameFromJWT(authenticationToken);
//            return new UsernamePasswordAuthenticationToken(username, null, new ArrayList<>());
//        }
//
//        throw new RuntimeException("JWT Token is incorrect");
//    }
//
//    @Override
//    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) {
//        SecurityContextHolder.getContext().setAuthentication(authResult);
//    }
//}
