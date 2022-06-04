package udemyLearning.starter.repository;

import org.springframework.data.repository.CrudRepository;
import udemyLearning.starter.domain.Book;

public interface BookRepository extends CrudRepository<Book,Long> {
}
