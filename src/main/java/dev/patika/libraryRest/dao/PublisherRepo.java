package dev.patika.libraryRest.dao;

import dev.patika.libraryRest.entities.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepo extends JpaRepository<Publisher, Integer> {
}
