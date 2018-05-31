package kz.h2h.H2H.components.post.web.forms;

import com.sun.istack.internal.Nullable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class PostForm {
    @NonNull
    @NotEmpty
    @Size(max = 50)
    private String title;

    @NotEmpty
    @Size(min = 5, max = 200, message = "Please write more words")
    private String description;

    @Nullable
    private String filename;
}
