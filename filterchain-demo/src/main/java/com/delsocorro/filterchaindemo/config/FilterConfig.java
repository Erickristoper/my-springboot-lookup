package com.delsocorro.filterchaindemo.config;

import com.delsocorro.filterchaindemo.filter.CustomFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<CustomFilter> customFilter() {
        FilterRegistrationBean<CustomFilter> customFilter = new FilterRegistrationBean<>(new CustomFilter());
        customFilter.addUrlPatterns("/*");
        return customFilter;
    }
}
