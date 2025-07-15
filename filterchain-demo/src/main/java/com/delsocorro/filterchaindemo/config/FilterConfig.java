package com.delsocorro.filterchaindemo.config;

import com.delsocorro.filterchaindemo.filter.CustomFilter;
import com.delsocorro.filterchaindemo.filter.IdentifyUserFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class FilterConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.addFilterBefore(
                new IdentifyUserFilter(),
                UsernamePasswordAuthenticationFilter.class
        );

        return http.build();
    }

    @Bean
    public FilterRegistrationBean<CustomFilter> customFilter() {
        FilterRegistrationBean<CustomFilter> customFilter = new FilterRegistrationBean<>(new CustomFilter());
        customFilter.addUrlPatterns("/*");
        return customFilter;
    }
}
