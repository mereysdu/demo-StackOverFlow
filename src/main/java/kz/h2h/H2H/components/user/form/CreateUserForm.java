package kz.h2h.H2H.components.user.form;

import kz.h2h.H2H.components.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserForm {

    @NotNull(message = "Name is required")
    @NotEmpty(message = "Name is required")
    private String name;

    @NotNull(message = "Surname is required")
    @NotEmpty(message = "Surname is required")
    private String surname;

    @NotNull(message = "Phone number is required")
    @NotEmpty(message = "Phone number is required")
    @Pattern(regexp = "[0-9]{11}", message = "Your number should contain only 11 numbers")
    private String number;

//    @NotNull(message = "Please check your gender")
//    private String gender;

    @Length(min=8, message = "Password must contain at least 8 symbols")
    private String password;

    @NotNull(message = "Password confirm is required")
    @NotEmpty(message = "Password confirm is required")
    private String passwordConfirm;

//    @NotNull
//    private User user;

    @Email
    private String email;
}
