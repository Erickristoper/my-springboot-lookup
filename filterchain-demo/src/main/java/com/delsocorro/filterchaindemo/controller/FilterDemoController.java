package com.delsocorro.filterchaindemo.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilterDemoController {

    @GetMapping("/hello-filter-demo")
    public String hello() {
        return "This demo go to a demo filter chain. A log displays the request and response details";
    }

    @GetMapping("/OncePerRequestFilter")
    public ResponseEntity<String> OncePerRequestFilter(@RequestAttribute("user") String user) {
        return
            ResponseEntity.ok().body("Hello " + user + "!");

    }

    @GetMapping("/OncePerRequestFilterSlow")
    public ResponseEntity<String> OncePerRequestFilterSlow(@RequestAttribute("user") String user) throws InterruptedException {
        Thread.sleep(5000);
        return ResponseEntity.ok().body("Hello " + user + "!");
    }
}
