package kz.h2h.H2H.components.post.web.controller;

import kz.h2h.H2H.components.post.model.Post;
import kz.h2h.H2H.components.post.service.PostService;
import kz.h2h.H2H.components.post.web.forms.PostForm;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/moderation")
public class ModerationController {

    @NonNull
    private PostService postService;

    @GetMapping("/posts/{postId}")
    public String moderate(@PathVariable("postId") Long postId, @RequestParam("action") String action, Model model) {
        System.out.println(action + " PRO");
        Post post = postService.findById(postId);
        if (action.equals("accept")) {
            System.out.println("ACCEPT");
            post.setModerated(true);
            postService.save(post);
        } else {
            postService.delete(post);
            System.out.println("DECLIEN");
        }

        return "redirect:/main";
    }
}
