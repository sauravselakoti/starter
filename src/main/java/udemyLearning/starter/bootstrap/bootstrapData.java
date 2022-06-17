package udemyLearning.starter.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import udemyLearning.starter.domain.Author;
import udemyLearning.starter.domain.Book;
import udemyLearning.starter.domain.Publisher;
import udemyLearning.starter.repository.AuthorRepository;
import udemyLearning.starter.repository.BookRepository;
import udemyLearning.starter.repository.PublisherRepository;

@Component
public class bootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;
    public bootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository=publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric= new Author("Eric","Evans");
        Book b= new Book("Domain Driven Design","1234");
        Publisher thomson=new Publisher("Thomson Publishers");
        eric.getBooks().add(b);
        b.getAuthors().add(eric);
        b.setPublisher(thomson);
        thomson.getBooks().add(b);

        authorRepository.save(eric);
        bookRepository.save(b);
        publisherRepository.save(thomson);

        Author rod =new Author("Rod","Johnson");
        Book j2EE= new Book("J2EE Development","1231");
        Publisher JavaPub= new Publisher("Java Publications");
        rod.getBooks().add(j2EE);
        j2EE.getAuthors().add(rod);
        j2EE.setPublisher(JavaPub);
        JavaPub.getBooks().add(j2EE);

        authorRepository.save(rod);
        bookRepository.save(j2EE);
        publisherRepository.save(JavaPub);

        System.out.println("Started in Bootstrap...");
        System.out.println("Number of authors: "+authorRepository.count());
        System.out.println("Number of books: "+bookRepository.count());
        System.out.println("Number of publishers:"+publisherRepository.count());
    }
}
