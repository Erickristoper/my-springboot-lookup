package com.delsocorro.eurekaclientborrow;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BorrowController {

    private final RestTemplate restTemplate;

    public BorrowController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/borrow/{bookId}")
    public ResponseEntity<String> currentBorrows(@PathVariable String bookId) {
        BookDTO bookDTO = restTemplate.getForObject("http://book-service/book/" + bookId, BookDTO.class);

        return ResponseEntity.ok("Book Borrowed: " + bookDTO.title());
    }
}
