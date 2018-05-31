package kz.h2h.H2H;

import kz.h2h.H2H.components.role.model.UserRole;
import kz.h2h.H2H.components.role.repository.UserRoleRepository;
import kz.h2h.H2H.components.user.model.User;
import kz.h2h.H2H.components.user.repository.User_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class H2HApplication {

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Bean
	CommandLineRunner commandLineRunner(User_repository user_repository, UserRoleRepository userRoleRepository) {

		UserRole userRole = new UserRole("ROLE_USER", "DESC");
		UserRole userRole1 = new UserRole("ROLE_ADMIN", "DESC");

		userRoleRepository.save(userRole);
		userRoleRepository.save(userRole1);

		List<UserRole> roleList = Arrays.asList(
				userRoleRepository.findByName("ROLE_USER"),
				userRoleRepository.findByName("ROLE_ADMIN"));

		return strings -> {
            String password = encoder.encode("password");
            User user = new User("Aisultan",
					"Yerlanuly",
					"77777777777",
					"male",
					password,
						"aisultan@gmail.com");
            user.setRoles(roleList);
            user_repository.save(user);
        };
	}

	public static void main(String[] args) {
		SpringApplication.run(H2HApplication.class, args);
	}
}
