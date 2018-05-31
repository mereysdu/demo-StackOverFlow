package kz.h2h.H2H.components.post.model;


import kz.h2h.H2H.components.post.comment.model.Comment;
import kz.h2h.H2H.components.user.model.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String title;

    @NonNull
    private String text;

    @NonNull
    private LocalDate date;
    @NonNull
    @OneToOne
    private User user;

    @OneToMany
    @NonNull
    private List<Comment> comments;

    public void setText(String text){
        this.text = text;
    }

    public String getText(){
        return  this.text;
    }

    public void setComments(List<Comment> comments){
        this.comments = comments;
    }

    public List<Comment> getCommets(){
        return this.comments;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return  this.title;
    }

    public void setUser(User user){
        this.user = user;
    }

    public User getUser(){
        return this.user;
    }

    public void setDate(LocalDate date){
        this.date = date;
    }

    public LocalDate getDate(){
        return  this.date;
    }

    private boolean isModerated = false;

}
