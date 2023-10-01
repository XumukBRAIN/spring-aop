package ru.ikudryashov.springaop.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ikudryashov.springaop.entities.Book;
import ru.ikudryashov.springaop.repositories.BookRepository;
import ru.ikudryashov.springaop.utils.CustomResponse;
import ru.ikudryashov.springaop.utils.CustomStatus;

import java.util.Collection;
import java.util.Collections;
import java.util.NoSuchElementException;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookService {
    private final BookRepository repository;

    public CustomResponse<Book> getAll() {
        Collection<Book> books;
        try {
            log.info("Попытка получить все книги");
            books = repository.findAll();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new CustomResponse<>(Collections.emptyList(), CustomStatus.EXCEPTION);
        }

        log.info("Все книги получены");
        return new CustomResponse<>(books, CustomStatus.SUCCESS);
    }

    public CustomResponse<Book> getBookByTitle(String title) {
        Book book;
        try {
            log.info("Попытка получить книгу с названием " + title);
            book = repository.findBoolByTitle(title)
                    .orElseThrow();
        } catch (NoSuchElementException e) {
            log.error(e.getMessage(), e);
            return new CustomResponse<>(Collections.emptyList(), CustomStatus.NOT_FOUND);
        }

        log.info("Книга с названнием {} получена", title);
        return new CustomResponse<>(Collections.singletonList(book), CustomStatus.SUCCESS);
    }

    public CustomResponse<Book> addBook(Book book) {
        Book newBook = repository.save(book);
        return new CustomResponse<>(Collections.singletonList(newBook), CustomStatus.SUCCESS);
    }
}
