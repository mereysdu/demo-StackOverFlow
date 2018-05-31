package kz.h2h.H2H.components.post.repository;

import kz.h2h.H2H.components.post.model.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long>{

        public Post getById(Long id);

        @Query("select post from Post post where post.text like %:text%")
        public List<Post> findPostByTextLike(@Param("text") String text);

}
