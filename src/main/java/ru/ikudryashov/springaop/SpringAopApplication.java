package ru.ikudryashov.springaop;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.ikudryashov.springaop.entities.Book;
import ru.ikudryashov.springaop.repositories.BookRepository;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringAopApplication implements CommandLineRunner {
	private final BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringAopApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Book book1 = new Book("Война и мир", "Лев Николаевич Толстой");
		Book book2 = new Book("Капитанская дочка", "Александр Сергеевич Пушкин");

		bookRepository.save(book1);
		bookRepository.save(book2);
	}
}
