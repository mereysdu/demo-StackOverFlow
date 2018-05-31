package kz.h2h.H2H.components.post.comment.repository;

import kz.h2h.H2H.components.post.comment.model.Comment;
import org.springframework.data.repository.CrudRepository;

public interface Comment_repository extends CrudRepository<Comment, Long> {

}
