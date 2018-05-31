package kz.h2h.H2H.controller;

import kz.h2h.H2H.components.post.model.Post;
import kz.h2h.H2H.components.post.service.PostService;
import kz.h2h.H2H.components.post.web.forms.PostForm;
import kz.h2h.H2H.components.user.form.CreateUserForm;
import kz.h2h.H2H.components.user.model.User;
import kz.h2h.H2H.components.user.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequiredArgsConstructor
public class MainController {

    private @NonNull
    UserService userService;

    private @NonNull
    PostService postService;

    @GetMapping("/login")
    public String login(Model model){
        CreateUserForm form = new CreateUserForm();
        model.addAttribute("createUserForm", form);

        return "/login";
    }

    @GetMapping("/about")
    public String about() {
        return "/about";
    }

    @GetMapping("/main")
    public String main(Model model) {
        Iterable<Post> posts = postService.findModerated();
        Iterable<Post> unmoderated = postService.findNonModerated();

        model.addAttribute("postForm", new PostForm());
        model.addAttribute("posts", posts);
        model.addAttribute("unmoderatedPosts", unmoderated);

        return "main";
    }

    @PostMapping("/users")
    public String createUser(@Valid CreateUserForm createUserForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "login";
        }

        if (!createUserForm.getPassword().equals(createUserForm.getPasswordConfirm())) {
            model.addAttribute("passwordsMissMatch", "true");
            return "login";
        }

        System.out.println(createUserForm);

        User user = new User(createUserForm.getName(),
                createUserForm.getSurname(),
                createUserForm.getNumber(),
                "",
                createUserForm.getPassword(),
                createUserForm.getEmail());

        userService.saveUser(user);

        model.addAttribute("ok", "You've been succesfully registered");

        System.out.println(userService.getAllUsers());

        return login(model);
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/login";
    }

}
