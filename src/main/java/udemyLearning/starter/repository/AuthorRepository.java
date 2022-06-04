package udemyLearning.starter.repository;

import org.springframework.data.repository.CrudRepository;
import udemyLearning.starter.domain.Author;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
