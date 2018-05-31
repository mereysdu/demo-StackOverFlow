package kz.h2h.H2H.components.user.service;

import kz.h2h.H2H.components.role.model.UserRole;
import kz.h2h.H2H.components.user.model.User;
import kz.h2h.H2H.components.user.repository.User_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private User_repository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);

        if(user == null){
            throw new UsernameNotFoundException("user not found");
        }

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        if(user != null && user.getRoles() != null){
            for (UserRole role : user.getRoles()){
                grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
            }
        }

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), grantedAuthorities);
    }
}