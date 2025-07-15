package com.delsocorro.filterchaindemo.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class IdentifyUserFilter extends OncePerRequestFilter {
    private static final Logger log = LoggerFactory.getLogger(IdentifyUserFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        long startTime = System.currentTimeMillis();

        // modify later when jwt authentication is available.
        request.setAttribute("user", "DUMMY_USER");

        filterChain.doFilter(request, response);

        long endTime = System.currentTimeMillis() - startTime;
        log.info("Elapsed time: {} ms", endTime);
    }
}
