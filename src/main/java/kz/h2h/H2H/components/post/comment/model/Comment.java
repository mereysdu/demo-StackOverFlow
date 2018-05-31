package kz.h2h.H2H.components.post.comment.model;

import kz.h2h.H2H.components.post.model.Post;
import kz.h2h.H2H.components.user.model.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="comments")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String text;
    @NonNull
    private LocalDate date;
    @NonNull
    @OneToOne
    private User user;
    @ManyToOne
    @NonNull
    private Post post;
}
