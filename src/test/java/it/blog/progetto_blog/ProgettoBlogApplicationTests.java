package it.blog.progetto_blog;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase.Replace;

import it.blog.progetto_blog.models.Author;
import it.blog.progetto_blog.models.Post;
import it.blog.progetto_blog.repositories.AuthorRepository;
import it.blog.progetto_blog.repositories.PostRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class ProgettoBlogApplicationTests {

	@Autowired
	AuthorRepository authorRepository;

	@Autowired 
	PostRepository postRepository;

	@BeforeEach
	void load() {
		Author a1 = new Author();
		a1.setName("Manuel");
		a1.setSurname("Pierangeli");
		a1.setEmail("manuel@test.it");
		authorRepository.save(a1);

		Post p1 = new Post();
		p1.setTitle("Titolo");
		p1.setBody("Corpo 1");
		p1.setAuthor(a1);

		postRepository.save(p1);
		
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

	@Test 
	void checkAuthor(){
		System.out.println("Check author test");
		assertThat(postRepository.findAll())
		.extracting(Post::getAuthor)
		.extracting(Author::getName)
		.containsOnly("Manuel");
	}

	@Test 
	void deletePost(){
		System.out.println("Delete post test");
		Iterable<Post> posts = postRepository.findAll();
		Post p = posts.iterator().next();
		postRepository.delete(p);

	}
	
}
