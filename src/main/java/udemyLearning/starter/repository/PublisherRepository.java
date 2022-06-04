package udemyLearning.starter.repository;

import org.springframework.data.repository.CrudRepository;
import udemyLearning.starter.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {

}
