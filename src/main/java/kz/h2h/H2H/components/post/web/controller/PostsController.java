package kz.h2h.H2H.components.post.web.controller;

import kz.h2h.H2H.components.post.comment.forms.CommentForm;
import kz.h2h.H2H.components.post.comment.model.Comment;
import kz.h2h.H2H.components.post.comment.repository.Comment_repository;
import kz.h2h.H2H.components.post.model.Post;
import kz.h2h.H2H.components.post.service.PostService;
import kz.h2h.H2H.components.post.web.forms.PostForm;
import kz.h2h.H2H.components.user.model.User;
import kz.h2h.H2H.components.user.service.UserService;
import kz.h2h.H2H.security.SecurityService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class PostsController {

    @NonNull
    private SecurityService securityService;

    @NonNull
    private UserService userService;
git
    @NonNull
    private PostService postService;

    @NonNull
    private Comment_repository comment_repository;

    @PostMapping("/main")
    public String addPost(@Valid PostForm postForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            System.out.println(postForm.getDescription() + " " + postForm.getTitle() + " " + postForm.getFilename());
            System.out.println("ERROR");
            return "main";
        }

        User current = userService.getUserByEmail(securityService.findLoggedInUsername());

        System.out.println(current);

        Post post = new Post(postForm.getTitle(),
                postForm.getDescription(),
                LocalDate.now(), current, Collections.emptyList());

        postService.save(post);

        return "redirect:/main";
    }

    @GetMapping("/posts/{postId}")
    public String postDetail(@PathVariable("postId") Long postId, Model model) {
        Post post = postService.findById(postId);

        model.addAttribute("post", post);
        model.addAttribute("commentForm", new CommentForm());

        return "request";
    }

    @PostMapping("/posts/{postId}/comments")
    public String addComment(@Valid CommentForm commentForm, @PathVariable("postId") Long postId, BindingResult bindingResult, Model model) {
        Post post = postService.findById(postId);

        User current = userService.getUserByEmail(securityService.findLoggedInUsername());

        Comment comment = new Comment(commentForm.getText(), LocalDate.now(), current, post);

        post.getComments().add(comment);

        comment_repository.save(comment);
        postService.save(post);

        return "redirect:/posts/" + postId;
    }
}
