package kz.h2h.H2H.components.post.comment.forms;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class CommentForm {
    @NotEmpty
    private String text;
}
