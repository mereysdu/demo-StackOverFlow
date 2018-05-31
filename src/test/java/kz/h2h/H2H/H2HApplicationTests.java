package kz.h2h.H2H;

import kz.h2h.H2H.components.post.model.Post;
import kz.h2h.H2H.components.post.repository.PostRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class H2HApplicationTests{
	@Autowired
	private TestEntityManager testEntityManager;


	@Autowired
	private PostRepository postRepository;

	@Test
	public void whenFindByName_thenReturnPosts(){
		// given
		Post post = new Post();
		post.setText("Wakanda Test!");
		testEntityManager.persist(post);
		testEntityManager.flush();

		// when
		List<Post> postsFound = postRepository.findPostByTextLike("Wakanda Test!");

		// then
		assertNotNull(postsFound);
		assertEquals(1, postsFound.size());
		assertTrue(postsFound.get(0).getText().equals("Wakanda Test!"));
	}
}
