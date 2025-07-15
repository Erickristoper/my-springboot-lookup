package com.delsocorro.filterchaindemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilterDemoController {

    @GetMapping("/hello-filter-demo")
    public String hello() {
        return "This demo go to a demo filter chain. A log displays the request and response details";
    }
}
