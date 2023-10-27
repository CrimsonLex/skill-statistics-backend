package com.backend.skillstatisticsbackend.config;

import com.backend.skillstatisticsbackend.model.AuthToken;
import com.backend.skillstatisticsbackend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {
    @Autowired
    private AuthService authService;

    @Autowired
    @Qualifier("HandlerExceptionResolver")
    private HandlerExceptionResolver resolver;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try{
            String authorizationHeader= request.getHeader(HttpHeaders.AUTHORIZATION);
            if(!StringUtils.hasText(authorizationHeader)){
                filterChain.doFilter(request,response);
                return;
            }

            String token = authorizationHeader.trim();
            AuthToken validated = authService.validateToken(token);
            if




        }catch (Exception e){

        }
    }
}
