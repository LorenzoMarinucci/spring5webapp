package spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import spring5webapp.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
