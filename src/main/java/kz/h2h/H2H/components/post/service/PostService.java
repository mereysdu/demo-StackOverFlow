package kz.h2h.H2H.components.post.service;

import kz.h2h.H2H.components.post.model.Post;
import kz.h2h.H2H.components.post.repository.PostRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class PostService {
    @NonNull
    private PostRepository postRepository;

    public Iterable<Post> findAll() {
        return postRepository.findAll();
    }

    public Iterable<Post> findModerated() {
        List<Post> posts = (List<Post>) postRepository.findAll();

        return posts.stream().filter(Post::isModerated).collect(Collectors.toList());
    }

    public void save(Post post) {
        postRepository.save(post);
    }

    public Post findById(Long postId) {
        return postRepository.findOne(postId);
    }

    public Iterable<Post> findNonModerated() {
        List<Post> posts = (List<Post>) postRepository.findAll();

        return posts.stream().filter(post -> !post.isModerated()).collect(Collectors.toList());
    }


    public void delete(Post post) {
        postRepository.delete(post);
    }
}
