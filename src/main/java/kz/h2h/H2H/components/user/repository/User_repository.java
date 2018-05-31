package kz.h2h.H2H.components.user.repository;

import kz.h2h.H2H.components.user.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface User_repository extends CrudRepository<User, Long>{
    List<User> findAll();
    User findByEmail(String email);
}
