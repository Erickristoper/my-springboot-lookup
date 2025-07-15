package com.delsocorro.eurekaclientbook;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @GetMapping("book/{id}")
    public BookDTO getBook(@PathVariable Long id) {
        return new BookDTO(id, "Crime and Punishment", "Dostoyevsky");
    }
}
