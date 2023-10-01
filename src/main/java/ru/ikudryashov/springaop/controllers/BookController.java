package ru.ikudryashov.springaop.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.ikudryashov.springaop.entities.Book;
import ru.ikudryashov.springaop.services.BookService;
import ru.ikudryashov.springaop.utils.CustomResponse;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BookController {

    private final BookService service;

    @GetMapping("/books")
    public CustomResponse<Book> getAll() {
        return service.getAll();
    }

    @GetMapping("/books/{title}")
    public CustomResponse<Book> getBookByTitle(@PathVariable String title) {
        return service.getBookByTitle(title);
    }

    @PostMapping("/books")
    public CustomResponse<Book> addBool(@RequestBody Book book) {
        return service.addBook(book);
    }
}
