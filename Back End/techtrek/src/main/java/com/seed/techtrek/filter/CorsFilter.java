package com.seed.techtrek.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpHeaders.*;
import static org.springframework.http.HttpHeaders.ACCESS_CONTROL_MAX_AGE;

@Component
@Order(1)
public class CorsFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        response.addHeader(ACCESS_CONTROL_ALLOW_ORIGIN, "*");
        response.addHeader(ACCESS_CONTROL_ALLOW_METHODS, "GET, POST, DELETE, PUT, PATCH, HEAD");
        response.addHeader(ACCESS_CONTROL_ALLOW_HEADERS, "Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");
        response.addHeader(ACCESS_CONTROL_EXPOSE_HEADERS, "Access-Control-Allow-Origin, Access-Control-Allow-Credentials");
        response.addHeader(ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
        response.addIntHeader(ACCESS_CONTROL_MAX_AGE, 10);
        filterChain.doFilter(request, response);
    }
}
