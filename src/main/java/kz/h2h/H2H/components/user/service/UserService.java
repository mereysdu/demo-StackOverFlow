package kz.h2h.H2H.components.user.service;

import kz.h2h.H2H.components.role.model.UserRole;
import kz.h2h.H2H.components.role.repository.UserRoleRepository;
import kz.h2h.H2H.components.user.model.User;
import kz.h2h.H2H.components.user.repository.User_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private User_repository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long userId){
        return userRepository.findOne(userId);
    }

    public User getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public void saveUser(User user){
        user.setRoles(Arrays.asList(userRoleRepository.findOne(1L)));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

}
