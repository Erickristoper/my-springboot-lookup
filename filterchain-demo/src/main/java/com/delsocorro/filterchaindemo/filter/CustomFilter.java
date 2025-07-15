package com.delsocorro.filterchaindemo.filter;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class CustomFilter implements Filter {
    private static final Logger log = LoggerFactory.getLogger(CustomFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        log.info("Request URI: " + request.getRequestURI());
        log.info("Request Method: " + request.getMethod());

        filterChain.doFilter(servletRequest, servletResponse);

        log.info("Response URI: " + request.getRequestURI());
    }

}
