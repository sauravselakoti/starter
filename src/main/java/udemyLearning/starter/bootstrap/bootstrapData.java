package udemyLearning.starter.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import udemyLearning.starter.domain.Author;
import udemyLearning.starter.domain.Book;
import udemyLearning.starter.repository.AuthorRepository;
import udemyLearning.starter.repository.BookRepository;

@Component
public class bootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public bootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric= new Author("Eric","Evans");
        Book b= new Book("Domain Driven Design","1234");
        eric.getBooks().add(b);
        b.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(b);

        Author rod =new Author("Rod","Johnson");
        Book j2EE= new Book("J2EE Development","1231");
        rod.getBooks().add(j2EE);
        j2EE.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(j2EE);

        System.out.println("Started in Bootstrap...");
        System.out.println("Number of books: "+bookRepository.count());
    }
}
