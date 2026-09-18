package it.blog.progetto_blog;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase.Replace;

import it.blog.progetto_blog.models.Author;
import it.blog.progetto_blog.repositories.AuthorRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class ProgettoBlogApplicationTests {

	@Autowired
	AuthorRepository authorRepository;

	@BeforeEach
	void load() {
		Author a1 = new Author();
		a1.setName("Manuel");
		a1.setSurname("Pierangeli");
		a1.setEmail("manuel@test.it");
		authorRepository.save(a1);
	}

	@Test
	void contextLoads() {
	}

	@Test
	void findByName() {
		assertThat(authorRepository.findByName("Manuel"))
				.extracting("name")
				.containsOnly("Manuel");
	}

	@Test 
	void sameNameNative() {
		assertThat(authorRepository.authorsWithSameName())
				.extracting("name")
				.containsOnly("Manuel");
	}

	@Test 
	void sameNameAuthourNonNative() {
		assertThat(authorRepository.authorsWithSameNameNonNative())
				.extracting("name")
				.containsOnly("Manuel");
	}

}
