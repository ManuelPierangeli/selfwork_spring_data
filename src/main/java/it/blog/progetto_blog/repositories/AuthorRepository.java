package it.blog.progetto_blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import it.blog.progetto_blog.models.Author;

public interface AuthorRepository extends ListCrudRepository<Author, Long> {

    List<Author> findByName(String name);

    List<Author> findByEmail(String email);

    List<Author> findBySurname(String surname);

    List<Author> findByNameAndSurname(String name, String surname);

    // query nativa
    @Query(value = "SELECT * FROM authors a WHERE a.firstname = 'Manuel'", nativeQuery = true)
    List<Author> authorsWithSameName();

    // query non nativa
    @Query("SELECT a FROM Author a WHERE a.name = 'Manuel'")
    List<Author> authorsWithSameNameNonNative();

}